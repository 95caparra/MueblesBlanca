package mueblesblanca.bean;

import java.io.Serializable;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import mueblesblanca.constante.EstadoEnum;
import mueblesblanca.constante.EstadoEnumLista;
import mueblesblanca.constante.UsuarioEnum;
import mueblesblanca.service.CategoriaService;
import mueblesblanca.vo.CategoriaVO;
import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "categoriaBean")
@ViewScoped
public class CategoriaBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private CategoriaService categoriaService;
    private CategoriaVO categoriaVO;
    private List<CategoriaVO> categorias;
    private CategoriaVO selectedCategoria;
    private List<CategoriaVO> categoriasFiltro;
    private List<String> estados;

    private Integer id;
    private String nombre;
    private Integer estado;
    private Integer selectedEstado;
    private Map<String, Integer> estadosEnum;
    
    @PostConstruct
    public void init() {

        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                setCategoriaService(new CategoriaService());

                setCategorias(getCategoriaService().listar());
                
                estadosEnum = new HashMap< String, Integer>();
                
                for (EstadoEnumLista enl : EstadoEnumLista.values()) {
                    estadosEnum.put(enl.getNombre(), enl.getIndex());
                }                

            } catch (Exception e) {

            }
        }
    }

    public void onAddNew() {
        try {
            CategoriaVO categoriaVO = new CategoriaVO();
            categorias = categoriaService.listar();
            categorias.add(categoriaVO);
            FacesMessage msg = new FacesMessage("Registro agregado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {

        }
    }

    public void onRowEdit(RowEditEvent event) {
        try {
            id = ((CategoriaVO) event.getObject()).getIdCategoria();
            if (id == null) {
                id = 0;
            }
            nombre = ((CategoriaVO) event.getObject()).getDescripcionCategoria();
            estado = selectedEstado;
            categoriaVO = new CategoriaVO();
            
            if (id != 0) {
                categoriaVO = categoriaService.consultarPorId(id);

                categoriaVO.setIdCategoria(id);
                categoriaVO.setDescripcionCategoria(nombre);
                categoriaVO.setUsuarioModificacionCategoria(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));
                categoriaVO.setEstado(selectedEstado);

                if (categoriaService.actualizar(categoriaVO) > 0) {
                    FacesMessage msg = new FacesMessage("actualizado");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    FacesMessage msg = new FacesMessage("NO actualizado");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else {
                categoriaVO.setDescripcionCategoria(nombre);
                categoriaVO.setUsuarioCreacionCategoria(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));
                categoriaVO.setEstado(estado);

                if (categoriaService.insertar(categoriaVO) > 0) {
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
            categorias = categoriaService.listar();
        } catch (Exception e) {
        }        
    }
    
    public String ValorEstado(Integer idestado) {
        if (idestado != null) {
            return EstadoEnum.get(idestado).toString();
        } else {
            return "";
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
     * @return the categoriaService
     */
    public CategoriaService getCategoriaService() {
        return categoriaService;
    }

    /**
     * @param categoriaService the categoriaService to set
     */
    public void setCategoriaService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    /**
     * @return the categoriaVO
     */
    public CategoriaVO getCategoriaVO() {
        return categoriaVO;
    }

    /**
     * @param categoriaVO the categoriaVO to set
     */
    public void setCategoriaVO(CategoriaVO categeriaVO) {
        this.categoriaVO = categoriaVO;
    }

    /**
     * @return the categorias
     */
    public List<CategoriaVO> getCategorias() {
        return categorias;
    }

    /**
     * @param categorias the categorias to set
     */
    public void setCategorias(List<CategoriaVO> categorias) {
        this.categorias = categorias;
    }

    /**
     * @return the selectedCategoria
     */
    public CategoriaVO getSelectedCategoria() {
        return selectedCategoria;
    }

    /**
     * @param selectedCategoria the selectedCategoria to set
     */
    public void setSelectedCategoria(CategoriaVO selectedCategoria) {
        this.selectedCategoria = selectedCategoria;
    }

    /**
     * @return the categoriasFiltro
     */
    public List<CategoriaVO> getCategoriasFiltro() {
        return categoriasFiltro;
    }

    /**
     * @param categoriasFiltro the categoriasFiltro to set
     */
    public void setCategoriasFiltro(List<CategoriaVO> categoriasFiltro) {
        this.categoriasFiltro = categoriasFiltro;
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
    
    /**
     * @return the selectedEstado
     */
    public Integer getSelectedEstado() {
        return selectedEstado;
    }

    /**
     * @param selectedEstado the selectedEstado to set
     */
    public void setSelectedEstado(Integer selectedEstado) {
        this.selectedEstado = selectedEstado;
    }

    public String data = "1";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Map< String, Integer> getEstadosEnum() {
        return estadosEnum;
    }

    public void setEstadosEnum(Map< String, Integer> estadosEnum) {
        this.estadosEnum = estadosEnum;
    }

}
