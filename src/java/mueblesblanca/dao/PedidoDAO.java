/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.PedidoVO;

/**
 *
 * @author cochoa
 */
public interface PedidoDAO {
    
    public int insertar(PedidoVO pedidoVO)throws Exception;
    
    public int actualizar(PedidoVO pedidoVO)throws Exception;
    
    public int eliminar(long id)throws Exception;
    
    public ArrayList<PedidoVO> listar() throws Exception; 
    
    public PedidoVO consultarPorId(long id) throws Exception;
    
}
