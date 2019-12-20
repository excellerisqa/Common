package oracleapexnce.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utils.ObjectHelper;

public class NCE_NciHistoryPage {
WebDriver driver;
	
	
	public NCE_NciHistoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    } 
    public boolean isNciHistoryDisplayed() {
    	boolean visibility = false;
    	try {
    		if((ObjectHelper.driver.findElements(By.xpath("//div[text()='ID']")).size() != 0) &&
    			(ObjectHelper.driver.findElements(By.xpath("//div[text()='Status']")).size() != 0) &&
    			(ObjectHelper.driver.findElements(By.xpath("//div[text()='Incident Date']")).size() != 0) &&
    			(ObjectHelper.driver.findElements(By.xpath("//div[text()='Service Date']")).size() != 0)&&
    			(ObjectHelper.driver.findElements(By.xpath("//div[text()='Reported Date']")).size() != 0) &&
    			(ObjectHelper.driver.findElements(By.xpath("//div[text()='Reported By User']")).size() != 0) &&
    			(ObjectHelper.driver.findElements(By.xpath("//div[text()='Incident Forwarded To User']")).size() != 0) &&
    			(ObjectHelper.driver.findElements(By.xpath("//div[text()='Incident Redelegated']")).size() != 0) &&
    			(ObjectHelper.driver.findElements(By.xpath("//div[text()='Redelegated Date']")).size() != 0) &&
    			(ObjectHelper.driver.findElements(By.xpath("//div[text()='Redelegated Comments']")).size() != 0))
    		{
    			System.out.println("NCI History successfully displayed");
    			visibility = true;
    	    } else 
    	    	System.out.println("NCI History page not found");
    	 
    	    }
    	      catch(Exception e) {
    	    	  System.out.println(e.getMessage());
    	    	  
    	      }
    	    return visibility; 
    	   }
    
    

}


