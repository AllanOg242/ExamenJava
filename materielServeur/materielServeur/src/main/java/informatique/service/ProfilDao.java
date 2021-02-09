package informatique.service;

import informatique.utils.HibernateUtil;
import informatique.model.Profil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ProfilDao extends UnicastRemoteObject implements IProfil {

    private Session session;
    public ProfilDao() throws RemoteException{
        session = HibernateUtil.getSession();
    }

    @Override
    public void add(Profil profil) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.save(profil);
            t.commit();
        }catch (Exception e){
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Profil profil) throws RemoteException {
        Transaction t = session.getTransaction();
        try
        {
            t.begin();
            session.remove(profil);
            t.commit();
        }
        catch (Exception e)
        {
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Profil find(int id) throws RemoteException {
        return session.find(Profil.class, id);
    }

    @Override
    public void update(Profil profil) throws RemoteException {
        Transaction t = session.getTransaction();
        try
        {
            t.begin();
            session.update(profil);
            t.commit();
        }
        catch (Exception e)
        {
            t.rollback();
            e.printStackTrace();
        }
    }
}
