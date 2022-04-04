package Objects;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class Manager{
    int emp_no;
    String dept_no;
    Date from_date;
    Date to_date;

    Manager(int emp_no,String dept_no,Date from_date,Date to_date){
        this.emp_no = emp_no;
        this.dept_no = dept_no;
        this.from_date = from_date;
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
        return "{" +
                "emp_no=" + emp_no + '\'' +
                ", dept_no =" + dept_no + ", from_date=" + from_date + '\'' + ", to_date=" + to_date + '\''+
                '}';
    }

    public static void main(String[] args) {
        ArrayList<Manager> man = new ArrayList<>();
        try {
            String url="jdbc:mysql://localhost:3306/employees",user="root",password="Naman@code22";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,password);
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery("Select * from dept_manager");
            while (rs.next()){
                man.add(new Manager(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4)));
            }
            con.close();
            System.out.println(man+"\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
