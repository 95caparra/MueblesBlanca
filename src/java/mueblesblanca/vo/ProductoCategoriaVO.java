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

public class ProductoCategoriaVO {

    private ProductoVO producto;
    private CategoriaVO categoria;

    public ProductoCategoriaVO() {
        producto = new ProductoVO();
        categoria = new CategoriaVO();
    }

    public ProductoVO getProducto() {
        return producto;
    }

    public void setProducto(ProductoVO producto) {
        this.producto = producto;
    }

    public CategoriaVO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaVO categoria) {
        this.categoria = categoria;
    }

}
