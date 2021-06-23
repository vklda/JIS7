package homework.jdbc.dbconfig;

import lombok.AllArgsConstructor;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@AllArgsConstructor
public class PostgresConnector {
    private static final Properties properties = new Properties();
    private static final String DATABASE_URL;
    static Connection connection;

    static {
        try {
            properties.load(new FileReader("src\\main\\resources\\datares\\database.properties"));
            String driverName = (String) properties.get("db.driver");
            Class.forName(driverName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        DATABASE_URL = (String) properties.get("db.url");
    }


    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(DATABASE_URL, properties);
        return connection;
    }

    public static Statement getStatement() throws SQLException {
        connection = DriverManager.getConnection(DATABASE_URL, properties);
        return connection.createStatement();
    }

}
