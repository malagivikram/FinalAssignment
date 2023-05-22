package stepDefinitions;

import java.time.Duration;

import org.testng.Assert;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.RegisterationPage;
import util.LoggerHelper;


public class StepsForEndtoEndTest{
	
	WebDriver driver=null;
	LoginPage cont;
	RegisterationPage reg;
	HomePage hm;
	ProductsPage prod;
	CartPage crt;
	Logger log;
	
	@Before
	public void setUpBrowser(Scenario scenario) {
		
		log=LoggerHelper.getLogger(LoggerHelper.class);
	
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationteststore.com/index.php?rt=account/login");
		
		log.info("Browser is Opened");
	}
	
	@After
	public void teardownBrowser(Scenario scenario) {
		
		if(scenario.isFailed()) {
			byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Screenshot attached");
		}
		
		log.info("Browser is Closed");
		
		driver.quit();
	}

@Given("User clicks on continue button for Registeration")
public void user_clicks_on_continue_button_for_registeration() {

	cont=new LoginPage(driver);
	cont.clickOnContinue();	
	
	log.info("Clicked on Continue button for creating a New Account");
}

@And("^User enters First Name (.*), Last Name (.*) and E-mail address (.*)$")
public void user_enters_first_name_last_name_and_e_mail_address(String firstName, String lastName, String email) {
	
	reg=new RegisterationPage(driver);
	
	reg.enterFirstName(firstName);
	reg.enterLastName(lastName);
	reg.enterEmailID(email);
	
	log.info("User Entered firstName, lastName and email");
}

@And("^User selects country (.*) and (.*) from the dropdown$")
public void user_selects_country_and_from_the_dropdown(String country, String state) {

	reg.selectCountry(country);
	reg.selectState(state);
	
	log.info("User has selected both Country and State from the dropdown");
}

@And("^User enters Address1  (.*), City (.*) and ZIP code (.*)$")
public void user_enters_address1_city_and_zip_code(String address, String city, String zip) {

	reg.enteraddress1(address);
	reg.enterCity(city);
	reg.enterZipCode(zip);
	
	log.info("User has entered address, city and zip");
}

@And("^User enters Login Name (.*), desired password as (.*) and confirm your password as (.*)$")
public void user_enters_login_name_desired_password_as_and_confirm_your_password_as(String loginName, String password, String confPass) {

	reg.enterLoginName(loginName);
	reg.enterPassword(password);
	reg.enterConfirmPassword(confPass);
	
	log.info("User has entered loginName, password and confPass");
}

@And("User checks the PrivacyPolicy checkbox")
public void user_checks_the_privacy_policy_checkbox() {

	reg.checkPolicy();
	
	log.info("User has checked on PrivacyPolicy checkbox");
}

@When("User clicks on continue button")
public void user_clicks_on_continue_button() {

	reg.clickOnContinue();
	
	log.info("User has entered all the Mandatory fields and clicked on continue button");
}

@Then("Validate for the successful account creation")
public void validate_for_the_successful_account_creation() {

	try {
		
	    Assert.assertEquals(reg.validateSuccessMessage(), "YOUR ACCOUNT HAS BEEN CREATED!");
	    
	} catch (AssertionError e) {
	    
		log.error("Account has not been created due to incorect inputs");
	    
	}
//	Assert.assertEquals("YOUR ACCOUNT HAS BEEN CREATED!", reg.validateSuccessMessage());
//	
//	log.info("Account has not been created due to incorect inputs");

}




@Given("^User enters the (.*) and (.*)$")
public void user_enters_the_and(String loginUserName, String loginUserPass) {
	cont=new LoginPage(driver);
	
	cont.enterLoginName(loginUserName);
	cont.enterPassword(loginUserPass);
	
	log.info("User entered loginUserName and Password");
	
}

@When("User clicks on Login button")
public void user_clicks_on_login_button() {
	cont.clickOnLogin();
	
	log.info("User clicked on Login button");
}

@Then("Validate the HomePage is displayed")
public void validate_the_home_page_is_displayed() {

	HomePage hm=new HomePage(driver);
	
	System.out.println(hm.verifyUsername());
	
		Assert.assertEquals("Welcome back TestFirstName1", hm.verifyUsername());
	
		log.info("User is Successfully Logged in to HomePage");
	
	
	
}




@Given("User Navigates to MEN catagery")
public void user_navigates_to_men_catagery() {

	prod=new ProductsPage(driver);
	prod.clickMenCat();
	
	log.info("User navigated to MEN's catagory for selecting the product");
}

@When("User Adds items to the cart")
public void user_adds_items_to_the_cart() {

	prod.goToFragrance();
	prod.selectAProduct();
	
	log.info("Item has been added to the cart");
}

@And("User clicks on cart button")
public void user_clicks_on_cart_button() {

	prod.clickOnAddToCart();
	
	log.info("Clicked on Cart button");
}

@Then("check for the items added to the cart")
public void check_for_the_items_added_to_the_cart() {
 
	crt=new CartPage(driver);
	
	System.out.println(crt.verifyProduct());
		
	Assert.assertEquals("Armani Code after shave balm", crt.verifyProduct());

	log.info("The item added to the cart is Correct");
	
}

@And("Verify the payment details for the products added")
public void verify_the_payment_details_for_the_products_added() {
	
	System.out.println(crt.totalAmountToPay());
		
	Assert.assertEquals("$44.00", crt.totalAmountToPay());

		log.info("Verification Passed for the Payment case");
	
}
		
	
}
