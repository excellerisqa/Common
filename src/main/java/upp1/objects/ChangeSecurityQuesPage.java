package upp1.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeSecurityQuesPage {
	WebDriver driver;

	public static String visibleValidationErrorPath = "//div[@id='changesecurityquestions']//div[@class='ng-active']";

	public static String changeseucritytitlepath = "//h3[contains(.,'Change Security Questions')]";
	public static String question1checkboxpath = "//input[@name='customQuestionCheck1']//following-sibling::*[position()=1]";
	public static String question1questionpath = "//div[@class='security-question security-question-1 carousel-form']//input[@name='customQuestion']";
	public static String question1dropdownPath = "//div[@class='security-question security-question-1 carousel-form']//select[@ng-model='question.question']";
	public static String question1answerpath = "//div[@class='security-question security-question-1 carousel-form']//input[@name='answer']";
	public static String question2checkboxpath = "//input[@name='customQuestionCheck2']//following-sibling::*[position()=1]";
	public static String question2questionpath = "//div[@class='security-question security-question-2 carousel-form']//input[@name='customQuestion']";
	public static String question2dropdownPath = "//div[@class='security-question security-question-2 carousel-form']//select[@ng-model='question.question']";
	public static String question2answerpath = "//div[@class='security-question security-question-2 carousel-form']//input[@name='answer']";
	public static String question3checkboxpath = "//input[@name='customQuestionCheck3']//following-sibling::*[position()=1]";
	public static String question3questionpath = "//div[@class='security-question security-question-3 carousel-form']//input[@name='customQuestion']";
	public static String question3dropdownPath = "//div[@class='security-question security-question-3 carousel-form']//select[@ng-model='question.question']";
	public static String question3answerpath = "//div[@class='security-question security-question-3 carousel-form']//input[@name='answer']";

	@FindBy(xpath = "//div[@id='changesecurityquestions']//button[@class='btn btn-primary btnPHover mbottom-10 ng-scope' and text()='SAVE']")
	public static WebElement savebutton;

	@FindBy(xpath = "//div[@id='changesecurityquestions']//a[contains(text(),'CANCEL')]")
	public static WebElement cancelbutton;

	@FindBy(xpath = "//input[@name='customQuestionCheck1']//following-sibling::*[position()=1]")
	public static WebElement question1checkbox;

	@FindBy(xpath = "//div[@class='security-question security-question-1 carousel-form']//input[@name='customQuestion']")
	public static WebElement question1question;

	@FindBy(xpath = "//div[@class='security-question security-question-1 carousel-form']//select[@ng-model='question.question']")
	public static WebElement question1dropdown;

	@FindBy(xpath = "//div[@class='security-question security-question-1 carousel-form']//input[@name='answer']")
	public static WebElement question1answer;

	@FindBy(xpath = "//input[@name='customQuestionCheck2']//following-sibling::*[position()=1]")
	public static WebElement question2checkbox;

	@FindBy(xpath = "//div[@class='security-question security-question-2 carousel-form']//input[@name='customQuestion']")
	public static WebElement question2question;

	@FindBy(xpath = "//div[@class='security-question security-question-2 carousel-form']//select[@ng-model='question.question']")
	public static WebElement question2dropdown;

	@FindBy(xpath = "//div[@class='security-question security-question-2 carousel-form']//input[@name='answer']")
	public static WebElement question2answer;

	@FindBy(xpath = "//input[@name='customQuestionCheck3']//following-sibling::*[position()=1]")
	public static WebElement question3checkbox;

	@FindBy(xpath = "//div[@class='security-question security-question-3 carousel-form']//input[@name='customQuestion']")
	public static WebElement question3question;

	@FindBy(xpath = "//div[@class='security-question security-question-3 carousel-form']//select[@ng-model='question.question']")
	public static WebElement question3dropdown;

	@FindBy(xpath = "//div[@class='security-question security-question-3 carousel-form']//input[@name='answer']")
	public static WebElement question3answer;

	@FindBy(xpath = "//h3[contains(.,'Change Security Questions')]")
	public static WebElement changeseucritytitle;

	@FindBy(xpath = "//button//span[text()='Select a security question, or enter your own']")
	public static List<WebElement> questionsDropDownUsingSpanList;

	public ChangeSecurityQuesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
