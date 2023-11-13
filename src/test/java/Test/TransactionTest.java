package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import CommonFiles.AddToCart;
import CommonFiles.Common;
import CommonFiles.JPetSearch;
import CommonFiles.Screenshot;
import CommonFiles.Transaction;
import Registration.SignIn;
import Registration.SignOut;

public class TransactionTest {
	
	WebDriver driver;
	SignIn signIn;
    JPetSearch search;
    Screenshot searchresult;
    AddToCart add;
    Transaction cardDetails;
    SignOut signout;
    Common common;
    
    @BeforeClass
    public void setup() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        search = new JPetSearch(driver);
        searchresult = new Screenshot(driver);
        add = new AddToCart(driver);
        signIn = new SignIn(driver);
        cardDetails = new Transaction(driver);
        signout = new SignOut(driver);
        common = new Common(driver);
    }
    
    @Test
    public void testUserSearch() throws IOException, InterruptedException {
    	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
    	ExtentReports extent = new ExtentReports();
    	extent.attachReporter(htmlReporter);
    	ExtentTest test = extent.createTest("Verifying Transaction", "Checking Transaction");
    	
    	
    	signIn.signIn().click();
    	Thread.sleep(1500);
		signIn.enterUsername().sendKeys("sayan2567");
		signIn.enterPassword().clear();
		Thread.sleep(1500);
		signIn.enterPassword().sendKeys("testpassword1");
		Thread.sleep(1500);
		signIn.clickLogin().click();
		Thread.sleep(1500);
    	search.searchResult().sendKeys("Fish", Keys.ENTER);
    	//searchresult.screenShot();
    	driver.findElement(By.xpath("//a[normalize-space()='Fresh Water fish from China']")).click();
    	Thread.sleep(1500);
    	driver.findElement(By.xpath("//a[normalize-space()='EST-21']")).click();
    	Thread.sleep(1500);
    	add.addToCart();
    	Thread.sleep(1500);
    	//proceed to checkout
    	common.proceedToCheckout().click();
    	Thread.sleep(1500);
    	//To enter card details for Transaction
    	cardDetails.transaction();
    	Thread.sleep(1500);
    	common.continueButton().click();
    	Thread.sleep(1500);
		//confirm button click
		common.confirmButton().click();
		Thread.sleep(1500);
		//take screenshot
		
		searchresult.fullScreenShot("Transaction");
		Thread.sleep(1500);
		
		signout.signOut().click();
		Thread.sleep(1500);
		driver.close();
		
		test.log(Status.INFO, "Test case run successfully");
    	extent.flush();
	}
    	
    	

}
