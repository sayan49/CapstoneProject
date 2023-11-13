package stepDef;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login{

	WebDriver driver;

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		driver = new ChromeDriver();
		driver.get("https://petstore.octoperf.com/actions/Account.action?signonForm=");
	}
	
	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("ank1234");
		driver.findElement(By.xpath("//input[@name='password']")).clear();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
	}

	@Then("I click the login button")
	public void i_click_the_login_button() {
		driver.findElement(By.name("signon")).click();
	}
}
