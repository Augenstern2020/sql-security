package com.sqldesign.sqlsec.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.Connection;

public class db {
    private static String url;
    private static String username;
    private static String passwd;
    private static String driverName;
    private static Connection connection = null;
    static {
        try{
            FileInputStream fileInputStream = new FileInputStream("database.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
//            url = (String) properties.get("url");
            url = "jdbc:mysql://localhost:3306/sqlsec?characterEncoding=UTF-8";
//            username = (String) properties.get("username");
            username = "root";
//            passwd = (String) properties.get("passwd");
            passwd = "123456";
//            driverName = (String) properties.get("driverName");
            driverName = "com.mysql.jdbc.Driver";
            System.out.println(driverName);
            Class.forName(driverName);
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(url,username,passwd);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
//    public static void main(String[] args) {
//            Connection connection = getConnection();
//            System.out.println(connection);
//    }
}
