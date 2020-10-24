package lab3.steps;

import io.qameta.allure.Step;
import lab3.pages.MapsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static lab3.config.Properties.TIMEOUT;

public class MapsSteps {
    private MapsPage page;
    private WebDriver driver;
    private final String TEMP_URL = "/temp";


    public MapsSteps(WebDriver driver) {
        this.driver = driver;
        page = new MapsPage(this.driver);
    }

    @Step("Check check rain map")
    public MapsSteps checkRainMap() {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(page.XPATH_MAP)));
        return this;
    }

    @Step("Navigate temperature map")
    public MapsSteps navigateTemperatureMap() {
        WebElement tempTab = page.subnavItems.stream().filter(e -> e.getText().equals("Температура воздуха")).findFirst().get();
        tempTab.click();
        new WebDriverWait(driver, TIMEOUT)
                .withMessage("Invalid url, expected URL is " + TEMP_URL)
                .until(ExpectedConditions.urlContains(TEMP_URL));
        return this;
    }

    @Step("Check check temperature map")
    public MapsSteps checkTemperatureMap() {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(page.XPATH_MAP)));
        return this;
    }

}