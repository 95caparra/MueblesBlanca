package mueblesblanca.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import mueblesblanca.service.EstadoOrdenService;
import mueblesblanca.vo.EstadoOrdenVO;
import org.primefaces.event.RowEditEvent;

import mueblesblanca.constante.UsuarioEnum;

@ManagedBean(name = "estadoOrdenBean")
@ViewScoped
public class EstadoOrdenBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private EstadoOrdenService estadoOrdenService;
    private EstadoOrdenVO estadoOrdenVO;
    private List<EstadoOrdenVO> estadosOrden;
    private EstadoOrdenVO selectedEstadoOrden;
    private List<EstadoOrdenVO> estadosOrdenFiltro;

    private Integer id;
    private String nombre;

    @PostConstruct
    public void init() {

        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                setEstadoOrdenService(new EstadoOrdenService());

                setEstadosOrden(getEstadoOrdenService().listar());

            } catch (Exception e) {

            }
        }
    }

    public void onAddNew() {
        try {
            EstadoOrdenVO estadoOrdenVO = new EstadoOrdenVO();
            estadosOrden = estadoOrdenService.listar();
            estadosOrden.add(estadoOrdenVO);
            FacesMessage msg = new FacesMessage("Registro agregado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {

        }
    }

    public void onRowEdit(RowEditEvent event) {
        try {
            id = ((EstadoOrdenVO) event.getObject()).getIdEstadoOrden();
            if (id == null) {
                id = 0;
            }
            nombre = ((EstadoOrdenVO) event.getObject()).getDescripcionEstadoOrden();
            estadoOrdenVO = new EstadoOrdenVO();
            if (id != 0) {
                estadoOrdenVO = estadoOrdenService.consultarPorId(id);

                estadoOrdenVO.setIdEstadoOrden(id);
                estadoOrdenVO.setDescripcionEstadoOrden(nombre);
                estadoOrdenVO.setUsuarioModificacionEstadoOrden(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));

                if (estadoOrdenService.actualizar(estadoOrdenVO) > 0) {
                    FacesMessage msg = new FacesMessage("actualizado");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    FacesMessage msg = new FacesMessage("NO actualizado");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else {
                estadoOrdenVO.setDescripcionEstadoOrden(nombre);
                estadoOrdenVO.setUsuarioCreacionEstadoOrden(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));

                if (estadoOrdenService.insertar(estadoOrdenVO) > 0) {
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
            estadosOrden = estadoOrdenService.listar();
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
     * @return the estadoOrdenService
     */
    public EstadoOrdenService getEstadoOrdenService() {
        return estadoOrdenService;
    }

    /**
     * @param estadoOrdenService the estadoOrdenService to set
     */
    public void setEstadoOrdenService(EstadoOrdenService estadoOrdenService) {
        this.estadoOrdenService = estadoOrdenService;
    }

    /**
     * @return the estadoOrdenVO
     */
    public EstadoOrdenVO getEstadoOrdenVO() {
        return estadoOrdenVO;
    }

    /**
     * @param estadoOrdenVO the estadoOrdenVO to set
     */
    public void setEstadoOrdenVO(EstadoOrdenVO estadoOrdenVO) {
        this.estadoOrdenVO = estadoOrdenVO;
    }

    /**
     * @return the estadosOrden
     */
    public List<EstadoOrdenVO> getEstadosOrden() {
        return estadosOrden;
    }

    /**
     * @param estadosOrden the estadosOrden to set
     */
    public void setEstadosOrden(List<EstadoOrdenVO> estadosOrden) {
        this.estadosOrden = estadosOrden;
    }

    /**
     * @return the selectedEstadoOrden
     */
    public EstadoOrdenVO getSelectedEstadoOrden() {
        return selectedEstadoOrden;
    }

    /**
     * @param selectedEstadoOrden the selectedEstadoOrden to set
     */
    public void setSelectedEstadoOrden(EstadoOrdenVO selectedEstadoOrden) {
        this.selectedEstadoOrden = selectedEstadoOrden;
    }

    /**
     * @return the estadosOrdenFiltro
     */
    public List<EstadoOrdenVO> getEstadosOrdenFiltro() {
        return estadosOrdenFiltro;
    }

    /**
     * @param estadosOrdenFiltro the estadosOrdenFiltro to set
     */
    public void setMedidasFiltro(List<EstadoOrdenVO> estadosOrdenFiltro) {
        this.estadosOrdenFiltro = estadosOrdenFiltro;
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
