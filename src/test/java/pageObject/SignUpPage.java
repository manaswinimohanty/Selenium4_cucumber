package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class SignUpPage {

    private final WebDriver driver;
    private final String signUpPageTitle = "Automation Exercise - Signup / Login";
    private final Logger log= LogManager.getLogger();

    @FindBy(name = "email")
    private WebElement userNameTextBox;

    @FindBy(name = "password")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//*[.='Login']")
    private WebElement loginBtn;

    @FindBy(xpath ="//*[contains(text(),'Your email or password is incorrect!')]") private WebElement errorMsg;


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void verifyPageTitle() {
        log.info("Verify signup page title");
        Assert.assertEquals(driver.getTitle(), signUpPageTitle, "signUp Page Title not matched");
    }

    public void enterUserName(String username) {
        userNameTextBox.sendKeys(username);

    }

    public void enterPassword(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void clickOnLoginBtn() {
        loginBtn.click();
    }

    public void verifyErrorMsg(){
        Assert.assertEquals(errorMsg.getText(),"Your email or password is incorrect!",errorMsg.getText()+" not displayed");
    }

}
