import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class LoginTest extends BasePage {
    private final By emailTextField = By.xpath("//input[@type='email' and @name='email']");
    private final By passwordTextField = By.xpath("//input[@type='password' and @name='password']");
    private final By loginButton = By.xpath("//button[@type='submit']");
    
    public LoginTest(WebDriver driver) {
        super(driver);
        this.driver.get("https://developers.turing.com/login");
    }

    public void setEmail(String email) {
        WebElement emailField = waitAndReturnElement(emailTextField);
        emailField.sendKeys(email);
    }

    public void setPassword(String password) {
        WebElement passwordField = waitAndReturnElement(passwordTextField);
        passwordField.sendKeys(password);
    }

    public void loginButtonClick() {
        WebElement login = waitAndReturnElement(loginButton);
        login.click();
    }
 

    
}