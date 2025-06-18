package stepDef;

import factories.UserFactories;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.AccountCreated;
import pojo.Users;
import utils.BaseClass;

public class AccountCreatedStepDef extends BaseClass {
        //Users users= UserFactories.createDefault();
        private final AccountCreated accountCreated=new AccountCreated(driver);
        Logger log= LogManager.getLogger();


    @Then("Page should navigate to account created page")
    public void page_should_navigate_to_account_created_page() {

        accountCreated.verifyAccountCreatedPageTitle();
    }

    @When("click on continue button")
    public void clickOnContinueButton() {
        accountCreated.clickOnContinueBtn();
    }
}
