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
@Table(name = "candidat")
@NamedQueries({
    @NamedQuery(name = "Candidat.findAll", query = "SELECT c FROM Candidat c")})
public class Candidat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code_pers")
    private Short codePers;
    @Basic(optional = false)
    @Column(name = "cni_cand")
    private String cniCand;
    @Basic(optional = false)
    @Column(name = "parti_cand")
    private String partiCand;
    @Basic(optional = false)
    @Column(name = "bulletin")
    private String bulletin;
    @Basic(optional = false)
    @Column(name = "date_naiss")
    @Temporal(TemporalType.DATE)
    private Date dateNaiss;
    @Basic(optional = false)
    @Column(name = "proffession")
    private String proffession;
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
    @JoinColumn(name = "code_pers", referencedColumnName = "code_pers", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personne personne;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codePersC")
    private List<Vote> voteList;

    public Candidat() {
    }

    public Candidat(Short codePers) {
        this.codePers = codePers;
    }

    public Candidat(Short codePers, String cniCand, String partiCand, String bulletin, Date dateNaiss, String proffession, String nomPers, String sexePers, String telPers, String emailPers, String codeVote) {
        this.codePers = codePers;
        this.cniCand = cniCand;
        this.partiCand = partiCand;
        this.bulletin = bulletin;
        this.dateNaiss = dateNaiss;
        this.proffession = proffession;
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

    public String getCniCand() {
        return cniCand;
    }

    public void setCniCand(String cniCand) {
        this.cniCand = cniCand;
    }

    public String getPartiCand() {
        return partiCand;
    }

    public void setPartiCand(String partiCand) {
        this.partiCand = partiCand;
    }

    public String getBulletin() {
        return bulletin;
    }

    public void setBulletin(String bulletin) {
        this.bulletin = bulletin;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getProffession() {
        return proffession;
    }

    public void setProffession(String proffession) {
        this.proffession = proffession;
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
        if (!(object instanceof Candidat)) {
            return false;
        }
        Candidat other = (Candidat) object;
        if ((this.codePers == null && other.codePers != null) || (this.codePers != null && !this.codePers.equals(other.codePers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modeles.Candidat[ codePers=" + codePers + " ]";
    }
    
}
