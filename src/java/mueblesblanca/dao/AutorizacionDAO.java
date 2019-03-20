/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.AutorizacionVO;

/**
 *
 * @author cochoa
 */
public interface AutorizacionDAO {
    
    public int insertar(AutorizacionVO autorizacionVO)throws Exception;
    
    public int actualizar(AutorizacionVO autorizacionVO)throws Exception;
    
    public int eliminar(long id)throws Exception;
    
    public ArrayList<AutorizacionVO> listar() throws Exception; 
    
    public AutorizacionVO consultarPorId(long id) throws Exception;
    
}
