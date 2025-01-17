/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modeles;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wulfrid MBONGO
 */
@Entity
@Table(name = "electeur")
@NamedQueries({
    @NamedQuery(name = "Electeur.findAll", query = "SELECT e FROM Electeur e")})
public class Electeur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code_pers")
    private Short codePers;
    @Basic(optional = false)
    @Column(name = "cni_electeur")
    private String cniElecteur;
    @Basic(optional = false)
    @Column(name = "date_naiss")
    @Temporal(TemporalType.DATE)
    private Date dateNaiss;
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
    @JoinColumn(name = "code_bureau", referencedColumnName = "code_bureau")
    @ManyToOne(optional = false)
    private Bureau codeBureau;
    @JoinColumn(name = "code_pers", referencedColumnName = "code_pers", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personne personne;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codePersE")
    private List<Vote> voteList;

    public Electeur() {
    }

    public Electeur(Short codePers) {
        this.codePers = codePers;
    }

    public Electeur(Short codePers, String cniElecteur, Date dateNaiss, String nomPers, String sexePers, String telPers, String emailPers, String codeVote) {
        this.codePers = codePers;
        this.cniElecteur = cniElecteur;
        this.dateNaiss = dateNaiss;
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

    public String getCniElecteur() {
        return cniElecteur;
    }

    public void setCniElecteur(String cniElecteur) {
        this.cniElecteur = cniElecteur;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
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

    public Bureau getCodeBureau() {
        return codeBureau;
    }

    public void setCodeBureau(Bureau codeBureau) {
        this.codeBureau = codeBureau;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    public void setVoteList(List<Vote> voteList) {
        this.voteList = voteList;
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
        if (!(object instanceof Electeur)) {
            return false;
        }
        Electeur other = (Electeur) object;
        if ((this.codePers == null && other.codePers != null) || (this.codePers != null && !this.codePers.equals(other.codePers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modeles.Electeur[ codePers=" + codePers + " ]";
    }

}
