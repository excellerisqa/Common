package myeHealth.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;


public class MEH_ChangeSecurityQuesPage {
	public static By question1DropdownText = By.id("ctl00_ContentPlaceHolder1_Question1Dropdown_TextBox");
	public static By question2DropdownText = By.id("ctl00_ContentPlaceHolder1_Question2Dropdown_TextBox");
	public static By question3DropdownText = By.id("ctl00_ContentPlaceHolder1_Question3Dropdown_TextBox");	
	public static By answer1Field = By.id("ctl00_ContentPlaceHolder1_Answer");
	public static By answer2Field = By.id("ctl00_ContentPlaceHolder1_Answer2");
	public static By answer3Field = By.id("ctl00_ContentPlaceHolder1_Answer3");
	public static By saveButton = By.id("ctl00_ContentPlaceHolder1_SecurityQuestionsChangeButton");
	public static By cancelButton = By.id("ctl00_ContentPlaceHolder1_SecurityQuestionsCancelButton");
	public static By changeSuccessOKText = By.id("ctl00_ContentPlaceHolder1_AccountStepsDescLabel");
	public static By homeButton = By.id("ctl00_ContentPlaceHolder1_MyeHealthButton");
	public static By question1DropdownList = By.id("ctl00_ContentPlaceHolder1_Question1Dropdown_OptionList");
	public static By question2DropdownList = By.id("ctl00_ContentPlaceHolder1_Question2Dropdown_OptionList");
	public static By question3DropdownList = By.id("ctl00_ContentPlaceHolder1_Question3Dropdown_OptionList");
	public static By question1DropdownButton = By.id("ctl00_ContentPlaceHolder1_Question1Dropdown_Button");
	public static By question2DropdownButton = By.id("ctl00_ContentPlaceHolder1_Question2Dropdown_Button");
	public static By question3DropdownButton = By.id("ctl00_ContentPlaceHolder1_Question3Dropdown_Button");

	/*
	 * Description : change security ques from one to another
	 * Parameters : @1 XLHandler object initiated for test data file
	 * Returns : Boolean - false for success, true for failure
	 * Author : Sindhu Rajaguru
	 * Modified By:
	 * */	
	public static boolean changeSecurityQues(XLHandler objXLHandler) throws InterruptedException {
		boolean err = false;
		String ansCar = objXLHandler.readCorrespondingValueFromTestDataName("Security Ques", "car");
		String ansEyes = objXLHandler.readCorrespondingValueFromTestDataName("Security Ques", "eyes");
		String ansWatch = objXLHandler.readCorrespondingValueFromTestDataName("Security Ques", "watch");
		String ansAnimal = objXLHandler.readCorrespondingValueFromTestDataName("Security Ques", "animal");
		CommonFunctions.waitForVisiblity(question1DropdownText, 30);
		String[] ques = new String[3];
		ques[0] = ObjectHelper.driver.findElement(question1DropdownText).getAttribute("value");
		ques [1] = ObjectHelper.driver.findElement(question2DropdownText).getAttribute("value");
		ques [2] = ObjectHelper.driver.findElement(question3DropdownText).getAttribute("value");
		/*if(ques1.contains("car")) {
			ObjectHelper.driver.findElement(question1DropdownButton).click();
			ObjectHelper.driver.findElement(question1DropdownList).findElement(By.xpath(".//li[contains(text(),'eyes')]")).click();
			ObjectHelper.driver.findElement(answer1Field).sendKeys(ansEyes);
		}else if(ques1.contains("eyes")) {
			ObjectHelper.driver.findElement(question1DropdownButton).click();
			ObjectHelper.driver.findElement(question1DropdownList).findElement(By.xpath(".//li[contains(text(),'watch')]")).click();
			ObjectHelper.driver.findElement(answer1Field).sendKeys(ansCar);
		}*/

		String j = "ctl00_ContentPlaceHolder1_Answer";
		for(int i=0; i<ques.length;i++) {
			if(i==2)
				j="ctl00_ContentPlaceHolder1_Answer3";
			else if(i==1)
				j="ctl00_ContentPlaceHolder1_Answer2";
			//System.out.println("ques:"+ques[i]);
			ObjectHelper.driver.findElement(By.id(j)).clear();
			ObjectHelper.driver.findElement(By.id(j)).click();
			if(ques[i].contains("car")) {
				ObjectHelper.driver.findElement(By.id(j)).sendKeys(ansCar);
				ObjectHelper.driver.findElement(By.id(j)).clear();
				ObjectHelper.driver.findElement(By.id(j)).click();
				ObjectHelper.driver.findElement(By.id(j)).sendKeys(ansCar);
			}
			else if(ques[i].contains("animal")) {
				ObjectHelper.driver.findElement(By.id(j)).sendKeys(ansAnimal);
				ObjectHelper.driver.findElement(By.id(j)).clear();
				ObjectHelper.driver.findElement(By.id(j)).click();
				ObjectHelper.driver.findElement(By.id(j)).sendKeys(ansAnimal);
			}
			else if(ques[i].contains("watch")) {
				ObjectHelper.driver.findElement(By.id(j)).sendKeys(ansWatch);
				ObjectHelper.driver.findElement(By.id(j)).clear();
				ObjectHelper.driver.findElement(By.id(j)).click();
				ObjectHelper.driver.findElement(By.id(j)).sendKeys(ansWatch);
			}
	
		}
		/*ObjectHelper.driver.findElement(question1DropdownButton).click();
		ObjectHelper.driver.findElement(question1DropdownList).findElement(By.xpath(".//li[contains(text(),'car')]")).click();
		ObjectHelper.driver.findElement(answer1Field).sendKeys(ansCar);
		CommonFunctions.waitForVisiblity(question2DropdownButton, 10);
		ObjectHelper.driver.findElement(question2DropdownButton).click();
		ObjectHelper.driver.findElement(question2DropdownList).findElement(By.xpath(".//li[contains(text(),'animal')]")).click();
		ObjectHelper.driver.findElement(answer2Field).sendKeys(ansAnimal);
		CommonFunctions.waitForVisiblity(question3DropdownButton, 10);
		Thread.sleep(1000);
		ObjectHelper.driver.findElement(question3DropdownButton).click();
		ObjectHelper.driver.findElement(question3DropdownList).findElement(By.xpath(".//li[contains(text(),'watch')]")).click();
		ObjectHelper.driver.findElement(answer3Field).sendKeys(ansWatch);*/
		Thread.sleep(2000);
		ObjectHelper.driver.findElement(saveButton).click();
		if(!CommonFunctions.waitForVisiblity(changeSuccessOKText, 10)) {
			ObjectHelper.driver.findElement(saveButton).click();
			CommonFunctions.waitForVisiblity(changeSuccessOKText, 10);
		}
		if(ObjectHelper.driver.findElement(changeSuccessOKText).getText().contains("security questions have been changed")) {
			ObjectHelper.driver.findElement(homeButton).click();
		}
		else
			err = true;
		return err;
		
	}

}
