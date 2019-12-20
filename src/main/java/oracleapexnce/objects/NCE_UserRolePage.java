package oracleapexnce.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class NCE_UserRolePage {
	WebDriver driver; 
    //page elements in add User/Roles
    @FindBy(xpath="//span[text()='Clear Contents']")
    WebElement btnClear;
    @FindBy(xpath="//span[text()='Open Dialog']")
    WebElement btnOpenDialog;
    @FindBy(id="P1010_ADD_USER_ROLE")
    WebElement btnAddUser;
    
    //page elements in Select user page
    @FindBy(id="superlov-column-select")
    WebElement srchBox;
    @FindBy(id="superlov-filter")
    WebElement txtBox;
    @FindBy(xpath="//*[@id=\"superlov_styled_filter\"]/table/tbody/tr/td[2]/div/span")
    WebElement btnSrch;
    
    //Page elements in user Roles
    
    @FindBy(id="apexir_SEARCHDROPROOT")
    WebElement srchDrpBtn;
    @FindBy(id="apexir_SEARCH")
    WebElement srchTxt;
    @FindBy(id="apexir_btn_SEARCH")
    WebElement goBtn;
    @FindBy(linkText="Add User")
    WebElement lnkAddUser;
    //Page elements in User Open Dialog Box
    @FindBy(id="superlov-filter")
    WebElement srchField;
    @FindBy(xpath="//div[@id='superlov_styled_filter']/table/tbody/tr/td[2]/div/span")
    WebElement srchBtn;
    
    

    public NCE_UserRolePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickUserDialogeBox() throws Exception {
    	CommonFunctions.waitandClick(btnOpenDialog, 30);
    }
    public void selectSearchBox(String text) {
    	CommonFunctions.waitForVisiblityWithException(By.id("superlov-column-select"), 30);
    	Select drpSrch = new Select(srchBox);
		drpSrch.selectByVisibleText(text);
	    	
    }
    public void enterUserName(String userName) throws Exception {
    	try {
    		if(!userName.isEmpty()) {
    	    	CommonFunctions.waitandClear(txtBox, 30);
    	    	txtBox.sendKeys(userName);
    	    	CommonFunctions.waitandClick(btnSrch, 30);
    	    	
    	    }else
    	    	System.out.println("Search Field is empty");
    	  	
    }catch (Exception e )
    	{	    	
        System.out.println(e.getMessage());
    
    }
    	

    }

    public boolean verifyUserNameDisplayed() {
    	boolean visibility = true;
    	try {
    		if((ObjectHelper.driver.findElements(By.xpath("//th[text()='USER_NAME']")).size() != 0) &&
        			(ObjectHelper.driver.findElements(By.xpath("//th[text()='FIRST_NAME']")).size() != 0) &&
        			(ObjectHelper.driver.findElements(By.xpath("//th[text()='LAST_NAME']")).size() != 0) &&
        			(ObjectHelper.driver.findElements(By.xpath("//th[text()='FULLNAME']")).size() != 0) &&
        			(ObjectHelper.driver.findElements(By.xpath("//th[text()='PROVINCE']")).size()!=0 ))
    		{
    			System.out.println("User Information successfully displayed");
    	    } else 
    	    	System.out.println("User Information not Displayed");
    	 
    	    }
    	      catch(Exception e) {
    	    	  visibility = false;
    	      }
    	    return visibility; 
    	   }  
    public void SelectUserRoles(String userRole) throws Exception{
    	CommonFunctions.waitandClick(By.id("apexir_SEARCHDROPROOT"), 50);
    	CommonFunctions.waitandClick(By.id("ROLE"), 40);
    	enterUserRole(userRole);
    }
    public void enterUserRole(String userRole) {
    	try {
    		if(!userRole.isEmpty()) {
    	    	CommonFunctions.waitandClear(srchTxt, 40);
    	    	srchTxt.sendKeys(userRole);
    	    	CommonFunctions.waitandClick(goBtn, 30);
    	    	
    	    }else
    	    	System.out.println("Text Field is empty");
    	  	
    }catch (Exception e )
    	{	    	
        System.out.println(e.getMessage());
    
    }
    	

    }
    public void addNewUserManager(String text,String name, String role )throws Exception {
    	//SELECT USER- Clear the field 
    	CommonFunctions.waitandClick(btnClear, 40);
    	//SELECT FROM OPEN DIALOGUE BOX
    	CommonFunctions.waitandClick(btnOpenDialog, 80);
    	Thread.sleep(2000);
    	//SELECT FIRST NAME FROM SEARCH DROP DOWN BOX
    	 Select srch = new Select(ObjectHelper.driver.findElement((By.xpath("//select[@id='superlov-column-select']"))));
 		srch.selectByVisibleText(text);
 		srchField.sendKeys(name);
 		CommonFunctions.waitandClick(btnSrch, 50);
 		Thread.sleep(2000);
 		//Click the filtered address
 		String xp= "//td[text()='XXX']";
 		Actions action = new Actions(ObjectHelper.driver);
 		action.moveToElement(ObjectHelper.driver.findElement(By.xpath(xp.replace("XXX", name)))).click().perform();
 		System.out.println("New Manager name is selected");
 		Thread.sleep(2000);
 		CommonFunctions.waitForVisiblity(By.id("P1010_ROLE"),80);
 		//SELECT ROLE
 		System.out.println("Role Drop Down Box is Visible");
 		Select userRole = new Select(ObjectHelper.driver.findElement(By.id("P1010_ROLE")));
 		userRole.selectByVisibleText(role);
 		CommonFunctions.waitandClick(lnkAddUser, 40);
    	
    }
    private void removeAllFilters() {
		WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, 50);
		try {
			List<WebElement> filters =  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@title='Remove Filter']")));
			for(WebElement filter: filters) {
			ObjectHelper.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title='Remove Filter']")));
				filter.click();
				//Thread.sleep(10000);
				
			}
		}catch(Exception e) {
			e.getMessage();
			
		}
		
	}
    
    public void removeUsersRole(String firstName) throws Exception{
    	//FILTER SEARCH WITH FIRST NAME
    	//Click First name
    	Thread.sleep(2000);
    	ObjectHelper.driver.findElement(By.id("apexir_FIRST_NAME")).click();
    	//send Keys to the search Field
    	ObjectHelper.driver.findElement(By.id("apexir_search")).sendKeys(firstName);
    	Thread.sleep(2000);
    	//Mouse Hover to the Filtered name and click it
    	Actions action = new Actions(ObjectHelper.driver);
    	action.moveToElement(ObjectHelper.driver.findElement(By.xpath("//a[text()='XXX']".replace("XXX",firstName)))).click().build().perform();
    	
    	//CLICK REMOVE BUTTON
    	ObjectHelper.driver.findElement(By.xpath("//div[@id='apexir_DATA_PANEL']//descendant::img")).click();
    	removeAllFilters();
    	System.out.println("Newly added manager removed from the role");
    	 	
    }
    
    
    
    public boolean verifyUserRoleDisplayed() {
    	boolean visibility = true;
    	try {
    		if((ObjectHelper.driver.findElements(By.id("apexir_FIRST_NAME")).size() != 0) &&
    				(ObjectHelper.driver.findElements(By.id("apexir_LAST_NAME")).size() != 0) &&
    				(ObjectHelper.driver.findElements(By.id("apexir_E_MAIL")).size() != 0) &&
    				(ObjectHelper.driver.findElements(By.id("apexir_USER_NAME")).size() != 0) &&
    				(ObjectHelper.driver.findElements(By.id("apexir_ROLE")).size() != 0) &&
    		         (ObjectHelper.driver.findElements(By.id("apexir_PROVINCE")).size() != 0) &&
    		         (ObjectHelper.driver.findElements(By.id("apexir_REMOVE")).size() != 0))
    		{
    			System.out.println("User Role page displayed with the user information searched for");
    	    } else 
    	    	System.out.println("User Information not Displayed");
    	 
    	    }
    	      catch(Exception e) {
    	    	  visibility = false;
    	      }
    	    return visibility; 
    	   } 
    
    }


