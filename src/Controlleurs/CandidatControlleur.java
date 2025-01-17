/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlleurs;

import Modeles.Candidat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Wulfrid MBONGO
 */
public class CandidatControlleur {

    public static void addcandidat(String cni_cand, String parti_cand, String bulletin, Date date_naiss, String profession, String nom_pers, String prenom_pers, String sexe_pers, String tel_pers, String email_pers, String code_vote) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ElectionManagementPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Candidat c = new Candidat();
            c.setCniCand(cni_cand);
            c.setPartiCand(parti_cand);
            c.setBulletin(bulletin);
            c.setDateNaiss(date_naiss);
            c.setProffession(profession);
            c.setNomPers(nom_pers);
            c.setPrenomPers(prenom_pers);
            c.setSexePers(sexe_pers);
            c.setTelPers(tel_pers);
            c.setEmailPers(email_pers);
            c.setCodeVote(code_vote);
            em.persist(c);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("Erreur lors de l'ajout de l'electeur: " + e.getMessage());
        } finally {
            em.close();
            emf.close();

        }
    }
     public static List<Candidat> get() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ElectionManagementPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            List<Candidat> c = em.createNamedQuery("Candidat.findAll").getResultList();
            transaction.commit();
            return c;
        } catch (Exception e) {
            transaction.rollback();
            return null;
        } finally {
            em.close();
            emf.close();
        }
    }

}
