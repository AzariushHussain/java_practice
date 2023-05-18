package schoolFinanceManagement;

import java.util.ArrayList;;

class Student
{
    //Fees of each student for a month is Rs. 5000 
    //12 months in a year represent one session here 
    private int monthsFeesPaidTill;
    private String name;
    private int std;


    public Student(String name,int monthsFeesPaidTill,int std) {
        setMonthsFeesPaidTill(monthsFeesPaidTill);
        setName(name);
        setStd(std);
    }

    public int getStd()
    {
        return std;
    }
    public void setStd(int std)
    {
        this.std=std;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getMonthsFeesPaidTill() {
        return monthsFeesPaidTill;
    }
    public void setMonthsFeesPaidTill(int monthsFeesPaidTill) {
        this.monthsFeesPaidTill = monthsFeesPaidTill;
    } 

}


class Teacher
{
    private String name;
    private int salary;
    private int monthsSalaryPaidTill;

    public Teacher(String name, int salary, int monthsSalaryPaidTill) {
        setName(name);
        setSalary(salary);
        setMonthsSalaryPaidTill(monthsSalaryPaidTill);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getMonthsSalaryPaidTill() {
        return monthsSalaryPaidTill;
    }
    public void setMonthsSalaryPaidTill(int monthsSalaryPaidTill) {
        this.monthsSalaryPaidTill = monthsSalaryPaidTill;
    }
}


class School
{
    
    private ArrayList<Student>students=new ArrayList<Student>();
    private ArrayList<Teacher>teachers=new ArrayList<Teacher>();
    private int totalIncome=0;
    private int totalExpense=0;
    private int netProfit;

    public int getNetProfit() {
        return netProfit;
    }


    public void setNetProfit() {
        this.netProfit = totalIncome-totalExpense;
    }


    public int getTotalIncome() {
        return totalIncome;
    }


    public int getTotalExpense() {
        return totalExpense;
    }


    public void setTotalIncome() {
        
        for (Student student : students) {
            this.totalIncome=this.totalIncome+(student.getMonthsFeesPaidTill()*5000);
        }
       
    }


    public void setTotalExpense() {
       

        for (Teacher teacher : teachers) {

            this.totalExpense=this.totalExpense+(teacher.getSalary()*teacher.getMonthsSalaryPaidTill());
            
        }
    }


    public void addTeacher(Teacher teacher)
    {
        this.teachers.add(teacher);
    }


    public void addStudent(Student student)
    {
        this.students.add(student);
    }

    

}

public class schoolFinanceManagement {
    
    public static void main(String[] args) {
        Student s1 = new Student("Azariush", 4, 12);
        Student s2 = new Student("Hussain", 4, 12);
        Student s3 = new Student("Rashal", 4, 12);

        Teacher t1 = new Teacher("Dungdung", 10000, 4);
        School s= new School();

        s.addStudent(s1);
        s.addStudent(s2);
        s.addStudent(s3);
        s.addTeacher(t1);
        s.setTotalIncome();
        s.setTotalExpense();
        s.setNetProfit();
        System.out.println("********** School's financial status **********");
        System.out.println();
        System.out.println("\t\tTotal Income : - "+s.getTotalIncome());
        System.out.println("\t\tTotal Expense :- "+s.getTotalExpense());
        System.out.println("\t\tReserve :- Rs."+s.getNetProfit());
    }
}
