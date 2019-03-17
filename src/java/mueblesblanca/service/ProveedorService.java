/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.ProveedorDAO;
import mueblesblanca.dao.ProveedorDAOMS;
import mueblesblanca.vo.ProveedorVO;

/**
 *
 * @author Fabian Garcia
 */

public class ProveedorService {

    private static ProveedorDAO proveedorDAO;

    public ProveedorService() {
        proveedorDAO = new ProveedorDAOMS();
    }

    public int insertar(ProveedorVO proveedorVO) throws Exception {
        int resultado = -1;
        try {
            resultado = proveedorDAO.insertar(proveedorVO);
        } catch (Exception e) {
            System.out.println("ProveedorService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(ProveedorVO proveedorVO) throws Exception {
        int resultado = -1;
        try {
            resultado = proveedorDAO.actualizar(proveedorVO);
        } catch (Exception e) {
            System.out.println("ProveedorService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<ProveedorVO> listar() throws Exception {

        ArrayList<ProveedorVO> lista = new ArrayList<ProveedorVO>();
        try {
            lista = proveedorDAO.listar();
        } catch (Exception e) {
            System.out.println("ProveedorService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public ProveedorVO consultarPorId(long id) throws Exception {
        ProveedorVO proveedorVO = new ProveedorVO();
        try {
            proveedorVO = proveedorDAO.consultarPorId(id);
        } catch (Exception e) {
            System.out.println("ProveedorService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return proveedorVO;
        }
    }

    public int eliminarPorId(long id) throws Exception {
        int resultado = -1;
        try {
            resultado = proveedorDAO.eliminar(id);
        } catch (Exception e) {
            System.out.println("ProveedorService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}
