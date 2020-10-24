package lab3.test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lab3.config.chrome.ChromeConfig;
import lab3.config.firefox.FirefoxConfig;
import lab3.steps.MainSteps;
import lab3.steps.TenDaysSteps;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TenDaysPageTests {
    private static WebDriver driver;
    private static TenDaysSteps tenDaysSteps;

    @BeforeAll
    public static void prepare() {
        driver = FirefoxConfig.createDriver();
        tenDaysSteps = new MainSteps(driver).openMain().navigate10days();
    }

    @Test
    @DisplayName("Check temperature tabs count in 10 days")
    @Description("Check if valid wind tabs count is shown on 3 days tab")
    @Feature("3 days tab")
    @Story("Show weather")
    public void check10DaysTemperatureCount() {
        tenDaysSteps.checkTemperatureCount();
    }

    @Test
    @DisplayName("Check temperature value in 10 days")
    @Description("Check if valid temperature is shown on 10 days tab")
    @Feature("10 days tab")
    @Story("Show weather")
    public void check10DaysTemperatureValue() {
        tenDaysSteps.checkTemperatureValue();
    }

    @Test
    @DisplayName("Check wind tabs count in 10 days")
    @Description("Check if valid wind tabs count is shown on 10 days tab")
    @Feature("10 days tab")
    @Story("Show weather")
    public void check10DaysWindCount() {
        tenDaysSteps.checkWindCount();
    }

    @Test
    @DisplayName("Check wind value in 10 days")
    @Description("Check if valid wind is shown on 10 days tab")
    @Feature("10 days tab")
    @Story("Show weather")
    public void check10DaysWindValue() {
        tenDaysSteps.checkWindValue();
    }

    @AfterAll
    public static void quit() {
        driver.quit();
    }
}
