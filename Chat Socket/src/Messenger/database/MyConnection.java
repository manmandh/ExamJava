package Messenger.database;
import java.sql.*;
import static java.sql.DriverManager.getConnection;
public class MyConnection {
    private static Connection conn = null;
    private static String DB_URL = "jdbc:mysql://localhost:3306/chatapp";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    public MyConnection() {
        try {
            conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Connected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static {
        try {
            conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Connected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnect() {
        try {
            conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Connected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
