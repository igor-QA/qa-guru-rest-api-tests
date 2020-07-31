package helpers;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LoadCredentials {

    public static byte[] readBytesFromFile(String filePath) throws Exception {
        File file = new File(filePath);
        try {
            return Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[]{};
    }

    public static String readStringFromFile(String filePath) throws Exception {
        return new String(readBytesFromFile(filePath));
    }

    public static String getCredentialsFromJson(String filePath, String JsonKey) throws Exception {
        JSONObject jsonCredentials = new JSONObject(readStringFromFile(filePath));
        String readCredentials;
        readCredentials = jsonCredentials.getString(JsonKey);

        return readCredentials;
    }

}
