package lab3.config.chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static lab3.config.Properties.CHROME_PATH;
import static lab3.config.Properties.CHROME_SYSTEM_PROPERTY;

public class ChromeConfig {
    static {
        System.setProperty(CHROME_SYSTEM_PROPERTY, CHROME_PATH);
    }

    public static WebDriver ChromeDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}