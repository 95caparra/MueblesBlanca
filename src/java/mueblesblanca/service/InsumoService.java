/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.InsumoDAO;
import mueblesblanca.dao.InsumoDAOMS;
import mueblesblanca.vo.InsumoVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class InsumoService {

    private static InsumoDAO insumoDAO;

    public InsumoService() {
        insumoDAO = new InsumoDAOMS();
    }

    public int insertar(InsumoVO insumoVO) throws Exception {
        int resultado = -1;
        try {
            resultado = insumoDAO.insertar(insumoVO);
        } catch (Exception e) {
            System.out.println("InsumoService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(InsumoVO insumoVO) throws Exception {
        int resultado = -1;
        try {
            resultado = insumoDAO.actualizar(insumoVO);
        } catch (Exception e) {
            System.out.println("InsumoService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<InsumoVO> listar() throws Exception {

        ArrayList<InsumoVO> lista = new ArrayList<InsumoVO>();
        try {
            lista = insumoDAO.listar();
        } catch (Exception e) {
            System.out.println("InsumoService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public InsumoVO consultarPorId(long idInsumo) throws Exception {
        InsumoVO insumoVO = new InsumoVO();
        try {
            insumoVO = insumoDAO.consultarPorId(idInsumo);
        } catch (Exception e) {
            System.out.println("InsumoService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return insumoVO;
        }
    }
    
    public int eliminarPorId(long idInsumo) throws Exception {
        int resultado = -1;
        try {
            resultado = insumoDAO.eliminar(idInsumo);
        } catch (Exception e) {
            System.out.println("InsumoService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}

