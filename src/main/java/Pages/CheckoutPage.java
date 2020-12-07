package Pages;

import Utilities.DriverClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends ParentClass{



    public CheckoutPage(){

        // Page factory is getting the driver from the driver class and it is sharing the driver with the elements in this class
        // in this way we are able to work with one browser and able to find the elements in the web page
        PageFactory.initElements( DriverClass.getDriver() , this );

    }

    @FindBy(id = "checkout")
    private WebElement checkoutButton;


    @FindBy(id = "termsofservice")
    private WebElement termsofservice;

    @FindBy(xpath = "//li[contains(@class,'active')]//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@value='Confirm']")
    private WebElement confirmButton;


    @FindBy(xpath = "//input[@name='removefromcart']")
    private WebElement removeButton;

    @FindBy(xpath = "//input[@name='updatecart']")
    private WebElement updateCartButton;


    private WebElement elementToClick;
    @Override
    public void ClicktoElement(String elementName) {


        switch (elementName) {
            case "checkoutButton":
                elementToClick = checkoutButton;
                break;

            case "termsofservice":
                elementToClick = termsofservice;
                break;

            case "continueButton":
                elementToClick = continueButton;
                break;

            case "confirmButton":
                elementToClick = confirmButton;
                break;

            case "removeButton":
                elementToClick = removeButton;
                break;

            case "updateCartButton":
                elementToClick = updateCartButton;
                break;




        }

        clickFunction(elementToClick);
    }

    @Override
    public void EnterTheDataToElement(String elementName, String value) {

    }

    @Override
    public void dropdownWithSelectClass(String elementName, String value) {

    }
}
