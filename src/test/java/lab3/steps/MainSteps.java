package lab3.steps;

import io.qameta.allure.Step;
import lab3.pages.MainPage;
import lab3.pages.TenDaysPage;
import lab3.pages.ThreeDaysPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;
import static lab3.config.Properties.URL;

public class MainSteps {
    private MainPage page;
    private WebDriver driver;


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
    public MainSteps cleanUpSearch(){
        page.searchPane.clear();
        return this;
    }

    @Step("Submit search result")
    public MainSteps submitSearch() {
        try {

            sleep(100);
        }catch (Exception e){}
        page.searchPane.submit();
        page.searchPane.click();
        return this;
    }

    @Step("Navigate new city")
    public MainSteps navigateCity() {
        page.root.findElements(By.xpath(MainPage.XPATH_FOUND_ELEMENTS)).get(0).click();
        return this;
    }

    @Step("Navigate 3 days tab")
    public ThreeDaysPage navigate3days() {
        WebElement webElement = page.weatherNavTabs.stream().filter(e -> e.getText().equals("3 дня")).findFirst().get();
        webElement.click();
        return new ThreeDaysPage(driver);
    }

    @Step("Navigate 10 days tab")
    public TenDaysPage navigate10days() {
        WebElement webElement = page.weatherNavTabs.stream().filter(e -> e.getText().equals("3 дня")).findFirst().get();
        webElement.click();
        return new TenDaysPage(driver);
    }
}