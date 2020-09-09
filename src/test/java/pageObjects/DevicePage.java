package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class DevicePage extends BasePage
{
    // Default constructor - super method calls the constructor from the parent class
    public DevicePage(WebDriver driver)
    {
        super(driver);
    }

    //Elements from Device page

    @FindBy(how= How.XPATH, using = "//a[text()='Dashboard']")
    public WebElement DashboardNavBtn;

    @FindBy(how= How.XPATH, using = "//a[text()='Protection']")
    public WebElement ProtectionNavBtn;

    @FindBy(how= How.XPATH, using = "//a[text()='Anti-Theft']")
    public WebElement AntiTheftNavBtn;

    @FindBy(how= How.XPATH, using ="//h3[@class=\"card-title ng-binding\"]/parent::div[@class=\"card-details\"]")
    public WebElement OverviewHeader;

    @FindBy(how= How.ID, using = "startScan")
    public WebElement StartScanBtn;

    //@FindBy(how= How.XPATH, using = "//*[@id=\"antitheft-action-cards\"]")
    //public WebElement AntiTheftMenu;

    @FindBy(how= How.XPATH, using = "//button[contains(., 'Alert')]")
    public WebElement AlertBtn;

}

