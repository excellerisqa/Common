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

public class Report_Operations_BizTalkRulesListPage extends LoadableComponent<Report_Operations_BizTalkRulesListPage> {

	@FindBy(xpath = "//span[text()='Pattern']/..//../following-sibling::td[1]//input[contains(@id,'txtValue')]")
	public WebElement patternInput;
	
	
	@FindBy(xpath = "//input[@type='checkbox']")
	public WebElement nullCheckbox;
	
	@FindBy(xpath = "//select[contains(@id, 'ddValue')]")
	public WebElement selectOption;
	
	
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement viewReportBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Loading')]")
	public WebElement spinners;
	
	
	WebDriver driver = null;

	public Report_Operations_BizTalkRulesListPage(WebDriver driver) {
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

	public static void selectentitytype(String etype) {
		WebElement entitydd = ObjectHelper.driver.findElement(By.id("Entity"));
		Select entityDropDown = new Select(entitydd);
		entityDropDown.selectByVisibleText(etype);
	}
	
	public int verifySearchResultBusinessRules(String aBusinessRules) {
		
		

		try {
			int aBusinessRulesResult = 0;
			try {

					spinnersChecking();
					nullCheckbox.click();
					CommonFunctions.waitandClear(patternInput, 30);
					//prefixInput.clear();
					patternInput.sendKeys(aBusinessRules);
					
					Select entityDropDown = new Select(selectOption);
					entityDropDown.selectByVisibleText("All");
					
		
					CommonFunctions.waitandClick(viewReportBtn, 30);
					
					//Thread.sleep(5000);
					spinnersChecking();
					aBusinessRulesResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aBusinessRules + "')]")).size();	
		
					System.out.println("Number of bill Status for this table found: " + aBusinessRulesResult);
		
					return aBusinessRulesResult;

			} catch (Exception e) {
				return aBusinessRulesResult;
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








	


	
