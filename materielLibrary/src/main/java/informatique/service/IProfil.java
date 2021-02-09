package informatique.service;

import informatique.model.Profil;
import informatique.model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IProfil extends Remote {
    public void add(Profil p) throws RemoteException;
    public void delete(Profil p) throws RemoteException;
    public Profil find(int id) throws RemoteException;
    public void update(Profil p) throws RemoteException;
    public List<Profil> findAll() throws RemoteException;
}
