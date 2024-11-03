package rahuallshettyacademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	
	ExtentReports extent;
	
	@BeforeTest
	public void config()
	{
		//ExtentReport, ExtentSparkReporter thees are 2 classes
		//ExtentSparkReporter= responsible for creating the report 
		//for thet we have to give path 
		String Path= System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(Path);
		//set configuration with above object
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation Results");
		
		//create object of other class , this is main 
		 extent=new ExtentReports();
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("Tester", "Prachi Parmar");
		
	}
	
	@Test
	public void initialDemo()
	{ //connect this test case with the extent object
		// extent.createTest("initialDemo") : this line create a ExtentTest object that will hold the data of this methood
		ExtentTest  test=extent.createTest("initialDemo");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		//explicitly failling this
		test.fail("reports do not match");
		extent.flush();
	}

}
