/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByCodigoProducto", query = "SELECT p FROM Productos p WHERE p.codigoProducto = :codigoProducto")
    , @NamedQuery(name = "Productos.findByMaterial", query = "SELECT p FROM Productos p WHERE p.material = :material")
    , @NamedQuery(name = "Productos.findByNombreProducto", query = "SELECT p FROM Productos p WHERE p.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "Productos.findByModelo", query = "SELECT p FROM Productos p WHERE p.modelo = :modelo")
    , @NamedQuery(name = "Productos.findByPrecio", query = "SELECT p FROM Productos p WHERE p.precio = :precio")
    , @NamedQuery(name = "Productos.findByTalla", query = "SELECT p FROM Productos p WHERE p.talla = :talla")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_producto")
    private Integer codigoProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "material")
    private String material;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "precio")
    private String precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "talla")
    private String talla;
    @ManyToMany(mappedBy = "productosCollection")
    private Collection<MateriaPrima> materiaPrimaCollection;
    @JoinColumn(name = "orden_venta_id_orden_venta", referencedColumnName = "id_orden_venta")
    @ManyToOne(optional = false)
    private OrdenVenta ordenVentaIdOrdenVenta;
    @JoinColumn(name = "stock_codigo_producto", referencedColumnName = "codigo_producto")
    @ManyToOne(optional = false)
    private Stock stockCodigoProducto;

    public Productos() {
    }

    public Productos(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Productos(Integer codigoProducto, String material, String nombreProducto, String modelo, String precio, String talla) {
        this.codigoProducto = codigoProducto;
        this.material = material;
        this.nombreProducto = nombreProducto;
        this.modelo = modelo;
        this.precio = precio;
        this.talla = talla;
    }

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    @XmlTransient
    public Collection<MateriaPrima> getMateriaPrimaCollection() {
        return materiaPrimaCollection;
    }

    public void setMateriaPrimaCollection(Collection<MateriaPrima> materiaPrimaCollection) {
        this.materiaPrimaCollection = materiaPrimaCollection;
    }

    public OrdenVenta getOrdenVentaIdOrdenVenta() {
        return ordenVentaIdOrdenVenta;
    }

    public void setOrdenVentaIdOrdenVenta(OrdenVenta ordenVentaIdOrdenVenta) {
        this.ordenVentaIdOrdenVenta = ordenVentaIdOrdenVenta;
    }

    public Stock getStockCodigoProducto() {
        return stockCodigoProducto;
    }

    public void setStockCodigoProducto(Stock stockCodigoProducto) {
        this.stockCodigoProducto = stockCodigoProducto;
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
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.codigoProducto == null && other.codigoProducto != null) || (this.codigoProducto != null && !this.codigoProducto.equals(other.codigoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Productos[ codigoProducto=" + codigoProducto + " ]";
    }
    
}
