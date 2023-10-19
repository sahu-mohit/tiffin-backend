package com.tifin.Utility;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.tifin.AllConstant.Constant;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DataTypeUtility {

    public static String getEncryption(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String stringvlue(Object value) {
        if(value != null && !(value.equals("") || value.toString().equalsIgnoreCase("undefined") || value.toString().equalsIgnoreCase("null"))) {
            return (value.toString()).trim();
        }else{
            return "";
        }

    }
    public static Long longvalue(Object value) {
        if(value instanceof String){
            String stringvalue = value.toString();
        }
        if ((value.equals("") || value == "" ||value == "0" || value == null || value.toString().equalsIgnoreCase("undefined") || value.toString().equalsIgnoreCase("null"))) {
            return 0l;
        }
        return (long)(int)(Integer)value;
    }

    public static Boolean booleanvalue(Object value){
        if(!(value.toString().equals("") || value == null || value.toString().equalsIgnoreCase("null") || !(Boolean)value)){
            return true;
        }else{
            return false;
        }
    }

    public static String getDateTimeByFormat(String dateFormat, Date date){
        if(!stringvlue(date).equals("")){
            return new SimpleDateFormat(dateFormat).format(date);
        }else{
            Date d = new Date();
            return new SimpleDateFormat(dateFormat).format(d);
        }
    }

    public static Date getDateTimeofDateTypeByFormat(String dateFormat, Date date){
        try{
            if(!stringvlue(date).equals("")){
                String strDate = new SimpleDateFormat(dateFormat).format(date);
                return new SimpleDateFormat(dateFormat).parse(strDate);
            }else{
                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
                String formattedDateTime = currentDateTime.format(formatter);
                return new SimpleDateFormat(dateFormat).parse(formattedDateTime);
            }
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Date getCurrentDateTimeOfDateTypeByFormat(String dateFormat){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        String formattedDateTime = currentDateTime.format(formatter);
        Date date = null;
        try {
            date = new SimpleDateFormat(dateFormat).parse(formattedDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getChangeDateFormat(String dateFormat, String date){
        Date date1 = null;
        try{
            date1 = new SimpleDateFormat(dateFormat).parse(date);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return date1;
    }



    public static Boolean isNull(Object value){
        if(value == null){
            return true;
        }else{
            return false;
        }
    }
}
