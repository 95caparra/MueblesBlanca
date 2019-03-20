/*
 * To change this license header;choose License Headers in Project Properties.
 * To change this template file;choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mueblesblanca.constante.UsuarioEnum;
import mueblesblanca.service.CiudadService;
import mueblesblanca.service.PersonaNaturalService;
import mueblesblanca.service.RolService;
import mueblesblanca.service.TipoDocumentoService;
import mueblesblanca.vo.CiudadVO;
import mueblesblanca.vo.PersonaNaturalVO;
import mueblesblanca.vo.RolVO;
import mueblesblanca.vo.TipoDocumentoVO;
import org.primefaces.context.RequestContext;

/**
 *
 * @author cochoa
 */
@ManagedBean(name = "clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private Integer idPersonaNatural;
    private Long identificacionPersonaNatural;
    private Integer selectedTipoDocumentoPersonaNatural;
    private String primerNombrePersonaNatural;
    private String segundoNombrePersonaNatural;
    private String primerApellidoPersonaNatural;
    private String segundoApellidoPersonaNatural;
    private String telefonoPersonaNatural;
    private String celularPersonaNatural;
    private String direccionPersonaNatural;
    private Integer selectedCiudadPersonaNatural;
    private String usuarioCreacionPersonaNatural;
    private String usuarioModificacionPersonaNatural;
    private Integer estado;
    private Integer selectedRolPersonaNatural;

    //objetos y listas/////////
    private PersonaNaturalVO personaNaturalVO;
    private PersonaNaturalVO selectedPersona;
    private List<PersonaNaturalVO> personasFiltro;
    private List<PersonaNaturalVO> personaNaturales;
    private List<CiudadVO> ciudades;
    private List<RolVO> roles;
    private List<TipoDocumentoVO> tiposDocumento;

    /// Services////////////
    private CiudadService ciudadService;
    private PersonaNaturalService personaNaturalService;
    private RolService rolService;
    private TipoDocumentoService tipoDocumentoService;

    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                //se inicializan los services y  objetos
                personaNaturalService = new PersonaNaturalService();
                ciudadService = new CiudadService();
                rolService = new RolService();
                tipoDocumentoService = new TipoDocumentoService();

                ciudades = ciudadService.listar();
                roles = rolService.listar();
                personaNaturales = personaNaturalService.listar();
                tiposDocumento = tipoDocumentoService.listar();

            } catch (Exception e) {

            }
        }
    }

    public void actualizar(Integer id) {
        try {
            personaNaturalVO = new PersonaNaturalVO();
            
            personaNaturalVO.setIdPersonaNatural(id);

            personaNaturalVO.setIdentificacionPersonaNatural(identificacionPersonaNatural);
            personaNaturalVO.getTipoDocumentoPersonaNatural().setIdTipoDocumento(selectedTipoDocumentoPersonaNatural);
            personaNaturalVO.setPrimerNombrePersonaNatural(primerNombrePersonaNatural);
            personaNaturalVO.setSegundoNombrePersonaNatural(segundoNombrePersonaNatural);
            personaNaturalVO.setPrimerApellidoPersonaNatural(primerApellidoPersonaNatural);
            personaNaturalVO.setSegundoApellidoPersonaNatural(segundoApellidoPersonaNatural);
            personaNaturalVO.setTelefonoPersonaNatural(telefonoPersonaNatural);
            personaNaturalVO.setCelularPersonaNatural(celularPersonaNatural);
            personaNaturalVO.setDireccionPersonaNatural(direccionPersonaNatural);
            personaNaturalVO.getCiudadPersonaNatural().setIdCiudad(selectedCiudadPersonaNatural);
            personaNaturalVO.getRolPersonaNatural().setIdRol(selectedRolPersonaNatural);
            personaNaturalVO.setUsuarioCreacionPersonaNatural(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));

            if (personaNaturalService.actualizar(personaNaturalVO) > 0) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "se actualizo "));
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Se produjo un error "));
            }
        } catch (Exception e) {
        }
    }

    public void consultarPorId() {
        try {
            personaNaturalVO = new PersonaNaturalVO();
            idPersonaNatural = selectedPersona.getIdPersonaNatural();

            personaNaturalVO = personaNaturalService.consultarPorId(idPersonaNatural);
            
        } catch (Exception e) {
        }
    }

    public void insertar() {
        try {
            personaNaturalVO = new PersonaNaturalVO();

            personaNaturalVO.setIdentificacionPersonaNatural(identificacionPersonaNatural);
            personaNaturalVO.getTipoDocumentoPersonaNatural().setIdTipoDocumento(selectedTipoDocumentoPersonaNatural);
            personaNaturalVO.setPrimerNombrePersonaNatural(primerNombrePersonaNatural);
            personaNaturalVO.setSegundoNombrePersonaNatural(segundoNombrePersonaNatural);
            personaNaturalVO.setPrimerApellidoPersonaNatural(primerApellidoPersonaNatural);
            personaNaturalVO.setSegundoApellidoPersonaNatural(segundoApellidoPersonaNatural);
            personaNaturalVO.setTelefonoPersonaNatural(telefonoPersonaNatural);
            personaNaturalVO.setCelularPersonaNatural(celularPersonaNatural);
            personaNaturalVO.setDireccionPersonaNatural(direccionPersonaNatural);
            personaNaturalVO.getCiudadPersonaNatural().setIdCiudad(selectedCiudadPersonaNatural);
            personaNaturalVO.getRolPersonaNatural().setIdRol(selectedRolPersonaNatural);
            personaNaturalVO.setUsuarioCreacionPersonaNatural(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));

            if (personaNaturalService.insertar(personaNaturalVO) > 0) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "se guardó "));
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Se produjo un error "));
            }

        } catch (Exception e) {
            System.out.println("error: "+ e.getMessage());
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        ClienteBean.serialVersionUID = serialVersionUID;
    }

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

    public Integer getSelectedTipoDocumentoPersonaNatural() {
        return selectedTipoDocumentoPersonaNatural;
    }

    public void setSelectedTipoDocumentoPersonaNatural(Integer selectedTipoDocumentoPersonaNatural) {
        this.selectedTipoDocumentoPersonaNatural = selectedTipoDocumentoPersonaNatural;
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

    public Integer getSelectedCiudadPersonaNatural() {
        return selectedCiudadPersonaNatural;
    }

    public void setSelectedCiudadPersonaNatural(Integer selectedCiudadPersonaNatural) {
        this.selectedCiudadPersonaNatural = selectedCiudadPersonaNatural;
    }

    public String getUsuarioCreacionPersonaNatural() {
        return usuarioCreacionPersonaNatural;
    }

    public void setUsuarioCreacionPersonaNatural(String usuarioCreacionPersonaNatural) {
        this.usuarioCreacionPersonaNatural = usuarioCreacionPersonaNatural;
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

    public Integer getSelectedRolPersonaNatural() {
        return selectedRolPersonaNatural;
    }

    public void setSelectedRolPersonaNatural(Integer selectedRolPersonaNatural) {
        this.selectedRolPersonaNatural = selectedRolPersonaNatural;
    }

    public List<CiudadVO> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<CiudadVO> ciudades) {
        this.ciudades = ciudades;
    }

    public List<RolVO> getRoles() {
        return roles;
    }

    public void setRoles(List<RolVO> roles) {
        this.roles = roles;
    }

    public CiudadService getCiudadService() {
        return ciudadService;
    }

    public void setCiudadService(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public RolService getRolService() {
        return rolService;
    }

    public void setRolService(RolService rolService) {
        this.rolService = rolService;
    }

    public PersonaNaturalVO getPersonaNaturalVO() {
        return personaNaturalVO;
    }

    public void setPersonaNaturalVO(PersonaNaturalVO personaNaturalVO) {
        this.personaNaturalVO = personaNaturalVO;
    }

    public PersonaNaturalService getPersonaNaturalService() {
        return personaNaturalService;
    }

    public void setPersonaNaturalService(PersonaNaturalService personaNaturalService) {
        this.personaNaturalService = personaNaturalService;
    }

    public List<PersonaNaturalVO> getPersonaNaturales() {
        return personaNaturales;
    }

    public void setPersonaNaturales(List<PersonaNaturalVO> personaNaturales) {
        this.personaNaturales = personaNaturales;
    }

    public PersonaNaturalVO getSelectedPersona() {
        return selectedPersona;
    }

    public void setSelectedPersona(PersonaNaturalVO selectedPersona) {
        this.selectedPersona = selectedPersona;
    }

    public List<PersonaNaturalVO> getPersonasFiltro() {
        return personasFiltro;
    }

    public void setPersonasFiltro(List<PersonaNaturalVO> personasFiltro) {
        this.personasFiltro = personasFiltro;
    }

    public List<TipoDocumentoVO> getTiposDocumento() {
        return tiposDocumento;
    }

    public void setTiposDocumento(List<TipoDocumentoVO> tiposDocumento) {
        this.tiposDocumento = tiposDocumento;
    }

}
