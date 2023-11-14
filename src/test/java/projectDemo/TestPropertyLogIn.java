package projectDemo;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Registration.SignIn;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
public class TestPropertyLogIn {
	
	SignIn login;
	
	@Test
    public void Main() {
		
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	  	ExtentReports extent = new ExtentReports();
	  	extent.attachReporter(htmlReporter);
	  	ExtentTest test = extent.createTest("Verifying Login successfully done by test.properties file", "Checking Login successfully done by test.properties file");
		
        Properties properties = new Properties();
        try {
            // Load the properties from the test.properties file
            FileInputStream input = new FileInputStream("/home/ubuntu/Desktop/project/My vlab projects/CapstoneProject/test.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Extract properties for Selenium configuration
        String url = properties.getProperty("url");
        
        // Extract properties for registration form data
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        
        //open chromedriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        login = new SignIn(driver);
        
        // Navigate to the signin page
        driver.get(url);
        login.signIn().click();
        login.enterUsername().sendKeys(username);
        login.enterPassword().clear();
        login.enterPassword().sendKeys(password);
        login.clickLogin().click();
        
        //close the browser
        driver.close();
        
        test.log(Status.INFO, "Test case run successfully");
      	extent.flush();
    }
}
