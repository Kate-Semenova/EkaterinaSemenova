package hw7and81.utils;


import com.google.gson.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

/**
 * Created by Ekaterina on 27.06.2018.
 */
public class JSONReader {
    private static JSONReader instance;
    private Object[][] dataFromJSON;

    public final static String FILE_NAME = "src\\test\\resources\\JDI_ex8_metalsColorsDataSet.json";

    private JSONReader() {
        try {
            JsonElement jsonData = new JsonParser().parse(new FileReader(FILE_NAME));
            JsonObject jsonObject = jsonData.getAsJsonObject();
            Set<String> dataNameSet = jsonData.getAsJsonObject().keySet();
            dataFromJSON = new Object[dataNameSet.size()][1];
            int index = 0;
            for (String data : dataNameSet
                    ) {
                Gson gson = new GsonBuilder().create();
                TestingData testingData = gson.fromJson(jsonObject.get(data).toString(), TestingData.class);
                dataFromJSON[index][0] = testingData;
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized JSONReader getInstance() {
        if (instance == null) {
            instance = new JSONReader();
        }
        return instance;
    }

    public Object[][] getDataFromJSON() {
        return dataFromJSON;
    }
}
