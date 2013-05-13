package Metier;

public class Client
{
    String cin, permi, nom, prenom, adr, email, tel, cat;

    public Client(String cin, String permi, String nom, String prenom, String adr, String tel, String cat) {
        this.cin = cin;
        this.permi = permi;
        this.nom = nom;
        this.prenom = prenom;
        this.adr = adr;
        this.tel = tel;
        this.cat = cat;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }
    
    
    public String getCin() {
        return cin;
    }

    public String getPermi() {
        return permi;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdr() {
        return adr;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String getCat() {
        return cat;
    }
    
    
}