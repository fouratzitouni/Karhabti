package Metier;

public class Chauffeur
{
    String nom, prenom, permis, tel, email;
    float prix;

    public Chauffeur(String nom, String prenom, String permis, String tel, float prix) {
        this.nom = nom;
        this.prenom = prenom;
        this.permis = permis;
        this.tel = tel;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPermis() {
        return permis;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public float getPrix() {
        return prix;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPermis(String permis) {
        this.permis = permis;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    
    
}