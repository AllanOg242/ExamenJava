package informatique.service;

import informatique.utils.HibernateUtil;
import informatique.model.Produit;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ProduitDao extends UnicastRemoteObject implements IProduit {

    private Session session;
    public ProduitDao() throws RemoteException{
        session = HibernateUtil.getSession();
    }

    @Override
    public void add(Produit produit) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.save(produit);
            t.commit();
        }catch (Exception e){
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Produit produit) throws RemoteException {
        Transaction t = session.getTransaction();
        try
        {
            t.begin();
            session.remove(produit);
            t.commit();
        }
        catch (Exception e)
        {
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Produit findByPrix(Double prix) throws RemoteException {
        try {
            return session.createQuery("SELECT p FROM Produit p WHERE p.prix = :prix", Produit.class)
                    .setParameter("prix", prix)
                    .getSingleResult();
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public List<Produit> findAll() throws RemoteException {
        return session.createQuery("SELECT p FROM Produit p", Produit.class).list();
    }
}
