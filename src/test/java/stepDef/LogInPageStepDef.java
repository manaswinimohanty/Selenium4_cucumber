package stepDef;

import factories.UserFactories;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LogInPage;
import pojo.Users;
import utils.BaseClass;

import java.util.List;
import java.util.Map;

public class LogInPageStepDef extends BaseClass {
    Users users= UserFactories.createDefault();
    private final LogInPage logInOrSignUpPage=new LogInPage(driver);

    @Then("page should navigate to sign Up or log in page")
    public void pageShouldNavigateToSignUpOrLogInPage() {
        logInOrSignUpPage.verifyloginPageTitle();
    }


    @When("enter username as {string}")
    public void enterUsernameAs(String username) {
        logInOrSignUpPage.enterUserName(username);
    }


    @And("enter password as {string}")
    public void enterPasswordAs(String password) {
        logInOrSignUpPage.enterPassword(password);
    }

    @And("click on login button")
    public void clickOnLoginButton() {
        logInOrSignUpPage.clickOnLoginBtn();
    }

    @When("enter username and password from data table as Map")
    public void enterUsernameAndPasswordFromDataTableAsMap(DataTable data) {
        List<Map<String,String>> mapList=data.asMaps(String.class, String.class);
        logInOrSignUpPage.enterUserName(mapList.get(0).get("username"));
        logInOrSignUpPage.enterPassword(mapList.get(0).get("password"));
    }

    @When("enter username and password from data table as List")
    public void enterUsernameAndPasswordFromDataTableAsList(DataTable data) {
       List<List<String>>lists= data.asLists(String.class);
        logInOrSignUpPage.enterUserName(lists.get(0).get(0));
        logInOrSignUpPage.enterPassword(lists.get(0).get(1));
    }

    @Then("Error message should display.")
    public void errorMessageShouldDisplay() {
        logInOrSignUpPage.verifyErrorMsg();
    }


//    @When("enter signup_name and signup_email Address and click on Signup  button")
//    public void enterNameAndEmailAddressAndClickOnSignupButton(DataTable signUp) {
//        List<Map<String,String>> mapList=signUp.asMaps(String.class, String.class);
//        sign.enterSignUpName_EmailTxtBox(mapList.get(0).get("signup_name"),mapList.get(0).get("signup_email"));
//
//    }





}