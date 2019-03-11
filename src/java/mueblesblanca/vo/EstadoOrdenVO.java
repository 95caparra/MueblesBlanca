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
public class EstadoOrdenVO {

    private Integer idEstadoOrden;
    private String descripcionEstadoOrden;
    private Timestamp fechaCreacionEstadoOrden;
    private String usuarioCreacionEstadoOrden;
    private Timestamp fechaModificacionEstadoOrden;
    private String usuarioModificacionEstadoOrden;
    private Integer estado;

    public Integer getIdEstadoOrden() {
        return idEstadoOrden;
    }

    public void setIdEstadoOrden(Integer idEstadoOrden) {
        this.idEstadoOrden = idEstadoOrden;
    }

    public String getDescripcionEstadoOrden() {
        return descripcionEstadoOrden;
    }

    public void setDescripcionEstadoOrden(String descripcionEstadoOrden) {
        this.descripcionEstadoOrden = descripcionEstadoOrden;
    }

    public Timestamp getFechaCreacionEstadoOrden() {
        return fechaCreacionEstadoOrden;
    }

    public void setFechaCreacionEstadoOrden(Timestamp fechaCreacionEstadoOrden) {
        this.fechaCreacionEstadoOrden = fechaCreacionEstadoOrden;
    }

    public String getUsuarioCreacionEstadoOrden() {
        return usuarioCreacionEstadoOrden;
    }

    public void setUsuarioCreacionEstadoOrden(String usuarioCreacionEstadoOrden) {
        this.usuarioCreacionEstadoOrden = usuarioCreacionEstadoOrden;
    }

    public Timestamp getFechaModificacionEstadoOrden() {
        return fechaModificacionEstadoOrden;
    }

    public void setFechaModificacionEstadoOrden(Timestamp fechaModificacionEstadoOrden) {
        this.fechaModificacionEstadoOrden = fechaModificacionEstadoOrden;
    }

    public String getUsuarioModificacionEstadoOrden() {
        return usuarioModificacionEstadoOrden;
    }

    public void setUsuarioModificacionEstadoOrden(String usuarioModificacionEstadoOrden) {
        this.usuarioModificacionEstadoOrden = usuarioModificacionEstadoOrden;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

}
