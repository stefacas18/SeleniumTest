package test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import component.GeneratedReport;
import component.Paragraph;
import driver.TestWebDriver;
import helper.GeneratedHelper;
import helper.HomeHelper;

//PLEASE UPLOAD YOUR WORKING SOLUTION TO GITHUB FOR REVIEW

/* Write Selenium Webdriver automation suite that validates http://www.lipsum.com/
* 
* please implement the following tests
* Note: The names, methods, arguments, etc are only suggestions
* feel free to change the way the functionality is tested if 
* you so choose.
* 
*/ 

public class LorumIpsumDefaultTest {
	
	private HomeHelper homeHelper;
	private GeneratedHelper generatedHelper;
	
@Before
public void initializeTests(){
	// Creating instance of homePage 
	homeHelper = new HomeHelper();
	generatedHelper = new GeneratedHelper();
	TestWebDriver.goToHomePage();
}
 
 @Test 
 public void homePageTitleTest() { 
     // Fetch title
     String title = TestWebDriver.getDriver().getTitle();

     // Assert title content
     Assert.assertTrue("Incorrect title", title.equals("Lorem Ipsum - All the facts - Lipsum generator"));
 } 

 @Test 
 public void homePageHeaderTest() {
 	// Validate page header
     String header = homeHelper.getHeader();
     Assert.assertTrue(header.equals(""));
     

     // Fetch latin quote:
     String latinQuote = homeHelper.getQuote("latin");
     Assert.assertTrue("Incorrect Latin quote",latinQuote.equals("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."));

     // Fetch english quote, which is:
     String englishQuote = homeHelper.getQuote("english");
     Assert.assertTrue("Incorrect English quote",englishQuote.equals("There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..."));

 }
 

 @Test 
 public void homePageParagraphTest() {
 	// Check paragraph count
     int paragraphCount = homeHelper.getParagraphCount();
     Assert.assertTrue(paragraphCount == 5);

     // Validate "What is Lorum Ipsum?" paragraph
     Paragraph what = homeHelper.getParagraph("what");
     Assert.assertTrue("Incorrect title", what.getTitleP().equals("What is Lorem Ipsum?"));
     Assert.assertTrue( "Incorrect paragraph content", what.getContentP().startsWith("Lorem Ipsum is simply dummy text of the printing and typesetting industry"));

     // Validate Why do we use it? paragraph
     Paragraph why = homeHelper.getParagraph("why");
     Assert.assertTrue("Incorrect title", why.getTitleP().equals("Why do we use it?"));
     Assert.assertTrue("Incorrect paragraph content", why.getContentP().startsWith("It is a long established fact "));

     // Validate Where does it come from? paragraph
     Paragraph where = homeHelper.getParagraph("where");
     Assert.assertTrue("Incorrect title", where.getTitleP().equals("Where does it come from?"));
     Assert.assertTrue("Incorrect paragraph content", where.getContentP().startsWith("Contrary to popular belief, Lorem Ipsum is not simply random text."));

     // Validate Where can I get some? paragraph
     Paragraph getSome = homeHelper.getParagraph("getSome");
     Assert.assertTrue("Incorrect title", getSome.getTitleP().equals("Where can I get some?"));
     Assert.assertTrue("Incorrect paragraph content", getSome.getContentP().startsWith("There are many variations of passages of Lorem Ipsum available,"));
 }
 

 @Test
 public void generateParagraphsTest() {
     // select 'paragraphs' radio button
	 homeHelper.selectContentType("paragraphs");

     // enter '10' in the count field
	 homeHelper.inputCount("10");
     
     // click "Generate Lorum Ipsum" button
	 homeHelper.clickGenerateIpsum();

     // validate the number of text paragraphs generated
     int paragraphCount = generatedHelper.getActualGeneratedCount("paragraph");
     Assert.assertTrue("Incorrect paragraph count", paragraphCount == 10);

     // validate the report text
     // ex: "Generated 10 paragraphs, 1106 words, 7426 bytes of Lorem Ipsum"
     GeneratedReport report = generatedHelper.getReport();
     Assert.assertTrue("Incorrect paragraph count", report.getParagraphs() == 10);
 }

