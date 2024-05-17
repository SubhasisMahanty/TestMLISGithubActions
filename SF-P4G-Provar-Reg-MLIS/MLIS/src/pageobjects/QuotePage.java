package pageobjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.logging.Logger;
import com.provar.core.testapi.annotations.*;

@Page( title="QuotePage"                                
     , summary=""
     , relativeUrl=""
     , connection="MLISBroker"
     )             
public class QuotePage {
	@TestLogger
    public Logger testLogger;
	WebDriver driver;
//	WebDriverWait wait = new WebDriverWait(driver, 90);
	public QuotePage(WebDriver driver){
	this.driver= driver;
	}
	@TextType()
	@FindBy(xpath = "//input[@placeholder=\"Your Reference Number\"]")
	public WebElement myCaseRefFileNumber;
	@TextType()
	@FindBy(xpath = "//input[@placeholder=\"e.g. 150000 - Numeric values only\"]")
	public WebElement limitOfIndemnity;
	public void selectProduct(String pName) throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//    	Adoption of Road - Historical Private Roads
		testLogger.info("Print the ProductName : " + pName);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h3[contains(text(),'"+pName+"')]/following::div/button)[1]")));
		WebElement element = driver.findElement(By.xpath("(//h3[contains(text(),'"+pName+"')]/following::div/button)[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		driver.findElement(By.xpath("(//h3[contains(text(),'"+pName+"')]/following::div/button)[1]")).click();
		
    	}
    	
    public void selectBinder(String binderName) throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//    	Adoption of Road - Historical Private Roads
		testLogger.info("Print the BinderName : " + binderName);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@alt='"+binderName+"']/following::div/div/button)[1]")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@alt='"+binderName+"']/following::button[contains(text(),'SELECT THIS QUOTE')])[1]")));
		WebElement element = driver.findElement(By.xpath("(//img[@alt='"+binderName+"']/following::button[contains(text(),'SELECT THIS QUOTE')])[1]"));
		Thread.sleep(4000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		
//		WebElement element = driver.findElement(By.xpath(xpath));
//		((JavascriptExecutor) driver).executeScript("scroll(0, 250);");
//		((JavascriptExecutor) driver).executeScript("scroll(0, 250);");
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//img[@alt='"+binderName+"']/following::div/div/button)[1]")).click();
//		executor.executeScript("arguments[0].click();", element);
		driver.findElement(By.xpath("(//img[@alt='"+binderName+"']/following::button[contains(text(),'SELECT THIS QUOTE')])[1]")).click();
		Thread.sleep(1000);
		
    	}
    public void selectDDAddress(String address) throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//    	Adoption of Road - Historical Private Roads
		testLogger.info("Print the Address : " + address);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='"+address+"']")));
		driver.findElement(By.xpath("//span[@title='"+address+"']")).click();
		
    	}
	@ButtonType()
	@FindBy(xpath = "(//button[normalize-space(.)='PROCEED'])[1]")
	public WebElement proceed;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='CONFIRM']")
	public WebElement confirm1;
	@TextType()
	@FindBy(xpath = "//h2[contains(text(),'quotes found.')]")
	public WebElement YourQuotePageAssertion;
	
	public void waitForElementToAppear(String x) {
		testLogger.info("Wait Started");
		int i = 0;
		for (int count = 60; count > i; count--) {
			if (driver.findElements(By.xpath(x)).size() > 0) {
				testLogger.info("Count :"+count);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				i = 26;
//				WebDriverWait wait = new WebDriverWait(driver, 20);
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(x)));
				int value = driver.findElements(By.xpath(x)).size();
				if(value > 0)
				{
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
				try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(x)));
				testLogger.info("Element Present");
				i = 61;
				}
				catch(Exception e){
				testLogger.info("Element Present But not Visible");
				}
				}
				
			} else {
				try {
					testLogger.info("Waiting for element to appear counter value is" + count);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	@TextType()
	@FindBy(xpath = "//input[@placeholder='Land registry number (if known)']")
	public WebElement landRegistryNumberIfKnown;
	@TextType()
	@FindBy(xpath = "//input[@name='clientName']")
	public WebElement insuredNameS;
	
	@TextType()
	@FindBy(xpath = "//input[@placeholder='Please enter postcode']")
	public WebElement insuredPropertyPostcode;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='SEARCH ADDRESS']")
	public WebElement searchAddress;
	@TextType()
	@FindBy(xpath = "//button[@name='address']")
	public WebElement pleaseSelectAddress;
	@TextType()
	@FindBy(xpath = "//button[@title='Select a date for ']//ancestor::div/input")
	public WebElement date;
	@TextType()
	@FindBy(xpath = "//input[@placeholder='Select date...']/parent::div")
	public WebElement date1;
	@TextType()
	@FindBy(xpath = "//input[@type='date']")
	public WebElement date2;
	@TextType()
	@FindBy(xpath = "//div[@class='custom-input']")
	public WebElement date3;
	
	
	@TextType()
	@FindBy(xpath = "//button[contains(text(),'Today')]")
	public WebElement today;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='ORDER NOW']")
	public WebElement orderNow;
	@TextType()
	@FindBy(xpath = "//p[normalize-space(.)='Congratulations, cover is now complete and your final policy will be emailed to you shortly. Your policy number is confirmed below and should be quoted in any future communications']")
	public WebElement congratsMessage;
	@TextType()
	@FindBy(xpath = "//strong[contains(text(),'Policy Number:')]/following::div[3]")
	public WebElement policyNumber;
	@TextType()
	@FindBy(xpath = "//strong[contains(text(),'Quote Number:')]/following::div[3]")
	public WebElement quoteNumber;
	
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The Property includes an existing building(s), being sold/purchased and/or mortgaged or subject to grant of a lease, which will continue to be used in accordance with its existing use and no redevelopment is planned.']")
	public WebElement UI_Assert___SOF;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The access way being insured has remained unobstructed and been used for more than 8 months without payment, permission or objection.']")
	public WebElement UI_Assert__SOF_2;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='There has been no contact with, and you will not contact, any third party regarding the ownership or use of the access.']")
	public WebElement UI_Assert___SOF_3;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='You are not aware of any proposed changes or diversions to the access way.']")
	public WebElement UI_Assert___SOF_4;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)=concat('The services',\"'\",' route being insured has been used for more than 8 months, or where services relate to connection to a septic tank used for more than 2 years, without payment, permission or objection.')]")
	public WebElement UI_Assert___SOF_5;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='There has been no contact with, and you will not contact, any third party regarding the ownership or use of the services.']")
	public WebElement UI_Assert___SOF_6;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='You are not aware of any proposed developments on adjoining land that may result in the obstruction or diversion of the services.']")
	public WebElement UI_Assert___SOF_7;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='Any alteration or additions to be insured were completed more than 8 months ago and there have been no subsequent objections.']")
	public WebElement UI_Assert___SOF_8;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The ground rent/service charge has not been paid or demanded and there has been no contact with the landlord for at least the last 2 years.']")
	public WebElement UI_Assert___SOF_9;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The parties to the transaction are not aware of any matters that would give rise to an Adverse Entry appearing in searches. In particular, you have established that the Property benefits from planning permission for its existing use (unless Planning Permission has been selected as an Insured Event).']")
	public WebElement UI_Assert___SOF_10;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)=\"The searches being relied upon for your purchase and/or mortgage, which are 'out-of-date', are no more than 18 months old at the Policy Commencement Date.\"]")
	public WebElement UI_Assert___SOF_11;
	@ButtonType()
	@JavascriptBy(jspath = "return document.querySelector('c-mlis-quote-journey').shadowRoot.querySelector('c-mlis-quote-results').shadowRoot.querySelector('button')")
	public WebElement SelectThisQuote;
	@ButtonType()
	@JavascriptBy(jspath = "return document.querySelector('c-mlis-quote-journey').shadowRoot.querySelector('c-mlis-quote-product-selection').shadowRoot.querySelectorAll('button')[1]")
	public WebElement sELECT1;
	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='*']/following-sibling::div//input")
	public WebElement pleaseEnterEmail;
	@TextType()
	@FindBy(xpath = "//button[normalize-space(.)='SEND']/lightning-primitive-icon")
	public WebElement sEND;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='CLOSE']")
	public WebElement cLOSE;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='CANNOT CONFIRM']")
	public WebElement Cannot_Confirm_value;
	@TextType()
	@FindBy(xpath = "//p[normalize-space(.)=concat('Your quote needs to be referred to one of our underwriters. This is either because you',\"'\",'ve been unable to confirm all statements of fact or the limit of indemnity exceeds the amount permitted by the service. To refer your quote request to an underwriter, please complete the additional details requested below and click the ',\"'\",'Proceed with Referral',\"'\",' button. To review the information you have previously supplied, please click the ',\"'\",'Back',\"'\",' button.')]")
	public WebElement Read_Additional_Details;
	@TextType()
	@FindBy(xpath = "//textarea[@name='additionalInformation']")
	public WebElement insuredNameS1;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='BACK']")
	public WebElement bACK;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='SUBMIT TO UNDERWRITER']")
	public WebElement sUBMITTOUNDERWRITER;
	@TextType()
	@FindBy(xpath = "//h3[normalize-space(.)='Absence of easement - Access (Pedestrian & Vehicular)']")
	public WebElement Assert_Product_name;
	@TextType()
	@FindBy(xpath = "//h3[normalize-space(.)='Absence of easement - Services']")
	public WebElement Assert_product_Absence_of_easement___Services;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The access way does not cross a registered village green.']")
	public WebElement Assert_SOF_value;
	@TextType()
	@FindBy(xpath = "//strong[normalize-space(.)='Insured name(s)']")
	public WebElement Verify_Insured_name;
	@TextType()
	@FindBy(xpath = "//input[@id='input-247']")
	public WebElement selectDate;
	@TextType()
	@JavascriptBy(jspath = "return document.querySelector('lightning-overlay-container').shadowRoot.querySelector('lightning-modal-base').shadowRoot.querySelector('lightning-modal').shadowRoot.querySelector('lightning-input').shadowRoot.querySelector('lightning-datepicker').shadowRoot.querySelector('input')")
	public WebElement selectDate1;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='PROCEED WITH REFERRAL']")
	public WebElement pROCEEDWITHREFERRAL;
	@ButtonType()
	@FindBy(xpath = "(//button[contains(text(),'EMAIL QUOTE')])[last()]")
	public WebElement emailEMAILQUOTE;
	
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='Owners of properties fronting the road are not known to have made any application to the local authority requesting the road be adopted, and the local authority is not known to be considering adoption.']")
	public WebElement sof1;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The Property is a fully built, single residential dwelling (which description includes a flat) being sold/purchased or remortgaged, and that use will not change.']")
	public WebElement sof2;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The road serving the Property is maintained allowing unobstructed access to and from the Property at all times.']")
	public WebElement sof3;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='There have been no problems or disputes regarding maintenance and repair of the road.']")
	public WebElement sof4;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The Property is a fully built, single residential dwelling (which description includes a flat) being sold/purchased or remortgaged, and that use will not change.']")
	public WebElement sof5;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='There has been no indication from the relevant enforcing authority to suggest any enforcement notice may be issued or that further investigation with regard to contaminated land is to be undertaken.']")
	public WebElement sof6;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The Property benefits from an NHBC, LABC or similar building warranty scheme or Architect’s Certificate where constructed or converted within 10 years prior to the Policy Commencement Date OR was constructed more than 10 years ago.']")
	public WebElement sof7;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The mortgage lender is a Bank, Building Society or other lending institution.']")
	public WebElement sof8;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='A survey or valuation report has been completed for the Property within the last 6 months, and does not disclose any structural defects in, or recommend further investigation of, the works to be insured.']")
	public WebElement sof9;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The adjoining building, connected with the Property affected by party wall, is also a fully built, single residential dwelling.']")
	public WebElement sof10;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The Property is a fully built, single residential dwelling (which description includes a flat) being sold/purchased and/or secured against, and that use will not change.']")
	public WebElement sof11;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The area of land to be insured has been occupied and enjoyed as part of the Property exclusively and without objection for more than 5 years.']")
	public WebElement sof12;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='No part of the main structure of the Property is built on the adversely possessed area of land to be insured']")
	public WebElement sof13;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The area of adversely possessed land to be insured is not adjacent to a railway line.']")
	public WebElement sof14;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The area of adversely possessed land to be insured is unregistered and there is no advance notice against first registration.']")
	public WebElement sof15;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The Property, including the area of land to be insured, has been enclosed by a boundary structure or boundary that otherwise clearly defines the land as being part of the Property, for more than 12 months.']")
	public WebElement sof16;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='There has been no contact with any third parties regarding ownership or use of the land to be insured.']")
	public WebElement sof17;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The mining/mineral reservation was reserved by deed, mining lease or other agreement dated more than 15 years ago or is a general reservation registered against the title to the Property.']")
	public WebElement sof18;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The Property is not known to be in a mining area or, where it is, an up to date mining search has been obtained confirming it is not affected by current or planned future mining works']")
	public WebElement sof19;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='There has been no contact with any third parties who may be able to claim the benefit of the mining/mineral reservation.']")
	public WebElement sof20;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The mining/mineral reservation was reserved by deed, mining lease or other agreement dated more than 15 years ago or is a general exception or reservation registered against the title.']")
	public WebElement sof21;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The Property is not known to be in a mining area or, where it is, an up to date mining search has been obtained confirming it is not affected by current or planned future mining works.']")
	public WebElement sof22;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The mines and minerals are not separately registered under their own title in the Land Register.']")
	public WebElement sof23;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='There has been no contact with, and you will not contact, any third party who may be able to claim the benefit of the mining/mineral reservation.']")
	public WebElement sof24;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)=\"The Property includes an existing building(s), being sold/purchased and/or mortgaged or subject to grant of a lease, which will continue to be used in accordance with its existing use and no redevelopment is planned.\"]")
	public WebElement sof25;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='There has been no contact with any third parties regarding the ownership or use of the services.']")
	public WebElement sof26;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The works to be insured were completed more than 5-years ago.']")
	public WebElement sof27;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='There have been no problems or disputes regarding the works to be insured or the party wall.']")
	public WebElement sof28;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)=\"The services' route being insured has been used for more than 8 months, or where services relate to connection to a septic tank used for more than 2 years, without payment, permission or objection.\"]")
	public WebElement sof29;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)=\"There has and will not be any contact with the owner of the land over/under which the services run regarding the ownership or use of the services.\"]")
	public WebElement sof30;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='No demands for payment are known to have been received or payment made for the rent charge']")
	public WebElement sof31;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='The rent charge is not an estate rent charge']")
	public WebElement sof32;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)='There has been no contact with, and you will not contact, any third party who may be able to claim payment of the rent charge.']")
	public WebElement sof33;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)=\"The Property includes an existing building(s), being sold/purchased and/or secured against or subject to grant of a lease, which will continue to be used in accordance with its existing use and no redevelopment is planned\"]")
	public WebElement sof34;
	@TextType()
	@FindBy(xpath = "//span[normalize-space(.)=\"The Property includes an existing building(s), being sold/purchased and/or mortgaged or subject to grant of a lease, which will continue to be used in accordance with its existing use and no redevelopment is planned.\"]")
	public WebElement sof35;
	@ButtonType()
	@FindBy(xpath = "//button[contains(text(),' Your Quote')]")
	public WebElement YourQuotePage;
	@ButtonType()
	@FindBy(xpath = "//button[contains(text(),'RETURN TO SUBMISSION')][1]")
	public WebElement rETURNTOSUBMISSION;
	
	public void clickDateFunction() throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//    	Adoption of Road - Historical Private Roads
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Select date...']")));
    	WebElement element = driver.findElement(By.xpath("//input[@placeholder='Select date...']"));
    	
		Thread.sleep(2000);
