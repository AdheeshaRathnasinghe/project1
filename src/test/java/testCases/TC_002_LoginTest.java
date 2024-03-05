package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	public void test_Login()
	{
		
		
		logger.info("Starting TC_002_LoginTest....");
		
		try {
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLogin();
		
		
		MyAccountPage myacc=new MyAccountPage(driver);
		boolean targetPage=myacc.isMyAccountPageExists();
		Assert.assertEquals(targetPage, true);
		}catch(Exception e)
		{
			Assert.fail();
		}
		
		
		logger.info("Ending TC_002_LoginTest....");
		
	}

}
