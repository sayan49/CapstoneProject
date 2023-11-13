package CommonFiles;

import org.openqa.selenium.WebDriver;

public class Wait {

	public void waits(int a) throws InterruptedException{
		Thread.sleep(a);
	}
	public void fixWait() throws InterruptedException{
		Thread.sleep(800);
	}
}
