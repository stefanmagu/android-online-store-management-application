package com.example.app.models;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(
        tableName = "Recenzii",
        foreignKeys = @ForeignKey(
                entity = Utilizator.class,
                parentColumns = "idUtilizator",
                childColumns = "idUtilizator",
                onDelete = ForeignKey.CASCADE
        )
)
public class Recenzie implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int idRecenzie;
    private String nume;
    private String recenzie;
    private float rating;
    private int idUtilizator;

    public Recenzie(String nume, String recenzie, float rating, int idUtilizator) {
        this.nume = nume;
        this.recenzie = recenzie;
        this.rating = rating;
        this.idUtilizator = idUtilizator;
    }

    public int getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(int idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public int getIdRecenzie() {
        return idRecenzie;
    }

    public void setIdRecenzie(int idRecenzie) {
        this.idRecenzie = idRecenzie;
    }

    public void setRating(float rating) {
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


    @Override
    public String toString() {
        return "Recenzie{" +
                "idRecenzie=" + idRecenzie +
                ", nume='" + nume + '\'' +
                ", recenzie='" + recenzie + '\'' +
                ", rating=" + rating +
                ", idUtilizator=" + idUtilizator +
                '}';
    }

}
