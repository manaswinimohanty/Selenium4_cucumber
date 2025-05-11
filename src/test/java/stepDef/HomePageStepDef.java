package stepDef;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import hooks.Hooks;

import org.testng.Assert;

import pageObject.HomePage;
import utils.BaseClass;

public class HomePageStepDef extends BaseClass {

 //   private BaseClass baseClass;
    private final HomePage homePage=new HomePage(driver);
    Logger log= LogManager.getLogger();

    @Given("Navigate to home page")
    public void navigate_to_home_page() {
        openUrl(driver);


    }
    @Then("Signup and login link should be displayed")
    public void signup_and_login_link_should_be_displayed() {
        homePage.verifySignUpLink();

    }

    @When("user click on signUp and login link")
    public void user_click_on_sign_up_and_login_link() {
        homePage.clickOnSignUpLink();
    }


    }


