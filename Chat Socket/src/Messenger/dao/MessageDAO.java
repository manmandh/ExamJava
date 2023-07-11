package Messenger.dao;
import Messenger.database.MyConnection;
import Messenger.model.MessageModel;
import java.sql.*;
import java.util.ArrayList;
public class MessageDAO {
    private static Connection conn = MyConnection.getConnect();

    public static ArrayList<MessageModel> getListMessage() {
        ArrayList<MessageModel> listMessage = new ArrayList<>();
        String sql = "SELECT * FROM message";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MessageModel messageModel = new MessageModel();
                messageModel.setName(rs.getString("name"));
                messageModel.setMessage(rs.getString("message"));
                messageModel.setTime(rs.getString("time"));
                listMessage.add(messageModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMessage;
    }

    public static boolean addMessage(MessageModel messageModel) {
        String sql = "INSERT INTO message(name, message, time) VALUES (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, messageModel.getName());
            ps.setString(2, messageModel.getMessage());
            ps.setString(2, messageModel.getTime());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

