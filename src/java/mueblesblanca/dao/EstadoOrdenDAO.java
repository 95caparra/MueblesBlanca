/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.EstadoOrdenVO;

/**
 *
 * @author cochoa
 */
public interface EstadoOrdenDAO {
    
    public int insertar(EstadoOrdenVO estadoOrdenVO)throws Exception;
    
    public int actualizar(EstadoOrdenVO estadoOrdenVO)throws Exception;
    
    public int eliminar(long id)throws Exception;
    
    public ArrayList<EstadoOrdenVO> listar() throws Exception; 
    
    public EstadoOrdenVO consultarPorId(long id) throws Exception;
}
