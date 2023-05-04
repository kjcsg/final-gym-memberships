public class Member {
    public String fname;
    public String lname;
    public int id;
    public int jyear;
    public double charge;
    public int age;

    Member(int id, String fname, String lname, int age, int jyear, double charge){
       this.id = id;
       this.fname = fname;
       this.lname = lname;
       this.age = age;
       this.jyear = jyear;
       this.charge = charge;
    }
}
