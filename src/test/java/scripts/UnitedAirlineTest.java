package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiters;

public class UnitedAirlineTest extends Base{

        /*
        Test Case 1: Validate "Main menu" navigation items
        Given user is on "https://www.united.com/en/us"
        Then user should see “Main menu” navigation items
        |BOOK                              |
        |MY TRIPS                          |
        |TRAVEL INFO            |
        |MILEAGEPLUS® PROGRAM|
        |DEALS                             |
        |HELP                              |
         */

    @Test(priority = 1, description = "Validate Main menu navigation items")
    public void testUnitedMainMenu() {
        driver.get("https://www.united.com/en/us");

        String[] mainMenuOptions = {"BOOK","MY TRIPS","TRAVEL INFO","MILEAGEPLUS® PROGRAM","DEALS","HELP"};
        for (int i = 0; i < unitedAirlinesHomePage.mainMenuList.size(); i++) {
            Assert.assertTrue(unitedAirlinesHomePage.mainMenuList.get(i).isDisplayed());
            Assert.assertTrue(unitedAirlinesHomePage.mainMenuList.get(i).isEnabled());
            Assert.assertEquals(unitedAirlinesHomePage.mainMenuList.get(i).getText(), mainMenuOptions[i]);
        }
    }

        /*
        Test Case 2: Validate "Book travel menu" navigation items
        Given user is on "https://www.united.com/en/us"
        Then user should see "Book travel menu" navigation items
        |Book             |
        |Flight Status|
        |Check-in       |
        |My trips        |
        */
    @Test(priority = 2, description = "Validate Book travel menu navigation items")
    public void testBookTravelMenu(){
        driver.get("https://www.united.com/en/us");

        Assert.assertEquals(unitedAirlinesHomePage.bookBT.getText(), "Book");
        Assert.assertTrue(unitedAirlinesHomePage.bookBT.isDisplayed() && unitedAirlinesHomePage.bookBT.isEnabled());

        Assert.assertEquals(unitedAirlinesHomePage.statusBT.getText(), "Flight status");
        Assert.assertTrue(unitedAirlinesHomePage.statusBT.isDisplayed() && unitedAirlinesHomePage.statusBT.isEnabled());

        Assert.assertEquals(unitedAirlinesHomePage.checkInBT.getText(), "Check-in");
        Assert.assertTrue(unitedAirlinesHomePage.checkInBT.isDisplayed() && unitedAirlinesHomePage.checkInBT.isEnabled());

        Assert.assertEquals(unitedAirlinesHomePage.myTripsBT.getText(), "My trips");
        Assert.assertTrue(unitedAirlinesHomePage.myTripsBT.isDisplayed() && unitedAirlinesHomePage.myTripsBT.isEnabled());
    }

        /*
        Test Case 3: Validate "Round-trip" and "One-way" radio buttons
        Given user is on "https://www.united.com/en/us"
        Then validate "Roundtrip" radio button is displayed, is enabled and is selected
        And validate "One-way" radio button is displayed, is enabled but is not selected
        When user clicks on "One-way" radio button
        Then validate "One-way" radio button is selected while "Roundtrip" radio button is
        deselected
        */

    @Test(priority = 3, description = "Validate Round-trip and One-way radio buttons")
    public void testroundTripAndOneWay() {
        driver.get("https://www.united.com/en/us");

        Assert.assertTrue(unitedAirlinesHomePage.roundTrip.isEnabled(), "Element IS NOT enabled");
        Assert.assertTrue(unitedAirlinesHomePage.roundTrip.isDisplayed(), "Element IS NOT displayed");
        Assert.assertTrue(unitedAirlinesHomePage.roundTripSelected.isSelected(), "Element IS NOT selected");

        Assert.assertTrue(unitedAirlinesHomePage.oneWay.isEnabled(), "Element IS NOT enabled");
        Assert.assertTrue(unitedAirlinesHomePage.oneWay.isDisplayed(), "Element IS NOT displayed");
        Assert.assertFalse(unitedAirlinesHomePage.oneWaySelected.isSelected(), "Element IS selected");

        unitedAirlinesHomePage.oneWay.click();
        Assert.assertTrue(unitedAirlinesHomePage.oneWaySelected.isSelected());
        Assert.assertFalse(unitedAirlinesHomePage.roundTrip.isSelected());
    }
        /*
        Test Case 4: Validate "Book with miles" and "Flexible dates" checkboxes
        Given user is on "https://www.united.com/en/us"
        Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
        And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
        When user clicks both checkboxes
        Then validate both checkboxes are selected
        When user clicks on both selected checkboxes again
        Then validate both checkboxes are deselected
        */

