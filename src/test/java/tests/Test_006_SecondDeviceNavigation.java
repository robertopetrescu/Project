package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DevicePage;
import pageObjects.HomePage;
import pageObjects.MyDevicesPage;

import java.io.IOException;

public class Test_006_SecondDeviceNavigation extends BaseTest {

    @Test
    public void secondDeviceNavigation() throws InterruptedException, IOException {
        //Add test to report
        test = extent.createTest("Navigation to second device tabs");
        //Open default URL and login
        navigateToPageAndLogin();

        //Create HomePage object
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);

        //Click on 'Continue my Trial' then on 'My Devices'
        homePage.continueMyTrial();
        homePage.clickDevices();

        // Click on the second device
        MyDevicesPage myDevices = PageFactory.initElements(driver, MyDevicesPage.class);
        myDevices.navigateTo(1);

        DevicePage myDevice = PageFactory.initElements(driver,DevicePage.class);

        // Switch to Protection tab and check Start Scan Button is present
        myDevices.clickElement(myDevice.ProtectionNavBtn);
        myDevice.waitForElement(myDevice.StartScanBtn,10);
        Assert.assertTrue(myDevice.StartScanBtn.isDisplayed());

        // Switch to AntiTheft tab and check Alert Button is present
        myDevices.clickElement(myDevice.AntiTheftNavBtn);
        myDevice.waitForElement(myDevice.AlertBtn,10);
        Assert.assertTrue(myDevice.AlertBtn.isDisplayed());

        // Switch to DashBoard tab and check Overview Text field
        myDevices.clickElement(myDevice.DashboardNavBtn);
        myDevice.waitForElement(myDevice.OverviewHeader,10);
        Assert.assertTrue(myDevice.OverviewHeader.isDisplayed());

    }
}
