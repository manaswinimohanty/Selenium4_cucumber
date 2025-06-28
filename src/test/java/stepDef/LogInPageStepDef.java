package stepDef;

import api.RegistrationApiClient;
import factories.UserFactories;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LogInPage;
import pojo.Users;
import utils.BaseClass;
import utils.DataInterface;
import utils.ScenarioContext;

import java.util.List;
import java.util.Map;


public class LogInPageStepDef extends BaseClass {

    private LogInPage logInOrSignUpPage;
     ScenarioContext context;
     private RegistrationApiClient apiClient;

    public LogInPageStepDef(ScenarioContext context,RegistrationApiClient apiClient){
        System.out.println("inside login step def==========");
        this.context=context;
        logInOrSignUpPage=new LogInPage(driver);
        this.apiClient=apiClient;
    }

    @Then("page should navigate to sign Up or log in page")
    public void pageShouldNavigateToSignUpOrLogInPage() {
        logInOrSignUpPage.verifyloginPageTitle();
    }


    @When("enter username as {string}")
    public void enterUsernameAs(String username) {
        logInOrSignUpPage.enterEmail(username);
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
        logInOrSignUpPage.enterEmail(mapList.get(0).get("username"));
        logInOrSignUpPage.enterPassword(mapList.get(0).get("password"));
    }

    @When("enter username and password from data table as List")
    public void enterUsernameAndPasswordFromDataTableAsList(DataTable data) {
       List<List<String>>lists= data.asLists(String.class);
        logInOrSignUpPage.enterEmail(lists.get(0).get(0));
        logInOrSignUpPage.enterPassword(lists.get(0).get(1));
    }

    @Then("Error message should display.")
    public void errorMessageShouldDisplay() {
        logInOrSignUpPage.verifyErrorMsg();
    }

    @When("enter signup_name and signup_email Address and click on Signup  button")
    public void enterNameAndEmailAddressAndClickOnSignupButton() {
        Users users=UserFactories.createDefault();
        ScenarioContext.setUsers(users);
       // context.users= UserFactories.createDefault();
       // context.setValue(DataInterface.email,context.users.getEmail());
      //  context.setValue(DataInterface.Password,context.users.getPassword());
        logInOrSignUpPage.enterSignUpName_EmailTxtBox(users.getUserName(),users.getEmail());

    }

    @When("log in with the credentials used during signup")
    public void logInWithTheCredentialsUsedDuringSignup() {
        Users user=ScenarioContext.getUsers();
        logInOrSignUpPage.enterSignUpName_EmailTxtBox(user.getUserName(),user.getEmail());
    }

    @Given("a new user is registered via API")
    public void aNewUserIsRegisteredViaAPI() {

        System.out.println("user is already registered");

    }

    @When("I enter the registered username and password")
    public void iEnterTheRegisteredUsernameAndPassword() {
        String username = apiClient.getRegisteredEmail();
        String password = apiClient.getRegisteredPassword();
        logInOrSignUpPage.enterEmail(username);
        logInOrSignUpPage.enterPassword(password);
        System.out.println("Logging in with: Username=" + username + ", Password=" + password);

    }
}