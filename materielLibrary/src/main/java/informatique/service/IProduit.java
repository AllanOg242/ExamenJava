package informatique.service;

import informatique.model.Produit;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IProduit extends Remote {
    public void add(Produit p) throws RemoteException;
    public void delete(Produit p) throws RemoteException;
    public Produit findByPrix(Double prix) throws RemoteException;
    public List<Produit> findAll() throws RemoteException;
}
