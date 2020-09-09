package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class Test_001_LoginFunctionality extends BaseTest
{

    @Test
    public void loginWithValidCredentials()
    {
        //Add test to report
        test = extent.createTest("Login with valid credentials");

        //Create LoginPage object
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);

        //Call method to login
        loginPage.loginWith(username, password);

        //Check WelcomeModal if it contains the correct message
        //Wait for the modal to load and after that split by comma
        //The first string should contain 'Welcome' followed by the current user account email
        loginPage.waitForElement(loginPage.WelcomeModal,20);
        Assert.assertEquals(loginPage.WelcomeModal.getText().split(",")[0],"Welcome " + username);

    }

    @Test
    public void loginWithInValidCredentials()
    {
        //Add test to report
        test = extent.createTest("Login with InValid credentials");

        //Create LoginPage object
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);

        //Call method to login with invalid credentials
        loginPage.loginWith(username, password+"1");

        //Check wrong error message is displayed
        loginPage.waitForElement(loginPage.WrongPassword,20);
        Assert.assertTrue(loginPage.WrongPassword.isDisplayed());

    }
}
