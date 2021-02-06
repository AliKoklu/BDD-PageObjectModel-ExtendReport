package Runners;


import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;

import java.io.File;

@CucumberOptions(

//        With a plugin we are able to create multiple types of reports.
        plugin = {
                "html:target/cucumber-report",
                "json:target/cucumber.json",
                "com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/RegressionReport.html" // to generate a extend report we need this plugin
        },

        tags = {"@Regression2"},
        features = {"src/test/java/Features"},
        glue = {"StepDefinition"},
        dryRun = false

)

public class RegressionRunner extends AbstractTestNGCucumberTests {

    //        After runner is done this after method will run and put username application name information in the report. After execution done Open the target > ExtentReport >RegressionReport
    @AfterClass
    public static void afterClass(){

//                Location of the xml file
        Reporter.loadXMLConfig(new File("src/test/java/Features/extendReports.xml"));
        Reporter.setSystemInfo("User Name" , "Ali Koklu");
        Reporter.setSystemInfo("Application Name", "Basqar");
        Reporter.setSystemInfo("Operating System Type" , System.getProperty("os.name"));
        Reporter.setSystemInfo("Environment", "QA");
        Reporter.setTestRunnerOutput("Test execution Cucumber report");
    }
}

