/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
 * @author Alejo Castaño Rojas
 */
@Entity
@Table(name = "automovil")
@XmlRootElement 
@NamedQueries({
    @NamedQuery(name = "Automovil.findAll", query = "SELECT a FROM Automovil a")
    , @NamedQuery(name = "Automovil.replace", query = "UPDATE Automovil a SET a.enVenta = false WHERE a.idAutomovil = :idAutomovil")
    , @NamedQuery(name = "Automovil.findByIdAutomovil", query = "SELECT a FROM Automovil a WHERE a.idAutomovil = :idAutomovil")
    , @NamedQuery(name = "Automovil.findByCilindraje", query = "SELECT a FROM Automovil a WHERE a.cilindraje = :cilindraje")
    , @NamedQuery(name = "Automovil.findByColor", query = "SELECT a FROM Automovil a WHERE a.color = :color")
    , @NamedQuery(name = "Automovil.findByPrecio", query = "SELECT a FROM Automovil a WHERE a.precio = :precio")
    , @NamedQuery(name = "Automovil.findByEnVenta", query = "SELECT a FROM Automovil a WHERE a.enVenta = :enVenta")
    , @NamedQuery(name = "Automovil.findByMesesGarantia", query = "SELECT a FROM Automovil a WHERE a.mesesGarantia = :mesesGarantia")})
public class Automovil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_automovil")
    private Integer idAutomovil;
    @Column(name = "cilindraje")
    private Integer cilindraje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "color")
    private String color;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "en_venta")
    private Boolean enVenta;
    @Column(name = "meses_garantia")
    private Integer mesesGarantia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @JoinColumn(name = "tipo_automovil", referencedColumnName = "id_tipo")
    @ManyToOne
    private Tipoautomovil tipoAutomovil;
    @JoinColumn(name = "linea", referencedColumnName = "id_linea")
    @ManyToOne
    private Linea linea;
    @OneToMany(mappedBy = "automovil")
    private Collection<Venta> ventaCollection;

    public Automovil() {
    }

    public Automovil(Integer idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public Automovil(Integer idAutomovil, String color, byte[] foto) {
        this.idAutomovil = idAutomovil;
        this.color = color;
        this.foto = foto;
    }

    public Integer getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(Integer idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public Integer getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(Integer cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Boolean getEnVenta() {
        return enVenta;
    }

    public void setEnVenta(Boolean enVenta) {
        this.enVenta = enVenta;
    }

    public Integer getMesesGarantia() {
        return mesesGarantia;
    }

    public void setMesesGarantia(Integer mesesGarantia) {
        this.mesesGarantia = mesesGarantia;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Tipoautomovil getTipoAutomovil() {
        return tipoAutomovil;
    }

    public void setTipoAutomovil(Tipoautomovil tipoAutomovil) {
        this.tipoAutomovil = tipoAutomovil;
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    @XmlTransient
    public Collection<Venta> getVentaCollection() {
        return ventaCollection;
    }

    public void setVentaCollection(Collection<Venta> ventaCollection) {
        this.ventaCollection = ventaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutomovil != null ? idAutomovil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Automovil)) {
            return false;
        }
        Automovil other = (Automovil) object;
        if ((this.idAutomovil == null && other.idAutomovil != null) || (this.idAutomovil != null && !this.idAutomovil.equals(other.idAutomovil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.Automovil[ idAutomovil=" + idAutomovil + " ]";
    }

}
