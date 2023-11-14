package Registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn {

	WebDriver driver;

    public SignIn(WebDriver driver) {
        this.driver = driver;
    }

    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.name("signon");
    By BackHome = By.linkText("Return to Main Menu");
    By signin = By.xpath("//a[normalize-space()='Sign In']");
    By register = By.xpath("//a[normalize-space()='Register Now!']");
    
    public WebElement enterUsername() {
        return driver.findElement(usernameField);
    }

    public WebElement enterPassword() {
    	
        return driver.findElement(passwordField);
    }

    public WebElement clickLogin() {
        return driver.findElement(loginButton);
    }
    
    public WebElement signIn() {
    	return driver.findElement(signin);
    }
    
    public WebElement registerNow() {
    	return driver.findElement(register);
    }
    
    public WebElement Home() {
    	return driver.findElement(BackHome);
    }
	
	
}
