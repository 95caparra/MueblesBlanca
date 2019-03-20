/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.ProveedorVO;

/**
 *
 * @author cochoa
 */
public interface ProveedorDAO {
    
     public int insertar(ProveedorVO proveedorVO)throws Exception;
    
    public int actualizar(ProveedorVO proveedorVO)throws Exception;
    
    public int eliminar(long id)throws Exception;
    
    public ArrayList<ProveedorVO> listar() throws Exception; 
    
    public ProveedorVO consultarPorId(long id) throws Exception;
}
