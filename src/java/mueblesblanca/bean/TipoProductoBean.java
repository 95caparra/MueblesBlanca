package mueblesblanca.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import mueblesblanca.service.TipoProductoService;
import mueblesblanca.vo.TipoProductoVO;
import org.primefaces.event.RowEditEvent;

import mueblesblanca.constante.UsuarioEnum;

@ManagedBean(name = "tipoProductoBean")
@ViewScoped
public class TipoProductoBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private TipoProductoService tipoProductoService;
    private TipoProductoVO tipoProductoVO;
    private List<TipoProductoVO> tiposProducto;
    private TipoProductoVO selectedTipoProducto;
    private List<TipoProductoVO> tiposProductoFiltro;

    private Integer id;
    private String nombre;

    @PostConstruct
    public void init() {

        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                tipoProductoService = new TipoProductoService();
                
                tiposProducto = tipoProductoService.listar();

            } catch (Exception e) {

            }
        }
    }

    public void onAddNew() {
        try {
            TipoProductoVO tipoProductoVO = new TipoProductoVO();
            tiposProducto = tipoProductoService.listar();
            tiposProducto.add(tipoProductoVO);
            FacesMessage msg = new FacesMessage("Registro agregado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {

        }
    }

    public void onRowEdit(RowEditEvent event) {
        try {
            id = ((TipoProductoVO) event.getObject()).getIdTipoProducto();
            if (id == null) {
                id = 0;
            }
            nombre = ((TipoProductoVO) event.getObject()).getDescripcionTipoProducto();
            tipoProductoVO = new TipoProductoVO();

            if (id != 0) {
                tipoProductoVO = tipoProductoService.consultarPorId(id);

                tipoProductoVO.setIdTipoProducto(id);
                tipoProductoVO.setDescripcionTipoProducto(nombre);
                tipoProductoVO.setUsuarioModificacionTipoProducto(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));

                if (tipoProductoService.actualizar(tipoProductoVO) > 0) {
                    FacesMessage msg = new FacesMessage("actualizado");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    FacesMessage msg = new FacesMessage("NO actualizado");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else {
                tipoProductoVO.setDescripcionTipoProducto(nombre);
                tipoProductoVO.setUsuarioCreacionTipoProducto(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));

                if (tipoProductoService.insertar(tipoProductoVO) > 0) {
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
            tiposProducto = tipoProductoService.listar();
        } catch (Exception e) {
        }        
    }

    public void onRowCancel(RowEditEvent event) {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        TipoProductoBean.serialVersionUID = serialVersionUID;
    }

    public TipoProductoService getTipoProductoService() {
        return tipoProductoService;
    }

    public void setTipoProductoService(TipoProductoService tipoProductoService) {
        this.tipoProductoService = tipoProductoService;
    }

    public TipoProductoVO getTipoProductoVO() {
        return tipoProductoVO;
    }

    public void setTipoProductoVO(TipoProductoVO tipoProductoVO) {
        this.tipoProductoVO = tipoProductoVO;
    }

    public List<TipoProductoVO> getTiposProducto() {
        return tiposProducto;
    }

    public void setTiposProducto(List<TipoProductoVO> tiposProducto) {
        this.tiposProducto = tiposProducto;
    }

    public TipoProductoVO getSelectedTipoProducto() {
        return selectedTipoProducto;
    }

    public void setSelectedTipoProducto(TipoProductoVO selectedTipoProducto) {
        this.selectedTipoProducto = selectedTipoProducto;
    }

    public List<TipoProductoVO> getTiposProductoFiltro() {
        return tiposProductoFiltro;
    }

    public void setTiposDocumentoFiltro(List<TipoProductoVO> tiposProductoFiltro) {
        this.tiposProductoFiltro = tiposProductoFiltro;
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
