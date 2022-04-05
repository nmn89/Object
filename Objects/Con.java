package Objects;
import java.sql.*;

public class Con {
    static Connection con = null;
    static public ResultSet fun(String sql)throws Exception{
        try {
            String url="jdbc:mysql://localhost:3306/employees",user="root",password="Naman@code22";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,password);
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}