package lab3.test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lab3.config.chrome.ChromeConfig;
import lab3.pages.MainPage;
import lab3.steps.MainSteps;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainPageTests {
    private static WebDriver driver;
    private static MainSteps mainSteps;
    private static MainPage mainPage;

    @BeforeAll
    public static void prepare() {
        driver = ChromeConfig.ChromeDriver();
        mainSteps = new MainSteps(driver);
        mainPage = new MainPage(driver);
        mainSteps
                .openMain();
    }

    @Test
    @Order(1)
    @DisplayName("Check temperature today")
    @Description("Check if temperature is shown on today tab")
    @Feature("Today tab")
    @Story("Show weather")
    public void checkTodayTemperature() {
        String temperatureStr = mainPage.todayTemperature.getText().replaceAll(",", ".");
        double v = Double.parseDouble(temperatureStr);
        Assertions.assertTrue(v < 100 && v > -100);
    }

    @Test
    @Order(2)
    @DisplayName("Check wind today")
    @Description("Check if wind is shown on today tab")
    @Feature("Today tab")
    @Story("Show weather")
    public void checkTodayWind() {
        String windStr = mainPage.todayWind.getText();
        Assertions.assertTrue(windStr.matches("^\\d+ м/с, (Ю|С|В|З|СВ|СЗ|ЮВ|ЮЗ)$"));
    }

    @Test
    @Order(3)
    @DisplayName("Find invalid city")
    @Description("Check check if system can find desired invalid city")
    @Feature("Invalid city search autocomplete")
    @Story("Autocomplete")
    public void unexistingCityAutocompleteTest() {
        mainSteps
                .cleanUpSearch()
                .typeCity("Ухрюпинск")
                .submitSearch();
        List<WebElement> results = mainPage.root.findElements(By.xpath(MainPage.XPATH_FOUND_ELEMENTS_TEXT));
        Assertions.assertEquals(0, results.size());
    }

    @Test
    @Order(4)
    @DisplayName("Find valid city")
    @Description("Check check if system can find desired valid city")
    @Feature("Valid city search autocomplete")
    @Story("Autocomplete")
    public void existingCityAutocompleteTest() {
        mainSteps
                .cleanUpSearch()
                .typeCity("Оренбург")
                .submitSearch();
        List<WebElement> results = mainPage.root.findElements(By.xpath(MainPage.XPATH_FOUND_ELEMENTS_TEXT));
        Assertions.assertEquals("Оренбург", results.get(0).getText());
    }

    @Test
    @Order(5)
    @DisplayName("Navigate city")
    @Description("Navigate to the city page")
    @Feature("City search navigation")
    @Story("Search and navigation")
    public void existingCityNavigationTest() {
        mainSteps
                .cleanUpSearch()
                .typeCity("Оренбург")
                .submitSearch()
                .navigateCity();
        Assertions.assertTrue(driver.getCurrentUrl().contains("orenburg"));
    }

    @AfterAll
    public static void quit() {
        driver.quit();
    }
}
