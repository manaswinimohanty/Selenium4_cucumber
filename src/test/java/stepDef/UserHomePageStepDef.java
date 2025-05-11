package stepDef;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObject.UserHomePage;
import utils.BaseClass;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class UserHomePageStepDef extends BaseClass {

    private final UserHomePage userHomePage=new UserHomePage(driver);
    private final Logger log= LogManager.getLogger();



    @Then("page should navigate to user HomePage")
    public void pageShouldNavigateToUserHomePage() {
        userHomePage.verifyPageTitle();

    }


    @When("click on logout button")
    public void clickOnLogoutButton() {

    userHomePage.clickOnLogOutLink();
    }
}
