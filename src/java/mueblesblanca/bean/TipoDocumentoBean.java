package mueblesblanca.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import mueblesblanca.service.TipoDocumentoService;
import mueblesblanca.vo.TipoDocumentoVO;
import org.primefaces.event.RowEditEvent;

import mueblesblanca.constante.UsuarioEnum;

@ManagedBean(name = "tipoDocumentoBean")
@ViewScoped
public class TipoDocumentoBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private TipoDocumentoService tipoDocumentoService;
    private TipoDocumentoVO tipoDocumentoVO;
    private List<TipoDocumentoVO> tiposDocumento;
    private TipoDocumentoVO selectedTipoDocumento;
    private List<TipoDocumentoVO> tiposDocumentoFiltro;

    private Integer id;
    private String nombre;

    @PostConstruct
    public void init() {

        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                tipoDocumentoService = new TipoDocumentoService();
                
                tiposDocumento = tipoDocumentoService.listar();

            } catch (Exception e) {

            }
        }
    }

    public void onAddNew() {
        try {
            TipoDocumentoVO tipoDocumentoVO = new TipoDocumentoVO();
            tiposDocumento = tipoDocumentoService.listar();
            tiposDocumento.add(tipoDocumentoVO);
            FacesMessage msg = new FacesMessage("Registro agregado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {

        }
    }

    public void onRowEdit(RowEditEvent event) {
        try {
            tipoDocumentoVO = new TipoDocumentoVO();

            if (selectedTipoDocumento== null) {
                id = 0;
            } else {
                id = selectedTipoDocumento.getIdTipoDocumento();
            }

            nombre = ((TipoDocumentoVO) event.getObject()).getDescripcionTipoDocumento();

            if (id != 0) {
                tipoDocumentoVO = tipoDocumentoService.consultarPorId(id);

                tipoDocumentoVO.setIdTipoDocumento(id);
                tipoDocumentoVO.setDescripcionTipoDocumento(nombre);
                tipoDocumentoVO.setUsuarioModificacionTipoDocumento(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));

                if (tipoDocumentoService.actualizar(tipoDocumentoVO) > 0) {
                    FacesMessage msg = new FacesMessage("actualizado");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    FacesMessage msg = new FacesMessage("NO actualizado");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else {
                tipoDocumentoVO.setDescripcionTipoDocumento(nombre);
                tipoDocumentoVO.setUsuarioCreacionTipoDocumento(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));

                if (tipoDocumentoService.insertar(tipoDocumentoVO) > 0) {
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
            tiposDocumento = tipoDocumentoService.listar();
        } catch (Exception e) {
        }        
    }

    public void onRowCancel(RowEditEvent event) {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        TipoDocumentoBean.serialVersionUID = serialVersionUID;
    }

    public TipoDocumentoService getTipoDocumentoService() {
        return tipoDocumentoService;
    }

    public void setTipoDocumentoService(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    public TipoDocumentoVO getTipoDocumentoVO() {
        return tipoDocumentoVO;
    }

    public void setTipoDocumentoVO(TipoDocumentoVO tipoDocumentoVO) {
        this.tipoDocumentoVO = tipoDocumentoVO;
    }

    public List<TipoDocumentoVO> getTiposDocumento() {
        return tiposDocumento;
    }

    public void setTiposDocumento(List<TipoDocumentoVO> tiposDocumento) {
        this.tiposDocumento = tiposDocumento;
    }

    public TipoDocumentoVO getSelectedTipoDocumento() {
        return selectedTipoDocumento;
    }

    public void setSelectedTipoDocumento(TipoDocumentoVO selectedTipoDocumento) {
        this.selectedTipoDocumento = selectedTipoDocumento;
    }

    public List<TipoDocumentoVO> getTiposDocumentoFiltro() {
        return tiposDocumentoFiltro;
    }

    public void setTiposDocumentoFiltro(List<TipoDocumentoVO> tiposDocumentoFiltro) {
        this.tiposDocumentoFiltro = tiposDocumentoFiltro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

}
