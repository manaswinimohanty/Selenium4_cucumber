package utils;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeStampBuilder {
    public  static synchronized String getGuid(){
        return java.util.UUID.randomUUID().toString();
    }



    public  static synchronized String buildUnqueTxtByPrefix(String prefix){
        return buildUniqueTxt(prefix,"","");
    }

    public  static synchronized String buildUnqueTxtByPrefix(String prefix,String separator){
        return buildUniqueTxt(prefix,"",separator);
    }

    public  static synchronized String buildUnqueTxtBySuffix(String suffix){
        return buildUniqueTxt("",suffix,"");
    }

    public  static synchronized String buildUnqueTxtBySuffix(String suffix,String separator){
        return buildUniqueTxt("",suffix,separator);
    }

    public static synchronized String buildUniqueTxt(String prefix, String suffix, String separator) {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSS");
        String dateNtime = date.format(formatter);

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return prefix + separator + dateNtime + separator + suffix;
    }

}
