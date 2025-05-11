package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;

public class BrowserFactory {
    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
    private static Logger log ;


    public static void browserSetUp() {
        log= LogManager.getLogger();
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(BaseClass.propertyFilePath));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        String browserType = prop.getProperty("browsername").toLowerCase();
        switch (browserType) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/driverExe/chromedriver.exe");
                threadLocal.set(ThreadGuard.protect(new ChromeDriver()));
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/driverExe/geckodriver.exe");
                threadLocal.set(ThreadGuard.protect(new FirefoxDriver()));
                break;
            default:
                log.info("unsupported browser is passed:" + browserType);

        }
    }


    public static synchronized WebDriver getDriverInstance() {
        return threadLocal.get();
    }


}