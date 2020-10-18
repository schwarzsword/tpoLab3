package lab3.test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lab3.config.chrome.ChromeConfig;
import lab3.pages.MainPage;
import lab3.pages.ThreeDaysPage;
import lab3.steps.MainSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tests {
    private WebDriver driver;
    private MainSteps mainSteps;
    private MainPage mainPage;

    @BeforeEach
    public void prepare() {
        driver = ChromeConfig.ChromeDriver();
        mainSteps = new MainSteps(driver);
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Find invalid city")
    @Description("Check check if system can find desired invalid city")
    @Feature("Invalid city search autocomplete")
    @Story("Autocomplete")
    public void unexistingCityAutocompleteTest() {
        mainSteps
                .openMain()
                .typeCity("Ухрюпинск")
                .submitSearch();
        List<WebElement> results = mainPage.root.findElements(By.xpath(MainPage.XPATH_FOUND_ELEMENTS_TEXT));
        Assertions.assertEquals(0, results.size());
    }

    @Test
    @DisplayName("Find valid city")
    @Description("Check check if system can find desired valid city")
    @Feature("Valid city search autocomplete")
    @Story("Autocomplete")
    public void existingCityAutocompleteTest() {
        mainSteps
                .openMain()
                .typeCity("Оренбург")
                .submitSearch();
        List<WebElement> results = mainPage.root.findElements(By.xpath(MainPage.XPATH_FOUND_ELEMENTS_TEXT));
        Assertions.assertEquals("Оренбург", results.get(0).getText());
    }

    @Test
    @DisplayName("Navigate city")
    @Description("Navigate to the city page")
    @Feature("City search navigation")
    @Story("Search and navigation")
    public void existingCityNavigationTest() {
        mainSteps
                .openMain()
                .typeCity("Оренбург")
                .submitSearch()
                .navigateCity();
        Assertions.assertTrue(driver.getCurrentUrl().contains("orenburg"));
    }

    @Test
    @DisplayName("Check temperature today")
    @Description("Check if temperature is shown on today tab")
    @Feature("Today tab")
    @Story("Show weather")
    public void checkTodayTemperature() {
        mainSteps
                .openMain();
        String temperatureStr = mainPage.todayTemperature.getText().replaceAll(",", ".");
        double v = Double.parseDouble(temperatureStr);
        Assertions.assertTrue(v < 100 && v > -100);
    }

    @Test
    @DisplayName("Check wind today")
    @Description("Check if wind is shown on today tab")
    @Feature("Today tab")
    @Story("Show weather")
    public void checkTodayWind() {
        mainSteps
                .openMain();
        String windStr = mainPage.todayWind.getText();
        Assertions.assertTrue(windStr.matches("\\d+ м/с, Ю|С|В|З|СВ|СЗ|ЮВ|ЮЗ|"));
    }


    @Test
    @DisplayName("Check temperature in 3 days")
    @Description("Check if valid temperature tabs count is shown on 3 days tab")
    @Feature("3 days tab")
    @Story("Show weather")
    public void check3DaysTemperatureCount() {
        ThreeDaysPage threeDaysPage = mainSteps
                .openMain()
                .navigate3days();
        Assertions.assertEquals(12, threeDaysPage.temperatureTabs.size());
    }

    @Test
    @DisplayName("Check temperature in 3 days")
    @Description("Check if valid temperature is shown on 3 days tab")
    @Feature("3 days tab")
    @Story("Show weather")
    public void check3DaysTemperatureValue() {
        ThreeDaysPage threeDaysPage = mainSteps
                .openMain()
                .navigate3days();
        String temperatureStr = threeDaysPage.temperatureTabs.get(0).getText();
        double v = Double.parseDouble(temperatureStr);
        Assertions.assertTrue(v < 100 && v > -100);
    }

    @Test
    @DisplayName("Check temperature in 3 days")
    @Description("Check if valid temperature tabs count is shown on 3 days tab")
    @Feature("3 days tab")
    @Story("Show weather")
    public void check3DaysWindCount() {
        ThreeDaysPage threeDaysPage = mainSteps
                .openMain()
                .navigate3days();
        Assertions.assertEquals(12, threeDaysPage.windTabs.size());
    }

    @Test
    @DisplayName("Check wind in 3 days")
    @Description("Check if valid wind is shown on 3 days tab")
    @Feature("3 days tab")
    @Story("Show weather")
    public void check3DaysWindValue() {
        ThreeDaysPage threeDaysPage = mainSteps
                .openMain()
                .navigate3days();
        String temperatureStr = threeDaysPage.windTabs.get(0).getText();
        double v = Double.parseDouble(temperatureStr);
        Assertions.assertTrue(v < 1000 && v > 0);
    }

    @Test
    @DisplayName("Check wind count in 10 days")
    @Description("Check if valid wind tabs count is shown on 3 days tab")
    @Feature("3 days tab")
    @Story("Show weather")
    public void check10DaysTemperatureCount() {
        ThreeDaysPage threeDaysPage = mainSteps
                .openMain()
                .navigate3days();
        Assertions.assertEquals(20, threeDaysPage.temperatureTabs.size());
    }

    @Test
    @DisplayName("Check temperature value in 10 days")
    @Description("Check if valid temperature is shown on 10 days tab")
    @Feature("10 days tab")
    @Story("Show weather")
    public void check10DaysTemperatureValue() {
        ThreeDaysPage threeDaysPage = mainSteps
                .openMain()
                .navigate3days();
        String temperatureStr = threeDaysPage.temperatureTabs.get(0).getText();
        double v = Double.parseDouble(temperatureStr);
        Assertions.assertTrue(v < 100 && v > -100);
    }

    @Test
    @DisplayName("Check wind count in 10 days")
    @Description("Check if valid wind tabs count is shown on 10 days tab")
    @Feature("10 days tab")
    @Story("Show weather")
    public void check10DaysWindCount() {
        ThreeDaysPage threeDaysPage = mainSteps
                .openMain()
                .navigate3days();
        Assertions.assertEquals(10, threeDaysPage.windTabs.size());
    }

    @Test
    @DisplayName("Check wind value in 10 days")
    @Description("Check if valid wind is shown on 10 days tab")
    @Feature("10 days tab")
    @Story("Show weather")
    public void check10DaysWindValue() {
        ThreeDaysPage threeDaysPage = mainSteps
                .openMain()
                .navigate3days();
        String temperatureStr = threeDaysPage.windTabs.get(0).getText();
        double v = Double.parseDouble(temperatureStr);
        Assertions.assertTrue(v < 1000 && v > 0);
    }


//    @AfterEach
//    public void quit() {
//        driver.quit();
//    }


}
