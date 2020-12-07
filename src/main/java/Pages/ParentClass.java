package Pages;

import Utilities.DriverClass;
import cucumber.api.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

/*
    This class is an abstract because in the steps utils class I would like to create one step definition and handle all the click functionality
    in the page classes.

    Check the last methods in this class those are abstract methods all the child should override these methods.

 */
public abstract class  ParentClass {


    private WebDriver driver;
    WebDriverWait wait;

    public ParentClass(){

        driver= DriverClass.getDriver();
        wait = new WebDriverWait(driver,10);

    }

    public void clickFunction(WebElement elementToClick){
        waitUntilClickable(elementToClick);
        System.out.println(elementToClick.getText());
        scrollToElement(elementToClick);
        elementToClick.click();
    }

    public void sendKeysFunction(WebElement sendKeyElement , String value){
        waitUntilVisibility(sendKeyElement);
        scrollToElement(sendKeyElement);
        sendKeyElement.clear();
        sendKeyElement.sendKeys(value);
    }

    public void handleDropdown(WebElement element,String valueToChoose){
        waitUntilVisibility(element);
        scrollToElement(element);
        Select select = new Select(element);
        select.selectByVisibleText(valueToChoose);
    }

    public void waitUntilVisibility(WebElement element){

        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void waitUntilVisibilityWithBy(By element){

        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    }

    public void waitUntilClickable(WebElement element){

        wait.until(ExpectedConditions.elementToBeClickable(element));

    }


    public void verifyElementContainsText(WebElement element , String text){

        waitUntilVisibility(element);
        Assert.assertTrue(element.getText().contains(text) , "element text is " + element.getText());

    }

    public void clickOnButtonAccordingToName(List<WebElement> listname , List<WebElement> Button , String expectedName){

        System.out.println(listname + "<<<<<<<<<<<<<<<<<---------------");

        for(int i = 0 ; i <listname.size() ; i++){

            System.out.println(listname.get(i).getText()+ " in the for loop ");
            if(listname.get(i).getText().equals(expectedName)){
                Button.get(i).click();
                break;
            }

        }

    }

    public void scrollToElement(WebElement elementToScroll){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", elementToScroll);
    }

    public void clickOnElementFromTheList(List<WebElement> listOfElements , String text){

        for (WebElement eachElement : listOfElements){

            if(eachElement.getText().equalsIgnoreCase(text)){

                eachElement.click();
                break;

            }
        }

    }

    public void scrollToLastElement(WebElement Element){

        JavascriptExecutor js = (JavascriptExecutor) driver;


        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }


    public abstract void ClicktoElement(String elementName);

    public abstract void EnterTheDataToElement(String elementName , String value);

    public abstract void dropdownWithSelectClass(String elementName , String value);

}
