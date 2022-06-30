package data;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class DataManager {

    private static DataManager manager;
    private String rankingPath = "rankings.json";

    private DataManager() {

    }

    public static DataManager getInstance() {
        if (manager == null) {
            manager = new DataManager();
        }

        return manager;
    }

    public void addToRanking(String name, float time) {
        try {
            ArrayList<PersonData> persons = getRankings();

            boolean inserted = false;
            for (PersonData pd: persons) {
                if (pd.getName().equalsIgnoreCase(name) && pd.getTime() > time) {
                    pd.setTime(time);
                    inserted = true;
                    break;
                }
            }

            if (!inserted) {
                persons.add(new PersonData(name, time));
            }


            JSONObject jo = new JSONObject();

            JSONArray array = new JSONArray();

            Map<String, String> m = new LinkedHashMap<>();
            for (PersonData p : persons) {
                m.put(p.getName(), "" + p.getTime());
            }
            array.add(m);
            jo.put("persons", array);

            PrintWriter pw = new PrintWriter(rankingPath);
            pw.write(jo.toJSONString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PersonData> getRankings() {
        ArrayList<PersonData> data = new ArrayList<>();
        try {
            Object obj = new JSONParser().parse(new FileReader(rankingPath));
            JSONObject jo = (JSONObject) obj;

            JSONArray ja = (JSONArray) (jo.get("persons"));

            // iterating phoneNumbers
            Iterator itr2 = ja.iterator();
            Iterator<Map.Entry> itr1;
            while (itr2.hasNext()) {
                itr1 = ((Map) itr2.next()).entrySet().iterator();
                while (itr1.hasNext()) {
                    Map.Entry pair = itr1.next();
                    data.add(new data.PersonData((String) pair.getKey(), Float.valueOf((String) pair.getValue()).floatValue()));
                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return data;
    }

}
