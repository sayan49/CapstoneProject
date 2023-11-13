package Category;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Fishs {

	
WebDriver driver;
	
	public Fishs(WebDriver driver) {
		this.driver=driver;
	}
	
	By fish = By.xpath("//img[@src='../images/sm_fish.gif']");
	By Angelfish = By.xpath("//a[normalize-space()='FI-SW-01']");
	By TigerShark = By.xpath("//a[normalize-space()='FI-SW-02']");
	By Koi = By.xpath("//a[normalize-space()='FI-FW-01']");
	By Goldfish = By.xpath("//a[normalize-space()='FI-FW-02']");
	By gotoFish = By.xpath("//a[normalize-space()='Return to FISH']");
	
	By viewLargeAngelfish = By.xpath("//a[normalize-space()='EST-1']");
	By viewSmallAngelfish = By.xpath("//a[normalize-space()='EST-2']");
	
	By viewToothlessTigerShark = By.xpath("//a[normalize-space()='EST-3']");
	
	By viewSpottedKoi = By.xpath("//a[normalize-space()='EST-4']");
	By viewSpotlessKoi = By.xpath("//a[normalize-space()='EST-5']");
	
	By viewAdultMaleGoldfish = By.xpath("//a[normalize-space()='EST-20']");
	By viewAdultFemaleGoldfish = By.xpath("//a[normalize-space()='EST-21']");
	
//	By proceedToCheckout = By.xpath("//a[normalize-space()='Proceed to Checkout']");
//	
//	By continueAfterCheckout = By.xpath("//input[@name='newOrder']");
//	By confirm = By.xpath("//a[normalize-space()='Confirm']");
//	
//	By addToCart = By.xpath("//a[normalize-space()='Add to Cart']");
	
	//By backToAngelfish = By.xpath("//a[normalize-space()='Return to FI-SW-01']");
	
	public WebElement gotoFish() {
		return driver.findElement(fish);
	}
	
	public WebElement gotoAngelfish() {
		return driver.findElement(Angelfish);
	}
	
	public WebElement gotoTigerShark() {
		return driver.findElement(TigerShark);
	}
	
	public WebElement gotoKoi() {
		return driver.findElement(Koi);
	}
	
	public WebElement gotoGoldfish() {
		return driver.findElement(Goldfish);
	}
	
	public WebElement gotoFishList() {
		return driver.findElement(gotoFish);
	}
	
	public WebElement gotoviewLargeAngelfish() {
		return driver.findElement(viewLargeAngelfish);
	}
	
	public WebElement gotoviewSmallAngelfish() {
		return driver.findElement(viewSmallAngelfish);
	}
	
//	public WebElement gotoaddToCart() {
//		return driver.findElement(addToCart);
//	}
	
	public WebElement gotoViewToothlessTigerShark() {
		return driver.findElement(viewToothlessTigerShark);
	}
	
	public WebElement gotoViewSpottedKoi() {
		return driver.findElement(viewSpottedKoi);
	}
	
	public WebElement gotoViewSpotlessKoi() {
		return driver.findElement(viewSpotlessKoi);
	}
	
	public WebElement gotoViewAdultMaleGoldfish() {
		return driver.findElement(viewAdultMaleGoldfish);
	}
	
	public WebElement gotoViewAdultFemaleGoldfish() {
		return driver.findElement(viewAdultFemaleGoldfish);
	}
	
//	public WebElement gotoProceedToCheckout() {
//		return driver.findElement(proceedToCheckout);
//	}
//	
//	public WebElement gotoContinueAfterCheckout() {
//		return driver.findElement(continueAfterCheckout);
//	}
//	
//	public WebElement gotoConfirm() {
//		return driver.findElement(confirm);
//	}
}
