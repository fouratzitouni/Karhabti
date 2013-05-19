package Metier;

import java.sql.Date;

public class Assurance
{
    String numero;
    Date debut, fin;
    float prix;

    public Assurance(String numero, Date debut, Date fin, float prix) {
        this.numero = numero;
        this.debut = debut;
        this.fin = fin;
        this.prix = prix;
    }

    public String getNumero() {
        return numero;
    }



    public Date getDebut() {
        return debut;
    }

    public Date getFin() {
        return fin;
    }

    public float getPrix() {
        return prix;
    }
    
    
}