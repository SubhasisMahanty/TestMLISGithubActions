package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.logging.Logger;


import com.provar.core.testapi.annotations.*;

@Page( title="UWQuotePage"                                
     , summary=""
     , relativeUrl=""
     , connection="MLISUnderWriter"
     )             
public class UWQuotePage {
	@TestLogger
    public Logger testLogger;
	WebDriver driver;
//	WebDriverWait wait = new WebDriverWait(driver, 90);
	public UWQuotePage(WebDriver driver){
	this.driver= driver;
	}
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='Search...']")
	public WebElement _quoteNumberUI_;
	
	public void clickQuote_PolicyNumber(String number) throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//    	Adoption of Road - Historical Private Roads
		testLogger.info("Print the Number : " + number);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='"+number+"']")));
		driver.findElement(By.xpath("//a[@title='"+number+"']")).click();
		
    	}
    public void navigate_To_Risk_ID_from_PolicyNumber(String subName) throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//    	Adoption of Road - Historical Private Roads
		testLogger.info("Print the Policy Number : " + subName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Submission Name']")));
		
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(subName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(Keys.ENTER);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Bound')]/parent::span/parent::td/preceding-sibling::td/span/a[@title='"+subName+"']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Bound')]/parent::span/parent::td/preceding-sibling::td/span/a[@title='"+subName+"']")));
		testLogger.info("--------");
		
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Bound')]/parent::span/parent::td/preceding-sibling::td/span/a[@title='"+subName+"']"));
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
//		driver.findElement(By.xpath("//span[contains(text(),'Bound')]/parent::span/parent::td/preceding-sibling::td/span/a[@title='"+subName+"']")).click();
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-label='Details']")));
		
//		driver.findElement(By.xpath("//a[@data-label='Related']")).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Notes & Attachments']")));
//		
//		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)", "");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Insurance Policies']")));
//		String pNumber = driver.findElement(By.xpath("//span[starts-with(text(),'DAU/')]")).getText();
//		testLogger.info("Print PolicyNUmber :" +pNumber);
		 
		
		
		
		
		
    	}
    public void setDiscountPercentage(int number) throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//    	Adoption of Road - Historical Private Roads
		testLogger.info("Print the Discount Number : " + number);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Discount (%):')]/following::div[1]/input")));
