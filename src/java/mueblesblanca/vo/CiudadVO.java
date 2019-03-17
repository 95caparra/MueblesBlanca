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

public class CiudadVO {
    
    private Integer idCiudad;
    private String descripcionCiudad;
    private Timestamp fechaCreacionCiudad;
    private String usuarioCreacionCiudad;
    private Timestamp fechaModificacionCiudad;
    private String usuarioModificacionCiudad;
    private Integer estado;

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getDescripcionCiudad() {
        return descripcionCiudad;
    }

    public void setDescripcionCiudad(String descripcionCiudad) {
        this.descripcionCiudad = descripcionCiudad;
    }

    public Timestamp getFechaCreacionCiudad() {
        return fechaCreacionCiudad;
    }

    public void setFechaCreacionCiudad(Timestamp fechaCreacionCiudad) {
        this.fechaCreacionCiudad = fechaCreacionCiudad;
    }

    public String getUsuarioCreacionCiudad() {
        return usuarioCreacionCiudad;
    }

    public void setUsuarioCreacionCiudad(String usuarioCreacionCiudad) {
        this.usuarioCreacionCiudad = usuarioCreacionCiudad;
    }

    public Timestamp getFechaModificacionCiudad() {
        return fechaModificacionCiudad;
    }

    public void setFechaModificacionCiudad(Timestamp fechaModificacionCiudad) {
        this.fechaModificacionCiudad = fechaModificacionCiudad;
    }

    public String getUsuarioModificacionCiudad() {
        return usuarioModificacionCiudad;
    }

    public void setUsuarioModificacionCiudad(String usuarioModificacionCiudad) {
        this.usuarioModificacionCiudad = usuarioModificacionCiudad;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
    
}
