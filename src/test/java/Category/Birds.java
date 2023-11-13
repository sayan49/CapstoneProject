package Category;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Birds {

	WebDriver driver;
	public Birds(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"QuickLinks\"]/a[5]/img") WebElement birds;
	@FindBy(xpath="//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a") WebElement amazonparrot;
	@FindBy(xpath="//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a") WebElement adultmaleamazonparrot;
	@FindBy(xpath="//*[@id=\"Catalog\"]/table/tbody/tr[3]/td[1]/a") WebElement finch;
	@FindBy(xpath="//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a") WebElement adultmalefinch;
	@FindBy(xpath="//*[@id=\"Catalog\"]/table/tbody/tr[7]/td/a") WebElement addtocart;
	
	
	public WebElement gotoBird() {
		  return birds;
	  }
	public WebElement gotoAmazonParrot() {
		  return amazonparrot;
	  }
	public WebElement gotoAdultMaleAmazonParrot() {
		  return adultmaleamazonparrot;
	  }
	
	public WebElement gotoFinch() {
		  return finch;
	  }
	
	public WebElement gotoAdultMaleFinch() {
		  return adultmalefinch;
	  }
	
	public WebElement addToCart() {
		  return addtocart;
	  }
	
}
