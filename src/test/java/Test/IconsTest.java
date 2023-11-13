package Test;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import CommonFiles.Icons;
import Registration.SignIn;

public class IconsTest {
	
	WebDriver driver;
	Icons icons;
	SignIn signIn;
	
	@BeforeMethod
	public void invokeBrowser()
	{
		
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
       icons = new Icons(driver);
       signIn=new SignIn(driver);
	}
	
  @Test
  public void f() {
	  
	  signIn.signIn().click();
		signIn.enterUsername().sendKeys("Pushpak123");;
		signIn.enterPassword().clear();
		signIn.enterPassword().sendKeys("7488099532");
		signIn.clickLogin().click();
	  
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
	  
	  //close browser
	  
	  driver.close();
	  
  }
}
