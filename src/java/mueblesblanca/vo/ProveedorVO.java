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
    private Integer telefonoProveedor;
    private String correoProveedor;
    private Timestamp fechaCreacionProveedor;
    private String usuarioCreacionProveedor;
    private Timestamp fechaModificacionProveedor;
    private String usuarioModificacionProveedor;
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

    public Integer getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(Integer telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getCorreoProveedor() {
        return correoProveedor;
    }

    public void setCorreoProveedor(String correoProveedor) {
        this.correoProveedor = correoProveedor;
    }

    public Timestamp getFechaCreacionProveedor() {
        return fechaCreacionProveedor;
    }

    public void setFechaCreacionProveedor(Timestamp fechaCreacionProveedor) {
        this.fechaCreacionProveedor = fechaCreacionProveedor;
    }

    public String getUsuarioCreacionProveedor() {
        return usuarioCreacionProveedor;
    }

    public void setUsuarioCreacionProveedor(String usuarioCreacionProveedor) {
        this.usuarioCreacionProveedor = usuarioCreacionProveedor;
    }

    public Timestamp getFechaModificacionProveedor() {
        return fechaModificacionProveedor;
    }

    public void setFechaModificacionProveedor(Timestamp fechaModificacionProveedor) {
        this.fechaModificacionProveedor = fechaModificacionProveedor;
    }

    public String getUsuarioModificacionProveedor() {
        return usuarioModificacionProveedor;
    }

    public void setUsuarioModificacionProveedor(String usuarioModificacionProveedor) {
        this.usuarioModificacionProveedor = usuarioModificacionProveedor;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
    
}
