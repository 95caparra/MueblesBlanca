/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import mueblesblanca.dao.ProductoDAO;
import mueblesblanca.dao.ProductoDAOMS;
import mueblesblanca.util.ConvertirBytesABase64;
import mueblesblanca.vo.ProductoVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class ProductoService {

    private static ProductoDAO productoDAO;
    private ConvertirBytesABase64 convertir;
    
    public ProductoService() {
        productoDAO = new ProductoDAOMS();
        //se instancia objeto para convertir bytes a base 64
        convertir = new ConvertirBytesABase64();
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
        ArrayList<ProductoVO> listaNueva = new ArrayList<ProductoVO>();
        try {
            lista = productoDAO.listar();
             
            for(ProductoVO p: lista){
                InputStream in = new ByteArrayInputStream(p.getFoto());
                Blob blob = new javax.sql.rowset.serial.SerialBlob(p.getFoto());
                String imagenBase64 = convertir.convertirABase64(in, blob);
                p.setImagenProducto(imagenBase64);
                listaNueva.add(p);
                if(p.getImagenProducto() == null){
                    listaNueva.remove(p);
                }
            }
        } catch (Exception e) {
            System.out.println("ProductoService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return listaNueva;
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


