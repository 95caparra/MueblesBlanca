/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.ProductoVO;

/**
 *
 * @author cochoa
 */
public interface ProductoDAO {

    public int insertar(ProductoVO productoVO) throws Exception;

    public int actualizar(ProductoVO productoVO) throws Exception;

    public int eliminar(long id) throws Exception;

    public ArrayList<ProductoVO> listar() throws Exception;

    public ProductoVO consultarPorId(long id) throws Exception;
}
