package mueblesblanca.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import mueblesblanca.service.CiudadService;
import mueblesblanca.vo.CiudadVO;
import org.primefaces.event.RowEditEvent;

import mueblesblanca.constante.UsuarioEnum;

@ManagedBean(name = "ciudadBean")
@ViewScoped
public class CiudadBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private CiudadService ciudadService;
    private CiudadVO ciudadVO;
    private List<CiudadVO> ciudades;
    private CiudadVO selectedCiudad;
    private List<CiudadVO> ciudadesFiltro;

    private Integer id;
    private String nombre;

    @PostConstruct
    public void init() {

        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                setCiudadService(new CiudadService());

                setCiudades(getCiudadService().listar());

            } catch (Exception e) {

            }
        }
    }

    public void onAddNew() {
        try {
            CiudadVO ciudadVO = new CiudadVO();
            ciudades = ciudadService.listar();
            ciudades.add(ciudadVO);
            FacesMessage msg = new FacesMessage("Registro agregado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {

        }
    }

    public void onRowEdit(RowEditEvent event) {
        try {
            ciudadVO = new CiudadVO();

            if (selectedCiudad == null) {
                id = 0;
            } else {
                id = selectedCiudad.getIdCiudad();
            }

            nombre = ((CiudadVO) event.getObject()).getDescripcionCiudad();

            if (id != 0) {
                ciudadVO = ciudadService.consultarPorId(id);

                ciudadVO.setIdCiudad(id);
                ciudadVO.setDescripcionCiudad(nombre);
                ciudadVO.setUsuarioModificacionCiudad(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));

                if (ciudadService.actualizar(ciudadVO) > 0) {
                    FacesMessage msg = new FacesMessage("actualizado");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    FacesMessage msg = new FacesMessage("NO actualizado");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else {
                ciudadVO.setDescripcionCiudad(nombre);
                ciudadVO.setUsuarioCreacionCiudad(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));

                if (ciudadService.insertar(ciudadVO) > 0) {
                    FacesMessage msg = new FacesMessage("insertado");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    FacesMessage msg = new FacesMessage("NO insertado");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
                
                listar();
                
            }

        } catch (Exception e) {
        }
    }
    
    public void listar(){
        try {
            ciudades = ciudadService.listar();
        } catch (Exception e) {
        }        
    }

    public void onRowCancel(RowEditEvent event) {

    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the ciudadService
     */
    public CiudadService getCiudadService() {
        return ciudadService;
    }

    /**
     * @param ciudadService the ciudadService to set
     */
    public void setCiudadService(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    /**
     * @return the ciudadVO
     */
    public CiudadVO getCiudadVO() {
        return ciudadVO;
    }

    /**
     * @param ciudadVO the ciudadVO to set
     */
    public void setCiudadVO(CiudadVO ciudadVO) {
        this.ciudadVO = ciudadVO;
    }

    /**
     * @return the ciudades
     */
    public List<CiudadVO> getCiudades() {
        return ciudades;
    }

    /**
     * @param ciudades the ciudades to set
     */
    public void setCiudades(List<CiudadVO> ciudades) {
        this.ciudades = ciudades;
    }

    /**
     * @return the selectedCiudad
     */
    public CiudadVO getSelectedCiudad() {
        return selectedCiudad;
    }

    /**
     * @param selectedCiudad the selectedCiudad to set
     */
    public void setSelectedCiudad(CiudadVO selectedCiudad) {
        this.selectedCiudad = selectedCiudad;
    }

    /**
     * @return the ciudadesFiltro
     */
    public List<CiudadVO> getCiudadesFiltro() {
        return ciudadesFiltro;
    }

    /**
     * @param ciudadesFiltro the ciudadesFiltro to set
     */
    public void setCiudadesFiltro(List<CiudadVO> ciudadesFiltro) {
        this.ciudadesFiltro = ciudadesFiltro;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}