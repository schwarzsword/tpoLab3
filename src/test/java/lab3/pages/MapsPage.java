package lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MapsPage extends Page {
    public MapsPage(WebDriver driver) {
        super(driver);
    }
    public final String XPATH_MAP = "//*[contains(@class,'layout-0')]";
    public final String XPATH_TEMPERATURE_TAB = "//*[contains(@class,'subnav')]//*[contains(@class, 'subnav_item')]/span[text()='Температура воздуха']";

    @FindBy(xpath = XPATH_TEMPERATURE_TAB)
    public WebElement temperatureTab;
}
