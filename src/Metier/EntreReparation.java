package Metier;

import java.sql.Date;

public class EntreReparation
{
    String mat, designation, garage, dure, prix;
    Date date;

    public EntreReparation(String mat, String designation, String garage, Date date, String dure, String prix) {
        this.mat = mat;
        this.designation = designation;
        this.garage = garage;
        this.date = date;
        this.dure = dure;
        this.prix = prix;
    }

    public String getMat() {
        return mat;
    }

    public String getDesignation() {
        return designation;
    }

    public String getGarage() {
        return garage;
    }

    public Date getDate() {
        return date;
    }

    public String getDure() {
        return dure;
    }

    public String getPrix() {
        return prix;
    }
    
    
}