package Pages;

import Utilities.DriverClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemsPage extends ParentClass{



    public ItemsPage(){

        // Page factory is getting the driver from the driver class and it is sharing the driver with the elements in this class
        // in this way we are able to work with one browser and able to find the elements in the web page
        PageFactory.initElements( DriverClass.getDriver() , this );
    }

    @FindBy(xpath = "//h2//a[text()='Build your own expensive computer']")
    private WebElement ownExpensiveComputerItem;

    @FindBy(xpath = " //label[text()='Slow ']")
    private WebElement slowRadioButton;

    @FindBy(xpath = "//label[contains(text(),'Medium')]")
    private WebElement mediumRadioButton;

    @FindBy(xpath = "//label[contains(text(),'Fast')]")
    private WebElement fastRadioButton;

    @FindBy(xpath = "//label[contains(text(),'2 GB')]")
    private WebElement GB2;

    @FindBy(xpath = "//label[contains(text(),'4GB')]")
    private WebElement GB4;

    @FindBy(xpath = "//label[contains(text(),'320 GB')]")
    private WebElement GB320;

    @FindBy(xpath = "//label[contains(text(),'400 GB')]")
    private WebElement GB400;

    @FindBy(xpath = "//label[contains(text(),'Image Viewer')]")
    private WebElement ImageViewer;

    @FindBy(xpath = "//label[contains(text(),'Office Suite')]")
    private WebElement OfficeSuite;

    @FindBy(xpath = "//label[contains(text(),'Other Office Suite')]")
    private WebElement OtherOfficeSuite;



    @FindBy(xpath = "//span[@title='Close']")
    private WebElement closeMessage;

//    items are under the apparel and shoes

    @FindBy(xpath = "//a[text()='Blue and green Sneaker']")
    private WebElement BlueAndGreenSneakers;




    @FindBy(xpath = "//input[contains(@id,'add-to-cart-button')]")
    private WebElement addToCart;

    @FindBy(xpath = "//input[contains(@id,'add-to-wishlist-button')]")
    private WebElement addtowishList;

    @FindBy(xpath = "//span[contains(text(),'Wishlist')]")
    private WebElement wishListButton;

    @FindBy(xpath = "//li[@id='topcartlink']//a")
    private WebElement shoppingCart;


    private WebElement elementToClick;

    @Override
    public void ClicktoElement(String elementName) {

        switch (elementName){
            case "ownExpensiveComputerItem":
                elementToClick = ownExpensiveComputerItem;
                break;

            case "slowRadioButton":
                elementToClick = slowRadioButton;
                break;

            case "mediumRadioButton":
                elementToClick = mediumRadioButton;
                break;

            case "fastRadioButton":
                elementToClick = fastRadioButton;
                break;

            case "GB2":
                elementToClick = GB2;
                break;

            case "GB4":
                elementToClick = GB4;
                break;

            case "GB320":
                elementToClick = GB320;
                break;

            case "GB400":
                elementToClick = GB400;
                break;

            case "ImageViewer":
                elementToClick = ImageViewer;
                break;

            case "OfficeSuite":
                elementToClick = OfficeSuite;
                break;

            case "OtherOfficeSuite":
                elementToClick = OtherOfficeSuite;
                break;

            case "addToCart":
                elementToClick = addToCart;
                break;

            case "shoppingCart":
                elementToClick = shoppingCart;
                break;

            case "closeMessage":
                elementToClick = closeMessage;
                break;

            case "BlueAndGreenSneakers":
                elementToClick = BlueAndGreenSneakers;
                break;

            case "addtowishList":
                elementToClick = addtowishList;
                break;

            case "wishListButton":
                elementToClick = wishListButton;
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
