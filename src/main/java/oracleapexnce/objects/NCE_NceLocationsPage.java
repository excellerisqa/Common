package oracleapexnce.objects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class NCE_NceLocationsPage {
	WebDriver driver; 
	//page elements in NCE Locations
	@FindBy(linkText="New Location")
	WebElement lnkNewLocation;
	
	//Page elements in Manage NCE Locations
	@FindBy(xpath="//input[@id='P1071_STREET']")
	WebElement txtStreet;
	@FindBy(xpath="//input[@id='P1071_CITY' and @ name='p_t03']")
	WebElement txtCity;
	@FindBy(xpath="//select[@id='P1071_PROVINCE' and @ name='p_t04']")
	WebElement drpbxProvice;
	@FindBy(xpath="//input[@id='P1071_POSTAL_CODE' and @ name='p_t05']")
	WebElement txtPostalCode;
	@FindBy(xpath="//input[@id='P1071_COUNTRY' and @ name='p_t06']")
	WebElement txtCountry;
	@FindBy(xpath="//input[@id='P1071_BUSINESS_UNIT' and @ name='p_t07']")
	WebElement txtBusinessUnit;
	@FindBy(id="P1071_MANAGER_USER_NAME")
	WebElement drpbxManager;
	@FindBy(id="P1071_ISACTIVE_0")
	WebElement radNo;
	@FindBy(id="P1071_ISACTIVE_1")
	WebElement radYes;
	
	@FindBy(xpath="//span[text()='Create']")
	WebElement btnCreate;
	
	@FindBy(linkText="Cancel")
	WebElement cancel;
	
	
	//Page Elements in Action processed
	@FindBy(xpath="//img[@class='uCheckmarkIcon']")
	WebElement imgCheck;
	@FindBy(xpath="//section[@id='uSuccessMessage']/descendant::div[position()=2]")
	WebElement txtActionProcessed;
	@FindBy(xpath="//div[@class='uCloseMessage'] ")
	WebElement btnClose;
	
	//Page Elements for Error Message
	
	@FindBy(xpath="//a[@class='uCloseMessage']")
	WebElement closeBtn;
	
	//Page elements Search Field
	@FindBy(xpath="//input[@id='apexir_SEARCH']")
	WebElement txtSrch;
	@FindBy(xpath="//span[text()='Go']")
	WebElement btnGo;
	
	//page element edit- pencil pic
	@FindBy(xpath="//div[@id='apexir_DATA_PANEL']/descendant::table[position()=2]/descendant::img")
	WebElement img;
	
	//page elements in edit field
	@FindBy(xpath="//span[text()='Save']")
	WebElement lnkSave;
	
	
	
    public NCE_NceLocationsPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver,this);
} 
    //VERIFY NCE LOCATIONS PAGE DISPLAYED
    public boolean verifyNceLocationsPageDisplayed() {
    	boolean visibility = false;
    	try {
    		if((ObjectHelper.driver.findElements(By.id("apexir_STREET")).size() != 0) &&
    				(ObjectHelper.driver.findElements(By.id("apexir_CITY")).size() != 0) &&
    				(ObjectHelper.driver.findElements(By.id("apexir_PROVINCE")).size() != 0) &&
    				(ObjectHelper.driver.findElements(By.id("apexir_POSTAL_CODE")).size() != 0) &&
    				(ObjectHelper.driver.findElements(By.id("apexir_COUNTRY")).size() != 0) &&
    		         (ObjectHelper.driver.findElements(By.id("apexir_BUSINESS_UNIT")).size() != 0) && 
    		         (ObjectHelper.driver.findElements(By.id("apexir_MANAGER")).size() != 0) &&
    		         (ObjectHelper.driver.findElements(By.id("apexir_ACTIVE")).size() != 0) )
    		{
    			visibility=true;
    			System.out.println("NCE Locations page Displayed with the Ranked Attributes");
    	    } else 
    	    	System.out.println("NCE Locations  page not found");
    	 
    	    }
    	      catch(Exception e) {
    	    	  System.out.println(e.getMessage());
    	    	  
    	      }
    	    return visibility; 
    	   } 
    //CLICK NEW LOCTION
    public void clickNewLocation() {
    	click(lnkNewLocation);
    }
   
    
   
       private void selectFromDropBox(WebElement webe, String text) {
    	CommonFunctions.isElementClickable(webe);
    	Select select = new Select(webe);
    		select.selectByVisibleText(text);
    	}
    private void click(WebElement webe)  {
    	 WebDriverWait wait = new WebDriverWait(ObjectHelper.driver,10);
         wait.until(ExpectedConditions.elementToBeClickable(webe)).click();
    	  	
    }
    
    
//CREATE NCE LOCATION
	public void createNceLocation(Hashtable<String, String> data) throws Exception {
		// TODO Auto-generated method stub
		CommonFunctions.ClearAndSetText(txtStreet, data.get(NCELocTable.STREET));
    	CommonFunctions.ClearAndSetText(txtCity,data.get(NCELocTable.CITY));
    	selectFromDropBox(drpbxProvice, data.get(NCELocTable.PROVINCE));
    	CommonFunctions.ClearAndSetText(txtPostalCode,data.get(NCELocTable.POSTAL_CODE));
    	CommonFunctions.ClearAndSetText(txtCountry,data.get(NCELocTable.COUNTRY));
    	CommonFunctions.ClearAndSetText(txtBusinessUnit,data.get(NCELocTable.BUSINESS_UNIT));
    	selectFromDropBox(drpbxManager, data.get(NCELocTable.MANAGER));
    	if(data.get(NCELocTable.ACTIVE).toLowerCase().equals("yes")) {
    		CommonFunctions.waitandClick(radYes, 10);   
    	}else {
    		CommonFunctions.waitandClick(radNo, 10);
    	}
    	CommonFunctions.waitandClick(btnCreate, 10);    
//    	Assert.assertTrue(isActionProcessed(),"Create Location Failed");
//    	System.out.println("New NCE Location Created");
		
	}
	public boolean isActionProcessed() {
		return CommonFunctions.checkElementDisplayed(txtActionProcessed);
	}
	//VERIFY NEWLY ADDED LOCATION FOUND WITH EXISTING NCE LOCATION
	public boolean searchForLocation(Hashtable<String, String> data) throws Exception {
		// TODO Auto-generated method stub
		NCETable locTable = new NCETable(NCELocTable.STREET);
		locTable.filterColumn("Street", data.get(NCELocTable.STREET));
		boolean result = locTable.find(data);
		System.out.println("is Newly added NCE Location found in NCE Location Table:"+result);
		 return result;
		
	} 
 

//EDIT NCE LOCATION
public void editNceLocation(Hashtable<String, String> data) throws Exception  {
	//Filter the Search for relevant column to be edited
	CommonFunctions.waitForVisiblity(txtSrch, 20);
	CommonFunctions.ClearAndSetText(txtSrch, data.get(NCELocTable.STREET));
	CommonFunctions.waitandClick(btnGo, 20);
	//Click the view link to edit existing NCE Location
	CommonFunctions.waitandClick(img, 20);
			
	//Wait till manage NCE Location page displayed  to edit the data
	CommonFunctions.checkElementDisplayed(txtStreet);
			
	// Edit the Required field
	CommonFunctions.ClearAndSetText(txtCity,data.get(NCELocTable.CITY));
	CommonFunctions.waitandClick(lnkSave, 10);
	//Assert.assertTrue(isActionProcessed(),"Edit Nce location failed");
	
}


		
		
	
	
	
		
	
	
	
	
	
	
}




    	
    
    




