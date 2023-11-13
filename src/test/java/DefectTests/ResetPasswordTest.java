package DefectTests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Registration.MyAccount;
import Registration.SignIn;
import Registration.SignOut;

public class ResetPasswordTest {
	static WebDriver driver;
	MyAccount editAccount;
	SignIn signEdit;
	SignOut nowLogout;
	
	@BeforeMethod
	public void invokeBrowser()
	{
		
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        editAccount = new MyAccount(driver);
        signEdit = new SignIn(driver);
        nowLogout=new SignOut(driver);
	}
	
	
  @Test
  public void f() throws InterruptedException {
	  
//	  ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
//  	ExtentReports extent = new ExtentReports();
//  	extent.attachReporter(htmlReporter);
//  	ExtentTest test = extent.createTest("Verifying Reset Password Test", "Checking Reset Password Test");
	  
	  signEdit.signIn().click();
	  Thread.sleep(500);
	  signEdit.enterUsername().sendKeys("Pushpak123");
	  signEdit.enterPassword().clear();
	  Thread.sleep(500);
	  signEdit.enterPassword().sendKeys("7488099532");
	  Thread.sleep(500);
	  signEdit.clickLogin().click();
	  Thread.sleep(500);
	  
	  editAccount.gotoMyAccount().click();
	  Thread.sleep(500);
	  editAccount.changePassword().sendKeys("12345");
	  Thread.sleep(500);
	  editAccount.resetPassword().sendKeys("12345");
	  Thread.sleep(500);
	

	  editAccount.changeSave().click();
	  Thread.sleep(500);
	  
	  
	  nowLogout.signOut().click();
	  Thread.sleep(500);
	  
	  signEdit.signIn().click();
	  Thread.sleep(500);
	  signEdit.enterUsername().sendKeys("Pushpak123");
	  
	  signEdit.enterPassword().clear();
	  Thread.sleep(500);
	  signEdit.enterPassword().sendKeys("12345");
	  Thread.sleep(500);
	  signEdit.clickLogin().click();
	  Thread.sleep(500);
	  
	  String errorMsg = driver.findElement(By.xpath("//div[@id='WelcomeContent']")).getText();
		System.out.println(errorMsg);
		//Validate/check
		if(errorMsg.contains("Invalid username or password. Signon failed."))
		{
			System.out.println("Login is unsuccessfull");
		}
		else
			System.out.println("Login is successful");
		
		String errorMsg1 = driver.findElement(By.xpath("//div[@id='WelcomeContent']")).getText();
		
		
	  	assertEquals("Welcome Pushpak!", errorMsg1);
		
	}
  
  @AfterMethod
  public void report() {
	  
	  ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	  	ExtentReports extent = new ExtentReports();
	  	extent.attachReporter(htmlReporter);
	  	ExtentTest test = extent.createTest("Verifying Reset Password Test", "Checking Reset Password Test");
	    test.log(Status.FAIL, "Test case failed because password remained same even after updating.");
	  	extent.flush();
	  	driver.close();
	  	
  }
	  
	  
	  
	  
	  
	  
	  
  }

