package Metier;

public class EntreCaisse
{
    String type, montant, description;
    Agent agent;

    public EntreCaisse(String type, String montant, String description, Agent agent) {
        this.type = type;
        this.montant = montant;
        this.description = description;
        this.agent = agent;
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