/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlleurs;

import Modeles.Region;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Wulfrid MBONGO
 */
public class RegionControlleur {

    public static List<Region> get() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ElectionManagementPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            List<Region> regions = em.createNamedQuery("Region.findAll").getResultList();
            transaction.commit();
            return regions;
        } catch (Exception e) {
            transaction.rollback();
            return null;
        } finally {
            em.close();
            emf.close();
        }
    }
    public static int save(String label){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ElectionManagementPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
           em.persist(new Region(label));
            transaction.commit();
            return 1;

        } catch (Exception e) {
            transaction.rollback();
           System.out.println("Erreur lors de l'ajout de la region: "+ e.getMessage());
           return 0;
        } finally {
            em.close();
            emf.close();
        }
        
    }

}