   @Test(priority = 4, description = "Validate Book with miles and Flexible dates checkboxes")
   public void testUnitedCheckboxes() {
       //Given user is on "https://www.united.com/en/us"
       //Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
       //And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
       driver.get("https://www.united.com/en/us");
       Assert.assertTrue(unitedAirlinesHomePage.bookWithMiles.isEnabled());
       Assert.assertTrue(unitedAirlinesHomePage.bookWithMiles.isDisplayed());
       Assert.assertFalse(unitedAirlinesHomePage.bookWithMilesChecked.isSelected());
       Assert.assertTrue(unitedAirlinesHomePage.flexibleDates.isEnabled());
       Assert.assertTrue(unitedAirlinesHomePage.flexibleDates.isDisplayed());
       Assert.assertFalse(unitedAirlinesHomePage.flexibleDatesChecked.isSelected());

       //When user clicks both checkboxes
       //Then validate both checkboxes are selected
       unitedAirlinesHomePage.bookWithMiles.click();
       unitedAirlinesHomePage.flexibleDates.click();
       Assert.assertTrue(unitedAirlinesHomePage.bookWithMilesChecked.isSelected());
       Assert.assertTrue(unitedAirlinesHomePage.flexibleDatesChecked.isSelected());

       //When user clicks on both selected checkboxes again
       //Then validate both checkboxes are deselected
       unitedAirlinesHomePage.bookWithMiles.click();
       unitedAirlinesHomePage.flexibleDates.click();
       Assert.assertFalse(unitedAirlinesHomePage.bookWithMilesChecked.isSelected());
       Assert.assertFalse(unitedAirlinesHomePage.flexibleDatesChecked.isSelected());
   }
        /*
        Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to
        Miami, FL, US (MIA)”
        Given user is on "https://www.united.com/en/us"
        When user selects "One-way" ticket radio button
        And user enters "Chicago, IL, US (ORD)" to from input box
        And user enters "Miami, FL, US (MIA)" to to input box
        And user selects "Jan 30" to the dates input box
        And user selects "2 Adults" from travelers selector
        And user selects "Business or First" from cabin dropdown
        And user clicks on "Find Flights" button
        Then validate departure equals to "Depart: Chicago, IL, US to Miami, FL, US
        */

    @Test(priority = 5,description = "Validate One-way ticket search results")
    public void testFlights(){
        driver.get("https://www.united.com/en/us");
        unitedAirlinesHomePage.oneWay.click();
        unitedAirlinesHomePage.fromInputBox.clear();
        unitedAirlinesHomePage.fromInputBox.sendKeys("Chicago, IL, US (ORD)");

        Waiters.pause(2);
        unitedAirlinesHomePage.toInputBox.click();
        unitedAirlinesHomePage.toInputBox.clear();
        unitedAirlinesHomePage.toInputBox.sendKeys("Miami, FL, US (MIA)");

        unitedAirlinesHomePage.dateInputBox.click();
        unitedAirlinesHomePage.dateInputBox.clear();
        unitedAirlinesHomePage.dateInputBox.sendKeys("Jan 30");

        unitedAirlinesHomePage.clickAdults.click();
        unitedAirlinesHomePage.numAdults.click();

        unitedAirlinesHomePage.cabinType.click();
        unitedAirlinesHomePage.cabinTypeBusiness.click();
        unitedAirlinesHomePage.findFlightsButton.click();
        Assert.assertEquals(unitedAirlinesFlightPage.departHeading.getText(), "Depart: Chicago, IL, US to Miami, FL, US");

        }
    }

