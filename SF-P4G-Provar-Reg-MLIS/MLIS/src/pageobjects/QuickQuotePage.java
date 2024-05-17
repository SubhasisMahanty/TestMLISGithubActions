package pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.provar.core.testapi.annotations.*;

@Page( title="QuickQuotePage"                                
     , summary=""
     , relativeUrl=""
     , connection="MLISBroker"
     )             
public class QuickQuotePage {
	@TestLogger
	public Logger testLogger;
	WebDriver driver;
//	WebDriverWait wait = new WebDriverWait(driver, 90);
	public QuickQuotePage(WebDriver driver){
	this.driver= driver;
	}
	@TextType()
	@FindBy(xpath = "//input[@name='clientName']")
	public WebElement insuredNameS;
	@TextType()
	@FindBy(xpath = "//input[@placeholder=\"Conveyancer's Email address *\"]")
	public WebElement conveyancerSEmailAddress;
	@TextType()
	@FindBy(xpath = "//input[@placeholder='Your Email address *']")
	public WebElement yourEmailAddress;
	@TextType()
	@FindBy(xpath = "//input[@placeholder='Reference *']")
	public WebElement reference;
	@TextType()
	@FindBy(xpath = "//input[@placeholder='Conveyancing Firm *']")
	public WebElement conveyancingFirm;
	@TextType()
	@FindBy(xpath = "//input[@placeholder='Please enter postcode of property to be insured *']")
	public WebElement pleaseEnterPostcodeOfPropertyToBeInsured;
	
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='SEARCH ADDRESS']")
	public WebElement searchAddress;
	
	public void selectDDAddress(String address) throws Exception{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
    	testLogger.info("----" );
		testLogger.info("Print the Address : " + address);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'-- Please select address --')]")));
		driver.findElement(By.xpath("//span[contains(text(),'-- Please select address --')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+address+"')]")));
		driver.findElement(By.xpath("//span[contains(text(),'"+address+"')]")).click();
		
    	}
	@TextType()
	@FindBy(xpath = "//label/span[normalize-space(.)='I confirm the property of interest is based in England or Wales']")
	public WebElement ConfirmCheckbox_EW;
	@TextType()
	@FindBy(xpath = "//label/span[normalize-space(.)='I confirm the property of interest is based in Scotland']")
	public WebElement ConfirmCheckbox_Sc;
	@TextType()
	@FindBy(xpath = "//label/span[normalize-space(.)='I confirm the property of interest is based in Northern Ireland']")
	public WebElement ConfirmCheckbox_NI;
	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='I confirm the property of interest is based in England or Wales']/span[1]")
	public WebElement ConfirmThePropertyOfInterestIsBasedInEnglandOrWales;
	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='I confirm the property of interest is based in Scotland']/span[1]")
	public WebElement ConfirmThePropertyOfInterestIsBasedInScotland;
	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='I confirm the property of interest is based in Northern Ireland']/span[1]")
	public WebElement ConfirmThePropertyOfInterestIsBasedInNortheanIreland;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='PROCEED TO STEP 2']")
	public WebElement pROCEEDTOSTEP2;
	@TextType()
	@FindBy(xpath = "//p[normalize-space(.)='Please select at least one product from the list below - Click on the information icon for more information on the product.']")
	public WebElement Assert_Page_2_Text;
	@TextType()
	@FindBy(xpath = "//h3[normalize-space(.)='54 Results displayed']")
	public WebElement _54resultsDisplayed;
	@TextType()
	@FindBy(xpath = "//h3[normalize-space(.)='34 Results displayed']")
	public WebElement _34resultsDisplayed;
	@TextType()
	@FindBy(xpath = "//h3[normalize-space(.)='36 Results displayed']")
	public WebElement _36resultsDisplayed;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='PROCEED TO STEP 3']")
	public WebElement pROCEEDTOSTEP3;
	@TextType()
	@FindBy(xpath = "//p[normalize-space(.)=concat('Your quotes are displayed below for you to email to your Conveyancer - you should email these quotes to your Conveyancer as quickly as possible by clicking the ',\"'\",'Email Quotes to My Conveyancer',\"'\",' button at the bottom of this screen. Your Conveyancer will be able to review your quotes and obtain a policy wording for consideration, to decide which quote/policy best meets your requirements.')]")
	public WebElement MessageDisplayed;
	@TextType()
	@FindBy(xpath = "//th/div[normalize-space(.)='Royal & Sun Alliance Insurance Limited']")
	public WebElement RSABnnder;
	@TextType()
	@FindBy(xpath = "//th/div[normalize-space(.)='Aviva Insurance Limited (trading as Norwich Union)']")
	public WebElement AvivaBinder;
	@TextType()
	@FindBy(xpath = "//th/div[normalize-space(.)='Accredited Insurance (Europe) Limited UK Branch']")
	public WebElement R_QBinder;
	@TextType()
	@FindBy(xpath = "//th/div[normalize-space(.)='AXA XL Insurance Company UK Limited']")
	public WebElement AXA_Binder;
	@TextType()
	@FindBy(xpath = "//label/span[normalize-space(.)='By ticking this box your client agrees that you have read and understood our Terms and Conditions for the provision of this non-binding indication and confirm that you have provided accurate and complete information to the best of your knowledge.']")
	public WebElement AgreeT_C;
	@BooleanType()
	@FindBy(xpath = "//label[normalize-space(.)='By ticking this box your client agrees that you have read and understood our Terms and Conditions for the provision of this non-binding indication and confirm that you have provided accurate and complete information to the best of your knowledge.']/span[1]")
	public WebElement byTickingThisBoxYourClientAgreesThatYouHaveReadAndUnderstoodOurTermsAndConditionsForTheProvisionOfThisNonBindingIndicationAndConfirmThatYouHaveProvidedAccurateAndCompleteInformationToTheBestOfYourKnowledge;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='EMAIL QUOTES TO MY CONVEYANCER AND MYSELF']")
	public WebElement eMAILQUOTESTOMYCONVEYANCERANDMYSELF;
	@TextType()
	@FindBy(xpath = "//strong[normalize-space(.)='YOUR QUOTE HAS BEEN EMAILED TO YOU AND YOUR CONVEYANCER']")
	public WebElement FinalConfirmation;
	@TextType()
	@FindBy(xpath = "//strong[normalize-space(.)='CLOSE THIS WINDOW']")
	public WebElement cLOSETHISWINDOW;
			
}
