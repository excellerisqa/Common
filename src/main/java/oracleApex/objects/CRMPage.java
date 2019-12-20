	package oracleApex.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMPage {
	public WebDriver driver;

	@FindBy(linkText = "CRM")
	WebElement crm;
	
	@FindBy(linkText = "Clients")
	WebElement clients;
	
	@FindBy(linkText = "eTrack")
	WebElement eTrack;
	
	@FindBy(linkText = "CFM History")
	WebElement cfmHistory;
	
	@FindBy(linkText = "Genetic Clients")
	WebElement geneticClients;
	
	@FindBy(linkText = "Genetics Call Logs")
	WebElement geneticsCallLogs;
	
	@FindBy(linkText = "Create New Genetic Client")
	WebElement createGeneticClient;
	
	@FindBy(linkText = "Create")
	WebElement saveGeneticClient;
	
	@FindBy(linkText = "Cancel")
	WebElement cancelGeneticClient;
	
	@FindBy(linkText = "Delete")
	WebElement deleteGeneticClient;
	
	@FindBy(id = "P159_FIRST_NAME")
	WebElement geneticsClientFirstName;
	
	@FindBy(id = "P159_LAST_NAME")
	WebElement geneticsClientLastName;
	
	@FindBy(id = "P159_CITY")
	WebElement geneticsClientCity;
	
	@FindBy(id = "apexir_SEARCHDROPROOT")
	WebElement searchDropDown;
	
	@FindBy(linkText = "Firstname")
	WebElement firstNameSearch;
	
	@FindBy(xpath = "//input[@title='Search Report']")
	WebElement search;
	
	@FindBy(xpath = "//button[@value='Go']")
	WebElement go;
	
	@FindBy(xpath = "//a[contains(text(),'Firstname')]/../../td[4]/a/img")
	WebElement removeFirstNameFilter;
	
	public void click(String element) throws InterruptedException {
		switch (element) {
		case "crm":
			crm.click();
			break;
		case "clients":
			clients.click();
			break;
		case "etrack":
			eTrack.click();
			break;
		case "cfmhistory":
			cfmHistory.click();
			break;
		case "geneticclients":
			geneticClients.click();
			break;
		case "geneticscalllogs":
			geneticsCallLogs.click();
			break;
		case "creategeneticclient":
			createGeneticClient.click();
			break;
		case "geneticsclientlastname":
			geneticsClientLastName.click();
			break;
		case "savegeneticclient":
			saveGeneticClient.click();
			break;
		case "cancelgeneticclient":
			cancelGeneticClient.click();
			break;
		case "deletegeneticclient":
			deleteGeneticClient.click();
			break;
		case "searchdropdown":
			searchDropDown.click();
			break;
		case "firstnamesearch":
			firstNameSearch.click();
			break;
		case "go":
			go.click();
			break;
		case "removefirstnamefilter":
			removeFirstNameFilter.click();
			break;
		}
	}
	
	public void enterText(String element, String text) {
		element.toLowerCase();
		switch (element) {
		case "geneticsclientfirstname":
			geneticsClientFirstName.sendKeys(text);
			break;
		case "geneticsclientlastname":
			geneticsClientLastName.sendKeys(text);
			break;
		case "search":
			search.sendKeys(text);
			break;
		case "geneticsclientcity":
			geneticsClientCity.sendKeys(text);
			break;
		}
	}
	
	public void clear(String element) throws InterruptedException {
		switch (element) {
		case "geneticsclientcity":
			geneticsClientCity.clear();
			break;
		}
	}

	public CRMPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}