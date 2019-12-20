package kronos.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferWidgetPage {
	public WebDriver driver;
	
	@FindBy(xpath = "//div[@class='span8']/div/div")
	WebElement company;
	
	@FindBy(xpath = "//div[@class='span8']/div/div/div/input")
	WebElement companyInput;
	
	@FindBy(xpath = "(//div[@class='span8']/div/div)[2]")
	WebElement function;
	
	@FindBy(xpath = "(//div[@class='span8']/div/div/div/input)[2]")
	WebElement functionInupt;
	
	@FindBy(xpath = "(//div[@class='span8']/div/div)[3]")
	WebElement subDivision;
	
	@FindBy(xpath = "(//div[@class='span8']/div/div/div/input)[3]")
	WebElement subDivisionInupt;
	
	@FindBy(xpath = "(//div[@class='span8']/div/div)[4]")
	WebElement org;
	
	@FindBy(xpath = "(//div[@class='span8']/div/div/div/input)[4]")
	WebElement orgInput;
	
	@FindBy(xpath = "(//div[@class='span8']/div/div)[5]")
	WebElement location;
	
	@FindBy(xpath = "(//div[@class='span8']/div/div/div/input)[5]")
	WebElement locationInput;
	
	@FindBy(xpath = "(//div[@class='span8']/div/div)[6]")
	WebElement costCentre;
	
	@FindBy(xpath = "(//div[@class='span8']/div/div/div/input)[6]")
	WebElement costCentreInput;
	
	@FindBy(xpath = "(//div[@class='span8']/div/div)[7]")
	WebElement jobCode;
	
	@FindBy(xpath = "(//div[@class='span8']/div/div/div/input)[7]")
	WebElement jobCodeInput;
	
	@FindBy(xpath = "//a[text()='Apply']")
	WebElement apply;

	public void click(String element) throws InterruptedException {
		element.toLowerCase();
		switch (element) {
		case "company":
			company.click();
			break;
		case "function":
			function.click();
			break;
		case "subdivision":
			subDivision.click();
			break;
		case "org":
			org.click();
			break;
		case "location":
			location.click();
			break;
		case "costcentre":
			costCentre.click();
			break;
		case "jobcode":
			jobCode.click();
			break;
		case "apply":
			apply.click();
			break;
		}
	}
	
	public void enterText(String element, String text) {
		element.toLowerCase();
		switch (element) {
		case "companyinput":
			companyInput.sendKeys(text);
			break;
		case "functioninput":
			functionInupt.sendKeys(text);
			break;
		case "subdivisioninput":
			subDivisionInupt.sendKeys(text);
			break;	
		case "orginput":
			orgInput.sendKeys(text);
			break;
		case "locationinput":
			locationInput.sendKeys(text);
			break;
		case "costcentreinput":
			costCentreInput.sendKeys(text);
			break;
		case "jobcodeinput":
			jobCodeInput.sendKeys(text);
			break;
		}
	}

	public TransferWidgetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}