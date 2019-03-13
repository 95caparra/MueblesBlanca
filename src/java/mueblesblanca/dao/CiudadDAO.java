package mueblesblanca.dao;

import mueblesblanca.vo.CiudadVO;
import java.util.ArrayList;

/**
 *
 * @author Sergio Alfonso G
 */
public interface CiudadDAO {
    
    public int insertar(CiudadVO ciudadVO)throws Exception;
    
    public int actualizar(CiudadVO ciudadVO)throws Exception;
    
    public int eliminar(long id)throws Exception;
    
    public ArrayList<CiudadVO> listar() throws Exception; 
    
    public CiudadVO consultarPorId(long id) throws Exception;
    
}
