package Registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccount {
WebDriver driver;
	
	public MyAccount(WebDriver driver) {
		this.driver=driver;
	}
//	   By usernameField = By.name("username");
//	    By passwordField = By.name("password");
//	    By loginButton = By.name("signon");
//	    By BackHome = By.linkText("Return to Main Menu");
	    //By signin = By.xpath("//a[normalize-space()='Sign In']");
	    //By register = By.xpath("//a[normalize-space()='Register Now!']");
	    
	    By Account=By.xpath("//a[normalize-space()='My Account']");
	    By NewPassword = By.xpath("//input[@name='password']");
	    By ResetPassword=By.xpath("//input[@name='repeatedPassword']");
	    By FirstName= By.xpath("//input[@name='account.firstName']");
	    By LastName= By.xpath("//input[@name='account.lastName']");
	    By Email= By.xpath("//input[@name='account.email']");
	    By Phone=By.xpath("//input[@name='account.phone']");
	    By Address1=By.xpath("//input[@name='account.address1']");
	    By Address2=By.xpath("//input[@name='account.address2']");
	    By City = By.xpath("//input[@name='account.city']");
	    By State=By.xpath("//input[@name='account.state']");
	    By Zip=By.xpath("//input[@name='account.zip']");
	    By Country=By.xpath("//input[@name='account.country']");
	    By LanguagePreference=By.xpath("//select[@name='account.languagePreference']");
	    By FavouriteCategory=By.xpath("//select[@name='account.favouriteCategoryId']");

	    By Save=By.xpath("//input[@name='editAccount']");
	    
	    public WebElement gotoMyAccount() {
			return driver.findElement(Account);
		}
	    
	    public WebElement changePassword() {
			return driver.findElement(NewPassword);
	    }
	    public WebElement resetPassword() {
			return driver.findElement(ResetPassword);
	    }
	    public WebElement changeFirstName() {
			return driver.findElement(FirstName);
	    }
	    public WebElement changeLastName() {
			return driver.findElement(LastName);
	    }
	    public WebElement changeEmail() {
			return driver.findElement(Email);
	    }
	    public WebElement changePhone() {
			return driver.findElement(Phone);
	    }
	    public WebElement changeAddress1() {
			return driver.findElement(Address1);
	    }
	    public WebElement changeAddress2() {
			return driver.findElement(Address2);
	    }
	    public WebElement changeCity() {
			return driver.findElement(City);
	    }
	    public WebElement changeState() {
			return driver.findElement(State);
	    }
	    public WebElement changeZip() {
			return driver.findElement(Zip);
	    }
	    public WebElement changeCountry() {
			return driver.findElement(Country);
	    }
	    public WebElement changeLanguagePreference() {
			return driver.findElement(LanguagePreference);
	    }
	    
	    public WebElement changeFavouriteCategory() {
			return driver.findElement(FavouriteCategory);
	    }

	    public WebElement changeSave() {
			return driver.findElement(Save);
	    }
			
		
	    

}
