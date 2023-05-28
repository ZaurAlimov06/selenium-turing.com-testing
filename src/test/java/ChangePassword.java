import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

    public class ChangePassword extends BasePage {
        private final By dropdownMenu = By.xpath("//*[@id='drawer_container']/div/ul/span/div");
        private final By settingsButton = By.xpath("//*[@id='drawer_container']/div/ul/span/div/div/ul/li[2]/a");
        private final By currentPasswordTextField = By.xpath("//input[@type='password' and @name='current_pwd']");
        private final By newPasswordTextField = By.xpath("//input[@type='password' and @name='new_pwd']");
        private final By againNewPasswordTextField = By.xpath("//input[@type='password' and @name='confirm_pwd']");
        private final By changePasswordButton = By.xpath("//button[@type='button']");
 

        public ChangePassword(WebDriver driver) {
            super(driver);
        }
        public void dropdownMenuClick() {
            WebElement dropdownMenuClick = waitAndReturnElement(dropdownMenu);
            dropdownMenuClick.click();
        }

        public void settingsButton() {
            WebElement settings = waitAndReturnElement(settingsButton);
            settings.click();
        }


        public void setCurrentPasword(String currentPassword) {
            WebElement currentPasswordField = waitAndReturnElement(currentPasswordTextField);
            currentPasswordField.sendKeys(currentPassword);
        }

        public void setNewPassword(String newPassword) {
            WebElement newPasswordField = waitAndReturnElement(newPasswordTextField);
            newPasswordField.sendKeys(newPassword);
        }

        public void setAgainNewPassword(String againNewPassword) {
            WebElement againNewPasswordField = waitAndReturnElement(againNewPasswordTextField);
            againNewPasswordField.sendKeys(againNewPassword);
        }

        public void changePasswordButtonClick() {
            WebElement changePasword = waitAndReturnElement(changePasswordButton);
            changePasword.click();
        }   

    
}
