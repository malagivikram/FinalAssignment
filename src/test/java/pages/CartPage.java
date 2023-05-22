package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[@class='top nobackground']//parent::li[@class='dropdown']")
	private WebElement cart;
	
	@FindBy(xpath = "//a[contains(text(),'Armani')]//parent::td[@class='align_left']")
	private WebElement product;

	@FindBy(xpath = "//span[@class='bold totalamout']")
    private WebElement totalAmount;
	
	@FindBy(id = "cart_checkout2")
    private WebElement checkout;
	
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnCart() {
		cart.click();
	}
	
	public String verifyProduct() {
		return product.getText();
	}
	
	public String totalAmountToPay() {
		return totalAmount.getText();
	}
	
	public void clickOnCheckout() {
		checkout.click();
	}
	
}
