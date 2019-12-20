package oracleapexnce.objects;

import org.openqa.selenium.By;
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

public class NCE_CreateNcePage  {
	WebDriver driver;
    

    @FindBy(linkText = "NCE Home")
    WebElement lnkNceHome;
    @FindBy(linkText="Show All")
    WebElement lnkShowAll;
    @FindBy(linkText = "Section A - Initial Submission")
    WebElement lnkSectionAInitialSubmission;
    @FindBy(linkText = "Save Section A As Draft")
    WebElement lnkSaveAsDraft;
    @FindBy(linkText = "Submit Section A")
    WebElement lnkSubmit;
    @FindBy(linkText = "Cancel NCE")
    WebElement lnkCancelNce;
    
    
    //page elements in "Point of Discovery" radio buttons
     @FindBy(xpath = "//input[@ value='37' and @name='p_t15']")
     WebElement btnBillingPoD;
     @FindBy(xpath ="//input[@ value='36' and @name='p_t15']")
     WebElement btnGeneticsPoD;
     @FindBy(xpath ="//input[@value='38' and @name='p_t15']")
     WebElement btnMaterialManagementsPoD;
     @FindBy(xpath = "//input[@value='24' and @name='p_t15']" )
     WebElement btnSpecimenManagementPoD;
     @FindBy(xpath = "//input[@value='39' and @name='p_t15']")
     WebElement btnBusinessDevelopmentHospitalsPoD;
     @FindBy(id="P2_SA_POD_7")
     WebElement btnHematologyPoD;
     @FindBy(xpath = "//input[@value='31' and @name='p_t15']")
     WebElement btnMicrobiologyPoD;
     @FindBy(xpath = "//input[@value='100' and @name='p_t15']")
     WebElement btnOtherPoD;
     @FindBy(xpath = "//input[@value='34' and @name='p_t15']")
     WebElement btnCardiacCarePoD;
     @FindBy(xpath = "//input[@value='28' and @name='p_t15']")
     WebElement btnHistologyPoD;
     @FindBy(xpath = "//input[@value='32' and @name='p_t15']")
     WebElement btnPscPoD;
     @FindBy(xpath = "//input[@value='22' and @name='p_t15']")
     WebElement btnChemistryPoD;
     @FindBy(xpath = "//input[@value='35' and @name='p_t15']")
     WebElement btnHomeCarepoD;
     @FindBy(xpath = "//input[@value='33' and @name='p_t15']")
     WebElement btnQraPoD;
     @FindBy(xpath = "//input[@value='21' and @name='p_t15']")
     WebElement btnCustomerContactCentrePoD;
     @FindBy(xpath = "//input[@value='29' and @name='p_t15']")
     WebElement btnInformationTechnologyPoD;
     @FindBy(xpath = "//input[@value='41' and @name='p_t15']")
     WebElement btnRmaPoD;
     @FindBy(xpath = "//input[@value='23' and @name='p_t15']")
     WebElement btnCytologyPoD;
     @FindBy(xpath="//input[@value='30' and @name='p_t15']")
     WebElement btnLogisticsPoD;
     @FindBy(xpath = "//input[@value='27' and @name='p_t15']")
     WebElement btnSpecialityContractServicePoD;

     @FindBy(xpath = "//input[@class='superlov-input popup_lov' and@id='P2_SA_POD_LOCATION']")
    WebElement searchFldPoDLocations;
    //found 2(verify)
    @FindBy(xpath="//span[@class='ui-button-text' and text()='Clear Contents'] ")
    WebElement poDCloseBtn;
    //found 2(verify)
    @FindBy(xpath = "//span[@class='ui-button-text' and text()='Open Dialog']")
    WebElement dialogueBoxPoD;

