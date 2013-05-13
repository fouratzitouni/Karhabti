package Metier;

public class Parc
{
    String mat, etat;
    boolean dispo;

    public Parc(String mat, String etat, boolean dispo) {
        this.mat = mat;
        this.etat = etat;
        this.dispo = dispo;
    }

    public String getMat() {
        return mat;
    }

    public String getEtat() {
        return etat;
    }

    public boolean isDispo() {
        return dispo;
    }
    
    
}