/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import mueblesblanca.dao.UsuarioDAO;
import mueblesblanca.dao.UsuarioDAOMS;
import mueblesblanca.vo.UsuarioVO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Alexis Holguin (MoraHol)
 */
public class UsuarioService {

    private static UsuarioDAO usuarioDAO;

    public UsuarioService() {
        usuarioDAO = new UsuarioDAOMS();
    }

    public int insertar(UsuarioVO user) {
        int result = -1;
        try {
            result = usuarioDAO.insertar(user);
        } catch (Exception e) {
            System.out.println("UsuarioService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        }
        return result;

    }

    public int actualizar(UsuarioVO user) throws Exception {
        int result = -1;
        try {
            result = usuarioDAO.actualizar(user);
        } catch (Exception e) {
            System.out.println("UsuarioService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        }
        return result;
    }

    public UsuarioVO consultarPorEmail(String email) throws Exception {
        UsuarioVO usuarioVO = new UsuarioVO();
        try {
            usuarioVO = usuarioDAO.consultarPorEmail(email);
        } catch (Exception e) {
            System.out.println("UsuarioService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        }

        return usuarioVO;

    }

    public UsuarioVO autenticarUsuario(String email, String password) throws Exception {
        UsuarioVO usuarioVO = consultarPorEmail(email);
        if (usuarioVO != null) {
            System.out.println(usuarioVO.getPassword());
            System.out.println(convertirSHA256(password));
            if (usuarioVO.getPassword().equals(convertirSHA256(password))) {
                return usuarioVO;
            }
        }
        return null;

    }

    public String convertirSHA256(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }

        byte[] hash = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();

        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }
}
