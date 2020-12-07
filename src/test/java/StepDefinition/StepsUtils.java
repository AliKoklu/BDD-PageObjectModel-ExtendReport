package StepDefinition;

import Pages.*;
import Utilities.DriverClass;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.xml.crypto.Data;
import java.util.List;

public class StepsUtils {

    ParentClass parentClass ;

    @Given("^Click on an element in the \"([^\"]*)\"$")
    public void click_on_an_element_in_the(String pageName, DataTable allElements) throws Throwable {

        /*
            I am using this if statement because I dont want to create an step definition for each page
           with one step definition I am able to handle all the click functionality.
         */
        if(pageName.equals("LandingPage")){
            parentClass = new LandingPage();
        }else if(pageName.equals("CheckoutPage")){
            parentClass = new CheckoutPage();
        }else if(pageName.equals("HomePage")){
            parentClass = new HomePage();
        }else if(pageName.equals("ItemsPage")){
            parentClass = new ItemsPage();
        }else if(pageName.equals("ProfilePage")){
            parentClass = new ProfilePage();
        }


        List<String> eachElement = allElements.asList(String.class);

        for(int i = 0 ; i<eachElement.size() ; i++){

            parentClass.ClicktoElement( eachElement.get(i));

        }
    }

    @And("^Enter the value in the element in the \"([^\"]*)\"$")
    public void enter_the_value_in_the_element_in_the(String pageName, DataTable allElements) throws Throwable {

         /*
            I am using this if statement because I dont want to create an step definition for each page
           with one step definition I am able to handle all the click functionality.
         */
        if(pageName.equals("LandingPage")){
            parentClass = new LandingPage();
        }else if(pageName.equals("CheckoutPage")){
            parentClass = new CheckoutPage();
        }else if(pageName.equals("HomePage")){
            parentClass = new HomePage();
        }else if(pageName.equals("ItemsPage")){
            parentClass = new ItemsPage();
        }else if(pageName.equals("ProfilePage")){
            parentClass = new ProfilePage();
        }

        List<List<String>> eachElement = allElements.asLists(String.class);

        for(int i = 0 ; i<eachElement.size() ; i++){

            parentClass.EnterTheDataToElement( eachElement.get(i).get(0) , eachElement.get(i).get(1));

        }
    }


//    With this step I can handle any dropdown in the website I need to mention element name and which value I need to choose in the feature file
    @And("^Select dropdown and value in the dropdown in the \"([^\"]*)\"$")
    public void select_dropdown_and_value_in_the_dropdown_in_the(String pageName, DataTable allElements) throws Throwable {

          /*
            I am using this if statement because I dont want to create an step definition for each page
           with one step definition I am able to handle all the click functionality.
         */
        if(pageName.equals("LandingPage")){
            parentClass = new LandingPage();
        }else if(pageName.equals("CheckoutPage")){
            parentClass = new CheckoutPage();
        }else if(pageName.equals("HomePage")){
            parentClass = new HomePage();
        }else if(pageName.equals("ItemsPage")){
            parentClass = new ItemsPage();
        }else if(pageName.equals("ProfilePage")){
            parentClass = new ProfilePage();
        }

        List<List<String>> eachElement = allElements.asLists(String.class);

        for(int i = 0 ; i<eachElement.size() ; i++){

            parentClass.dropdownWithSelectClass( eachElement.get(i).get(0) , eachElement.get(i).get(1));

        }

    }
    private WebDriver driver;


//     With  this step I am able to check any text in the website is it displayed or not in the current page.
    @Then("^Verify \"([^\"]*)\" text is displayed$")
    public void verifyTextIsDisplayed(String expectedText) throws Throwable {

        parentClass=  new HomePage();

        char quotes='"';

        String as= quotes + expectedText + quotes;

        By by = By.xpath("//*[contains(text(),"+as+")]");

        driver= DriverClass.getDriver();

        parentClass.waitUntilVisibilityWithBy(by);

        WebElement element = driver.findElement(by);

        element.isDisplayed();
    }


    @And("^Click on the \"([^\"]*)\" element delete button$")
    public void clickOnTheElementDeleteButton(String addressName) throws Throwable {
        ProfilePage profilePage = new ProfilePage();

        profilePage.ClickOnTheSpecificDeleteButton(addressName);
    }
}
