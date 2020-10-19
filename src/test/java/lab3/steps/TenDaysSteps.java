package lab3.steps;

import io.qameta.allure.Step;
import lab3.pages.MainPage;
import lab3.pages.TenDaysPage;
import lab3.pages.ThreeDaysPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Thread.sleep;
import static lab3.config.Properties.TIMEOUT;
import static lab3.config.Properties.URL;

public class TenDaysSteps {
    private TenDaysPage page;
    private WebDriver driver;


    public TenDaysSteps(WebDriver driver) {
        this.driver = driver;
        page = new TenDaysPage(this.driver);
    }

    @Step("Check count of temperature tabs")
    public TenDaysSteps checkTemperatureCount() {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(page.XPATH_TEMPERATURE), 0));
        Assertions.assertEquals(30, page.temperatureTabs.size());
        return this;
    }

    @Step("Check value of temperature")
    public TenDaysSteps checkTemperatureValue() {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(page.XPATH_TEMPERATURE), 0));
        String temperatureStr = page.temperatureTabs.get(0).getText();
        double v = Double.parseDouble(temperatureStr);
        Assertions.assertTrue(v < 100 && v > -100);
        return this;
    }

    @Step("Check count of wind tabs")
    public TenDaysSteps checkWindCount() {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(page.XPATH_WIND), 0));
        Assertions.assertEquals(30, page.windTabs.size());
        return this;
    }

    @Step("Check value of wind")
    public TenDaysSteps checkWindValue() {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(page.XPATH_WIND), 0));
        String temperatureStr = page.windTabs.get(0).getText();
        double v = Double.parseDouble(temperatureStr);
        Assertions.assertTrue(v < 1000 && v > 0);
        return this;
    }

}