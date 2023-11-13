package DefectTests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
import CommonFiles.UpdateCart;
import Registration.Registration;
import Registration.SignIn;
import Registration.SignOut;

public class LoginAfterRegistraionWithWorngPassword {
	

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
	//Screenshot screenshot;
	UpdateCart updatecart;
	AddToCart add;
	
	@BeforeClass
    public void setup() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
   
        registration = new Registration(driver);
        signIn = new SignIn(driver);
        signOut = new SignOut(driver);
        birds = new Birds(driver);
        cats = new Cats(driver);
        dogs = new Dogs(driver);
        fishs = new Fishs(driver);
        reptiles = new Reptiles(driver);
        //screenshot = new Screenshot();
        updatecart = new UpdateCart(driver);
        common = new Common(driver);
        add = new AddToCart(driver);
    }
	
  @Test
  public void f() throws InterruptedException {
	  
	  ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
  	ExtentReports extent = new ExtentReports();
  	extent.attachReporter(htmlReporter);
  	ExtentTest test = extent.createTest("Verifying Login After Registraion With Worng Password", "Checking Login After Registraion With Worng Password");
	  
		signIn.signIn().click();
		Thread.sleep(1500);
		signIn.registerNow().click();
		Thread.sleep(1500);
		registration.enterUsername().sendKeys("sayankh200b005200g00");
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
	
		
	  

		//Signin to the JPetStore website
        Thread.sleep(1500);
		signIn.signIn().click();
		signIn.enterUsername().sendKeys("sayank200b005200g00");;
		signIn.enterPassword().clear();
		Thread.sleep(1500);
		signIn.enterPassword().sendKeys("12345hsdg");
		Thread.sleep(1500);
		signIn.clickLogin().click();
		Thread.sleep(1500);
		
		
		//take a screenshot to verify
		
		Thread.sleep(1500);
		//add fish items
		fishs.gotoFish().click();
		fishs.gotoAngelfish().click();
		fishs.gotoviewSmallAngelfish().click();
		add.addToCart();
		
		//add dog item
		Thread.sleep(1500);
		dogs.gotoDog().click();
		dogs.gotoBulldog().click();
		dogs.gotoFemalePuppyBulldog().click();
		add.addToCart();
		fishs.gotoFish().click();
		fishs.gotoGoldfish().click();
		fishs.gotoViewAdultFemaleGoldfish().click();
		
		add.addToCart();
		updatecart.updateCart();
		dogs.gotoDog().click();
		dogs.gotoDalmation().click();
		dogs.gotoSpottedAdultFemaleDalmation().click();
		add.addToCart();
		
		//add cat 
		Thread.sleep(1500);
		cats.gotoCats().click();
		cats.gotoPersian().click();
		cats.gotoAdultMalePersian().click();
		add.addToCart();
		
		//add reptiles
		Thread.sleep(1500);
		reptiles.gotoReptile().click();
		reptiles.gotoRattleSnake().click();
		reptiles.gotoVenomlessRattleSnake().click();
		add.addToCart();
		
		//add birds
//		Thread.sleep(1500);
//		birds.gotoBird().click();
//		birds.gotoAmazonParrot().click();
//		birds.gotoAdultMaleAmazonParrot().click();
//		add.addToCart();
//		
////		Thread.sleep(1500);
////		driver.findElement(By.xpath("//input[@name='EST-2']")).clear();
////		driver.findElement(By.xpath("//input[@name='EST-2']")).sendKeys("4");
////		
//		Thread.sleep(1500);
		//updatecart.updateCart();
//		
	
		//proceed to checkout
		common.proceedToCheckout().click();
		
		//take a screenshot
		
		String errorMsg = driver.findElement(By.cssSelector("ul[class='messages'] li")).getText();
		assertEquals("You must sign on before attempting to check out. Please sign on and try checking out again.", errorMsg);
		Thread.sleep(1500);
		driver.close();
	  
		test.log(Status.FAIL, "Test case is not running successfully");
	  	extent.flush();
	  
  }
}
