package CommonFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateCart {

	WebDriver driver;
	public UpdateCart(WebDriver driver){
		this.driver = driver;
	}
	
//	By updateBox = By.xpath("//input[@name='EST-2']");
//	By updatebutton = By.xpath("//input[@name='updateCartQuantities']");
	
	public void updateCart() throws InterruptedException {
		WebElement box = driver.findElement(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[2]/td[5]/input"));
		box.clear();
		Thread.sleep(500);
		box.sendKeys("2");
		driver.findElement(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[3]/td[1]/input")).click();
	}
	
//	public WebElement updateButton() {
//		return driver.findElement(updatebutton);
//	}
//	
//	public WebElement updatebox() {
//		return driver.findElement(updateBox);
//	}
	
}