    //page elements in "Point of Investigation" radio buttons
    @FindBy(xpath = "//input[@ value='37' and @name='p_t18']")
    WebElement btnBillingPoI;
    @FindBy(xpath ="//input[@ value='36' and @name='p_t18']")
    WebElement btnGeneticsPoI;
    @FindBy(xpath ="//input[@value='38' and @name='p_t18']")
    WebElement btnMaterialManagementsPoI;
    @FindBy(xpath = "//input[@value='24' and @name='p_t18']" )
    WebElement btnSpecimenManagementPoI;
    @FindBy(xpath = "//input[@value='39' and @name='p_t18']")
    WebElement btnBusinessDevelopmentHospitalsPoI;
    @FindBy(xpath = "//input[@value='26' and @name='p_t18']")
    WebElement btnHematologyPoI;
    @FindBy(xpath = "//input[@value='31' and @name='p_t18']")
    WebElement btnMicrobiologyPoI;
    @FindBy(xpath = "//input[@value='100' and @name='p_t18']")
    WebElement btnOtherPoI;
    @FindBy(xpath = "//input[@value='34' and @name='p_t18']")
    WebElement btnCardiacCarePoI;
    @FindBy(xpath = "//input[@value='28' and @name='p_t18']")
    WebElement btnHistologyPoI;
    @FindBy(xpath = "//input[@value='32' and @name='p_t18']")
    WebElement btnPscPoI;
    @FindBy(xpath = "//input[@value='22' and @name='p_t18']")
    WebElement btnChemistryPoI;
    @FindBy(xpath = "//input[@value='35' and @name='p_t18']")
    WebElement btnHomeCarePoI;
    @FindBy(xpath = "//input[@value='33' and @name='p_t18']")
    WebElement btnQraPoI;
    @FindBy(xpath = "//input[@value='21' and @name='p_t18']")
    WebElement btnCustomerContactCentrePoI;
    @FindBy(xpath = "//input[@value='29' and @name='p_t18']")
    WebElement btnInformationTechnologyPoI;
    @FindBy(xpath = "//input[@value='41' and @name='p_t18']")
    WebElement btnRmaPoI;
    @FindBy(xpath = "//input[@value='23' and @name='p_t18']")
    WebElement btnCytologyPoI;
    @FindBy(xpath="//input[@value='30' and @name='p_t18']")
    WebElement btnLogisticsPoI;
    @FindBy(xpath = "//input[@value='27' and @name='p_t18']")
    WebElement btnSpecialityContractServicePoI;

    @FindBy(xpath = "//input[@class='superlov-input popup_lov' and@id='P2_SA_LOCATION']")
    WebElement searchFldPoILocations;
    //found 2(verify)
    @FindBy(xpath="//span[@class='ui-button-text' and text()='Clear Contents'] ")
    WebElement poICloseBtn;
    //found 2(verify)
    @FindBy(xpath = "//span[@class='ui-button-text' and text()='Open Dialog']")
    WebElement dialogueBoxPoI;

    //Page Elements in Information Received By radio Buttons

    @FindBy(xpath = "//input[@value='40' and @name='p_t21']")
    WebElement btnemail;
    @FindBy(xpath = "//input[@value='39' and @name='p_t21']")
    WebElement btnfax;
    @FindBy(xpath = "//input[@value='37' and @name='p_t21']")
    WebElement btninPerson;
    @FindBy(xpath = "//input[@value='42' and @name='p_t21']")
    WebElement btnletter;
    @FindBy(xpath = "//input[@value='43' and @name='p_t21']")
    WebElement btnother;
    @FindBy(xpath = "//input[@value='38' and @name='p_t21']")
    WebElement btnphone;
    @FindBy(xpath = "//input[@value='41' and @name='p_t21']")
    WebElement btnquery;

    // Page elements in Category of NCE
    @FindBy(xpath = "//input[@value='45' and @name='p_t22']")
    WebElement btncollection;
    @FindBy(xpath = "//input[@value='46' and @name='p_t22']")
    WebElement btncontracts;
    @FindBy(xpath = "//input[@value='44' and @name='p_t22']")
    WebElement btncustomerComplaints;
    @FindBy(xpath = "//input[@value='47' and @name='p_t22']")
    WebElement btnproducts;
    @FindBy(xpath = "//input[@value='48' and @name='p_t22']")
    WebElement btnsampleProcessing;
    @FindBy(xpath = "//input[@value='49' and @name='p_t22']")
    WebElement btntesting;
    @FindBy(xpath = "//input[@value='100' and @name='p_t22']")
    WebElement btnotherCategory;
    
    @FindBy(xpath = "//textarea[@name='p_t24' and @id='P2_SA_REMEDIAL_ACTION_TAKEN']")
    WebElement txtremedialAction;
    @FindBy(xpath = "//textarea[@name='p_t25' and @id='P2_SA_DESCRIPTION']")
    WebElement txtdescriptionNce;
    @FindBy(xpath = "//input[ @id='P2_SA_ACCESSION_NUMBER']")
    WebElement txtaccessionNumber;


