package bankTestCases;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bankPageObject.LoginPage;

public class TC_DDT_002 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) 
	{
	 LoginPage lp=new LoginPage(driver);
	 System.out.println("user:"+user);
	 driver.get(BaseUrl);
	 lp.setUsername(user);
	 lp.setPassword(pwd);
	 lp.clickSubmit();
	 
	 if(isAlertPresent()==true)
	 {
		
		 driver.switchTo().alert().accept();
		
		 driver.switchTo().defaultContent();
		 Assert.assertTrue(false);
		
		 
	 }
	 else {
		
		 lp.logOut();
		 driver.switchTo().alert().accept();
		 driver.switchTo().defaultContent();
		 Assert.assertTrue(true);
	 }
	 
	}
	 
	 public boolean isAlertPresent()
	 {
		 try {
			 driver.switchTo().alert();
			 return true;
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
			 
		 } 
		
	@DataProvider(name="LoginData")

	String [][] getData() throws IOException
	{
		String path =System.getProperty("user.dir")+"\\TestData\\xlfile.xlsx";
		FileInputStream fis = new FileInputStream (path);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sh= wb.getSheet("LoginData");
        int row = sh.getPhysicalNumberOfRows();
		int col = sh.getRow(0).getPhysicalNumberOfCells();
		String logindata[][]=new String[row-1][col];	
		for (int i=1; i<row; i++)
		{
			for(int j=0; j<col; j++)
			{
				logindata[i-1][j]= sh.getRow(i).getCell(j).getStringCellValue();
                
			}
			
		}
		return logindata;
	}
}