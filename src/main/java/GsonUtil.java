import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by saurabh.uttam on 8/29/17.
 */
public class GsonUtil {
    public <T> T readObjectFromJson(String filePath, Class<T> classOfT) throws FileNotFoundException {
        return (new Gson()).fromJson(new FileReader(filePath), classOfT);
    }

    public <T> void writeObjectToJson(T obj, String filePath) throws IOException {
        try (Writer writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(obj, writer);
        }
    }
}
