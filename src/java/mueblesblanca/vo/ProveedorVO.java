/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.vo;

import java.sql.Timestamp;

/**
 *
 * @author camil
 */
public class ProveedorVO {

    private Integer idProveedor;
    private String razonSocialProveedor;
    private String direccionProveedor;
    private String telefonoProveedor;
    private String correoProveedor;
    private Timestamp fechaCreacionProducto;
    private String usuarioCreacionProducto;
    private Timestamp fechaModificacionProducto;
    private String usuarioModificacionProducto;
    private Integer estado;

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRazonSocialProveedor() {
        return razonSocialProveedor;
    }

    public void setRazonSocialProveedor(String razonSocialProveedor) {
        this.razonSocialProveedor = razonSocialProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getCorreoProveedor() {
        return correoProveedor;
    }

    public void setCorreoProveedor(String correoProveedor) {
        this.correoProveedor = correoProveedor;
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
    
    
}
