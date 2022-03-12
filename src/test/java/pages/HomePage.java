package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	//Mapeo
	@FindBy(xpath = "//a[contains(text(),'Laptops')]")
	public WebElement categoryLaptops;
	
	@FindBy(xpath = "//a[contains(text(),'MacBook Pro')]")
	public WebElement macBookProButton;
	
	@FindBy(xpath = "//a[contains(text(),'Add to cart')]")
	public WebElement addToCartButton;
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	public WebElement homeOption;

	@FindBy(xpath = "//a[contains(text(),'Phones')]")
	public WebElement categoryPhones;
	
	@FindBy(xpath = "//a[contains(text(),'Nokia lumia 1520')]")
	public WebElement nokiaLumiaButton;
	
	@FindBy(xpath = "//a[contains(text(),'Add to cart')]")
	public WebElement addToCart2Button;
	
	@FindBy(css = "#cartur")
	public WebElement cartOption;
	
	@FindBy(xpath = "//h3[@id='totalp']")
	public WebElement totalCart;
	
	@FindBy(xpath = "//button[contains(text(),'Place Order')]")
	public WebElement placeOrderButton;
	
	@FindBy(css = "#name")
	public WebElement nameOrder;
	
	@FindBy(css = "#country")
	public WebElement countryOrder;
	
	@FindBy(css = "#city")
	public WebElement cityOrder;
	
	@FindBy(xpath = "//button[contains(text(),'Purchase')]")
	public WebElement purchaseButton;
		
	@FindBy(css = "#card")
	public WebElement creditCardOrder;
	
	@FindBy(css = "#month")
	public WebElement monthOrder;
	
	@FindBy(css = "#year")
	public WebElement yearOrder;
	
	@FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary']")
	public WebElement finalOkButton;
	


}
