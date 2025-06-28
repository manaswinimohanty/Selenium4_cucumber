package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UserHomePage {

    private final WebDriver driver;
    private static final String UserHomePageTitle="Automation Exercise";
    private final Logger log= LogManager.getLogger();

    @FindBy(xpath = "//a[@href='/logout']") private WebElement logoutLink;

    public UserHomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public void verifyPageTitle() {
        log.info("Verify signup page title");
        Assert.assertEquals(driver.getTitle(), UserHomePageTitle, "UserHome Page Title not matched");
    }

    public void clickOnLogOutLink(){
        logoutLink.click();
    }

}
