package Metier;

import java.sql.Date;

public class Contrat
{
    Date debut, fin;
    Agent agent;
    Client client1, client2;
    Voiture v;
    int chauffeur;

    public Contrat(Date debut, Date fin, Agent agent, Client client1, Voiture v) {
        this.debut = debut;
        this.fin = fin;
        this.agent = agent;
        this.client1 = client1;
        this.v = v;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Client getClient1() {
        return client1;
    }

    public void setClient1(Client client1) {
        this.client1 = client1;
    }

    public Client getClient2() {
        return client2;
    }

    public void setClient2(Client client2) {
        this.client2 = client2;
    }

    public Voiture getV() {
        return v;
    }

    public void setV(Voiture v) {
        this.v = v;
    }

    public int getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(int chauffeur) {
        this.chauffeur = chauffeur;
    }

    
    
    
}