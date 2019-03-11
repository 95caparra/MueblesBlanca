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
public class PedidoVO {
    
    private Integer idPedido;
    private Integer idInsumo;
    private Integer idProveedor;
    private Timestamp fechaSugeridaPedido;
    private String observacionPedido;
    private Timestamp fechaCreacionPedido;
    private String usuarioCreacionPedido;
    private Timestamp fechaModificacionPedido;
    private String usuarioModificacionPedido;
    private Integer estado;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Timestamp getFechaSugeridaPedido() {
        return fechaSugeridaPedido;
    }

    public void setFechaSugeridaPedido(Timestamp fechaSugeridaPedido) {
        this.fechaSugeridaPedido = fechaSugeridaPedido;
    }

    public String getObservacionPedido() {
        return observacionPedido;
    }

    public void setObservacionPedido(String observacionPedido) {
        this.observacionPedido = observacionPedido;
    }

    public Timestamp getFechaCreacionPedido() {
        return fechaCreacionPedido;
    }

    public void setFechaCreacionPedido(Timestamp fechaCreacionPedido) {
        this.fechaCreacionPedido = fechaCreacionPedido;
    }

    public String getUsuarioCreacionPedido() {
        return usuarioCreacionPedido;
    }

    public void setUsuarioCreacionPedido(String usuarioCreacionPedido) {
        this.usuarioCreacionPedido = usuarioCreacionPedido;
    }

    public Timestamp getFechaModificacionPedido() {
        return fechaModificacionPedido;
    }

    public void setFechaModificacionPedido(Timestamp fechaModificacionPedido) {
        this.fechaModificacionPedido = fechaModificacionPedido;
    }

    public String getUsuarioModificacionPedido() {
        return usuarioModificacionPedido;
    }

    public void setUsuarioModificacionPedido(String usuarioModificacionPedido) {
        this.usuarioModificacionPedido = usuarioModificacionPedido;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
    
}
