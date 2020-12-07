package Pages;

import Utilities.DriverClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// I am extending the ParentClass because I have a click sendkeys functionality in the parent class
// I am using in this way because in the parent class functions it is waiting until element is visible or clickable and scrolling to this element
// in this way I am reducing the failures in the automation.
public class HomePage extends ParentClass{




    public HomePage(){

        // Page factory is getting the driver from the driver class and it is sharing the driver with the elements in this class
        // in this way we are able to work with one browser and able to find the elements in the web page
        PageFactory.initElements( DriverClass.getDriver() , this );

    }

    @FindBy(xpath="//a[text()='Log in']")
    private WebElement LoginButtonMenu;

    @FindBy(id="Email")
    private WebElement EmailInput;

    @FindBy(id="Password")
    private WebElement PasswordInput;

    @FindBy(xpath="//input[@value='Log in']")
    private WebElement LogInButton;

    private WebElement WebElementName ;

//    Every time if I want to click on an element in the home page I will call this method this method will call the method in the parent class
//    in the parent class method I am waiting scrolling and clicking on the element.
    public void ClicktoElement(String elementName){

        switch (elementName){
            case "LoginButtonMenu":
                WebElementName = LoginButtonMenu;
                break;

            case  "LogInButton":
                WebElementName = LogInButton;
                break;


        }

//        clickFunction method is in the parent class
        clickFunction(WebElementName);
    }

    @Override
    public void EnterTheDataToElement(String elementName, String value) {

    }

    @Override
    public void dropdownWithSelectClass(String elementName, String value) {

    }

    public void sendkeysToElement(String elementName , String value){

        switch (elementName){
            case "EmailInput":
                WebElementName = EmailInput;
                break;

            case  "PasswordInput":
                WebElementName = PasswordInput;
                break;


        }

//        clickFunction method is in the parent class
        sendKeysFunction(WebElementName , value);

    }



}
