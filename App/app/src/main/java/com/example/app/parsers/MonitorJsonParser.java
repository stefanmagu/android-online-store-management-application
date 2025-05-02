package com.example.app.parsers;

import com.example.app.R;
import com.example.app.models.Monitor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MonitorJsonParser {
    public static List<Monitor> getMonitoare(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            List<Monitor> monitoare = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String nume = jsonObject.getString("nume");
                float pret = (float) jsonObject.getDouble("pret");
                int canitate = jsonObject.getInt("cantitate");
                Monitor monitor = new Monitor(id, nume, pret, canitate, R.drawable.monitor);

                monitoare.add(monitor);
            }
            return monitoare;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
