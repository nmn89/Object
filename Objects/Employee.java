package Objects;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class Employee{
    private int emp_no;
    private Date birth_date;
    private String first_name;
    private String last_name;
    private String gender;
    private Date hire_date;

    public Employee(int emp_no,Date birth_date,String first_name,String last_name,String gender,Date hire_date){
        this.emp_no = emp_no;
        this.birth_date = birth_date;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.hire_date = hire_date;
    }
    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }
    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }
    public int getEmp_no() {
        return emp_no;
    }
    public Date getBirth_date() {
        return birth_date;
    }
    public String getFirst_name() {
        return first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public String getGender() {
        return gender;
    }
    public Date getHire_date() {
        return hire_date;
    }
    
    @Override
    public String toString() {
        return "{" +
                "emp_no = " + emp_no + ", " + ", birth_date = " + birth_date + ", first_name = " + first_name  + 
                ", last_name = " + last_name  + ", gender = " + gender  + ", hire_date = " + hire_date + '}' + "\n";
    }

    public static void main(String[] args) {
        ArrayList<Employee> emp = new ArrayList<>();
        try {
            String url="jdbc:mysql://localhost:3306/employees",user="root",password="Naman@code22";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,password);
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery("Select * from employees");
            while (rs.next()){
                Employee g = new Employee(rs.getInt(1),rs.getDate(2),rs.getString(3),
                rs.getString(4),rs.getString(5),rs.getDate(6));
                emp.add(g);
            }
            con.close();
            System.out.println(emp+"\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}