package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFile {

    Properties prop;

    File src = new File("./Utilities/config.properties");

    //Read from config.properties
    public ReadConfigFile() {
        try {
            FileInputStream fis = new FileInputStream(src);
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is: " + e.getMessage());
        }
    }

    //Return URL value from config.properties
    public String getAppURL() {
        return prop.getProperty("URL");
    }

    //Return username value from config.properties
    public String getUsername() {
        return prop.getProperty("usernameTxt");
    }

    //Return password value from config.properties
    public String getPassword() {
        return prop.getProperty("passwordTxt");
    }

    //Return Chrome driver path value from config.properties
    public String getChromeDriverPath() {
        return prop.getProperty("chromepath");
    }
    public String getScreenshotPath() {
        return prop.getProperty("screenshotpath");
    }
}