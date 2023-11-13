package CommonFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Icons{
	

	WebDriver driver;
	
	public Icons(WebDriver driver) {
		this.driver=driver;
	}
	//go to dog
	By dogIcon=By.xpath("//area[@alt='Dogs']");
	By catIcon=By.xpath("//area[@alt='Cats']");
	By reptileIcon=By.xpath("//area[@alt='Reptiles']");
	By birdIcon=By.xpath("//area[6]");
	By fishIcon=By.xpath("//area[@alt='Fish']");
	
	By homeFromIcons=By.xpath("//img[@src='../images/logo-topbar.gif']");
	
	public WebElement gotoDogIcon() {
		return driver.findElement(dogIcon);
	}
	public WebElement gotoFishIcon() {
		return driver.findElement(fishIcon);
	}
	

	public WebElement gotoCatIcon() {
	return driver.findElement(catIcon);
}
	public WebElement gotoReptileIcon() {
		return driver.findElement(reptileIcon);
	}
	public WebElement gotoBirdIcon() {
		return driver.findElement(birdIcon);
	}
	public WebElement goBacktoHome() {
		return driver.findElement(homeFromIcons);
	}








}