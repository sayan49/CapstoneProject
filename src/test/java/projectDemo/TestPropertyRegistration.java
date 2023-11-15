package projectDemo;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import CommonFiles.Wait;
import Registration.Registration;
import Registration.SignIn;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class TestPropertyRegistration {
	//Creating Objects
	SignIn login;
	Registration registrationPage;
	Wait wait;
	@Test
    public void Main() throws IOException, InterruptedException {
	
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	  	ExtentReports extent = new ExtentReports();
	  	extent.attachReporter(htmlReporter);
	  	ExtentTest test = extent.createTest("Verifying Registration successfully done by test.properties file", "Checking Registration successfully done by test.properties file");
		
        Properties properties = new Properties();
        
        // Load the properties from the test.properties file
        FileInputStream input = new FileInputStream("/home/ubuntu/git/CapstoneProject/test.properties");
        properties.load(input);
        
        // Extract properties for Selenium configuration
        String url = properties.getProperty("url");
        String browser = properties.getProperty("browser");
        
        // Extract properties for registration form data
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String repeatPassword = properties.getProperty("repeatPassword");
        String firstName = properties.getProperty("firstName");
        String lastName = properties.getProperty("lastName");
        String email = properties.getProperty("email");
        String phone = properties.getProperty("phone");
        String address1 = properties.getProperty("address1");
        String address2 = properties.getProperty("address2");
        String city = properties.getProperty("city");
        String state = properties.getProperty("state");
        String zip = properties.getProperty("zip");
        String country = properties.getProperty("country");
        
        // Set up WebDriver based on Selenium configuration
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        login = new SignIn(driver);
        wait = new Wait();
        registrationPage = new Registration(driver);
        login.signIn().click();
        login.registerNow().click();
        
        // Fill out the registration form
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        wait.waits(1000);
        driver.findElement(By.name("repeatedPassword")).sendKeys(repeatPassword);
        driver.findElement(By.name("account.firstName")).sendKeys(firstName);
        driver.findElement(By.name("account.lastName")).sendKeys(lastName);
        wait.waits(1000);
        driver.findElement(By.name("account.email")).sendKeys(email);
        driver.findElement(By.name("account.phone")).sendKeys(phone);
        driver.findElement(By.name("account.address1")).sendKeys(address1);
        driver.findElement(By.name("account.address2")).sendKeys(address2);
        driver.findElement(By.name("account.city")).sendKeys(city);
        driver.findElement(By.name("account.state")).sendKeys(state);
        driver.findElement(By.name("account.zip")).sendKeys(zip);
        driver.findElement(By.name("account.country")).sendKeys(country);
        wait.waits(1000);
        registrationPage.submitRegistration().click();
        
        // Perform other actions, submit the form, and verify results as needed
        // Close the WebDriver
        driver.close();
        test.log(Status.INFO, "Test case run successfully");
      	extent.flush();
    }
}