//		driver.findElement(By.xpath("//label[contains(text(),'Discount (%):')]/following::div[1]/input")).sendKeys(Keys.DOWN,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT);
		for (int i=0;i<number;i++)
		{
		testLogger.info("Print I : " + i);
		driver.findElement(By.xpath("//label[contains(text(),'Discount (%):')]/following::div[1]/input")).sendKeys(Keys.DOWN,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT);
		} 		
		
		
    	}	
	@TextType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//input[@id='input-579']")
	public WebElement discount;
	@ButtonType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//button[normalize-space(.)='Update Premium']")
	public WebElement updatePremium;
	@TextType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//div[3]//div[3]/div/lightning-formatted-number")
	public WebElement OverriddenPremium;
	@TextType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//div[3]//div[2]/div/lightning-formatted-number")
	public WebElement OriginalPremium;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='Continue Quote']")
	public WebElement continueQuote;
	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='Quotes']")
	public WebElement quotes;
	@ButtonType()
	@FindBy(xpath = "//button[contains(text(),'RETURN TO SUBMISSION')][1]")
	public WebElement rETURNTOSUBMISSION;
	@TextType()
	@FindByLabel(label = "Stage", labelType = LabelType.SalesforceLightningDesignSystem)
	public WebElement StageName;
	@TextType()
	@FindBy(xpath = "//button[@type='button' and @role='combobox']")
	public WebElement type_button;
	@TextType()
	@FindBy(xpath = "//span[@title='Statement of Fact']")
	public WebElement option_sof;
	@TextType()
	@FindBy(xpath = "//span[@title='Uninsured Matter']")
	public WebElement option_uninsured;
	@TextType()
	@FindBy(xpath = "//span[@title='Terms & Condition']")
	public WebElement option_termsCon;
	public void selectSOF() throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Statement of Fact']")));
		option_sof.click();
    	}
    public void selectUninsured() throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Uninsured Matter']")));
		option_uninsured.click();
    	}
    public void selectTermsCon() throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Terms & Condition']")));
		option_termsCon.click();
    	}
    public void scrollDown() throws InterruptedException{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)", "");
    }
    @TextType()
    @FindBy(xpath = "//div[@data-placeholder='type here...']")
	public WebElement Addterm_Text_Field;
	@TextType()
    @FindBy(xpath = "//p[@aria-placeholder='type here...']")
	public WebElement Addterm_Text_Field_P_click;
	@TextType()
	@FindBy(xpath = "//div[@tabindex='0' and @data-index='0']")
	public WebElement Product_Coverage;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='Move to Applied']")
	public WebElement moveSelectionToApplied;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='SAVE']")
	public WebElement sAVE_Term;
	@LinkType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//a[normalize-space(.)='View AllSubmission Statement Of Facts']")
	public WebElement SOF_viewAll;
	@TextType()
	@FindBy(xpath = "//lightning-base-formatted-text[contains(text(),'Automation sof1')]")
	public WebElement MLIS_Text__SOF;
	@TextType()
	@FindBy(xpath = "//lightning-base-formatted-text[contains(text(),'Automation UM1')]")
	public WebElement MLIS_Text__UninsuredMatter;
	@TextType()
	@FindBy(xpath = "//lightning-base-formatted-text[contains(text(),'Automation TC1')]")
	public WebElement MLIS_Text__TermsConditions;
	@TextType()
	@FindBy(xpath = "//lightning-base-formatted-text[contains(text(),'Automation UM1')][1]")
	public WebElement UninsuredMatter_Assertext;
	@TextType()
	@FindBy(xpath = "//span[@title='Submission Uninsured Matters']")
	public WebElement UninsuredMatter_viewAll;
	@TextType()
	@FindBy(xpath = "//span[@title='Submission Terms & Conditions']")
	public WebElement Terms_Condition_viewAll;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='CLOSE']")
	public WebElement cLOSE_Term;
	@LinkType()
	@FindBy(xpath = "//one-app-nav-bar-item-root/a[normalize-space(.)='Submissions']")
	public WebElement All_Submissions;
	@ButtonType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//button[normalize-space(.)='Add Terms']")
	public WebElement addTerms;
	@LinkType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//a[@id='flexipage_tab__item']")
	public WebElement SubmissionRelatedTab;
	@ButtonType()
	@FindBy(xpath = ".//c-mlis-u-w-quote-view//div[3]//button[normalize-space(.)='Edit Terms']")
	public WebElement editTerms;
	@TextType()
	@FindBy(xpath = "//input[@name='newExcess']")
	public WebElement newExcess;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='SAVE AND CLOSE']")
	public WebElement sAVEANDCLOSE;
	@LinkType()
	@FindBy(linkText = "Related")
	public WebElement related;
	@LinkType()
	@FindBy(xpath = "//a[@data-label='Related']")
	public WebElement related1;
	@LinkType()
	@FindBy(xpath = "//a[@data-label='sFiles']")
	public WebElement sFiles;
	@LinkType()
//	@FindBy(xpath = "//slot/span[@id='window' and contains(text(),'DAU/')]")
	@FindBy(xpath = "//th[@data-label='Policy Number']//a//span/slot/span/slot")
