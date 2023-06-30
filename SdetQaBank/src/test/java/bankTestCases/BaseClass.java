package bankTestCases;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass implements ITestListener {
	
	public String BaseUrl= "https://demo.guru99.com/v4/";
	public String username=  "mngr512140";
	public String password= "dejuveq";
	public static WebDriver driver;
	ExtentReports extent;
	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	@AfterMethod
	public void tearDown()
	{
	driver.close();	
	}
	

	public void config() {
		String path = System.getProperty("user.dir")+"\\reportes\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("paratc001");
		
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rohit");
	}
	


	
	public static void getScreenshot(String scname) {
		System.out.println("I failed executing");
		 File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try {
			 
			 FileUtils.copyFile(src, new File("C:\\Users\\Rohit\\eclipse-workspace\\SdetQaBank\\Screenshots\\"+scname+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

}