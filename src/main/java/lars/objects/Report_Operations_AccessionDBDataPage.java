package lars.objects;

import java.text.NumberFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

public class Report_Operations_AccessionDBDataPage extends LoadableComponent<Report_Operations_AccessionDBDataPage> {

	@FindBy(xpath = "//span[text()='prefix']/..//../following-sibling::td[1]//input[contains(@id,'txtValue')]")
	public WebElement prefixInput;
	
	
	@FindBy(xpath = "//span[text()='request Num']/..//../following-sibling::td[1]//input[contains(@id,'txtValue')]")
	public WebElement requestNumInput;
	
	
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement viewReportBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Loading')]")
	public WebElement spinners;
	
	@FindBy(xpath = "//input[@title='Current Page']")
	public WebElement currentPageInput;
	
	@FindBy(xpath = "//input[@id='ctl32_ctl05_ctl00_Last_ctl00_ctl00']")
	public WebElement lastPageImage;
	
	@FindBy(xpath = "//input[@id='ctl32_ctl05_ctl00_Previous_ctl00_ctl00']")
	public WebElement previousPageImage;
	
	
	@FindBy(xpath = "//span[contains(@id,'TotalPages')]")
	public WebElement totalPage;
	
	//span[contains(text(),'?')]
	
	
	
	
	WebDriver driver = null;

	int totalPageNumber = 1;
	
	public Report_Operations_AccessionDBDataPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		get();
	}

	

	@Override
	protected void isLoaded() throws Error {
	}

	@Override
	protected void load() {
	}

	public int verifySearchResultDelegateFeeTrackID(String aPrefix, String aRequestNum, String aDelegateFeeTrackID) {

		try {
			int aDelegateFeeTrackIDResult = 0;
			try {

					spinnersChecking();
					CommonFunctions.waitandClear(prefixInput, 30);
					//prefixInput.clear();
					//aPrefix = "14";
					//aRequestNum = "482170024";
					//aRequestNum = "425115065";
					
					
					prefixInput.sendKeys(aPrefix);
					
					CommonFunctions.waitandClear(requestNumInput, 30);
					requestNumInput.sendKeys(aRequestNum);
					
		
					CommonFunctions.waitandClick(viewReportBtn, 30);
					
					Thread.sleep(2000);
					spinnersChecking();
					
					//click end button if total page = 2 ?
					if (totalPage.getText().endsWith("?")){
					
						lastPageImage.click();
						Thread.sleep(2000);
						spinnersChecking();
						
						totalPageNumber = Integer.valueOf(Integer.valueOf(totalPage.getText()));
					}
					
					
					//check the result
					aDelegateFeeTrackIDResult = ObjectHelper.driver.findElements(By.xpath("//td/div[contains(text(),'" + aDelegateFeeTrackID + "')]")).size();	
		
					// see there is no result found or current page >  1, then continue
					while (aDelegateFeeTrackIDResult == 0 && totalPageNumber>1) {
						previousPageImage.click();
						Thread.sleep(2000);
						spinnersChecking();
						totalPageNumber--;
						aDelegateFeeTrackIDResult = ObjectHelper.driver.findElements(By.xpath("//td/div[contains(text(),'" + aDelegateFeeTrackID + "')]")).size();	
					}
						
					
					
					System.out.println("Number of bill Status for this table found: " + aDelegateFeeTrackIDResult + " Prefix=" + aPrefix + " requestNum=" + aRequestNum + " FeeTrackID=" + aDelegateFeeTrackID);
		
					return aDelegateFeeTrackIDResult;

			} catch (Exception e) {
				return aDelegateFeeTrackIDResult;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}



	public void spinnersChecking() {
		
		boolean spinnersExist = false;
		int startTime2;
		int elapsedTime2;
		
		try {
			
			
				startTime2 = 400;
				elapsedTime2 = startTime2 - 10;
				spinnersExist = CommonFunctions.waitForInVisiblity(spinners, 1);
				
				while (spinnersExist == false && elapsedTime2 > 10) {
					elapsedTime2 = elapsedTime2 -10;
					spinnersExist = CommonFunctions.waitForInVisiblity(spinners, 1);
				}
				// System.out.println("Spinners is not here or timeout: " + spinnersExist);
				
		} catch (Exception e) {
			System.out.println("Spinners is still here or timeout: " + spinnersExist);
		}
	}
	
}








	


	
