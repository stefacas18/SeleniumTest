package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver.TestWebDriver;

public class GeneratedPage {
	
	
	private WebDriver driver;
	private By paragraphDiv = By.id("lipsum");
	private By paragraphTag = By.tagName("p");
	private By listTag = By.tagName("ul");
	private By generatedReport = By.id("generated"); 
	
	public GeneratedPage() {
		this.driver = TestWebDriver.getDriver();
	}
	
	public WebElement getParagraphDiv(){
		return driver.findElement(paragraphDiv);
	}
	
	public WebElement getParagraphTag(){
		return driver.findElement(paragraphTag);
	}
	
	public WebElement getListTag(){
		return driver.findElement(listTag);
	}
	
	public WebElement getGeneratedReport(){
		return driver.findElement(generatedReport);
	}
	
	public List<WebElement> getGeneratedParagraphs() {
		return driver.findElement(paragraphDiv).findElements(paragraphTag);
	}
	
	public List<WebElement> getGeneratedLists() {
		return driver.findElement(paragraphDiv).findElements(listTag);
	}

}
