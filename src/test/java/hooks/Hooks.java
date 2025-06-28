package hooks;

import api.RegistrationApiClient;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.BrowserFactory;

public class Hooks {
    Logger log= LogManager.getLogger();
    public Scenario sc;

    private RegistrationApiClient registrationApiClient; // Injected by PicoContainer

    // Constructor for PicoContainer injection
    public Hooks(RegistrationApiClient registrationApiClient) {
        System.out.println("inside hooks constructor====");
        this.registrationApiClient = registrationApiClient;
    }

    @Before
    public void beforeScenario(Scenario sc) {

        log.info("launching the browser...........");
        BrowserFactory.browserSetUp();
    }
    @Before("@apiRegistration")
        public void registerUserApiPrecondition(Scenario sc) {
        System.out.println("inside before @apiRegistratio====");
        registrationApiClient.registerNewUser();
    }

    @After(order = 1)
    public void TakeScreenShot(Scenario sc) {
        if (sc.isFailed()) {
            String scenarionName = sc.getName().replaceAll(" ", "_");
            TakesScreenshot ts = (TakesScreenshot) BrowserFactory.getDriverInstance();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            sc.attach(screenshot, "image/png", scenarionName);
        }

    }


    @After(order = 0)
    public void tearDown() {
        log.info("quiting the browser........");
        BrowserFactory.getDriverInstance().quit();
    }


}
