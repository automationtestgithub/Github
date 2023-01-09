package Com.Guru99.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import freemarker.template.SimpleDate;
import net.bytebuddy.utility.RandomString;

public class ExtentReporterNG {

	public static ExtentReports extent;

	public static ExtentReports getReportObject()
	{
		String Random = RandomString.make(5);
			
        String Timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    	String Name = "ExtentReport -"+Timestamp;
        String path = System.getProperty("user.dir")+"/reports/"+Name+""+".html";
        
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		
		reporter.config().setReportName("Framework Results");
		reporter.config().setDocumentTitle("Automation Execution Results");
		
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Automation Engineer", "Nikhil Pandit");
		return extent;	
	}

	public void endTest()
	{
		extent.flush();

	} 
}