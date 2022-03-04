package CRUDThuVien;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Connect {
    
    public static Connection ConnectSQL (){
        final String user = "sa";
        final String password = "123456";
        final String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLiThuVien;user="+user+";password="+password;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}