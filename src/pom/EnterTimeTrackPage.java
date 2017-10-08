package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.IAutoConstant;
import generic.Lib;

public class EnterTimeTrackPage
{
	@FindBy(xpath ="//div[@class = 'popup_menu_button popup_menu_button_support']//div[@class = 'popup_menu_label']")
	private WebElement help_LINK;
	
	@FindBy(xpath="//a[.='About your actiTIME']")
	private WebElement aboutActimeLink;
	
	@FindBy(xpath="//span[.='actiTIME 2017.4']")
	private WebElement productVersionText;
	
	@FindBy(xpath ="//div[@id='aboutPopupCloseButtonId']")
	private WebElement closeBTN;
	
	@FindBy(id = "logoutLink")
	private WebElement logoutLink;



//create the constructor

public EnterTimeTrackPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

//perform the action

public void clickOnHelpLink()

{
	help_LINK.click();
}

public void ClickAboutActimeLink()

{
	aboutActimeLink.click();
}

//public void VerifyProductVersionText(String eVerison)
//{
//	
//	String aVersion = productVersionText.getText();
//	Assert.assertEquals(aVersion, eVerison);
//}



public void VerifyProductVersionText() throws InterruptedException
{
	String expversion = Lib.getProperty(IAutoConstant.CONFIG_PATH, "eVersion");
	String aVersion = productVersionText.getText();
	Assert.assertEquals(aVersion, expversion);
	Reporter.log("Product version is verified sucessfully",true);
	Thread.sleep(2000);
	
}

public void ClickCloseBTN() throws InterruptedException

{
	closeBTN.click();
	Thread.sleep(2000);
}

public void ClickLogoutBTN()

{
	logoutLink.click();
}


public void verifyTitle(WebDriver driver, String eTitle)

{
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	try
	{
		wait.until(ExpectedConditions.titleIs(eTitle));
		Reporter.log("Pass: Home page is displayed",true);
	}
	
	catch(Exception e)
	{
		Reporter.log("Fail: Home page is not displayed",true);
		Assert.fail();
	}
}

 

}