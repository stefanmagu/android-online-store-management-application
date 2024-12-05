package com.example.tema2.parsers;

import com.example.tema2.R;
import com.example.tema2.models.Laptop;
import com.example.tema2.models.Telefon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LaptopJsonParser {

    public static List<Laptop> getTelefoane(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            List<Laptop> laptopuri = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String nume = jsonObject.getString("nume");
                float pret = (float) jsonObject.getDouble("pret");
                int canitate = jsonObject.getInt("cantitate");
                Laptop laptop = new Laptop(id,nume,pret,canitate, R.drawable.laptop);

                laptopuri.add(laptop);
            }
            return laptopuri;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }
}
