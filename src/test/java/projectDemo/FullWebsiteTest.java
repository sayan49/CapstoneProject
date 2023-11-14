package projectDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import Category.Birds;
import Category.Cats;
import Category.Dogs;
import Category.Fishs;
import Category.Reptiles;
import CommonFiles.AddToCart;
import CommonFiles.Common;

import CommonFiles.Screenshot;
import CommonFiles.Transaction;
import CommonFiles.UpdateCart;
import Registration.Registration;
import Registration.SignIn;
import Registration.SignOut;

public class FullWebsiteTest {

	WebDriver driver;
	Common common;
	Registration registration;
	SignIn signIn;
	SignOut signOut;
	Birds birds;
	Cats cats;
	Dogs dogs;
	Fishs fishs;
	Reptiles reptiles;
	Screenshot screenshot;
	UpdateCart updatecart;
	Screenshot invoice;
	Transaction transaction;
	AddToCart add;
	
	
	@BeforeClass
    public void setup() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        common = new Common(driver);
        registration = new Registration(driver);
        signIn = new SignIn(driver);
        signOut = new SignOut(driver);
        birds = new Birds(driver);
        cats = new Cats(driver);
        dogs = new Dogs(driver);
        fishs = new Fishs(driver);
        reptiles = new Reptiles(driver);
        screenshot = new Screenshot(driver);
        updatecart = new UpdateCart(driver);
        invoice = new Screenshot(driver);
        transaction = new Transaction(driver);
        add = new AddToCart(driver);
    }
	
	
	@Test
	public void addToCartTest() throws WebDriverException, IOException, InterruptedException {
		
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	  	ExtentReports extent = new ExtentReports();
	  	extent.attachReporter(htmlReporter);
	  	ExtentTest test = extent.createTest("Verifying Full website test", "Checking Full website test");
		
		//create a account on JPetStore website
		signIn.signIn().click();
		test.log(Status.INFO, "Sign button clicked");
		Thread.sleep(1000);
		signIn.registerNow().click();
		test.log(Status.INFO, "Register now button clicked");
		Thread.sleep(1000);
		registration.enterUsername().sendKeys("sayankljhgf900h");
		registration.enterPassword().sendKeys("testpassword1");
		registration.enterRepeatPassword().sendKeys("testpassword1");
		registration.enterFirstName().sendKeys("Johne");
		registration.enterLastName().sendKeys("Doeo");
		registration.enterEmail().sendKeys("test@example1.com");
        registration.enterPhone().sendKeys("1234567898");
        registration.enterAddress1().sendKeys("123 Street");
        registration.enterAddress2().sendKeys("Apt 102");
        registration.enterCity().sendKeys("New York city");
        registration.enterState().sendKeys("NY");
        registration.enterZip().sendKeys("10002");
        registration.enterCountry().sendKeys("USA");
        registration.submitRegistration().click();
        test.log(Status.INFO, "New registration successful");
        Thread.sleep(1000);
        
        
		//Signin to the JPetStore website
		signIn.signIn().click();
		test.log(Status.INFO, "Signin button clicked");
		signIn.enterUsername().sendKeys("sayankjhgf59000h");;
		signIn.enterPassword().clear();
		signIn.enterPassword().sendKeys("testpassword1");
		signIn.clickLogin().click();
		test.log(Status.INFO, "Login successful");
		Thread.sleep(1000);
		
		//add fish items
		fishs.gotoFish().click();
		fishs.gotoGoldfish().click();
		fishs.gotoViewAdultFemaleGoldfish().click();
		
		add.addToCart();
		updatecart.updateCart();
		dogs.gotoDog().click();
		dogs.gotoDalmation().click();
		dogs.gotoSpottedAdultFemaleDalmation().click();
		add.addToCart();
		test.log(Status.INFO, "Fish added to cart");
		Thread.sleep(1000);
		
		//add dog item
		dogs.gotoDog().click();
		dogs.gotoBulldog().click();
		dogs.gotoFemalePuppyBulldog().click();
		add.addToCart();
		test.log(Status.INFO, "Dog added to cart");
		Thread.sleep(1000);
		
		//add cat 
		cats.gotoCats().click();
		cats.gotoPersian().click();
		cats.gotoAdultMalePersian().click();
		add.addToCart();
		test.log(Status.INFO, "Cat added to cart");
		Thread.sleep(1000);
		
		//add reptiles
		reptiles.gotoReptile().click();
		reptiles.gotoRattleSnake().click();
		reptiles.gotoVenomlessRattleSnake().click();
		add.addToCart();
		test.log(Status.INFO, "Reptiles added to cart");
		Thread.sleep(1000);
		
		//add birds
		birds.gotoBird().click();
		birds.gotoAmazonParrot().click();
		birds.gotoAdultMaleAmazonParrot().click();
		add.addToCart();
		test.log(Status.INFO, "Bird added to cart");
		Thread.sleep(1000);

		
		//proceed to checkout
		common.proceedToCheckout().click();
		test.log(Status.INFO, "Proceed to checkout button clicked");
		Thread.sleep(1000);
		
		//Transaction details chech
		transaction.transaction();
		test.log(Status.INFO, "Transaction details change");
		Thread.sleep(1000);
		
		//continue button click
		common.continueButton().click();
		test.log(Status.INFO, "Continue button clicked");
		Thread.sleep(1000);
		
		//confirm button click
		common.confirmButton().click();
		test.log(Status.INFO, "confirm button clicked");
		Thread.sleep(1000);
		
		//take screenshot
		screenshot.fullScreenShot("invoice");
		test.log(Status.INFO, "Screenshot taken sucessfully");
		Thread.sleep(1000);
		
		//click on signout button
		signOut.signOut().click();
		test.log(Status.INFO, "Signout successfully");
		Thread.sleep(1000);
		
		//Close the browser
		driver.close();
		test.log(Status.INFO, "Close the browser sucessfully");
		
		
		test.log(Status.INFO, "Test case run successfully");
    	extent.flush();
    	
	}
	

	
}
