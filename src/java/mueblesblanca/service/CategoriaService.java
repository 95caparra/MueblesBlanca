/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.CategoriaDAO;
import mueblesblanca.dao.CategoriaDAOMS;
import mueblesblanca.vo.CategoriaVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class CategoriaService {

    private static CategoriaDAO categoriaDAO;

    public CategoriaService() {
        categoriaDAO = new CategoriaDAOMS();
    }

    public int insertar(CategoriaVO categoriaVO) throws Exception {
        int resultado = -1;
        try {
            resultado = categoriaDAO.insertar(categoriaVO);
        } catch (Exception e) {
            System.out.println("CategoriaService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(CategoriaVO categoriaVO) throws Exception {
        int resultado = -1;
        try {
            resultado = categoriaDAO.actualizar(categoriaVO);
        } catch (Exception e) {
            System.out.println("CategoriaService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<CategoriaVO> listar() throws Exception {

        ArrayList<CategoriaVO> lista = new ArrayList<CategoriaVO>();
        try {
            lista = categoriaDAO.listar();
        } catch (Exception e) {
            System.out.println("CategoriaService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public CategoriaVO consultarPorId(long idCategoria) throws Exception {
        CategoriaVO categoriaVO = new CategoriaVO();
        try {
            categoriaVO = categoriaDAO.consultarPorId(idCategoria);
        } catch (Exception e) {
            System.out.println("CategoriaService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return categoriaVO;
        }
    }
    
    public int eliminarPorId(long idCategoria) throws Exception {
        int resultado = -1;
        try {
            resultado = categoriaDAO.eliminar(idCategoria);
        } catch (Exception e) {
            System.out.println("CategoriaService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}

