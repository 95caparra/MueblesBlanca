package mueblesblanca.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import mueblesblanca.service.RolService;
import mueblesblanca.vo.RolVO;
import org.primefaces.event.RowEditEvent;

import mueblesblanca.constante.UsuarioEnum;

@ManagedBean(name = "rolBean")
@ViewScoped
public class RolBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private RolService rolService;
    private RolVO rolVO;
    private List<RolVO> roles;
    private RolVO selectedRol;
    private List<RolVO> rolFiltro;

    private Integer id;
    private String nombre;

    @PostConstruct
    public void init() {

        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                rolService = new RolService();
                
                roles = rolService.listar();

            } catch (Exception e) {

            }
        }
    }

    public void onAddNew() {
        try {
            RolVO rolVO = new RolVO();
            roles = rolService.listar();
            roles.add(rolVO);
            FacesMessage msg = new FacesMessage("Registro agregado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {

        }
    }

    public void onRowEdit(RowEditEvent event) {
        try {
            id = ((RolVO) event.getObject()).getIdRol();
            if (id == null) {
                id = 0;
            }
            nombre = ((RolVO) event.getObject()).getDescripcionRol();
            rolVO = new RolVO();
            
            if (id != 0) {
                rolVO = rolService.consultarPorId(id);

                rolVO.setIdRol(id);
                rolVO.setDescripcionRol(nombre);
                rolVO.setUsuarioModificacionRol(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));

                if (rolService.actualizar(rolVO) > 0) {
                    FacesMessage msg = new FacesMessage("actualizado");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    FacesMessage msg = new FacesMessage("NO actualizado");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else {
                rolVO.setDescripcionRol(nombre);
                rolVO.setUsuarioCreacionRol(String.valueOf(UsuarioEnum.USUARIO_DEFAULT.getIndex()));

                if (rolService.insertar(rolVO) > 0) {
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
            roles = rolService.listar();
        } catch (Exception e) {
        }        
    }

    public void onRowCancel(RowEditEvent event) {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        RolBean.serialVersionUID = serialVersionUID;
    }

    public RolService getRolService() {
        return rolService;
    }

    public void setRolService(RolService rolService) {
        this.rolService = rolService;
    }

    public RolVO getRolVO() {
        return rolVO;
    }

    public void setRolVO(RolVO rolVO) {
        this.rolVO = rolVO;
    }

    public List<RolVO> getRoles() {
        return roles;
    }

    public void setRoles(List<RolVO> roles) {
        this.roles = roles;
    }

    public RolVO getSelectedRol() {
        return selectedRol;
    }

    public void setSelectedRol(RolVO selectedRol) {
        this.selectedRol = selectedRol;
    }

    public List<RolVO> getRolFiltro() {
        return rolFiltro;
    }

    public void setRolFiltro(List<RolVO> rolFiltro) {
        this.rolFiltro = rolFiltro;
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