//		element.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		driver.findElement(By.xpath("(//img[@alt='"+binderName+"']/following::div/div/button)[1]")).click();
		executor.executeScript("arguments[0].click();", element);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Select date...']/parent::div")));
//		driver.findElement(By.xpath("//input[@placeholder='Select date...']/parent::div")).click();
		
    	}
	@TextType()
	@FindBy(xpath = "//strong[normalize-space(.)='Referral Submitted']")
	public WebElement Assert_Referral_Submitted_Message;
	@TextType()
	@FindBy(xpath = "(//p[contains(text(),'Please note that selecting more than four products will refer the quote to an Underwriter.')])[1]")
	public WebElement refferedToastMessage;
	@TextType()
	@FindBy(xpath = "//p[normalize-space(.)=concat('You must select the ',\"'\",'Submit to Underwriter',\"'\",' control for your request to be sent to an Underwriter.')]")
	public WebElement toastSubmitToUW;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='HOME']")
	public WebElement hOME;
	public String readAndAssertQuoteStatus(String number) throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//    	Adoption of Road - Historical Private Roads
		testLogger.info("Print Quote/Policy Number: " + number);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(text(),'"+number+"')]/following::td[@data-label='Status'])[1]")));
		String statusText= driver.findElement(By.xpath("(//div[contains(text(),'"+number+"')]/following::td[@data-label='Status'])[1]")).getText();
		testLogger.info("Print Quote/Polic Number Status: " + statusText);
		return statusText;
    	}
    public String readAndReturnQuoteNumber(String number) throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//    	Adoption of Road - Historical Private Roads
		testLogger.info("Print Quote/Policy Number: " + number);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@title='"+number+"']/preceding::td[@data-label='Quote/Policy Ref'])[1]")));
		String statusText= driver.findElement(By.xpath("(//div[@title='"+number+"']/preceding::td[@data-label='Quote/Policy Ref'])[1]")).getText();
		testLogger.info("Print Quote/Policy Number from UI : " + statusText);
		return statusText;
    	}
        	
	@TextType()
	@FindBy(xpath = "(//p[normalize-space(.)='Please note that having a Limit of Indemnity of more than £25m will refer the quote to an Underwriter.'])[1]")
	public WebElement LOI25ReferText;
	@TextType()
	@FindBy(xpath = "//span[text()='Policy Commencement Date:']/ancestor::slot//input")
	public WebElement dateNew;
	
	public void setDate(String date1) throws InterruptedException{
	driver.findElement(By.xpath("//span[text()='Policy Commencement Date:']/ancestor::slot//input/..")).click();
	Thread.sleep(2000);
	//driver.findElement(By.xpath("//button[contains(text(),'Today')]")).click();
	dateNew.sendKeys(Keys.RETURN);
	}
	@TextType()
	@FindBy(xpath = "//slot[contains(text(),'Thank you. Your documents are being generated and will been sent to the specified email address/s in the next few minutes.')]")
	public WebElement toastMessage;
	@TextType()
	@FindBy(xpath ="(//p[normalize-space(.)='Please note that having a Limit of Indemnity of more than £5m will refer the quote to an Underwriter.'])[1]")
	public WebElement LOI5MRefertext;
	@TextType()
	@FindBy(xpath = "(//img[@alt=\"Royal & Sun Alliance Insurance Limited\"]/following::div/div)[1]\n")
	public WebElement Override_premium_rsa;
	
			
}
