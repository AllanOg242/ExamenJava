package informatique.service;

import informatique.model.Facture;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFacture extends Remote {
    public void add(Facture f) throws RemoteException;
    public Facture find(int id) throws RemoteException;
    public void update(Facture f) throws RemoteException;
    public void delete(Facture f) throws RemoteException;
}
