package lab3.test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lab3.config.chrome.ChromeConfig;
import lab3.pages.MainPage;
import lab3.steps.MainSteps;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

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
        mainSteps.checkTemperature();
    }

    @Test
    @Order(2)
    @DisplayName("Check wind today")
    @Description("Check if wind is shown on today tab")
    @Feature("Today tab")
    @Story("Show weather")
    public void checkTodayWind() {
        mainSteps.checkWind();
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
                .typeCity("Новоухрюпинск")
                .checkNotFound();
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
                .checkFound();
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
                .navigateCity()
                .checkNavigation();
    }
//
//    @AfterAll
//    public static void quit() {
//        driver.quit();
//    }
}
