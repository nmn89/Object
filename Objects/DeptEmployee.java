package Objects;
import java.util.*;
import java.util.Date;
import java.sql.*;

public class DeptEmployee {
    private int emp_no;
    private String dept_no;
    private Date from_date;
    private Date to_date;

    public DeptEmployee(int emp_no, String dept_no, Date from_date, Date to_date){
        this.emp_no = emp_no;
        this.dept_no = dept_no;
        this.from_date = from_date;
        this.to_date = to_date;
    }
    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }
    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
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
    public String getDept_no() {
        return dept_no;
    }
    public Date getFrom_date() {
        return from_date;
    }
    public Date getTo_date() {
        return to_date;
    }
    @Override
    public String toString() {
        return "{" + "Employee_no. = " + emp_no +", " + "Department_no. = " + dept_no + ", " + 
        "From_date = " + from_date + ", " + "To_date" + to_date + "}" + "\n";
    }

    public static void main(String[] args) {
        ArrayList<DeptEmployee> dept_emp = new ArrayList<>();
        String url="jdbc:mysql://localhost:3306/employees",user="root",password="Naman@code22";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,password);
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery("Select * from dept_emp");
            while (rs.next()){
                dept_emp.add(new DeptEmployee(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4)));
            }
            con.close();
            System.out.println(dept_emp+"\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
