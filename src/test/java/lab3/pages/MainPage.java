package lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends Page {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public final String XPATH_ROOT = "//*[contains(@class,'content')]";
    public final String XPATH_WEATHER_TABS = "//*[contains(@class,'subnav_link')]";
    public final String XPATH_TODAY_TEMPERATURE = "//*[contains(@class,'unit_temperature_c')]";
    public final String XPATH_TODAY_WIND = "//*[contains(@class,'unit_wind_m_s')]";
    public final String XPATH_SEARCH_INPUT = "//*[contains(@class,'search_input')]";
    public final String XPATH_MENU_ITEMS = "//*[contains(@role,'menuitem')]";
    public final String XPATH_FOUND_ELEMENTS = "//*[contains(@class,'found__list')]//*[contains(@class,'founditem')]";
    public final String XPATH_NOT_FOUND_ELEMENTS = "//*[contains(@class,'found__notfound')]";
    public final String XPATH_FOUND_ELEMENTS_TEXT = "//*[contains(@class,'found__list')]//*[contains(@class,'founditem')]//*[contains(@class, 'founditem__link')]";

    @FindBy(xpath = XPATH_ROOT)
    public WebElement root;

    @FindBy(xpath = XPATH_SEARCH_INPUT)
    public WebElement searchPane;

    @FindBy(xpath = XPATH_TODAY_TEMPERATURE)
    public WebElement todayTemperature;

    @FindBy(xpath = XPATH_TODAY_WIND)
    public WebElement todayWind;

    @FindBy(xpath = XPATH_WEATHER_TABS)
    public List<WebElement> weatherNavTabs;

    @FindBy(xpath = XPATH_MENU_ITEMS)
    public List<WebElement> menuItems;
}
