package Metier;

import java.io.File;

public class Voiture
{
    String mat;
    String marque;
    String model;
    String carburant;
    String puiss;
    String couleur;
    String police;
    float tarif;
    float caution;
    File image;

    public Voiture(String mat, String marque, String model, String carburant, String puiss, String couleur, String police, float tarif, float caution, File image) {
        this.mat = mat;
        this.marque = marque;
        this.model = model;
        this.carburant = carburant;
        this.puiss = puiss;
        this.couleur = couleur;
        this.police = police;
        this.tarif = tarif;
        this.caution = caution;
        this.image = image;
    }

    public String getMat() {
        return mat;
    }

    public String getMarque() {
        return marque;
    }

    public String getModel() {
        return model;
    }

    public String getCarburant() {
        return carburant;
    }

    public String getPuiss() {
        return puiss;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getPolice() {
        return police;
    }

    public float getTarif() {
        return tarif;
    }

    public float getCaution() {
        return caution;
    }

    public File getImage() {
        return image;
    }
    
    
}