package com.example.tema2.parsers;

import com.example.tema2.R;
import com.example.tema2.models.Telefon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TelefonJsonParser {

    public static List<Telefon> getTelefoane(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            List<Telefon> telefoane = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String nume = jsonObject.getString("nume");
                float pret = (float) jsonObject.getDouble("pret");
                int canitate = jsonObject.getInt("cantitate");
                Telefon telefon = new Telefon(id,nume,pret,canitate, R.drawable.smartphone);

                telefoane.add(telefon);
            }

            return telefoane;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }
}
