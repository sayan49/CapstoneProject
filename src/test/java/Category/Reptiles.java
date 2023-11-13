package Category;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Reptiles {

	WebDriver driver;
	
	public Reptiles(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='../images/sm_reptiles.gif']")
	WebElement Reptile;
	@FindBy(xpath = "//a[normalize-space()='RP-SN-01']")
	WebElement Rattlesnake;
	@FindBy(xpath = "//a[normalize-space()='RP-LI-02']")
	WebElement Iguana;
	@FindBy(xpath = "//a[normalize-space()='EST-11']")
	WebElement VenomlessRattlesnake;
	@FindBy(xpath = "//a[normalize-space()='EST-12']")
	WebElement RattlelessRattlesnake;
	@FindBy(xpath = "//a[normalize-space()='EST-13']")
	WebElement GreenAdultIguana;
	@FindBy(xpath = "//a[normalize-space()='Add to Cart']")
	WebElement AddtoCart;
	
	public WebElement gotoReptile() {
		return Reptile;
	}
	
	public WebElement gotoRattleSnake() {
		return Rattlesnake;
	}
	
	public WebElement gotoIguana() {
		return Iguana;
	}
	
	public WebElement gotoVenomlessRattleSnake() {
		return VenomlessRattlesnake;
	}
	
	public WebElement gotoRattlelessRattleSnake() {
		return RattlelessRattlesnake;
	}
	
	public WebElement gotoGreenAdultIguana() {
		return GreenAdultIguana;
	}
	
//	public WebElement addtoCart() {
//		return AddtoCart;
//	}
	
}
