package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	public WebDriver driver;
	Actions a;
	By hoversignin = By.xpath("//*[@id=\'nav-link-accountList\']");
	By signin = By.xpath("//span[@class=\'nav-action-inner\']");
	By mycart = By.xpath("//*[@id=\'nav-cart-count-container\']");
	By breadcrumb = By.xpath("//a[@id='nav-hamburger-menu']");
	By name = By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
	By hello = By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
	By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");
	By searchBtn = By.xpath("//input[@id='nav-search-submit-button']");
	By searchResultHeading = By.xpath("//span[contains(text(),'results for')]");
	
	
	
	String actualName;
	String helloText;
	String searchResultText;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		
	}
	

	public void mouseHover(){
		a=new Actions(driver);
		a.moveToElement(driver.findElement(hoversignin)).click(driver.findElement(signin)).build().perform();		
	}
	
	
	public void clickMyCart() {
		driver.findElement(mycart).click();
		driver.navigate().back();
	}
	
	public String checkName() {
		actualName = driver.findElement(name).getText();
		return actualName;
	}
	
	public String checkWelcome() {
		helloText = driver.findElement(hello).getText();
		return helloText;
	}
	
	public void enterSearchString(String str) {
		driver.findElement(searchBox).sendKeys(str);
	}
	
	public void clickSearch() {
		driver.findElement(searchBtn).click();
	}
	
	public String searchResult() {
		searchResultText = driver.findElement(searchResultHeading).getText();
		return searchResultText;
	}
	
	
}
