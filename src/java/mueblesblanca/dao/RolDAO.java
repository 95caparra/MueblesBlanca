/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.RolVO;

/**
 *
 * @author cochoa
 */
public interface RolDAO {
    
     public int insertar(RolVO rolVO)throws Exception;
    
    public int actualizar(RolVO rolVO)throws Exception;
    
    public int eliminar(long id)throws Exception;
    
    public ArrayList<RolVO> listar() throws Exception; 
    
    public RolVO consultarPorId(long id) throws Exception;
    
}
