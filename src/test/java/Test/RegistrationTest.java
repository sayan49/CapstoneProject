package Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Registration.Registration;
import Registration.SignIn;



public class RegistrationTest {

	
	WebDriver driver;
    Registration registrationPage;
    SignIn signIn;

    @BeforeClass
    public void setup() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        registrationPage = new Registration(driver);
        signIn = new SignIn(driver);
    }

    @Test
    public void testUserRegistration() throws InterruptedException {
    	
    	
    	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	  	 ExtentReports extent = new ExtentReports();
	  	  extent.attachReporter(htmlReporter);
	  	  ExtentTest test = extent.createTest("Verifying user regidtration", "Checking user registration");
    	
    	signIn.signIn().click();
    	Thread.sleep(1500);
    	
    	signIn.registerNow().click();
    	Thread.sleep(1500);
    	
        registrationPage.enterUsername().sendKeys("sayan2561");
        registrationPage.enterPassword().sendKeys("testpassword1");
        registrationPage.enterRepeatPassword().sendKeys("testpassword1");
        registrationPage.enterFirstName().sendKeys("Johne");
        registrationPage.enterLastName().sendKeys("Doeo");
        registrationPage.enterEmail().sendKeys("test@example1.com");
        registrationPage.enterPhone().sendKeys("1234567898");
        registrationPage.enterAddress1().sendKeys("123 Street");
        registrationPage.enterAddress2().sendKeys("Apt 102");
        registrationPage.enterCity().sendKeys("New York city");
        registrationPage.enterState().sendKeys("NY");
        registrationPage.enterZip().sendKeys("10002");
        registrationPage.enterCountry().sendKeys("USA");
        Thread.sleep(1500);
        registrationPage.submitRegistration().click();
        Thread.sleep(1500);
        
        driver.close();
        
        test.log(Status.INFO, "Test case run successfully");
      	extent.flush();
    }
}
