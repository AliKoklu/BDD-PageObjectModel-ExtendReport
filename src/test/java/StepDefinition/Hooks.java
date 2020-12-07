package StepDefinition;

import Pages.HomePage;
import Utilities.DriverClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    private WebDriver driver;

    HomePage homePage = new HomePage();

    public Hooks() {
        driver = DriverClass.getDriver();
    }


    @Before
    public void beforeClass() {

        driver.get("http://demowebshop.tricentis.com/");

        driver.manage().window().maximize();

        homePage.ClicktoElement("LoginButtonMenu");

        homePage.sendkeysToElement("EmailInput", "asd1223@gmail.com");
        homePage.sendkeysToElement("PasswordInput", "asd1223");

        homePage.ClicktoElement("LogInButton");

    }

    @After
    public void after(Scenario scenario) {

        if (scenario.getStatus().equalsIgnoreCase("failed")) {

//        Take Screen shot is coming from the selenium.
            TakesScreenshot Screenshot = ((TakesScreenshot) DriverClass.getDriver()); // which driver to get a screen shot

//        File is coming from JAVA
            File srcFile = Screenshot.getScreenshotAs(OutputType.FILE);

            String featureFileName = scenario.getName();

//        Adding the today date and time to our screen shot name
            Date now = new Date();

            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH mm ss");

            String dateInString = formater.format(now);

            dateInString = dateInString.replace(":", " ");

//        Location of the screenshot.
            File destinationFile = new File("target/FailedScreenShots/" + featureFileName + dateInString + ".png");

            try {
                FileUtils.copyFile(srcFile, destinationFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        DriverClass.quitDriver();

        System.out.println("This is the after class");
    }

}
