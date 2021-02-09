package informatique.utils;

import informatique.service.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Fabrique {
    private static ICommande iCommande;
    private static IFacture iFacture;
    private static IProduit iProduit;
    private static IProfil iProfil;
    private static IUser iUser;
    private static IDetailCommande iDetailCommande;
    private static IClient iClient;
    private static ITypeClient iTypeClient;

    private static void init() throws Exception{
        try {
            Registry registry = LocateRegistry.getRegistry(5003);
            iCommande = (ICommande) registry.lookup("commandeRemote");
            iFacture = (IFacture) registry.lookup("factureRemote");
            iProduit = (IProduit) registry.lookup("produitRemote");
            iProfil = (IProfil) registry.lookup("profilRemote");
            iUser = (IUser) registry.lookup("userRemote");
            iDetailCommande = (IDetailCommande) registry.lookup("detailCommandeRemote");
            iClient = (IClient) registry.lookup("clientRemote");
            iTypeClient = (ITypeClient) registry.lookup("typeClientRemote");
        }
        catch(Exception e){
            throw e;
        }
    }

    public static ICommande getiCommande() throws  Exception{
        try {
            if(iCommande == null) {
                init();
            }
            return iCommande;
        }
        catch(Exception e){
            throw e;
        }
    }

    public static IFacture getiFacture() throws  Exception{
        try {
            if(iFacture == null) {
                init();
            }
            return iFacture;
        }
        catch(Exception e){
            throw e;
        }
    }

    public static IProduit getiProduit() throws  Exception{
        try {
            if(iProduit == null) {
                init();
            }
            return iProduit;
        }
        catch(Exception e){
            throw e;
        }
    }

    public static IProfil getiProfil() throws  Exception{
        try {
            if(iProfil == null) {
                init();
            }
            return iProfil;
        }
        catch(Exception e){
            throw e;
        }
    }

    public static IUser getiUser() throws  Exception{
        try {
            if(iUser == null) {
                init();
            }
            return iUser;
        }
        catch(Exception e){
            throw e;
        }
    }

    public static IDetailCommande getiDetailCommande() throws  Exception{
        try {
            if(iDetailCommande == null) {
                init();
            }
            return iDetailCommande;
        }
        catch(Exception e){
            throw e;
        }
    }

    public static IClient getiClient() throws  Exception{
        try {
            if(iClient == null) {
                init();
            }
            return iClient;
        }
        catch(Exception e){
            throw e;
        }
    }

    public static ITypeClient getiTypeClient() throws  Exception{
        try {
            if(iTypeClient == null) {
                init();
            }
            return iTypeClient;
        }
        catch(Exception e){
            throw e;
        }
    }

}
