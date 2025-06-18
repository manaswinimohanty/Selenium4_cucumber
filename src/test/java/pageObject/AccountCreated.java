package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AccountCreated {
    private WebDriver driver;
    private final String accountCreatedPageTitle="Automation Exercise - Account Created";
    Logger log= LogManager.getLogger();

    @FindBy(xpath="//*//b[.='Account Created!']")private WebElement accountCreatedTxt;

    @FindBy(linkText = "Continue")private WebElement continueBtn;

    public AccountCreated(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void verifyAccountCreatedPageTitle(){

        Assert.assertEquals(driver.getTitle(),accountCreatedPageTitle,"Account Created page title not matching");

     //   verifyTxt();

    }

    public void clickOnContinueBtn(){
        continueBtn.click();
    }

    private void verifyTxt(){
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOf(accountCreatedTxt));
        Assert.assertEquals(accountCreatedTxt.getText(),"Account Created!","account created text not matching");
    }

}
