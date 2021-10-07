package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {
	public WebDriver driver;
	
	By searchResultItem = By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']");
	By searchItemPrice = By.xpath("//span[contains(text(),'Metal Ducati Panigale')]/ancestor::div[@class='a-section a-spacing-none']/div[3]/div/a/span/span[2]/span[2]");
	
	String price;
	String name;
	
	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public String checkSearchResultPrice() {
		List<WebElement> items = driver.findElements(searchResultItem);
		int listSize = items.size();
		
		for (int i=0;i<listSize;i++) {
			name = items.get(i).getText();
			if(name.contains("Metal Ducati Panigale")) {
				price = driver.findElement(searchItemPrice).getText();
				break;
			}
		}
		return price;
	}
	

}
