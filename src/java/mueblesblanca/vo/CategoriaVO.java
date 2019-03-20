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

public class CategoriaVO {
    
    private Integer idCategoria;
    private String descripcionCategoria;
    private Timestamp fechaCreacionCategoria;
    private String usuarioCreacionCategoria;
    private Timestamp fechaModificacionCategoria;
    private String usuarioModificacionCategoria;
    private Integer estado;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public Timestamp getFechaCreacionCategoria() {
        return fechaCreacionCategoria;
    }

    public void setFechaCreacionCategoria(Timestamp fechaCreacionCategoria) {
        this.fechaCreacionCategoria = fechaCreacionCategoria;
    }

    public String getUsuarioCreacionCategoria() {
        return usuarioCreacionCategoria;
    }

    public void setUsuarioCreacionCategoria(String usuarioCreacionCategoria) {
        this.usuarioCreacionCategoria = usuarioCreacionCategoria;
    }

    public Timestamp getFechaModificacionCategoria() {
        return fechaModificacionCategoria;
    }

    public void setFechaModificacionCategoria(Timestamp fechaModificacionCategoria) {
        this.fechaModificacionCategoria = fechaModificacionCategoria;
    }

    public String getUsuarioModificacionCategoria() {
        return usuarioModificacionCategoria;
    }

    public void setUsuarioModificacionCategoria(String usuarioModificacionCategoria) {
        this.usuarioModificacionCategoria = usuarioModificacionCategoria;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
    
    
    
}
