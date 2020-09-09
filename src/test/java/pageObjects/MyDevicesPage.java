package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MyDevicesPage extends BasePage
{
    // Default constructor - super method calls the constructor from the parent class
    public MyDevicesPage(WebDriver driver)
    {
        super(driver);
    }

    //Elements from My Devices page
    @FindBy(how= How.CSS, using ="div[ng-click='toDevice(device.device_crc);")
    List<WebElement> UnprotectedDevices;

    // Iterate through the list of devices and print the ones that don't contain 'Protected'
    public void displayDeviceWithRiskStatus()
    {
        for (WebElement device : UnprotectedDevices)
        {
            if(!device.getText().contains("Protected"))
                System.out.println(device.getText());
        }
    }

    //Navigate to specific device
    public void navigateTo(int deviceNumber) throws InterruptedException {
        Thread.sleep(2000);
        clickElement(UnprotectedDevices.get(deviceNumber));
    }

}
