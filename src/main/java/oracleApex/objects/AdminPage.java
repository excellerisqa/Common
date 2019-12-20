	package oracleApex.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
	public WebDriver driver;
	Select userDropdown;

	@FindBy(linkText = "Admin")
	WebElement admin;
	
	@FindBy(linkText = "User Profile")
	WebElement userProfile;
	
	@FindBy(linkText = "Create New User")
	WebElement createNewUser;
	
	@FindBy(linkText = "Location Profile")
	WebElement locationProfile;
	
	@FindBy(linkText = "Distribution Groups")
	WebElement distributionGroups;
	
	@FindBy(linkText = "Reason Groups")
	WebElement reasonGroups;
	
	@FindBy(linkText = "Reasons")
	WebElement reasons;
	
	@FindBy(linkText = "Business Unit Group")
	WebElement businessUnitGroup;
	
	@FindBy(linkText = "Genetics Product")
	WebElement geneticsProduct;

	@FindBy(linkText = "Help Content")
	WebElement helpContent;
	
	@FindBy(linkText = "Emails")
	WebElement emails;
	
	@FindBy(linkText = "Create New Location")
	WebElement createNewLocation;
	
	@FindBy(linkText = "Add Distribution Group")
	WebElement createNewDistributionGroup;
	
	@FindBy(linkText = "Create New Reason Group")
	WebElement createNewReasonGroup;
	
	@FindBy(linkText = "Create New Reason")
	WebElement createNewReason;
	
	@FindBy(linkText = "Create New Business Group")
	WebElement createNewBusinessGroup;
	
	@FindBy(linkText = "Create New Genetic Product")
	WebElement createNewGeneticProduct;
	
	@FindBy(id = "P151_STREET")
	WebElement newStreet;
	
	@FindBy(id = "P151_CITY")
	WebElement newCity;
	
	@FindBy(id = "P151_POSTAL_CODE")
	WebElement newPostalCode;
	
	@FindBy(id = "P151_PROVINCE")
	WebElement province_dropdown;
	
	@FindBy(id = "P163_BUSINESS_UNIT")
	WebElement newBusinessUnit;
	
	@FindBy(id = "P165_PRODUCT")
	WebElement newGeneticProduct;
	
	@FindBy(linkText = "Create")
	WebElement create;
	
	@FindBy(id = "P175_CODE")
	WebElement code;
	
	@FindBy(id = "P175_DESCRIPTION")
	WebElement description;
	
	@FindBy(id = "P175_E_MAIL")
	WebElement email;
	
	@FindBy(id = "P154_REASON")
	WebElement reasonGroup;
	
	@FindBy(id = "P156_REASON")
	WebElement newReason;
	
	@FindBy(id = "P154_PROVINCE")
	WebElement reasonGroup_province_dropdown;	
	
	@FindBy(id = "P156_PROVINCE")
	WebElement reason_province_dropdown;
	
	@FindBy(id = "P156_REASON_GROUP_ID")
	WebElement reasonGroup_dropdown;	
	
	@FindBy(id = "apexir_SEARCHDROPROOT")
	WebElement searchDropDown;
	
	@FindBy(id = "STREET")
	WebElement streetSearch;

	@FindBy(id = "CODE")
	WebElement codeSearch;
	
	@FindBy(id = "REASON")
	WebElement reasonSearch;
	
	@FindBy(id = "BUSINESS_UNIT")
	WebElement businessUnitSearch;
	
	@FindBy(id = "PRODUCT")
	WebElement geneticProductSearch;
	
	@FindBy(id = "USER_NAME")
	WebElement userNameSearch;
	
	@FindBy(xpath = "//input[@title='Search Report']")
	WebElement search;
	
	@FindBy(id = "apexir_btn_SEARCH")
	WebElement go;
	
	@FindBy(xpath = "//a[contains(text(),'User Name')]/../../td[4]/a/img")
	WebElement removeUserNameFilter;
	
	@FindBy(xpath = "//a[contains(text(),'Street')]/../../td[4]/a/img")
	WebElement removeStreetFilter;
	
	@FindBy(xpath = "//a[contains(text(),'Code')]/../../td[4]/a/img")
	WebElement removeCodeFilter;
	
	@FindBy(xpath = "//a[contains(text(),'Reason')]/../../td[4]/a/img")
	WebElement removeReasonFilter;
	
	@FindBy(xpath = "//a[contains(text(),'Business Unit')]/../../td[4]/a/img")
	WebElement removeBusinessUnitFilter;
	
	@FindBy(xpath = "//a[contains(text(),'Product')]/../../td[4]/a/img")
	WebElement removeGeneticProductFilter;
	
	@FindBy(xpath = "(//span[text()='Show Values']/..)[1]")
	WebElement addUserName;
	
	@FindBy(xpath = "(//span[text()='Show Values']/..)[2]")
	WebElement addLocation;
	
	@FindBy(xpath = "(//span[text()='Show Values']/..)[3]")
	WebElement copyLocationFromUser;
	
	@FindBy(xpath = "(//span[text()='Show Values']/..)[4]")
	WebElement copyLocationByProvince;
	
	@FindBy(xpath = "//span[text()='Save']")
	WebElement save;
	
	@FindBy(xpath = "//span[text()='Delete']")
	WebElement delete;
	
	@FindBy(xpath = "//button[text()='Yes']")
	WebElement confirmationYes;
	
	@FindBy(id = "P200_CLEAR")
	WebElement clearUserProfile;
	
	@FindBy(id = "CANCEL_BUTTON")
	WebElement cancelUserProfile;
	
	public void click(String element) throws InterruptedException {
		switch (element) {
		case "admin":
			admin.click();
			break;
		case "userprofile":
			userProfile.click();
			break;
		case "createnewuser":
			createNewUser.click();
			break;
		case "locationprofile":
			locationProfile.click();
			break;
		case "distributiongroups":
			distributionGroups.click();
			break;
		case "reasongroups":
			reasonGroups.click();
			break;
		case "reasons":
			reasons.click();
			break;
		case "businessunitgroup":
			businessUnitGroup.click();
			break;		
		case "geneticsproduct":
			geneticsProduct.click();
			break;	
		case "helpcontent":
			helpContent.click();
			break;	
		case "emails":
			emails.click();
			break;	
		case "createnewlocation":
			createNewLocation.click();
			break;
		case "createnewdistributiongroup":
			createNewDistributionGroup.click();
			break;
		case "createnewreasongroup":
			createNewReasonGroup.click();
			break;
		case "createnewreason":
			createNewReason.click();
			break;
		case "createnewbusinessgroup":
			createNewBusinessGroup.click();
			break;
		case "createnewgeneticproduct":
			createNewGeneticProduct.click();
			break;
		case "search":
			searchDropDown.click();
			break;		
		case "usernamesearch":
			userNameSearch.click();
			break;	
		case "streetsearch":
			streetSearch.click();
			break;	
		case "codesearch":
			codeSearch.click();
			break;
		case "reasonsearch":
			reasonSearch.click();
			break;
		case "businessunitsearch":
			businessUnitSearch.click();
			break;
		case "geneticproductsearch":
			geneticProductSearch.click();
			break;
		case "go":
			go.click();
			break;	
		case "removeusernamefilter":
			removeUserNameFilter.click();
			break;
		case "removestreetfilter":
			removeStreetFilter.click();
			break;
		case "removecodefilter":
			removeCodeFilter.click();
			break;
		case "removereasonfilter":
			removeReasonFilter.click();
			break;
		case "removebusinessunitfilter":
			removeBusinessUnitFilter.click();
			break;
		case "removegeneticproductfilter":
			removeGeneticProductFilter.click();
			break;
		case "addusername":
			addUserName.click();
			break;
		case "addlocation":
			addLocation.click();
			break;
		case "copylocationfromuser":
			copyLocationFromUser.click();
			break;
		case "copylocationbyprovince":
			copyLocationByProvince.click();
			break;
		case "save":
			save.click();
			break;
		case "delete":
			delete.click();
			break;
		case "create":
			create.click();
			break;
		case "confirmationyes":
			confirmationYes.click();
			break;
		case "clearuserprofile":
			clearUserProfile.click();
			break;
		case "canceluserprofile":
			cancelUserProfile.click();
			break;
		}
	}
	
	public void enterText(String element, String text) {
		element.toLowerCase();
		switch (element) {
		case "search":
			search.sendKeys(text);
			break;
		case "newstreet":
			newStreet.sendKeys(text);
			break;
		case "newcity":
			newCity.sendKeys(text);
			break;
		case "newpostalcode":
			newPostalCode.sendKeys(text);
			break;
		case "code":
			code.sendKeys(text);
			break;
		case "description":
			description.sendKeys(text);
			break;
		case "email":
			email.sendKeys(text);
			break;
		case "newreasongroup":
			reasonGroup.sendKeys(text);
			break;
		case "newreason":
			newReason.sendKeys(text);
			break;
		case "newbusinessunit":
			newBusinessUnit.sendKeys(text);
			break;	
		case "newgeneticproduct":
			newGeneticProduct.sendKeys(text);
			break;
		}
	}
	
	public void clear(String element) throws InterruptedException {
		switch (element) {
		case "code":
			code.clear();
			break;
		case "email":
			email.clear();
			break;
		}
	}
	
	public void select_dropdown(String element, String value) {
		switch (element) {
		case "newlocationprovince":
			userDropdown = new Select(province_dropdown);
			userDropdown.selectByValue(value);
			break;	
		case "newreasongroupprovince":
			userDropdown = new Select(reasonGroup_province_dropdown);
			userDropdown.selectByValue(value);
			break;
		case "newreasonprovince":
			userDropdown = new Select(reason_province_dropdown);
			userDropdown.selectByValue(value);
			break;
		case "reasonsgroup":
			userDropdown = new Select(reasonGroup_dropdown);
			userDropdown.selectByValue(value);
			break;
		}
		
	}

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}