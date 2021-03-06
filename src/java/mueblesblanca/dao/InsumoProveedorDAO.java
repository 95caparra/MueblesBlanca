/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.InsumoProveedorVO;

/**
 *
 * @author cochoa
 */
public interface InsumoProveedorDAO {
    
    public int insertar(InsumoProveedorVO insumoProveedorVO)throws Exception;
    
    public int actualizar(InsumoProveedorVO insumoProveedorVO)throws Exception;
    
    public int eliminar(long id, long idProveedor)throws Exception;
    
    public ArrayList<InsumoProveedorVO> listar() throws Exception; 
    
    public InsumoProveedorVO consultarPorId(long id) throws Exception;
    
}
