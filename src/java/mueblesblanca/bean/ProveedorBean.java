/*
 * To change this license header;choose License Headers in Project Properties.
 * To change this template file;choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mueblesblanca.constante.EstadoEnum;
import mueblesblanca.constante.UsuarioEnum;
import mueblesblanca.service.ProveedorService;
import mueblesblanca.vo.ProveedorVO;
import org.apache.commons.lang3.ArrayUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author cochoa
 */
@ManagedBean(name = "proveedorBean")
@ViewScoped
public class ProveedorBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private Integer idProveedor;
    private String razonSocialProveedor;
    private String direccionProveedor;
    private Integer telefonoProveedor;
    private String correoProveedor;
    private Timestamp fechaModificacionProveedor;
    private String usuarioModificacionProveedor;
    private Integer estado;
    private Integer id;
    private String nombre;
    private Integer selectedEstado;
    private List<String> estados;
    //objetos y listas/////////
    private ProveedorVO proveedorVO;
    private List<ProveedorVO> proveedoresVO;
    private ProveedorVO selectedProveedor;
    private List<ProveedorVO> proveedorFiltro;
     private Map<Integer,String> estadosEnum;

    //Services ///////////
    private ProveedorService proveedorService;

    @PostConstruct
    public void init() {

        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                proveedorService = new ProveedorService();

                proveedoresVO = proveedorService.listar();

                estadosEnum = new HashMap<Integer, String>();
                
                for (int i = 0; i < EstadoEnum.values().length; i++) {
                    estadosEnum.put(EstadoEnum.get(i).getIndex(), EstadoEnum.get(i).getDeclaringClass().getName());
                }
                
            } catch (Exception e) {

            }
        }
    }

    public void onAddNew() {
        try {
            ProveedorVO proveedorVO = new ProveedorVO();
            proveedoresVO = proveedorService.listar();
            proveedoresVO.add(proveedorVO);
            FacesMessage msg = new FacesMessage("Registro agregado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {

        }
    }

    public void onRowEdit(RowEditEvent event) {
        try {
            proveedorVO = new ProveedorVO();

            if (selectedProveedor == null) {
                id = 0;
            } else {
                id = selectedProveedor.getIdProveedor();
            }

            nombre = ((ProveedorVO) event.getObject()).getRazonSocialProveedor();

            if (id != 0) {
                proveedorVO = proveedorService.consultarPorId(id);

                proveedorVO.setIdProveedor(id);
                proveedorVO.setRazonSocialProveedor(nombre);
                proveedorVO.setDireccionProveedor(direccionProveedor);
                proveedorVO.setTelefonoProveedor(telefonoProveedor);
                proveedorVO.setCorreoProveedor(correoProveedor);
                proveedorVO.setUsuarioModificacionProveedor(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));
                proveedorVO.setEstado(selectedEstado);

                if (proveedorService.actualizar(proveedorVO) > 0) {
                    FacesMessage msg = new FacesMessage("actualizado");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    FacesMessage msg = new FacesMessage("NO actualizado");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else {
                proveedorVO.setRazonSocialProveedor(nombre);
                proveedorVO.setDireccionProveedor(direccionProveedor);
                proveedorVO.setTelefonoProveedor(telefonoProveedor);
                proveedorVO.setCorreoProveedor(correoProveedor);
                proveedorVO.setUsuarioModificacionProveedor(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));

                if (proveedorService.insertar(proveedorVO) > 0) {
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

    public void listar() {
        try {
            proveedoresVO = proveedorService.listar();
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        ProveedorBean.serialVersionUID = serialVersionUID;
    }

    public ProveedorService getProveedorService() {
        return proveedorService;
    }

    public void setProveedorService(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    public ProveedorVO getProveedorVO() {
        return proveedorVO;
    }

    public void setProveedorVO(ProveedorVO proveedorVO) {
        this.proveedorVO = proveedorVO;
    }

    public List<ProveedorVO> getProveedores() {
        return proveedoresVO;
    }

    public void setProveedores(List<ProveedorVO> proveedoresVO) {
        this.proveedoresVO = proveedoresVO;
    }

    public ProveedorVO getSelectedProveedor() {
        return selectedProveedor;
    }

    public void setSelectedProveedor(ProveedorVO selectedProveedor) {
        this.selectedProveedor = selectedProveedor;
    }

    public List<ProveedorVO> getProveedoresFiltro() {
        return proveedorFiltro;
    }

    public void setProveedoresFiltro(List<ProveedorVO> proveedorFiltro) {
        this.proveedorFiltro = proveedorFiltro;
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

    public Map<Integer, String> getEstadosEnum() {
        return estadosEnum;
    }

    public void setEstadosEnum(Map<Integer, String> estadosEnum) {
        this.estadosEnum = estadosEnum;
    }

    
    
    
}
