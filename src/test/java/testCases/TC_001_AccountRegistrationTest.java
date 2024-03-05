package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression","Master"})
	public void test_accountRegistration()
	{
		logger.info("****Starting TC_001_AccountRegistrationTest****");
		Homepage hp=new Homepage(driver);
		
		logger.info("Clicking on MyAccount link");
		hp.clickMyAccount();
		
		logger.info("Clicking on Register link");
		hp.clickRegister();
		
		logger.info("Providing Customer Details");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		  logger.info("Registration Successful... ");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Registration Failed");
			Assert.fail();
		}

		logger.info("****Finishing TC_001_AccountRegistrationTest****");
		
	}
	
}
