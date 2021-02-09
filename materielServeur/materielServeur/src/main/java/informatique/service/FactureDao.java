package informatique.service;

import informatique.utils.HibernateUtil;
import informatique.model.Facture;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FactureDao extends UnicastRemoteObject implements IFacture {

    private Session session;
    public FactureDao() throws RemoteException{
        session = HibernateUtil.getSession();
    }

    @Override
    public void add(Facture facture) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.save(facture);
            t.commit();
        }catch (Exception e){
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Facture find(int id) throws RemoteException {
        return session.find(Facture.class, id);
    }

    @Override
    public void update(Facture facture) throws RemoteException {
        Transaction t = session.getTransaction();
        try
        {
            t.begin();
            session.update(facture);
            t.commit();
        }
        catch (Exception e)
        {
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Facture facture) throws RemoteException {
        Transaction t = session.getTransaction();
        try
        {
            t.begin();
            session.remove(facture);
            t.commit();
        }
        catch (Exception e)
        {
            t.rollback();
            e.printStackTrace();
        }
    }
}
