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
public class InsumoVO {
    
    private Integer idInsumo;
    private String nombreInsumo;
    private Integer idMedida;
    private BigDecimal precioUnidadInsumo;
    private String detalleInsumo;
    private Timestamp fechaCreacionInsumo;
    private String usuarioCreacionInsumo;
    private Timestamp fechaModificacionInsumo;
    private String usuarioModificacionInsumo;
    private Integer estado;

    public Integer getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public Integer getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Integer idMedida) {
        this.idMedida = idMedida;
    }

    public BigDecimal getPrecioUnidadInsumo() {
        return precioUnidadInsumo;
    }

    public void setPrecioUnidadInsumo(BigDecimal precioUnidadInsumo) {
        this.precioUnidadInsumo = precioUnidadInsumo;
    }

    public String getDetalleInsumo() {
        return detalleInsumo;
    }

    public void setDetalleInsumo(String detalleInsumo) {
        this.detalleInsumo = detalleInsumo;
    }

    public Timestamp getFechaCreacionInsumo() {
        return fechaCreacionInsumo;
    }

    public void setFechaCreacionInsumo(Timestamp fechaCreacionInsumo) {
        this.fechaCreacionInsumo = fechaCreacionInsumo;
    }

    public String getUsuarioCreacionInsumo() {
        return usuarioCreacionInsumo;
    }

    public void setUsuarioCreacionInsumo(String usuarioCreacionInsumo) {
        this.usuarioCreacionInsumo = usuarioCreacionInsumo;
    }

    public Timestamp getFechaModificacionInsumo() {
        return fechaModificacionInsumo;
    }

    public void setFechaModificacionInsumo(Timestamp fechaModificacionInsumo) {
        this.fechaModificacionInsumo = fechaModificacionInsumo;
    }

    public String getUsuarioModificacionInsumo() {
        return usuarioModificacionInsumo;
    }

    public void setUsuarioModificacionInsumo(String usuarioModificacionInsumo) {
        this.usuarioModificacionInsumo = usuarioModificacionInsumo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
    
    
}
