package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnitedAirlinesFlightPage {
     public UnitedAirlinesFlightPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        @FindBy(className = "app-components-Shopping-TripInfo-styles__tripOriginDestinationHeader--RcPyp")
        public WebElement departHeading;

    }
