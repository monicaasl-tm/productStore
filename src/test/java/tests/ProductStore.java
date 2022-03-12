package tests;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductStore {
	
	public String baseURL = "https://www.demoblaze.com";
	String driverPath = "/Users/monicasanchez/eclipse-workspace/ProductStore/src/test/resources/drivers/geckodriver";
	public WebDriver driver;

	
	@BeforeTest
	private void startTesting() {
		System.out.println("This is a Before Test");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver ();	
		driver.get(baseURL);
	    driver.manage().window().maximize();
	    System.out.println("Browser launched and maximized!");
	}

	@Test
	public void selectProducts() throws InterruptedException {


		//Mapeo
		HomePage home = new HomePage(this.driver);
		home.categoryLaptops.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(home.macBookProButton));
		home.macBookProButton.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(home.addToCartButton));
		home.addToCartButton.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
		driver.switchTo( ).alert( ).accept();
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(home.homeOption));
		home.homeOption.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(home.categoryPhones));
		home.categoryPhones.click();
				
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(home.nokiaLumiaButton));
		home.nokiaLumiaButton.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(home.addToCart2Button));
		home.addToCart2Button.click();

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
		driver.switchTo( ).alert( ).accept();
		
		//cart
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(home.cartOption));
		home.cartOption.click();
		
		//Validar si el total hace match
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(home.totalCart));
		Assert.assertEquals(home.totalCart.getText(), "1920");
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(home.placeOrderButton));
		home.placeOrderButton.click();

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(home.nameOrder));
		home.nameOrder.sendKeys("Monica Sanchez");
		
		home.countryOrder.sendKeys("USA");
		
		home.cityOrder.sendKeys("San Diego");
		
		home.purchaseButton.click();
		
		//Validar que se abre una ventana si no se llena formato completo
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
		String alert= driver.switchTo().alert().getText(); 
		Assert.assertNotNull(alert);
		driver.switchTo( ).alert( ).accept();
		
		home.creditCardOrder.sendKeys("67136387471498");
		
		home.monthOrder.sendKeys("March");
		
		home.yearOrder.sendKeys("2022");
		
		home.purchaseButton.click();

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(home.finalOkButton));
		
		home.finalOkButton.click();
		

	}
	
	@AfterTest
	public void terminateBrowser() {
		driver.close();
	    System.out.println("Browser closed!");
	}
	
}
