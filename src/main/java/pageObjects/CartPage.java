package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	
	public WebDriver driver;
	
	By cart = By.xpath("//a[@id='nav-cart']");
	By shoppingCartText = By.xpath("//span[@id='sc-subtotal-label-buybox']");
	By shoppingCartPrice = By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']");
	By delete = By.xpath("//input[@value='Delete']");
	
	String cartText;
	String cartPriceText;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void viewCart() {
		driver.findElement(cart).click();
	}
	
	public String validateCartPageText() {
		cartText = driver.findElement(shoppingCartText).getText();
		return cartText; 
		
	}
	
	public String validateCartPriceText() {
		cartPriceText = driver.findElement(shoppingCartPrice).getText().trim();
		return cartPriceText;
	}
	
	public void deleteCartItem() {
		driver.findElement(delete).click();
	}
	
	
	
	

}
