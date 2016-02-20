package helper;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;

import component.GeneratedReport;
import page.GeneratedPage;

public class GeneratedHelper {
	
	private GeneratedPage generatedPage;
	
	public GeneratedHelper (){
		generatedPage = new GeneratedPage();
	}
	
	public int getActualGeneratedCount(String countIndex){
		if (countIndex.equals("paragraph")) {
			return getActualGeneratedParagraphCount();
		} else if (countIndex.equals("words")){
			return getActualGeneratedWordsCount();
		} else if (countIndex.equals("bytes")) {
			return getActualGeneratedBytesCount();
		} else if (countIndex.equals("lists")) {
			return getActualGeneratedListsCount();
		}
		return 0;
	}

	public int getActualGeneratedParagraphCount() {
		return generatedPage.getGeneratedParagraphs().size();
	}

	public int getActualGeneratedWordsCount() {
		int countWords = 0;
		for (WebElement paragraph : generatedPage.getGeneratedParagraphs()) {
			String[] text = (paragraph.getText()).split(" ");
			countWords += text.length;
		}
		return countWords;
	}
	
	public int getActualGeneratedBytesCount() {
		int countBytes = 0;
		for (WebElement paragraph : generatedPage.getGeneratedParagraphs()) {
			countBytes += (paragraph.getText()).getBytes().length;
		}
		return countBytes;
	}
	
	public int getActualGeneratedListsCount() {
		return generatedPage.getGeneratedLists().size();
	}


	public GeneratedReport getReport() {
		WebElement elementReport = generatedPage.getGeneratedReport();
		GeneratedReport generatedReport = new GeneratedReport();
		String text = elementReport.getText();
		String[] parts = text.split(",");
		
		generatedReport.setParagraphs(findCount(parts[0]));
		generatedReport.setBytes(findCount(parts[2]));
		generatedReport.setWords(findCount(parts[1]));
		return generatedReport;
	}
	
	private int findCount(String string){
		String[] split = string.split(" ");
		for (String piece : split) {
			if (StringUtils.isNumeric(piece.trim())) {
				return Integer.parseInt(piece);
			}
		}
		return 0;
	}

}
