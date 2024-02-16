package bank.management.system;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    {
    try{
        c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","SakLak");
        s = c.createStatement();
    }catch(Exception e){
        System.out.println(e);
    }
}
}
