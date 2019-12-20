package rmalabs.objects;

import java.text.NumberFormat;
import java.util.List;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class RMA_LiveChat extends LoadableComponent<RMA_LiveChat> {


		
//Service Now
	
	@FindBy(xpath = "//input[@data-id='webchat-sendbox-input']")
	public WebElement typeYourMessage;
	
	@FindBy(xpath = "//button[@aria-label='Patient']")
	public WebElement patientBtn;
	
	@FindBy(xpath = "//button[@aria-label='Healthcare professional']")
	public WebElement healthcareBtn;
	
	@FindBy(xpath = "//button[@aria-label='Ontario']")
	public WebElement ontarioBtn;
	
	@FindBy(xpath = "//button[@aria-label='Saskatchewan']")
	public WebElement saskatchewanBtn;
	
	@FindBy(xpath = "//button[@aria-label='British Columbia']")
	public WebElement bcBtn;
	
	@FindBy(xpath = "//div[text()[contains(., 'RMA FST')]]")
	public WebElement rmafstBtn;
	
	@FindBy(xpath = "//div[text()[contains(., 'Candida Panel')]]")
	public WebElement candidaPanelBtn;
		
	@FindBy(xpath = "//div[text()[contains(., 'Celiac Profile')]]")
	public WebElement celiacProfileBtn;
	
	@FindBy(xpath = "//div[text()[contains(., 'IgA')]]")
	public WebElement IgABtn;
	
	@FindBy(xpath = "//div[text()[contains(., 'MELISA')]]")
	public WebElement MELISABtn;
	
	@FindBy(xpath = "//div[text()='Saliva']")
	public WebElement salivaBtn;
	
	@FindBy(xpath = "//div[text()[contains(., 'Urine')]]")
	public WebElement urineBtn;
	
	@FindBy(xpath = "//div[text()[contains(., 'Hair Cortisol')]]")
	public WebElement hairBtn;
	
	@FindBy(xpath = "//div[text()[contains(., 'Serum')]]")
	public WebElement serumBtn;
	
	
	@FindBy(xpath = "//div[text()[contains(., 'Hormone testing')]]")
	public WebElement hormoneBtn;
	
	
	@FindBy(xpath = "//div[text()[contains(., 'Gut-Well™ Digestive Stool Analysis')]]")
	public WebElement gutWellBtn;
	
	@FindBy(xpath = "//div[text()[contains(., 'Nutrigenomix®')]]")
	public WebElement nutrigenomixBtn;
	
	
	@FindBy(xpath = "//div[text()[contains(., 'Iodine Plus™')]]")
	public WebElement iodineBtn;
	
	@FindBy(xpath = "//div[text()[contains(., 'D-Spot™')]]")
	public WebElement dSpotBtn;
	
	@FindBy(xpath = "//div[text()[contains(., 'Fatty Acid Profile')]]")
	public WebElement fattyAcidBtn;
	
	@FindBy(xpath = "//div[text()[contains(., 'Element Analysis')]]")
	public WebElement elementAnalysisBtn;
	
	@FindBy(xpath = "//div[text()[contains(., 'Hair Element Analysis')]]")
	public WebElement hairElementAnalysisBtn;
	
	@FindBy(xpath = "//div[text()[contains(., 'Urine Element Analysis')]]")
	public WebElement urineElementAnalysisBtn;
	
	@FindBy(xpath = "//div[text()[contains(., 'Patient Assessment Panel')]]")
	public WebElement patientAssessmentPanelBtn;
	
	
	WebDriver driver = null;

	public RMA_LiveChat(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		get();
	}
	
	String lookingForHCP = "Looking for a healthcare provider? Find one here";
	String findAPractionerLink = "http://rma-dev.newsite.space/patients/find-a-practitioner";
	String patientAssessmentLink = "https://www.lifelabs.com/test/patient-assessment-panels/";
	
	

	@Override
	protected void isLoaded() throws Error {
	}

	@Override
	protected void load() {
	}


public boolean verifyKeywordsRMA(String[] input) {
	
	boolean result = false;
	try {

		Thread.sleep(1000);
		typeYourMessage.sendKeys(input[0]);
		typeYourMessage.sendKeys(Keys.ENTER);
		
		if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+lookingForHCP+"')]")), 20) && 
				CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[contains(text(), '"+findAPractionerLink+"')]")), 20) && 
				CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[@href='"+findAPractionerLink+"']")), 20) &&
			    CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[1]+"')]")), 20))
			{
				result = true;
			}
		else
			result=false;
		return result;
	} catch (Exception e) {
		System.out.println(e.getMessage());
		return result;
	}

}



