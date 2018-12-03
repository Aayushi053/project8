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
public class SignUpDAO {
    
    public boolean SignUp(String name,String email, String password)
    {
        String url="jdbc:mysql://localhost:3306/pro?useSSL=false";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement pstmt=con.prepareStatement("insert into prog values(?,?,?)");
            pstmt.setString(1,name);
            pstmt.setString(2,email);
            pstmt.setString(3,password);
            
            pstmt.executeUpdate();
            
            return true;
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println(e);
        }
        return false;
    }
    
}
