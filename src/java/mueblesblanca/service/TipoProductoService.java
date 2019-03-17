/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.TipoProductoDAOMS;
import mueblesblanca.dao.TipoProductoDAO;
import mueblesblanca.vo.TipoProductoVO;

/**
 *
 * @author cochoa
 */

public class TipoProductoService {

    private static TipoProductoDAO tipoProductoDAO;

    public TipoProductoService() {
        tipoProductoDAO = new TipoProductoDAOMS();
    }

    public int insertar(TipoProductoVO tipoProductoVO) throws Exception {
        int resultado = -1;
        try {
            resultado = tipoProductoDAO.insertar(tipoProductoVO);
        } catch (Exception e) {
            System.out.println("TipoProductoService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(TipoProductoVO tipoProductoVO) throws Exception {
        int resultado = -1;
        try {
            resultado = tipoProductoDAO.actualizar(tipoProductoVO);
        } catch (Exception e) {
            System.out.println("TipoProductoService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<TipoProductoVO> listar() throws Exception {

        ArrayList<TipoProductoVO> lista = new ArrayList<TipoProductoVO>();
        try {
            lista = tipoProductoDAO.listar();
        } catch (Exception e) {
            System.out.println("TipoProductoService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public TipoProductoVO consultarPorId(long idCiudad) throws Exception {
        TipoProductoVO tipoProductoVO = new TipoProductoVO();
        try {
            tipoProductoVO = tipoProductoDAO.consultarPorId(idCiudad);
        } catch (Exception e) {
            System.out.println("TipoProductoService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return tipoProductoVO;
        }
    }
    
    public int eliminarPorId(long idCiudad) throws Exception {
        int resultado = -1;
        try {
            resultado = tipoProductoDAO.eliminar(idCiudad);
        } catch (Exception e) {
            System.out.println("TipoProductoService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}
