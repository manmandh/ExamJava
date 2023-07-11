package Messenger.dao;
import Messenger.database.MyConnection;
import Messenger.model.UserModel;
import java.sql.*;
import java.util.ArrayList;
public class UserDAO {
    private static Connection conn = MyConnection.getConnect();

    public static ArrayList<UserModel> getListUser() {
        ArrayList<UserModel> listUser = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserModel userModel = new UserModel();
                userModel.setName(rs.getString("name"));
                userModel.setUsername(rs.getString("username"));
                userModel.setPassword(rs.getString("password"));
                listUser.add(userModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUser;
    }

    public static boolean addUser(UserModel userModel) {
        String sql = "INSERT INTO user(name, username, password, img) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userModel.getName());
            ps.setString(2, userModel.getUsername());
            ps.setString(3, userModel.getPassword());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
