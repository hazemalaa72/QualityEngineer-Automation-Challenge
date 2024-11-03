package utils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
public class JsonDataReader {
    public static List<Object[]> getLoginData(String filePath) {
        List<Object[]> loginData = new ArrayList<>();
        try (FileReader reader = new FileReader(filePath)) {
            JSONArray jsonArray = new JSONArray(new JSONTokener(reader));
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String username = jsonObject.getString("username");
                String password = jsonObject.getString("password");
                String expectedMessage = jsonObject.getString("expectedMessage");
                loginData.add(new Object[]{username, password, expectedMessage});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginData;
    }
}