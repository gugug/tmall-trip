package www.gdufs.tmall.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by gu on 2017/10/14.
 */
public class DBUtil {

    public static Logger logger = LoggerFactory.getLogger(DBUtil.class);

    static String ip = "127.0.0.1";
    static int port = 3306;
    static String database = "tmall";
    static String encoding = "UTF-8";
    static String loginName = "root";
    static String password = "";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        return DriverManager.getConnection(url,loginName,password);
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());

    }

}
