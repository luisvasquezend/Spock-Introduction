import pages.BasePage
import pages.HomePage
import pages.components.NavBar
import spock.lang.Shared
import spock.lang.Unroll
import utilities.ReadCredentialsFile
import spock.lang.Specification

class SpockTestSpec extends Specification {

    def driver
    def driverSetup
    @Shared
    def reader

    def "setupSpec"() {
        reader = new ReadCredentialsFile()
        reader.readData()
    }

    def "setup"() {
        driverSetup = new DriverSetup()
        driver = driverSetup.getWebDriver()
        driver.get("https://www.laneros.com/")
    }

    @Unroll
    def "login to the website"() {

        given: "The user needs to log in to their Laneros account"
        def basePage = new BasePage(driver)
        def navBar = new NavBar(driver)
        def homePage = new HomePage(driver)

        when: "The user enters valid credentials in the corresponding fields"
        navBar.displayLoginMenu()
        homePage.login(email, password)

        then: "The user should be logged in"
        username == navBar.username()

        where: "The email is #email and the password is #password"
        email << reader.getEmailColumns()
        password << reader.getPasswordColumns()
        username << reader.getUsernameColumns()
    }

    def "cleanup"() {
        driverSetup.closeDriver()
    }
}
