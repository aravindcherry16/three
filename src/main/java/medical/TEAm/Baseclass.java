package medical.TEAm;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v101.css.CSS.TakeCoverageDeltaResponse;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.google.common.io.Files;

public class Baseclass {
	WebDriver driver;
	Properties pro;
	
	@BeforeTest
	public void open_browser() throws IOException {
		FileInputStream fS =new FileInputStream("C:\\Users\\VOONNA ARAVIND VAMSI\\eclipse-workspace\\TEAm\\test-output\\old\\Suite\\values.properties");
		pro=new Properties();
		pro.load(fS);
		String browsername=pro.getProperty("browser");
		System.out.println(browsername);
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver_win32 (5)\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get(pro.getProperty("url"));
			
		}
		
		
	}
	@AfterMethod
	public void Screenshot(ITestResult result) throws IOException {
		if(result.getStatus()==result.FAILURE) {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			String dest=System.getProperty("User.dir")+result.getMethod().getMethodName()+".png";
			File fs=new File(dest);
			//Files.copy(src ,System.getProperty("User.dir")+result.getMethod().getMethodName()+".png" );
			Files.copy(src, fs);
		
			
		}
		
	}

}
