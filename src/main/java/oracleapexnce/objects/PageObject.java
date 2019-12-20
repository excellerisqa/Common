package oracleapexnce.objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
	protected WebDriver driver;
	protected void click(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }
    protected void sendKeys(WebElement webElement, String keys){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(keys);
    }
    protected boolean isVisible(WebElement element){    	
    	boolean visibility = true;
    	ArrayList<WebElement> elements = new ArrayList<WebElement>();
    	elements.add(element);
    	
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	try {
    		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    	}catch(Exception e) {
    		visibility = false;    		
    	}
    	return visibility;
    }
   
}
