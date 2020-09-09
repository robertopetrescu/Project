package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class Test_002_ContinueMyTrial extends BaseTest
{

    @Test
    public void continueMyTrial() throws InterruptedException {
        //Add test to report
        test = extent.createTest("Click on continue trial");

        //Open default URL and login
        navigateToPageAndLogin();

        // Create Homepage object and click on 'Continue My Trial'
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        homePage.continueMyTrial();

    }
}
