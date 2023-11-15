package projectDemo;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import CommonFiles.Wait;
import Registration.SignIn;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class TestPropertyLogIn {
	//Creating Objects
	SignIn login;
	Wait wait;
	
	@Test
    public void Main() throws IOException, InterruptedException {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	  	ExtentReports extent = new ExtentReports();
	  	extent.attachReporter(htmlReporter);
	  	ExtentTest test = extent.createTest("Verifying Login successfully done by test.properties file", "Checking Login successfully done by test.properties file");
		
        Properties properties = new Properties();
        // Load the properties from the test.properties file
        FileInputStream input = new FileInputStream("/home/ubuntu/git/CapstoneProject/test.properties");
        properties.load(input);
        // Extract properties for Selenium configuration
        String url = properties.getProperty("url");
        // Extract properties for registration form data
        String username = properties.getProperty("username");
        String password = properties.getProperty("password"); 
        //open chromedriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        login = new SignIn(driver);
        wait = new Wait();
        // Navigate to the signin page
        driver.get(url);
        login.signIn().click();
        login.enterUsername().sendKeys(username);
        wait.waits(1000);
        login.enterPassword().clear();
        login.enterPassword().sendKeys(password);
        wait.waits(1000);
        login.clickLogin().click();
        //close the browser
        driver.close();
        test.log(Status.INFO, "Test case run successfully");
      	extent.flush();
    }
}
