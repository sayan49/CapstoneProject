package Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Category.Cats;
import Category.Fishs;
import CommonFiles.AddToCart;
import CommonFiles.Screenshot;
import Registration.SignIn;


public class TestOutOfStockPet {
		
		WebDriver driver;
		Fishs fish;
		Cats cats;
		SignIn signIn;
		Screenshot screenshot;
		AddToCart addtocart;
		
		
		@BeforeClass
	    public void setup() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
	        fish = new Fishs(driver);
	        cats = new Cats(driver);
	       screenshot = new Screenshot(driver);
	       signIn = new SignIn(driver);
	       addtocart = new AddToCart(driver);
	    }
		
		
		@Test
		public void addToCartTest() throws IOException, InterruptedException {
			signIn.signIn().click();
			signIn.enterUsername().sendKeys("sayan2567");;
			signIn.enterPassword().clear();
			signIn.enterPassword().sendKeys("testpassword1");
			signIn.clickLogin().click();
			cats.gotoCats().click();
			cats.gotoManx().click();
			cats.gotoTaillessManx().click();
			addtocart.addToCart();
			screenshot.fullScreenShot("fullscreen");
		}
		
	}

