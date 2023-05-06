import java.util.*;

public class Database {
    HashMap<Integer, Member> db = new HashMap<>(); //Setup database
    String[] names;

    public void add(Member member){ //Add member to database
        db.put(member.id, member);
    }

    public Member find(int id){ //Find member from id number and return member object
        return db.get(id);
    }

    private String[] namesList(){
        names = new String[db.size()];
        int i=0;
        for(Map.Entry<Integer, Member> member : db.entrySet()){
            names[i]=member.getValue().lname;
            i++;
        }
        return names;
    }

    private void swap(int apos, int bpos){ //Making a function to swap array items for sorting
        String temp=names[apos]; //Store the first value in a temp variable
        names[apos]=names[bpos]; //Set the first value to the the second value
        names[bpos]=temp; //Set the second value to the first value that was stored in temp
    }

    private int analyze(String[] names, int uno, int dos){ //Ascending sort
        String pivot=names[dos]; //Get value of item at mid point of arry
        int cpos=uno-1; //Set current change position tracker to start - 1
        int check=uno; //Set starting check point

        for(;check<dos;check++){ //Set up initial for loop with current position tracker
            if(names[check].compareToIgnoreCase(pivot) < 0){ //Increment change position and run value swap if checked value is less than pivot value
                cpos++;
                swap(cpos,check);
            }
        }
        swap(cpos+1,dos); //Swap pivot value and value 1 spot greater than last changed spot
        return (cpos+1); //Return the last changed spot, the pivot value, for further sorting if needed
    }

    private String[] quickSort(String[] names, int uno, int dos){ //Callable function for ascending sort
        if(uno<dos){
            int cpos=analyze(names,uno,dos); //Do the sort and get the returned value current position tracker for further sorting
            quickSort(names,uno,cpos-1); //Sort anything to the left in the array, until done
            quickSort(names,cpos+1,dos); //Sort anything to the right in the array, until done
        }
        return names; //Send ascending sorted array back
    }

    public void NamesString(){ //Convert array of names to plain text, human readable string and print it out
        namesList(); //Run the names list function to get all the last names from the hashmap
        quickSort(names, 0, names.length-1); //Run the quick sort function to sort the last names
        String out = ""; //Set up the output string 
        for(String name : names){ //Fill out the output string with the sorted last names
            if("".equals(out)){out+=names[0];}
            else{out+=", "+name;}
        }
        System.out.println("Here is the list of members last names, sorted alphabetically.");
        System.out.println(out);
    }
}
