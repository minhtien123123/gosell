package page.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utilities.links.Links.*;

public class LoginPage extends LoginVerify{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage navigate() {
        driver.get(DOMAIN + LOGIN_PATH);
        wait.until(ExpectedConditions.titleIs(LOGIN_PAGE_TITLE));
        return this;
    }

    public LoginPage inputEmailOrPhoneNumber(String username) {
        wait.until(ExpectedConditions.visibilityOf(USERNAME)).sendKeys(username);
        return this;
    }

    public LoginPage inputPassword(String password) {
        PASSWORD.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginBtn() {
        LOGIN_BTN.click();
        return this;
    }
    
    public LoginPage fillOutLoginForm(String username, String password) {
    	inputEmailOrPhoneNumber(username);
    	inputPassword(password);
    	clickLoginBtn();
        return this;
    }
    
}
