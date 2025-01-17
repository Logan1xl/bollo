/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modeles;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Wulfrid MBONGO
 */
@Entity
@Table(name = "personne")
@NamedQueries({
    @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p")})
public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code_pers")
    private Short codePers;
    @Basic(optional = false)
    @Column(name = "nom_pers")
    private String nomPers;
    @Column(name = "prenom_pers")
    private String prenomPers;
    @Basic(optional = false)
    @Column(name = "sexe_pers")
    private String sexePers;
    @Basic(optional = false)
    @Column(name = "tel_pers")
    private String telPers;
    @Basic(optional = false)
    @Column(name = "email_pers")
    private String emailPers;
    @Basic(optional = false)
    @Column(name = "code_vote")
    private String codeVote;
    @JoinColumn(name = "code_region", referencedColumnName = "code_region")
    @ManyToOne(optional = false)
    private Region codeRegion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personne")
    private Admin admin;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personne")
    private Electeur electeur;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personne")
    private Candidat candidat;

    public Personne() {
    }

    public Personne(Short codePers) {
        this.codePers = codePers;
    }

    public Personne(Short codePers, String nomPers, String sexePers, String telPers, String emailPers, String codeVote) {
        this.codePers = codePers;
        this.nomPers = nomPers;
        this.sexePers = sexePers;
        this.telPers = telPers;
        this.emailPers = emailPers;
        this.codeVote = codeVote;
    }

    public Short getCodePers() {
        return codePers;
    }

    public void setCodePers(Short codePers) {
        this.codePers = codePers;
    }

    public String getNomPers() {
        return nomPers;
    }

    public void setNomPers(String nomPers) {
        this.nomPers = nomPers;
    }

    public String getPrenomPers() {
        return prenomPers;
    }

    public void setPrenomPers(String prenomPers) {
        this.prenomPers = prenomPers;
    }

    public String getSexePers() {
        return sexePers;
    }

    public void setSexePers(String sexePers) {
        this.sexePers = sexePers;
    }

    public String getTelPers() {
        return telPers;
    }

    public void setTelPers(String telPers) {
        this.telPers = telPers;
    }

    public String getEmailPers() {
        return emailPers;
    }

    public void setEmailPers(String emailPers) {
        this.emailPers = emailPers;
    }

    public String getCodeVote() {
        return codeVote;
    }

    public void setCodeVote(String codeVote) {
        this.codeVote = codeVote;
    }

    public Region getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(Region codeRegion) {
        this.codeRegion = codeRegion;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Electeur getElecteur() {
        return electeur;
    }

    public void setElecteur(Electeur electeur) {
        this.electeur = electeur;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codePers != null ? codePers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.codePers == null && other.codePers != null) || (this.codePers != null && !this.codePers.equals(other.codePers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modeles.Personne[ codePers=" + codePers + " ]";
    }
    
}
