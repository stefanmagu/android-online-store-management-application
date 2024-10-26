package com.example.tema2;

import java.io.Serializable;

public class Utilizator implements Serializable {
    private String nume;
    private String prenume;
    private String parola;

    public Utilizator(String nume, String prenume, String parola) {
        this.nume = nume;
        this.prenume = prenume;
        this.parola = parola;
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
}
