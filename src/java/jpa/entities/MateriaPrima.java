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
import javax.persistence.JoinTable;
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
@Table(name = "materia_prima")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriaPrima.findAll", query = "SELECT m FROM MateriaPrima m")
    , @NamedQuery(name = "MateriaPrima.findByIdMateriaPrima", query = "SELECT m FROM MateriaPrima m WHERE m.idMateriaPrima = :idMateriaPrima")
    , @NamedQuery(name = "MateriaPrima.findByColorMateria", query = "SELECT m FROM MateriaPrima m WHERE m.colorMateria = :colorMateria")
    , @NamedQuery(name = "MateriaPrima.findByTextura", query = "SELECT m FROM MateriaPrima m WHERE m.textura = :textura")
    , @NamedQuery(name = "MateriaPrima.findByPrecio", query = "SELECT m FROM MateriaPrima m WHERE m.precio = :precio")
    , @NamedQuery(name = "MateriaPrima.findByCantidadMateria", query = "SELECT m FROM MateriaPrima m WHERE m.cantidadMateria = :cantidadMateria")
    , @NamedQuery(name = "MateriaPrima.findByPeso", query = "SELECT m FROM MateriaPrima m WHERE m.peso = :peso")})
public class MateriaPrima implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_materia_prima")
    private Integer idMateriaPrima;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "color_materia")
    private String colorMateria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "textura")
    private String textura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private float precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_materia")
    private float cantidadMateria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private float peso;
    @JoinTable(name = "materia_prima_has_productos", joinColumns = {
        @JoinColumn(name = "materia_prima_id_materia_prima", referencedColumnName = "id_materia_prima")}, inverseJoinColumns = {
        @JoinColumn(name = "productos_codigo_producto", referencedColumnName = "codigo_producto")})
    @ManyToMany
    private Collection<Productos> productosCollection;
    @JoinColumn(name = "pedido_id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(optional = false)
    private Pedido pedidoIdPedido;

    public MateriaPrima() {
    }

    public MateriaPrima(Integer idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public MateriaPrima(Integer idMateriaPrima, String colorMateria, String textura, float precio, float cantidadMateria, float peso) {
        this.idMateriaPrima = idMateriaPrima;
        this.colorMateria = colorMateria;
        this.textura = textura;
        this.precio = precio;
        this.cantidadMateria = cantidadMateria;
        this.peso = peso;
    }

    public Integer getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(Integer idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public String getColorMateria() {
        return colorMateria;
    }

    public void setColorMateria(String colorMateria) {
        this.colorMateria = colorMateria;
    }

    public String getTextura() {
        return textura;
    }

    public void setTextura(String textura) {
        this.textura = textura;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getCantidadMateria() {
        return cantidadMateria;
    }

    public void setCantidadMateria(float cantidadMateria) {
        this.cantidadMateria = cantidadMateria;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    public Pedido getPedidoIdPedido() {
        return pedidoIdPedido;
    }

    public void setPedidoIdPedido(Pedido pedidoIdPedido) {
        this.pedidoIdPedido = pedidoIdPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateriaPrima != null ? idMateriaPrima.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaPrima)) {
            return false;
        }
        MateriaPrima other = (MateriaPrima) object;
        if ((this.idMateriaPrima == null && other.idMateriaPrima != null) || (this.idMateriaPrima != null && !this.idMateriaPrima.equals(other.idMateriaPrima))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.MateriaPrima[ idMateriaPrima=" + idMateriaPrima + " ]";
    }
    
}
