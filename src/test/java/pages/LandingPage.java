package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LandingPage {

    private WebDriver driver;
    
    // Locators
    @FindBy(linkText = "Login or register")
    private WebElement loginOrRegisterBT;
    
    
    public LandingPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
    
    public void clickLoginOrRegister() {
 
    	loginOrRegisterBT.click();;
    }

}
