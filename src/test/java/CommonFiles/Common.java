package CommonFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Common {
	
	
	WebDriver driver;
	
	public Common(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By confirm = By.xpath("//a[normalize-space()='Confirm']");
	By addToCart = By.xpath("//a[normalize-space()='Add to Cart']");
	By continueAfterCheckout = By.xpath("//input[@name='newOrder']");
	By proceedToCheckout = By.xpath("//a[normalize-space()='Proceed to Checkout']");
	
	
	By remove = By.xpath("//a[normalize-space()='Remove']");
	
	public WebElement removeItem() {
		return driver.findElement(remove);
	}
	public WebElement proceedToCheckout() {
		return driver.findElement(proceedToCheckout);
	}
	
	
	public WebElement continueButton() {
		return driver.findElement(continueAfterCheckout);
	}
	

	
	public WebElement confirmButton() {
		return driver.findElement(confirm);
	}
}
