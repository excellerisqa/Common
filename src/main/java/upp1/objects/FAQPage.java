package upp1.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FAQPage {

	WebDriver driver;

	/*
	 * public static WebElement[] FAQtitlelist = { BaseClass.fp.general,
	 * BaseClass.fp.login, BaseClass.fp.privacy, BaseClass.fp.report,
	 * BaseClass.fp.accountcreation, BaseClass.fp.security, BaseClass.fp.tutorials
	 * };
	 * 
	 * public static WebElement[] generalFAQNonexpandedlist = {
	 * BaseClass.fp.generalFAQ1NonExpanded, BaseClass.fp.generalFAQ2NonExpanded,
	 * BaseClass.fp.generalFAQ3NonExpanded, BaseClass.fp.generalFAQ4NonExpanded,
	 * BaseClass.fp.generalFAQ5NonExpanded, BaseClass.fp.generalFAQ6NonExpanded };
	 * 
	 * public static WebElement[] generalFAQexpandedlist = {
	 * BaseClass.fp.generalFAQ1Expanded, BaseClass.fp.generalFAQ2Expanded,
	 * BaseClass.fp.generalFAQ3Expanded, BaseClass.fp.generalFAQ4Expanded,
	 * BaseClass.fp.generalFAQ5Expanded, BaseClass.fp.generalFAQ6Expanded };
	 * 
	 * public static WebElement[] loginFAQNonexpandedlist = {
	 * BaseClass.fp.loginFAQ1NonExpanded }; public static WebElement[]
	 * loginFAQexpandedlist = { BaseClass.fp.loginFAQ1Expanded };
	 * 
	 * public static WebElement[] privacyFAQNonexpandedlist = {
	 * BaseClass.fp.privacyFAQ1NonExpanded, BaseClass.fp.privacyFAQ2NonExpanded,
	 * BaseClass.fp.privacyFAQ3NonExpanded, BaseClass.fp.privacyFAQ4NonExpanded,
	 * BaseClass.fp.privacyFAQ5NonExpanded, BaseClass.fp.privacyFAQ6NonExpanded };
	 * 
	 * public static WebElement[] privacyFAQexpandedlist = {
	 * BaseClass.fp.privacyFAQ1Expanded, BaseClass.fp.privacyFAQ2Expanded,
	 * BaseClass.fp.privacyFAQ3Expanded, BaseClass.fp.privacyFAQ4Expanded,
	 * BaseClass.fp.privacyFAQ5Expanded, BaseClass.fp.privacyFAQ6Expanded };
	 * 
	 * public static WebElement[] reportFAQNonexpandedlist = {
	 * BaseClass.fp.reportFAQ1NonExpanded, BaseClass.fp.reportFAQ2NonExpanded,
	 * BaseClass.fp.reportFAQ3NonExpanded, BaseClass.fp.reportFAQ4NonExpanded,
	 * BaseClass.fp.reportFAQ5NonExpanded, BaseClass.fp.reportFAQ6NonExpanded };
	 * 
	 * public static WebElement[] reportFAQexpandedlist = {
	 * BaseClass.fp.reportFAQ1Expanded, BaseClass.fp.reportFAQ2Expanded,
	 * BaseClass.fp.reportFAQ3Expanded, BaseClass.fp.reportFAQ4Expanded,
	 * BaseClass.fp.reportFAQ5Expanded, BaseClass.fp.reportFAQ6Expanded };
	 * 
	 * public static WebElement[] accountcreationFAQNonexpandedlist = {
	 * BaseClass.fp.accountcreationFAQ1NonExpanded,
	 * BaseClass.fp.accountcreationFAQ2NonExpanded,
	 * BaseClass.fp.accountcreationFAQ3NonExpanded,
	 * BaseClass.fp.accountcreationFAQ4NonExpanded,
	 * BaseClass.fp.accountcreationFAQ5NonExpanded,
	 * BaseClass.fp.accountcreationFAQ6NonExpanded,
	 * BaseClass.fp.accountcreationFAQ7NonExpanded,
	 * BaseClass.fp.accountcreationFAQ8NonExpanded,
	 * BaseClass.fp.accountcreationFAQ9NonExpanded };
	 * 
	 * public static WebElement[] accountcreationFAQexpandedlist = {
	 * BaseClass.fp.accountcreationFAQ1Expanded,
	 * BaseClass.fp.accountcreationFAQ2Expanded,
	 * BaseClass.fp.accountcreationFAQ3Expanded,
	 * BaseClass.fp.accountcreationFAQ4Expanded,
	 * BaseClass.fp.accountcreationFAQ5Expanded,
	 * BaseClass.fp.accountcreationFAQ6Expanded,
	 * BaseClass.fp.accountcreationFAQ7Expanded,
	 * BaseClass.fp.accountcreationFAQ8Expanded,
	 * BaseClass.fp.accountcreationFAQ9Expanded };
	 * 
	 * public static WebElement[] securityFAQNonexpandedlist = {
	 * BaseClass.fp.securityFAQ1NonExpanded, BaseClass.fp.securityFAQ2NonExpanded,
	 * BaseClass.fp.securityFAQ3NonExpanded, BaseClass.fp.securityFAQ4NonExpanded };
	 * 
	 * public static WebElement[] securityFAQexpandedlist = {
	 * BaseClass.fp.securityFAQ1Expanded, BaseClass.fp.securityFAQ2Expanded,
	 * BaseClass.fp.securityFAQ3Expanded, BaseClass.fp.securityFAQ4Expanded };
	 * 
	 * public static WebElement[] tutorialsFAQNonexpandedlist = {
	 * BaseClass.fp.tutorialsFAQ1NonExpanded, BaseClass.fp.tutorialsFAQ2NonExpanded,
	 * BaseClass.fp.tutorialsFAQ3NonExpanded, BaseClass.fp.tutorialsFAQ4NonExpanded,
	 * BaseClass.fp.tutorialsFAQ5NonExpanded };
	 * 
	 * public static WebElement[] tutorialsFAQexpandedlist = {
	 * BaseClass.fp.tutorialsFAQ1Expanded, BaseClass.fp.tutorialsFAQ2Expanded,
	 * BaseClass.fp.tutorialsFAQ3Expanded, BaseClass.fp.tutorialsFAQ4Expanded,
	 * BaseClass.fp.tutorialsFAQ5Expanded };
	 */

	public static String generalpath = "//a[@data-target='#FAQ_GENERAL']";
	public static String loginpath = "//a[@data-target='#FAQ_LOGIN']";
	public static String privacypath = "//a[@data-target='#FAQ_PRIVACY']";
	public static String reportpath = "//a[@data-target='#FAQ_REPORTS']";
	public static String accountcreationpath = "//a[@data-target='#FAQ_REGISTRATION']";
	public static String securitypath = "//a[@data-target='#FAQ_SECURITY']";
	public static String tutorialspath = "//a[@data-target='#FAQ_TUTORIALS']";
	public static String appointmentspath = "//a[@data-target='#FAQ_APPOINTMENTS']";

	// general
	@FindBy(xpath = "//a[@data-target='#FAQ_GENERAL']")
	public static WebElement general;

	@FindBy(xpath = "//a[@data-target='#FAQ_LOGIN']")
	public static WebElement login;

	@FindBy(xpath = "//a[@data-target='#FAQ_PRIVACY']")
	public static WebElement privacy;

	@FindBy(xpath = "//a[@data-target='#FAQ_REPORTS']")
	public static WebElement report;

	@FindBy(xpath = "//a[@data-target='#FAQ_REGISTRATION']")
	public static WebElement accountcreation;

	@FindBy(xpath = "//a[@data-target='#FAQ_SECURITY']")
	public static WebElement security;

	@FindBy(xpath = "//a[@data-target='#FAQ_TUTORIALS']")
	public static WebElement tutorials;

	@FindBy(xpath = "//a[@data-target='#FAQ_APPOINTMENTS']")
	public static WebElement appointments;

	public static String generalFAQ1NonExpandedpath = "//a[@data-target='#collapse1' and @aria-expanded='false']";
	public static String generalFAQ2NonExpandedpath = "//a[@data-target='#collapse2' and @aria-expanded='false']";
	public static String generalFAQ3NonExpandedpath = "//a[@data-target='#collapse3' and @aria-expanded='false']";
	public static String generalFAQ4NonExpandedpath = "//a[@data-target='#collapse4' and @aria-expanded='false']";
	public static String generalFAQ5NonExpandedpath = "//a[@data-target='#collapse5' and @aria-expanded='false']";
	public static String generalFAQ6NonExpandedpath = "//a[@data-target='#collapse6' and @aria-expanded='false']";

	public static String generalFAQ1Expandedpath = "//a[@data-target='#collapse1' and @aria-expanded='true']";
	public static String generalFAQ2Expandedpath = "//a[@data-target='#collapse2' and @aria-expanded='true']";
	public static String generalFAQ3Expandedpath = "//a[@data-target='#collapse3' and @aria-expanded='true']";
	public static String generalFAQ4Expandedpath = "//a[@data-target='#collapse4' and @aria-expanded='true']";
	public static String generalFAQ5Expandedpath = "//a[@data-target='#collapse5' and @aria-expanded='true']";
	public static String generalFAQ6Expandedpath = "//a[@data-target='#collapse6' and @aria-expanded='true']";

	@FindBy(xpath = "//a[@data-target='#collapse1' and @aria-expanded='false']")
	public static WebElement generalFAQ1NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse2' and @aria-expanded='false']")
	public static WebElement generalFAQ2NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse3' and @aria-expanded='false']")
	public static WebElement generalFAQ3NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse4' and @aria-expanded='false']")
	public static WebElement generalFAQ4NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse5' and @aria-expanded='false']")
	public static WebElement generalFAQ5NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse6' and @aria-expanded='false']")
	public static WebElement generalFAQ6NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse1' and @aria-expanded='true']")
	public static WebElement generalFAQ1Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse2' and @aria-expanded='true']")
	public static WebElement generalFAQ2Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse3' and @aria-expanded='true']")
	public static WebElement generalFAQ3Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse4' and @aria-expanded='true']")
	public static WebElement generalFAQ4Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse5' and @aria-expanded='true']")
	public static WebElement generalFAQ5Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse6' and @aria-expanded='true']")
	public static WebElement generalFAQ6Expanded;

	// login

	public static String loginFAQ1NonExpandedpath = "//a[@data-target='#collapse11' and @aria-expanded='false']";

	public static String loginFAQ1Expandedpath = "//a[@data-target='#collapse11' and @aria-expanded='true']";

	@FindBy(xpath = "//a[@data-target='#collapse11' and @aria-expanded='false']")
	public static WebElement loginFAQ1NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse11' and @aria-expanded='true']")
	public static WebElement loginFAQ1Expanded;

	// privacy

	public static String privacyFAQ1NonExpandedpath = "//a[@data-target='#collapse12' and @aria-expanded='false']";
	public static String privacyFAQ2NonExpandedpath = "//a[@data-target='#collapse13' and @aria-expanded='false']";
	public static String privacyFAQ3NonExpandedpath = "//a[@data-target='#collapse14' and @aria-expanded='false']";
	public static String privacyFAQ4NonExpandedpath = "//a[@data-target='#collapse15' and @aria-expanded='false']";
	public static String privacyFAQ5NonExpandedpath = "//a[@data-target='#collapse16' and @aria-expanded='false']";
	public static String privacyFAQ6NonExpandedpath = "//a[@data-target='#collapse17' and @aria-expanded='false']";

	public static String privacyFAQ1Expandedpath = "//a[@data-target='#collapse12' and @aria-expanded='true']";
	public static String privacyFAQ2Expandedpath = "//a[@data-target='#collapse13' and @aria-expanded='true']";
	public static String privacyFAQ3Expandedpath = "//a[@data-target='#collapse14' and @aria-expanded='true']";
	public static String privacyFAQ4Expandedpath = "//a[@data-target='#collapse15' and @aria-expanded='true']";
	public static String privacyFAQ5Expandedpath = "//a[@data-target='#collapse16' and @aria-expanded='true']";
	public static String privacyFAQ6Expandedpath = "//a[@data-target='#collapse17' and @aria-expanded='true']";

	@FindBy(xpath = "//a[@data-target='#collapse12' and @aria-expanded='false']")
	public static WebElement privacyFAQ1NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse13' and @aria-expanded='false']")
	public static WebElement privacyFAQ2NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse14' and @aria-expanded='false']")
	public static WebElement privacyFAQ3NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse15' and @aria-expanded='false']")
	public static WebElement privacyFAQ4NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse16' and @aria-expanded='false']")
	public static WebElement privacyFAQ5NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse17' and @aria-expanded='false']")
	public static WebElement privacyFAQ6NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse12' and @aria-expanded='true']")
	public static WebElement privacyFAQ1Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse13' and @aria-expanded='true']")
	public static WebElement privacyFAQ2Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse14' and @aria-expanded='true']")
	public static WebElement privacyFAQ3Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse15' and @aria-expanded='true']")
	public static WebElement privacyFAQ4Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse16' and @aria-expanded='true']")
	public static WebElement privacyFAQ5Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse17' and @aria-expanded='true']")
	public static WebElement privacyFAQ6Expanded;

	// report
	public static String reportFAQ1NonExpandedpath = "//a[@data-target='#collapse14' and @aria-expanded='false']";
	public static String reportFAQ2NonExpandedpath = "//a[@data-target='#collapse15' and @aria-expanded='false']";
	public static String reportFAQ3NonExpandedpath = "//a[@data-target='#collapse16' and @aria-expanded='false']";
	public static String reportFAQ4NonExpandedpath = "//a[@data-target='#collapse17' and @aria-expanded='false']";
	public static String reportFAQ5NonExpandedpath = "//a[@data-target='#collapse18' and @aria-expanded='false']";
	public static String reportFAQ6NonExpandedpath = "//a[@data-target='#collapse19' and @aria-expanded='false']";

	public static String reportFAQ1Expandedpath = "//a[@data-target='#collapse14' and @aria-expanded='true']";
	public static String reportFAQ2Expandedpath = "//a[@data-target='#collapse15' and @aria-expanded='true']";
	public static String reportFAQ3Expandedpath = "//a[@data-target='#collapse16' and @aria-expanded='true']";
	public static String reportFAQ4Expandedpath = "//a[@data-target='#collapse17' and @aria-expanded='true']";
	public static String reportFAQ5Expandedpath = "//a[@data-target='#collapse18' and @aria-expanded='true']";
	public static String reportFAQ6Expandedpath = "//a[@data-target='#collapse19' and @aria-expanded='true']";

	@FindBy(xpath = "//a[@data-target='#collapse18' and @aria-expanded='false']")
	public static WebElement reportFAQ1NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse19' and @aria-expanded='false']")
	public static WebElement reportFAQ2NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse20' and @aria-expanded='false']")
	public static WebElement reportFAQ3NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse21' and @aria-expanded='false']")
	public static WebElement reportFAQ4NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse22' and @aria-expanded='false']")
	public static WebElement reportFAQ5NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse23' and @aria-expanded='false']")
	public static WebElement reportFAQ6NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse18' and @aria-expanded='true']")
	public static WebElement reportFAQ1Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse19' and @aria-expanded='true']")
	public static WebElement reportFAQ2Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse20' and @aria-expanded='true']")
	public static WebElement reportFAQ3Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse21' and @aria-expanded='true']")
	public static WebElement reportFAQ4Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse22' and @aria-expanded='true']")
	public static WebElement reportFAQ5Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse23' and @aria-expanded='true']")
	public static WebElement reportFAQ6Expanded;

	// Account Creation

	public static String accountcreationFAQ1NonExpandedpath = "//a[@data-target='#collapse20' and @aria-expanded='false']";
	public static String accountcreationFAQ2NonExpandedpath = "//a[@data-target='#collapse21' and @aria-expanded='false']";
	public static String accountcreationFAQ3NonExpandedpath = "//a[@data-target='#collapse22' and @aria-expanded='false']";
	public static String accountcreationFAQ4NonExpandedpath = "//a[@data-target='#collapse23' and @aria-expanded='false']";
	public static String accountcreationFAQ5NonExpandedpath = "//a[@data-target='#collapse24' and @aria-expanded='false']";
	public static String accountcreationFAQ6NonExpandedpath = "//a[@data-target='#collapse25' and @aria-expanded='false']";
	public static String accountcreationFAQ7NonExpandedpath = "//a[@data-target='#collapse26' and @aria-expanded='false']";
	public static String accountcreationFAQ8NonExpandedpath = "//a[@data-target='#collapse27' and @aria-expanded='false']";
	public static String accountcreationFAQ9NonExpandedpath = "//a[@data-target='#collapse28' and @aria-expanded='false']";

	public static String accountcreationFAQ1Expandedpath = "//a[@data-target='#collapse20' and @aria-expanded='true']";
	public static String accountcreationFAQ2Expandedpath = "//a[@data-target='#collapse21' and @aria-expanded='true']";
	public static String accountcreationFAQ3Expandedpath = "//a[@data-target='#collapse22' and @aria-expanded='true']";
	public static String accountcreationFAQ4Expandedpath = "//a[@data-target='#collapse23' and @aria-expanded='true']";
	public static String accountcreationFAQ5Expandedpath = "//a[@data-target='#collapse24' and @aria-expanded='true']";
	public static String accountcreationFAQ6Expandedpath = "//a[@data-target='#collapse25' and @aria-expanded='true']";
	public static String accountcreationFAQ7Expandedpath = "//a[@data-target='#collapse26' and @aria-expanded='true']";
	public static String accountcreationFAQ8Expandedpath = "//a[@data-target='#collapse27' and @aria-expanded='true']";
	public static String accountcreationFAQ9Expandedpath = "//a[@data-target='#collapse28' and @aria-expanded='true']";

	@FindBy(xpath = "//a[@data-target='#collapse30' and @aria-expanded='false']")
	public static WebElement accountcreationFAQ1NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse31' and @aria-expanded='false']")
	public static WebElement accountcreationFAQ2NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse32' and @aria-expanded='false']")
	public static WebElement accountcreationFAQ3NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse33' and @aria-expanded='false']")
	public static WebElement accountcreationFAQ4NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse34' and @aria-expanded='false']")
	public static WebElement accountcreationFAQ5NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse35' and @aria-expanded='false']")
	public static WebElement accountcreationFAQ6NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse36' and @aria-expanded='false']")
	public static WebElement accountcreationFAQ7NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse37' and @aria-expanded='false']")
	public static WebElement accountcreationFAQ8NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse39' and @aria-expanded='false']")
	public static WebElement accountcreationFAQ9NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse30' and @aria-expanded='true']")
	public static WebElement accountcreationFAQ1Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse31' and @aria-expanded='true']")
	public static WebElement accountcreationFAQ2Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse32' and @aria-expanded='true']")
	public static WebElement accountcreationFAQ3Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse33' and @aria-expanded='true']")
	public static WebElement accountcreationFAQ4Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse34' and @aria-expanded='true']")
	public static WebElement accountcreationFAQ5Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse35' and @aria-expanded='true']")
	public static WebElement accountcreationFAQ6Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse36' and @aria-expanded='true']")
	public static WebElement accountcreationFAQ7Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse37' and @aria-expanded='true']")
	public static WebElement accountcreationFAQ8Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse39' and @aria-expanded='true']")
	public static WebElement accountcreationFAQ9Expanded;

	// security
	public static String securityFAQ1NonExpandedpath = "//a[@data-target='#collapse29' and @aria-expanded='false']";
	public static String securityFAQ2NonExpandedpath = "//a[@data-target='#collapse30' and @aria-expanded='false']";
	public static String securityFAQ3NonExpandedpath = "//a[@data-target='#collapse31' and @aria-expanded='false']";
	public static String securityFAQ4NonExpandedpath = "//a[@data-target='#collapse32' and @aria-expanded='false']";

	public static String securityFAQ1Expandedpath = "//a[@data-target='#collapse29' and @aria-expanded='true']";
	public static String securityFAQ2Expandedpath = "//a[@data-target='#collapse30' and @aria-expanded='true']";
	public static String securityFAQ3Expandedpath = "//a[@data-target='#collapse31' and @aria-expanded='true']";
	public static String securityFAQ4Expandedpath = "//a[@data-target='#collapse32' and @aria-expanded='true']";

	@FindBy(xpath = "//a[@data-target='#collapse42' and @aria-expanded='false']")
	public static WebElement securityFAQ1NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse43' and @aria-expanded='false']")
	public static WebElement securityFAQ2NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse44' and @aria-expanded='false']")
	public static WebElement securityFAQ3NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse45' and @aria-expanded='false']")
	public static WebElement securityFAQ4NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse42' and @aria-expanded='true']")
	public static WebElement securityFAQ1Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse43' and @aria-expanded='true']")
	public static WebElement securityFAQ2Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse44' and @aria-expanded='true']")
	public static WebElement securityFAQ3Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse45' and @aria-expanded='true']")
	public static WebElement securityFAQ4Expanded;

	// tutorials

	public static String tutorialsFAQ1NonExpandedpath = "//a[@data-target='#collapse33' and @aria-expanded='false']";
	public static String tutorialsFAQ2NonExpandedpath = "//a[@data-target='#collapse34' and @aria-expanded='false']";
	public static String tutorialsFAQ3NonExpandedpath = "//a[@data-target='#collapse35' and @aria-expanded='false']";
	public static String tutorialsFAQ4NonExpandedpath = "//a[@data-target='#collapse36' and @aria-expanded='false']";
	public static String tutorialsFAQ5NonExpandedpath = "//a[@data-target='#collapse37' and @aria-expanded='false']";

	public static String tutorialsFAQ1Expandedpath = "//a[@data-target='#collapse33' and @aria-expanded='true']";
	public static String tutorialsFAQ2Expandedpath = "//a[@data-target='#collapse34' and @aria-expanded='true']";
	public static String tutorialsFAQ3Expandedpath = "//a[@data-target='#collapse35' and @aria-expanded='true']";
	public static String tutorialsFAQ4Expandedpath = "//a[@data-target='#collapse36' and @aria-expanded='true']";
	public static String tutorialsFAQ5Expandedpath = "//a[@data-target='#collapse37' and @aria-expanded='true']";

	@FindBy(xpath = "//a[@data-target='#collapse46' and @aria-expanded='false']")
	public static WebElement tutorialsFAQ1NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse47' and @aria-expanded='false']")
	public static WebElement tutorialsFAQ2NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse48' and @aria-expanded='false']")
	public static WebElement tutorialsFAQ3NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse49' and @aria-expanded='false']")
	public static WebElement tutorialsFAQ4NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse50' and @aria-expanded='false']")
	public static WebElement tutorialsFAQ5NonExpanded;

	@FindBy(xpath = "//a[@data-target='#collapse46' and @aria-expanded='true']")
	public static WebElement tutorialsFAQ1Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse47' and @aria-expanded='true']")
	public static WebElement tutorialsFAQ2Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse48' and @aria-expanded='true']")
	public static WebElement tutorialsFAQ3Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse49' and @aria-expanded='true']")
	public static WebElement tutorialsFAQ4Expanded;

	@FindBy(xpath = "//a[@data-target='#collapse50' and @aria-expanded='true']")
	public static WebElement tutorialsFAQ5Expanded;

	// appointments
	@FindBy(xpath = "//a[@data-target='#collapse52' and @aria-expanded='false']")
	public static WebElement appointmentsFAQ1NonExpanded;

	public FAQPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
