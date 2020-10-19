package lab3.steps;

import io.qameta.allure.Step;
import lab3.pages.ThreeDaysPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static lab3.config.Properties.TIMEOUT;

public class ThreeDaysSteps {
    private ThreeDaysPage page;
    private WebDriver driver;


    public ThreeDaysSteps(WebDriver driver) {
        this.driver = driver;
        page = new ThreeDaysPage(this.driver);
    }

    @Step("Check count of temperature tabs")
    public ThreeDaysSteps checkTemperatureCount() {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(page.XPATH_TEMPERATURE), 0));
        Assertions.assertEquals(40, page.temperatureTabs.size());
        return this;
    }

    @Step("Check value of temperature")
    public ThreeDaysSteps checkTemperatureValue() {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(page.XPATH_TEMPERATURE), 0));
        String temperatureStr = page.temperatureTabs.get(0).getText();
        double v = Double.parseDouble(temperatureStr);
        Assertions.assertTrue(v < 100 && v > -100);
        return this;
    }

    @Step("Check count of wind tabs")
    public ThreeDaysSteps checkWindCount() {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(page.XPATH_WIND), 0));
        Assertions.assertEquals(40, page.windTabs.size());
        return this;
    }

    @Step("Check value of wind")
    public ThreeDaysSteps checkWindValue() {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(page.XPATH_WIND), 0));
        String temperatureStr = page.windTabs.get(0).getText();
        double v = Double.parseDouble(temperatureStr);
        Assertions.assertTrue(v < 1000 && v > 0);
        return this;
    }
}