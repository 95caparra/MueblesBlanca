/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author camil
 */

public class ProductoVO {
    
    private Integer idProducto;
    private String nombreProducto;
    private TipoProductoVO tipoProducto;
    private Integer cantidadExistente;
    private BigDecimal precioUnidadProducto;
    private MedidaVO medida;    
    private Timestamp fechaCreacionProducto;
    private String usuarioCreacionProducto;
    private Timestamp fechaModificacionProducto;
    private String usuarioModificacionProducto;
    private Integer estado;
    private byte[] foto;
    private String imagenProducto;

    //se instancian clases u objetos de llaves foraneas para evitar null 
    public ProductoVO(){
        this.tipoProducto = new TipoProductoVO();
        this.medida = new MedidaVO();
    }
    
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(Integer cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    public BigDecimal getPrecioUnidadProducto() {
        return precioUnidadProducto;
    }

    public void setPrecioUnidadProducto(BigDecimal precioUnidadProducto) {
        this.precioUnidadProducto = precioUnidadProducto;
    }

    public Timestamp getFechaCreacionProducto() {
        return fechaCreacionProducto;
    }

    public void setFechaCreacionProducto(Timestamp fechaCreacionProducto) {
        this.fechaCreacionProducto = fechaCreacionProducto;
    }

    public String getUsuarioCreacionProducto() {
        return usuarioCreacionProducto;
    }

    public void setUsuarioCreacionProducto(String usuarioCreacionProducto) {
        this.usuarioCreacionProducto = usuarioCreacionProducto;
    }

    public Timestamp getFechaModificacionProducto() {
        return fechaModificacionProducto;
    }

    public void setFechaModificacionProducto(Timestamp fechaModificacionProducto) {
        this.fechaModificacionProducto = fechaModificacionProducto;
    }

    public String getUsuarioModificacionProducto() {
        return usuarioModificacionProducto;
    }

    public void setUsuarioModificacionProducto(String usuarioModificacionProducto) {
        this.usuarioModificacionProducto = usuarioModificacionProducto;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public TipoProductoVO getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProductoVO tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public MedidaVO getMedida() {
        return medida;
    }

    public void setMedida(MedidaVO medida) {
        this.medida = medida;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }
    
    
    
    

}
