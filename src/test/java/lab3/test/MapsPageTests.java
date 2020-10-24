package lab3.test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lab3.config.firefox.FirefoxConfig;
import lab3.steps.MainSteps;
import lab3.steps.MapsSteps;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class MapsPageTests {
    private static WebDriver driver;
    private static MapsSteps mapsSteps;

    @BeforeAll
    public static void prepare() {
        driver = FirefoxConfig.createDriver();
        mapsSteps = new MainSteps(driver).openMain().navigateMaps();
    }

    @Test
    @DisplayName("Rain map test")
    @Description("Check if rain map page working")
    @Feature("Weather maps")
    @Story("Rain map")
    public void checkRainMap() {
        mapsSteps.checkRainMap();
    }

    @Test
    @DisplayName("Temperature map test")
    @Description("Check if temperature map page working")
    @Feature("Weather maps")
    @Story("Temperature map")
    public void checkTemperatureMap() {
        mapsSteps
                .navigateTemperatureMap()
                .checkTemperatureMap();
    }


    @AfterAll
    public static void quit() {
        driver.quit();
    }
}
