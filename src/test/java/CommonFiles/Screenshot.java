package CommonFiles;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
public class Screenshot {
	
	WebDriver driver;
	public Screenshot(WebDriver driver){
 this.driver = driver;
	}
	public void fullScreenShot(String name) throws IOException
	{
 ru.yandex.qatools.ashot.Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
 ImageIO.write(screenshot.getImage(), "jpg", new File("./screenshot/"+name+".png"));
	}
	
	public void elementScreenshot(WebElement element, String name) throws IOException {
 File srcFile = element.getScreenshotAs(OutputType.FILE);
 FileUtils.copyFile(srcFile, new File("./screenshot/"+name+".png"));
 }
}
