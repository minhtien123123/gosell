package utilities.database;

import org.testng.annotations.Test;

import java.sql.*;

import static utilities.account.AccountTest.*;

public class InitConnection {
    public java.sql.Connection createConnection() throws SQLException {
        String connectionUrl = "jdbc:postgresql://%s:%s/%s?user=%s&password=%s&loginTimeout=30".formatted(DB_HOST, DB_PORT, DB_DATABASE, DB_USER, DB_PASS);
        return DriverManager.getConnection(connectionUrl);
    }


    @Test
    public void test() throws SQLException {
        java.sql.Connection connection = createConnection();
        String query = "select activation_key from \"gateway-services\".jhi_user ju where login = '+500:8942531099'";
        ResultSet resultSet = connection.prepareStatement(query).executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("activation_key"));
        }

    }
}
