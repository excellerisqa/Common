package oracleapexnce.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ObjectHelper;

public class NCE_ManagerDelegationHistoryPage {
	 WebDriver driver; 

	        public NCE_ManagerDelegationHistoryPage(WebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver,this);
	    } 
	        
	        public boolean verifyManagerDelegationHistoryDisplayed() {
		    	boolean visibility = true;
		    	try {
		    		if((ObjectHelper.driver.findElements(By.id("apexir_MANAGER_NAME")).size() != 0) &&
		    				(ObjectHelper.driver.findElements(By.id("apexir_NAME")).size() != 0) &&
		    				(ObjectHelper.driver.findElements(By.id("apexir_USER_PROVINCE")).size() != 0) &&
		    				(ObjectHelper.driver.findElements(By.id("apexir_MA_START_DATE")).size() != 0) &&
		    				(ObjectHelper.driver.findElements(By.id("apexir_MA_END_DATE")).size() != 0) &&
		    		         (ObjectHelper.driver.findElements(By.id("apexir_ACTIVE")).size() != 0) && 
		    		         (ObjectHelper.driver.findElements(By.id("apexir_LOCATION")).size() != 0) &&
		    		         (ObjectHelper.driver.findElements(By.id("apexir_LOCATION_PROVINCE")).size() != 0) &&
		    		         (ObjectHelper.driver.findElements(By.id("apexir_BUSINESS_UNIT")).size() != 0))
		    		{
		    			System.out.println("Manager delegation History page Displayed with the Ranked Attributes");
		    	    } else 
		    	    	System.out.println("Manager Delegation History page not found");
		    	 
		    	    }
		    	      catch(Exception e) {
		    	    	  visibility = false;
		    	      }
		    	    return visibility; 
		    	   } 

	    

}
