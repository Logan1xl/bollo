/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlleurs;

import Modeles.Bureau;
import Modeles.Electeur;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Wulfrid MBONGO
 */
public class ElecteurControlleur {

    public static void addelecteur(Bureau code_bureau, String cni_electeur,String code_vote ,Date date_naiss, String nom_pers, String prenom_pers, String sexe_pers, String tel_pers, String email_pers) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ElectionManagementPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Electeur electeur = new Electeur();
            electeur.setCodeBureau(code_bureau);
            electeur.setCniElecteur(cni_electeur);
            electeur.setCodeVote(code_vote);
            electeur.setDateNaiss(date_naiss);
            electeur.setNomPers(nom_pers);
            electeur.setPrenomPers(prenom_pers);
            electeur.setSexePers(sexe_pers);
            electeur.setTelPers(tel_pers);
            electeur.setEmailPers(email_pers);
            em.persist(electeur);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
           System.out.println("Erreur lors de l'ajout de l'electeur: "+ e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
    

 
}
