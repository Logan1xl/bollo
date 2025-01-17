/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modeles;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wulfrid MBONGO
 */
@Entity
@Table(name = "vote")
@NamedQueries({
    @NamedQuery(name = "Vote.findAll", query = "SELECT v FROM Vote v")})
public class Vote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "date_vote")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateVote;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code_vote")
    private Integer codeVote;
    @JoinColumn(name = "code_pers_c", referencedColumnName = "code_pers")
    @ManyToOne(optional = false)
    private Candidat codePersC;
    @JoinColumn(name = "code_pers_e", referencedColumnName = "code_pers")
    @ManyToOne(optional = false)
    private Electeur codePersE;
    @JoinColumn(name = "code_election", referencedColumnName = "code_election")
    @ManyToOne(optional = false)
    private Election codeElection;

    public Vote() {
    }

    public Vote(Integer codeVote) {
        this.codeVote = codeVote;
    }

    public Vote(Integer codeVote, Date dateVote) {
        this.codeVote = codeVote;
        this.dateVote = dateVote;
    }

    public Date getDateVote() {
        return dateVote;
    }

    public void setDateVote(Date dateVote) {
        this.dateVote = dateVote;
    }

    public Integer getCodeVote() {
        return codeVote;
    }

    public void setCodeVote(Integer codeVote) {
        this.codeVote = codeVote;
    }

    public Candidat getCodePersC() {
        return codePersC;
    }

    public void setCodePersC(Candidat codePersC) {
        this.codePersC = codePersC;
    }

    public Electeur getCodePersE() {
        return codePersE;
    }

    public void setCodePersE(Electeur codePersE) {
        this.codePersE = codePersE;
    }

    public Election getCodeElection() {
        return codeElection;
    }

    public void setCodeElection(Election codeElection) {
        this.codeElection = codeElection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeVote != null ? codeVote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vote)) {
            return false;
        }
        Vote other = (Vote) object;
        if ((this.codeVote == null && other.codeVote != null) || (this.codeVote != null && !this.codeVote.equals(other.codeVote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modeles.Vote[ codeVote=" + codeVote + " ]";
    }
    
}