    // Page elements in Action Required Radio Button
    @FindBy(xpath = "//input[ @id='P2_SA_ADDITIONAL_INFO_REQUIRED_0']")
    WebElement btnNo;
    @FindBy(xpath = "P2_SA_ADDITIONAL_INFO_REQUIRED_1")
    WebElement btnYes;

    //page elements in Point of Cause Radio Button
    @FindBy(xpath = "//input[ @id='P2_SA_POINT_OF_CAUSE_0' and @name='p_t33'")
    WebElement btnPreanalytical;
    @FindBy(xpath = "//input[ @id='P2_SA_POINT_OF_CAUSE_1' and @name='p_t33']")
    WebElement btnAnalytical;
    @FindBy(xpath = "//input[ @id='P2_SA_POINT_OF_CAUSE_2' and @name='p_t33']")
    WebElement btnPostAnalytical;
    
    //page elements in  PreAnalytical Category
    @FindBy(xpath ="//input[ @id='P2_SA_PREANALYTICAL_CATEGORY_0' and @name='p_t34']\"" )
    WebElement btnCardiacPreAna;
    @FindBy(xpath = "//input[ @id='P2_SA_PREANALYTICAL_CATEGORY_0' and @name='p_t34']")
    WebElement btnHomeCare;
    @FindBy(xpath = "//input[ @id='P2_SA_PREANALYTICAL_CATEGORY_2' and @name='p_t34']")
    WebElement btnLogistics;
    @FindBy(xpath = "//input[ @id='P2_SA_PREANALYTICAL_CATEGORY_3' and @name='p_t34']")
    WebElement btnPsc;
    @FindBy(xpath = "//input[ @id='P2_SA_PREANALYTICAL_CATEGORY_4' and @name='p_t34']" )
    WebElement btnPhysican;
    @FindBy(xpath = "//input[ @id='P2_SA_SPECIMEN_AFFECTED_5' and @name='p_v44']" )
    WebElement btnOtherPreanalytical;
    
    //page elements in Specimen Affected radio buttons
    @FindBy(xpath ="//input[ @id='P2_SA_SPECIMEN_AFFECTED_0' and @name='p_v44']" )
    WebElement btnNoSpecimenAffected;
    @FindBy(xpath = "//input[ @id='P2_SA_SPECIMEN_AFFECTED_1' and @name='p_v44']")
    WebElement btnCardiac;
    @FindBy(xpath = "//input[ @id='P2_SA_SPECIMEN_AFFECTED_2' and @name='p_v44']")
    WebElement btnChemistry;
    @FindBy(xpath = "//input[ @id='P2_SA_SPECIMEN_AFFECTED_3' and @name='p_v44']")
    WebElement btnCytology;
    @FindBy(xpath = "//input[ @id='P2_SA_SPECIMEN_AFFECTED_4' and @name='p_v44']" )
    WebElement btnGenetics;
    @FindBy(xpath = "//input[ @id='P2_SA_SPECIMEN_AFFECTED_5' and @name='p_v44']" )
    WebElement btnHematology;
    @FindBy(xpath = "//input[ @id='P2_SA_SPECIMEN_AFFECTED_6' and @name='p_v44']" )
    WebElement btnHistology;
    @FindBy(xpath = "//input[ @id='P2_SA_SPECIMEN_AFFECTED_7' and @name='p_v44']" )
    WebElement btnMicrobiology;
    @FindBy(xpath = "//input[ @id='P2_SA_SPECIMEN_AFFECTED_8' and @name='p_v44']" )
    WebElement btnMicology;
    @FindBy(xpath = "//input[ @id='P2_SA_SPECIMEN_AFFECTED_9' and @name='p_v44']" )
    WebElement btnParasitology;
    @FindBy(xpath = "//input[ @id='P2_SA_SPECIMEN_AFFECTED_10' and @name='p_v44']" )
    WebElement btnUrinalysis;
    @FindBy(xpath = "//input[ @id='P2_SA_SPECIMEN_AFFECTED_11' and @name='p_v44']")
    WebElement otherSpecimenAffected;
    
  //page elements in Escalation to managers radio buttons
    @FindBy(xpath = "//input[ @id='P2_SA_ESCALATE_0' and @name='p_t46']")
    WebElement no;
    @FindBy(xpath = "//input[ @id='P2_SA_ESCALATE_1' and @name='p_t46']" )
    WebElement yes;
    
