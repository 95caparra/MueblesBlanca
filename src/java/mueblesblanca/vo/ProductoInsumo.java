/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.vo;

/**
 *
 * @author camil
 */
public class ProductoInsumo {
    
    private ProductoVO producto;
    private InsumoVO insumo;
    private Integer cantidad;
    private Integer estado;

    public ProductoInsumo(){
        producto = new ProductoVO();
        insumo = new InsumoVO();
    }
    

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public ProductoVO getProducto() {
        return producto;
    }

    public void setProducto(ProductoVO producto) {
        this.producto = producto;
    }

    public InsumoVO getInsumo() {
        return insumo;
    }

    public void setInsumo(InsumoVO insumo) {
        this.insumo = insumo;
    }
    
    
    
    
}
