/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.bean;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
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
import mueblesblanca.service.MedidaService;
import mueblesblanca.service.Modelo3DService;
import mueblesblanca.service.InsumoService;
import mueblesblanca.vo.MedidaVO;
import mueblesblanca.vo.Modelo3DVO;
import mueblesblanca.vo.InsumoVO;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Sergio AlfonsoG
 */
@ManagedBean(name = "insumoBean")
@ViewScoped
public class InsumoBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

    private Integer idInsumo;
    private String nombreInsumo;
    private Integer selectedMedida;
    private Integer cantidadExistente;
    private BigDecimal precioUnidadInsumo;
    private String usuarioCreacion;
    private String usuarioModificacion;
    private Integer estadoInsumo;
    private Integer selectedEstado;
    private String detalleInsumo;
    
    //objetos y listas/////////
    private InsumoVO insumoVO;
    private InsumoVO selectedInsumo;
    private List<InsumoVO> insumosFiltro;
    private List<InsumoVO> insumos;
    private List<MedidaVO> medidas;
    private List<Modelo3DVO> modelos;
    private Map<String, Integer> estadosEnum;

    private String imageString;
    private UploadedFile file;
    private byte[] contents;

    /// Services////////////
    private InsumoService InsumoService;
    private MedidaService medidaService;
    private Modelo3DService modelo3DService;

    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                //se inicializan los services y  objetos
                InsumoService = new InsumoService();
                medidaService = new MedidaService();
                modelo3DService = new Modelo3DService();

                setInsumos(InsumoService.listar());
                setMedidas(medidaService.listar());
                setModelos(modelo3DService.listar());

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
            setInsumoVO(new InsumoVO());

            getInsumoVO().setIdInsumo(id);

            getInsumoVO().setNombreInsumo(nombreInsumo);
            getInsumoVO().setCantidadExistente(cantidadExistente);
            getInsumoVO().getMedida().setIdMedida(selectedMedida);
            getInsumoVO().setPrecioUnidadInsumo(precioUnidadInsumo);
            getInsumoVO().setDetalleInsumo(detalleInsumo);
            getInsumoVO().setUsuarioModificacionInsumo(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));
            getInsumoVO().setEstado(estadoInsumo);

            if (InsumoService.actualizar(getInsumoVO()) > 0) {
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
            insumoVO = new InsumoVO();
            idInsumo = getSelectedInsumo().getIdInsumo();

            insumoVO = InsumoService.consultarPorId(idInsumo);
            
            //Código para traer bytes de bd y convertir la imagen a base 64
            InputStream in = new ByteArrayInputStream(insumoVO.getFoto());
            if (in != null) {
                Blob blob = new javax.sql.rowset.serial.SerialBlob(insumoVO.getFoto());

                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();

                String base64Image = new BASE64Encoder().encode(imageBytes);

                inputStream.close();
                outputStream.close();
                
                imageString = base64Image;
            }

        } catch (Exception e) {
        }
    }

    public void insertar() {
        try {
            insumoVO = new InsumoVO();

            insumoVO.setNombreInsumo(nombreInsumo);
            insumoVO.setCantidadExistente(cantidadExistente);
            insumoVO.getMedida().setIdMedida(selectedMedida);
            insumoVO.setPrecioUnidadInsumo(precioUnidadInsumo);
            insumoVO.setDetalleInsumo(detalleInsumo);
            insumoVO.setUsuarioCreacionInsumo(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));
            insumoVO.setEstado(selectedEstado);

            //Código para obtener los bytes de la imagen y setearlo
            /*InputStream is2 = file.getInputstream();
            int k2 = is2.available();
            byte[] b2 = new byte[k2];*/
            insumoVO.setFoto(contents);

            if (InsumoService.insertar(getInsumoVO()) > 0) {
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

    public void upload(FileUploadEvent event) {
        UploadedFile uploadedFile = event.getFile();
        String fileName = uploadedFile.getFileName();
        String contentType = uploadedFile.getContentType();
        contents = uploadedFile.getContents(); // Or getInputStream()
        if (contents.length > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "se subio la imagen "));
        }
        // ... Save it, now!
    }

    public Integer getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public Integer getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(Integer cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    public BigDecimal getPrecioUnidadInsumo() {
        return precioUnidadInsumo;
    }

    public void setPrecioUnidadInsumo(BigDecimal precioUnidadInsumo) {
        this.precioUnidadInsumo = precioUnidadInsumo;
    }
    
    public String getDetalleInsumo() {
        return detalleInsumo;
    }

    public void setDetalleInsumo(String detalleInsumo) {
        this.detalleInsumo = detalleInsumo;
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

    public Integer getEstadoInsumo() {
        return estadoInsumo;
    }

    public void setEstadoInsumo(Integer estadoInsumo) {
        this.estadoInsumo = estadoInsumo;
    }

    public List<InsumoVO> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<InsumoVO> insumos) {
        this.insumos = insumos;
    }

    public List<MedidaVO> getMedidas() {
        return medidas;
    }

    public void setMedidas(List<MedidaVO> medidas) {
        this.medidas = medidas;
    }

    public List<Modelo3DVO> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo3DVO> modelos) {
        this.modelos = modelos;
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

    public InsumoVO getSelectedInsumo() {
        return selectedInsumo;
    }

    public void setSelectedInsumo(InsumoVO selectedInsumo) {
        this.selectedInsumo = selectedInsumo;
    }

    public InsumoVO getInsumoVO() {
        return insumoVO;
    }

    public void setInsumoVO(InsumoVO insumoVO) {
        this.insumoVO = insumoVO;
    }

    public List<InsumoVO> getInsumosFiltro() {
        return insumosFiltro;
    }

    public void setInsumosFiltro(List<InsumoVO> insumosFiltro) {
        this.insumosFiltro = insumosFiltro;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public byte[] getContents() {
        return contents;
    }

    public void setContents(byte[] contents) {
        this.contents = contents;
    }

    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }

}
