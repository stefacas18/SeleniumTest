package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver.TestWebDriver;

public class HomePage {
	
	private WebDriver driver;
	private By generateLorumIpsum = By.id("generate");
	private By latinQuote = By.tagName("h4");
	private By englishQuote = By.tagName("h5");
	private By paragraphTag = By.tagName("p");
	private By leftColumn = By.className("lc");
	private By rightColumn = By.className("rc");
	private By amount = By.id("amount");
	private By headerLeft = By.id("HdrLeft"); 

	public HomePage(){
		driver = TestWebDriver.getDriver();
	}

	public WebElement getGenerateLorumIpsum(){
		return driver.findElement(generateLorumIpsum);
	}
	
	public WebElement getLatinQuote(){
		return driver.findElement(latinQuote);
	}
	
	public WebElement getEnglishQuote(){
		return driver.findElement(englishQuote);
	}
	
	public WebElement getParagraphTag(){
		return driver.findElement(paragraphTag);
	}
	
	public List<WebElement> getLeftColumns(){
		return driver.findElements(leftColumn);
	}
	
	public List<WebElement> getRightColumns(){
		return driver.findElements(rightColumn);
	}
	
	public WebElement getAmountField(){
		return driver.findElement(amount);
	}

	public WebElement getHeaderLeft(){
		return driver.findElement(headerLeft);
	}
	

}
