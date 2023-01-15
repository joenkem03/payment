package com.paysuremiddleware.easypayservice.logic.helpers;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Component
public class Utility {

    public Timestamp DateTime(){

        Calendar calendar = Calendar.getInstance();
        java.util.Date currentTime = calendar.getTime();
        long time = currentTime.getTime();

        return new Timestamp(time);
    }

    public Timestamp ParseDate(String date) throws ParseException {

//        SimpleDateFormat sdf = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        SimpleDateFormat sdf = new SimpleDateFormat(Locale.ROOT.toString());
        Date ss = sdf.parse(date);
        long longDate = ss.getTime()/1000;

        return new Timestamp(longDate);
    }

    public String  DateString(){

//        SimpleDateFormat sdf = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
//        SimpleDateFormat sdfx = new SimpleDateFormat("E, yyyymmmddHHmmss");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
//        SimpleDateFormat sdf = new SimpleDateFormat(Locale.ROOT.toString());

        return sdf.format(new Date());
    }

    public String RandomNumbersString(int max, int min, int size){
        StringBuilder rand = new StringBuilder();
        for(int count = 0; count <= size; count++ ){
            rand.append((int) Math.floor(Math.random() * (max - min + 1) + min));
        }
        return rand.toString();
    }

    public String GenerateSessionID(String clientCode){
//        yymmddHHmmss
//        Client code + date and time in YYMMDDHHMMSS + random 12 digits  "777777221201230344517472945356",
        String get = clientCode + DateString() + RandomNumbersString(9, 0, 11);
        System.out.println(get);
        return get;
    }

    public static String GenerateBatchNo(){
        return "";
    }
}
