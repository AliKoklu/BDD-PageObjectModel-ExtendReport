package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverClass {

    private static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver==null){
            if(ReadPropery.init_properties("browserName").equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }else if(ReadPropery.init_properties("browserName").equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver=null;
        }
    }

}
