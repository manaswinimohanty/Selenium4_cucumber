package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

private final WebDriver driver;

    @FindBy(xpath="//a[@href='/login']")
    WebElement loginOrSignUpLink;
    private final Logger log= LogManager.getLogger();

public HomePage(WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(driver,this);

}

public void verifySignUpLink(){
    Assert.assertTrue(loginOrSignUpLink.getText().contains("Signup / Login"));
}

public void clickOnSignUpLink(){
    loginOrSignUpLink.click();
}

}
