/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.TipoProductoVO;

/**
 *
 * @author cochoa
 */
public interface TipoProductoDAO {
    
    public int insertar(TipoProductoVO tipoProductoVO)throws Exception;
    
    public int actualizar(TipoProductoVO tipoProductoVO)throws Exception;
    
    public int eliminar(long id)throws Exception;
    
    public ArrayList<TipoProductoVO> listar() throws Exception; 
    
    public TipoProductoVO consultarPorId(long id) throws Exception;
    
}
