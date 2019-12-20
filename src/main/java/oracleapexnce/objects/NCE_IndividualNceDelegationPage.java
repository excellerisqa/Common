package oracleapexnce.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ObjectHelper;

public class NCE_IndividualNceDelegationPage {
	 WebDriver driver; 

	    
	    public NCE_IndividualNceDelegationPage(WebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver,this);
	    } 
	    public boolean verifyIndividualNceDelegationDisplayed() {
	    	boolean visibility = true;
	    	try {
	    		if((ObjectHelper.driver.findElements(By.id("apexir_LOG_NUM")).size() != 0) &&
	    				(ObjectHelper.driver.findElements(By.id("apexir_SECTION")).size() != 0) &&
	    				(ObjectHelper.driver.findElements(By.id("apexir_DELEGATE")).size() != 0) &&
	    				(ObjectHelper.driver.findElements(By.id("apexir_DELEGATED_BY")).size() != 0) &&
	    				(ObjectHelper.driver.findElements(By.id("apexir_DELEGATED_ON")).size() != 0) &&
	    		         (ObjectHelper.driver.findElements(By.id("apexir_PROVINCE")).size() != 0) )
	    		{
	    			System.out.println("Individual NCe Delegation Page Displayed with the Ranked Attributes");
	    	    } else 
	    	    	System.out.println("Individual NCE Delegation page not found");
	    	 
	    	    }
	    	      catch(Exception e) {
	    	    	    System.out.println(e.getMessage());
	    	    	  visibility = false;
	    	      }
	    	    return visibility; 
	    	   } 

}
