/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.AutorizacionDAO;
import mueblesblanca.dao.AutorizacionDAOMS;
import mueblesblanca.vo.AutorizacionVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class AutorizacionService {

    private static AutorizacionDAO autorizacionDAO;

    public AutorizacionService() {
        autorizacionDAO = new AutorizacionDAOMS();
    }

    public int insertar(AutorizacionVO autorizacionVO) throws Exception {
        int resultado = -1;
        try {
            resultado = autorizacionDAO.insertar(autorizacionVO);
        } catch (Exception e) {
            System.out.println("AutorizacionService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(AutorizacionVO autorizacionVO) throws Exception {
        int resultado = -1;
        try {
            resultado = autorizacionDAO.actualizar(autorizacionVO);
        } catch (Exception e) {
            System.out.println("AutorizacionService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<AutorizacionVO> listar() throws Exception {

        ArrayList<AutorizacionVO> lista = new ArrayList<AutorizacionVO>();
        try {
            lista = autorizacionDAO.listar();
        } catch (Exception e) {
            System.out.println("AutorizacionService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public AutorizacionVO consultarPorId(long idAutorizacion) throws Exception {
        AutorizacionVO autorizaciónVO = new AutorizacionVO();
        try {
            autorizaciónVO = autorizacionDAO.consultarPorId(idAutorizacion);
        } catch (Exception e) {
            System.out.println("AutorizacionService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return autorizaciónVO;
        }
    }
    
    public int eliminarPorId(long idAutorizacion) throws Exception {
        int resultado = -1;
        try {
            resultado = autorizacionDAO.eliminar(idAutorizacion);
        } catch (Exception e) {
            System.out.println("AutorizacionService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}

