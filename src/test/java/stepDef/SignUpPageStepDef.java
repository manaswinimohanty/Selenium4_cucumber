package stepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.SignUpPage;
import utils.BaseClass;

import java.util.List;
import java.util.Map;

public class SignUpPageStepDef extends BaseClass {

    private final SignUpPage sign=new SignUpPage(driver);

    @Then("page should navigate to sign Up page")
    public void page_should_navigate_to_sign_up_page() {
    sign.verifyPageTitle();
    }


    @When("enter username as {string}")
    public void enterUsernameAs(String username) {
        sign.enterUserName(username);
    }


    @And("enter password as {string}")
    public void enterPasswordAs(String password) {
        sign.enterPassword(password);
    }

    @And("click on login button")
    public void clickOnLoginButton() {
        sign.clickOnLoginBtn();
    }

    @When("enter username and password from data table as Map")
    public void enterUsernameAndPasswordFromDataTableAsMap(DataTable data) {
        List<Map<String,String>> mapList=data.asMaps(String.class, String.class);
        sign.enterUserName(mapList.get(0).get("username"));
        sign.enterPassword(mapList.get(0).get("password"));
    }

    @When("enter username and password from data table as List")
    public void enterUsernameAndPasswordFromDataTableAsList(DataTable data) {
       List<List<String>>lists= data.asLists(String.class);
        sign.enterUserName(lists.get(0).get(0));
        sign.enterPassword(lists.get(0).get(1));
    }

    @Then("Error message should display.")
    public void errorMessageShouldDisplay() {
        sign.verifyErrorMsg();
    }
}