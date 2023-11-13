package Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import org.apache.commons.io.filefilter.TrueFileFilter;
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
import CommonFiles.Icons;
import CommonFiles.JPetSearch;
import CommonFiles.Screenshot;
import CommonFiles.Wait;
import Registration.SignIn;


public class AddToCartFromSearch {

	WebDriver driver;
	SignIn signIn;
    JPetSearch search;
    Screenshot searchresult;
   
    Wait wait;
    AddToCart add;
    Icons icons;
	
    
    @BeforeClass
    public void setup() throws InterruptedException {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        search = new JPetSearch(driver);
        searchresult = new Screenshot(driver);
        add = new AddToCart(driver);
        signIn = new SignIn(driver);
        wait = new Wait();
        icons = new Icons(driver);
    }
    
    @Test(priority = 0)
    public void testUserSearch() throws IOException, InterruptedException {
    	
    	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
    	ExtentReports extent = new ExtentReports();
    	extent.attachReporter(htmlReporter);
    	ExtentTest test = extent.createTest("Verifying Add to cart", "Checking the Cart");
    	
    	
    	signIn.signIn().click();
		signIn.enterUsername().sendKeys("sayan2567");
		signIn.enterPassword().clear();
		signIn.enterPassword().sendKeys("testpassword1");
		signIn.clickLogin().click();
		
		wait.waits(1000);
		
    	search.searchResult().sendKeys("Fish", Keys.ENTER);
    	
    	wait.fixWait();
    	
    	//searchresult.screenShot();
    	driver.findElement(By.xpath("//a[normalize-space()='Fresh Water fish from China']")).click();
    	
    	wait.waits(800);
    	
    	driver.findElement(By.xpath("//a[normalize-space()='EST-21']")).click();
    	
    	wait.waits(500);
    	
    	add.addToCart();
    	
    	wait.waits(200);
    	
    	//driver.close();
    	
    	test.log(Status.INFO, "Test case run successfully");
    	extent.flush();
    	
    }
    
    @Test(enabled = true)
    public void f() {
  	  
//  	  signIn.signIn().click();
//  		signIn.enterUsername().sendKeys("Pushpak123");;
//  		signIn.enterPassword().clear();
//  		signIn.enterPassword().sendKeys("7488099532");
//  		signIn.clickLogin().click();
    	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
    	ExtentReports extent = new ExtentReports();
    	extent.attachReporter(htmlReporter);
    	ExtentTest test = extent.createTest("Verifying Add to cart", "Checking the Cart");
      icons.goBacktoHome().click();
  	  icons.gotoBirdIcon().click();
  	  icons.goBacktoHome().click();
  	  
  	  icons.gotoCatIcon().click();
  	  icons.goBacktoHome().click();
  	  icons.gotoDogIcon().click();
  	  
  	  icons.goBacktoHome().click();
  	  icons.gotoFishIcon().click();
  	  icons.goBacktoHome().click();
  	  
  	  icons.gotoReptileIcon().click();
  	  icons.goBacktoHome().click();
  	  
  	test.log(Status.INFO, "Test case run successfully");
	extent.flush();
    
	
}
}
