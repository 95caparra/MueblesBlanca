/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.ProductoDAO;
import mueblesblanca.dao.ProductoDAOMS;
import mueblesblanca.vo.ProductoVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class ProductoService {

    private static ProductoDAO productoDAO;

    public ProductoService() {
        productoDAO = new ProductoDAOMS();
    }

    public int insertar(ProductoVO productoVO) throws Exception {
        int resultado = -1;
        try {
            resultado = productoDAO.insertar(productoVO);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(ProductoVO productoVO) throws Exception {
        int resultado = -1;
        try {
            resultado = productoDAO.actualizar(productoVO);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<ProductoVO> listar() throws Exception {

        ArrayList<ProductoVO> lista = new ArrayList<ProductoVO>();
        try {
            lista = productoDAO.listar();
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public ProductoVO consultarPorId(long idProducto) throws Exception {
        ProductoVO productoVO = new ProductoVO();
        try {
            productoVO = productoDAO.consultarPorId(idProducto);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return productoVO;
        }
    }
    
    public int eliminarPorId(long idProducto) throws Exception {
        int resultado = -1;
        try {
            resultado = productoDAO.eliminar(idProducto);
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}


