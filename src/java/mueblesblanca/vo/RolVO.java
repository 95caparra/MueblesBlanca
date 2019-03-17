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
public class RolVO {
    
    private Integer idRol;
    private String descripcionRol;
    private Timestamp fechaCreacionRol;
    private String usuarioCreacionRol;
    private Timestamp fechaModificacionRol;
    private String usuarioModificacionRol;
    private Integer estado;
    
    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    public Timestamp getFechaCreacionRol() {
        return fechaCreacionRol;
    }

    public void setFechaCreacionRol(Timestamp fechaCreacionRol) {
        this.fechaCreacionRol = fechaCreacionRol;
    }

    public String getUsuarioCreacionRol() {
        return usuarioCreacionRol;
    }

    public void setUsuarioCreacionRol(String usuarioCreacionRol) {
        this.usuarioCreacionRol = usuarioCreacionRol;
    }

    public Timestamp getFechaModificacionRol() {
        return fechaModificacionRol;
    }

    public void setFechaModificacionRol(Timestamp fechaModificacionRol) {
        this.fechaModificacionRol = fechaModificacionRol;
    }

    public String getUsuarioModificacionRol() {
        return usuarioModificacionRol;
    }

    public void setUsuarioModificacionRol(String usuarioModificacionRol) {
        this.usuarioModificacionRol = usuarioModificacionRol;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
}
