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

public class TipoProductoVO {
    
    private Integer idTipoProducto;
    private String descripcionTipoProducto;
    private Timestamp fechaCreacionTipoProducto;
    private String usuarioCreacionTipoProducto;
    private Timestamp fechaModificacionTipoProducto;
    private String usuarioModificacionTipoProducto;
    private Integer estado;

    /**
     * @return the idTipoProducto
     */
    public Integer getIdTipoProducto() {
        return idTipoProducto;
    }

    /**
     * @param idTipoProducto the idTipoProducto to set
     */
    public void setIdTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    /**
     * @return the descripcionTipoProducto
     */
    public String getDescripcionTipoProducto() {
        return descripcionTipoProducto;
    }

    /**
     * @param descripcionTipoProducto the descripcionTipoProducto to set
     */
    public void setDescripcionTipoProducto(String descripcionTipoProducto) {
        this.descripcionTipoProducto = descripcionTipoProducto;
    }

    /**
     * @return the fechaCreacionTipoProducto
     */
    public Timestamp getFechaCreacionTipoProducto() {
        return fechaCreacionTipoProducto;
    }

    /**
     * @param fechaCreacionTipoProducto the fechaCreacionTipoProducto to set
     */
    public void setFechaCreacionTipoProducto(Timestamp fechaCreacionTipoProducto) {
        this.fechaCreacionTipoProducto = fechaCreacionTipoProducto;
    }

    /**
     * @return the usuarioCreacionTipoProducto
     */
    public String getUsuarioCreacionTipoProducto() {
        return usuarioCreacionTipoProducto;
    }

    /**
     * @param usuarioCreacionTipoProducto the usuarioCreacionTipoProducto to set
     */
    public void setUsuarioCreacionTipoProducto(String usuarioCreacionTipoProducto) {
        this.usuarioCreacionTipoProducto = usuarioCreacionTipoProducto;
    }

    /**
     * @return the fechaModificacionTipoProducto
     */
    public Timestamp getFechaModificacionTipoProducto() {
        return fechaModificacionTipoProducto;
    }

    /**
     * @param fechaModificacionTipoProducto the fechaModificacionTipoProducto to set
     */
    public void setFechaModificacionTipoProducto(Timestamp fechaModificacionTipoProducto) {
        this.fechaModificacionTipoProducto = fechaModificacionTipoProducto;
    }

    /**
     * @return the usuarioModificacionTipoProducto
     */
    public String getUsuarioModificacionTipoProducto() {
        return usuarioModificacionTipoProducto;
    }

    /**
     * @param usuarioModificacionTipoProducto the usuarioModificacionTipoProducto to set
     */
    public void setUsuarioModificacionTipoProducto(String usuarioModificacionTipoProducto) {
        this.usuarioModificacionTipoProducto = usuarioModificacionTipoProducto;
    }

    /**
     * @return the estado
     */
    public Integer getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
