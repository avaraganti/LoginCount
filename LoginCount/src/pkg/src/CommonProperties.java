package pkg.src;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonProperties extends PageLocators{
	
	/**
	 * Navigating to the URL and load the url
	 * 
	 * @param String
	 */
	static WebDriver driver;
	public void getURL(String URL) {
		
		driver.get(URL);
	}
	
public void type(WebElement Key, String value) throws Exception {
		
		if(Key.isDisplayed()) {
			Key.sendKeys(value);
		} else {
			
			throw new Exception(Key +"is not found");
		}
		
	}
	
	public void click(WebElement Key) throws Exception {
		if(Key.isDisplayed()) {
			Key.click();
		} else {
			throw new Exception(Key + "is not found");
		}
	}
	
	public String getText(WebElement Key) throws Exception {
		if(Key.isDisplayed()) {
			Key.getText();
		} else {
			throw new Exception(Key + "is not found");
		}
		
		return Key.isDisplayed() ? Key.getText() : null;
	}

}
