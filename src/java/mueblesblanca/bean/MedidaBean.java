package mueblesblanca.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import mueblesblanca.service.MedidaService;
import mueblesblanca.vo.MedidaVO;
import org.primefaces.event.RowEditEvent;

import mueblesblanca.constante.UsuarioEnum;

@ManagedBean(name = "medidaBean")
@ViewScoped
public class MedidaBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private MedidaService medidaService;
    private MedidaVO medidaVO;
    private List<MedidaVO> medidas;
    private MedidaVO selectedMedida;
    private List<MedidaVO> medidasFiltro;

    private Integer id;
    private String nombre;

    @PostConstruct
    public void init() {

        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                setMedidaService(new MedidaService());

                setMedidas(getMedidaService().listar());

            } catch (Exception e) {

            }
        }
    }

    public void onAddNew() {
        try {
            MedidaVO medidaVO = new MedidaVO();
            medidas = medidaService.listar();
            medidas.add(medidaVO);
            FacesMessage msg = new FacesMessage("Registro agregado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {

        }
    }

    public void onRowEdit(RowEditEvent event) {
        try {
            id = ((MedidaVO) event.getObject()).getIdMedida();
            if (id == null) {
                id = 0;
            }
            nombre = ((MedidaVO) event.getObject()).getDescripcionMedida();
            medidaVO = new MedidaVO();
            if (id != 0) {
                medidaVO = medidaService.consultarPorId(id);

                medidaVO.setIdMedida(id);
                medidaVO.setDescripcionMedida(nombre);
                medidaVO.setUsuarioModificacionMedida(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));

                if (medidaService.actualizar(medidaVO) > 0) {
                    FacesMessage msg = new FacesMessage("actualizado");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    FacesMessage msg = new FacesMessage("NO actualizado");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else {
                medidaVO.setDescripcionMedida(nombre);
                medidaVO.setUsuarioCreacionMedida(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));

                if (medidaService.insertar(medidaVO) > 0) {
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
            medidas = medidaService.listar();
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
     * @return the medidaService
     */
    public MedidaService getMedidaService() {
        return medidaService;
    }

    /**
     * @param medidaService the medidaService to set
     */
    public void setMedidaService(MedidaService medidaService) {
        this.medidaService = medidaService;
    }

    /**
     * @return the medidaVO
     */
    public MedidaVO getMedidaVO() {
        return medidaVO;
    }

    /**
     * @param medidaVO the medidaVO to set
     */
    public void setMedidaVO(MedidaVO medidaVO) {
        this.medidaVO = medidaVO;
    }

    /**
     * @return the medidas
     */
    public List<MedidaVO> getMedidas() {
        return medidas;
    }

    /**
     * @param medidas the medidas to set
     */
    public void setMedidas(List<MedidaVO> medidas) {
        this.medidas = medidas;
    }

    /**
     * @return the selectedMedida
     */
    public MedidaVO getSelectedMedida() {
        return selectedMedida;
    }

    /**
     * @param selectedMedida the selectedMedida to set
     */
    public void setSelectedMedida(MedidaVO selectedMedida) {
        this.selectedMedida = selectedMedida;
    }

    /**
     * @return the medidasFiltro
     */
    public List<MedidaVO> getMedidasFiltro() {
        return medidasFiltro;
    }

    /**
     * @param medidasFiltro the medidasFiltro to set
     */
    public void setMedidasFiltro(List<MedidaVO> medidasFiltro) {
        this.medidasFiltro = medidasFiltro;
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
