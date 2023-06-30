package bankPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCus {
	WebDriver ldriver;
	public  AddNewCus(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[text()='New Customer']")
	WebElement newcuslink;
	public void newcustomer()
	{
		newcuslink.click();
	}
	
	@FindBy(xpath="//input[@name='name']")
	WebElement custname;
	public void customername(String name)
	{
		custname.sendKeys(name);
	}
	
	@FindBy(xpath="//input[@value='f']")
     WebElement gender;
	public void Gender()
	{
		gender.click();
	}
	
	@FindBy(xpath="//input[@id='dob']")
	WebElement dob;
	public void dateOfBirth(String dd, String mm,String yyyy )
	{
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yyyy);
		
	}
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement address;
	public void Address(String add)
	{
		address.sendKeys(add);
	}
	
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	public void City(String cityname)
	{
		city.sendKeys(cityname);
	}
	
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	public void State(String statename)
	{
		state.sendKeys(statename);
	}
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement pin;
	public void PIN(String code)
	{
		pin.sendKeys(String.valueOf(code));
	}
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement mobile;
	public void mobileNumber(String num)
	{
		mobile.sendKeys(String.valueOf(num));
	}
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement email;
	public void emailid(String id)
	{
		email.sendKeys(id);
	}
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	public void Password(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	@FindBy(xpath="//input[@name='sub']")
	WebElement submit;
	public void btnSubmit()
	{
		submit.click();
	}
	
	
}
