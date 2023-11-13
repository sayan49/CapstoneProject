package CommonFiles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 public class AddToCart {
	WebDriver driver;
	public AddToCart(WebDriver driver){
 this.driver = driver;
 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"Catalog\"]/table/tbody/tr[5]/td") WebElement check;
	@FindBy(xpath="//a[normalize-space()='Add to Cart']") WebElement addtocart;
	@FindBy(xpath="//*[@id=\"Cart\"]/form/table/tbody/tr[td//text()[contains(.,'false')]]/td[8]/a") WebElement remove;
	public void addToCart() {
 String isavailable = check.getText();
 addtocart.click();
 System.out.println(isavailable);
 if(isavailable.equals("Back ordered.")) {remove.click();}
	}
}