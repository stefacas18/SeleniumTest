package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestWebDriver {
	
	public static WebDriver driver;

	/* Create firefox driver's instance */
	public static WebDriver getDriver() {
		if (driver == null){
			driver = new FirefoxDriver();
		}
		return driver;
	}
	
	/* Go to HomePage: http://www.lipsum.com/ */
	public static void goToHomePage(){
		//driver.navigate().to("http://www.lipsum.com/");
		driver.get("http://www.lipsum.com/");
	}
	
	/* Get title driver */
	public String getTitle() {
		return driver.getTitle();
	}
	


}