   //page elemnets in text box 
    @FindBy(id="P2_SA_NUM_EDITED_REPORTS")
    WebElement txtNoOfEdReport;
    @FindBy(id = "P2_SA_NUM_REPEATED_TESTS")
    WebElement txtNoOfRepTest;
    @FindBy(id = "P2_SA_NUM_PATIENT_RECALLS")
    WebElement txtNoPatientRecalls;
    
    @FindBy(linkText="Add Additional Attachments")
    WebElement lnkAdditionalAttachment;
    
    //page elements in dialogue box
    @FindBy(id="superlov-column-select")
    WebElement drpLocation; 
    @FindBy(id="superlov-filter")
    WebElement srchFld;
    @FindBy(xpath= "//div[@class='ui-state-highlight superlov-search-icon']")
    WebElement srchBtn;
    
    // Page elements in Preanalytical sub category group Cardiac
    @FindBy(xpath = "//input[ @name='p_t36' and @value='110']" )
    WebElement btnAmbp;
    @FindBy(xpath = "//input[ @name='p_t36' and @value='120']" )
    WebElement btnEcgSetup;
    @FindBy(xpath = "//input[ @name='p_t36' and @value='130']" )
    WebElement btnEcgTest;
    @FindBy(xpath = "//input[ @name='p_t36' and @value='140']" )
    WebElement btnEcgRepo;
    @FindBy(xpath = "//input[ @name='p_t36' and @value='145']" )
    WebElement btnHolter;
    
    
    
    
	    
    
    
    public NCE_CreateNcePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    } 
    
    private void click(WebElement webe) {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(webe)).click();
    
    }
    // Create New NCE page displayed
     public boolean isDisplayed() {
    	 return CommonFunctions.checkElementDisplayed(lnkSubmit);
    		
    		}
    	 
