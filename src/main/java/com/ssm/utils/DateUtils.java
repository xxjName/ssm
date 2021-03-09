package com.ssm.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateUtils {
   private static  SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /***
     *   字符串转日期格式
     * @param date
     * @return
     */
   public static String dateFormat(String date){
       return dateFormat.format(date);
   }


   public static String dateFormat(Date date){
       return dateFormat.format(date);
   }
  public static String timeStamp(String date){
      return date.replace("T" ," ");
  }
    public static void main(String[] args) {

       String date="2021-03-08T12:16:53";


        try {
            System.out.println(timeStamp(date));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
