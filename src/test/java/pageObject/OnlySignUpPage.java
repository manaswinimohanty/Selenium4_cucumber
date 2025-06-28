package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class OnlySignUpPage {

    private WebDriver driver;
    private WebElement element;
    private final String signUpPageTitle="Automation Exercise - Signup";
    private final Logger log= LogManager.getLogger();

        @FindBy(xpath="//form//label[@for]") private List<WebElement> labels;

    @FindBy(xpath = "//label[text()='Title']//following-sibling::div//label[@for='id_gender1']") private WebElement labelMr;

    @FindBy(xpath = "//label[text()='Title']//following-sibling::div//label[@for='id_gender2']") private WebElement labelMrs;

    @FindBy(xpath="//label[@for='name']")private WebElement nameLabel;

    @FindBy(xpath = "//label[@for='email']")private WebElement emailLabel;
    @FindBy(xpath = "//label[@for='password']")private WebElement passwordLabel;

    @FindBy(xpath = "//label[.='Date of Birth']")private WebElement DOBLabel;

    @FindBy(xpath = "//label[@for='newsletter']")private WebElement newsletterLabel;

    @FindBy(xpath = "//label[@for='optin']")private WebElement optinLabel;
    @FindBy(xpath = "//label[@for='first_name']")private WebElement first_nameLabel;
    @FindBy(xpath = "//label[@for='last_name']")private WebElement last_nameLabel;
    @FindBy(xpath = "//label[@for='company']")private WebElement companyLabel;
    @FindBy(xpath = "//label[@for='address1']")private WebElement address1Label;

    @FindBy(xpath = "//label[@for='address2']")private WebElement address2Label;
    @FindBy(xpath = "//label[@for='country']")private WebElement countryLabel;
    @FindBy(xpath = "//label[@for='state']")private WebElement stateLabel;
    @FindBy(xpath = "(//label[@for='city'])[1]")private WebElement cityLabel;

    @FindBy(xpath = "(//label[@for='city'])[2]")private WebElement zipcodeLabel;
    @FindBy(xpath = "//label[@for='mobile_number']")private WebElement mobile_numberLabel;



    @FindBy(xpath = "//form[@action='/signup']//button[text()='Create Account']")private WebElement createAccountBtn;

    public OnlySignUpPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public void verifysignUpPageTitle() {
        log.info("Verify signup page title");
        Assert.assertEquals(driver.getTitle(), signUpPageTitle, "signUp Page Title not matched");
    }



    private String getWebElementAttribute(WebElement element,String atr){
        return element.getDomAttribute(atr);
    }

    private WebElement getInputElementUsingForAttribute(WebElement element) {
        String forAtr=getWebElementAttribute(element,"for");
        String idAttribute = String.format("./..//input[@id='%s']", forAtr);
        // return element.findElement(By.xpath("./.."+idAttribute+""));
        return element.findElement(By.xpath(idAttribute));

    }

    private String getWebElementText(WebElement e) {
        String text = e.getText().trim();
        /*List<WebElement> children = e.findElements(By.xpath("./*"));
        for (WebElement child : children)
        {
            if(child.getText().equals("*"))
                        text = text.replaceAll("\\*", "").trim();
        else
            text = text.replaceFirst(child.getText(), "").trim();

    }
        text=text.replaceAll("[^\\w\\s]","");
        System.out.println(text);*/
        return text;
    }
    public void assertTitleForMr(){
        String text=getWebElementText(labelMr);
        Assert.assertEquals(text,"Mr.");
    }

    public void selectMrTitle()throws Exception{
        WebElement TitleMrRadioBtn=getInputElementUsingForAttribute(labelMr);
        if (TitleMrRadioBtn.isEnabled() && !TitleMrRadioBtn.isSelected()) {
            TitleMrRadioBtn.click();
        }
    }
    public void assertTitleForMrs(){
        String text=getWebElementText(labelMrs);
        Assert.assertEquals(text,"Mrs.");
    }

    public void selectMrsTitle() throws Exception {
        WebElement TitleMrsRadioBtn = getInputElementUsingForAttribute(labelMrs);
        if (TitleMrsRadioBtn.isEnabled() && !TitleMrsRadioBtn.isSelected()) {
            TitleMrsRadioBtn.click();
        }
    }


    private boolean validateRequiredTxtBox(WebElement element) {
        String value = getWebElementAttribute(element, "required");
        boolean result = false;
        if (value != null) {
            result = true;
        }
        return result;
    }

    public void AssertNameLabel(){
        String text=getWebElementText(nameLabel);
        Assert.assertEquals(text,"Name *");
    }

    public void AssertEmailLabel(){
        String text=getWebElementText(emailLabel);
        Assert.assertEquals(text,"Email *");
    }

    public void AssertPasswordLabel(){
        String text=getWebElementText(passwordLabel);
        Assert.assertEquals(text,"Password *");
    }

    public void AssertDOBLabel(){
        String text=getWebElementText(DOBLabel);
        Assert.assertEquals(text,"Date of Birth");
    }


    public void AssertnewsletterLabel(){
        String text=getWebElementText(newsletterLabel);
        Assert.assertEquals(text,"Sign up for our newsletter!");
    }


    public void AssertoptinLabel(){
        String text=getWebElementText(optinLabel);
        Assert.assertEquals(text,"Receive special offers from our partners!");
    }

    public void Assertfirst_nameLabel(){
        String text=getWebElementText(first_nameLabel);
        Assert.assertEquals(text,"First name *");
    }


    public void Assertlast_nameLabel(){
        String text=getWebElementText(last_nameLabel);
        Assert.assertEquals(text,"Last name *");
    }

    public void AssertcompanyLabel(){
        String text=getWebElementText(companyLabel);
        Assert.assertEquals(text,"Company");
    }

    public void Assertaddress1Label(){
        String text=getWebElementText(address1Label);
        Assert.assertEquals(text,"Address * (Street address, P.O. Box, Company name, etc.)");
    }

    public void Assertaddress2Label(){
        String text=getWebElementText(address2Label);
        Assert.assertEquals(text,"Address 2");
    }

    public void AssertcountryLabel(){
        String text=getWebElementText(countryLabel);
        Assert.assertEquals(text,"Country *");
    }

    public void AssertstateLabel(){
        String text=getWebElementText(stateLabel);
        Assert.assertEquals(text,"State *");
    }

    public void AssertcityLabel(){
        String text=getWebElementText(cityLabel);
        Assert.assertEquals(text,"City *");
    }

    public void AssertzipcodeLabel(){
        String text=getWebElementText(zipcodeLabel);
        Assert.assertEquals(text,"Zipcode *");
    }

    public void Assertmobile_numberLabel() {
        String text = getWebElementText(mobile_numberLabel);
        Assert.assertEquals(text, "Mobile Number *");
    }

    public boolean validateNameTxtBox() {
        WebElement nameTxtBox = getInputElementUsingForAttribute(nameLabel);
        return validateRequiredTxtBox(nameTxtBox);

    }

    public boolean validateEmailTxtBox() {
        WebElement emailTxtBox = getInputElementUsingForAttribute(emailLabel);
        return validateRequiredTxtBox(emailTxtBox);

    }

    public boolean validatePasswordTxtBox() {
        WebElement passwordTxtBox = getInputElementUsingForAttribute(passwordLabel);
        return validateRequiredTxtBox(passwordTxtBox);
    }


    public boolean validatenewsletterChkBox() {
        WebElement newsChktBox = getInputElementUsingForAttribute(newsletterLabel);
        return validateRequiredTxtBox(newsChktBox);
    }

    public boolean validateoptinChkBox() {
        WebElement optinChkBox = getInputElementUsingForAttribute(optinLabel);
        return validateRequiredTxtBox(optinChkBox);
    }
    public boolean validateFirst_nameTxtBox() {
        WebElement first_nameTxtBox = getInputElementUsingForAttribute(first_nameLabel);
        return validateRequiredTxtBox(first_nameTxtBox);
    }
    public boolean validateLast_nameTxtBox() {
        WebElement last_nameTxtBox = getInputElementUsingForAttribute(last_nameLabel);
        return validateRequiredTxtBox(last_nameTxtBox);
    }

    public boolean validateCompanyTxtBox() {
        WebElement companyTxtBox = getInputElementUsingForAttribute(companyLabel);
        return validateRequiredTxtBox(companyTxtBox);
    }

    public boolean validateAddress1TxtBox() {
        WebElement address1TxtBox = getInputElementUsingForAttribute(address1Label);
        return validateRequiredTxtBox(address1TxtBox);
    }

    public boolean validateAddress2TxtBox() {
        WebElement address2TxtBox = getInputElementUsingForAttribute(address2Label);
        return validateRequiredTxtBox(address2TxtBox);
    }

    public boolean validateCountryDropDown() {
        String countryForAttribute=getWebElementAttribute(countryLabel,"for");
        String idAttribute = String.format("//select[@id='%s']", countryForAttribute);
        WebElement countrySelectDropDown= driver.findElement(By.xpath(idAttribute));
        return validateRequiredTxtBox(countrySelectDropDown);
    }

    public boolean validateStateTxtBox() {
        WebElement stateTxtBox = getInputElementUsingForAttribute(stateLabel);
        return validateRequiredTxtBox(stateTxtBox);
    }

    public boolean validateCityTxtBox() {

        WebElement cityTxtBox = getInputElementUsingForAttribute(cityLabel);
        return validateRequiredTxtBox(cityTxtBox);
    }
    public boolean validateZipcodeTxtBox() {
        WebElement zipcodeTxtBox = zipcodeLabel.findElement(By.xpath("./../input[@id='zipcode']"));;
        return validateRequiredTxtBox(zipcodeTxtBox);
    }

    public boolean validateMobileNoTxtBox() {
        WebElement mobileNoTxtBox = getInputElementUsingForAttribute(mobile_numberLabel);
        return validateRequiredTxtBox(mobileNoTxtBox);
    }
    private void enterValueInTxtBox(WebElement txtElement,String name)throws Exception {
        //WebElement nameTxtBox = getInputElementUsingForAttribute(nameLabel);
        if (txtElement.isEnabled()) {
            if (getWebElementAttribute(txtElement, "value").isEmpty()) {
                txtElement.sendKeys(name);
            } else {
                /*txtElement.clear();
                txtElement.sendKeys(name);*/
            }
        } else {
            System.out.println(getWebElementAttribute(txtElement,"value"));
        }
    }

    public void enterValueInNameTxtBox(String name)throws Exception {
        WebElement TxtBoxelement = getInputElementUsingForAttribute(nameLabel);
        enterValueInTxtBox(TxtBoxelement,name);
    }

    public void enterValueInEmailTxtBox(String email)throws Exception{
        WebElement emailTxtBox = getInputElementUsingForAttribute(emailLabel);
        enterValueInTxtBox(emailTxtBox,email);
    }

    public void enterValueInPasswordTxtBox(String password)throws Exception{
        WebElement passwordTxtBox = getInputElementUsingForAttribute(passwordLabel);
        enterValueInTxtBox(passwordTxtBox,password);
    }

    public void enterValueInfirst_nameTxtBox(String first_name)throws Exception{
        WebElement first_nameTxtBox = getInputElementUsingForAttribute(first_nameLabel);
        enterValueInTxtBox(first_nameTxtBox,first_name);
    }

    public void enterValueInlast_nameTxtBox(String last_name)throws Exception{
        WebElement last_nameTxtBox = getInputElementUsingForAttribute(last_nameLabel);
        enterValueInTxtBox(last_nameTxtBox,last_name);
    }
    public void enterValueInCompanyTxtBox(String companyName)throws Exception{
        WebElement companyTxtBox = getInputElementUsingForAttribute(companyLabel);
        enterValueInTxtBox(companyTxtBox,companyName);
    }

    public void enterValueInAddress1TxtBox(String address1)throws Exception{
        WebElement address1TxtBox = getInputElementUsingForAttribute(address1Label);
        enterValueInTxtBox(address1TxtBox,address1);
    }

    public void enterValueInAddress2TxtBox(String address2)throws Exception{
        WebElement address2TxtBox = getInputElementUsingForAttribute(address2Label);
        enterValueInTxtBox(address2TxtBox,address2);
    }

    public void enterValueInCountryDropDown(String countryName)throws Exception{
        String countryForAttribute= countryLabel.getAttribute("for");
        String idAttribute = String.format("//select[@id='%s']", countryForAttribute);
        WebElement countryDropDown= driver.findElement(By.xpath(idAttribute));
        // WebElement countryDropDown=countryLabel.findElement(By.xpath("/..//select[@id="+countryForAttribute+""));
        if(countryDropDown.isEnabled()){
            new Select(countryDropDown).selectByVisibleText(countryName);
        }

    }

    public void enterValueInStateTxtBox(String stateName)throws Exception{
        WebElement stateTxtBox = getInputElementUsingForAttribute(stateLabel);
        enterValueInTxtBox(stateTxtBox,stateName);
    }

    public void enterValueInCityTxtBox(String cityName)throws Exception{
        WebElement cityTxtBox = getInputElementUsingForAttribute(cityLabel);
        enterValueInTxtBox(cityTxtBox,cityName);
    }


    public void enterValueInZipcodeTxtBox(String zipcode)throws Exception{
        WebElement zipcodeTxtBox = zipcodeLabel.findElement(By.xpath("./../input[@id='zipcode']"));
        enterValueInTxtBox(zipcodeTxtBox,zipcode);
    }

    public void enterValueInMobileNoTxtBox(String mobileNo)throws Exception{
        WebElement mobileNoTxtBox = getInputElementUsingForAttribute(mobile_numberLabel);
        enterValueInTxtBox(mobileNoTxtBox,mobileNo);
    }

    public void selectNewsletterChkBox(boolean status)throws Exception{
        WebElement newsletterChkBox = getInputElementUsingForAttribute(newsletterLabel);
        if(status==true&&newsletterChkBox.isEnabled() && ! newsletterChkBox.isSelected()){
            newsletterChkBox.click();
        }
        else if(status==false&&newsletterChkBox.isEnabled() &&  newsletterChkBox.isSelected())
            newsletterChkBox.click();
    }

    public void selectOptionChkBox(boolean status)throws Exception{
        WebElement optionChkBox = getInputElementUsingForAttribute(optinLabel);
        if(status==true&&optionChkBox.isEnabled() && ! optionChkBox.isSelected()){
            optionChkBox.click();
        }
        else if(status==false&&optionChkBox.isEnabled() && optionChkBox.isSelected())
            optionChkBox.click();
    }

    public void enterDOB(String day, String month, String year){

        List<WebElement>dob=DOBLabel.findElements(By.xpath("./..//select"));
        for(WebElement eachDOB:dob){
            String idAtr=eachDOB.getDomAttribute("id");
            if(idAtr.equalsIgnoreCase("days"))
                new Select(eachDOB).selectByVisibleText(day);
            else if (idAtr.equalsIgnoreCase("months")) {
                new Select(eachDOB).selectByVisibleText(month);
            } else if (idAtr.equalsIgnoreCase("years")) {
                new Select(eachDOB).selectByVisibleText(year);
            }
        }
    }

    public void clickOnCreateAccountBtn(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createAccountBtn);
        wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn));
        Assert.assertEquals(createAccountBtn.getText(),"Create Account");
        //  if(createAccountBtn.isEnabled())
        createAccountBtn.click();
        //  else System.out.println("button is disabled");
    }


}
