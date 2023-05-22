package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"categorymenu\"]/nav/ul/li[6]/a")
	private WebElement menCat;

	@FindBy(linkText = "Fragrance Sets")
    private WebElement fragranceSection;
	
	@FindBy(xpath = "//a[@class='prdocutname' and text()='Armani Code after shave balm']")
    private WebElement armani;
	
	@FindBy(xpath = "//a[@class='cart']")
    private WebElement addToCart;
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickMenCat() {
		menCat.click();
	}
	
	public void goToFragrance() {
		fragranceSection.click();
	}
	
	public void selectAProduct() {
		armani.click();
	}
	
	public void clickOnAddToCart() {
		addToCart.click();
	}
	
	
}
