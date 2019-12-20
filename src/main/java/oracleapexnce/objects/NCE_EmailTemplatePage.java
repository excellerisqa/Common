package oracleapexnce.objects;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class NCE_EmailTemplatePage {
	 WebDriver driver; 
	 
	 @FindBy(xpath="//a[text()='DELEGATE']")
	 WebElement emailDelegate;
	 @FindBy(xpath="//a[text()='DIRECTOR_DELEGATE_COMPLETE']")
	 WebElement emailDirectorDelegateComplete;
	 @FindBy(xpath="//a[text()='DIRECTOR_NORMAL']")
	 WebElement emailDirectorNormal;	 
	 @FindBy(xpath="//a[text()='DIRECTOR_SERIOUS']")
	 WebElement emailDirectorSerious;
	 
	 //page elements in Edit Email Template
	 @FindBy(linkText="Return")
	 WebElement btnReturn;
	 @FindBy(linkText="Apply Changes")
	 WebElement btnApplyChanges;
	 @FindBy(xpath="//textarea[@id='P1001_ET_TEMPLATE']/text()")
	 WebElement textEmail;
	 @FindBy(id="P1001_ET_TEMPLATE_DISPLAY")
	 WebElement Template;
	 @FindBy(xpath="//div[@id='P1001_ET_EMAIL_SUBJECT']")
	 WebElement txtEmailSubject;
	 
	 //Page elements in action processed
	 
	 @FindBy(xpath="//img[@class='uCheckmarkIcon']")
	 WebElement imgCheck;
	 @FindBy(xpath="//section[@id='uSuccessMessage']/div/div")
	 WebElement txtActionProcessed;
	 @FindBy(className="uCloseMessage")
	 WebElement btnClose;
	 
	 
	 
	 
	 
	    
	    public NCE_EmailTemplatePage(WebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver,this);
	    } 
	    public boolean isEmailTempaltesViewable() {
	    	boolean visibility = true;
	    	try {
	    		if((ObjectHelper.driver.findElements(By.id("apexir_TYPE")).size() != 0) &&
	    			(ObjectHelper.driver.findElements(By.id("apexir_DESCRIPTION")).size() != 0) &&
	    			(ObjectHelper.driver.findElements(By.id("apexir_TEMPLATE")).size() != 0) &&
	    			(ObjectHelper.driver.findElements(By.id("apexir_ET_PROVINCE")).size() != 0) )
	    		{
	    			System.out.println("Email Template page successfully displayed");
	    	    } else 
	    	    	System.out.println("Email Template page not properly displayed: ranked attributes not found");
	    	 
	    	    }
	    	      catch(Exception e) {
	    	    	  visibility = false;
	    	      }
	    	    return visibility; 
	    	   }
	    
	    public void clickEmail(String element) {
	    	if(CommonFunctions.checkElementDisplayed(emailDelegate))
			{
			   String e = element.toLowerCase();
		switch (e) {
			case "delegate":
				emailDelegate.click();
				break;
			case "directordelegatecomplete":
				emailDirectorDelegateComplete.click();
				break;
			case "directornormal":
				emailDirectorNormal.click();
				break;
			case "directorserious":
				emailDirectorSerious.click();
				break;	
				} 
			}else 
				CommonFunctions.waitForVisiblity(emailDelegate,30);
					
						}
	    
	    //EDIT EMAIL TEMPLATE
	    
	    public void editEmailTemplate(String newText) throws Exception {  
	    	WebElement template =ObjectHelper.driver.findElement(By.xpath("//*[@id='P1001_ET_TEMPLATE']"));
	    	WebElement esubjectTxt =ObjectHelper.driver.findElement(By.id("P1001_ET_EMAIL_SUBJECT"));
	    	String javascript = "document.getElementById('P1001_ET_TEMPLATE').setAttribute('textContent', 'XXX')".replace("XXX", newText);
	    	JavascriptExecutor js = (JavascriptExecutor) ObjectHelper.driver;	    	
	    	js.executeScript(javascript);
	    	CommonFunctions.sendKeysUsingJavaExecutor(template, newText);
	    	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	    	String text = "An Email has been delegated to you"+timeStamp;
	    	CommonFunctions.ClearAndSetText(esubjectTxt, text );
	    	CommonFunctions.waitandClick(By.linkText("Apply Changes"), 40);
	    	Thread.sleep(4000);

	    }
	    	
	    public boolean isActionProcessedDisplayed() {
	    	boolean visibility = false;
	    	if(CommonFunctions.checkElementDisplayed(txtActionProcessed)) {
	    		System.out.println("Action Processed Message displayed");
	    		visibility = true;
	    	}else
	    		System.out.println("No message displayed as Action processed");
	    	return visibility;
	    	
	    }
    	
       
	    
}

	    


