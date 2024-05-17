package pageobjects;

import java.sql.Driver;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.provar.core.testapi.annotations.*;

@Page( title="HomePage"                                
     , summary=""
     , relativeUrl=""
     , connection="MLISBroker"
     )             
public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver){
	this.driver= driver;
	}
	@TestLogger
    public Logger testLogger;
    
	@LinkType()
	@FindBy(xpath = "//a[@href='broker-zone' and contains(text(),'Home')]")
	public WebElement hOME;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='CLOSE']")
	public WebElement closePopup;
	@TextType()
	@FindBy(xpath = "//*[@data-quote-type='Residential' and @data-jurisdiction='EnglandAndWales']")
	public WebElement E_W_Residential;
	@TextType()
	@FindBy(xpath = "//*[@data-quote-type='Residential' and @data-jurisdiction='NorthernIreland']")
	public WebElement N_I_Residential;
	@TextType()
	@FindBy(xpath = "//*[@data-quote-type='Residential' and @data-jurisdiction='Scotland']")
	public WebElement S_C_Residential;
	@TextType()
	@FindBy(xpath = "//*[@data-quote-type='Commercial' and @data-jurisdiction='EnglandAndWales']")
	public WebElement E_W_Commercial;
	@TextType()
	@FindBy(xpath = "//*[@data-quote-type='Commercial' and @data-jurisdiction='NorthernIreland']")
	public WebElement N_I_Commercial;	
	@TextType()
	@FindBy(xpath = "//*[@data-quote-type='Commercial' and @data-jurisdiction='Scotland']")
	public WebElement S_C_Commercial;
	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='Quote Journey']")
	public WebElement quoteJourney;
	@LinkType()
	@FindBy(xpath = "//a[@data-id=\"EnglandAndWales\"]/strong[contains(text(),'House Buyer or Seller')]")
	public WebElement HouseBuyerorSellerE_W;
	@LinkType()
	@FindBy(xpath = "//a[@data-id='Scotland']/strong[contains(text(),'House Buyer or Seller')]")
	public WebElement HouseBuyerorSeller_SC;
	@LinkType()
	@FindBy(xpath = "//a[@data-id='NorthernIreland']/strong[contains(text(),'House Buyer or Seller')]")
	public WebElement HouseBuyerorSeller_NI;
	
	public String getBrandLogoAttr() throws Exception	{		
		WebElement Logo = driver.findElement(By.xpath("//img[@class='img-responsive img-rounded']"));
		String LogoText = Logo.getAttribute("src");
		return LogoText;
	}
	
	@LinkType()
	@FindBy(xpath = "//button[@aria-label='Open LiveChat chat widget']/preceding::p[contains(text(),'Leave a message')]")
	public WebElement liveChatButton;
	@LinkType()
	@FindBy(xpath = "//h1[contains(text(),'Welcome to LiveChat')]")
	public WebElement liveChatAssert;
	
	@LinkType()
	@FindBy(xpath = "//input[@type='checkbox']/following::label[contains(text(),'I want to receive newsletter campaigns')]")
	public WebElement chatCheckBox;
	@LinkType()
	@FindBy(xpath = "//button[@type='submit']//span[contains(text(),'Start the chat')]")
	public WebElement startChat;
	
	public void setLiveChatValues(String name, String emailId){
	driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailId);
	}
	
}
