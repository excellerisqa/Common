package oracleapexnce.objects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.WebHandler;

public class NCE_CreateNewNcePage {
	 WebDriver driver;
	 String xpRadios ="//*[text()='PoD Location ']/ancestor::table/descendant::*[text()='XXX'][1]/following::table[position()=1]/descendant::input[@type='radio']//following-sibling::label[text()='YYY']";
	 
	 
	//Page elements in open location Box
	 @FindBy(xpath="//input[@id='superlov-filter']")
	 WebElement txtSrch;
	 @FindBy(xpath="//*[@id=\"superlov_styled_filter\"]/table/tbody/tr/td[2]/div/span")
	 WebElement btnSrch;
	 
	 //page elements in location box
	 //pod Location
	 @FindBy(xpath="//*[@id=\"P2_SA_POD_LOCATION_holder\"]/tbody/tr/td[2]/div/button[1]/span[1]")
	 WebElement btnClearPod;
	 @FindBy(xpath="//*[@id=\"P2_SA_POD_LOCATION_holder\"]/tbody/tr/td[2]/div/button[2]/span[1]")
	 WebElement btnOpnLocBox;
	 
	 // poi Location
	 @FindBy(xpath="//table[@id='P2_SA_LOCATION_holder']/tbody/tr/td[2]/div/button[1]/span[1]")
	 WebElement btnClearPoi;
	 @FindBy(xpath="//table[@id='P2_SA_LOCATION_holder']/tbody/tr/td[2]/div/button[2]/span[1]")
	 WebElement btnOpnLocBoxPoi;
	 
	 @FindBy(xpath="//textarea[@id='P2_SA_REMEDIAL_ACTION_TAKEN']")
	 WebElement txtRemedialAction;
	 @FindBy(xpath="//textarea[@id='P2_SA_DESCRIPTION']")
	 WebElement txtDescription;
	 
	 @FindBy(xpath="//section[@id='SECTIONA']/descendant::span[position()=3]")
	 WebElement btnSaveAsDraft;
	 @FindBy(xpath="//section[@id='SECTIONA']/descendant::span[position()=4]")
	 WebElement btnSubmit;
	 @FindBy(xpath="//span[text()='Add Additional Attachments']")
	 WebElement lnkAddAttchment;
	 
	 //Page element for "Section A Submitted.NCE#....."
	 @FindBy(xpath="//section[@id=\"uSuccessMessage\"]/descendant::div[position()=2]")
	 WebElement txtNewNce;
	 
	 
	 // page elements NCE page
	 @FindBy(xpath="//select[@id='apexir_SAVED_REPORTS']")
	 WebElement report;
	 
	 //Page elements- Addl Info
	 @FindBy(xpath="//input[@id='P2_SA_HEALTHCARD_NUMBER']")
	 WebElement txtHCardNo;
	 @FindBy(xpath="//input[@id='P2_SA_PATIENT_NAME']")
	 WebElement txtPName;
	 @FindBy(xpath="//input[@id='P2_SA_RELEVANT_DATE']")
	 WebElement txtDate;
	 
	 //page elements Filter
	 @FindBy(xpath="//table[@id='apexir_CONTROL_PANEL_COMPLETE']/descendant::img[position()=1]")
	 WebElement filter1;
	 @FindBy(xpath="//table[@id='apexir_CONTROL_PANEL_COMPLETE']/descendant::img[position()=3]")
	 WebElement filter2;
	 
	 //Page elements View Audit Information
	 @FindBy(xpath="//span[text()='View Audit Information']")
	 WebElement lnkViewAuditInfo;
	 
	 
	 public NCE_CreateNewNcePage (WebDriver driver  ) {
		 
		 this.driver = driver;
	        PageFactory.initElements(driver,this);		
			
		}
	 
