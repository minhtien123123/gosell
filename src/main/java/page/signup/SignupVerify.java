package page.signup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SignupVerify extends SignUpElement{
    SoftAssert soft = new SoftAssert();
    WebDriverWait wait;

    public SignupVerify(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
