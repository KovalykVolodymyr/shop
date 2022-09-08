package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Bying;
import util.HibernateUtil;

public class ShopingDao {

    public void savePurchase(Bying purchase) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(purchase);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Update Bying
     * 
     * @param Bying
     */
    public void updatePurchase(Bying purchase) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(purchase);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete Bying
     * 
     * @param id
     */
    public void deletePurchase(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a Bying object
            Bying purchase = session.get(Bying.class, id);
            if (purchase != null) {
                session.delete(purchase);
                System.out.println("Bying is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get Bying By ID
     * 
     * @param id
     * @return
     */
    public Bying getPurchase(int id) {

        Transaction transaction = null;
        Bying purchase = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an Bying object
            purchase = session.get(Bying.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return purchase;
    }

    /**
     * Get all Purchases
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Bying> getAllPurchase() {

        Transaction transaction = null;
        List<Bying> listOfPurchase = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an Bying object

            listOfPurchase = session.createQuery("from Bying").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfPurchase;
    }
}