	 public void submitForm(Hashtable<String,String> data) throws Exception {
		 //Point of Discovery
		 CommonFunctions.waitandClick(By.xpath(xpRadios.replace("XXX", CreateNceFields.POINT_OF_DISCOVERY).replace("YYY", data.get(CreateNceFields.POINT_OF_DISCOVERY))), 10);
		 //POD Location
      	 selectPodLoc(data.get(CreateNceFields.POD_LOCATION));
      	 //Point of Investigation
		 CommonFunctions.waitandClick(By.xpath(xpRadios.replace("XXX", CreateNceFields.POINT_OF_INVESTIGATION).replace("YYY", data.get(CreateNceFields.POINT_OF_INVESTIGATION))), 10);
		 //POI Location
		 selectPoiLoc(data.get(CreateNceFields.POI_LOCATION));
		 //Information Received By
		 CommonFunctions.waitandClick(By.xpath(xpRadios.replace("XXX", CreateNceFields.INFORMATION_RECEIVED_BY).replace("YYY", data.get(CreateNceFields.INFORMATION_RECEIVED_BY))), 10);
		 //Category of NCE
		 CommonFunctions.waitandClick(By.xpath(xpRadios.replace("XXX", CreateNceFields.CATEGORY_OF_NCE).replace("YYY",data.get(CreateNceFields.CATEGORY_OF_NCE ))), 10);
		 //Remedial Action
		 enterRemedialAction(data.get(CreateNceFields.REMEDIAL_ACTION));
		 //Description of NCE
		 enterDescription(data.get(CreateNceFields.DESCRIPTION_OF_NCE));
		 //Additional info Required
		 if(data.get(CreateNceFields.ADDITIONAL_INFO_REQUIRED).equalsIgnoreCase("Yes")) {
	    		CommonFunctions.waitandClick(By.xpath(xpRadios.replace("XXX",CreateNceFields.ADDITIONAL_INFO_REQUIRED).replace("YYY", data.get(CreateNceFields.ADDITIONAL_INFO_REQUIRED))), 10);
	    		CommonFunctions.ClearAndSetText(txtHCardNo, data.get(CreateNceFields.HEALTH_CARD));
	    		CommonFunctions.ClearAndSetText(txtPName, data.get(CreateNceFields.PATIENT_NAME));
	    		CommonFunctions.ClearAndSetText(txtDate, data.get(CreateNceFields.DATE));
	    	}else {
	    		CommonFunctions.waitandClick(By.xpath(xpRadios.replace("XXX",CreateNceFields.ADDITIONAL_INFO_REQUIRED).replace("YYY", data.get(CreateNceFields.ADDITIONAL_INFO_REQUIRED))), 10);
	    	}
		 
		 //Point of Cause------(if selected is preanalytical)
		 CommonFunctions.waitandClick(By.xpath(xpRadios.replace("XXX",CreateNceFields.POINT_OF_CAUSE).replace("YYY", data.get(CreateNceFields.POINT_OF_CAUSE))), 10);
		 //preAnalytical Category-----( selected field is cardiac)
		 CommonFunctions.waitandClick(By.xpath("//*[text()='PoD Location ']/ancestor::table/descendant::*[text()='XXX']/following::label[text()='YYY'][1]".replace("XXX", CreateNceFields.PREANALYTICAL_CATEGORY).replace("YYY", data.get(CreateNceFields.PREANALYTICAL_CATEGORY))), 10);
		
		 
		 //preanalytical Sub category group-----(if selected is ECG Reporting
		 CommonFunctions.waitandClick(By.xpath("//*[text()='PoD Location ']/ancestor::table/descendant::*[text()='XXX']/following::label[text()='YYY'][1]".replace("XXX", CreateNceFields.PREANALYTICAL_SUBCATEGORY_GROUP).replace("YYY",data.get(CreateNceFields.PREANALYTICAL_SUBCATEGORY_GROUP))), 10);
		 //preanalytical subcategory
		 CommonFunctions.waitandClick(By.xpath("//*[text()='PoD Location ']/ancestor::table/descendant::*[text()='XXX']/following::label[text()='YYY'][1]".replace("XXX", CreateNceFields.PREANALYTICAL_SUBCATEGORY).replace("YYY", data.get(CreateNceFields.PREANALYTICAL_SUBCATEGORY))),10);
		 //specimen Affected
		 CommonFunctions.waitandClick(By.xpath("//*[@id='P2_SA_SPECIMEN_AFFECTED_1']"), 10);
		 // submit Section A
		 CommonFunctions.waitandClick(btnSubmit, 10);
			Thread.sleep(3000);
			Assert.assertTrue(isNewNceCreated(), "Create New Nce Test Failed");
	 }
	 
	  private void openDialogeBox(String text, String idNo) throws InterruptedException {
		    
          CommonFunctions.waitForVisiblity(txtSrch, 20);
    	    Select srchLocation = new Select(ObjectHelper.driver.findElement((By.xpath("//select[@id='superlov-column-select']"))));
    		srchLocation.selectByVisibleText(text);
    		txtSrch.sendKeys(idNo);
    		btnSrch.click();
    		Thread.sleep(2000);
    		//Click the filtered address
    		String xp= "//td[text()='XXX']";
    		Actions action = new Actions(ObjectHelper.driver);
    		action.moveToElement(ObjectHelper.driver.findElement(By.xpath(xp.replace("XXX", idNo)))).click().perform();
	  }
    	
