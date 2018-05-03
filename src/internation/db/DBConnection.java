/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internation.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author NQHUY
 */
public class DBConnection {
    // Driver and URL
    private static final String DRIVER_JDBC = "com.mysql.jdbc.Driver";
    private static final String URL_DB = "jdbc:mysql://localhost/internation";
    // Pass and User
    private static final String USER = "root";
    private static final String PASS = "hoanghiep";

    private static Connection conn;

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_JDBC);
            conn = DriverManager.getConnection(URL_DB, USER, PASS);     // Kết nối mysql 
            System.out.println("Connected successfully ...");
        } catch (Exception e) {
            System.out.println("Error connection " + e);
        }
        return conn;    
    }
}
