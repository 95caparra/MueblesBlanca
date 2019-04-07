/*
 * To change this license header;choose License Headers in Project Properties.
 * To change this template file;choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mueblesblanca.constante.UsuarioEnum;
import mueblesblanca.service.InsumoService;
import mueblesblanca.service.MedidaService;
import mueblesblanca.vo.InsumoVO;
import mueblesblanca.vo.MedidaVO;

/**
 *
 * @author Sergio Alfonso G
 */
@ManagedBean(name = "insumoBean")
@ViewScoped
public class InsumoBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private Integer idInsumo;
    private String nombreInsumo;
    private Integer cantidadExistente;
    private Integer selectedMedidaInsumo;   
    private BigDecimal precioUnidadInsumo;
    private String detalleInsumo;
    private Integer estado;

    //objetos y listas/////////
    private InsumoVO insumoVO;
    private InsumoVO selectedInsumo;
    private List<InsumoVO> insumoFiltro;
    private List<InsumoVO> Insumos;
    private List<MedidaVO> medidas;

    /// Services////////////
    private InsumoService insumoService;
    private MedidaService medidaService;

    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                //se inicializan los services y  objetos
                insumoService = new InsumoService();
                medidaService = new MedidaService();

                setMedidas(medidaService.listar());
                setInsumos(insumoService.listar());

            } catch (Exception e) {

            }
        }
    }

    public void actualizar(Integer id) {
        try {
            setInsumoVO(new InsumoVO());
            
            getInsumoVO().setIdInsumo(id);

            getInsumoVO().setNombreInsumo(getNombreInsumo());
            getInsumoVO().setcantidadExistente(getCantidadExistente());
            getInsumoVO().getMedida().setIdMedida(getSelectedMedidaInsumo());
            getInsumoVO().setPrecioUnidadInsumo(getPrecioUnidadInsumo());
            getInsumoVO().setDetalleInsumo(getDetalleInsumo());
            getInsumoVO().setUsuarioModificacionInsumo(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));

            if (insumoService.actualizar(getInsumoVO()) > 0) {
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
            setInsumoVO(new InsumoVO());
            setIdInsumo(getSelectedInsumo().getIdInsumo());

            setInsumoVO(insumoService.consultarPorId(getIdInsumo()));
            
        } catch (Exception e) {
        }
    }

    public void insertar() {
        try {
            setInsumoVO(new InsumoVO());

            getInsumoVO().setNombreInsumo(getNombreInsumo());
            getInsumoVO().setcantidadExistente(getCantidadExistente());
            getInsumoVO().getMedida().setIdMedida(getSelectedMedidaInsumo());
            getInsumoVO().setPrecioUnidadInsumo(getPrecioUnidadInsumo());
            getInsumoVO().setDetalleInsumo(getDetalleInsumo());
            getInsumoVO().setUsuarioCreacionInsumo(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));

            if (insumoService.insertar(getInsumoVO()) > 0) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "se guardó "));
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Se produjo un error "));
            }

        } catch (Exception e) {
            System.out.println("error: "+ e.getMessage());
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        InsumoBean.serialVersionUID = serialVersionUID;
    }

    public Integer getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
    }
    
    /**
     * @return the nombreInsumo
     */
    public String getNombreInsumo() {
        return nombreInsumo;
    }

    /**
     * @param nombreInsumo the nombreInsumo to set
     */
    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    /**
     * @return the cantidadExistente
     */
    public Integer getCantidadExistente() {
        return cantidadExistente;
    }

    /**
     * @param cantidadExistente the cantidadExistente to set
     */
    public void setCantidadExistente(Integer cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    /**
     * @return the selectedMedidaInsumo
     */
    public Integer getSelectedMedidaInsumo() {
        return selectedMedidaInsumo;
    }

    /**
     * @param selectedMedidaInsumo the selectedMedidaInsumo to set
     */
    public void setSelectedMedidaInsumo(Integer selectedMedidaInsumo) {
        this.selectedMedidaInsumo = selectedMedidaInsumo;
    }

    /**
     * @return the precioUnidadInsumo
     */
    public BigDecimal getPrecioUnidadInsumo() {
        return precioUnidadInsumo;
    }

    /**
     * @param precioUnidadInsumo the precioUnidadInsumo to set
     */
    public void setPrecioUnidadInsumo(BigDecimal precioUnidadInsumo) {
        this.precioUnidadInsumo = precioUnidadInsumo;
    }

    /**
     * @return the detalleInsumo
     */
    public String getDetalleInsumo() {
        return detalleInsumo;
    }

    /**
     * @param detalleInsumo the detalleInsumo to set
     */
    public void setDetalleInsumo(String detalleInsumo) {
        this.detalleInsumo = detalleInsumo;
    }

    /**
     * @return the estado
     */
    public Integer getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    /**
     * @return the insumoVO
     */
    public InsumoVO getInsumoVO() {
        return insumoVO;
    }

    /**
     * @param insumoVO the insumoVO to set
     */
    public void setInsumoVO(InsumoVO insumoVO) {
        this.insumoVO = insumoVO;
    }

    /**
     * @return the selectedInsumo
     */
    public InsumoVO getSelectedInsumo() {
        return selectedInsumo;
    }

    /**
     * @param selectedInsumo the selectedInsumo to set
     */
    public void setSelectedInsumo(InsumoVO selectedInsumo) {
        this.selectedInsumo = selectedInsumo;
    }

    /**
     * @return the insumoFiltro
     */
    public List<InsumoVO> getInsumoFiltro() {
        return insumoFiltro;
    }

    /**
     * @param insumoFiltro the insumoFiltro to set
     */
    public void setInsumoFiltro(List<InsumoVO> insumoFiltro) {
        this.insumoFiltro = insumoFiltro;
    }

    /**
     * @return the Insumos
     */
    public List<InsumoVO> getInsumos() {
        return Insumos;
    }

    /**
     * @param Insumos the Insumos to set
     */
    public void setInsumos(List<InsumoVO> Insumos) {
        this.Insumos = Insumos;
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

}
