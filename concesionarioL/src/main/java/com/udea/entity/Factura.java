/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alejo Castaño Rojas
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByNumeroFactura", query = "SELECT f FROM Factura f WHERE f.numeroFactura = :numeroFactura")
    , @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha")
    , @NamedQuery(name = "Factura.findByNombreCliente", query = "SELECT f FROM Factura f WHERE f.nombreCliente = :nombreCliente")
    , @NamedQuery(name = "Factura.findByIdCliente", query = "SELECT f FROM Factura f WHERE f.idCliente = :idCliente")
    , @NamedQuery(name = "Factura.findByPrecio", query = "SELECT f FROM Factura f WHERE f.precio = :precio")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero_factura")
    private Integer numeroFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Column(name = "precio")
    private Integer precio;
    @OneToMany(mappedBy = "numeroFactura")
    private Collection<Venta> ventaCollection;

    public Factura() {
    }

    public Factura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Factura(Integer numeroFactura, Date fecha, String nombreCliente) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
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
        hash += (numeroFactura != null ? numeroFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.numeroFactura == null && other.numeroFactura != null) || (this.numeroFactura != null && !this.numeroFactura.equals(other.numeroFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.Factura[ numeroFactura=" + numeroFactura + " ]";
    }
    
}
