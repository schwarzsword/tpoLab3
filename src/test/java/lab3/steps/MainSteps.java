package lab3.steps;

import io.qameta.allure.Step;
import lab3.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static lab3.config.Properties.TIMEOUT;
import static lab3.config.Properties.URL;

public class MainSteps {
    private MainPage page;
    private WebDriver driver;
    private final String ORENBURG_URL = "orenburg";
    private final String THREE_DAYS_URL = "3-days";
    private final String TEN_DAYS_URL = "10-days";
    private final String MAPS_URL = "maps";


    public MainSteps(WebDriver driver) {
        this.driver = driver;
        page = new MainPage(this.driver);
    }

    @Step("Open main page")
    public MainSteps openMain() {
        driver.get(URL);
        return this;
    }

    @Step("Type given city - {city}")
    public MainSteps typeCity(String city) {
        page.searchPane.sendKeys(city);
        return this;
    }

    @Step("Clean up search pane")
    public MainSteps cleanUpSearch() {
        page.searchPane.clear();
        return this;
    }

    @Step("Navigate new city")
    public MainSteps navigateCity() {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(page.XPATH_FOUND_ELEMENTS), 0));
        page.root.findElements(By.xpath(page.XPATH_FOUND_ELEMENTS)).get(0).click();
        return this;
    }

    @Step("Navigate 3 days tab")
    public ThreeDaysSteps navigate3days() {
        WebElement webElement = page.weatherNavTabs.stream().filter(e -> e.getText().equals("3 дня")).findFirst().get();
        webElement.click();
        new WebDriverWait(driver, TIMEOUT)
                .withMessage("Invalid url, expected URL is " + THREE_DAYS_URL)
                .until(ExpectedConditions.urlMatches(THREE_DAYS_URL));
        return new ThreeDaysSteps(driver);
    }

    @Step("Navigate 10 days tab")
    public TenDaysSteps navigate10days() {
        WebElement webElement = page.weatherNavTabs.stream().filter(e -> e.getText().equals("10 дней")).findFirst().get();
        webElement.click();
        new WebDriverWait(driver, TIMEOUT)
                .withMessage("Invalid url, expected URL is " + TEN_DAYS_URL)
                .until(ExpectedConditions.urlContains(TEN_DAYS_URL));
        return new TenDaysSteps(driver);
    }

    @Step("Navigate maps tab")
    public MapsSteps navigateMaps() {
        WebElement webElement = page.menuItems.stream().filter(e -> e.getText().equals("Карты")).findFirst().get();
        webElement.click();
        new WebDriverWait(driver, TIMEOUT)
                .withMessage("Invalid url, expected URL is " + MAPS_URL)
                .until(ExpectedConditions.urlContains(MAPS_URL));
        return new MapsSteps(driver);
    }

    @Step("Check today temperature")
    public MainSteps checkTemperature() {
        String temperatureStr = page.todayTemperature.getText().replaceAll(",", ".");
        double v = Double.parseDouble(temperatureStr);
        Assertions.assertTrue(v < 100 && v > -100);
        return this;
    }

    @Step("Check today wind")
    public MainSteps checkWind() {
        String windStr = page.todayWind.getText();
        Assertions.assertTrue(windStr.matches("^\\d+ м/с, (Ю|С|В|З|СВ|СЗ|ЮВ|ЮЗ)$"));
        return this;
    }

    @Step("Check invalid search result")
    public MainSteps checkNotFound() {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(page.XPATH_NOT_FOUND_ELEMENTS), 0));
        List<WebElement> results = page.root.findElements(By.xpath(page.XPATH_FOUND_ELEMENTS_TEXT));
        Assertions.assertEquals(0, results.size());
        return this;
    }

    @Step("Check valid search result")
    public MainSteps checkFound() {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(page.XPATH_FOUND_ELEMENTS), 0));
        List<WebElement> results = page.root.findElements(By.xpath(page.XPATH_FOUND_ELEMENTS_TEXT));
        Assertions.assertEquals("Оренбург", results.get(0).getText());
        return this;
    }

    @Step("Check valid search result")
    public MainSteps checkNavigation() {
        new WebDriverWait(driver, TIMEOUT)
                .withMessage("Invalid url, expected URL is " + ORENBURG_URL)
                .until(ExpectedConditions.urlContains(ORENBURG_URL));
        return this;
    }
}