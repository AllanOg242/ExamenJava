package informatique.service;

import informatique.utils.HibernateUtil;
import informatique.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UserDao extends UnicastRemoteObject implements IUser {

    private Session session;
    public UserDao() throws RemoteException{
        session = HibernateUtil.getSession();
    }

    @Override
    public void add(User user) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.save(user);
            t.commit();
        }catch (Exception e){
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) throws RemoteException {
        Transaction t = session.getTransaction();
        try
        {
            t.begin();
            session.remove(user);
            t.commit();
        }
        catch (Exception e)
        {
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public User find(int id) throws RemoteException {
        return session.find(User.class, id);
    }

    @Override
    public void update(User user) throws RemoteException {
        Transaction t = session.getTransaction();
        try
        {
            t.begin();
            session.update(user);
            t.commit();
        }
        catch (Exception e)
        {
            t.rollback();
            e.printStackTrace();
        }
    }
}
