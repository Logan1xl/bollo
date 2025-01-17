/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modeles;

import java.io.Serializable;
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

/**
 *
 * @author Wulfrid MBONGO
 */
@Entity
@Table(name = "region")
@NamedQueries({
    @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r")})
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code_region")
    private Integer codeRegion;
    @Basic(optional = false)
    @Column(name = "label_region")
    private String labelRegion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeRegion")
    private List<Personne> personneList;

    public Region() {
    }

    public Region(Integer codeRegion) {
        this.codeRegion = codeRegion;
    }

    public Region(Integer codeRegion, String labelRegion) {
        this.codeRegion = codeRegion;
        this.labelRegion = labelRegion;
    }

    public Region(String labelRegion) {

        this.labelRegion = labelRegion;
    }

    public Integer getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(Integer codeRegion) {
        this.codeRegion = codeRegion;
    }

    public String getLabelRegion() {
        return labelRegion;
    }

    public void setLabelRegion(String labelRegion) {
        this.labelRegion = labelRegion;
    }

    public List<Personne> getPersonneList() {
        return personneList;
    }

    public void setPersonneList(List<Personne> personneList) {
        this.personneList = personneList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeRegion != null ? codeRegion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.codeRegion == null && other.codeRegion != null) || (this.codeRegion != null && !this.codeRegion.equals(other.codeRegion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modeles.Region[ codeRegion=" + codeRegion + " ]";
    }

}
