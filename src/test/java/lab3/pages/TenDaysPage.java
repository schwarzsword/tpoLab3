package lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TenDaysPage extends Page {
    public TenDaysPage(WebDriver driver) {
        super(driver);
    }

    public static final String XPATH_ROOT = "//*[contains(@class,'content')]";
    public static final String XPATH_TEMPERATURE = "//*[contains(@class,'unit_temperature_c')]";
    public static final String XPATH_WIND = "//*[contains(@class,'unit_wind_m_s')]";

    @FindBy(xpath = XPATH_ROOT)
    public WebElement root;

    @FindBy(xpath = XPATH_TEMPERATURE)
    public List<WebElement> temperatureTabs;

    @FindBy(xpath = XPATH_WIND)
    public List<WebElement> windTabs;
}
