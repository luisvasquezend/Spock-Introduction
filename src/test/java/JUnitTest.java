import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.HomePage;
import pages.components.NavBar;
import utilities.ReadCredentialsFile;

import java.io.FileNotFoundException;
import java.util.List;

@RunWith(Parameterized.class)
public class JUnitTest {

    private final String email;
    private final String password;
    private final String username;


    private WebDriver driver;
    private DriverSetup driverSetup;

    @Parameterized.Parameters(name = "Data = {0} - {1} - {2}")
    public static List<String[]> dataProv() throws FileNotFoundException {
        ReadCredentialsFile reader = new ReadCredentialsFile();
        reader.readData();
        return reader.getRows();
    }

    public JUnitTest(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    @Before
    public void setup() {
        driverSetup = new DriverSetup();
        driver = driverSetup.getWebDriver();
        driver.get("https://www.laneros.com/");
    }

    @Test
    public void loginToTheWebsite() throws InterruptedException {

        //Given
        BasePage basePage = new BasePage(driver);
        NavBar navBar = new NavBar(driver);
        HomePage homePage = new HomePage(driver);

        //when
        navBar.displayLoginMenu();
        homePage.login(email, password);

        //then
        Assert.assertEquals(username, navBar.username());
    }

    @After
    public void closeTheDriver() {
        driverSetup.closeDriver();
    }
}