public boolean submitQ2(String[] input, String aRole, String aProvince) {
	
	boolean result = false;
	try {

		Thread.sleep(1000);
		typeYourMessage.sendKeys(input[2]);
		typeYourMessage.sendKeys(Keys.ENTER);
		if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[3]+"')]")), 20))
			if(aRole=="Patient") {
				patientBtn.click();
				if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[4]+"')]")), 20)) {
					if (aProvince=="Ontario") {
						ontarioBtn.click();
						//Test panel display
						if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[5]+"')]")), 20)) {
							rmafstBtn.click();
							if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+lookingForHCP+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[contains(text(), '"+findAPractionerLink+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[@href='"+findAPractionerLink+"']")), 20) &&
							    CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[6]+"')]")), 20))
							{
								System.out.println("RMAFST Pass");
							}
							candidaPanelBtn.click();
							if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+lookingForHCP+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[contains(text(), '"+findAPractionerLink+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[@href='"+findAPractionerLink+"']")), 20) &&
							    CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[7]+"')]")), 20))
							{
								System.out.println("Candida Pass");
							}
							celiacProfileBtn.click();
							if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+lookingForHCP+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[contains(text(), '"+findAPractionerLink+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[@href='"+findAPractionerLink+"']")), 20) &&
							    CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[8]+"')]")), 20))
							{
								System.out.println("Celiac Profile Pass");
							}
						/*	
							IgABtn.click();
							if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+lookingForHCP+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[contains(text(), '"+findAPractionerLink+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[@href='"+findAPractionerLink+"']")), 20) &&
							    CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[9]+"')]")), 20))
							{
								System.out.println("IGA Pass");
							}
						*/	
							MELISABtn.click();
							if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+lookingForHCP+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[contains(text(), '"+findAPractionerLink+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[@href='"+findAPractionerLink+"']")), 20) &&
							    CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[10]+"')]")), 20))
							{
								System.out.println("MELISA Pass");
							}
							
							
							hormoneBtn.click();
							Thread.sleep(500);
			/*				
							salivaBtn.click();
							salivaBtn.click();
							
							if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+lookingForHCP+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[contains(text(), '"+findAPractionerLink+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[@href='"+findAPractionerLink+"']")), 20) &&
							    CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[11]+"')]")), 20))
							{
								System.out.println("saliva Pass");
							}
			*/				
			/*				
							urineBtn.click();
							Thread.sleep(1000);
							urineBtn.click();
							if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+lookingForHCP+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[contains(text(), '"+findAPractionerLink+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[@href='"+findAPractionerLink+"']")), 20) &&
							    CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[12]+"')]")), 20))
							{
								System.out.println("Urine Pass");
							}
			*/				
							
							hairBtn.click();
							Thread.sleep(1000);
							hairBtn.click();
							if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[13]+"')]")), 20))
							{
								System.out.println("Hair Cortisol Pass");
							}
				
							
							serumBtn.click();
							if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+lookingForHCP+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[contains(text(), '"+findAPractionerLink+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[@href='"+findAPractionerLink+"']")), 20) &&
							    CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[14]+"')]")), 20))
							{
								System.out.println("Serum Pass");
							}
				
			/*				
							gutWellBtn.click();
							if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+lookingForHCP+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[contains(text(), '"+findAPractionerLink+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[@href='"+findAPractionerLink+"']")), 20) &&
							    CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[15]+"')]")), 20))
							{
								System.out.println("Gut Well Pass");
							}
			*/	
							
							nutrigenomixBtn.click();
							if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+lookingForHCP+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[contains(text(), '"+findAPractionerLink+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[@href='"+findAPractionerLink+"']")), 20) &&
							    CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[16]+"')]")), 20))
							{
								System.out.println("Nutrigenomix Pass");
							}
							
							iodineBtn.click();
							if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+lookingForHCP+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[contains(text(), '"+findAPractionerLink+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[@href='"+findAPractionerLink+"']")), 20) &&
							    CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[17]+"')]")), 20))
							{
								System.out.println("Iodine Pass");
							}
			/*				
							dSpotBtn.click();
							if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+lookingForHCP+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[contains(text(), '"+findAPractionerLink+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[@href='"+findAPractionerLink+"']")), 20) &&
							    CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[18]+"')]")), 20))
							{
								System.out.println("D spot Pass");
							}
			*/				
							fattyAcidBtn.click();
							if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+lookingForHCP+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[contains(text(), '"+findAPractionerLink+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[@href='"+findAPractionerLink+"']")), 20) &&
							    CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[19]+"')]")), 20))
							{
								System.out.println("Fatty acid profile Pass");
							}
							
							elementAnalysisBtn.click();
							Thread.sleep(500);
			/*				
							hairElementAnalysisBtn.click();
							if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+lookingForHCP+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[contains(text(), '"+findAPractionerLink+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[@href='"+findAPractionerLink+"']")), 20) &&
							    CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[20]+"')]")), 20))
							{
								System.out.println("Hair Elementary Analysis Pass");
							}
			*/
			/*				
							urineElementAnalysisBtn.click();
							
							
							if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+lookingForHCP+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[contains(text(), '"+findAPractionerLink+"')]")), 20) && 
								CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[@href='"+findAPractionerLink+"']")), 20) &&
							    CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[21]+"')]")), 20))
							{
								System.out.println("Urine Elementary Analysis Pass");
							}
			*/				
							patientAssessmentPanelBtn.click();
							
							if(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[contains(text(), '"+patientAssessmentLink+"')]")), 20) && 
							   CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//a[@href='"+patientAssessmentLink+"']")), 20) &&
							   CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//p[contains(text(), '"+input[22]+"')]")), 20))
							{
									System.out.println("Patient Assessment Pass");
							}
						}
						Thread.sleep(30000);
					}
				
			}	
			else
				healthcareBtn.click();
		}	
		else
			result=false;
		return result;
	} catch (Exception e) {
		System.out.println(e.getMessage());
		return result;
	}

}



}








	


	
