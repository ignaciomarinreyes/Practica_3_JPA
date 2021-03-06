/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ignacio
 */
@Entity
@Table(name = "AUTONOMOUSCOMMUNITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autonomouscommunity.findAll", query = "SELECT a FROM Autonomouscommunity a"),
    @NamedQuery(name = "Autonomouscommunity.findById", query = "SELECT a FROM Autonomouscommunity a WHERE a.id = :id"),
    @NamedQuery(name = "Autonomouscommunity.findByName", query = "SELECT a FROM Autonomouscommunity a WHERE a.name = :name")})
public class Autonomouscommunity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autonomouscommunity")
    private Collection<Province> provinceCollection;

    public Autonomouscommunity() {
    }

    public Autonomouscommunity(Integer id) {
        this.id = id;
    }

    public Autonomouscommunity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Province> getProvinceCollection() {
        return provinceCollection;
    }

    public void setProvinceCollection(Collection<Province> provinceCollection) {
        this.provinceCollection = provinceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autonomouscommunity)) {
            return false;
        }
        Autonomouscommunity other = (Autonomouscommunity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Autonomouscommunity[ id=" + id + " ]";
    }
    
}
