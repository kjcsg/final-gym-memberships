import java.util.*;

public class Database {
    HashMap<Integer, Member> db = new HashMap<>(); //Setup database

    public void add(Member member){ //Add member to database
        db.put(member.id, member);
    }

    public Member find(int id){ //Find member from id number and return member object
        return db.get(id);
    }

    private String[] qs(){
        String[] names = new String[db.size()];
        for(int i=0; i<db.size(); i++){
            names[i]=db.get(i).lname;
        }
        return names;
    }

    public String NamesString(String[] arr){ //Convert array of names to comma separated names list
        arr = qs();
        String out = arr[0];
        for(String name : arr){
            out+=", "+name;
        }
        return out;
    }
}
