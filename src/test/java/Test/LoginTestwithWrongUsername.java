package Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import CommonFiles.Common;
import Registration.Registration;
import Registration.SignIn;

public class LoginTestwithWrongUsername {
	
	WebDriver driver;
	Common common;
	
	SignIn signIn;
	
	@BeforeTest
 public void setup() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
   
        signIn= new SignIn(driver);
	}
  @Test
  public void f() throws InterruptedException {

	  
	  ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	  	 ExtentReports extent = new ExtentReports();
	  	  extent.attachReporter(htmlReporter);
	  	  ExtentTest test = extent.createTest("Verifying Logging Test with Wrong Username", "Checking Logging Test with Wrong Username");
	  
		signIn.signIn().click();
		Thread.sleep(1500);
		signIn.enterUsername().sendKeys("sayanstar2567");;
		signIn.enterPassword().clear();
		Thread.sleep(1500);
		signIn.enterPassword().sendKeys("testpassword");
		Thread.sleep(1500);
		signIn.clickLogin().click();
		Thread.sleep(1500);
		
		String errorMsg = driver.findElement(By.cssSelector("ul[class='messages'] li")).getText();
		AssertJUnit.assertEquals("Invalid username or password. Signon failed.", errorMsg);
		
		Thread.sleep(1500);
		
		driver.close();
		
		test.log(Status.INFO, "Test case run successfully");
	  	extent.flush();
	  
	  
  }
  @AfterTest
  public void afterTest() {
	driver.close();
  }
}

