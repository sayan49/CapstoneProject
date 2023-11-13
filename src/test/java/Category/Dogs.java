package Category;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dogs {

WebDriver driver;
	
	public Dogs(WebDriver driver) {
		this.driver=driver;
	}
	
	By dog = By.xpath("//img[@src='../images/sm_dogs.gif']");
	By bulldog = By.xpath("//a[normalize-space()='K9-BD-01']");
	By Poodle = By.xpath("//a[normalize-space()='K9-PO-02']");
	By Dalmation = By.xpath("//a[normalize-space()='K9-DL-01']");
	By GoldenRetriever = By.xpath("//a[normalize-space()='K9-RT-01']");
	By LabradorRetriever = By.xpath("//a[normalize-space()='K9-RT-02']");
	By Chihuahua = By.xpath("//a[normalize-space()='K9-CW-01']");
	
	By MaleAdultBulldog = By.xpath("//a[normalize-space()='EST-6']");
	
	
	By FemalePuppyBulldog = By.xpath("//a[normalize-space()='EST-7']");
	
   
	By MalePuppyPoodle = By.xpath("//a[normalize-space()='EST-8']");
	
	By SpotlessMalePuppyDalmation = By.xpath("//a[normalize-space()='EST-9']");
	By SpottedAdultFemaleDalmation = By.xpath("//a[normalize-space()='EST-10']");
	By AdultFemaleGoldenRetriever = By.xpath("//a[normalize-space()='EST-28']");
	
	By AdultMaleLabradorRetriever = By.xpath("//a[normalize-space()='EST-22']");
	By AdultFemaleLabradorRetriever = By.xpath("//a[normalize-space()='EST-23']");
	By 	AdultMaleChihuahua = By.xpath("//a[normalize-space()='EST-26']");
	By AdultFemaleChihuahua = By.xpath("//a[normalize-space()='EST-27']");
	
	
	By AddToCartByListForGR= By.xpath("//a[normalize-space()='Add to Cart']");
	
	By  AddToCartFromCart=By.xpath("//a[normalize-space()='Add to Cart']");
	//By GoToDog=By.xpath("//img[@src='../images/sm_dogs.gif']");
	
	public WebElement gotoDog() {
		return driver.findElement(dog);
	}
	
	public WebElement gotoBulldog() {
		return driver.findElement(bulldog);
	}
	public WebElement gotoPoodle() {
		return driver.findElement(Poodle);	
	}
	public WebElement gotoDalmation() {
		return driver.findElement(Dalmation);
	}
	public WebElement gotoGoldenRetriever() {
		return driver.findElement(GoldenRetriever);
	}
	public WebElement gotoLabradorRetriever() {
		return driver.findElement(LabradorRetriever);
	}
	public WebElement gotoChihuahua() {
		return driver.findElement(Chihuahua);
	}
	public WebElement gotoMaleAdultBulldog() {
		return driver.findElement(MaleAdultBulldog);
	}
	public WebElement gotoFemalePuppyBulldog() {
		return driver.findElement(FemalePuppyBulldog);
	}
	public WebElement gotoMalePuppyPoodle() {
		return driver.findElement(MalePuppyPoodle);
	}
	public WebElement gotoSpotlessMalePuppyDalmation() {
		return driver.findElement(SpotlessMalePuppyDalmation);
	}
	public WebElement gotoSpottedAdultFemaleDalmation() {
		return driver.findElement(SpottedAdultFemaleDalmation);
	}
	public WebElement gotoAdultFemaleGoldenRetriever() {
		return driver.findElement(AdultFemaleGoldenRetriever);
	}
	public WebElement gotoAdultMaleLabradorRetriever() {
		return driver.findElement(AdultMaleLabradorRetriever);
	}
	public WebElement gotoAdultFemaleLabradorRetriever() {
		return driver.findElement(AdultFemaleLabradorRetriever);
	}
	public WebElement gotoAdultMaleChihuahua() {
		return driver.findElement(AdultMaleChihuahua);
	}
	public WebElement gotoAdultFemaleChihuahua() {
		return driver.findElement(AdultFemaleChihuahua);
	}
	public WebElement gotoAddToCartByListForGR() {
		return driver.findElement(AddToCartByListForGR);
	}
	public WebElement gotoAddToCartFromCart() {
		return driver.findElement(AddToCartFromCart);
	}

	
}
