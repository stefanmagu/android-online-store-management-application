package com.example.tema2.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = "Utilizatori")
public class Utilizator implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int idUtilizator;
    private String nume;
    private String prenume;
    private String parola;

    public Utilizator(String nume, String prenume, String parola) {
        this.nume = nume;
        this.prenume = prenume;
        this.parola = parola;
    }

    public int getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(int idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "Utilizator{" +
                "idUtilizator=" + idUtilizator +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizator that = (Utilizator) o;
        return Objects.equals(nume, that.nume) &&
                Objects.equals(prenume, that.prenume) &&
                Objects.equals(parola, that.parola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume, parola);
    }
}
