package Test;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import CommonFiles.Screenshot;
import Registration.MyAccount;
import Registration.SignIn;
import Registration.SignOut;

public class MyAccountTest {
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
	  
	  
	  
	  ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	  	 ExtentReports extent = new ExtentReports();
	  	  extent.attachReporter(htmlReporter);
	  	  ExtentTest test = extent.createTest("Verifying My account data working test", "Checking My account data working test");
	  
	  signEdit.signIn().click();
	  Thread.sleep(1500);
	  signEdit.enterUsername().sendKeys("Pushpak123");
	  signEdit.enterPassword().clear();
	  Thread.sleep(1500);
	  signEdit.enterPassword().sendKeys("7488099532");
	  signEdit.clickLogin().click();
	  Thread.sleep(1500);
	  
	  editAccount.gotoMyAccount().click();
	  Thread.sleep(1500);
	  editAccount.changePassword().sendKeys("12345");
	  editAccount.resetPassword().sendKeys("12345");
	  //editAccount.changeFirstName().click();
	  editAccount.changeFirstName().clear();
	  editAccount.changeFirstName().sendKeys("sayan");
	  editAccount.changeLastName().clear();
	  editAccount.changeLastName().sendKeys("king");
	  editAccount.changeEmail().clear();
	  editAccount.changeEmail().sendKeys("akashkrrsingh5862@gmail.com");
	  editAccount.changePhone().clear();
	  editAccount.changePhone().sendKeys("9934740465");
	  editAccount.changeAddress1().clear();
	  editAccount.changeAddress1().sendKeys("Itc");
	  editAccount.changeAddress2().clear();
	  editAccount.changeAddress2().sendKeys("cox town");
	  editAccount.changeCity().clear();
	  editAccount.changeCity().sendKeys("Bengaluru");
	  editAccount.changeState().clear();
	  editAccount.changeState().sendKeys("karnataka");
	  editAccount.changeCountry().clear();
	  editAccount.changeCountry().sendKeys("india");
	  editAccount.changeZip().clear();
	  editAccount.changeZip().sendKeys("560002");
	  Thread.sleep(1500);
	  
	  editAccount.changeLanguagePreference().click();
	  
	  editAccount.changeFavouriteCategory().click();

	  editAccount.changeSave().click();
	  
	  Thread.sleep(1500);
	  nowLogout.signOut().click();
	  Thread.sleep(1500);
	  signEdit.signIn().click();
	  signEdit.enterUsername().sendKeys("Pushpak123");
	  
	  signEdit.enterPassword().clear();
	  Thread.sleep(1500);
	  signEdit.enterPassword().sendKeys("12345");
	  signEdit.clickLogin().click();
	  
	  
		String errorMsg = driver.findElement(By.cssSelector("ul[class='messages'] li")).getText();
		System.out.println(errorMsg);
		//Validate/check
		if(errorMsg.contains("Invalid username or password. Signon failed."))
		{
			System.out.println("Login is unsuccessfull");
		}
		else
			System.out.println("Login is successful");
		//continue the logic
		
		driver.close();
		
		test.log(Status.INFO, "Test case is not running successfully");
	  	extent.flush();
		
	}
	  
	  
	  
	  
	  
	  
	  
}
