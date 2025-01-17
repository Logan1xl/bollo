/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlleurs;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Wulfrid MBONGO
 */
public class ConnexionControlleur {

    public static Object login(String code) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ElectionManagementPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            List<Object> admins = em.createQuery("SELECT a FROM Admin a WHERE a.codeAccess = :codeA")
                    .setParameter("codeA", code)
                    .getResultList();

            if (!admins.isEmpty()) {
                return admins.get(0);
            }
            List<Object> electeur = em.createQuery("SELECT e FROM Electeur e WHERE e.codeVote = :codeE ")
                    .setParameter("codeE", code)
                    .getResultList();
            if (!electeur.isEmpty()) {
                return electeur.get(0);
            }
            List<Object> candidats = em.createQuery("SELECT c FROM Candidat c  WHERE c.codeVote  =: codeA ").setParameter("codeA", code).getResultList();
            if (!candidats.isEmpty()) {
                return candidats.get(0);

            }
            transaction.commit();
            return null;

        } catch (Exception E) {
            transaction.rollback();
            return null;
        } finally {
            em.close();
            emf.close();
        }
    }
}
