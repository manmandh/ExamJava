package Messenger.json;
import Messenger.model.UserModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class JsonData {
    public static ArrayList<UserModel> readJson() {

        Gson gson = new Gson();
        String jsonStr;

        try {
            jsonStr = new String(Files.readAllBytes(Paths.get("output.json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return gson.fromJson(jsonStr, new TypeToken<ArrayList<UserModel>>(){}.getType());
    }

    public static void writeJson(ArrayList<UserModel> listUser) {

        Gson gson = new Gson();

        listUser.add(new UserModel("Admin", "admin", "123", "user.png"));
        listUser.add(new UserModel("Chung", "chung", "123", "chung.jpg"));
        listUser.add(new UserModel("Định", "dinh", "123", "dinh.jpg"));
        listUser.add(new UserModel("Kỳ Lân", "kyanh", "123", "kyanh.jpg"));
        listUser.add(new UserModel("Duck", "duc", "123", "duc.jpg"));

        String listJson = gson.toJson(listUser);

        try {
            Files.write(Paths.get("output.json"), listJson.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        writeJson(new ArrayList<>());
    }
}
