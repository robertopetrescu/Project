package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class Test_004_NavigateToMyDevices extends BaseTest
{

    @Test
    public void navigateToMyDevices() throws InterruptedException {
        //Add test to report
        test = extent.createTest("Navigate to my devices");
        //Open default URL and login
        navigateToPageAndLogin();

        HomePage homePage = PageFactory.initElements(driver,HomePage.class);

        //Click on 'Continue my Trial' then on 'My Devices'
        homePage.continueMyTrial();
        homePage.clickDevices();

        //Check InstallProtectionBtn is present
        homePage.waitForElement(homePage.InstallProtectionBtn,15);
        Assert.assertTrue(homePage.InstallProtectionBtn.isDisplayed());

    }
}
