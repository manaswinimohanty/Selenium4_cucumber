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

    @Then("page should navigate to log in page")
    public void page_should_navigate_to_log_in_page() {
    sign.verifyloginPageTitle();
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


    @When("enter signup_name and signup_email Address and click on Signup  button")
    public void enterNameAndEmailAddressAndClickOnSignupButton(DataTable signUp) {
        List<Map<String,String>> mapList=signUp.asMaps(String.class, String.class);
        sign.enterSignUpName_EmailTxtBox(mapList.get(0).get("signup_name"),mapList.get(0).get("signup_email"));

    }

    @Then("Page should navigate to sign up Page")
    public void pageShouldNavigateToSignUpPage() {
    sign.verifysignUpPageTitle();
    }

    @And("Enter Account Information and click on create account Btn")
    public void enterAccountInformationAndClickOnCreateAccountBtn() {
    //List<Map<String,String>>mapList=user.asMaps(String.class,String.class);
        try {
            sign.assertTitleForMr();
            sign.selectMrTitle();
            sign.AssertNameLabel();
            sign.AssertEmailLabel();
            sign.AssertPasswordLabel();
            sign.AssertDOBLabel();
            sign.AssertnewsletterLabel();
            sign.AssertoptinLabel();
            sign.Assertfirst_nameLabel();
            sign.Assertlast_nameLabel();
            sign.AssertcompanyLabel();
            sign.Assertaddress1Label();
            sign.Assertaddress2Label();
            sign.AssertcountryLabel();
            sign.AssertstateLabel();
            sign.AssertcityLabel();
            sign.AssertzipcodeLabel();
            sign.Assertmobile_numberLabel();


            if (sign.validateNameTxtBox()) {
                sign.enterValueInNameTxtBox("demo");
            }

            if (sign.validateEmailTxtBox()) {
                sign.enterValueInEmailTxtBox("demo");
            }
            else{
                System.out.println("email not required");
            }

            if (sign.validatePasswordTxtBox()) {
                sign.enterValueInPasswordTxtBox("password");
            }
            else{
                System.out.println("password not required");
            }


            if(sign.validatenewsletterChkBox()){
                sign.selectNewsletterChkBox();
            }
            else{
                System.out.println("newsletter not required");
            }


            if(sign.validateoptinChkBox()){
                sign.selectOptionChkBox();
            }
            else{
                System.out.println("option not required");
            }

            if(sign.validateFirst_nameTxtBox()){
                sign.enterValueInfirst_nameTxtBox("firstName");
            }
            else{
                System.out.println("first name not a mandatory field");
            }

            if(sign.validateLast_nameTxtBox()){
                sign.enterValueInlast_nameTxtBox("lastName");
            }
            else{
                System.out.println("last name not a mandatory field");
            }


            if(sign.validateCompanyTxtBox()){
                sign.enterValueInCompanyTxtBox("fake company");
            }
            else System.out.println("company not a mandatory field");

            if(sign.validateAddress1TxtBox()){
                sign.enterValueInAddress1TxtBox("flat-1,Road-1");
            }
            else System.out.println("address1 not a mandatory field");

            if(sign.validateAddress2TxtBox()){
                sign.enterValueInAddress2TxtBox("flat-2,Road-2");
            }
            else System.out.println("address2 not a mandatory field");

            if(sign.validateCountryDropDown()){
                sign.enterValueInCountryDropDown("India");
            }
            else System.out.println("country not a mandatory field");

            if(sign.validateStateTxtBox()){
                sign.enterValueInStateTxtBox("state");
            }
            else System.out.println("state not a mandatory field");

            if(sign.validateCityTxtBox()){
                sign.enterValueInCityTxtBox("city");
            }
            else System.out.println("city not a mandatory field");


            if(sign.validateZipcodeTxtBox()){
                sign.enterValueInZipcodeTxtBox("6789758");
            }
            else System.out.println("zipcode not a mandatory field");

            if(sign.validateMobileNoTxtBox()){
                sign.enterValueInMobileNoTxtBox("7789898899");
            }
            else System.out.println("mobileNo not a mandatory field");

            sign.clickOnCreateAccountBtn();




        Thread.sleep(50000);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}