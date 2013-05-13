package Metier;

public class Agent
{
    String nom, prenom, login, pass, tel;
    int id;

    public Agent(String nom, String prenom, String login, String tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.tel = tel;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public String getTel() {
        return tel;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}