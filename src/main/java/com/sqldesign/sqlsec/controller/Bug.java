package com.sqldesign.sqlsec.controller;

import com.sqldesign.sqlsec.jdbc.db;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Bug {
    @RequestMapping("/getUserInfo")

    public Map<String, Object> getUserInfo(String uid) {
        System.out.println("getuserinfo"+uid);
        Map<String, Object> map = new HashMap<>();
        Connection connection = db.getConnection();
        String sql = "select * from sqlsec.users where uid = " + uid;
        System.out.println(sql);
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            int count = 0;
            while (rs.next()) {
                String res = "";
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) {
                        res += ",  ";
                        System.out.print(",  ");
                    }
                    String columnValue = rs.getString(i);
                    System.out.print(rsmd.getColumnName(i) + " " + columnValue);
                    res += rsmd.getColumnName(i) + " " + columnValue;

                }
                map.put(String.valueOf(count), res);
                count++;
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        map.put("demo","demo");
        return map;
    }
    /*
    public Map<String,Object> getUserinfo(String uid){
        Map<String,Object> map = new HashMap<>();
        Connection connection= db.getConnection();
        String sql = "select * from sqlsec.users where uid = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,Integer.valueOf(uid));
            System.out.println(st.toString());
            ResultSet rs = st.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            int count = 0;
            while (rs.next()) {
                String res = "";
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) {
                        res += ",  ";
                        System.out.print(",  ");
                    }
                    String columnValue = rs.getString(i);
                    System.out.print( rsmd.getColumnName(i)+ " " + columnValue);
                    res += rsmd.getColumnName(i)+ " " + columnValue;

                }
                map.put(String.valueOf(count),res);
                count++;
                System.out.println("");
            }
        }catch (Exception e) {
            map.put("info","error");
            e.printStackTrace();
        }
//        map.put("demo","demo");
        return map;
    }*/
}
