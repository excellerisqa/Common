package oracleapexnce.objects;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class NCE_ManagerDirectorLinkPage {
	WebDriver driver; 

   //page elements in Manager Director Link
    @FindBy(linkText = "New Link")
    WebElement newLink;
    @FindBy(id="apexir_MANAGER")
    WebElement manager;
    @FindBy(id="apexir_SEARCH")
    WebElement txtSearch;
    @FindBy(id="apexir_btn_SEARCH")
    WebElement btnGo;
    
    
    
    
    
    // Page elements in Manager Director Link Manage
    @FindBy(id="P1076_MANAGER_CREATE")
    WebElement drpBoxManager;
    @FindBy(id="P1076_DIRECTOR")
    WebElement drpBoxDirector;
    @FindBy(linkText="Create")
    WebElement btnCreate;
    @FindBy(linkText="Cancel")
    WebElement cancel;
    
    // Page elements in Action Processed
    
    @FindBy(xpath="//section[@id='uSuccessMessage']/descendant::div[position()=2]")
    WebElement txtActionProcessed;
    
   
    public NCE_ManagerDirectorLinkPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    } 
    //CLICK NEW LINK
    public void clickNewLink() throws Exception {
    	CommonFunctions.waitandClick(newLink, 30);
    }
    //Create New manager
    public void addNewManager(String manager) {
    	Select drpdown = new Select(ObjectHelper.driver.findElement(By.id("P1076_MANAGER_CREATE")));
       	drpdown.selectByVisibleText(manager);
       	System.out.println("New manager Selected");
    	
    }
    
    //validate New Manager Found in Manager Director link Manage Page
    	public boolean validateNewlyCratedManager(String manager) throws Exception{
    		boolean result = false;
    		//SELECT ALL PROVINCE LOCATION
    		CommonFunctions.waitandClick(By.id("P0_PROVINCE_0"),50);
    		Select drpdown = new Select(ObjectHelper.driver.findElement(By.id("P1076_MANAGER_CREATE")));
       	//GET ALL ELEMENTS FROM MANAGER DROP DOWN LIST
        	List<WebElement> options = (List<WebElement>) drpdown.getOptions();
        	options.remove(0);
        	for(WebElement option : options) {
        		if(option.isDisplayed()) {
        			System.out.println("Newly Added Manager found in Manager Director Link Manage page");
        			result = true; 
        			break;
        			   			
        			}
        		
        		}
        	return result;
    	    	}
    	//Create New Director
    	
    	public String addnewDirector()throws Exception {
    		String newDirector = "";
    		Select drpdown = new Select(ObjectHelper.driver.findElement(By.id("P1076_DIRECTOR")));
        	   	//GET ALL ELEMENTS FROM  DIRECTOR DROP DOWN LIST
        	List<WebElement> options = (List<WebElement>) drpdown.getOptions();
        	System.out.println("Got all Directors Name");
        	options.remove(0);
        	Thread.sleep(3000);
        	for(WebElement option : options) {
        		if(!option.isSelected()) {
        			newDirector = option.getText();
        			drpdown.selectByVisibleText(newDirector);
        			System.out.println("Director:"+ newDirector);
        			
        			break;
        			   			
        			}
        		
        		}
        	
        	return newDirector;
        	
        	}
        
    		
    	
    	
   
    	public boolean isDisplayed() {
    		return CommonFunctions.checkElementDisplayed(btnCreate);
    		}
    	
    	
    public boolean verifyManagerDirectorLinkPageDisplayed() {
    	boolean visibility = true;
    	try {   		
    		
    		if((ObjectHelper.driver.findElements(By.id("apexir_MANAGER")).size() != 0) &&
    				(ObjectHelper.driver.findElements(By.id("apexir_MANAGER_PROVINCE")).size() != 0) &&
    				(ObjectHelper.driver.findElements(By.id("apexir_DIRECTOR")).size() != 0) &&
    				(ObjectHelper.driver.findElements(By.id("apexir_DIRECTOR_PROVINCE")).size() != 0))
    		{
    			System.out.println("Manager Director Link page Displayed with the Ranked Attributes");
    	    } else 
    	    	System.out.println("Manager Director link page not found");
    	 
    	    }
    	      catch(Exception e) {
    	    	  visibility = false;
    	      }
    	    return visibility; 
    	   }
    //VERIFY ACTION PROCESS DISPLAYED
    public boolean isActionProcessedDisplayed() {
    	
    	return CommonFunctions.waitForVisiblity(txtActionProcessed, 30);
    }
    
   
    
    //FILTER SEARCH FOR MANAGER
    public void filterSearch(Hashtable<String, String>data) throws Exception {
    	if(CommonFunctions.isElementClickable(txtSearch)) 
    	{
    		CommonFunctions.ClearAndSetText(txtSearch, data.get("MANAGER"));
    		CommonFunctions.waitandClick(btnGo, 20);
    		
    	}else
    		System.out.println("Manager Director Link Manage page not displayed");
    	
    }
    //CLICK EDIT LINK 
    public void clickEditLink(Hashtable<String, String>data) throws Exception {
    	//VALIDATE THAT THE TABLE CONTAIN MANAGER SEARCHED FOR
       	NCETable table = new NCETable("MANAGER");
    	
    	//IF TABLE CONTAINS THE MANAGER SEARCHED FOR CLICK EDIT LINK
    	if(table.find(data)) {
    		CommonFunctions.waitandClick(By.xpath("//td[text()='XXX']//preceding::img[position()=1]".replace("XXX", data.get("MANAGER"))), 20);
    	
    	}else {
    		System.out.println("No search result found with the Manager name searched for");
    		
    		}
    }
    
        
    //Edit Manager Director Link
    public String editDirector() throws Exception {
    	String newDirector = "";
    	CommonFunctions.waitForVisiblity(By.id("P1076_DIRECTOR"), 40);
    	System.out.println("Director Combo Box is visible");
    	Select drpdown = new Select(ObjectHelper.driver.findElement(By.id("P1076_DIRECTOR")));
    	//GET THE TEXT OF CURRENT SELECTED ONE
    	String currentDirector = drpdown.getFirstSelectedOption().getText();
    	System.out.println("Current Director is:"+currentDirector);
    	
    	//GET ALL ELEMENTS FROM  DIRECTOR DROP DOWN LIST
    	List<WebElement> options = (List<WebElement>) drpdown.getOptions();
    	System.out.println("Got all Directors Name");
    	options.remove(0);
    	Thread.sleep(3000);
    	for(WebElement option : options) {
    		if(!option.isSelected()) {
    			newDirector = option.getText();
    			drpdown.selectByVisibleText(newDirector);
    			
    			break;
    			   			
    			}
    		
    		}
    	
    	CommonFunctions.waitandClick(By.xpath("//span[text()='Save']"), 10);
    	return newDirector;
    	
    	}
    
    
    //VERIFY NEWLY ADDED NAMES DISPLAYED WITH EXISTING MANAGER DIRECTOR LINK 	
    
    	public boolean validateAddedNameDisplayed(Hashtable<String, String>data) throws Exception {
           boolean visibility = false;
           Thread.sleep(3000);
		//VALIDATE THAT THE TABLE CONTAIN MANAGER SEARCHED FOR
       NCETable table = new NCETable("MANAGER");
       System.out.println("The Table Found");
       
       	//FILTER THE SEARCH
    //   	table.filterColumn("MANAGER", data.get("MANAGER"));
       	
    	
    	//IF TABLE CONTAINS THE MANAGER SEARCHED FOR CLICK EDIT LINK
    	if(table.find(data)) {
    		System.out.println(" The Manager Director Link displayed the named Searched for");
    		visibility = true;
    			
	}else
		System.out.println("No record to show with the Managers name searched for");
    	
    	return visibility;
    	}
}
    		


    

    


