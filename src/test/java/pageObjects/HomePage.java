package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage
{
    // Default constructor - super method calls the constructor from the parent class
    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    //Elements from Home page
    @FindBy(how= How.XPATH, using ="//button[text()='Continue my trial']")
    WebElement ContinueTrialBtn;

    @FindBy(how= How.XPATH, using ="//span[text()='My Devices']")
    WebElement MyDevices;

    @FindBy(how= How.CSS, using ="a[class='flex-list-item selected']")
    public WebElement ActivityTab;

    @FindBy(how= How.XPATH, using ="//button[text()='INSTALL PROTECTION']")
    public WebElement InstallProtectionBtn;

    // Function that clicks on the 'Continue my Trial'
    public void continueMyTrial() throws InterruptedException {
        waitForElement(ContinueTrialBtn,10);
        Thread.sleep(1500);
        ContinueTrialBtn.click();

    }

    // Method that clicks on 'My Devices' tab
    public void clickDevices()
    {
        clickElement(MyDevices);
    }
}
