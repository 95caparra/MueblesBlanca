/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.bean;

import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mueblesblanca.service.ProductoService;
import mueblesblanca.vo.ProductoVO;
import mueblesblanca.vo.TipoProductoVO;

/**
 *
 * @author Fabian Garcia
 */
@ManagedBean(name = "singleBean")
@ViewScoped
public class SingleBean {

    private Integer idProducto;
    private String nombreProducto;
    private Integer selectedIdTipoProducto;
    private Integer cantidadExistente;
    private BigDecimal precioUnidadProducto;
    private Integer selectedMedida;
    private String usuarioCreacion;
    private String usuarioModificacion;
    private Integer estadoProducto;
    private Integer selectedEstado;
    private TipoProductoVO tipoProductoVO;
    private ProductoService productoService;
    private ProductoVO productoVO;

    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                //se inicializan los services y  objetos
                productoService = new ProductoService();
                setProductoVO(new ProductoVO());

            } catch (Exception e) {

            }
        }
    }

    public void preRenderView() throws Exception {
        System.out.println("HOla " + idProducto);
        int idProductoVista;

        idProductoVista = idProducto;
        setProductoVO(productoService.consultarPorId(idProductoVista));
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getSelectedIdTipoProducto() {
        return selectedIdTipoProducto;
    }

    public void setSelectedIdTipoProducto(Integer selectedIdTipoProducto) {
        this.selectedIdTipoProducto = selectedIdTipoProducto;
    }

    public Integer getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(Integer cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    public BigDecimal getPrecioUnidadProducto() {
        return precioUnidadProducto;
    }

    public void setPrecioUnidadProducto(BigDecimal precioUnidadProducto) {
        this.precioUnidadProducto = precioUnidadProducto;
    }

    public Integer getSelectedMedida() {
        return selectedMedida;
    }

    public void setSelectedMedida(Integer selectedMedida) {
        this.selectedMedida = selectedMedida;
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
        return estadoProducto;
    }

    public void setEstadoProducto(Integer estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public Integer getSelectedEstado() {
        return selectedEstado;
    }

    public void setSelectedEstado(Integer selectedEstado) {
        this.selectedEstado = selectedEstado;
    }

    public TipoProductoVO getTipoProductoVO() {
        return tipoProductoVO;
    }

    public void setTipoProductoVO(TipoProductoVO tipoProductoVO) {
        this.tipoProductoVO = tipoProductoVO;
    }

    public ProductoVO getProductoVO() {
        return productoVO;
    }

    public void setProductoVO(ProductoVO productoVO) {
        this.productoVO = productoVO;
    }
}
