import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;


public class FirstSeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() throws MalformedURLException
    {
        ChromeOptions options = new ChromeOptions();
        this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), (Capabilities) options);
        this.driver.manage().window().maximize();

        this.wait = new WebDriverWait(driver, 10);
    }

    private By bodyLocator = By.tagName("body");
    private By flashMessagesLocator = By.id("flash");
    private By usernameFieldLocator = By.id("username");
    private By passwordFieldLocator = By.id("password");
    private By loginButtonLocator = By.className("radius");
    private By logoutButtonLocator = By.className("secondary");

    private WebElement waitVisibilityAndFindElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }


    //Open the http://the-internet.herokuapp.com/login page with selenium
    @Test
    public void testLoadPage()
    {
        this.driver.get("http://the-internet.herokuapp.com/login");

        WebElement bodyResult = waitVisibilityAndFindElement(bodyLocator);
        assertTrue(bodyResult.getText().contains("Login Page"));
    }

    //Try wrong credentials to login and check the login fail.
    @Test
    public void testInvalidLogin()
    {
        this.driver.get("http://the-internet.herokuapp.com/login");

        WebElement usernameField = waitVisibilityAndFindElement(usernameFieldLocator);
        usernameField.sendKeys("name");

        WebElement passwordField = waitVisibilityAndFindElement(passwordFieldLocator);
        passwordField.sendKeys("passwd");

        WebElement loginButton = waitVisibilityAndFindElement(loginButtonLocator);
        loginButton.click();

        WebElement bodyResult = waitVisibilityAndFindElement(bodyLocator);
        assertTrue(bodyResult.getText().contains("Your username is invalid!"));
    }

    // Check if you logged in correctly. + Logout where:
    @Test
    public void testSuccessfulLoginAndLogoutAfter() {
        // Check if you logged in correctly.
        this.driver.get("http://the-internet.herokuapp.com/login");

        WebElement usernameField = waitVisibilityAndFindElement(usernameFieldLocator);
        usernameField.sendKeys("tomsmith");

        WebElement passwordField = waitVisibilityAndFindElement(passwordFieldLocator);
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement loginButton = waitVisibilityAndFindElement(loginButtonLocator);
        loginButton.click();

        WebElement alertMessage = waitVisibilityAndFindElement(flashMessagesLocator);
        assertTrue(alertMessage.getText().contains("You logged into a secure area!"));

        // Loguout
        WebElement logoutButton = waitVisibilityAndFindElement(logoutButtonLocator);
        logoutButton.click();

        WebElement bodyResult = waitVisibilityAndFindElement(bodyLocator);
        assertTrue(bodyResult.getText().contains("Login Page"));

    }

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
