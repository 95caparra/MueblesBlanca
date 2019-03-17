/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.ProductoCategoriaDAO;
import mueblesblanca.dao.ProductoCategoriaDAOMS;
import mueblesblanca.vo.ProductoCategoriaVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class ProductoCategoriaService {

    private static ProductoCategoriaDAO productoCategoriaDAO;

    public ProductoCategoriaService() {
        productoCategoriaDAO = new ProductoCategoriaDAOMS();
    }

    public int insertar(ProductoCategoriaVO productoCategoriaVO) throws Exception {
        int resultado = -1;
        try {
            resultado = productoCategoriaDAO.insertar(productoCategoriaVO);
        } catch (Exception e) {
            System.out.println("ProductoCategoriaService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(ProductoCategoriaVO productoCategoriaVO) throws Exception {
        int resultado = -1;
        try {
            resultado = productoCategoriaDAO.actualizar(productoCategoriaVO);
        } catch (Exception e) {
            System.out.println("ProductoCategoriaService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<ProductoCategoriaVO> listar() throws Exception {

        ArrayList<ProductoCategoriaVO> lista = new ArrayList<ProductoCategoriaVO>();
        try {
            lista = productoCategoriaDAO.listar();
        } catch (Exception e) {
            System.out.println("ProductoCategoriaService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public ProductoCategoriaVO consultarPorId(long idProductoCategoria) throws Exception {
        ProductoCategoriaVO pedidoVO = new ProductoCategoriaVO();
        try {
            pedidoVO = productoCategoriaDAO.consultarPorId(idProductoCategoria);
        } catch (Exception e) {
            System.out.println("ProductoCategoriaService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return pedidoVO;
        }
    }
    
    public int eliminarPorId(long idProductoCategoria, long IdCategoria) throws Exception {
        int resultado = -1;
        try {
            resultado = productoCategoriaDAO.eliminar(idProductoCategoria, IdCategoria);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}


