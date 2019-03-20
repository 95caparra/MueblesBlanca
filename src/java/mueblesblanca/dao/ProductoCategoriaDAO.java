/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.ProductoCategoriaVO;

/**
 *
 * @author cochoa
 */
public interface ProductoCategoriaDAO {

    public int insertar(ProductoCategoriaVO productoCategoriaVO) throws Exception;

    public int actualizar(ProductoCategoriaVO productoCategoriaVO) throws Exception;

    public int eliminar(long id, long IdCategoria) throws Exception;

    public ArrayList<ProductoCategoriaVO> listar() throws Exception;

    public ProductoCategoriaVO consultarPorId(long id) throws Exception;

}
