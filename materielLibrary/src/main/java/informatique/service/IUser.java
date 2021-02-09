package informatique.service;

import informatique.model.Commande;
import informatique.model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IUser extends Remote {
    public void add(User u) throws RemoteException;
    public void delete(User u) throws RemoteException;
    public User find(int id) throws RemoteException;
    public void update(User u) throws RemoteException;
    public List<User> findAll() throws RemoteException;
    public abstract User getUser(String login, String mdp) throws RemoteException;
}
