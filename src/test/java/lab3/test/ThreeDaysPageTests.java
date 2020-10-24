package lab3.test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lab3.config.chrome.ChromeConfig;
import lab3.config.firefox.FirefoxConfig;
import lab3.steps.MainSteps;
import lab3.steps.ThreeDaysSteps;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class ThreeDaysPageTests {
    private static WebDriver driver;
    private static ThreeDaysSteps threeDaysSteps;

    @BeforeAll
    public static void prepare() {
        driver = FirefoxConfig.createDriver();
        threeDaysSteps = new MainSteps(driver).openMain().navigate3days();
    }


    @Test
    @DisplayName("Check temperature tabs count in 3 days")
    @Description("Check if valid temperature tabs count is shown on 3 days tab")
    @Feature("3 days tab")
    @Story("Show weather")
    public void check3DaysTemperatureCount() {
        threeDaysSteps.checkTemperatureCount();
    }

    @Test
    @DisplayName("Check temperature in 3 days")
    @Description("Check if valid temperature is shown on 3 days tab")
    @Feature("3 days tab")
    @Story("Show weather")
    public void check3DaysTemperatureValue() {
        threeDaysSteps.checkTemperatureValue();
    }

    @Test
    @DisplayName("Check wind tabs count in 3 days")
    @Description("Check if valid wind tabs count is shown on 3 days tab")
    @Feature("3 days tab")
    @Story("Show weather")
    public void check3DaysWindCount() {
        threeDaysSteps.checkWindCount();
    }

    @Test
    @DisplayName("Check wind in 3 days")
    @Description("Check if valid wind is shown on 3 days tab")
    @Feature("3 days tab")
    @Story("Show weather")
    public void check3DaysWindValue() {
       threeDaysSteps.checkWindValue();
    }

    @AfterAll
    public static void quit() {
        driver.quit();
    }
}
