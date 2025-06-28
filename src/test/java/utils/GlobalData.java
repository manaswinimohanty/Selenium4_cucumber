package utils;

import java.util.LinkedHashMap;

public class GlobalData {
   public static ThreadLocal<LinkedHashMap<String,Object>>data=ThreadLocal.withInitial(()->new LinkedHashMap<>());
    GlobalData(){}
    public static Object getData(String key){
        return data.get().get(key);
    }

    public static void setData(String key,Object value){
        data.get().put(key,value);
    }
}
