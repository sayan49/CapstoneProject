package Category;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cats {

	WebDriver driver;
	
	public Cats(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"QuickLinks\"]/a[4]/img") WebElement cats;
	@FindBy(xpath="//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a") WebElement manx;
	@FindBy(xpath="//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a") WebElement taillessmanx;
	@FindBy(xpath="//*[@id=\"Catalog\"]/table/tbody/tr[3]/td[1]/a") WebElement withtailmanx;
	@FindBy(xpath="//*[@id=\"Catalog\"]/table/tbody/tr[3]/td[1]/a") WebElement persian;
	@FindBy(xpath="//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a") WebElement adultfemalepersian;
	@FindBy(xpath="//*[@id=\"Catalog\"]/table/tbody/tr[3]/td[1]/a") WebElement adultmalepersian;
	@FindBy(xpath="//*[@id=\"Catalog\"]/table/tbody/tr[7]/td/a") WebElement addtocart;
	public WebElement gotoCats() {
		  return cats;
	  }
	public WebElement gotoManx() {
		  return manx;
	  }
	public WebElement gotoTaillessManx() {
		  return taillessmanx;
	  }
	public WebElement gotoWithManx() {
		  return withtailmanx;
	  }
	public WebElement gotoPersian() {
		  return persian;
	  }
	public WebElement gotoAdultFemalePersian() {
		  return adultfemalepersian;
	  }
	public WebElement gotoAdultMalePersian() {
		  return adultmalepersian;
	  }
	public WebElement gotoAddToCart() {
		  return addtocart;
	  }
	
}
