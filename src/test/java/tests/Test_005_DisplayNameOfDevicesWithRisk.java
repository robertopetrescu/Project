package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.MyDevicesPage;

public class Test_005_DisplayNameOfDevicesWithRisk extends BaseTest{

    @Test
    public void displayNameOfDevicesWithRisk() throws InterruptedException {
        //Add test to report
        test = extent.createTest("Display name of devices with Risk");
        //Open default URL and login
        navigateToPageAndLogin();

        HomePage homePage = PageFactory.initElements(driver,HomePage.class);

        //Click on 'Continue my Trial' then on 'My Devices'
        homePage.continueMyTrial();
        homePage.clickDevices();
        Thread.sleep(2000);

        //Write to console devices with risks
        MyDevicesPage myDevices = PageFactory.initElements(driver, MyDevicesPage.class);
        myDevices.displayDeviceWithRiskStatus();

    }
}
