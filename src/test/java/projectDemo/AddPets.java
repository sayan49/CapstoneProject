package projectDemo;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Category.Birds;
import Category.Cats;
import CommonFiles.AddToCart;
import CommonFiles.Common;
import CommonFiles.Icons;
import CommonFiles.JPetSearch;
import CommonFiles.Screenshot;
import CommonFiles.UpdateCart;
import CommonFiles.Wait;
import Registration.SignIn;

public class AddPets {
	WebDriver driver;
	SignIn signIn;
	JPetSearch search;
	Screenshot screenshot;
	Wait wait;
	AddToCart add;
	Icons icons;
	Birds birds;
	Cats cats;
	Common common;
	UpdateCart update;

	@BeforeClass
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://petstore.octoperf.com/actions/Catalog.action");
		search = new JPetSearch(driver);
		screenshot = new Screenshot(driver);
		add = new AddToCart(driver);
		signIn = new SignIn(driver);
		wait = new Wait();
		icons = new Icons(driver);
		birds = new Birds(driver);
		cats = new Cats(driver);
		common = new Common(driver);
		update = new UpdateCart(driver);
	}

	@Test
	public void addPets() throws InterruptedException, IOException {
		signIn.signIn().click();
		signIn.enterUsername().sendKeys("sayan2567");
		signIn.enterPassword().clear();
		signIn.enterPassword().sendKeys("testpassword1");
		signIn.clickLogin().click();
		wait.waits(1000);
		search.searchResult().sendKeys("Fish", Keys.ENTER);
		wait.fixWait();
		driver.findElement(By.xpath("//a[normalize-space()='Fresh Water fish from China']")).click();
		wait.waits(800);
		driver.findElement(By.xpath("//a[normalize-space()='EST-21']")).click();
		wait.waits(500);
		add.addToCart();
		wait.waits(200);
		icons.goBacktoHome().click();
		icons.gotoBirdIcon().click();
		birds.gotoAmazonParrot().click();
		birds.gotoAdultMaleAmazonParrot().click();
		add.addToCart();
		icons.goBacktoHome().click();
		icons.goBacktoHome().click();
		icons.gotoDogIcon().click();
		icons.goBacktoHome().click();
		icons.gotoFishIcon().click();
		icons.goBacktoHome().click();
		icons.gotoReptileIcon().click();
		icons.goBacktoHome().click();
		icons.gotoCatIcon().click();
		cats.gotoManx().click();
		cats.gotoTaillessManx().click();
		add.addToCart();
		update.updateCart();
		WebElement bill = driver.findElement(By.xpath("//*[@id=\"Cart\"]/form/table"));
		screenshot.elementScreenshot(bill, "aa");
	}

	@AfterMethod
	public void close() {
		
		driver.close();

	}
}