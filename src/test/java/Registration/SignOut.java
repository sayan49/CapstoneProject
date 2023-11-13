package Registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignOut {
	
	WebDriver driver;
	 public SignOut(WebDriver driver) {
		 this.driver = driver;
	 }
	 
	 By signout = By.xpath("//a[normalize-space()='Sign Out']");
	 
	 public WebElement signOut() {
		 return driver.findElement(signout);
	 }
}
