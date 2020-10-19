package lab3.steps;

import lab3.pages.MapsPage;
import org.openqa.selenium.WebDriver;

public class MapsSteps {
    private MapsPage page;
    private WebDriver driver;


    public MapsSteps(WebDriver driver) {
        this.driver = driver;
        page = new MapsPage(this.driver);
    }

}