package Objects;
import Objects.Con;
import java.sql.*;
import java.util.*;

public class Departments {
    private String dept_no;
    private String dept_name;

    public Departments(String dept_no,String dept_name){
        this.dept_no =dept_no;
        this.dept_name = dept_name;
    }
    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
    }
    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
    public String getDept_no() {
        return dept_no;
    }
    public String getDept_name() {
        return dept_name;
    }
    @Override
    public String toString() {
        return "{"
            + "Department_no. = " + dept_no + " " + ",Department_name = " + dept_name +
        "}" + " \n";
    }

    public static void main(String[] args) {
        ArrayList<Departments> dep = new ArrayList<>();
        String query = "Select * from departments";
        try{ResultSet rs = Con.fun(query);
        while(rs.next()){
            dep.add(new Departments(rs.getString(1), rs.getString(2)));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(dep);
    }
}