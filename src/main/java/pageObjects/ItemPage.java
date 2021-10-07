package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage {
	public WebDriver driver;
	
	By item = By.xpath("//span[contains(text(),'Ducati Panigale V4')]");
	By itemPageTextElement = By.xpath("//h1[@class='a-size-base-plus a-text-bold']");
	By addToCartElement = By.xpath("//input[@id='add-to-cart-button']");
	By viewCartElement = By.xpath("//a[@id='hlb-view-cart-announce']");
	
	////div[@class='a-section a-spacing-none'] //div[@class='a-section a-spacing-none a-spacing-top-small'] //div[@class='a-row a-size-base a-color-base'] //a[@class='a-size-base a-link-normal a-text-normal'] //span[@class='a-price'] //span[@aria-hidden='true'] //span[@class='a-price-whole']
	
	String itemPageText;
	
	public ItemPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void itemClick() {
		driver.findElement(item).click();
	}
	
	public String validateItemPageText() {
		itemPageText = driver.findElement(itemPageTextElement).getText();
		return itemPageText;
	}
	
	public void clickAddToCart() {
		driver.findElement(addToCartElement).click();
	}
	
	public void clickViewCart() {
		driver.findElement(viewCartElement);
	}
	
	


}
