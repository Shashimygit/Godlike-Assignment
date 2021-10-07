package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn {
	public WebDriver driver;
	By email = By.xpath("//input[@id='ap_email']");
	By btn_continue = By.xpath("//input[@id=\'continue\']");
	By password = By.xpath("//input[@id='ap_password']");
	By btn_signin = By.xpath("//input[@id='signInSubmit']");
	
	
	public SignIn(WebDriver driver) {
		this.driver=driver;		
	}
	

	public void enterEmail(String str){
		driver.findElement(email).sendKeys(str);
	}
	
	public void clickContinue() {
		driver.findElement(btn_continue).click();
	}
	
	public void enterPassword(String str) {
		driver.findElement(password).sendKeys(str);
	}
	
	public void clickSignIn() {
		driver.findElement(btn_signin).click();
	}

}