	  // Select PoD Location
	 private void selectPodLoc(String idNo) throws Exception {
		  //Clear the field
		  CommonFunctions.waitandClick(btnClearPod, 10);
		  //open dialog box
		  CommonFunctions.waitandClick(btnOpnLocBox, 10);
		  openDialogeBox("ID", idNo);
	  }
	  
	  // Select POI Location
	 private void selectPoiLoc(String idNo)throws Exception {
		  //Clear filed
		  CommonFunctions.waitandClick(btnClearPoi, 10);
		  //open dialog box
		  CommonFunctions.waitandClick(btnOpnLocBoxPoi, 10);
		  openDialogeBox("ID", idNo);
	  }
	  //Enter Remedial Action
	  private void enterRemedialAction(String txt) {
		  String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String remedy=txt+timeStamp;
			try {
				CommonFunctions.waitForVisiblity(txtRemedialAction, 10);
				txtRemedialAction.sendKeys(remedy);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
            	
	  }
	  
	  //Enter Description
	 private void enterDescription(String descrip) {
		  try {
			CommonFunctions.waitandClick(txtDescription, 10);
			txtDescription.sendKeys(descrip);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	  }
	
	private boolean isNewNceCreated() {
		return CommonFunctions.waitForVisiblity(txtNewNce, 30);
		
	}

//Filter the search to find Newly Created NCE and View NCE Audit Info	
public void viewNCEAuditInfo() throws Exception {
	
	CommonFunctions.waitForVisiblity(txtNewNce, 20);
    
	//Find out Log#
	String txt = txtNewNce.getText();
	String log = txt.substring(txt.indexOf("#")+1).trim();
	
	//Filter search
	selectReport();
	removeAllFilters();
	System.out.println("Filter removed");
	Thread.sleep(5000);
	CommonFunctions.waitForVisiblity(By.xpath("//input[@id='apexir_SEARCH']"), 100);
	ObjectHelper.driver.findElement(By.xpath("//input[@id='apexir_SEARCH']")).sendKeys(log);		
	CommonFunctions.waitandClick(By.xpath("//span[text()='Go']"), 100);
	Thread.sleep(5000);
	removeBreaks();		
	
	//VIEW AUDIT INFO
	NCETable table = new NCETable(CreateNceFields.LOG);
	Hashtable<String, String> data = new Hashtable<>();
	data.put(CreateNceFields.LOG, log);
	if(table.find(data)) {
		CommonFunctions.waitandClick(By.xpath("//th[@id='NCE']//ancestor::table[position()=1]/descendant::td[text()='XXX']/following::a[text()='View']".replace("XXX", log)), 10);
	}else
	{
	removeAllFilters();
	ObjectHelper.driver.findElement(By.xpath("//input[@id='apexir_SEARCH']")).sendKeys(log);
	CommonFunctions.waitandClick(By.xpath("//span[text()='Go']"), 10);
	CommonFunctions.waitandClick(By.xpath("//th[@id='NCE']//ancestor::table[position()=1]/descendant::td[text()='XXX']/following::a[text()='View']".replace("XXX", log)), 10);
	}
	
}

//VERIFY VIEW AUDIT INFORMATION
public boolean verifyViewAuditInfo(Hashtable<String, String> data) {
	boolean visibility = false;
	
		
	String actualPOD = ObjectHelper.driver.findElement(By.xpath("//td[text()='Point of Discovery']/following::td[position()=1]")).getText();
	String actPOI = ObjectHelper.driver.findElement(By.xpath("//td[text()='Point of Investigation']/following::td[position()=1]")).getText();
	String actInfo = ObjectHelper.driver.findElement(By.xpath("//td[text()='Information Received By']/following::td[position()=1]")).getText();
	String actNceCat = ObjectHelper.driver.findElement(By.xpath("//td[text()='NCE Category']/following::td[position()=1]")).getText();
	
	if(CommonFunctions.checkElementDisplayed(lnkViewAuditInfo)) {	
			Assert.assertEquals(actualPOD, data.get(CreateNceFields.POINT_OF_DISCOVERY)) ;
			Assert.assertEquals(actPOI, data.get(CreateNceFields.POINT_OF_INVESTIGATION));
		    Assert.assertEquals(actInfo, data.get(CreateNceFields.INFORMATION_RECEIVED_BY));
		    Assert.assertEquals(actNceCat, data.get(CreateNceFields.CATEGORY_OF_NCE));
		    visibility = true;
		    
		    System.out.println("Audit Information of the selected NCE displayed successfully");
		    	
		    }else
		    	System.out.println("View Audit Information validation Test Failed");
	return visibility;
	
	}

public boolean validateNewNce() throws Exception {
         
        CommonFunctions.waitForVisiblity(txtNewNce, 100);
         
		//Find out Log#
		String txt = txtNewNce.getText();
		String log = txt.substring(txt.indexOf("#")+1).trim();
		
		//Filter search
		selectReport();
		
		removeAllFilters();
		
//		removeFilter();	
		System.out.println("Filter removed");
		Thread.sleep(5000);
		CommonFunctions.waitForVisiblity(By.xpath("//input[@id='apexir_SEARCH']"), 100);
		ObjectHelper.driver.findElement(By.xpath("//input[@id='apexir_SEARCH']")).sendKeys(log);		
		CommonFunctions.waitandClick(By.xpath("//span[text()='Go']"), 100);
		Thread.sleep(5000);
		removeBreaks();		
		
		NCETable table = new NCETable(CreateNceFields.LOG);
		Hashtable<String, String> data = new Hashtable<>();
		data.put(CreateNceFields.LOG, log);
		System.out.println("Finding data from table...");
		boolean result = table.find(data);
		System.out.println("Search Result : "+ result);
		return result;
		
         }
	private void selectReport() {
		System.out.println("Selecting the report from combo...");
		CommonFunctions.waitForVisiblity(report, 100);
		Select select = new Select(report);
		select.selectByVisibleText("1. All NCEs");
		System.out.println("Report selected from combo");
	}
	private void removeAllFilters() {
		WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, 50);
		try {
			List<WebElement> filters =  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@title='Remove Filter']")));
			for(WebElement filter: filters) {
			ObjectHelper.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title='Remove Filter']")));
				filter.click();
				//Thread.sleep(10000);
				
			}
		}catch(Exception e) {
			e.getMessage();
			
		}
		
	}
	private void removeBreaks() {
		WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, 100);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title='Remove Breaks']"))).click();
		}catch(Exception e) {
			
		}
		
	}

