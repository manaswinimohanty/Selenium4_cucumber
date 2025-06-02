package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-web-security");
                options.addArguments("--no-proxy-server");
                options.addArguments("--disable-extensions");
                options.addArguments("test-type");

                options.addArguments("--disable-notifications");
                // Disable pop-up blocking
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-infobars");


                Map prefs = new HashMap();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.default_content_setting_values.notifications", 2);
                prefs.put("autofill.profile_enabled",false);



               options.setExperimentalOption("prefs", prefs);

                System.setProperty("webdriver.chrome.driver", "src/test/resources/driverExe/chromedriver.exe");
                threadLocal.set(ThreadGuard.protect(new ChromeDriver(options)));
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference("dom.webnotifications.enabled",false);
                System.setProperty("webdriver.gecko.driver", "src/test/resources/driverExe/geckodriver.exe");
                threadLocal.set(ThreadGuard.protect(new FirefoxDriver(firefoxOptions)));
                break;
            default:
                log.info("unsupported browser is passed:" + browserType);

        }
    }


    public static synchronized WebDriver getDriverInstance() {
        return threadLocal.get();
    }


}