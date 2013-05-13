package Metier;

public class Assurance
{
    String numero, debut, fin;
    float prix;

    public Assurance(String numero, String debut, String fin, float prix) {
        this.numero = numero;
        this.debut = debut;
        this.fin = fin;
        this.prix = prix;
    }

    public String getNumero() {
        return numero;
    }



    public String getDebut() {
        return debut;
    }

    public String getFin() {
        return fin;
    }

    public float getPrix() {
        return prix;
    }
    
    
}