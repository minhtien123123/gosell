package page.signup;

import org.apache.commons.lang.math.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.data.GenerateData;
import utilities.database.InitConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Thread.sleep;
import static utilities.links.Links.*;

public class SignupPage extends SignupVerify {

    public String countryCode;
    public String userLoginDB;
    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public SignupPage navigate() {
        driver.get(DOMAIN + SIGNUP_PATH);
        wait.until(ExpectedConditions.titleIs(SIGNUP_PAGE_TITLE));
        return this;
    }

    public SignupPage selectCountry() {
        int id = RandomUtils.nextInt(250);
        COUNTRY_DROPDOWN.click();
        COUNTRY_LIST.get(id).click();
        countryCode = COUNTRY_CODE.getText();
        return this;
    }

    public SignupPage inputMailOrPhoneNumber(String accountType) {
        String account;
        if (accountType.equals("phone")) {
            account = new GenerateData().generateNumber(10);
        } else {
            account = new GenerateData().generateString(10) + "@nbobd.com";
        }
        userLoginDB = countryCode + ":" + account;
        System.out.println(userLoginDB);
        USERNAME.sendKeys(account);
        return this;
    }

    public SignupPage inputPassword(String password) {
        PASSWORD.sendKeys(password);
        return this;
    }

    public SignupPage clickOnTheSignupBtn() throws InterruptedException {
        SIGNUP_BTN.click();
        sleep(3000);
        return this;
    }

    public SignupPage inputOTPCode() throws SQLException {
        Connection connection = new InitConnection().createConnection();
        String query = "select activation_key from \"gateway-services\".jhi_user ju where login = '" + userLoginDB + "'";
        ResultSet resultSet = connection.prepareStatement(query).executeQuery();
        Integer OTP_CODE = 0;
        while (resultSet.next()) {
            OTP_CODE = resultSet.getInt("activation_key");
            System.out.println(OTP_CODE);
        }
        wait.until(ExpectedConditions.visibilityOf(OTP)).sendKeys(OTP_CODE.toString());
        return this;
    }

    public void clickOnTheConfirmBtn() {
        CONFIRM_OTP.click();
    }
}
