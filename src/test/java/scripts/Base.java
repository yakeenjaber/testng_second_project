package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.UnitedAirlinesFlightPage;
import pages.UnitedAirlinesHomePage;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Base {

    WebDriver driver;
    UnitedAirlinesHomePage unitedAirlinesHomePage;
    UnitedAirlinesFlightPage unitedAirlinesFlightPage;
    WebDriverWait wait;
    Wait fluentWait;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        unitedAirlinesHomePage = new UnitedAirlinesHomePage(driver);
        unitedAirlinesFlightPage = new UnitedAirlinesFlightPage(driver);
        WebDriverWait wait = new WebDriverWait(driver,15);
        Wait fluentWait = new FluentWait(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(2,TimeUnit.SECONDS).ignoring(Exception.class);
    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}