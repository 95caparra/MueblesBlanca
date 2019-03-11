/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.CiudadDAO;
import mueblesblanca.dao.CiudadDAOMS;
import mueblesblanca.vo.CiudadVO;

/**
 *
 * @author cochoa
 */
public class CiudadService {

    private static CiudadDAO ciudadDAO;

    public CiudadService() {
        ciudadDAO = new CiudadDAOMS();
    }

    public int insertar(CiudadVO ciudadVO) throws Exception {
        int resultado = -1;
        try {
            resultado = ciudadDAO.insertar(ciudadVO);
        } catch (Exception e) {
            System.out.println("CiudadService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(CiudadVO ciudadVO) throws Exception {
        int resultado = -1;
        try {
            resultado = ciudadDAO.actualizar(ciudadVO);
        } catch (Exception e) {
            System.out.println("CiudadService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<CiudadVO> listar() throws Exception {

        ArrayList<CiudadVO> lista = new ArrayList<CiudadVO>();
        try {
            lista = ciudadDAO.listar();
        } catch (Exception e) {
            System.out.println("CiudadService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public CiudadVO consultarPorId(long idCiudad) throws Exception {
        CiudadVO ciudadVO = new CiudadVO();
        try {
            ciudadVO = ciudadDAO.consultarPorId(idCiudad);
        } catch (Exception e) {
            System.out.println("CiudadService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return ciudadVO;
        }
    }
    
    public int eliminarPorId(long idCiudad) throws Exception {
        int resultado = -1;
        try {
            resultado = ciudadDAO.eliminar(idCiudad);
        } catch (Exception e) {
            System.out.println("CiudadService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}