 @Test
 public void generateWordsTest() {
     // select 'words' radio button
	 homeHelper.selectContentType("words");

     // enter '100' in the count field
	 homeHelper.inputCount("1000");

     // click "Generate Lorum Ipsum" button
	 homeHelper.clickGenerateIpsum();

     // validate the number of words generated
     int wordCount = generatedHelper.getActualGeneratedCount("words");
     Assert.assertTrue("Incorrect word count", wordCount == 1000);

     // validate the report text
     // ex: "Generated 10 paragraphs, 1106 words, 7426 bytes of Lorem Ipsum"
     GeneratedReport report = generatedHelper.getReport();
     Assert.assertTrue("Incorrect word count", report.getWords() == 1000);
 }
 

 @Test
 public void generateBytesTest() {
     // select 'bytes' radio button
     homeHelper.selectContentType("bytes");

     // enter '3000' in the count field
     homeHelper.inputCount("3000");

     // click "Generate Lorum Ipsum" button
     homeHelper.clickGenerateIpsum();

     // validate the number of bytes generated
     int byteCount = generatedHelper.getActualGeneratedCount("bytes");
     Assert.assertTrue("Incorrect byte count",byteCount == 3000);

     // validate the report text
     // ex: "Generated 10 paragraphs, 1106 words, 7426 bytes of Lorem Ipsum"
     GeneratedReport report = generatedHelper.getReport();
     Assert.assertTrue("Incorrect reported byte count",report.getBytes() == 3000);
 }
 
 @Test
 public void generateListsTest() {
     // select 'lists' radio button
     homeHelper.selectContentType("lists");

     // enter '9' in the count field
     homeHelper.inputCount("9");

     // click "Generate Lorum Ipsum" button
     homeHelper.clickGenerateIpsum();

     // validate the number of list generated
     int listCount = generatedHelper.getActualGeneratedCount("lists");
     Assert.assertTrue("Incorrect list count",listCount == 9);

     // validate the report text
     // ex: "Generated 10 paragraphs, 1106 words, 7426 bytes of Lorem Ipsum"
     GeneratedReport report = generatedHelper.getReport();
     Assert.assertTrue("Incorrect reported list count", report.getParagraphs() == 9);
 }
 
 @Test
 public void invalidInputForParagrapshOpt(){
     GeneratedReport report = generateLorumIpsumPage("paragraphs","abc");
     // validate the report text,validate the number of paragraphs because when you type a invalid value in the input always generate 5 paragraphs
     Assert.assertTrue("Incorrect paragraph count", report.getParagraphs() == 5);
     
     TestWebDriver.goToHomePage();
     
     report = generateLorumIpsumPage("paragraphs","-100");
     // validate the report text,validate the number of paragraphs because when you type a invalid value in the input always generate 5 paragraphs
     Assert.assertTrue("Incorrect paragraph count", report.getParagraphs() == 5);
     
     TestWebDriver.goToHomePage();
     
     report = generateLorumIpsumPage("paragraphs","0");
     // validate the report text,validate the number of paragraphs because when you type a invalid value in the input always generate 5 paragraphs
     Assert.assertTrue("Incorrect paragraph count", report.getParagraphs() == 5);
 }
 
