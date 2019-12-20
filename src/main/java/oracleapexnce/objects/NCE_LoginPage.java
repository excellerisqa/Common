package oracleapexnce.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonFunctions;

public class NCE_LoginPage   { 
     WebDriver driver; 

    @FindBy(id="P101_USERNAME")
    WebElement username;
    @FindBy(id="P101_PASSWORD")
    WebElement password;
    @FindBy(linkText = "Login")
    WebElement btnLogin;

    public NCE_LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    } 
    private void click(WebElement webe) {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(webe)).click();
    	
    }
    private void sendKeys(WebElement webElement, String keys){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(keys);
    }
    public void login(String username, String password) {
    	sendKeys( this.username, username);
    	sendKeys(this.password, password);
        click(btnLogin);
    }
    public boolean isDisplayed() throws Exception {
    	return CommonFunctions.waitForVisiblity(btnLogin, 30);
    	
		
		
	}
}
    
    
  