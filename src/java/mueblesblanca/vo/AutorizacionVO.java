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
public class AutorizacionVO {
    
    private Integer idAutorizacion;
    private Integer codigoOpcionAutorizacion;
    private Integer idRolAutorizacion;
    private String modificaAutorizacion;
    private String creaAutorizacion;
    private String consultaAutorizacion;
    private String eliminaAutorizacion;
    private Timestamp fechaCreacionAutorizacion;
    private String usuarioCreacionAutorizacion;
    private Timestamp fechaModificacionAutorizacion;
    private String usuarioModificacion;
    private Integer estadoAutorizacion;

    public Integer getIdAutorizacion() {
        return idAutorizacion;
    }

    public void setIdAutorizacion(Integer idAutorizacion) {
        this.idAutorizacion = idAutorizacion;
    }

    public Integer getCodigoOpcionAutorizacion() {
        return codigoOpcionAutorizacion;
    }

    public void setCodigoOpcionAutorizacion(Integer codigoOpcionAutorizacion) {
        this.codigoOpcionAutorizacion = codigoOpcionAutorizacion;
    }

    public Integer getIdRolAutorizacion() {
        return idRolAutorizacion;
    }

    public void setIdRolAutorizacion(Integer idRolAutorizacion) {
        this.idRolAutorizacion = idRolAutorizacion;
    }

    public String getModificaAutorizacion() {
        return modificaAutorizacion;
    }

    public void setModificaAutorizacion(String modificaAutorizacion) {
        this.modificaAutorizacion = modificaAutorizacion;
    }

    public String getCreaAutorizacion() {
        return creaAutorizacion;
    }

    public void setCreaAutorizacion(String creaAutorizacion) {
        this.creaAutorizacion = creaAutorizacion;
    }

    public String getConsultaAutorizacion() {
        return consultaAutorizacion;
    }

    public void setConsultaAutorizacion(String consultaAutorizacion) {
        this.consultaAutorizacion = consultaAutorizacion;
    }

    public String getEliminaAutorizacion() {
        return eliminaAutorizacion;
    }

    public void setEliminaAutorizacion(String eliminaAutorizacion) {
        this.eliminaAutorizacion = eliminaAutorizacion;
    }

    public Timestamp getFechaCreacionAutorizacion() {
        return fechaCreacionAutorizacion;
    }

    public void setFechaCreacionAutorizacion(Timestamp fechaCreacionAutorizacion) {
        this.fechaCreacionAutorizacion = fechaCreacionAutorizacion;
    }

    public String getUsuarioCreacionAutorizacion() {
        return usuarioCreacionAutorizacion;
    }

    public void setUsuarioCreacionAutorizacion(String usuarioCreacionAutorizacion) {
        this.usuarioCreacionAutorizacion = usuarioCreacionAutorizacion;
    }

    public Timestamp getFechaModificacionAutorizacion() {
        return fechaModificacionAutorizacion;
    }

    public void setFechaModificacionAutorizacion(Timestamp fechaModificacionAutorizacion) {
        this.fechaModificacionAutorizacion = fechaModificacionAutorizacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Integer getEstadoAutorizacion() {
        return estadoAutorizacion;
    }

    public void setEstadoAutorizacion(Integer estadoAutorizacion) {
        this.estadoAutorizacion = estadoAutorizacion;
    }
    
    
    
    
    
}
