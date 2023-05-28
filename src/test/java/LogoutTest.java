import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class LogoutTest extends BasePage {
    private final By dropdownMenu = By.xpath("//*[@id='drawer_container']/div/ul/span/div");
    private final By logoutButton = By.xpath("//*[@id='drawer_container']/div[1]/ul/span/div/div/ul/li[3]/a");
    
    public LogoutTest(WebDriver driver) {
        super(driver);
    }


    public void dropdownMenuClick() {
            WebElement dropdownMenuClick = waitAndReturnElement(dropdownMenu);
            dropdownMenuClick.click();
    }

    public void logoutButtonClick() {
            WebElement logout = waitAndReturnElement(logoutButton);
            logout.click();
    }

}