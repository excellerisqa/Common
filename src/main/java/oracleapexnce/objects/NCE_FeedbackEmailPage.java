package oracleapexnce.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utils.ObjectHelper;

public class NCE_FeedbackEmailPage {
	WebDriver driver;
	
	
	public NCE_FeedbackEmailPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    } 
    public boolean isFeedbackEmailsViewable() {
    	boolean visibility = true;
    	try {
    		if((ObjectHelper.driver.findElements(By.xpath("//div[text()='ID']")).size() != 0) &&
    			(ObjectHelper.driver.findElements(By.xpath("//div[text()='Subject']")).size() != 0) &&
    			(ObjectHelper.driver.findElements(By.xpath("//div[text()='Message']")).size() != 0) &&
    			(ObjectHelper.driver.findElements(By.xpath("//div[text()='Recipients']")).size() != 0) )
    		{
    			System.out.println("Feedback emails successfully displayed");
    	    } else 
    	    	System.out.println("Feedback emails not found");
    	 
    	    }
    	      catch(Exception e) {
    	    	  System.out.println(e.getMessage());
    	    	  visibility = false;
    	      }
    	    return visibility; 
    	   }
    
    

}
