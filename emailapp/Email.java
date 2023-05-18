package emailapp;

import java.util.ArrayList;
import java.util.Random;

enum Empldept {
    sales,
    development,
    accounting
}

class Employee {
    private String firstname;
    private String lastname;
    private Empldept dept;
    private String password;
    private String email;

    public Employee(String firstname, String lastname, Empldept dept) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dept = dept;
        setEmail(firstname, lastname, dept);
        setPassword();


    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String firstname, String lastname, Empldept branch) {
        this.email = firstname + lastname + '.' + branch + "@ gmail.com";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {

        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        this.password = String.format("%06d", number);
    }

    public Empldept getDept() {
        return dept;
    }

    public void setDept(Empldept dept) {
        this.dept = dept;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void register(Employee empl)
    {
        
    }

}

class EmplDataBase
{
    private ArrayList<Employee>data=new ArrayList<Employee>();

    public ArrayList<Employee> getData() {
        return data;
    }

    public void adddData(Employee data) {
        this.data.add(data);
    }
}


public class Email {
public static void main(String[] args) {
    EmplDataBase d1= new EmplDataBase();
    Employee e1 = new Employee("Azariush", "Hussain", Empldept.development);
    d1.adddData(e1);
    // System.out.print("Auto generated email :- ");
    // System.out.println(e1.getEmail());
    // System.out.print("Auto generated password :- ");
    // System.out.println(e1.getPassword());
    
}
}
