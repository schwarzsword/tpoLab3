package lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ThreeDaysPage extends Page {
    public ThreeDaysPage(WebDriver driver) {
        super(driver);
    }

    public final String XPATH_TEMPERATURE = "//*[contains(@class,'unit_temperature_c')]";
    public final String XPATH_WIND = "//*[contains(@class,'wind_value')]";

    @FindBy(xpath = XPATH_TEMPERATURE)
    public List<WebElement> temperatureTabs;

    @FindBy(xpath = XPATH_WIND)
    public List<WebElement> windTabs;

}
