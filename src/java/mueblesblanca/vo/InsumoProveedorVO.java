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

public class InsumoProveedorVO {
    
    private ProductoVO producto;
    private ProveedorVO proveedor;
    
    public InsumoProveedorVO(){
        producto = new ProductoVO();
        proveedor = new ProveedorVO();
    }

    public ProductoVO getProducto() {
        return producto;
    }

    public void setProducto(ProductoVO producto) {
        this.producto = producto;
    }

    public ProveedorVO getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorVO proveedor) {
        this.proveedor = proveedor;
    }
    
    
    
}
