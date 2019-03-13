/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.Modelo3DVO;

/**
 *
 * @author cochoa
 */
public interface Modelo3DDAO {
    
    public int insertar(Modelo3DVO modelo3DVO)throws Exception;
    
    public int actualizar(Modelo3DVO modelo3DVO)throws Exception;
    
    public int eliminar(long id)throws Exception;
    
    public ArrayList<Modelo3DVO> listar() throws Exception; 
    
    public Modelo3DVO consultarPorId(long id) throws Exception;
    
}
