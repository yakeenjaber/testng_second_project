package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UnitedAirlinesHomePage {
    public UnitedAirlinesHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[id^='headerNav']")
    public List<WebElement> mainMenuList;

    @FindBy(id = "travelTab")
    public WebElement bookBT;

    @FindBy(id = "statusTab")
    public WebElement statusBT;

    @FindBy(id = "checkInTab")
    public WebElement checkInBT;

    @FindBy(id = "tripsTab")
    public WebElement myTripsBT;

    @FindBy(xpath = "//*[@id = 'roundtrip']/..")
    public WebElement roundTrip;

    @FindBy(id = "roundtrip")
    public WebElement roundTripSelected;

    @FindBy(id = "oneway")
    public WebElement oneWaySelected;

    @FindBy(xpath = "//*[@id = 'oneway']/..")
    public WebElement oneWay;

    @FindBy(css = "[aria-label = 'Book with miles']")
    public WebElement bookWithMiles;

    @FindBy(css = "[aria-label = 'Book with miles']>input")
    public WebElement bookWithMilesChecked;

    @FindBy(css = "[aria-label = 'Flexible dates']")
    public WebElement flexibleDates;

    @FindBy(css = "[aria-label = 'Flexible dates']>input")
    public WebElement flexibleDatesChecked;


    @FindBy(id = "bookFlightOriginInput")
    public WebElement fromInputBox;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement toInputBox;

    @FindBy(id = "DepartDate")
    public WebElement dateInputBox;

    @FindBy(className = "app-components-BookFlightForm-bookFlightForm__optionField--1kIro")
    public WebElement emptySpace;

    @FindBy
    public WebElement innerIFrame;

   /* @FindBy(id = "stuff")
    public WebElement clickAdults;*/

    @FindBy(css = "[id ='passengerSelector']>button")
    public WebElement clickAdults;

    @FindBy(css = "[aria-label='Substract one Adult']")
    public WebElement numAdults;

    @FindBy(id = "cabinType")
    public WebElement cabinType;

    @FindBy(id = "cabinType_item-2")
    public WebElement cabinTypeBusiness;

    @FindBy(css = "button[aria-label = 'Find flights']")
    public WebElement findFlightsButton;

}
