package eOrder.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_eOrderPage2 {
                public WebDriver driver;

                // to verify if navigated to page 2 of Create eOrder form
                @FindBy(xpath = "//span[contains(text(),'OHIP Laboratory')]")
                WebElement TextOnPage2;

                // Fields on page 2
                @FindBy(xpath = "//button[@class='select-button required-field']//div")
                WebElement OrderedBy;

                // matching by Doctor's name in Ordered By dropdown
                @FindBy(xpath = "//div[@class='dropdown open']//span[contains(text(),'Dr. ELIZABETH BLAKE')]")
                WebElement DrElizabethBlake;

                @FindBy(xpath = "//div[@class='dropdown open']//span[contains(text(),'Dr. GRAEME TESTING')]")
                WebElement DrGraemeTesting;

                @FindBy(xpath = "//div[@class='dropdown open']//span[contains(text(),'Dr. J ABISCOTT')]")
                WebElement DrJAbiscott;

                @FindBy(xpath = "//div[@class='dropdown open']//span[contains(text(),'ABLE LIVING SERVICES')]")
                WebElement DrAbleLivingServices;

                @FindBy(xpath = "//div[@class='dropdown open']//span[contains(text(),'Dr. GREG ARMSTRONG')]")
                WebElement DrGregArmstrong;
                
                @FindBy(xpath = "//div[@class='dropdown open']//span[contains(text(),'Dr. KMCWILLIAM TESTING')]")
                WebElement DrKmcwilliamTesting;

                // if there is only 1HCP available
                @FindBy(xpath = "//button[@class='select-button']//div")
                WebElement OrderedBy_1HCP;

                @FindBy(xpath = "//input[@placeholder='Search by Family Name']")
                WebElement CopyTo;

                @FindBy(xpath = "//i[@class='fa fa-pencil']")
                WebElement StandingOrder;

                // options under Standing Order
                @FindBy(xpath = "//app-checkbox[@formcontrolname='standingOrder']//span")
                WebElement RequestStandingOrder;

                @FindBy(xpath = "//textarea")
                WebElement Notes;

                @FindBy(xpath = "//app-input[@formcontrolname='diagnosisCode']//input")
                WebElement Diagnosis;

                @FindBy(xpath = "//label[contains(text(),'Start')]//following-sibling::input")
                WebElement StartDate;

                @FindBy(xpath = "//label[contains(text(),'Frequency')]//parent::div//button//div[1]")
                WebElement Frequency;

                @FindBy(xpath = "//a[contains(text(),'Monthly')]")
                WebElement MonthlyFrequency;

                @FindBy(xpath = "//label[contains(text(),'Duration')]//following-sibling::input")
                WebElement Duration;

                @FindBy(xpath = "//button[contains(text(),'Update Options')]")
                WebElement UpdateOptions;

                // Bill To options
                @FindBy(xpath = "//input[@id='72']//following-sibling::span")
                WebElement BillTo_Insured;

                @FindBy(xpath = "//input[@id='73']//following-sibling::span")
                WebElement BillTo_Uninsured;

                @FindBy(xpath = "//input[@id='74']//following-sibling::span")
                WebElement BillTo_WSIB;
                
                //Element for 'Pregnant'
                @FindBy(xpath = "//div[@class='checkbox-btn']//input[@id='20']//following-sibling::span")
                WebElement Pregnant;

                // Select Other Tests
                @FindBy(xpath = "//input[@placeholder='Type test name']")
                WebElement SelectOtherTests;

                // List of Tests
                @FindBy(xpath = "//div[@class='checkbox-btn']//input[@id='23']//following-sibling::span")
                WebElement Test_GlucoseRandom;

                @FindBy(xpath = "//div[@class='checkbox-btn']//input[@id='24']//following-sibling::span")
                WebElement Test_GlucoseFasting;

                @FindBy(xpath = "//div[@class='checkbox-btn']//input[@id='25']//following-sibling::span")
                WebElement Test_HbA1C;

                @FindBy(xpath = "//div[@class='checkbox-btn']//input[@id='41']//following-sibling::span")
                WebElement Test_PregnancyTest;

                @FindBy(xpath = "//div[@class='checkbox-btn']//input[@id='45']//following-sibling::span")
                WebElement Test_RepeatPrenatalAntibodies;

                @FindBy(xpath = "//div[@class='checkbox-btn']//input[@id='46']//following-sibling::span")
                WebElement Test_Cervical;

                @FindBy(xpath = "//div[@class='checkbox-btn']//input[@id='52']//following-sibling::span")
                WebElement Test_Throat;

                @FindBy(xpath = "//div[@class='checkbox-btn']//input[@id='39']//following-sibling::span")
                WebElement Test_CBC;

                @FindBy(xpath = "//div[@class='checkbox-btn']//input[@id='62']//following-sibling::span")
                WebElement Test_AcuteHepatitis;

                @FindBy(xpath = "//div[@class='checkbox-btn']//input[@id='65']//following-sibling::span")
                WebElement Test_HepatitisB;

                @FindBy(xpath = "//div[@class='checkbox-btn']//input[@id='68']//following-sibling::span")
                WebElement Test_FreePSA;

                @FindBy(xpath = "//div[@class='checkbox-btn']//input[@id='69']//following-sibling::span")
                WebElement Test_VitDInsured;

                @FindBy(xpath = "//div[@class='checkbox-btn']//input[@id='61']//following-sibling::span")
                WebElement Test_CCC;
                
                @FindBy(xpath = "//div[@class='checkbox-btn']//input[@id='53']//following-sibling::span")
                WebElement Test_Urine;
                
                @FindBy(xpath = "//div[@class='checkbox-btn']//input[@id='50']//following-sibling::span")
                WebElement Test_GC;
                
                @FindBy(xpath = "//div[@class='checkbox-btn']//input[@id='55']//following-sibling::span")
                WebElement Test_Stool;

                // Options for specimen details
                @FindBy(xpath = "//input[@placeholder='HH']")
                WebElement SpecimenCollection_Hours;

                @FindBy(xpath = "//input[@placeholder='MM']")
                WebElement SpecimenCollection_Minutes;

                @FindBy(xpath = "//app-date[@placeholder='Date']//input")
                WebElement SpecimenCollection_Date;

                // Other options on the page
                @FindBy(xpath = "//button[contains(text(),'Submit')]")
                WebElement SubmitAccession;

                @FindBy(xpath = "//button[contains(text(),'Back')]")
                WebElement BackBtn;

                @FindBy(xpath = "//button[contains(text(),'Cancel')]")
                WebElement CancelBtn;

                @FindBy(xpath = "//div[contains(text(),'Successfully')]")
                WebElement eOrderSuccessMessage;

                @FindBy(xpath = "//button[@tabindex='100']")
                WebElement PrintBtn;

                @FindBy(xpath = "//button[@tabindex='103']")
                WebElement CloseBtn;

                @FindBy(xpath = "//button[contains(text(),'Discard eOrder')]")
                WebElement DiscardeOrder;

                @FindBy(xpath = "//i[@class='fa fa-plus']")
                WebElement AddCopyTo;

                @FindBy(xpath = "//button[@data-dismiss='modal']//i")
                WebElement CloseStandingOrder;

                @FindBy(xpath = "//div[@id='toast-container']//span[@class='toast-message']")
                WebElement serverError;

                public boolean serverErrDisplayed() {
                                return serverError.isDisplayed();
                }

                public void enterText(String element, String text) {
                                element.toLowerCase();
                                switch (element) {
                                case "orderedby":
                                                OrderedBy.sendKeys(text);
                                                break;
                                case "copyto":
                                                CopyTo.sendKeys(text);
                                                break;
                                case "startdate":
                                                StartDate.sendKeys(text);
                                                break;
                                case "duration":
                                                Duration.clear();
                                                Duration.sendKeys(text);
                                                break;
                                case "selectothertests":
                                                SelectOtherTests.sendKeys(text);
                                                break;
                                case "diagnosis":
                                                Diagnosis.sendKeys(text);
                                                break;
                                case "notes":
                                                Notes.sendKeys(text);
                                                break;
                                }
                }

                public boolean eOrderSuccessMessage() {
                                String actualMsg = eOrderSuccessMessage.getText();
                                String expectedMsg = "Successfully Submitted";
                                if (actualMsg.contains(expectedMsg)) {
                                                return true;
                                } else {
                                                return false;
                                }
                }

                public void click(String element) {
                                element.toLowerCase();
                                switch (element) {
                                case "orderedby":
                                                OrderedBy.click();
                                                break;
                                case "orderedby_1hcp":
                                                OrderedBy_1HCP.click();
                                                break;
                                case "standingorder":
                                                StandingOrder.click();
                                                break;
                                case "requeststandingorder":
                                                RequestStandingOrder.click();
                                                break;
                                case "startdate":
                                                StartDate.click();
                                                break;
                                case "frequency":
                                                Frequency.click();
                                                break;
                                case "monthlyfrequency":
                                                MonthlyFrequency.click();
                                                break;
                                case "duration":
                                                Duration.click();
                                                break;
                                case "updateoptions":
                                                UpdateOptions.click();
                                                break;
                                case "selectothertests":
                                                SelectOtherTests.click();
                                                break;
                                case "submit":
                                                SubmitAccession.click();
                                                break;
                                case "back":
                                                BackBtn.click();
                                                break;
                                case "cancel":
                                                CancelBtn.click();
                                                break;
                                case "print":
                                                PrintBtn.click();
                                                break;
                                case "close":
                                                CloseBtn.click();
                                                break;
                                case "discardeorder":
                                                DiscardeOrder.click();
                                                break;
                                case "addcopyto":
                                                AddCopyTo.click();
                                                break;
                                case "closestandingorder":
                                                CloseStandingOrder.click();
                                                break;
                                case "pregnant":
                                                Pregnant.click();
                                                break;
                                }
                }

                // Options when a NEW COPY TO patient is to be added
                @FindBy(xpath = "//app-input[@placeholder='Last Name']//input")
                WebElement AddCopy_LastName;

                @FindBy(xpath = "//app-input[@placeholder='First Name']//input")
                WebElement AddCopy_FirstName;

                @FindBy(xpath = "//app-input[@placeholder='Address Line 1']//input")
                WebElement AddCopy_AddressLine1;

                @FindBy(xpath = "//app-input[@placeholder='Address Line 2']//input")
                WebElement AddCopy_AddressLine2;

                @FindBy(xpath = "//app-input[@placeholder='City']//input")
                WebElement AddCopy_City;

                @FindBy(xpath = "//app-input[@placeholder='Postal Code']//input")
                WebElement AddCopy_PostalCode;

                @FindBy(xpath = "//app-input[@placeholder='Phone Number']//input")
                WebElement AddCopy_PhoneNumber;

                @FindBy(xpath = "//app-dropdown[@formcontrolname='province']//i")
                WebElement Provincedpd;

                @FindBy(xpath = "//button[contains(text(),'Ok')]")
                WebElement AddCopy_Okbtn;

                public void AddCopy_selectProvince(String provinceName) {
                                Provincedpd.click();
                                List<WebElement> provinces = driver.findElements(By.xpath("//app-dropdown[@formcontrolname='province']//a"));
                                for (WebElement province : provinces) {
                                                if ((province.getText()).equalsIgnoreCase(provinceName)) {
                                                                province.click();
                                                }
                                }
                }

                @FindBy(xpath = "//app-dropdown[@formcontrolname='country']//i")
                WebElement Countrydpd;

                public void AddCopy_selectCountry(String countryName) {
                                Countrydpd.click();
                                List<WebElement> countries = driver.findElements(By.xpath("//app-dropdown[@formcontrolname='country']//a"));
                                for (WebElement country : countries) {
                                                if ((country.getText()).equalsIgnoreCase(countryName)) {
                                                                country.click();
                                                }
                                }
                }

                public void addCopyToClient(String lastName, String firstName, String addressLine1, String addressLine2,
                                                String city, String provinceName, String postalCode, String countryName, String phoneNumber)
                                                throws InterruptedException {
                                AddCopyTo.click();
                                Thread.sleep(1000);
                                try {
                                                AddCopy_LastName.sendKeys(lastName);
                                                AddCopy_FirstName.sendKeys(firstName);
                                                Thread.sleep(1000);
                                                AddCopy_AddressLine1.sendKeys(addressLine1);
                                                AddCopy_AddressLine2.sendKeys(addressLine2);
                                                Thread.sleep(1000);
                                                AddCopy_City.sendKeys(city);
                                                Thread.sleep(500);
                                                AddCopy_selectProvince(provinceName);
                                                Thread.sleep(500);
                                                AddCopy_PostalCode.sendKeys(postalCode);
                                                Thread.sleep(500);
                                                AddCopy_selectCountry(countryName);
                                                Thread.sleep(500);
                                                AddCopy_PhoneNumber.sendKeys(phoneNumber);
                                                Thread.sleep(1000);
                                                AddCopy_Okbtn.click();

                                } catch (Exception e) {
                                                e.printStackTrace();
                                }

                }

                public void selectBillTo(String BillType) {
                                BillType.toLowerCase();
                                switch (BillType) {
                                case "insured":
                                                BillTo_Insured.click();
                                                break;
                                case "uninsured":
                                                BillTo_Uninsured.click();
                                                break;
                                case "wsib":
                                                BillTo_WSIB.click();
                                                break;
                                }
                }

                public void selectTest(String TestName) {
                                TestName.toLowerCase();
                                switch (TestName) {
                                case "acutehepatitis":
                                                Test_AcuteHepatitis.click();
                                                break;
                                case "freepsa":
                                                Test_FreePSA.click();
                                                break;
                                case "hepatitisb":
                                                Test_HepatitisB.click();
                                                break;
                                case "vitdinsured":
                                                Test_VitDInsured.click();
                                                break;
                                case "cbc":
                                                Test_CBC.click();
                                                break;
                                case "ccc":
                                                Test_CCC.click();
                                                break;
                                case "cervical":
                                                Test_Cervical.click();
                                                break;
                                case "glucosefasting":
                                                Test_GlucoseFasting.click();
                                                break;
                                case "glucoserandom":
                                                Test_GlucoseRandom.click();
                                                break;
                                case "hba1c":
                                                Test_HbA1C.click();
                                                break;
                                case "pregnancytest":
                                                Test_PregnancyTest.click();
                                                break;
                                case "repeatprenatalantibodies":
                                                Test_RepeatPrenatalAntibodies.click();
                                                break;
                                case "throat":
                                                Test_Throat.click();
                                                break;
                                case "urine":
                                                Test_Urine.click();
                                                break;
                                case "gc":
                                                Test_GC.click();
                                                break;
                                case "stool":
                                				Test_Stool.click();
                                				break;
                                }
                }

                public void selectDoctor(String name) throws InterruptedException {
                                name.toLowerCase();
                                switch (name) {
                                case "als":
                                                Thread.sleep(2000);
                                                DrAbleLivingServices.click();
                                                break;
                                case "eb":
                                                Thread.sleep(2000);
                                                DrElizabethBlake.click();
                                                break;
                                case "gt":
                                                Thread.sleep(2000);
                                                DrGraemeTesting.click();
                                                break;
                                case "ga":
                                                Thread.sleep(2000);
                                                DrGregArmstrong.click();
                                                break;
                                case "ja":
                                                Thread.sleep(2000);
                                                DrJAbiscott.click();
                                                break;
                                                
                                case "kmc":
                                				Thread.sleep(2000);
                                				DrKmcwilliamTesting.click();
                                				break;
                                }
                }

                public void enterSpecimentTime(String hours, String minutes) {
                                SpecimenCollection_Hours.click();
                                SpecimenCollection_Hours.sendKeys(hours);
                                SpecimenCollection_Minutes.click();
                                SpecimenCollection_Minutes.sendKeys(minutes);
                }

                public void enterSpecimenDate(String dateYYYMMDD) {
                                SpecimenCollection_Date.click();
                                SpecimenCollection_Date.sendKeys(dateYYYMMDD);
                                SpecimenCollection_Date.click();
                }

                public Create_eOrderPage2(WebDriver driver) {
                                this.driver = driver;
                                PageFactory.initElements(driver, this);
                }

}
