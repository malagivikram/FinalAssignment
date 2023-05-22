package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterationPage {

	private WebDriver driver;

	// Locators
	@FindBy(id = "AccountFrm_firstname")
	private WebElement firstName;

	@FindBy(id = "AccountFrm_lastname")
	private WebElement lastName;

	@FindBy(id = "AccountFrm_email")
	private WebElement emailID;

	@FindBy(id = "AccountFrm_address_1")
	private WebElement address1;

	@FindBy(id = "AccountFrm_city")
	private WebElement city;

	@FindBy(id = "AccountFrm_country_id")
	private WebElement country;

	@FindBy(id = "AccountFrm_zone_id")
	private WebElement state;

	@FindBy(id = "AccountFrm_postcode")
	private WebElement zipCode;

	// ,,
	@FindBy(id = "AccountFrm_loginname")
	private WebElement loginName;

	@FindBy(id = "AccountFrm_password")
	private WebElement password;

	@FindBy(id = "AccountFrm_confirm")
	private WebElement confirmPassword;

	@FindBy(id = "AccountFrm_agree")
	private WebElement policyCheckBox;

	@FindBy(xpath = "//button[@title='Continue']")
	private WebElement clickOnContinue;
	
	@FindBy(xpath = "//span[text()=' Your Account Has Been Created!']")
	private WebElement regSuccess;

	public RegisterationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFirstName(String firstname) {

		firstName.sendKeys(firstname);
		
	}

	public void enterLastName(String lastname) {
		
		lastName.sendKeys(lastname);
		
	}

	public void enterEmailID(String emailAddress) {

		emailID.sendKeys(emailAddress);
	}

	public void enteraddress1(String address) {

		address1.sendKeys(address);
	}

	public void enterCity(String cityName) {

		city.sendKeys(cityName);
	}

	public void enterZipCode(String zip) {

		zipCode.sendKeys(zip);
	}
	
	public void selectCountry(String countryName) {

		Select s=new Select(country);
		s.selectByVisibleText(countryName);
		
	}
	
	public void selectState(String stateName) {

		Select s=new Select(state);
		s.selectByVisibleText(stateName);
	}

	public void enterLoginName(String logname) {

		loginName.sendKeys(logname);
	}
	
	public void enterPassword(String pass) {

		password.sendKeys(pass);
	}
	
	public void enterConfirmPassword(String cPass) {

		confirmPassword.sendKeys(cPass);
	}
	public void checkPolicy() {

		policyCheckBox.click();
	}

	public void clickOnContinue() {

		clickOnContinue.click();
	}
	
	public WebElement getElement() {
        return regSuccess;
    }
	
	
	public String validateSuccessMessage() {

		return regSuccess.getText();
		
	}
}
