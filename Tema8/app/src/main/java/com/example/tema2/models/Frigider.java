package com.example.tema2.models;

public class Frigider {
    private int id;
    private String nume;
    private float pret;
    private int cantitate;
    private int imageResourceId;

    public Frigider(int id, String nume, float pret, int cantitate, int imageResourceId) {
        this.id = id;
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
        this.imageResourceId = imageResourceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    @Override
    public String toString() {
        return "Frigider{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", pret=" + pret +
                ", cantitate=" + cantitate +
                ", imageResourceId=" + imageResourceId +
                '}';
    }

}
