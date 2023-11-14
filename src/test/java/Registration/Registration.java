package Registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration {

	private WebDriver driver;

    public Registration(WebDriver driver) {
        this.driver = driver;
    }

    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By repeatPasswordField = By.name("repeatedPassword");
    By firstNameField = By.name("account.firstName");
    By lastNameField = By.name("account.lastName");
    By emailField = By.name("account.email");
    By phoneField = By.name("account.phone");
    By address1Field = By.name("account.address1");
    By address2Field = By.name("account.address2");
    By cityField = By.name("account.city");
    By stateField = By.name("account.state");
    By zipField = By.name("account.zip");
    By countryField = By.name("account.country");

    public WebElement enterUsername() {
        return driver.findElement(usernameField);
    }

    public WebElement enterPassword() {
        return driver.findElement(passwordField);
    }

    public WebElement enterRepeatPassword() {
        return driver.findElement(repeatPasswordField);
    }

    public WebElement enterFirstName() {
        return driver.findElement(firstNameField);
    }

    public WebElement enterLastName() {
        return driver.findElement(lastNameField);
    }

    public WebElement enterEmail() {
    	return driver.findElement(emailField);
    }

    public WebElement enterPhone() {
    	return driver.findElement(phoneField);
    }

    public WebElement enterAddress1() {
    	return driver.findElement(address1Field);
    }

    public WebElement enterAddress2() {
    	return driver.findElement(address2Field);
    }

    public WebElement enterCity() {
    	return driver.findElement(cityField);
    }

    public WebElement enterState() {
    	return driver.findElement(stateField);
    }

    public WebElement enterZip() {
    	return driver.findElement(zipField);
    }

    public WebElement enterCountry() {
    	return driver.findElement(countryField);
    }

    public WebElement submitRegistration() {
    	return driver.findElement(By.name("newAccount"));
    }
}
