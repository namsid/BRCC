package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import pom.EnterTimeTrackPage;
import pom.LoginPage;

public class VerifyProductVersion extends BaseTest
{
	@Test(priority=3)
	public void testProductVersion() throws InterruptedException
	{
		LoginPage l2 = new LoginPage(driver);
		
		//1.Enter valid UN
		l2.setUserName("admin");
		//2.enter valid pwd
		l2.setPassword("manager");
		//3.click on login button
		l2.clickLogin();
		//4.click on help
		
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		e.clickOnHelpLink();
		
		//5.click on about your actitime
		e.ClickAboutActimeLink();
		//6.verify the product version is actiTIME 2017.4 
		e.VerifyProductVersionText();
		//7.click on close
		e.ClickCloseBTN();
		//8.click on logout
		e.ClickLogoutBTN();
	}
	
	
	
	
}
