package utils;

import factories.UserFactories;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pojo.Users;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static final String propertyFilePath=System.getProperty("user.dir")+"/src/test/resources/SetUp.properties";
    private Logger log;
   // protected static Users users = UserFactories.createDefault();
    protected WebDriver driver=BrowserFactory.getDriverInstance();
    //testContextSetUp

    public void openUrl(WebDriver driver){
        log= LogManager.getLogger();
        Properties pro=new Properties();
        try {
            pro.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String url=pro.getProperty("url");
        log.info("entering the url........");
        driver.get(url);
    //    driver.manage().window().maximize();

    }





}
