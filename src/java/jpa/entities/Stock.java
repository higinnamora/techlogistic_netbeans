/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author aurac
 */
@Entity
@Table(name = "stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")
    , @NamedQuery(name = "Stock.findByCodigoProducto", query = "SELECT s FROM Stock s WHERE s.codigoProducto = :codigoProducto")
    , @NamedQuery(name = "Stock.findByCantidadStock", query = "SELECT s FROM Stock s WHERE s.cantidadStock = :cantidadStock")
    , @NamedQuery(name = "Stock.findByDescripcionStock", query = "SELECT s FROM Stock s WHERE s.descripcionStock = :descripcionStock")
    , @NamedQuery(name = "Stock.findByEstado", query = "SELECT s FROM Stock s WHERE s.estado = :estado")})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_producto")
    private Integer codigoProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cantidad_stock")
    private String cantidadStock;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion_stock")
    private String descripcionStock;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stockCodigoProducto")
    private Collection<Productos> productosCollection;

    public Stock() {
    }

    public Stock(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Stock(Integer codigoProducto, String cantidadStock, String descripcionStock, String estado) {
        this.codigoProducto = codigoProducto;
        this.cantidadStock = cantidadStock;
        this.descripcionStock = descripcionStock;
        this.estado = estado;
    }

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(String cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public String getDescripcionStock() {
        return descripcionStock;
    }

    public void setDescripcionStock(String descripcionStock) {
        this.descripcionStock = descripcionStock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoProducto != null ? codigoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.codigoProducto == null && other.codigoProducto != null) || (this.codigoProducto != null && !this.codigoProducto.equals(other.codigoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Stock[ codigoProducto=" + codigoProducto + " ]";
    }
    
}
