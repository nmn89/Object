package Objects;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class Titles {
    private int emp_no;
    private String title;
    private Date from_date;
    private Date to_date;

    public Titles(int emp_no, String title, Date from_date, Date to_date){
        this.emp_no = emp_no;
        this.title = title;
        this.from_date = from_date;
        this.to_date = to_date;
    }
    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }
    public void setTitle(String title) {
        this.title = title;
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
    public String getTitle() {
        return title;
    }
    public Date getFrom_date() {
        return from_date;
    }
    public Date getTo_date() {
        return to_date;
    }
    @Override
    public String toString() {
        return "{" + "Employee_no. = " + emp_no +", " + "Title = " + title + ", " + 
        "From_date = " + from_date + ", " + "To_date" + to_date + "}" + "\n";
    }

    public static void main(String[] args) {
        ArrayList<Titles> tit = new ArrayList<>();
        String url="jdbc:mysql://localhost:3306/employees",user="root",password="Naman@code22";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,password);
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery("Select * from titles");
            while (rs.next()){
                tit.add(new Titles(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4)));
            }
            con.close();
            System.out.println(tit+"\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
