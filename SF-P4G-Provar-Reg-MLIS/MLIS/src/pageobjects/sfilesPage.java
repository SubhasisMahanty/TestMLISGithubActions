package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.SalesforcePage;

@SalesforcePage(title = "sfilesPage", summary = "", connection = "MLISEnhancedUnderwriter", auraComponent = "enterprise", namespacePrefix = "fileforcem1")
public class sfilesPage {

	@ButtonType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//span[normalize-space(.)='Debit Note.pdf']//button[@name='openItem']")
	public WebElement debitNotePdf;
	@ButtonType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//span[normalize-space(.)='Final Draft.pdf']//button[@name='openItem']")
	public WebElement finalDraftPdf;
	@ButtonType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//span[normalize-space(.)='Policy Document.pdf']//button[@name='openItem']")
	public WebElement policyDocumentPdf;
	@ButtonType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//span[normalize-space(.)='Quote Document.pdf']//button[@name='openItem']")
	public WebElement quoteDocumentPdf;
	@ButtonType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//span[normalize-space(.)='Specimen Policy Document.pdf']//button[@name='openItem']")
	public WebElement specimenPolicyDocumentPdf;
	@ButtonType()
	@FindBy(xpath = "//button[@title='Refresh']")
	public WebElement refreshButtton;

}
