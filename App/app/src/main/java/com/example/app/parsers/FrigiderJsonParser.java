package com.example.app.parsers;

import com.example.app.R;
import com.example.app.models.Frigider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FrigiderJsonParser {

    public static List<Frigider> getfrigidere(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            List<Frigider> frigidere = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String nume = jsonObject.getString("nume");
                float pret = (float) jsonObject.getDouble("pret");
                int canitate = jsonObject.getInt("cantitate");
                Frigider frigider = new Frigider(id, nume, pret, canitate, R.drawable.fridge);

                frigidere.add(frigider);
            }
            return frigidere;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
