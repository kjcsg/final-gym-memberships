import java.util.*;

public class Database {
    HashMap<Integer, Member> db = new HashMap<>(); //Setup database
    Member[] memArray;

    public void add(Member member){ //Add member to database
        db.put(member.id, member);
    }

    public Member find(int id){ //Find member from id number and return member object
        return db.get(id);
    }

    private void swap(int apos, int bpos){ //Making a function to swap array items for sorting
        Member temp=memArray[apos]; //Store the first value in a temp variable
        memArray[apos]=memArray[bpos]; //Set the first value to the the second value
        memArray[bpos]=temp; //Set the second value to the first value that was stored in temp
    }

    private int analyze(Member[] memArray, int uno, int dos){ //Alphabetical sort of last names
        String pivot=memArray[dos].lname; //Get value of item at mid point of arry
        int cpos=uno-1; //Set current change position tracker to start - 1
        int check=uno; //Set starting check point

        for(;check<dos;check++){ //Set up initial for loop with current position tracker
            if(memArray[check].lname.compareToIgnoreCase(pivot) < 0){ //Increment change position and run value swap if checked value is less than pivot value
                cpos++;
                swap(cpos,check);
            }
        }
        swap(cpos+1,dos); //Swap pivot value and value 1 spot greater than last changed spot
        return (cpos+1); //Return the last changed spot, the pivot value, for further sorting if needed
    }

    private void quickSort(Member[] memArray, int uno, int dos){ //Callable function for ascending sort
        if(uno<dos){
            int cpos=analyze(memArray,uno,dos); //Do the sort and get the returned value current position tracker for further sorting
            quickSort(memArray,uno,cpos-1); //Sort anything to the left in the array, until done
            quickSort(memArray,cpos+1,dos); //Sort anything to the right in the array, until done
        }
    }

    public void namesString(){ //Convert array of member info to plain text, human readable string of names and print it out
        memArray = new Member[db.size()]; //Initialize the array
        int i=0;
        for(Map.Entry<Integer, Member> member : db.entrySet()){ //Fill the array
            memArray[i]=member.getValue();
            i++;
        }
        
        quickSort(memArray, 0, memArray.length-1); //Run the quick sort function to sort the members by last names
        String out = ""; //Set up the output string 
        for(Member member : memArray){ //Fill out the output string with the sorted last names
            if("".equals(out)){out += member.fname + " " + member.lname;} //If it's the first, don't put a comma in front of it
            else{out += ", " + member.fname + " " + member.lname;} //Otherwise, put a comma in front to separate the names
        }
        System.out.println("\nHere is the list of members, sorted alphabetically by last name."); //Print the names out
        System.out.println(out);
    }
}
