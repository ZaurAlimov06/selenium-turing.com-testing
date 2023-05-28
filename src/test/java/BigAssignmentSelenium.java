import org.junit.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class BigAssignmentSelenium {
    private WebDriver driver;


    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
        options.addArguments("--disable-popup-blocking"); //Disable popup blocking
    }

    @Test
    public void testLogin() {
        // Login Page
        LoginTest loginTest = new LoginTest(driver);
        // Static Page Test
        Assert.assertTrue(loginTest.getBodyText().contains("Sign in"));
        // Login Page Test
        loginTest.setEmail("rikonak677@duscore.com");
        loginTest.setPassword("12345Qwert%");
        loginTest.loginButtonClick();
        
    
    }
    

    @Test
    public void testLogout(){
            // Login Page
        LoginTest loginTest = new LoginTest(driver);
        loginTest.setEmail("rikonak677@duscore.com");
        loginTest.setPassword("12345Qwert%");
        loginTest.loginButtonClick();
        
        LogoutTest logoutTest = new LogoutTest(driver);
        logoutTest.dropdownMenuClick();
        logoutTest.logoutButtonClick();

        }

    @Test
    public void testPageTitle() {
        this.driver.get("https://developers.turing.com/");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
    }

    @Test
    public void testChangePassword(){
          // Login Page
        LoginTest loginTest = new LoginTest(driver);
        loginTest.setEmail("rikonak677@duscore.com");
        loginTest.setPassword("12345Qwert%");
        loginTest.loginButtonClick();
        // Home Page -> Settings Page
        ChangePassword changePassword = new ChangePassword(driver);
        changePassword.dropdownMenuClick();
        changePassword.settingsButton(); //Settings Page
        changePassword.setCurrentPasword("12345Qwert%");
        changePassword.setNewPassword("12345Qwert%%");
        changePassword.setAgainNewPassword("12345Qwert%%");
        changePassword.changePasswordButtonClick();
        }



    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
