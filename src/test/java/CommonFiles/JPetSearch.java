package CommonFiles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JPetSearch {

	WebDriver driver;

    public JPetSearch(WebDriver driver) {
        this.driver = driver;
    }
    
    By serchBox = By.xpath("//input[@name='keyword']");
    
    public WebElement searchResult() {
    	return driver.findElement(serchBox);
    }
}
