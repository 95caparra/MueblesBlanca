/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.RolDAO;
import mueblesblanca.dao.RolDAOMS;
import mueblesblanca.vo.RolVO;

/**
 *
 * @author Fabian Garcia
 */

public class RolService {

    private static RolDAO rolDAO;

    public RolService() {
        rolDAO = new RolDAOMS();
    }

    public int insertar(RolVO rolVO) throws Exception {
        int resultado = -1;
        try {
            resultado = rolDAO.insertar(rolVO);
        } catch (Exception e) {
            System.out.println("RolService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(RolVO rolVO) throws Exception {
        int resultado = -1;
        try {
            resultado = rolDAO.actualizar(rolVO);
        } catch (Exception e) {
            System.out.println("RolService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }           

    public ArrayList<RolVO> listar() throws Exception {

        ArrayList<RolVO> lista = new ArrayList<RolVO>();
        try {
            lista = rolDAO.listar();
        } catch (Exception e) {
            System.out.println("RolService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public RolVO consultarPorId(long id) throws Exception {
        RolVO rolVO = new RolVO();
        try {
            rolVO = rolDAO.consultarPorId(id);
        } catch (Exception e) {
            System.out.println("RolService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return rolVO;
        }
    }
    
    public int eliminarPorId(long id) throws Exception {
        int resultado = -1;
        try {
            resultado = rolDAO.eliminar(id);
        } catch (Exception e) {
            System.out.println("RolService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}

