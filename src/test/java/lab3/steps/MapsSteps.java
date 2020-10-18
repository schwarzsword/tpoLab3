package lab3.steps;

import io.qameta.allure.Step;
import lab3.pages.MainPage;
import org.openqa.selenium.WebDriver;

import static lab3.config.Properties.URL;

public class MapsSteps {
    private MainPage page;
    private WebDriver driver;


    public MapsSteps(WebDriver driver) {
        this.driver = driver;
        page = new MainPage(this.driver);
    }

    @Step("Open main page")
    public MapsSteps openMain() {
        driver.get(URL);
        return this;
    }
}