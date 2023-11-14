package projectDemo;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
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

public class CheckAccountUpdationTest {

	static WebDriver driver;
	MyAccount editAccount;
	SignIn signEdit;
	SignOut nowLogout;
	Screenshot screenshot;

	@BeforeMethod
	public void invokeBrowser() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://petstore.octoperf.com/actions/Catalog.action");
		editAccount = new MyAccount(driver);
		signEdit = new SignIn(driver);
		nowLogout = new SignOut(driver);
		screenshot = new Screenshot(driver);
	}

	@Test
	public void f() throws InterruptedException, IOException {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("Verifying Check Account Updation Test",
				"Checking Check Account Updation Test");

		// Signin
		signEdit.signIn().click();
		Thread.sleep(500);
		signEdit.enterUsername().sendKeys("Pushpak123");
		signEdit.enterPassword().clear();
		signEdit.enterPassword().sendKeys("7488099532");
		Thread.sleep(1000);
		signEdit.clickLogin().click();

		Thread.sleep(1000);
		editAccount.gotoMyAccount().click();

		// Taking screensort before updating data
		screenshot.fullScreenShot("Before update");

		// updating my account data
		editAccount.changeFirstName().clear();
		editAccount.changeFirstName().sendKeys("sayan");
		editAccount.changeLastName().clear();
		editAccount.changeLastName().sendKeys("Bhattacharya");
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
		editAccount.changeLanguagePreference().click();
		editAccount.changeFavouriteCategory().click();
		Thread.sleep(1000);
		editAccount.changeSave().click();
		Thread.sleep(500);
		nowLogout.signOut().click();

		// logging in with the old password
		Thread.sleep(1500);
		signEdit.signIn().click();
		signEdit.enterUsername().sendKeys("Pushpak123");
		signEdit.enterPassword().clear();
		signEdit.enterPassword().sendKeys("7488099532");
		Thread.sleep(1000);
		signEdit.clickLogin().click();

		// Goto my account for checking updated data
		Thread.sleep(1000);
		editAccount.gotoMyAccount().click();
		Thread.sleep(1000);

		// take a screenshot to verify
		screenshot.fullScreenShot("After update");

		String errorMsg1 = driver.findElement(By.xpath("//input[@name='account.firstName']")).getAttribute("value");
		System.out.println(errorMsg1);

		AssertJUnit.assertEquals(errorMsg1, "sayan");

		// extend report
		test.log(Status.FAIL, "Test case fail because after update data remain same as previous");
		extent.flush();

	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
