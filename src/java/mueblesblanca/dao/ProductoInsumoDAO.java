/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.ProductoInsumoVO;

/**
 *
 * @author cochoa
 */
public interface ProductoInsumoDAO {

    public int insertar(ProductoInsumoVO productoInsumoVO) throws Exception;

    public int actualizar(ProductoInsumoVO productoInsumoVO) throws Exception;

    public int eliminar(long idproducto, long idinsumo) throws Exception;

    public ArrayList<ProductoInsumoVO> listar() throws Exception;

    public ProductoInsumoVO consultarPorId(long id) throws Exception;

}
