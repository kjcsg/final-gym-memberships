import java.util.*;

public class Database {
    HashMap<Integer, Member> db = new HashMap<>(); //Setup database

    public void add(Member member){ //Add member to database
        int id = member.id;
        db.put(id, member);
    }

    public Member find(int id){ //Find member from id number and return member object
        Member member = db.get(id);
        return member;
    }

    private Array qs(){

    }

    public String NamesString(){
        
    }
}
