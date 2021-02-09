package informatique.service;

import informatique.model.Commande;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICommande extends Remote{
    public Commande add(Commande c) throws RemoteException;
    public Commande find(int id) throws RemoteException;
    public void update(Commande c) throws RemoteException;
    public void delete(Commande c) throws RemoteException;
    public String  createNumero() throws RemoteException;
    public List<Commande> findAll() throws RemoteException;
}
