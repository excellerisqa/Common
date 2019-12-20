package oracleapexnce.objects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class NCE_HelpLinkPage2 {
WebDriver driver;
	
	
	public NCE_HelpLinkPage2(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    } 
	private String getPopUpWindowText() {
		Set<String> winHandles = ObjectHelper.driver.getWindowHandles(); 
		Iterator<String> itr = winHandles.iterator();
		System.out.println("Got window handles");

		String currentWin = itr.next();
		String newBrowserWin = null;
		if (itr.hasNext())
		    newBrowserWin = itr.next();

		String newBrowserWinText="";
		
		if (newBrowserWin!=null) {
			
		    driver.switchTo().window(newBrowserWin);

		    newBrowserWinText =ObjectHelper. driver.findElement(By.tagName("body")).getText();
		    System.out.println("Text found is:"+ newBrowserWinText);
		}

		return newBrowserWinText;
	}
	
    public boolean isHelpLinkDisplayed() {
    	boolean result = false;
    	
    	
    		String actTxt = getPopUpWindowText();
    		String exp ="01_SOPs";
    		if(actTxt.contains(exp)) {
        	System.out.println("Help Link Page Displayed successfully");
    		result= true;
    		
    		
    		}else
    			System.out.println("Help Link not found");
    	    	  
    	     
    	    return result; 
    	   }
	
    


}
