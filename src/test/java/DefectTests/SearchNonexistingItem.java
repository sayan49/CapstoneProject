package DefectTests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Registration.SignIn;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class SearchNonexistingItem {
	WebDriver driver;
	SignIn signIn;
	
  @Test
  public void f() throws InterruptedException {
	  
	  ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
  	ExtentReports extent = new ExtentReports();
  	extent.attachReporter(htmlReporter);
  	ExtentTest test = extent.createTest("Verifying search non existing item", "Checking search non existing item");
  	
  	
		signIn.signIn().click();
		Thread.sleep(1500);
		signIn.enterUsername().sendKeys("Pushpak123");;
		signIn.enterPassword().clear();
		Thread.sleep(1500);
		signIn.enterPassword().sendKeys("7488099532");
		Thread.sleep(1500);
		signIn.clickLogin().click();
		Thread.sleep(1500);
		
		 driver.findElement(By.xpath("//input[@name='keyword']")).click();
		 Thread.sleep(1500);
	     driver.findElement(By.xpath("//input[@name='keyword']")).sendKeys("cow");
	     Thread.sleep(1500);
	  
	     driver.findElement(By.xpath(" //input[@name='searchProducts']")).click();
	     Thread.sleep(1500);
		
	 	String errorMsg = driver.findElement(By.cssSelector("ul[class='messages'] li")).getText();
		assertEquals("This Pet not found", errorMsg);
		Thread.sleep(1500);
		driver.close();
		
		test.log(Status.INFO, "Test case is running successfully");
	  	extent.flush();
	  
  }
  @BeforeTest
  public void beforeTest() {
	  
	        
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
	   
	        signIn= new SignIn(driver);
	        
	       
  }

}
