package commonUtils;

import java.io.IOException;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentation implements ITestListener {
	
	JavaUtils jUtils =new JavaUtils();
	ExtentReports report;
	ExtentTest test ;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"Test Script Execution Started",true);
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"Test Script Execution is Successful",true);
		test.log(Status.PASS, methodName+"Test Script Execution is Successful");
		
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		Throwable msg = result.getThrowable();
		
		//Reporter.log(methodName+"Test Script Execution Failed"+msg,true);
		test.log(Status.FAIL, methodName+"Test Script is Failed");
		WebDriverUtils wUtils = new WebDriverUtils();
        JavaUtils jUtils  = new JavaUtils();
		
		int random = jUtils.getRandomNumber();
		String screenShotName = methodName;
		try {
			String path =wUtils.screenshot(BaseClass2.sDriver, screenShotName+random);
			//  to Add  ScreenShot to my Extent report
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
	///	Reporter.log(methodName+"Test Script Execution Skipped",true);
		test.log(Status.SKIP, methodName+"Test Script Execution is Skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		
		// configuration of  extent report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentsReport/report"+jUtils.getRandomNumber()+jUtils.getRandomNumber()+".html");
		htmlreport.config().setDocumentTitle("Fraamework vTiger");
		htmlreport.config().setReportName("vTigerCRM");
		htmlreport.config().setTheme(Theme.STANDARD);
		
		
		// to add information to the html report
	    report = new ExtentReports();
		// to attach all the data to the html report
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "WINDOWS");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Author", "Atharva Khati");
	
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		// all data  which is Written on onStart() will be configured to report
		report.flush();
		
		
	}
	
    
    

}
