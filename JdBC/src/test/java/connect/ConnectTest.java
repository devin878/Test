package connect;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectTest {


    @Test
    public void test01(){
        try {
           Driver driver = new Driver();
            Properties info = new Properties();
            info.setProperty("user","root");
            info.setProperty("password","123456");
            String url = "jdbc:mysql://localhost:3306";
           Connection connect = driver.connect(url, info);
            System.out.println(connect);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test02() throws SQLException {



        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "123456");
        System.out.println(connect);
        
    }

    @Test
    public void test03() throws Exception {

        InputStream asStream = ConnectTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(asStream);
        System.out.println(asStream);
        String url = properties.getProperty("url");
        System.out.println(url);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
       Connection connect = DriverManager.getConnection(url, user, password);
        System.out.println(connect);
    }
}
