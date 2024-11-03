package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    private final By swagLabsTitle = By.cssSelector(".title");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSwagLabsTitleDisplayed() {
        return driver.findElement(swagLabsTitle).isDisplayed();
    }
}
