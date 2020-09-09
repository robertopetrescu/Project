package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage
{

    WebDriver _driver;

    @FindBy(how= How.XPATH, using ="//div[contains(@class, 'modal-content') and contains(.//h2, 'Welcome')]")
    public WebElement WelcomeModal;

    // Default constructor, set local driver = remote driver
    public BasePage(WebDriver driver) {
        _driver = driver;
    }

    // Explicit wait, wait a certain amount of time for the element
    // If element is found before, then click it
    public void waitForElement(WebElement element, int timeout)
    {
        WebDriverWait wait = new WebDriverWait(_driver,timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Click method that waits for an element before clicking
    public void clickElement(WebElement element) {
        waitForElement(element,10);
        element.click();
    }

}


