package CommonFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Transaction {
	WebDriver driver;
	
	
	public Transaction(WebDriver driver){
		
        this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"Catalog\"]/form/table/tbody/tr[2]/td[2]/select/option[3]") WebElement cardtype;
	@FindBy(xpath="//*[@id=\"Catalog\"]/form/table/tbody/tr[3]/td[2]/input") WebElement cardnumber;
	@FindBy(xpath="//*[@id=\"Catalog\"]/form/table/tbody/tr[4]/td[2]/input") WebElement expirydate;
	
	public void transaction() {
		
        cardtype.click();
        cardnumber.clear();
        cardnumber.sendKeys("1111 2222 3333 4444");
        expirydate.clear();
        expirydate.sendKeys("09/2023");
	}
}
