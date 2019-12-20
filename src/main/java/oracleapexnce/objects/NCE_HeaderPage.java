package oracleapexnce.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class NCE_HeaderPage {
	WebDriver driver; 
	
	   @FindBy(linkText = "Welcome")
	    WebElement welcomeLnk;
	    @FindBy(xpath = "//a[@id='download']")
	    WebElement downloadBlankNCEFormLnk;
	    @FindBy(xpath="//a[text()='Help']")
	    WebElement help;
	    @FindBy(linkText = "Logout")
	    WebElement logoutBtn;
	    @FindBy(linkText="Non-Conforming Events")
	    WebElement nonConformingEventLnk;
	    @FindBy(linkText="Delegation")
	    WebElement delegationLnk;
	    @FindBy(linkText="User Management")
	    WebElement userManagementLnk;
	    @FindBy(linkText="Reference")
	    WebElement referenceLnk;
	    @FindBy(linkText="Admin")
	    WebElement adminLnk;
	    
	    
	   	    public NCE_HeaderPage(WebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver,this);
	    }
	   	    public void clickNonConformingEvent() throws Exception{
	   	    	CommonFunctions.waitandClick(nonConformingEventLnk, 10);
	   	    }
	   	    public void clickDelegation() throws Exception {
	   	    	CommonFunctions.waitandClick(delegationLnk, 10);
	   	    }
	   	    public void clickUserManagement() throws Exception {
	   	    	CommonFunctions.waitandClick(userManagementLnk, 10);
	   	    }
	   	    public void clickReference() throws Exception {
	   	    	CommonFunctions.waitandClick(referenceLnk, 10);
	   	    }
	   	    public void clickAdmin() throws Exception {
	   	    	CommonFunctions.waitandClick(adminLnk, 10);
	   	    }
	   	    public void clickDownloadBlankNceForm() throws Exception{
	   	    	CommonFunctions.waitandClick(downloadBlankNCEFormLnk, 10);
	   	    }
	   	    public void logOut() throws Exception {
	   	    	CommonFunctions.waitandClick(By.xpath("//a[text()='Logout']"), 30);
	   	    }
	   	    public void clickHelp() throws Exception {
	   	    	CommonFunctions.waitandClick(help, 40);
	   	    }
	   	      	      	    
	   	    

}
