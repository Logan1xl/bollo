/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlleurs;

import Modeles.Vote;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Wulfrid MBONGO
 */
public class VoteControlleur {

    public static void save(int Code) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ElectionManagementPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Vote v = new Vote();
            v.setCodeVote(Code);
            transaction.commit();

        } catch (Exception e) {
            System.err.println("Une erreur s'est produite" + e.getMessage());
        } finally {
            em.close();
            emf.close();

        }
    }

    public static List<Object> select(String bulletin) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ElectionManagementPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            List<Object> ob = em.createNamedQuery(" SELECT  nom_pers,prenom_pers,bulletin from candidat where bulletin = :codec").setParameter("codec", bulletin).getResultList();
            transaction.commit();
            return ob;
        } catch (Exception e) {
            System.err.println("Erreur lors de la selection");
            return null;
        } finally {
            em.close();
            emf.close();
        }

    }

}
