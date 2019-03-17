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

public class PersonaNaturalVO {
    
    private Integer idPersonaNatural;
    private Long identificacionPersonaNatural;
    private TipoDocumentoVO TipoDocumentoPersonaNatural;
    private String primerNombrePersonaNatural;
    private String segundoNombrePersonaNatural;
    private String primerApellidoPersonaNatural;
    private String segundoApellidoPersonaNatural;
    private String telefonoPersonaNatural;
    private String celularPersonaNatural;
    private String direccionPersonaNatural;
    private CiudadVO CiudadPersonaNatural;
    private Timestamp fechaCreacionPersonaNatural;
    private String usuarioCreacionPersonaNatural;
    private Timestamp fechaModificacionPersonaNatural;
    private String usuarioModificacionPersonaNatural;
    private Integer estado;
    private RolVO RolPersonaNatural;

    public Integer getIdPersonaNatural() {
        return idPersonaNatural;
    }

    public void setIdPersonaNatural(Integer idPersonaNatural) {
        this.idPersonaNatural = idPersonaNatural;
    }

    public Long getIdentificacionPersonaNatural() {
        return identificacionPersonaNatural;
    }

    public void setIdentificacionPersonaNatural(Long identificacionPersonaNatural) {
        this.identificacionPersonaNatural = identificacionPersonaNatural;
    }

    public TipoDocumentoVO getTipoDocumentoPersonaNatural() {
        return TipoDocumentoPersonaNatural;
    }

    public void setTipoDocumentoPersonaNatural(TipoDocumentoVO TipoDocumentoPersonaNatural) {
        this.TipoDocumentoPersonaNatural = TipoDocumentoPersonaNatural;
    }

    public String getPrimerNombrePersonaNatural() {
        return primerNombrePersonaNatural;
    }

    public void setPrimerNombrePersonaNatural(String primerNombrePersonaNatural) {
        this.primerNombrePersonaNatural = primerNombrePersonaNatural;
    }

    public String getSegundoNombrePersonaNatural() {
        return segundoNombrePersonaNatural;
    }

    public void setSegundoNombrePersonaNatural(String segundoNombrePersonaNatural) {
        this.segundoNombrePersonaNatural = segundoNombrePersonaNatural;
    }

    public String getPrimerApellidoPersonaNatural() {
        return primerApellidoPersonaNatural;
    }

    public void setPrimerApellidoPersonaNatural(String primerApellidoPersonaNatural) {
        this.primerApellidoPersonaNatural = primerApellidoPersonaNatural;
    }

    public String getSegundoApellidoPersonaNatural() {
        return segundoApellidoPersonaNatural;
    }

    public void setSegundoApellidoPersonaNatural(String segundoApellidoPersonaNatural) {
        this.segundoApellidoPersonaNatural = segundoApellidoPersonaNatural;
    }

    public String getTelefonoPersonaNatural() {
        return telefonoPersonaNatural;
    }

    public void setTelefonoPersonaNatural(String telefonoPersonaNatural) {
        this.telefonoPersonaNatural = telefonoPersonaNatural;
    }

    public String getCelularPersonaNatural() {
        return celularPersonaNatural;
    }

    public void setCelularPersonaNatural(String celularPersonaNatural) {
        this.celularPersonaNatural = celularPersonaNatural;
    }

    public String getDireccionPersonaNatural() {
        return direccionPersonaNatural;
    }

    public void setDireccionPersonaNatural(String direccionPersonaNatural) {
        this.direccionPersonaNatural = direccionPersonaNatural;
    }

    public CiudadVO getCiudadPersonaNatural() {
        return CiudadPersonaNatural;
    }

    public void setIdCiudadPersonaNatural(CiudadVO CiudadPersonaNatural) {
        this.CiudadPersonaNatural = CiudadPersonaNatural;
    }

    public Timestamp getFechaCreacionPersonaNatural() {
        return fechaCreacionPersonaNatural;
    }

    public void setFechaCreacionPersonaNatural(Timestamp fechaCreacionPersonaNatural) {
        this.fechaCreacionPersonaNatural = fechaCreacionPersonaNatural;
    }

    public String getUsuarioCreacionPersonaNatural() {
        return usuarioCreacionPersonaNatural;
    }

    public void setUsuarioCreacionPersonaNatural(String usuarioCreacionPersonaNatural) {
        this.usuarioCreacionPersonaNatural = usuarioCreacionPersonaNatural;
    }

    public Timestamp getFechaModificacionPersonaNatural() {
        return fechaModificacionPersonaNatural;
    }

    public void setFechaModificacionPersonaNatural(Timestamp fechaModificacionPersonaNatural) {
        this.fechaModificacionPersonaNatural = fechaModificacionPersonaNatural;
    }

    public String getUsuarioModificacionPersonaNatural() {
        return usuarioModificacionPersonaNatural;
    }

    public void setUsuarioModificacionPersonaNatural(String usuarioModificacionPersonaNatural) {
        this.usuarioModificacionPersonaNatural = usuarioModificacionPersonaNatural;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public RolVO getRolPersonaNatural() {
        return RolPersonaNatural;
    }

    public void setIdRolPersonaNatural(RolVO idRolPersonaNatural) {
        this.RolPersonaNatural = RolPersonaNatural;
    }
    
    
    
    
}
