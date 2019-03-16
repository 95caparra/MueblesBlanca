/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.ImagenProductoDAO;
import mueblesblanca.dao.ImagenProductoDAOMS;
import mueblesblanca.vo.ImagenProductoVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class ImagenProductoService {

    private static ImagenProductoDAO imagenProductoDAO;

    public ImagenProductoService() {
        imagenProductoDAO = new ImagenProductoDAOMS();
    }

    public int insertar(ImagenProductoVO imagenProductoVO) throws Exception {
        int resultado = -1;
        try {
            resultado = imagenProductoDAO.insertar(imagenProductoVO);
        } catch (Exception e) {
            System.out.println("ImagenProductoService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(ImagenProductoVO imagenProductoVO) throws Exception {
        int resultado = -1;
        try {
            resultado = imagenProductoDAO.actualizar(imagenProductoVO);
        } catch (Exception e) {
            System.out.println("ImagenProductoService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<ImagenProductoVO> listar() throws Exception {

        ArrayList<ImagenProductoVO> lista = new ArrayList<ImagenProductoVO>();
        try {
            lista = imagenProductoDAO.listar();
        } catch (Exception e) {
            System.out.println("ImagenProductoService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public ImagenProductoVO consultarPorId(long idImagenProducto) throws Exception {
        ImagenProductoVO imagenProductoVO = new ImagenProductoVO();
        try {
            imagenProductoVO = imagenProductoDAO.consultarPorId(idImagenProducto);
        } catch (Exception e) {
            System.out.println("ImagenProducto: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return imagenProductoVO;
        }
    }
    
    public int eliminarPorId(long idImagenProducto) throws Exception {
        int resultado = -1;
        try {
            resultado = imagenProductoDAO.eliminar(idImagenProducto);
        } catch (Exception e) {
            System.out.println("ImagenProductoService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}

