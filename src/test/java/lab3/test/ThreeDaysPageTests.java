package lab3.test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lab3.config.chrome.ChromeConfig;
import lab3.pages.ThreeDaysPage;
import lab3.steps.MainSteps;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class ThreeDaysPageTests {
    private static WebDriver driver;
    private static ThreeDaysPage threeDaysPage;

    @BeforeAll
    public static void prepare() {
        driver = ChromeConfig.ChromeDriver();
        threeDaysPage = new MainSteps(driver).openMain().navigate3days();
    }


    @Test
    @DisplayName("Check temperature tabs count in 3 days")
    @Description("Check if valid temperature tabs count is shown on 3 days tab")
    @Feature("3 days tab")
    @Story("Show weather")
    public void check3DaysTemperatureCount() {
        Assertions.assertEquals(12, threeDaysPage.temperatureTabs.size());
    }

    @Test
    @DisplayName("Check temperature in 3 days")
    @Description("Check if valid temperature is shown on 3 days tab")
    @Feature("3 days tab")
    @Story("Show weather")
    public void check3DaysTemperatureValue() {
        String temperatureStr = threeDaysPage.temperatureTabs.get(0).getText();
        double v = Double.parseDouble(temperatureStr);
        Assertions.assertTrue(v < 100 && v > -100);
    }

    @Test
    @DisplayName("Check wind tabs count in 3 days")
    @Description("Check if valid wind tabs count is shown on 3 days tab")
    @Feature("3 days tab")
    @Story("Show weather")
    public void check3DaysWindCount() {
        Assertions.assertEquals(12, threeDaysPage.windTabs.size());
    }

    @Test
    @DisplayName("Check wind in 3 days")
    @Description("Check if valid wind is shown on 3 days tab")
    @Feature("3 days tab")
    @Story("Show weather")
    public void check3DaysWindValue() {
        String temperatureStr = threeDaysPage.windTabs.get(0).getText();
        double v = Double.parseDouble(temperatureStr);
        Assertions.assertTrue(v < 1000 && v > 0);
    }

    @AfterAll
    public static void quit() {
        driver.quit();
    }
}
