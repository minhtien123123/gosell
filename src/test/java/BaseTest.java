import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.login.LoginPage;
import page.signup.SignupPage;
import utilities.data.GenerateData;
import utilities.driver.InitWebdriver;

public class BaseTest {
    WebDriver driver;
    LoginPage LoginPage;
    SignupPage SignupPage;
    GenerateData generate;

    @BeforeMethod
    public void setup() {
        driver = new InitWebdriver().getDriver("chrome", "false");
        LoginPage = new LoginPage(driver);
        SignupPage = new SignupPage(driver);
        generate = new GenerateData();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
