package oracleapexnce.objects;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;



public class NCE_HomePage  {
	WebDriver driver;
	    
    @FindBy(linkText = "Create New NCE")
    WebElement lnkCreateNewNCE;
    

    public NCE_HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    
	public boolean isDisplayed() {
		return CommonFunctions.waitForVisiblity(lnkCreateNewNCE, 30);
		
	}
	public void clickCreateNewNCE() throws Exception {
		CommonFunctions.waitandClick(lnkCreateNewNCE, 30);
	}
	
	
	
	}
	
	


	
   

   

