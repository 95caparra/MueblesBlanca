/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.ProductoInsumoDAO;
import mueblesblanca.dao.ProductoInsumoDAOMS;
import mueblesblanca.vo.ProductoInsumoVO;

/**
 *
 * @author Fabian Garcia
 */
public class ProductoInsumoService {
    private static ProductoInsumoDAO productoInsumoDAO;

    public ProductoInsumoService() {
        productoInsumoDAO = new ProductoInsumoDAOMS();
    }

    public int insertar(ProductoInsumoVO productoInsumoVO) throws Exception {
        int resultado = -1;
        try {
            resultado = productoInsumoDAO.insertar(productoInsumoVO);
        } catch (Exception e) {
            System.out.println("ProductoInsumoService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(ProductoInsumoVO productoInsumoVO) throws Exception {
        int resultado = -1;
        try {
            resultado = productoInsumoDAO.actualizar(productoInsumoVO);
        } catch (Exception e) {
            System.out.println("ProductoInsumoService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<ProductoInsumoVO> listar() throws Exception {

        ArrayList<ProductoInsumoVO> lista = new ArrayList<ProductoInsumoVO>();
        try {
            lista = productoInsumoDAO.listar();
        } catch (Exception e) {
            System.out.println("ProductoInsumoService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public ProductoInsumoVO consultarPorId(long idProducto) throws Exception {
        ProductoInsumoVO productoVO = new ProductoInsumoVO();
        try {
            productoVO = productoInsumoDAO.consultarPorId(idProducto);
        } catch (Exception e) {
            System.out.println("ProductoInsumoService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return productoVO;
        }
    }
    
    public int eliminarPorId(long idProducto, long idinsumo) throws Exception {
        int resultado = -1;
        try {
            resultado = productoInsumoDAO.eliminar(idProducto, idinsumo);
        } catch (Exception e) {
            System.out.println("ProductoInsumoServices: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }
    
}
