/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aayushi Singh
 */
public class adminDAO {
    
    
    String name;
    String password;
    public boolean validate(String username,String password) 
    {
        String url="jdbc:mysql://localhost:3306/pro?useSSL=false";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            String query="select * from prog where name=? AND password =?";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            ResultSet rs=pstmt.executeQuery();
            return rs.next();
//            while(rs.next())
//            {
//                name=rs.getString(2);
//                return true;
//            }
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println(e);
        }
        return false;
    }
    public String getName()
    {
        return name;
    }
}
