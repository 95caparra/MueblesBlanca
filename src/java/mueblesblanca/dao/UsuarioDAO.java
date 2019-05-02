/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import mueblesblanca.vo.UsuarioVO;

/**
 *
 * @author Alexis Holguin
 */
public interface UsuarioDAO {
    public int insertar(UsuarioVO usuario) throws Exception;
    public int actualizar(UsuarioVO usuario)throws Exception;
    public UsuarioVO consultarPorEmail(String email) throws Exception;
}
