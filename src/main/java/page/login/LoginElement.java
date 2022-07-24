package page.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.driver.InitWebdriver;

import java.util.List;

public class LoginElement {
    WebDriver driver;

    public LoginElement (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#username")
    WebElement USERNAME;

    @FindBy (css = "#password")
    WebElement PASSWORD;

    @FindBy (css = "button.gs-button")
    WebElement LOGIN_BTN;

    @FindBy (css = "div.invalid-feedback")
    List<WebElement> USER_PASSWORD_ERROR;

    @FindBy (css = "div.alert__wrapper")
    WebElement INVALID_USER_ERROR;
}
