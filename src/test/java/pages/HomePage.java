package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//div[contains(text(),'Welcome back')]")
	private WebElement userNameDisplay;

	public HomePage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}

	public String verifyUsername() {
		return userNameDisplay.getText();
	}

}
