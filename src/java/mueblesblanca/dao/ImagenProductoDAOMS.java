/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mueblesblanca.vo.ImagenProductoVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class ImagenProductoDAOMS extends ConexionSQL implements ImagenProductoDAO {

    @Override
    public int insertar(ImagenProductoVO imagenProductoVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " INSERT INTO ImagenesProducto (Id_Producto, ruta, NombreArchivo) "
                    + " VALUES(?,?,?) ";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, imagenProductoVO.getProducto().getIdProducto());
            pstm.setString(2, imagenProductoVO.getRuta());
            pstm.setString(3, imagenProductoVO.getNombreArchivo());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ImagenProductoDAOMS: Se presento un error al insertar una Imagen del producto."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
     
    }

    @Override
    public int actualizar(ImagenProductoVO imagenProductoVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE ImagenesProducto SET "
                    + " Id_Producto = ?, "
                    + " ruta = ?, "
                    + " WHERE Id_imagenes = ? ";

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, imagenProductoVO.getProducto().getIdProducto());
            pstm.setString(2, imagenProductoVO.getRuta());
            pstm.setString(3, imagenProductoVO.getNombreArchivo());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ImagenProductoDAOMS: Se presento un error al actualizar una Imagen del producto."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int eliminar(long idImagenProducto) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " DELETE FROM ImagenesProductos WHERE Id_imagenes = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, idImagenProducto);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ImagenProductoDAOMS: Se presento un error al eliminar una Imagen del producto."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public ArrayList<ImagenProductoVO> listar() throws Exception {
        ArrayList<ImagenProductoVO> lista = new ArrayList<ImagenProductoVO>();
        ImagenProductoVO imagenProductoVO;
        try {
            this.Conectar();
            String consulta = "SELECT Id_imagenes, Id_Producto, ruta, NombreArchivo FROM ImagenesProducto"; 

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                imagenProductoVO = new ImagenProductoVO();
                imagenProductoVO.setIdImagen(rs.getInt(t++));
                imagenProductoVO.getProducto().setIdProducto(t++);
                imagenProductoVO.setRuta(rs.getString(t++));
                imagenProductoVO.setNombreArchivo(rs.getString(t++));

                lista.add(imagenProductoVO);
            }
        } catch (Exception e) {
            System.out.println(" ImagenProductoDAOMS: Se presento un error al consultar la tabla Imagen del producto. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public ImagenProductoVO consultarPorId(long idImagenProducto) throws Exception {
        ImagenProductoVO imagenProductoVO = null;
        try {
            this.Conectar();
            String consulta = " SELECT Id_imagenes, Id_Producto, ruta, NombreArchivo"
                    + " FROM ImagenesProducto WHERE Id_imagenes = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idImagenProducto);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                imagenProductoVO = new ImagenProductoVO();
                imagenProductoVO.setIdImagen(rs.getInt(t++));
                imagenProductoVO.getProducto().setIdProducto(t++);
                imagenProductoVO.setRuta(rs.getString(t++));
                imagenProductoVO.setNombreArchivo(rs.getString(t++));
                
            }

        } catch (Exception e) {
            System.out.println("ImagenProductoDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return imagenProductoVO;
    }
    
}
