package lab3.test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lab3.config.chrome.ChromeConfig;
import lab3.steps.MainSteps;
import lab3.steps.MapsSteps;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class MapsPageTests {
    private static WebDriver driver;
    private static MapsSteps mapsSteps;

    @BeforeAll
    public static void prepare() {
        driver = ChromeConfig.createDriver();
        mapsSteps = new MainSteps(driver).openMain().navigateMaps();
    }

    @Test
    @DisplayName("Rain map test")
    @Description("Check if rain map page working")
    @Feature("Rain map")
    @Story("Weather maps")
    public void checkRainMap() {
        mapsSteps.checkRainMap();
    }

    @Test
    @DisplayName("Rain map test")
    @Description("Check if rain map page working")
    @Feature("Rain map")
    @Story("Weather maps")
    public void checkTemperatureTemperatureMap() {
        mapsSteps.checkRainMap();
    }


    @AfterAll
    public static void quit() {
        driver.quit();
    }
}
