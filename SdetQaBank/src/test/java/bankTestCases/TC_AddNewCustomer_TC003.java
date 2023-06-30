package bankTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import bankPageObject.AddNewCus;
import bankPageObject.LoginPage;

public class TC_AddNewCustomer_TC003 extends BaseClass{
	
	@Test
	public void newcustomer()
	{
		driver.get(BaseUrl);
		LoginPage lp= new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		AddNewCus customer= new AddNewCus(driver);
		customer.newcustomer();
		customer.customername("Sudhir");
		customer.Gender();
		customer.dateOfBirth("01", "01", "2000");
		customer.Address("Ekta society");
		customer.City("Navi Mumbai");
		customer.State("Maharashtra");
		customer.PIN("400704");
		customer.mobileNumber("1234512345");
		customer.emailid("sudhirpawarad@gmail.com");
		customer.Password("Quark@123");
		customer.btnSubmit();
		
		
		boolean msg=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(msg==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		
	}

}
