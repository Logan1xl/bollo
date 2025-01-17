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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wulfrid MBONGO
 */
@Entity
@Table(name = "election")
@NamedQueries({
    @NamedQuery(name = "Election.findAll", query = "SELECT e FROM Election e")})
public class Election implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code_election")
    private Short codeElection;
    @Basic(optional = false)
    @Column(name = "label_election")
    private String labelElection;
    @Basic(optional = false)
    @Column(name = "debut")
    @Temporal(TemporalType.DATE)
    private Date debut;
    @Basic(optional = false)
    @Column(name = "fin")
    @Temporal(TemporalType.DATE)
    private Date fin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeElection")
    private List<Vote> voteList;

    public Election() {
    }

    public Election(Short codeElection) {
        this.codeElection = codeElection;
    }

    public Election(Short codeElection, String labelElection, Date debut, Date fin) {
        this.codeElection = codeElection;
        this.labelElection = labelElection;
        this.debut = debut;
        this.fin = fin;
    }

    public Short getCodeElection() {
        return codeElection;
    }

    public void setCodeElection(Short codeElection) {
        this.codeElection = codeElection;
    }

    public String getLabelElection() {
        return labelElection;
    }

    public void setLabelElection(String labelElection) {
        this.labelElection = labelElection;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
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
        hash += (codeElection != null ? codeElection.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Election)) {
            return false;
        }
        Election other = (Election) object;
        if ((this.codeElection == null && other.codeElection != null) || (this.codeElection != null && !this.codeElection.equals(other.codeElection))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modeles.Election[ codeElection=" + codeElection + " ]";
    }
    
}
