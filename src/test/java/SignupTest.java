import org.testng.annotations.Test;

import java.sql.SQLException;

public class SignupTest extends BaseTest{

    @Test
    public void test() throws SQLException, InterruptedException {
        SignupPage.navigate()
                .selectCountry()
                .inputMailOrPhoneNumber("phone")
                .inputPassword("Abc@12345")
                .clickOnTheSignupBtn()
                .inputOTPCode()
                .clickOnTheConfirmBtn();
    }
}
