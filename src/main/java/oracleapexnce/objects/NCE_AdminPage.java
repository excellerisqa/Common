package oracleapexnce.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class NCE_AdminPage {
	WebDriver driver;
	@FindBy(linkText ="Email Templates")
	WebElement emailTempLnk;
	@FindBy(linkText="User Roles")
	WebElement userRolelnk;
	@FindBy(linkText="Individual NCE Delegation")
	WebElement indNceDelLnk;
	@FindBy(linkText="Manager Delegation History")
	WebElement managerDelHisLnk;
	@FindBy(linkText="Download Blank NCE Audit")
	WebElement dwnldBlankNceAuditlnk;
	@FindBy(linkText="NCE Locations")
	WebElement nceLocationLnk;
	@FindBy(linkText="Manager/Director Link")
	WebElement managerDirectorLnk;
	@FindBy(linkText="View Emails")
	WebElement viewEmailLnk;
	@FindBy(linkText="NCI History")
	WebElement nciHistoryLnk;
	@FindBy(xpath="//input[@id='P0_PROVINCE_0']")
	WebElement allBtn;
	@FindBy(id="P0_PROVINCE_1")
	WebElement ontarioBtn;
	@FindBy(id="P0_PROVINCE_2")
	WebElement bcBtn;
	@FindBy(id="P0_PROVINCE_3")
	WebElement albertaBtn;
	@FindBy(id="P0_PROVINCE_4")
	WebElement skBtn;
	
	public NCE_AdminPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    } 
	
	public void clickEmailTemplate() throws Exception{
		CommonFunctions.waitandClick(emailTempLnk, 30);
	}
	public void clickUserRole() throws Exception{
		CommonFunctions.waitandClick(userRolelnk, 30);
	}
	public void clickIndividualNceDelegation() throws Exception{
		CommonFunctions.waitandClick(indNceDelLnk, 30);
	}
	public void clickManagerDelegationHistory() throws Exception{
		CommonFunctions.waitandClick(managerDelHisLnk, 30);
	}
	public void clickDownlaodBlankNceAuditLnk() throws Exception{
		CommonFunctions.waitandClick(dwnldBlankNceAuditlnk, 30);
	}
	public void clickNceLocation() throws Exception{
		CommonFunctions.waitandClick(nceLocationLnk, 30);
	}
	public void clickMangerDirector() throws Exception{
		CommonFunctions.waitandClick(managerDirectorLnk, 30);
	}
	public void clickViewEmail() throws Exception{
		CommonFunctions.waitandClick(viewEmailLnk, 30);
	}
	public void clickNciHistory() throws Exception{
		CommonFunctions.waitandClick(nciHistoryLnk, 30);
	}
	
	public void selectProvince(String province) {
		
		String p =	province.toLowerCase().trim();
		switch (p) {
			case "all":
				allBtn.click();
				break;
			case "ontario":
				ontarioBtn.click();
				break;
			case "british columbia":
				bcBtn.click();
				break;
			case "alberta":
				albertaBtn.click();
				break;
			case "saskatchewan":
				skBtn.click();
				break;
							
				}
	}

	
	
	
	
	
	
	
	

}
