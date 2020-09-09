package tests;

import Utilities.ReadConfigFile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pageObjects.LoginPage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class BaseTest
{

    public WebDriver driver;

    ReadConfigFile readconfig = new ReadConfigFile();

    public String URL = readconfig.getAppURL();
    public String username = readconfig.getUsername();
    public String password = readconfig.getPassword();
    public String chromeDriverPath = readconfig.getChromeDriverPath();
    public String screenshotPath = readconfig.getScreenshotPath();

    public static ExtentSparkReporter reporter;
    public static ExtentReports extent;
    public static ExtentTest test;


    @BeforeSuite
    public void setUpSuite(){
        // Created object of ExtentSparkReporter and provided the path for the report
        // Set to run once before the test suite

        reporter = new ExtentSparkReporter("./Reports/AutomationReport " + System.currentTimeMillis() + ".html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    // Initialize driver and open website
    @BeforeMethod
    public void setup() throws IOException {

        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        driver = new ChromeDriver();

        //Move window on second monitor
        driver.manage().window().setPosition(new Point(2000,0));
        driver.manage().window().maximize();
        // Open URL
        driver.get(URL);

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {

        // Screenshot name - current time in milliseconds
        String screenshotName = String.valueOf(System.currentTimeMillis());


        if(result.getStatus()== ITestResult.FAILURE)
        {
            // If test is failed take screenshot
            takeScreenShot(driver,screenshotPath+screenshotName+".jpg");

            // Then add test case name as failed in the report with the screenshot along
            test.fail(result.getName() + "Test Case Failed", MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/"+screenshotPath+screenshotName+".jpg").build());
            test.fail(result.getThrowable());
        }
        else{

            // If test is passed take screenshot
            takeScreenShot(driver,screenshotPath+screenshotName+".jpg");

            // Then add test case name as passed in the report with the screenshot along
            test.pass(result.getName() + "Test Case Passed", MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/"+screenshotPath+screenshotName+".jpg").build());

        }

        //Close browser
        driver.quit();
    }

    @AfterSuite
    public void tearDownSuite(){
        // Flush method is used to write the test in the report
        extent.flush();
    }
    public void navigateToPageAndLogin()
    {
        // Used to login with default credentials
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.loginWith(username, password);
    }

    // Method used to take screenshot
    public static void takeScreenShot(WebDriver driver, String filepath) {
        try {
            TakesScreenshot ts = (TakesScreenshot)driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File(filepath));
        } catch (WebDriverException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}