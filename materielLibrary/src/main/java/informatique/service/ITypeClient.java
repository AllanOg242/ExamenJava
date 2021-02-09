package informatique.service;

import informatique.model.TypeClient;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ITypeClient extends Remote {

    public List<TypeClient> findAll() throws RemoteException;
}
