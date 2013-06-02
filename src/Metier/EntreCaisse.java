package Metier;

import java.sql.Date;

public class EntreCaisse
{
    String type, montant, description;
    Agent agent;
    Date date;

    public EntreCaisse(String type, String montant, String description, Agent agent) {
        this.type = type;
        this.montant = montant;
        this.description = description;
        this.agent = agent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
    public String getType() {
        return type;
    }

    public String getMontant() {
        return montant;
    }

    public String getDescription() {
        return description;
    }

    public Agent getAgent() {
        return agent;
    }
    
    
}