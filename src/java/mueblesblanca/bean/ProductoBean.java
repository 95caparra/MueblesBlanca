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
import mueblesblanca.service.ProductoService;
import mueblesblanca.service.TipoProductoService;
import mueblesblanca.vo.MedidaVO;
import mueblesblanca.vo.Modelo3DVO;
import mueblesblanca.vo.ProductoVO;
import mueblesblanca.vo.TipoProductoVO;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Fabian Garcia
 */
@ManagedBean(name = "productoBean")
@ViewScoped
public class ProductoBean implements Serializable {

    private static long serialVersionUID = 4545919119678482516L;

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

    //objetos y listas/////////
    private ProductoVO productoVO;
    private ProductoVO selectedProducto;
    private List<ProductoVO> productosFiltro;
    private List<ProductoVO> productos;
    private List<TipoProductoVO> tipoProductos;
    private List<MedidaVO> medidas;
    private List<Modelo3DVO> modelos;
    private Map<String, Integer> estadosEnum;

    private String imageString;
    private UploadedFile file;
    private byte[] contents;

    /// Services////////////
    private TipoProductoService tipoProductoService;
    private ProductoService productoService;
    private MedidaService medidaService;
    private Modelo3DService modelo3DService;

    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Application application = context.getApplication();
            try {
                //se inicializan los services y  objetos
                productoService = new ProductoService();
                tipoProductoService = new TipoProductoService();
                medidaService = new MedidaService();
                modelo3DService = new Modelo3DService();

                setProductos(productoService.listar());
                setTipoProductos(tipoProductoService.listar());
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
            setProductoVO(new ProductoVO());

            getProductoVO().setIdProducto(id);

            getProductoVO().setNombreProducto(nombreProducto);
            getProductoVO().getTipoProducto().setIdTipoProducto(selectedIdTipoProducto);
            getProductoVO().setCantidadExistente(cantidadExistente);
            getProductoVO().setPrecioUnidadProducto(precioUnidadProducto);
            getProductoVO().getMedida().setIdMedida(selectedMedida);
            getProductoVO().setUsuarioModificacionProducto(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));
            getProductoVO().setEstado(estadoProducto);

            if (productoService.actualizar(getProductoVO()) > 0) {
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
            productoVO = new ProductoVO();
            idProducto = getSelectedProducto().getIdProducto();

            productoVO = productoService.consultarPorId(idProducto);
            
            //Código para traer bytes de bd y convertir la imagen a base 64
            InputStream in = new ByteArrayInputStream(productoVO.getFoto());
            if (in != null) {
                Blob blob = new javax.sql.rowset.serial.SerialBlob(productoVO.getFoto());

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
            productoVO = new ProductoVO();

            productoVO.setNombreProducto(nombreProducto);
            productoVO.getTipoProducto().setIdTipoProducto(selectedIdTipoProducto);
            productoVO.setCantidadExistente(cantidadExistente);
            productoVO.setPrecioUnidadProducto(precioUnidadProducto);
            productoVO.getMedida().setIdMedida(selectedMedida);
            productoVO.setUsuarioCreacionProducto(String.valueOf(UsuarioEnum.USUARIO_DEFAULT));
            productoVO.setEstado(selectedEstado);

            //Código para obtener los bytes de la imagen y setearlo
            /*InputStream is2 = file.getInputstream();
            int k2 = is2.available();
            byte[] b2 = new byte[k2];*/
            productoVO.setFoto(contents);

            if (productoService.insertar(getProductoVO()) > 0) {
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

    public List<ProductoVO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoVO> productos) {
        this.productos = productos;
    }

    public List<TipoProductoVO> getTipoProductos() {
        return tipoProductos;
    }

    public void setTipoProductos(List<TipoProductoVO> tipoProductos) {
        this.tipoProductos = tipoProductos;
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

    public ProductoVO getSelectedProducto() {
        return selectedProducto;
    }

    public void setSelectedProducto(ProductoVO selectedProducto) {
        this.selectedProducto = selectedProducto;
    }

    public ProductoVO getProductoVO() {
        return productoVO;
    }

    public void setProductoVO(ProductoVO productoVO) {
        this.productoVO = productoVO;
    }

    public List<ProductoVO> getProductosFiltro() {
        return productosFiltro;
    }

    public void setProductosFiltro(List<ProductoVO> productosFiltro) {
        this.productosFiltro = productosFiltro;
    }

    public TipoProductoVO getTipoProductoVO() {
        return tipoProductoVO;
    }

    public void setTipoProductoVO(TipoProductoVO tipoProductoVO) {
        this.tipoProductoVO = tipoProductoVO;
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
    
    public String ValorTipoProducto(Integer idTipoProducto) throws Exception {
        if (idTipoProducto != null) {
            TipoProductoVO tipoProducto = tipoProductoService.consultarPorId(idTipoProducto);
            return tipoProducto.getDescripcionTipoProducto();
        } else {
            return "";
        }
    }
    
    public String ValorMedida(Integer idMedida) throws Exception {
        if (idMedida != null) {
            MedidaVO medida = medidaService.consultarPorId(idMedida);
            return medida.getDescripcionMedida();
        } else {
            return "";
        }
    }   

}
