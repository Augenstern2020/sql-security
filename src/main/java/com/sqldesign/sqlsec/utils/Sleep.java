package com.sqldesign.sqlsec.utils;

public class Sleep {
    public static void wait(int ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
