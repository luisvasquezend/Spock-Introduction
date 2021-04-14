package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class NavBar extends BasePage {

    private final By accessButton = By.className("p-navgroup-link--logIn");
    private final By userLoggedIn = By.xpath("//span[contains(text(),'vasquez')]");

    public NavBar(WebDriver driver) {
        super(driver);
    }

    public void displayLoginMenu() {
        waitElementVisible(accessButton).click();
    }

    public String username() {
        return waitElementVisible(userLoggedIn).getText();
    }
}
