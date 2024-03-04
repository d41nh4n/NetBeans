package API;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApiCountry {

    public static List<String> countries = new ArrayList<>();

    static {
        String strUrl = "https://countriesnow.space/api/v0.1/countries/currency";

        try {
            URL url = new URL(strUrl);
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is);

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(isr);

            JSONArray dataArray = (JSONArray) jsonObject.get("data");
            for (Object obj : dataArray) {
                JSONObject dataObject = (JSONObject) obj;
                String name = (String) dataObject.get("name");
                countries.add(name);
            }
            is.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
