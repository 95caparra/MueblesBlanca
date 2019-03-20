/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.InsumoProveedorDAOMS;
import mueblesblanca.dao.InsumoProveedorDAO;
import mueblesblanca.vo.InsumoProveedorVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class InsumoProveedorService {

    private static InsumoProveedorDAO insumoProveedorDAO;

    public InsumoProveedorService() {
        insumoProveedorDAO = new InsumoProveedorDAOMS();
    }

    public int insertar(InsumoProveedorVO insumoProveedorVO) throws Exception {
        int resultado = -1;
        try {
            resultado = insumoProveedorDAO.insertar(insumoProveedorVO);
        } catch (Exception e) {
            System.out.println("InsumoProveedorService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(InsumoProveedorVO insumoProveedorVO) throws Exception {
        int resultado = -1;
        try {
            resultado = insumoProveedorDAO.actualizar(insumoProveedorVO);
        } catch (Exception e) {
            System.out.println("InsumoProveedorService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<InsumoProveedorVO> listar() throws Exception {

        ArrayList<InsumoProveedorVO> lista = new ArrayList<InsumoProveedorVO>();
        try {
            lista = insumoProveedorDAO.listar();
        } catch (Exception e) {
            System.out.println("InsumoProveedorService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public InsumoProveedorVO consultarPorId(long idInsumoProveedor) throws Exception {
        InsumoProveedorVO insumoVO = new InsumoProveedorVO();
        try {
            insumoVO = insumoProveedorDAO.consultarPorId(idInsumoProveedor);
        } catch (Exception e) {
            System.out.println("InsumoProveedorService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return insumoVO;
        }
    }
    
    public int eliminarPorId(long idInsumo, long idProveedor) throws Exception {
        int resultado = -1;
        try {
            resultado = insumoProveedorDAO.eliminar(idInsumo, idProveedor);
        } catch (Exception e) {
            System.out.println("InsumoProveedorService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}

