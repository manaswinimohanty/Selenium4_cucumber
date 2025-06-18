package stepDef;

import factories.UserFactories;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.OnlySignUpPage;
import pojo.Users;
import utils.BaseClass;

public class OnlySignUpPageStepDef extends BaseClass {
    Users users= UserFactories.createDefault();
    private final OnlySignUpPage sign=new OnlySignUpPage(driver);

    @When("enter signup_name and signup_email Address and click on Signup  button")
    public void enterNameAndEmailAddressAndClickOnSignupButton() {
        sign.enterSignUpName_EmailTxtBox(users.getUserName(),users.getEmail());

    }


    @Then("Page should navigate to sign up Page")
    public void pageShouldNavigateToSignUpPage() {
        sign.verifysignUpPageTitle();
    }

    @And("Enter Account Information")
    public void enterAccountInformation() {
        //List<Map<String,String>>mapList=user.asMaps(String.class,String.class);

        try {
            System.out.println("==============inside only signup page==========");
            System.out.println(users.getUserName());
            System.out.println(users.getEmail());
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

            if(users.getGender().equalsIgnoreCase("male")){
                sign.selectMrTitle();
            } else if (users.getGender().equalsIgnoreCase("female")) {
                sign.selectMrTitle();
            }

            if (sign.validateNameTxtBox()) {
                sign.enterValueInNameTxtBox(users.getUserName());
            }

            if (sign.validateEmailTxtBox()) {
                sign.enterValueInEmailTxtBox(users.getEmail());
            }
            else{
                System.out.println("email not required");
            }

            if (sign.validatePasswordTxtBox()) {
                sign.enterValueInPasswordTxtBox(users.getPassword());
            }
            else{
                System.out.println("password not required");
            }

            sign.enterDOB(users.getDay(),users.getMonth(),users.getYear());

            if(users.getNewsletterChkBox()){
                sign.selectNewsletterChkBox(true);
            }
            else {
                sign.selectNewsletterChkBox(false);
            }


            if(users.getOptions()){
                sign.selectOptionChkBox(true);
            }
            else{
                sign.selectOptionChkBox(false);
            }

            if(sign.validateFirst_nameTxtBox()){
                sign.enterValueInfirst_nameTxtBox(users.getFirstName());
            }
            else{
                System.out.println("first name not a mandatory field");
            }

            if(sign.validateLast_nameTxtBox()){
                sign.enterValueInlast_nameTxtBox(users.getLastName());
            }
            else{
                System.out.println("last name not a mandatory field");
            }


            if(sign.validateCompanyTxtBox()){
                sign.enterValueInCompanyTxtBox(users.getCompany());
            }
            else
                sign.enterValueInCompanyTxtBox(users.getCompany());
            //System.out.println("company not a mandatory field");

            if(sign.validateAddress1TxtBox()){
                sign.enterValueInAddress1TxtBox(users.getAddress());
            }
            else System.out.println("address1 not a mandatory field");

            if(sign.validateAddress2TxtBox()){
                sign.enterValueInAddress2TxtBox(users.getSecondaryAddress());
            }
            else
                sign.enterValueInAddress2TxtBox(users.getSecondaryAddress());
            //System.out.println("address2 not a mandatory field");

            if(sign.validateCountryDropDown()){
                sign.enterValueInCountryDropDown(users.getCountry());
            }
            else System.out.println("country not a mandatory field");

            if(sign.validateStateTxtBox()){
                sign.enterValueInStateTxtBox(users.getState());
            }
            else System.out.println("state not a mandatory field");

            if(sign.validateCityTxtBox()){
                sign.enterValueInCityTxtBox(users.getCity());
            }
            else System.out.println("city not a mandatory field");


            if(sign.validateZipcodeTxtBox()){
                sign.enterValueInZipcodeTxtBox(users.getZipcode());
            }
            else System.out.println("zipcode not a mandatory field");

            if(sign.validateMobileNoTxtBox()){
                sign.enterValueInMobileNoTxtBox(users.getMobileNo());
            }
            else System.out.println("mobileNo not a mandatory field");



        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @And("click on create account Btn")
    public void clickOnCreateAccountBtn() {

        sign.clickOnCreateAccountBtn();
    }
}
