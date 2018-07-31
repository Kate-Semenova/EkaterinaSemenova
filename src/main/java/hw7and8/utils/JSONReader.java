package hw7and8.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import hw7and8.entities.MetalColor;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ekaterina on 27.06.2018.
 */
public class JSONReader {
    private static JSONReader instance;
    private MetalColor[][] dataFromJSON;
    private Map<String, MetalColor> map = new HashMap<>();

    public final static String FILE_NAME = "src\\test\\resources\\JDI_ex8_metalsColorsDataSet.json";

    private JSONReader() {
        // TODO take a look on TypeToken !
        //WOW THANK YOU
        try {
            JsonElement jsonData = new JsonParser().parse(new FileReader(FILE_NAME));
            Type itemsListType = new TypeToken<Map<String, MetalColor>>() {
            }.getType();
            map = new Gson().fromJson(jsonData, itemsListType);

            dataFromJSON = new MetalColor[map.size()][1];
            int i = 0;
            for (Map.Entry<String, MetalColor> data : map.entrySet()
                    ) {
                dataFromJSON[i][0] = data.getValue();
                i++;
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

    public MetalColor[][] getDataFromJSON() {
        return dataFromJSON;
    }

    public static void main(String[] args) {
        JSONReader jsonReader = new JSONReader();
        System.out.println(jsonReader.map.toString());
        System.out.println(jsonReader.map.get("data_1").getMetals());
        System.out.println(jsonReader.map.get("data_6"));
    }
}
