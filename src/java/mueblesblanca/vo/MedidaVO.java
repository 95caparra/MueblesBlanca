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

public class MedidaVO {
    
    private Integer idMedida;
    private String descripcionMedida;
    private Timestamp fechaCreacionMedida;
    private String usuarioCreacionMedida;
    private Timestamp fechaModificacionMedida;
    private String usuarioModificacionMedida;
    private Integer estado;

    public Integer getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Integer idMedida) {
        this.idMedida = idMedida;
    }

    public String getDescripcionMedida() {
        return descripcionMedida;
    }

    public void setDescripcionMedida(String descripcionMedida) {
        this.descripcionMedida = descripcionMedida;
    }

    public Timestamp getFechaCreacionMedida() {
        return fechaCreacionMedida;
    }

    public void setFechaCreacionMedida(Timestamp fechaCreacionMedida) {
        this.fechaCreacionMedida = fechaCreacionMedida;
    }

    public String getUsuarioCreacionMedida() {
        return usuarioCreacionMedida;
    }

    public void setUsuarioCreacionMedida(String usuarioCreacionMedida) {
        this.usuarioCreacionMedida = usuarioCreacionMedida;
    }

    public Timestamp getFechaModificacionMedida() {
        return fechaModificacionMedida;
    }

    public void setFechaModificacionMedida(Timestamp fechaModificacionMedida) {
        this.fechaModificacionMedida = fechaModificacionMedida;
    }

    public String getUsuarioModificacionMedida() {
        return usuarioModificacionMedida;
    }

    public void setUsuarioModificacionMedida(String usuarioModificacionMedida) {
        this.usuarioModificacionMedida = usuarioModificacionMedida;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
}
