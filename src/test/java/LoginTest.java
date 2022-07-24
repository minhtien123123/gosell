import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.account.AccountTest.*;
import static utilities.message.Message.*;

public class LoginTest extends BaseTest {

    @Test
    public void Tc01_VerifyThatCanLoginWithValidPhoneNumberAccount() {
        LoginPage.navigate()
        .fillOutLoginForm(PHONE, PASSWORD);
    }

    @Test
    public void Tc02_VerifyThatCanLoginWithValidMailAccount() {
        LoginPage.navigate()
        .fillOutLoginForm(MAIL, PASSWORD);
    }

    @Test
    public void Tcs03_VerifyThatErrorMessageShouldBeShownCorrectlyWhenLeaveAllBlank() {
        LoginPage.navigate()
        .fillOutLoginForm("", "")
        .verifyEmailOrPhoneNumberError(BLANK_ERROR_MESSAGE)
        .verifyPasswordError(BLANK_ERROR_MESSAGE)
        .completeVerify();
    }

    @Test
    public void Tcs04_VerifyThatErrorMessageShouldBeShownCorrectlyWhenInputInvalidPhoneFormat() {
        LoginPage.navigate()
        .fillOutLoginForm("123", PASSWORD)
        .verifyEmailOrPhoneNumberError(INVALID_PHONE_ERROR_MESSAGE)
        .completeVerify();
    }

    @Test
    public void Tcs05_VerifyThatErrorMessageShouldBeShownCorrectlyWhenInputInvalidMailFormat() {
        LoginPage.navigate()
        .fillOutLoginForm("abc", PASSWORD)
        .verifyEmailOrPhoneNumberError(INVALID_MAIL_ERROR_MESSAGE)
        .completeVerify();
    }

    @Test
    public void Tcs06_VerifyThatErrorMessageShouldBeShownCorrectlyWhenInputInValidPhoneAccount() {
        LoginPage.navigate()
        .fillOutLoginForm(generate.generateString(140) + "@nbobd.com", PASSWORD)
        .verifyEmailOrPasswordIncorrectError(INVALID_MAIL_OR_PASSWORD_ERROR)
        .completeVerify();
    }

    @Test
    public void Tcs07_VerifyThatErrorMessageShouldBeShownCorrectlyWhenInputInValidEmailAccount() {
        LoginPage.navigate()
        .fillOutLoginForm(generate.generateNumber(13), PASSWORD)
        .verifyEmailOrPasswordIncorrectError(INVALID_MAIL_OR_PASSWORD_ERROR)
        .completeVerify();
    }
}