//CLICK POD 
       
    public void clickPod(String element) {
    	
    		element.toLowerCase();
    		try {
    		switch (element) {
    		case "billing":
    			click(btnBillingPoD);
    			break;
    		case "genetics":
    			click(btnGeneticsPoD);
    			break;
    		case "materialmanagement":
    			click(btnMaterialManagementsPoD);
    			break;
    		case "specimenmanagement":
    			click(btnSpecimenManagementPoD);
    			break;
    		case "businessdevelopmenthospitals":
    			click(btnBusinessDevelopmentHospitalsPoD);
    			break;
    		case "hematology":
    			click(btnHematologyPoD);
    			break;
    		case "microbiology":
    			click(btnMicrobiologyPoD);
    			break;
    		case "other":
    			click(btnOtherPoD);
    			break;
    		case "cardiaccare":
    			click(btnCardiacCarePoD);
    			break;
    		case "histology":
    			click(btnHistologyPoD);
    			break;
    		case "psc":
    			click(btnPscPoD);
    			break;
    		case "chemistry":
    			click(btnChemistryPoD);
    			break;
    		case "homecare":
    			click(btnHomeCarepoD);
    			break;
    		case "qra":
    			click(btnQraPoD);
    			break;
    		case "customercontactcentre":
    			click(btnCustomerContactCentrePoD);
    			break;
    		case "informationtechnology":
    			click(btnInformationTechnologyPoD);
    			break;
    		case "rma":
    			click(btnRmaPoD);
    			break;
    		case "cytology":
    			click(btnCytologyPoD);
    			break;
    		case "logistics":
    			click(btnLogisticsPoD);
    			break;
    		case "specialityandcontractservice":
    			click(btnSpecialityContractServicePoD);
    			break;
    		}
    		}catch(Exception e) {
  	    	  System.out.println(e.getMessage());
	    	  
  	      }
    	} 
    
    //SELECT POD LOCATION
    public void selectPodLocation(String text, String idNo ) throws Exception {
    	//to clear the filed
    	CommonFunctions.waitandClick(By.xpath("//*[@id=\"P2_SA_POD_LOCATION_holder\"]/tbody/tr/td[2]/div/button[1]/span[2]"), 10);
    	// To open the POD Location Box
    	CommonFunctions.waitandClick(By.xpath("//*[@id=\"P2_SA_POD_LOCATION_holder\"]/tbody/tr/td[2]/div/button[2]/span[2]"), 10);
    	selectFromLocationBox(text, idNo);
    }
    	
    private void selectFromLocationBox(String text, String idNo) {
    
          CommonFunctions.waitForVisiblityWithException(By.xpath("//input[@id='superlov-filter']"), 30);
    	try {
    		Select srchLocation = new Select(ObjectHelper.driver.findElement((By.xpath("//input[@id='superlov-column-select']"))));
    		srchLocation.selectByVisibleText(text);
    		srchFld.sendKeys(idNo);
    		srchBtn.click();
    		//mouse hover to address
    		Actions action = new Actions(ObjectHelper.driver);
    		action.moveToElement(ObjectHelper.driver.findElement(By.id(idNo))).click().perform();
    	
    	} catch(Exception e) {
	    	  System.out.println(e.getMessage());
	    	  
	      }
    }
    	
  
       	//CLICK POI	
		public void clickPoI(String element) {
				element.toLowerCase();
				switch (element) {
				case "billing":
					click(btnBillingPoI);
					break;
				case "genetics":
					click(btnGeneticsPoI);
					break;
				case "materialmanagement":
					click(btnMaterialManagementsPoI);
					break;
				case "specimenmanagement":
					click(btnSpecimenManagementPoI);
					break;
				case "businessdevelopmenthospitals":
					click(btnBusinessDevelopmentHospitalsPoI);
					break;
				case "hematology":
					click(btnHematologyPoI);
					break;
				case "microbiology":
					click(btnMicrobiologyPoI);
					break;
				case "other":
					click(btnOtherPoI);
					break;
				case "cardiaccare":
					click(btnCardiacCarePoI);
					break;
				case "histology":
					click(btnHistologyPoI);
					break;
				case "psc":
					click(btnPscPoI);
					break;
				case "chemistry":
					click(btnChemistryPoI);
					break;
				case "homecare":
					click(btnHomeCarePoI);
					break;
				case "qra":
					click(btnQraPoI);
					break;
				case "customercontactcentre":
					click(btnCustomerContactCentrePoI);
					break;
				case "informationtechnology":
					click(btnInformationTechnologyPoI);
					break;
				case "rma":
					click(btnRmaPoI);
					break;
				case "cytology":
					click(btnCytologyPoI);
					break;
				case "logistics":
					click(btnLogisticsPoI);
					break;
				case "specialityandcontractservice":
					click(btnSpecialityContractServicePoI);
					break;
				}
				
				    	
		}
		//SELECT POI LOCATION
		public void selectPoILocation(String text, String idNo ) throws Exception {
	    	//to clear the filed
	    	CommonFunctions.waitandClick(By.xpath("//*[@id=\"P2_SA_LOCATION_holder\"]/tbody/tr/td[2]/div/button[1]/span[2]"), 10);
	    	CommonFunctions.waitandClick(By.xpath("//*[@id=\"P2_SA_LOCATION_holder\"]/tbody/tr/td[2]/div/button[2]/span[2]"), 10);
	    	selectFromLocationBox(text, idNo);
	    	
		}
		// CLICK ONFORMATION RECEIVED BY
	
		public void clickInformationReceivedBy(String element) { 
	    	element.toLowerCase();
		switch (element) {
			case "email":
				btnemail.click();
				break;
			case "fax":
				btnfax.click();
				break;
			case "inPerson":
				btninPerson.click();
				break;
			case "letter":
				btnletter.click();
				break;
			case "other":
				btnother.click();
				break;
			case "phone":
				btnphone.click();
				break;
			case "query":
				btnquery.click();
				break;
			    }
		}
		// CLICK CATEGORY OF NCE
		
		public void clickCategoryOfNce(String element) {
			element.toLowerCase();
		switch (element) {
			case "collection":
				btncollection.click();
				break;
			case "contracts":
				btncontracts.click();
				break;
			case "customercomplaints":
				btncustomerComplaints.click();
				break;
			case "products":
				btnproducts.click();
				break;
			case "sampleprocessing":
				btnsampleProcessing.click();
				break;
			case "testing":
				btntesting.click();
				break;
			case "otherCategory":
				btnotherCategory.click();
				break;
			    }
			
		}
		public void enterRemedialAction(String text) {
			CommonFunctions.ClearAndSetText(txtremedialAction, text);
					
		}
		public void enterDescriptionOfNce(String text) {
			CommonFunctions.ClearAndSetText(txtdescriptionNce, text);
		}
		public void clickAdditinalInfoReqd(String element) {
			element.toLowerCase();
			switch (element) {
				case "no":
					btnNo.click();
					break;
				case "yes":
					btnYes.click();
					break;
		}
	}

		public void clickPointOfCause(String element){
			element.toLowerCase();
		switch (element) {
			case "preanalytical":
				btnPreanalytical.click();
				break;
			case "analytical":
				btnAnalytical.click();
				break;
			case "postAnalytical":
				btnPostAnalytical.click();
				break;
			
				}
		}
		public void clickPreAnalyticalCategory( String element) {
						
			CommonFunctions.waitForVisiblity(btnCardiac, 30);
			try {
			    element.toLowerCase();
		switch (element) {
			case "cardiac":
				btnCardiac.click();
				break;
			case "homeCare":
				btnHomeCare.click();
				break;
			case "logistics":
				btnLogistics.click();
				break;
			case "Psc":
				btnPsc.click();
				break;
			case "physican":
				btnPhysican.click();
				break;
			case "otherPreanalytical":
				btnOtherPreanalytical.click();
				break;
					}
			}catch(Exception e) {
			    	  System.out.println(e.getMessage());
			    	  
			      }
			}
		public void clickPreanalyticalSubCategoryGroup(String element) {
			CommonFunctions.waitForVisiblity(btnEcgRepo,20);
			try{
				element.toLowerCase();
	    		switch (element) {
	    		case "ambp":
	    			click(btnAmbp);
	    			break;
	    		case "ecgsetup":
	    			click(btnEcgSetup);
	    			break;
	    		case "ecgtest":
	    			click(btnEcgTest);
	    			break;
	    		case "ecgreporting":
	    			click(btnEcgRepo);
	    			break;
	    		case "holtermonitor":
	    			click(btnHolter);
	    			break;
			}
		} catch(Exception e) {
	    	  System.out.println(e.getMessage());
	    	  
	      }
		}
		// CLICK PREANALYTICAL SUB CATEGORY WHERE PREANALYTICAL SUBCATEGORY GROUP 'ECG REPORTING' IS SELECTED
		public void clickPreanalyticalSubCategory()throws Exception {
			CommonFunctions.waitandClick(By.xpath("//input[ @name='p_t37' and @value='180']"), 30);
		}
			
		public void clickSpecimenAffected(String element){
			element.toLowerCase();
		switch (element) {
			case "noSpecimenAffected":
				btnNoSpecimenAffected.click();
				break;
			case "cardiac":
				btnCardiac.click();
				break;
			case "chemistry":
				btnChemistry.click();
				break;
			case "cytology":
				btnCytology.click();
				break;
			case "genetics":
				btnGenetics.click();
				break;
			case "hematology":
				btnHematology.click();
				break;
			case "histology":
				btnHistology.click();
				break;
			case "microbiology":
				btnMicrobiology.click();
				break;
			case "micology":
				btnMicology.click();
				break;
			case "parasitology":
				btnParasitology.click();
				break;
			case "urinalysis":
				btnUrinalysis.click();
				break;
			case "other specimen affected":
				otherSpecimenAffected.click();
				break;
				
								
				}
		}
		public void clickImmediateEscalation(String element) {
				element.toLowerCase();
				switch (element) {
					case "no":
						no.click();
						break;
					case "yes":
						yes.click();
						break;
						}
		}
		private void sendKeys(WebElement element, String text )  {
			try {
			CommonFunctions.waitandClear(element, 10);
			element.sendKeys(text);
			
		}catch(Exception e) {
	    	  System.out.println(e.getMessage());
	      
	      }
		}
		public void enterTextBox(String reportNo, String repTst, String patRecalls) {
			sendKeys(txtNoOfEdReport, reportNo);
			sendKeys(txtNoOfRepTest, repTst);
			sendKeys(txtNoPatientRecalls, patRecalls);
		}
		
		public void selectReport(String text) {
			CommonFunctions.waitForVisiblity(By.id("apexir_SAVED_REPORTS"), 30);
			Select report = new Select(ObjectHelper.driver.findElement(By.xpath("//option[text()='1. All NCEs']")));
			report.selectByVisibleText( text);
				}
		public void clickSubmit () throws Exception {
			CommonFunctions.waitandClick(lnkSubmit, 20);
			
		}
		
		
		}
		
		
		
		

