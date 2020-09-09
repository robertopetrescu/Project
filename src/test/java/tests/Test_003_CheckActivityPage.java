package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class Test_003_CheckActivityPage extends BaseTest
{

    @Test
    public void checkActivityPage() throws InterruptedException {
        //Add test to report
        test = extent.createTest("Check Activity Page");
        //Open default URL and login
        navigateToPageAndLogin();

        //Create Homepage object and click on 'Continue my Trial'
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        homePage.continueMyTrial();

        //Check Activity tab is present and opened
        homePage.waitForElement(homePage.ActivityTab,10);
        Assert.assertEquals(homePage.ActivityTab.getText(),"Activity");

    }
}
