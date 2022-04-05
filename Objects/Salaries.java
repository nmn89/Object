package Objects;
import java.sql.*;
import java.util.Date;
import java.util.HashSet;

public class Salaries {
    private int emp_no;
    private int salary;
    private Date from_date;
    private Date to_date;

    public Salaries(int emp_no, int salary, Date from_date, Date to_date){
        this.emp_no = emp_no;
        this.salary = salary;
        this.from_date = from_date;
        this.to_date = to_date;
    }
    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }
    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }
    public int getEmp_no() {
        return emp_no;
    }
    public int getSalary() {
        return salary;
    }
    public Date getFrom_date() {
        return from_date;
    }
    public Date getTo_date() {
        return to_date;
    }
    @Override
    public String toString() {
        return "{" + "Employee_no.: " + emp_no + ", Salary: " + salary + 
        ", From_date: " + from_date + ", To_date: " + to_date + "}" + "\n";
    }

    public static void main(String[] args) {
        HashSet<Salaries> sal = new HashSet<>();
        String url="jdbc:mysql://localhost:3306/employees",user="root",password="Naman@code22";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,password);
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery("Select * from salaries");
            while (rs.next()){
                sal.add(new Salaries(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4)));
            }
            con.close();
            System.out.println(sal);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}