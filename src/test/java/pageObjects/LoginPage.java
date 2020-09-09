package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage
{
    // Default constructor - super method calls the constructor from the parent class
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    //Elements from Login page
    @FindBy(how= How.CSS, using ="input[id='username']")
    WebElement UsernameTxt;

    @FindBy(how= How.CSS, using ="button[id='login-next']")
    WebElement NextBtn;

    @FindBy(how= How.CSS, using ="input[id='password_input']")
    WebElement PasswordTxt;

    @FindBy(how= How.CSS, using ="button[id='password-sign-in']")
    WebElement SignInBtn;

    @FindBy(how= How.XPATH, using ="//span[text()='Wrong password. Try again.']")
    public WebElement WrongPassword;


    // Method that populates username and password fields and clicks Sign In
    public void loginWith(String username,String password)
    {
        // Wait for Username Text field before populating and click Next
        waitForElement(UsernameTxt,10);
        UsernameTxt.sendKeys(username);
        NextBtn.click();

        // Wait for Password Text field before populating and click Sign In
        waitForElement(PasswordTxt,10);
        PasswordTxt.sendKeys(password);
        SignInBtn.click();

    }


}
