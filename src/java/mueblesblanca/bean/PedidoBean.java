/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import mueblesblanca.constante.EstadoEnum;
import mueblesblanca.constante.EstadoEnumLista;
import mueblesblanca.constante.UsuarioEnum;
import mueblesblanca.service.PedidoService;
import mueblesblanca.service.ProveedorService;
import mueblesblanca.service.InsumoService;
import mueblesblanca.vo.InsumoVO;
import mueblesblanca.vo.PedidoVO;
import mueblesblanca.vo.ProveedorVO;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Sergio Alfonso G
 */
@ManagedBean(name = "pedidoBean")
@ViewScoped
public class PedidoBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private Integer idPedido;
    private Integer selectedIdInsumo;
    private Integer selectedIdProveedor;
    private Timestamp fechaSugerida;
    private String observaciones;
    private String usuarioCreacion;
    private String usuarioModificacion;
    private Integer estadoPedido;
    private Integer selectedEstado;
    private InsumoVO insumoVO;    
    private ProveedorVO proveedorVO;

    //objetos y listas/////////
    private PedidoVO pedidoVO;
    private PedidoVO selectedPedido;
    private List<PedidoVO> pedidosFiltro;
    private List<PedidoVO> pedidos;
    private List<InsumoVO> insumos;
    private List<ProveedorVO> proveedores;
    private Map<String, Integer> estadosEnum;

    /// Services////////////
    private PedidoService pedidoService;
    private ProveedorService proveedorService;
    private InsumoService insumoService;

    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                //se inicializan los services y  objetos
                pedidoService = new PedidoService();
                proveedorService = new ProveedorService();
                insumoService = new InsumoService();

                setPedidos(pedidoService.listar());
                setProveedores(proveedorService.listar());
                setInsumos(insumoService.listar());

                setEstadosEnum(new HashMap< String, Integer>());

                for (EstadoEnumLista enl : EstadoEnumLista.values()) {
                    getEstadosEnum().put(enl.getNombre(), enl.getIndex());
                }

            } catch (Exception e) {

            }
        }
    }

    public void actualizar(Integer id) {
        try {
            setPedidoVO(new PedidoVO());

            getPedidoVO().setIdPedido(id);

            getPedidoVO().getInsumo().setIdInsumo(selectedIdInsumo);
            getPedidoVO().getProveedor().setIdProveedor(selectedIdProveedor);            
            getPedidoVO().setFechaSugeridaPedido(fechaSugerida);
            getPedidoVO().setObservacionPedido(observaciones);
            getPedidoVO().setUsuarioModificacionPedido(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));
            getPedidoVO().setEstado(estadoPedido);

            if (pedidoService.actualizar(getPedidoVO()) > 0) {
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
            pedidoVO = new PedidoVO();
            idPedido = selectedPedido.getIdPedido();

            pedidoVO = pedidoService.consultarPorId(idPedido);
            
        } catch (Exception e) {
        }
    }

    public void insertar() {
        try {
            pedidoVO = new PedidoVO();

            pedidoVO.getInsumo().setIdInsumo(selectedIdInsumo);
            pedidoVO.getProveedor().setIdProveedor(selectedIdProveedor);
            pedidoVO.setFechaSugeridaPedido(fechaSugerida);
            pedidoVO.setObservacionPedido(observaciones);
            pedidoVO.setUsuarioCreacionPedido(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));
            pedidoVO.setEstado(selectedEstado);

            if (pedidoService.insertar(getPedidoVO()) > 0) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "se guardó "));
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Se produjo un error "));
            }

        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public Integer getIdPedido() {
        return idPedido;
    }
    
    public String ValorEstado(Integer idestado) {
        if (idestado != null) {
            return EstadoEnum.get(idestado).toString();
        } else {
            return "";
        }
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Timestamp getFechaSugerida() {
        return fechaSugerida;
    }

    public void getFechaSugerida(Timestamp fechaSugerida) {
        this.fechaSugerida = fechaSugerida;
    }

    public Integer getSelectedIdInsumo() {
        return selectedIdInsumo;
    }

    public void setSelectedIdInsumo(Integer selectedIdInsumo) {
        this.selectedIdInsumo = selectedIdInsumo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getSelectedproveedor() {
        return selectedIdProveedor;
    }

    public void setSelectedProveedor(Integer selectedIdProveedor) {
        this.selectedIdProveedor = selectedIdProveedor;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Integer getEstadoProducto() {
        return estadoPedido;
    }

    public void setEstadoPedido(Integer estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public List<PedidoVO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoVO> pedidos) {
        this.pedidos = pedidos;
    }

    public List<InsumoVO> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<InsumoVO> insumos) {
        this.insumos = insumos;
    }

    public List<ProveedorVO> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<ProveedorVO> proveedores) {
        this.proveedores = proveedores;
    }

    public Integer getSelectedEstado() {
        return selectedEstado;
    }

    public void setSelectedEstado(Integer selectedEstado) {
        this.selectedEstado = selectedEstado;
    }

    public Map<String, Integer> getEstadosEnum() {
        return estadosEnum;
    }

    public void setEstadosEnum(Map<String, Integer> estadosEnum) {
        this.estadosEnum = estadosEnum;
    }

    public PedidoVO getSelectedPedido() {
        return selectedPedido;
    }

    public void setSelectedPedido(PedidoVO selectedPedido) {
        this.selectedPedido = selectedPedido;
    }

    public PedidoVO getPedidoVO() {
        return pedidoVO;
    }

    public void setPedidoVO(PedidoVO pedidoVO) {
        this.pedidoVO = pedidoVO;
    }

    public List<PedidoVO> getPedidosFiltro() {
        return pedidosFiltro;
    }

    public void setPedidosFiltro(List<PedidoVO> pedidosFiltro) {
        this.pedidosFiltro = pedidosFiltro;
    }

    public InsumoVO getInsumoVO() {
        return insumoVO;
    }

    public void setInsumoVO(InsumoVO insumoVO) {
        this.insumoVO = insumoVO;
    }
    
    public ProveedorVO getproveedorVO() {
        return proveedorVO;
    }

    public void setProveedorVO(ProveedorVO proveedorVO) {
        this.proveedorVO = proveedorVO;
    }

}
