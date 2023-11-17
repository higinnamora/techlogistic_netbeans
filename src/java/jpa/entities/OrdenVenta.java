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
import javax.persistence.JoinColumn;
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
 * @author aurac
 */
@Entity
@Table(name = "orden_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenVenta.findAll", query = "SELECT o FROM OrdenVenta o")
    , @NamedQuery(name = "OrdenVenta.findByIdOrdenVenta", query = "SELECT o FROM OrdenVenta o WHERE o.idOrdenVenta = :idOrdenVenta")
    , @NamedQuery(name = "OrdenVenta.findByCantidadProductos", query = "SELECT o FROM OrdenVenta o WHERE o.cantidadProductos = :cantidadProductos")
    , @NamedQuery(name = "OrdenVenta.findByDescuento", query = "SELECT o FROM OrdenVenta o WHERE o.descuento = :descuento")
    , @NamedQuery(name = "OrdenVenta.findByFechaFactura", query = "SELECT o FROM OrdenVenta o WHERE o.fechaFactura = :fechaFactura")
    , @NamedQuery(name = "OrdenVenta.findByObservacion", query = "SELECT o FROM OrdenVenta o WHERE o.observacion = :observacion")
    , @NamedQuery(name = "OrdenVenta.findByMedioPago", query = "SELECT o FROM OrdenVenta o WHERE o.medioPago = :medioPago")
    , @NamedQuery(name = "OrdenVenta.findBySubTotal", query = "SELECT o FROM OrdenVenta o WHERE o.subTotal = :subTotal")
    , @NamedQuery(name = "OrdenVenta.findByTotal", query = "SELECT o FROM OrdenVenta o WHERE o.total = :total")})
public class OrdenVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_orden_venta")
    private Integer idOrdenVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_productos")
    private int cantidadProductos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento")
    private float descuento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fecha_factura")
    private String fechaFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "medio_pago")
    private String medioPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_total")
    private float subTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private float total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenVentaIdOrdenVenta")
    private Collection<Productos> productosCollection;
    @JoinColumn(name = "roles_id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Roles rolesIdRol;

    public OrdenVenta() {
    }

    public OrdenVenta(Integer idOrdenVenta) {
        this.idOrdenVenta = idOrdenVenta;
    }

    public OrdenVenta(Integer idOrdenVenta, int cantidadProductos, float descuento, String fechaFactura, String observacion, String medioPago, float subTotal, float total) {
        this.idOrdenVenta = idOrdenVenta;
        this.cantidadProductos = cantidadProductos;
        this.descuento = descuento;
        this.fechaFactura = fechaFactura;
        this.observacion = observacion;
        this.medioPago = medioPago;
        this.subTotal = subTotal;
        this.total = total;
    }

    public Integer getIdOrdenVenta() {
        return idOrdenVenta;
    }

    public void setIdOrdenVenta(Integer idOrdenVenta) {
        this.idOrdenVenta = idOrdenVenta;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    public Roles getRolesIdRol() {
        return rolesIdRol;
    }

    public void setRolesIdRol(Roles rolesIdRol) {
        this.rolesIdRol = rolesIdRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenVenta != null ? idOrdenVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenVenta)) {
            return false;
        }
        OrdenVenta other = (OrdenVenta) object;
        if ((this.idOrdenVenta == null && other.idOrdenVenta != null) || (this.idOrdenVenta != null && !this.idOrdenVenta.equals(other.idOrdenVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.OrdenVenta[ idOrdenVenta=" + idOrdenVenta + " ]";
    }
    
}
