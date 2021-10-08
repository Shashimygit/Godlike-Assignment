package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import Resources.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ItemPage;
import pageObjects.SearchResultPage;
import pageObjects.SignIn;



@SuppressWarnings("deprecation")
public class StepDefinition extends Base{
    
        @Given("^\"([^\"]*)\" page is loaded on browser$")
        public void something_page_is_loaded_on_browser(String strArg1) throws Throwable {
        	//System.setProperty("webdriver.chrome.driver","D://Selenium//chromedriver_win32//chromedriver.exe");
        	//WebDriver driver = new ChromeDriver();
        	driver = initializeDriver();
        	driver.get(strArg1);
        	HomePage hp = new HomePage(driver);
        	hp.mouseHover();        	
            
        }

        @When("^(.+) and (.+) is entered$")
        public void and_is_entered(String username, String password) throws Throwable {
        	SignIn sn = new SignIn(driver);
        	sn.enterEmail(username);
        	sn.clickContinue();
        	sn.enterPassword(password);
        	

        }

        @And("^signin button is clicked$")
        public void signin_button_is_clicked() throws Throwable {
        	SignIn sn = new SignIn(driver);
        	sn.clickSignIn();
        }

        @Then("^Login is successful$")
        public void login_is_successful() throws Throwable {
        	HomePage hp = new HomePage(driver);
        	Assert.assertEquals("Hello, testfirst",hp.checkName());

        }

        @And("^Hi username is displayed$")
        public void hi_username_is_displayed() throws Throwable {
        	HomePage hp = new HomePage(driver);
        	Assert.assertEquals(hp.checkWelcome(), "Hello, testfirst");

        } 
        
        @And("^browser is closed$")
        public void browser_is_closed() throws Throwable {
        	driver.quit();
        }
        
        @And("^(.+) search text is entered in search box$")
        public void search_text_is_entered_in_search_box(String searchtext) throws Throwable {
        	HomePage hp = new HomePage(driver);
        	hp.enterSearchString(searchtext);
        }
        
        @And("^search button is clicked$")
        public void search_button_is_clicked() throws Throwable {
        	HomePage hp = new HomePage(driver);
        	hp.clickSearch();
        }

        @Then("^search results are displayed$")
        public void search_results_are_displayed() throws Throwable {
        	HomePage hp = new HomePage(driver);
          	Assert.assertEquals("1-48 of over 40,000 results for", hp.searchResult());

        }
        
        @And("^item is clicked$")
        public void item_is_clicked() {
        	ItemPage ip = new ItemPage(driver);
        	ip.itemClick();
        }
        
        @And("^item detail page is displayed$")
        public void item_detail_page_is_displayed() {
        	ItemPage ip = new ItemPage(driver);
        	Set<String> windows = driver.getWindowHandles();
        	Iterator<String> it = windows.iterator();
        	String parentId = it.next();
        	String childId = it.next();
        	driver.switchTo().window(childId);
        	Assert.assertEquals("About this item", ip.validateItemPageText());
        }
        
        @And("^add to cart button is clicked$")
        public void add_to_cart_button_is_clicked() throws Throwable {
        	ItemPage ip = new ItemPage(driver);
        	ip.clickAddToCart();
        }

        @Then("^item is added to cart$")
        public void item_is_added_to_cart() throws Throwable {
        	CartPage cp = new CartPage(driver);
        	cp.viewCart();
        	Assert.assertEquals("Subtotal (1 item):", cp.validateCartPageText());
        }
        
        @And("^item is removed from cart$")
        public void item_is_removed_from_cart() throws Throwable{
        	CartPage cp = new CartPage(driver);
        	cp.deleteCartItem();
        }

        @And("^item price on search results page is checked$")
        public void item_price_on_search_results_page_is_checked() throws Throwable {
            SearchResultPage sp = new SearchResultPage(driver);
            Assert.assertEquals("599", sp.checkSearchResultPrice());
            
        }
        
        @And("^item price on cart page is checked$")
        public void item_price_on_cart_page_is_checked() throws Throwable {
        	CartPage cp = new CartPage(driver);
        	Assert.assertEquals("599.00", cp.validateCartPriceText());
            
        }
        

}