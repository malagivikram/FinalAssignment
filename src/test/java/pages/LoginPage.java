package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
    
    // Locators
    @FindBy(xpath = "//button[@title='Continue']")
    private WebElement continueBtn;
    
    @FindBy(xpath = "//button[@title='Login']")
    private WebElement loginBtn;
    
    @FindBy(id = "loginFrm_loginname")
    private WebElement loginName;
    
    @FindBy(id = "loginFrm_password")
    private WebElement password;
    
    
    public LoginPage(WebDriver driver) {
   
        PageFactory.initElements(driver, this);
    }
    
    public void clickOnContinue() {
 
    	continueBtn.click();;
    }
    
    public void clickOnLogin() {
    	 
    	loginBtn.click();;
    }
    
    public void enterLoginName(String loginname ) {
   	 
    	loginName.sendKeys(loginname);
    }
    
    public void enterPassword(String pass ) {
      	 
    	password.sendKeys(pass);
    }
}
