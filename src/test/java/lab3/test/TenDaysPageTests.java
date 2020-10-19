package lab3.test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lab3.config.chrome.ChromeConfig;
import lab3.pages.MainPage;
import lab3.pages.TenDaysPage;
import lab3.pages.ThreeDaysPage;
import lab3.steps.MainSteps;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TenDaysPageTests {
    private static WebDriver driver;
    private static TenDaysPage tenDaysPage;

    @BeforeAll
    public static void prepare() {
        driver = ChromeConfig.ChromeDriver();
        tenDaysPage = new MainSteps(driver).navigate10days();
    }
    @Test
    @DisplayName("Check temperature tabs count in 10 days")
    @Description("Check if valid wind tabs count is shown on 3 days tab")
    @Feature("3 days tab")
    @Story("Show weather")
    public void check10DaysTemperatureCount() {
        Assertions.assertEquals(20, tenDaysPage.temperatureTabs.size());
    }

    @Test
    @DisplayName("Check temperature value in 10 days")
    @Description("Check if valid temperature is shown on 10 days tab")
    @Feature("10 days tab")
    @Story("Show weather")
    public void check10DaysTemperatureValue() {
        String temperatureStr = tenDaysPage.temperatureTabs.get(0).getText();
        double v = Double.parseDouble(temperatureStr);
        Assertions.assertTrue(v < 100 && v > -100);
    }

    @Test
    @DisplayName("Check wind tabs count in 10 days")
    @Description("Check if valid wind tabs count is shown on 10 days tab")
    @Feature("10 days tab")
    @Story("Show weather")
    public void check10DaysWindCount() {
        Assertions.assertEquals(10, tenDaysPage.windTabs.size());
    }

    @Test
    @DisplayName("Check wind value in 10 days")
    @Description("Check if valid wind is shown on 10 days tab")
    @Feature("10 days tab")
    @Story("Show weather")
    public void check10DaysWindValue() {
        String temperatureStr = tenDaysPage.windTabs.get(0).getText();
        double v = Double.parseDouble(temperatureStr);
        Assertions.assertTrue(v < 1000 && v > 0);
    }

    @AfterAll
    public static void quit() {
        driver.quit();
    }
}
