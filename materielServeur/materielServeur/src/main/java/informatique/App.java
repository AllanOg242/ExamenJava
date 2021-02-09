package informatique;

import informatique.service.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            System.setSecurityManager(new SecurityManager());
            Registry registry = LocateRegistry.createRegistry(5003);

            ICommande iCommande = new CommandeDao();
            registry.bind("commandeRemote", iCommande);

            IFacture iFacture = new FactureDao();
            registry.bind("factureRemote", iFacture);

            IProduit iProduit = new ProduitDao();
            registry.bind("produitRemote", iProduit);

            IProfil iProfil = new ProfilDao();
            registry.bind("profilRemote", iProfil);

            IUser iUser = new UserDao();
            registry.bind("userRemote", iUser);

            System.out.println("Serveur lance sur le port 5003");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
