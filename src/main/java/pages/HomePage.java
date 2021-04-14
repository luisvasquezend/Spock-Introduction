package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By emailField = By.name("login");
    private final By passwordField = By.name("password");
    private final By loginButton = By.className("button--icon--login");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void login(String email, String password) {
        waitElementVisible(emailField).sendKeys(email);
        find(passwordField).sendKeys(password);
        find(loginButton).click();
    }
}
