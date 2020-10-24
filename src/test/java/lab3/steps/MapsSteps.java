package lab3.steps;

import io.qameta.allure.Step;
import lab3.pages.MapsPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static lab3.config.Properties.TIMEOUT;

public class MapsSteps {
    private MapsPage page;
    private WebDriver driver;


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

}