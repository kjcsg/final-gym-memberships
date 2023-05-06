import java.util.*;
import java.io.*;

public class Main {
    private static Database db = new Database(); //Create instance of database class

    public static void main(String[] args){
        buildDB(); //Build up the database
        db.namesString(); //Sort and print last names from db
        findMember(); //Find a certain member by member ID number
    }

    private static void buildDB() { //Build up the database
        String fname;
        String lname;
        int id;
        int jyear;
        double charge;
        int age;

        try {
            File list = new File("GymMembers.txt");
            Scanner scan = new Scanner(list).useDelimiter(",|\r\n");
            scan.nextLine(); //Skip the header line

            while(scan.hasNext()) {
                id = scan.nextInt();
                fname = scan.next();
                lname = scan.next();
                jyear = scan.nextInt();
                charge = scan.nextDouble();
                age = scan.nextInt();
                Member member = new Member(id, fname, lname, age, jyear, charge); //Make each member object
                db.add(member); //Add each member object
            }
            scan.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("No file found.");
        }
    }

    private static void findMember() { //Find a member by ID number and print out their info
        Member member = db.find(1400); //Find member by ID in the database
        System.out.println("\nMember ID: " + member.id);
        System.out.println("Member Name: " + member.fname + " " + member.lname);
        System.out.println("Member Age: " + member.age);
        System.out.println("Member Join Year: " + member.jyear);
        System.out.println("Member Dues: " + member.charge + "\n");
    }
}