//	
	public WebElement policyNumber_underIP;
	public void scrollToElement(String xpath) throws InterruptedException{
		testLogger.info("-- Test --");
    	testLogger.info("Print Xpath : "+xpath); 
//		WebElement element = driver.findElement(By.xpath(xpath));
//		((JavascriptExecutor) driver).executeScript("scroll(0, 250);");
//		((JavascriptExecutor) driver).executeScript("scroll(0, 250);");
//		Thread.sleep(5000);
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    	((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1100)", "");
//    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//    	
    	}
	@LinkType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//a[normalize-space(.)='View AllNotes & Attachments']")
	public WebElement viewAllNotesAndAttachments;
	@LinkType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//a[normalize-space(.)='AttachmentPolicy Document.pdf']")
	public WebElement AttachmentPolicy_Document_pdf;
	@LinkType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//a[normalize-space(.)='AttachmentQuote Document.pdf']")
	public WebElement AttachmentQuote_Document_pdf;	
	@ButtonType()
	@FindBy(xpath = "//button[@title='Refresh']")
	public WebElement refreshButton;
	@ButtonType()
	@FindBy(xpath = "//span[contains(text(),'Show more actions')]")
	public WebElement showMoreOptions;
	@ButtonType()
	@FindBy(xpath = "//span[contains(text(),'Cancel Policy')]")
	public WebElement cancelPolicy;
	@TextType()
    @FindBy(xpath = "//input[@aria-label='Policy Cancellation Date']")
	public WebElement date_policyCancel;
	
    public void selectImpersonationFirm(String interm) throws InterruptedException{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
    testLogger.info("Firm/Intermediary Selected as Impersonation: "+interm);
    driver.findElement(By.xpath("//label[contains(text(),'Broker Account')]/parent::div/div/input")).click();
    driver.findElement(By.xpath("//label[contains(text(),'Broker Account')]/parent::div/div/input")).clear();
    driver.findElement(By.xpath("//label[contains(text(),'Broker Account')]/parent::div/div/input")).sendKeys(interm.substring(0, interm.length() - 2));
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-mainfield='"+interm+"']")));
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-mainfield='"+interm+"']")));
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-mainfield='"+interm+"']")));
    
    driver.findElement(By.xpath("//div[@data-mainfield='"+interm+"']")).click();
    //testLogger.info("****");
    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-mainfield='"+interm+"']")));
    //driver.findElement(By.xpath("//div[@data-mainfield='"+interm+"']")).click();
    }
    public void selectImpersonationUser(String brk) throws InterruptedException{
//    JavascriptExecutor js = (JavascriptExecutor)driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
    testLogger.info("Broker Selected as Impersonation: "+brk);
    driver.findElement(By.xpath("//div/label[contains(text(),'Broker User')]/following::input[@type='search']")).click();
    driver.findElement(By.xpath("//div/label[contains(text(),'Broker User')]/following::input[@type='search']")).clear();
    driver.findElement(By.xpath("//div/label[contains(text(),'Broker User')]/following::input[@type='search']")).sendKeys(brk.substring(0,brk.length() - 2));
    //WebElement popUp=driver.findElement(By.xpath("//div[@data-mainfield='"+brk+"']"));
    //testLogger.info("Selected Brk User Successfull with."+popUp.getText());
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-mainfield='"+brk+"']")));
 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-mainfield='"+brk+"']")));
	driver.findElement(By.xpath("//div[@data-mainfield='"+brk+"']")).click();
//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-mainfield='"+brk+"']")));
//	js.executeScript("arguments[0].click();", popUp);
    }
    public void selectQuoteTypeRes() throws Exception{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
    testLogger.info("Quote Type selected as Residential");
    driver.findElement(By.xpath("//button[@name='quoteType']")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Residential')]")));
	driver.findElement(By.xpath("//span[contains(text(),'Residential')]")).click();
    }
    public void selectQuoteTypeCom() throws Exception{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
    testLogger.info("Quote Type selected as Commercial");
    driver.findElement(By.xpath("//button[@name='quoteType']")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Commercial')]")));
	driver.findElement(By.xpath("//span[contains(text(),'Commercial')]")).click();
    }
    public void selectJurisdiction(String jur) throws Exception{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
    testLogger.info("Jurisdiction type: "+jur);
    driver.findElement(By.xpath("//button[@name='jurisdiction']")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+jur+"')]")));
	driver.findElement(By.xpath("//span[contains(text(),'"+jur+"')]")).click();
    }
    public void selectImpersonationBrand(String brand) throws Exception{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
    testLogger.info("Brand Selected: "+brand);
    driver.findElement(By.xpath("//span[contains(text(),'Select Brand')]")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Brand')]/following::div[@role='listbox'][1]/lightning-base-combobox-item[@data-value='"+brand+"']")));
	driver.findElement(By.xpath("//label[contains(text(),'Brand')]/following::div[@role='listbox'][1]/lightning-base-combobox-item[@data-value='"+brand+"']")).click();
    }
	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='Quote Journey']")
	public WebElement quoteJourney;
	public void selectProductUW(String pName) throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//    	Adoption of Road - Historical Private Roads
		testLogger.info("Print the ProductName : " + pName);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h3[contains(text(),'"+pName+"')]/following::div/button)[1]")));
