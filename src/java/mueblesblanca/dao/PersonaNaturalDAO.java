/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.PersonaNaturalVO;

/**
 *
 * @author cochoa
 */
public interface PersonaNaturalDAO {
    
    public int insertar(PersonaNaturalVO personaNaturalVO)throws Exception;
    
    public int actualizar(PersonaNaturalVO personaNaturalVO)throws Exception;
    
    public int eliminar(long id)throws Exception;
    
    public ArrayList<PersonaNaturalVO> listar() throws Exception; 
    
    public PersonaNaturalVO consultarPorId(long id) throws Exception;
    
}
