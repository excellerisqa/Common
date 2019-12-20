package oracleapexnce.objects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

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

public class NCE_NonConformingEventsPage {
	WebDriver driver; 
	@FindBy(xpath="//input[@id='apexir_CURRENT_SEARCH_COLUMN']")
	WebElement srchDropDownBtn;
	@FindBy(id="apexir_SEARCH")
	WebElement srchTxt;
	@FindBy(xpath="//span[text()='Go']")
	WebElement btnGo;
	@FindBy(id="apexir_SAVED_REPORTS")
	WebElement reports;
	@FindBy(id="apexir_ACTIONSMENUROOT")
	WebElement actionBtn;
	

	
	//page elements in Save Report Page
	@FindBy(id="apexir_WORKSHEET_NAME")
	WebElement txtName;
	@FindBy(id="apexir_DESCRIPTION")
	WebElement txtDescription;
	@FindBy(id="apexir_PUBLIC")
	WebElement chkBoxPublic;
	
	@FindBy(linkText="Cancel")
	WebElement btnCancel;
	@FindBy(id="apexir_btn_APPLY")
	WebElement btnApply;
	
	

    public NCE_NonConformingEventsPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver,this);
} 
    
    public boolean isSelectedReportPageDisplayed() {
    	boolean visibility = true;
    	try {
    		if((ObjectHelper.driver.findElements(By.xpath("//div[text()='Log #']")).size() != 0) &&
					(ObjectHelper.driver.findElements(By.xpath("//div[text()='Action']")).size() != 0) &&
					(ObjectHelper.driver.findElements(By.xpath("//div[text()='Status']")).size() != 0) &&
				    (ObjectHelper.driver.findElements(By.xpath("//div[text()='Closed?']")).size() != 0)&&
                    (ObjectHelper.driver.findElements(By.xpath("//div[text()='Description']")).size() != 0)&&
                    (ObjectHelper.driver.findElements(By.xpath("//div[text()='Created Date']")).size() != 0)&&
                    (ObjectHelper.driver.findElements(By.xpath("//div[text()='Escalate']")).size() != 0)&&
                    (ObjectHelper.driver.findElements(By.xpath("//div[text()='Serious']")).size() != 0)&&
                    (ObjectHelper.driver.findElements(By.xpath("//div[text()='Incident Category']")).size() != 0)&&
                    (ObjectHelper.driver.findElements(By.xpath("//div[text()='Accession #']")).size() != 0))
    		{
    			System.out.println("Selected  Report Displayed with the Ranked Attributes");
    	    } else 
    	    	System.out.println("Selected  Report not Found");
    	 
    	    }
    	      catch(Exception e) {
    	    	  visibility = false;
    	    	  
    	      }
    	    return visibility; 
    	   }
    private void selectFromDropBox(WebElement webe, String text) {
    	CommonFunctions.isElementClickable(webe);
    	
    	Select select = new Select(webe);
    		select.selectByVisibleText(text);
    	}
    private void sendKeys(WebElement webElement, String keys){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(keys);
    }
    
    //CREATE NEW REPORT
   
    public String createNewReport( String srchOption, String txtSrchField, String report) throws Exception {
    	String xp = "//a[text()='XXX']";
    	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String txt=report+timeStamp;
    	
    	
    	//Select All NCE's
    	selectReport("1. All NCEs");
    	Thread.sleep(2000);
    	//Filter the search
    	CommonFunctions.waitandClick(By.id("apexir_SEARCHDROPROOT"), 30);
    	//Click Search Option from search button
    	CommonFunctions.waitandClick(By.xpath(xp.replace("XXX", srchOption)), 30);
    	CommonFunctions.ClearAndSetText(srchTxt, txtSrchField);
    	//Click Go
    	CommonFunctions.waitandClick(btnGo, 10);
    	Thread.sleep(3000);
    	//Click Action 
    	CommonFunctions.waitandClick(By.xpath("//span[text()='Actions']"), 30);
    	//Click 'Save Report' from Action Menu
    	CommonFunctions.waitandClick(By.xpath("//ul[@id='apexir_ACTIONSMENU']/descendant::a[text()=' Save Report']"), 30);
    	Thread.sleep(3000);
    	//Enter Fields in Save Report page
    	CommonFunctions.ClearAndSetText(txtName, txt);
    	ObjectHelper.driver.findElement(By.id("apexir_PUBLIC")).click();
    	//Click Apply
    	CommonFunctions.waitandClick(btnApply, 10);
    	Thread.sleep(2000);
    	System.out.println("Newly added Report:"+txt);
    	
    	return txt;
    }
    
    public String findAddedReport(String report) {
    	String newReport ="";
    	CommonFunctions.waitForVisiblity(By.id("apexir_SAVED_REPORTS"),40);
    	
    	Select drpdown = new Select(ObjectHelper.driver.findElement(By.id("apexir_SAVED_REPORTS")));
		//GET ALL ELEMENTS FROM REPORT DROPDOWN LIST
		List<WebElement> options = (List<WebElement>) drpdown.getOptions();
		System.out.println("Got all Listed Files From Report Combo Box");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		for(WebElement option: options) {
			 newReport = option.getText();
			if(newReport.contains(report)) {
				System.out.println("Newly added Report is:" + newReport);
				break;
			}
			
		}
		return newReport;
		
    }
    
    
    public void downloadpublicReport(String file) throws Exception {
    	 
    	WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, 30);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Actions']")));
    	//Click Action 
    	CommonFunctions.waitandClick(By.xpath("//span[text()='Actions']"),60);
    	//Click 'Download' from Action Menu
    	CommonFunctions.waitandClick(By.xpath("//ul[@id='apexir_ACTIONSMENU']/descendant::a[text()=' Download']"), 60);
    	//Select Download Options
    	CommonFunctions.waitandClick(By.xpath("//a[@id='apexir_dl_HTML']/img"), 60);
    	Thread.sleep(30000);
    	System.out.println("File Download completed");
    	
    }
		
    	// VERIFY NEW REPORT IS CREATED
    	public boolean validateNewReport(String report) {
    		boolean visibility = false;
    		CommonFunctions.waitForVisiblity(By.id("apexir_SAVED_REPORTS"), 30);
    		System.out.println("Report Combo Box is visible");
    		Select drpdown = new Select(ObjectHelper.driver.findElement(By.id("apexir_SAVED_REPORTS")));
    		//GET ALL ELEMENTS FROM REPORT DROPDOWN LIST
    		List<WebElement> options = (List<WebElement>) drpdown.getOptions();
    		System.out.println("Got all Listed Reports");
    		
    		for(WebElement option: options) {
    			String actReport = option.getText();
    			//String actReport = addedReport.substring(3).trim();
    			if(actReport.equals(report)) {
    		
    			visibility = true; 
    			System.out.println("The report successfully displayed with existing Reports as expected");
    			break;
    		}
    		 		
    	}return visibility;
    	}
    	
    public void selectReport(String report) {
    	CommonFunctions.waitForVisiblity(reports, 60);
    	Select select = new Select(reports);
    	select.selectByVisibleText(report);
    }
    
    public boolean findReport(String log, String status, String closed,  String escalate) throws InterruptedException {
		NCETable locTable = new NCETable("NCE");
		Hashtable<String, String> data = new Hashtable<>();
		data.put("NCE", log);
		//data.put("PRINT", action);
		data.put("N_STATUS_ID", status);
		data.put("N_OPEN_OR_CLOSED", closed);
		//data.put("SA_DESCRIPTION", description);
		//data.put("SA_CREATED_DATE", createdDate);
		data.put("ESCALATE", escalate);
		//data.put("SERIOUS", serious);	
		//data.put("SA_NCE_CATEGORY", incidentCategory);
		//data.put("SA_ACCESSION_NUMBER", accession);
		
		boolean found = locTable.find(data);
		return found;
	}

	public boolean isReportDisplayed(String newReport) {
		boolean visibility = false;
		selectReport(newReport);
		
		if(isSelectedReportPageDisplayed()) {
			visibility = true;
		}else
			System.out.println("There are no record that matched the result");
		
		return visibility;
		
		
	}

	
	
	
    
    

    

}


