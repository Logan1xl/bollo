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
@Table(name = "bureau")
@NamedQueries({
    @NamedQuery(name = "Bureau.findAll", query = "SELECT b FROM Bureau b")})
public class Bureau implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code_bureau")
    private Short codeBureau;
    @Basic(optional = false)
    @Column(name = "label_bureau")
    private String labelBureau;
    @Column(name = "qtier_bureau")
    private String qtierBureau;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeBureau")
    private List<Electeur> electeurList;

    public Bureau() {
    }

    public Bureau(Short codeBureau) {
        this.codeBureau = codeBureau;
    }

    public Bureau(Short codeBureau, String labelBureau) {
        this.codeBureau = codeBureau;
        this.labelBureau = labelBureau;
    }

    public Bureau(String labelBureau, String qtierBureau) {
        this.qtierBureau = qtierBureau;
        this.labelBureau = labelBureau;
    }

    public Short getCodeBureau() {
        return codeBureau;
    }

    public void setCodeBureau(Short codeBureau) {
        this.codeBureau = codeBureau;
    }

    public String getLabelBureau() {
        return labelBureau;
    }

    public void setLabelBureau(String labelBureau) {
        this.labelBureau = labelBureau;
    }

    public String getQtierBureau() {
        return qtierBureau;
    }

    public void setQtierBureau(String qtierBureau) {
        this.qtierBureau = qtierBureau;
    }

    public List<Electeur> getElecteurList() {
        return electeurList;
    }

    public void setElecteurList(List<Electeur> electeurList) {
        this.electeurList = electeurList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeBureau != null ? codeBureau.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bureau)) {
            return false;
        }
        Bureau other = (Bureau) object;
        if ((this.codeBureau == null && other.codeBureau != null) || (this.codeBureau != null && !this.codeBureau.equals(other.codeBureau))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modeles.Bureau[ codeBureau=" + codeBureau + " ]";
    }

}
