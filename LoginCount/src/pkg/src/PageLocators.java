package pkg.src;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageLocators {
	
	@FindBy(id = "searchBox")
	public WebElement searchText;
	
	@FindBy(xpath = "//*[@class='input-group-btn']//*[text()='Search']")
	public WebElement clickBtn;
	
	@FindBy(xpath = "//*[@class='search-result-count srp-list-header-count font-bold']")
	public WebElement textElement;
	
	

}
