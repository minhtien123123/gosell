package page.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginVerify extends LoginElement{
    SoftAssert soft = new SoftAssert();
    WebDriverWait wait;
    
    public LoginVerify(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public LoginVerify verifyEmailOrPhoneNumberError(String errMessage) {
        String text = wait.until(ExpectedConditions.visibilityOf(USER_PASSWORD_ERROR.get(0))).getText();
        soft.assertEquals(text, errMessage, "[Login][Email or Phone Number] Message does not match.");
        return this;
    }

    public LoginVerify verifyPasswordError(String errMessage) {
        int size = USER_PASSWORD_ERROR.size() - 1;
        System.out.println(size + "!23");
        String text = wait.until(ExpectedConditions.visibilityOf(USER_PASSWORD_ERROR.get(size))).getText();
        soft.assertEquals(text,errMessage, "[Login][Password] Message does not match");
        return this;
    }

    public LoginVerify verifyEmailOrPasswordIncorrectError(String errMessage) {
        String text = wait.until(ExpectedConditions.visibilityOf(INVALID_USER_ERROR)).getText();
        soft.assertEquals(text,errMessage, "[Login][Invalid Email/Password] Message does not match");
        return this;
    }

    public void completeVerify() {
        soft.assertAll();
    }
}
