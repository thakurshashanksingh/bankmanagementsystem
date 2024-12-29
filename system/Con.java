package bank.management.system;

import java.sql.*;
public class Con {
    
    Connection c;
    Statement s;
    public Con()
    {
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","1234");
            s = c.createStatement();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
