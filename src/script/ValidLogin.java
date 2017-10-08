package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pom.EnterTimeTrackPage;
import pom.LoginPage;

public class ValidLogin extends BaseTest
{
	@Test(priority=1,enabled = false)
	public void testValidLogin()
	{
		
		
		LoginPage l = new LoginPage(driver);
				//1.enter valid UN
		l.setUserName("admin");
				//2.enter valid Pwd
		l.setPassword("manager");
				//3.click on login button
		l.clickLogin();
				//4.verify home page is displayed
		
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		e.verifyTitle(driver, "actiTIME - Enter Time-Track");
				
	}

	@Test(priority=1)
	public void testValidLoginViaExcel()
	{	
		// taking Un and password from excel file
		String UserName = Lib.getCellValue(XLPATH, "Sheet1", 2, 0);
		String Pwd = Lib.getCellValue(XLPATH, "Sheet1", 2, 1);
		String HPageTitle = Lib.getCellValue(XLPATH, "Sheet1", 1, 2);
		
		LoginPage l1 = new LoginPage(driver);
		l1.setUserName(UserName);
		l1.setPassword(Pwd);
		l1.clickLogin();
	
		
		//EnterTimeTrackPage ett = new EnterTimeTrackPage(driver);
		//ett.verifyTitle(driver, HPageTitle);
		
		
	}
	
}