 @Test
 public void invalidInputForWordsOpt(){
     GeneratedReport report = generateLorumIpsumPage("words","abc");

     // validate the report text,validate the number of words and bytes because when you type a invalid value in the input always generate 5 word and 27 Bytes.
     Assert.assertTrue("Incorrect word count", report.getWords() == 5);
     Assert.assertTrue("Incorrect byte count", report.getBytes() == 27);
     
     TestWebDriver.goToHomePage();
     
     report = generateLorumIpsumPage("words","-100");

     // validate the report text,validate the number of words and bytes because when you type a invalid value in the input always generate 5 word and 27 Bytes.
     Assert.assertTrue("Incorrect word count", report.getWords() == 5);
     Assert.assertTrue("Incorrect byte count", report.getBytes() == 27);
     
     
     TestWebDriver.goToHomePage();
     
     report = generateLorumIpsumPage("words","-100");

     // validate the report text,validate the number of words and bytes because when you type a invalid value in the input always generate 5 word and 27 Bytes.
     Assert.assertTrue("Incorrect word count", report.getWords() == 5);
     Assert.assertTrue("Incorrect byte count", report.getBytes() == 27);
     
     TestWebDriver.goToHomePage();
     
     report = generateLorumIpsumPage("words","0");

     // validate the report text,validate the number of words and bytes because when you type a invalid value in the input always generate 5 word and 27 Bytes.
     Assert.assertTrue("Incorrect word count", report.getWords() == 5);
     Assert.assertTrue("Incorrect byte count", report.getBytes() == 27);
 }
 
 
 @Test
 public void invalidInputForBytesOpt(){
     GeneratedReport report = generateLorumIpsumPage("bytes","abc");

     // validate the report text,validate the number of words and bytes because when you type a invalid value in the input always generate 5 word and 27 Bytes.
     Assert.assertTrue("Incorrect word count", report.getWords() == 5);
     Assert.assertTrue("Incorrect byte count", report.getBytes() == 27);
     
     TestWebDriver.goToHomePage();
     
     report = generateLorumIpsumPage("bytes","-100");

     // validate the report text,validate the number of words and bytes because when you type a invalid value in the input always generate 5 word and 27 Bytes.
     Assert.assertTrue("Incorrect word count", report.getWords() == 5);
     Assert.assertTrue("Incorrect byte count", report.getBytes() == 27);
     
     TestWebDriver.goToHomePage();
     
     report = generateLorumIpsumPage("bytes","0");

     // validate the report text,validate the number of words and bytes because when you type a invalid value in the input always generate 5 word and 27 Bytes.
     Assert.assertTrue("Incorrect word count", report.getWords() == 5);
     Assert.assertTrue("Incorrect byte count", report.getBytes() == 27);
 }
 
 
 @Test
 public void invalidInputForListsOpt(){
     GeneratedReport report = generateLorumIpsumPage("lists","abc");
     
     // validate the report text,validate the number of paragraphs because when you type a invalid value in the input always generate 5 paragraphs
     Assert.assertTrue("Incorrect paragraph count", report.getParagraphs() == 5);
     
     TestWebDriver.goToHomePage();
     
     report = generateLorumIpsumPage("lists","-100");
     
     // validate the report text,validate the number of paragraphs because when you type a invalid value in the input always generate 5 paragraphs
     Assert.assertTrue("Incorrect paragraph count", report.getParagraphs() == 5);
     
     TestWebDriver.goToHomePage();
     
     report = generateLorumIpsumPage("lists","0");
     
     // validate the report text,validate the number of paragraphs because when you type a invalid value in the input always generate 5 paragraphs
     Assert.assertTrue("Incorrect paragraph count", report.getParagraphs() == 5);
 }
 
 private GeneratedReport generateLorumIpsumPage(String selectOpt, String valueInput) {
		// select a radio button option
	     homeHelper.selectContentType(selectOpt);
	     // enter value in the count field
	     homeHelper.inputCount(valueInput);
	     homeHelper.clickGenerateIpsum();
		return generatedHelper.getReport();
	}
 
 @AfterClass
 public static void endTests(){
	 TestWebDriver.getDriver().quit();
 }
 

 // write a method that validates the following "invalid" inputs for 
 // paragraph, word, bytes, and list counts:
 // '0', 'abcd', '-100'

 // can you find any bugs on this page?
 
}










