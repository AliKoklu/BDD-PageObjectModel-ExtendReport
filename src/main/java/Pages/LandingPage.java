package Pages;

import Utilities.DriverClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage  extends ParentClass{



    public LandingPage(){

        // Page factory is getting the driver from the driver class and it is sharing the driver with the elements in this class
        // in this way we are able to work with one browser and able to find the elements in the web page
        PageFactory.initElements( DriverClass.getDriver() , this );

    }

    @FindBy(xpath = "//ul[@class='top-menu']//a[contains(text(),'Computers')]")
    private WebElement computersMenuButton;

    @FindBy(xpath = "//h2//a[@title='Show products in category Desktops']")
    private WebElement desktopsUnderComputer;

    @FindBy(xpath = "//ul[@class='top-menu']//a[contains(text(),'Apparel & Shoes')]")
    private WebElement ApparelAndShoes;

    @FindBy(xpath = "  //a[text()='My account']")
    private WebElement myAccount;




    private WebElement elementToClick;

    @Override
    public void ClicktoElement(String elementName) {

        switch (elementName){
            case "computersMenuButton":
                elementToClick = computersMenuButton;
            break;
            case "desktopsUnderComputer":
                elementToClick = desktopsUnderComputer;
                break;
            case "ApparelAndShoes":
                elementToClick = ApparelAndShoes;
                break;

            case "myAccount":
                elementToClick = myAccount;
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
