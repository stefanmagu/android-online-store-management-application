package com.example.tema2.models;

import java.io.Serializable;

public class Recenzie implements Serializable {
    private String nume;
    private String recenzie;
    private float rating;

    public Recenzie(String nume, String recenzie, float rating) {
        this.nume = nume;
        this.recenzie = recenzie;
        this.rating = rating;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getRecenzie() {
        return recenzie;
    }

    public void setRecenzie(String recenzie) {
        this.recenzie = recenzie;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Recenzie{" +
                "nume='" + nume + '\'' +
                ", recenzie='" + recenzie + '\'' +
                ", rating=" + rating +
                '}';
    }
}
