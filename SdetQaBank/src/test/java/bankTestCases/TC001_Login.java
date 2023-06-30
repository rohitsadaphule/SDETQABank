package bankTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import bankPageObject.LoginPage;


public class TC001_Login extends BaseClass {
	
	

		@Test
		public void testlogin()
		{
			
			driver.get(BaseUrl);
			
			LoginPage lp = new LoginPage(driver);
			lp.setUsername(username);
			lp.setPassword(password);
			lp.clickSubmit();
			
			if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
			{
			 Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			
			
		}
		
	}


