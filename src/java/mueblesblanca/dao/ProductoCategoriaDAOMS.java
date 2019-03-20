/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mueblesblanca.vo.ProductoCategoriaVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class ProductoCategoriaDAOMS extends ConexionSQL implements ProductoCategoriaDAO {

    @Override
    public int insertar(ProductoCategoriaVO productoCategoriaVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " INSERT INTO Producto_Categoria ( Id_Producto, Id_Categoria )"
                    + " VALUES(?,?) ";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, productoCategoriaVO.getProducto().getIdProducto());
            pstm.setInt(2, productoCategoriaVO.getCategoria().getIdCategoria());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ProductoCategoriaDAOMS: Se presento un error al insertar un Producto o Categoria."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(ProductoCategoriaVO productoCategoriaVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE Producto_Categoria SET "
                    + " Id_Producto = ?, "
                    + " Id_Categoria = ? "
                    + " WHERE Id_Producto = ?  AND  Id_Categoria = ?";

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, productoCategoriaVO.getProducto().getIdProducto());
            pstm.setInt(2, productoCategoriaVO.getCategoria().getIdCategoria());
               
            pstm.setInt(3, productoCategoriaVO.getProducto().getIdProducto());
            pstm.setInt(4, productoCategoriaVO.getCategoria().getIdCategoria());
            
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ProductoCategoriaDAOMS: Se presento un error al actualizar un Producto o Categoria."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int eliminar(long idProducto, long idCategoria) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " DELETE FORM Producto_Categoria WHERE Id_Producto = ? AND Id_Categoria = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, idProducto);
            pstm.setLong(2, idCategoria);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ProductoCategoriaDAOMS: Se presento un error al eliminar un Producto y Categoria."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public ArrayList<ProductoCategoriaVO> listar() throws Exception {
        ArrayList<ProductoCategoriaVO> lista = new ArrayList<ProductoCategoriaVO>();
        ProductoCategoriaVO productoCategoriaVO;
        try {
            this.Conectar();
            String consulta = "SELECT Id_Producto, Id_Categoria FROM Producto_Categoria";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                productoCategoriaVO = new ProductoCategoriaVO();
                productoCategoriaVO.getProducto().setIdProducto(t++);
                productoCategoriaVO.getCategoria().setIdCategoria(t++);

                lista.add(productoCategoriaVO);
            }
        } catch (Exception e) {
            System.out.println(" ProductoCategoriaDAOMS: Se presento un error al consultar la tabla Producto_Categoria. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public ProductoCategoriaVO consultarPorId(long idProducto) throws Exception {
        ProductoCategoriaVO productoCategoriaVO = null;
        try {
            this.Conectar();
            String consulta = " SELECT Id_Producto, Id_Categoria"
                    + " FROM Producto_Categoria WHERE Id_Producto = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idProducto);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                productoCategoriaVO = new ProductoCategoriaVO();
                productoCategoriaVO.getProducto().setIdProducto(t++);
                productoCategoriaVO.getCategoria().setIdCategoria(t++);
                
            }

        } catch (Exception e) {
            System.out.println("ProductoCategoriaDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return productoCategoriaVO;
    }
    
}
