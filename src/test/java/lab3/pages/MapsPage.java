package lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MapsPage extends Page {
    public MapsPage(WebDriver driver) {
        super(driver);
    }
    public final String XPATH_ROOT = "//*[contains(@class,'content')]";
    public final String XPATH_MAP = "//*[contains(@class,'layout-0')]";
}
