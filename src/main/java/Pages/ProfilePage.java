package Pages;

import Utilities.DriverClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePage extends ParentClass{

    public ProfilePage(){

        // Page factory is getting the driver from the driver class and it is sharing the driver with the elements in this class
        // in this way we are able to work with one browser and able to find the elements in the web page
        PageFactory.initElements( DriverClass.getDriver() , this );
    }


    @FindBy(xpath = " //a[text()='Addresses']")
    private WebElement Addresses;

    @FindBy(xpath = "//input[@value='Add new']")
    private WebElement AddNewButton;

    @FindBy(id = "Address_FirstName")
    private WebElement FirstNameInput;

    @FindBy(id = "Address_LastName")
    private WebElement LastNameInput;

    @FindBy(id = "Address_Email")
    private WebElement EmailInput;

    @FindBy(id = "Address_City")
    private WebElement CityInput;

    @FindBy(id = "Address_Address1")
    private WebElement Address1Input;

    @FindBy(id = "Address_ZipPostalCode")
    private WebElement ZipCodeInput;

    @FindBy(id = "Address_PhoneNumber")
    private WebElement PhoneNumberInput;

    @FindBy(id = "Address_CountryId")
    private WebElement CountryDropdown;

    @FindBy(id = "Address_StateProvinceId")
    private WebElement StateDropdown;

    @FindBy(xpath = "//input[@value='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@class='section address-item']//strong")
    private List<WebElement> nameList;

    @FindBy(xpath = "//input[@value='Delete']")
    private List<WebElement> DeleteList;






    private WebElement elementToClick;


    @Override
    public void ClicktoElement(String elementName) {

        switch (elementName){
            case "Addresses":
                elementToClick = Addresses;
                break;

            case "AddNewButton":
                elementToClick = AddNewButton;
                break;

            case "saveButton":
                elementToClick = saveButton;
                break;

        }

        clickFunction(elementToClick);
    }


    @Override
    public void EnterTheDataToElement(String elementName, String value) {

        switch (elementName) {
            case "FirstNameInput":
                elementToClick = FirstNameInput;
                break;

            case "LastNameInput":
                elementToClick = LastNameInput;
                break;

            case "EmailInput":
                elementToClick = EmailInput;
                break;

            case "CityInput":
                elementToClick = CityInput;
                break;

            case "Address1Input":
                elementToClick = Address1Input;
                break;
            case "ZipCodeInput":
                elementToClick = ZipCodeInput;
                break;

            case "PhoneNumberInput":
                elementToClick = PhoneNumberInput;
                break;

        }

        sendKeysFunction(elementToClick , value);
    }

    public void dropdownWithSelectClass(String elementName , String value){

        switch (elementName) {
            case "CountryDropdown":
                elementToClick = CountryDropdown;
                break;
            case "StateDropdown":
                elementToClick = StateDropdown;
                break;

        }

        handleDropdown(elementToClick,value);
    }

//    In the my profile > addresses > we have list of address
//    If my address is in the second or third position then I am going to click on that delete button specific
    public void ClickOnTheSpecificDeleteButton(String expectedName){


        for(int i = 0 ; i < nameList.size() ; i++){

            if(nameList.get(i).getText().equals(expectedName)){

                DeleteList.get(i).click();

                WebDriver driver = DriverClass.getDriver();
                driver.switchTo().alert().accept();

            }

        }


    }

}
