/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.util.ArrayList;
import mueblesblanca.vo.TipoDocumentoVO;

/**
 *
 * @author cochoa
 */
public interface TipoDocumentoDAO {
    
    public int insertar(TipoDocumentoVO tipoDocumentoVO)throws Exception;
    
    public int actualizar(TipoDocumentoVO tipoDocumentoVO)throws Exception;
    
    public int eliminar(long id)throws Exception;
    
    public ArrayList<TipoDocumentoVO> listar() throws Exception; 
    
    public TipoDocumentoVO consultarPorId(long id) throws Exception;
    
}
