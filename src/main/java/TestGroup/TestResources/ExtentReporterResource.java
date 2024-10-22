package TestGroup.TestResources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterResource {

public ExtentReports	extentReporterObject()
{
	ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\masineni.s.teja\\eclipse-workspace\\TestAutomation\\test-output\\Testreport.html");
	reporter.config().setReportName("Test Report");
	reporter.config().setDocumentTitle("Test Automation Report");
	
	
	
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	return extent;
}
	
}
