/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.MedidaVO;

/**
 *
 * @author cochoa
 */
public interface MedidaDAO {
    
    public int insertar(MedidaVO medidaVO)throws Exception;
    
    public int actualizar(MedidaVO medidaVO)throws Exception;
    
    public int eliminar(long id)throws Exception;
    
    public ArrayList<MedidaVO> listar() throws Exception; 
    
    public MedidaVO consultarPorId(long id) throws Exception;
}
