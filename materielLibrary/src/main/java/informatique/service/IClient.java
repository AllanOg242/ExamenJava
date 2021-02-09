package informatique.service;

import informatique.model.Client;
import informatique.model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IClient extends Remote {
    public void add(Client cl) throws RemoteException;
    public void delete(Client cl) throws RemoteException;
    public Client find(int id) throws RemoteException;
    public void update(Client cl) throws RemoteException;
    public List<Client> findAll() throws RemoteException;
}
