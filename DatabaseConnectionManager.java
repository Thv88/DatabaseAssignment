import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private final String HOST;
    private final String USERNAME;
    private final String PASSWORD;
    private final String DATABASENAME;

    public DatabaseConnectionManager() throws IOException
    {
            InputStream input = new FileInputStream("src/main/resources/aplication.properties");
            Properties prop = new Properties();
            prop.load(input);
            this.HOST = prop.getProperty("db.host");
            this.DATABASENAME = prop.getProperty("db.databasename");
            this.USERNAME = prop.getProperty("db.username");
            this.PASSWORD = prop.getProperty("db.password");
    }

    public Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(HOST + DATABASENAME, USERNAME, PASSWORD);

    }
}
