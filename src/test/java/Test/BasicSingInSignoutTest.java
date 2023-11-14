package Test;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Category.Birds;
import Category.Dogs;
import Registration.SignIn;
import Registration.SignOut;

public class BasicSingInSignoutTest {
	static WebDriver driver;
	SignIn logingIn;
	SignOut loggingOut;
	Birds NavigateToBird; 
	Dogs NavigateToDogs;
	
	
 	 
 	
	@BeforeMethod
	public void invokeBrowser()
	{
		
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        logingIn = new SignIn(driver);
        loggingOut = new SignOut(driver);
        NavigateToBird=new Birds(driver);
        NavigateToDogs=new Dogs(driver);
        
        
        
	}
	
  @Test
  public void f() throws InterruptedException {
	  
	  ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
  	  ExtentReports extent = new ExtentReports();
  	  extent.attachReporter(htmlReporter);
  	  ExtentTest test = extent.createTest("Verifying Basic SingIn Signout Test", "Checking Basic SingIn Signout Test");
  	
	  
	  logingIn.signIn().click();
	  logingIn.enterUsername().sendKeys("Pushpak123");
	  logingIn.enterPassword().clear();
	  logingIn.enterPassword().sendKeys("7488099532");
	  logingIn.clickLogin().click();
	  
	  Thread.sleep(1500);
	  
	  NavigateToDogs.gotoDog().click();
	  Thread.sleep(1000);
	  NavigateToDogs.gotoChihuahua().click();
	  Thread.sleep(1000);
	  NavigateToDogs.gotoAdultFemaleChihuahua().click();
	  
	  Thread.sleep(1000);
	  
	  NavigateToBird.gotoBird().click();
	  Thread.sleep(1000);
	  NavigateToBird.gotoAmazonParrot().click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//img[@src='../images/logo-topbar.gif']")).click();
	  Thread.sleep(1000);
	  loggingOut.signOut().click();
	  Thread.sleep(1500);
	  driver.close();
	  
	  test.log(Status.INFO, "Test case run successfully");
  	  extent.flush();
  	
	  
  }
  
  
  
}
