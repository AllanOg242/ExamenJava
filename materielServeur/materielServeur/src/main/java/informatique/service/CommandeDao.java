package informatique.service;

import informatique.utils.HibernateUtil;
import informatique.model.Commande;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CommandeDao extends UnicastRemoteObject implements ICommande {

    private Session session;
    public CommandeDao() throws RemoteException{
        session = HibernateUtil.getSession();
    }

    @Override
    public void add(Commande commande) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.save(commande);
            t.commit();
        }catch (Exception e){
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Commande find(int id) throws RemoteException {
        return session.find(Commande.class, id);
    }

    @Override
    public void update(Commande commande) throws RemoteException {
        Transaction t = session.getTransaction();
        try
        {
            t.begin();
            session.update(commande);
            t.commit();
        }
        catch (Exception e)
        {
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Commande commande) throws RemoteException{
        Transaction t = session.getTransaction();
        try
        {
            t.begin();
            session.delete(commande);
            t.commit();
        }
        catch (Exception e)
        {
            t.rollback();
            e.printStackTrace();
        }
    }
}
