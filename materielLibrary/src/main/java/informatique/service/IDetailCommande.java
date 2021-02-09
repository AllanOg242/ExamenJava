package informatique.service;

import informatique.model.Commande;
import informatique.model.DetailCommande;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IDetailCommande extends Remote {
    public void add(DetailCommande dt) throws RemoteException;
    public List<DetailCommande> findAll() throws RemoteException;
    public void update(DetailCommande dt) throws RemoteException;
    public void delete(DetailCommande dt) throws RemoteException;
}
