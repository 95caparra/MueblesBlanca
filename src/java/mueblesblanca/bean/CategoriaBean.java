package mueblesblanca.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import mueblesblanca.service.CategoriaService;
import mueblesblanca.vo.CategoriaVO;
import org.primefaces.event.RowEditEvent;

import mueblesblanca.constante.UsuarioEnum;

@ManagedBean(name = "categoriaBean")
@ViewScoped
public class CategoriaBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private CategoriaService categoriaService;
    private CategoriaVO categoriaVO;
    private List<CategoriaVO> categorias;
    private CategoriaVO selectedCategoria;
    private List<CategoriaVO> categoriasFiltro;

    private Integer id;
    private String nombre;

    @PostConstruct
    public void init() {

        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                setCategoriaService(new CategoriaService());

                setCiudades(getCategoriaService().listar());

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
            categoriaVO = new CategoriaVO();
            if (id != 0) {
                categoriaVO = categoriaService.consultarPorId(id);

                categoriaVO.setIdCategoria(id);
                categoriaVO.setDescripcionCategoria(nombre);
                categoriaVO.setUsuarioModificacionCategoria(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));

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
    public CategoriaService getCategoriaService() {
        return categoriaService;
    }

    /**
     * @param ciudadService the ciudadService to set
     */
    public void setCategoriaService(CategoriaService ciudadService) {
        this.categoriaService = ciudadService;
    }

    /**
     * @return the ciudadVO
     */
    public CategoriaVO getCategoriaVO() {
        return categoriaVO;
    }

    /**
     * @param ciudadVO the ciudadVO to set
     */
    public void setCategoriaVO(CategoriaVO categeriaVO) {
        this.categoriaVO = categoriaVO;
    }

    /**
     * @return the ciudades
     */
    public List<CategoriaVO> getCategorias() {
        return categorias;
    }

    /**
     * @param ciudades the ciudades to set
     */
    public void setCiudades(List<CategoriaVO> categorias) {
        this.categorias = categorias;
    }

    /**
     * @return the selectedCiudad
     */
    public CategoriaVO getSelectedCategoria() {
        return selectedCategoria;
    }

    /**
     * @param selectedCiudad the selectedCiudad to set
     */
    public void setSelectedCategoria(CategoriaVO selectedCategoria) {
        this.selectedCategoria = selectedCategoria;
    }

    /**
     * @return the ciudadesFiltro
     */
    public List<CategoriaVO> getCategoriasFiltro() {
        return categoriasFiltro;
    }

    /**
     * @param ciudadesFiltro the ciudadesFiltro to set
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

}