//		testLogger.info("***");
//		WebElement element = driver.findElement(By.xpath("(//h3[contains(text(),'"+pName+"')]/following::div/button)[1]"));
//		testLogger.info("***");
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		//Thread.sleep(500);
//		testLogger.info("***");
		driver.findElement(By.xpath("//h3[contains(text(),'"+pName+"')]/following::slot[1]/div/button[contains(text(),'SELECT')]")).click();
		
		
    	}	
	//span[contains(text(),'Cancellation Instigated By')]/parent::label/following::div/div/div/input
	public void selectDDCancellation(String byperson) throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		testLogger.info("Print the Address : " + byperson);
		driver.findElement(By.xpath("//span[contains(text(),'Cancellation Instigated By')]/parent::label/following::div/div/div/input")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+byperson+"')]")));
		driver.findElement(By.xpath("//span[contains(text(),'"+byperson+"')]")).click();
	}
    public void selectDDCancellationReason(String reason) throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		testLogger.info("Print the Cancellation reason : " + reason);
		driver.findElement(By.xpath("//span[contains(text(),'Cancellation Reason')]/parent::label/parent::div/following-sibling::div/div/div/input")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+reason+"')]")));
		driver.findElement(By.xpath("//span[contains(text(),'"+reason+"')]")).click();
	}
	public void selectDDSubReason(String subReason) throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		testLogger.info("Print the sub reason : " + subReason);
		driver.findElement(By.xpath("//span[contains(text(),'Sub Reason')]/parent::label/parent::div/following-sibling::div/div/div/input")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+subReason+"')]")));
		driver.findElement(By.xpath("//span[contains(text(),'"+subReason+"')]")).click();
	}
    @ButtonType()
    @FindBy(xpath = "(//span[contains(text(),'Next')])[last()]")
	public WebElement next;
	@TextType()
	@FindBy(xpath = "//textarea[@class='slds-textarea']")
	public WebElement cancellationNotesNarrative;
	@TextType()
	@FindBy(xpath = "//label[contains(text(),'Gross Written Premium')]/following-sibling::div/input")
	public WebElement grossWrittenPremium;
	@TextType()
	@FindBy(xpath = "//label[contains(text(),'Cancellation Return Premium')]/following-sibling::div/input")
	public WebElement cancellationReturnPremium;
	@LinkType()
	@FindBy(xpath = "(//a[@id='detailTab__item'])[last()]")
	public WebElement details;
	@TextType()
	@FindBy(xpath = "//records-record-layout-item[@field-label=\"Status\"]//lightning-formatted-text[@slot=\"outputField\"]")
	public WebElement Status;
	@ButtonType()
	@FindBy(xpath = "//b[contains(text(),'Royal & Sun Alliance Insurance Limited')]/following::button[contains(text(),'Remove Quote')][1]")
	public WebElement removeQuoteRSA;
	@TextType()
	@FindBy(xpath = "//b[contains(text(),'Royal & Sun Alliance Insurance Limited')]/following::div[contains(text(),'NO QUOTE OFFERED')]")
	public WebElement noQuoteOfferedRSA;
	@ButtonType()
	@FindBy(xpath = "//button[contains(text(),'BACK')]")
	public WebElement bACK;
	@ButtonType()
	@FindBy(xpath = "//button[contains(text(),' Your Quote')]")
	public WebElement YourQuotePage;
	@TextType()
	@FindBy(xpath = "//div[contains(text(),'NO QUOTE OFFERED')]/following::div[contains(text(),'Royal & Sun Alliance Insurance Limited')]")
	public WebElement RSAAssertTrue;
	@ButtonType()
	@FindBy(xpath = "//b[contains(text(),'Royal & Sun Alliance Insurance Limited')]/following::button[contains(text(),'Unhide Quote')]")
	public WebElement unhideQuoteRSA;
	@TextType()
	@FindBy(xpath = "//div[contains(text(),'Royal & Sun Alliance Insurance Limited')]/preceding::div[contains(text(),'£108.27')]")
	public WebElement RSAPremiumAssert;
	
	
    public void setCancelDate() throws InterruptedException{
	driver.findElement(By.xpath("(//label[text()='Policy Cancellation Date']/following::div/input)[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[contains(text(),'Today')]")).click();
	}
	@ButtonType()
	@FindByLabel(label = "Next")
	public WebElement next1;
	@TextType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneWorkspace') and (ancestor::div[contains(@class,'active') and contains(@class,'main-content')]//div[contains(@class, 'oneGlobalNav') or contains(@class, 'tabBarContainer')]//div[contains(@class, 'tabContainer') and contains(@class, 'active')] )]//vlocity_ins-button[1]//span[normalize-space(.)='Previous']")
	public WebElement previous;
	@LinkType()
	@FindBy(xpath = "//th[@data-label='Policy Number']//a//span/slot/span/slot")
	public WebElement policyNumber_underIP1;
    

}

