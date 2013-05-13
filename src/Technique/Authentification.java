package Technique;
import Metier.Agent;
import DAO.AuthentificationDAO;
public final class Authentification
{
    private static Authentification ins;
    private Agent agent;
    
    private Authentification(){}
    
    public void setLoginAgent(Agent loginAgent)
    {
        this.agent = loginAgent;
    }
    
    public Agent getAgent()
    {
        return this.agent;
    }
    
    public static synchronized Authentification getInstance()
    {
        if(ins == null)
        {
            ins = new Authentification();
        }
        return ins;
    }
    
    public boolean Autheticate(String login, String pass)
    {
        Agent a = AuthentificationDAO.getInstance().connect(login, pass);
        if(a != null)
        {
            this.setLoginAgent(a);
            return true;
        }
        else
        {
            return false;
        }
    }
}