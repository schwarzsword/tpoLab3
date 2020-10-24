package lab3.config.firefox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static lab3.config.Properties.*;

public class FirefoxConfig {
    static {
        System.setProperty(FIREFOX_SYSTEM_PROPERTY, FIREFOX_PATH);
    }

    public static WebDriver createDriver() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}