//SELECT NCE WHICH HAS SECTION A ATTACHMENTS
public void selectNceReport(String log) throws Exception{
	
	removeAllFilters();
	System.out.println("Filter removed");
	Thread.sleep(5000);
	CommonFunctions.waitForVisiblity(By.xpath("//input[@id='apexir_SEARCH']"), 100);
	ObjectHelper.driver.findElement(By.xpath("//input[@id='apexir_SEARCH']")).sendKeys(log);		
	CommonFunctions.waitandClick(By.xpath("//span[text()='Go']"), 100);
	Thread.sleep(10000);
	removeBreaks();
	//Thread.sleep(4000);
}
	
public void viewAuditInfo(String log) throws Exception  {
	ObjectHelper.driver.findElement(By.xpath("//th[@id='NCE']//ancestor::table[position()=1]/descendant::td[text()='XXX']/following::a[text()='View']".replace("XXX", log))).click();
	
//	//VIEW AUDIT INFO
//	NCETable table = new NCETable(CreateNceFields.LOG);
//	Hashtable<String, String> data = new Hashtable<>();
//	data.put(CreateNceFields.LOG, log);
//	if(table.find(data)) {
//		CommonFunctions.waitandClick(By.xpath("//th[@id='NCE']//ancestor::table[position()=1]/descendant::td[text()='XXX']/following::a[text()='View']".replace("XXX", log)), 10);
//	}else
//	{
//		System.out.println("No records to display with the NCE Log Number searched for");
//	}
//	
	
	
	
}

//VERIFY AUDIT INFO OF SECTION A INITIAL SUBMISSION DISPLAYED
public boolean isAuditInfoDisplayed(String log) {
	boolean visibility = false;
	String actLog = ObjectHelper.driver.findElement(By.xpath("//td[text()='Log #']/following::td[position()=1]")).getText().trim();
	if(CommonFunctions.checkElementDisplayed(lnkViewAuditInfo)) {
		Assert.assertEquals(actLog, log);
		visibility = true;
		
	} else
		System.out.println( "Expected Audit Info of Selected NCE not displayed ");
	return visibility;
	
	
}
public boolean isSectionADisplayed() throws Exception{
	Boolean result = false;
	if((ObjectHelper.driver.findElements(By.xpath("//h1[text()='Section A - Initial Submission']")).size() != 0) &&
			(CommonFunctions.checkElementDisplayed(btnSaveAsDraft))&&
			(CommonFunctions.checkElementDisplayed(btnSubmit))&&
			(CommonFunctions.checkElementDisplayed(lnkAddAttchment))) {
	
	System.out.println("Section A Form Displayed to the User");
	result= true;	
		
	}
	else
		System.out.println("Section A Form is not Displayed");
	return result;
		
}



	 
}	 
	 
	 

	 
	 
	 

	 
	 
	 
	  
	  
	  
	  

