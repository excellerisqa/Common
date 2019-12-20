package oracleapexnce.objects;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class NCE_ReferenceDocumentPage {
	 WebDriver driver; 
	 
	 
	 String xpnewFileRemove ="//div[@id='apexir_DATA_PANEL']//descendant::a[text()='XXX']//following::a[position()=1]";

	    @FindBy(id="apexir_SEARCH")
	    WebElement txtSearch;
	    @FindBy(id="apexir_btn_SEARCH")
	    WebElement btnGo;
	    @FindBy(id = "apexir_ACTIONSMENUROOT")
	    WebElement btnAction;
	    @FindBy(xpath= "//span[text()='Add ']")
	    WebElement btnAdd;
	    @FindBy(xpath="//span[text()='View ']")
	    WebElement btnView;
	    
	    // page elements in View-Attachment page
	    @FindBy(xpath="//div[@id=\"apexir_A_CREATED_DATE\"]")
	    WebElement createdDtLnk;
	    @FindBy(id="apexir_A_CREATED_BY")
	    WebElement createdtByLnk;
	    @FindBy(id="apexir_FILENAME")
	    WebElement fileName;
	    @FindBy(id="apexir_FILE_SIZE")
	    WebElement fileSize;
	    @FindBy(id="apexir_REMOVE")
	    WebElement removeBtn;
	    
	    //page elements in Attachmnets
	    @FindBy(xpath="//input[@id='P19_FILENAME']")
	    WebElement upload;
	    @FindBy(id="P19_UPLOAD")
	    WebElement btnUpload;
	    @FindBy(id="P19_CANCEL")
	    WebElement btnCancel;
	    
	    @FindBy(xpath="//div[@id='apexir_DATA_PANEL']//descendant::a[text()='FAQ Updated Aug 2016 PDF (8) upload.pdf']")
	    WebElement file;
	    
	    //page element in PopUp Message
	    @FindBy(xpath="//body[@id=\"TOP\"]//following::button[text()='Yes']")
	    WebElement btnYes;
	    @FindBy(xpath="//body[@id=\"TOP\"]//following::button[text()='No']")
	    WebElement btnNo;
	    
	    
	    
	    

	    public NCE_ReferenceDocumentPage(WebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver,this);
	    } 
	    private boolean isVisible(WebElement element){    	
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
	    public boolean isDisplayed() {
	    	 return CommonFunctions.isElementClickable(txtSearch);
	    }
	    
	    // REFERENCE LINK VALIDATION
	    
	    public boolean referenceLinkValidation(Hashtable<String, String> data) throws Exception {
	    	
	    	ObjectHelper.driver.findElement(By.xpath("//h1[text()='Reference Documents']")).isDisplayed();
	    		NCETable table = new NCETable("FILENAME");
	    		return table.find(data);
	    	
	    	}
	    	
	  //REFERENCE DOCUMENT VISBLE 
	    public boolean isReferenceDocumentVisible() {
	    	boolean visibility = false;
	    	
	    	try {
	    	CommonFunctions.waitandClick(btnView, 10);
	    	  		if((ObjectHelper.driver.findElements(By.id("apexir_A_CREATED_DATE")).size() != 0) &&
	    			(ObjectHelper.driver.findElements(By.id("apexir_A_CREATED_BY")).size() != 0) &&
	    			(ObjectHelper.driver.findElements(By.id("apexir_FILENAME")).size() != 0) &&
	    			(ObjectHelper.driver.findElements(By.id("apexir_FILE_SIZE")).size() != 0) &&
	    			(ObjectHelper.driver.findElements(By.id("apexir_REMOVE")).size() != 0))
	    		{
	    			System.out.println("Reference Documents are successfully displayed");
	    			visibility = true;
	    	    } else 
	    	    	System.out.println("Reference Documents not found");
	    	 
	    	    }
	    	      catch(Exception e) {
	    	    	 
	    	      }
	    	    return visibility; 
	    		    	
	    }
	    
	    //UPLOAD REFERENCE DOCUMENT
	    public void addReferenceDocument(String filename) throws Exception {
	    	    ObjectHelper.driver.findElement(By.xpath("//h1[text()='Reference Documents']")).isDisplayed();
	    		CommonFunctions.waitandClick(btnAdd, 40);
	    		ObjectHelper.driver.findElement(By.id("P19_FILENAME")).sendKeys("C:\\project\\oracleApexNCE\\upload-test\\FAQ Updated Aug 2016 PDF (8) upload.pdf");
	   			CommonFunctions.isElementClickable(upload);
	    		CommonFunctions.waitandClick(By.id("P19_UPLOAD"), 30);
	    		
//	    		
//	    		if(CommonFunctions.waitForDownload(filename, 30)) {
//	    			System.out.println("New File Successfully added with the existing Reference Documents");
//	    		}
	    		
	    		
	    }
	    
	//REMOVE NEWLY ADDED FILE    	
public void removeaddedFile(String addedFile) throws Exception {
	Thread.sleep(3000);
	CommonFunctions.waitandClick(btnView, 40);
	Thread.sleep(2000);
	//Click Remove Button and Remove the file
	ObjectHelper.driver.findElement(By.xpath(xpnewFileRemove.replace("XXX", addedFile))).click();
	CommonFunctions.waitandClick(btnYes, 30);
	//Click CANCEL BUTTON
	CommonFunctions.waitandClick(By.xpath("//div[@id='apexir_WORKSHEET']/preceding::input[@type='button']"), 10);
	}

//REFERENCE DOCUMENT VALIDATION AFTER ADDED FILE REMOVED FROM THE EXISTING REFERENCE DOCUMNET

public boolean referenceDocumentValidationAfterRemoval() {
	Boolean result = true;
	if(CommonFunctions.checkElementDisplayed(file))
	{
		System.out.println("File Found with the name searched for");
		
		
		
	}else
	{
		System.out.println("Test Case Passed:No records to display with the name searched for");
		result= false;
	}
		
	return result;
}
public boolean newReferenceDocumentDisplayed() {
	Boolean result =false;
	if(CommonFunctions.checkElementDisplayed(file))
	{
	result=true;
	System.out.println("File Found with the name searched for");
	}else
		System.out.println("Test Case Passed:No records to display with the name searched for");

return result;
}

}




	    
	    
	    		
	    
	    

