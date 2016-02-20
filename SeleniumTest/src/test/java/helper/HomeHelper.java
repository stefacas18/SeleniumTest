package helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import component.Paragraph;
import driver.TestWebDriver;
import page.HomePage;

public class HomeHelper {
	
	private HomePage homePage;
	private WebDriver driver;
	
	public HomeHelper (){
		homePage = new HomePage();
		driver = TestWebDriver.getDriver();
	}
	
	public String getHeader() {
		return homePage.getHeaderLeft().getText();
	}

	public String getQuote(String lenguageQuote) {
		String quote = "";
		if (lenguageQuote.equalsIgnoreCase("latin")){
			quote = (homePage.getLatinQuote().getText()).replaceAll("\"", "");
		} else if (lenguageQuote.equalsIgnoreCase("english")) {
			quote = (homePage.getEnglishQuote().getText()).replaceAll("\"", "");
		}
		return quote;
	}

	public int getParagraphCount() {
		int countParagraph = 0;
		List<WebElement> lc = homePage.getLeftColumns();
		for (WebElement webElement : lc) {
			countParagraph+= webElement.findElements(By.tagName("p")).size();
		}
		List<WebElement> rc = homePage.getRightColumns();
		for (WebElement webElement : rc) {
			countParagraph+= webElement.findElements(By.tagName("p")).size();
		}
		return countParagraph;
		
	}

	public Paragraph getParagraph(String idParagraph) {
		idParagraph = idParagraph.toLowerCase();
		
		Paragraph paragraph = new Paragraph();
		
		paragraph.setTitleP(driver.findElement(By.cssSelector("." + idParagraph + " span")).getAttribute("innerHTML"));
		
		WebElement parentParagraph = driver.findElement(By.className(idParagraph)).findElement(By.xpath(".."));
		paragraph.setContentP(parentParagraph.findElement(By.tagName("p")).getText());
		
		return paragraph;
	}

	public void selectContentType(String idElement) {
		if (idElement.equals("paragraphs")) {
			idElement = "paras";
		}
		driver.findElement(By.id(idElement)).click();	
	}

	public void inputCount(String value) {
		WebElement amountParagraphs = homePage.getAmountField();
		amountParagraphs.clear();
		amountParagraphs.sendKeys(value);
	}
	
	public void clickGenerateIpsum() {
		homePage.getGenerateLorumIpsum().submit();
	}
	
	


}
