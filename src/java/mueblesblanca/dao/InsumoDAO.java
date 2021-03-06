/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.InsumoVO;

/**
 *
 * @author cochoa
 */
public interface InsumoDAO {
    
    public int insertar(InsumoVO insumoVO)throws Exception;
    
    public int actualizar(InsumoVO insumoVO)throws Exception;
    
    public int eliminar(long id)throws Exception;
    
    public ArrayList<InsumoVO> listar() throws Exception; 
    
    public InsumoVO consultarPorId(long id) throws Exception;
    
}
