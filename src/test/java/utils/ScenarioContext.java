package utils;

import pojo.Users;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScenarioContext {
    private static ThreadLocal<Users>threadLocalDataStore=ThreadLocal.withInitial(() -> {return new Users();});

    //public Users users;
 //   private Map<String, Object> scenarioData = new HashMap<>();

   // private ScenarioContext(){};

    public static void setUsers(Users users){
        threadLocalDataStore.set(users);
   }

    public static Users getUsers(){
        return threadLocalDataStore.get();
   }

}