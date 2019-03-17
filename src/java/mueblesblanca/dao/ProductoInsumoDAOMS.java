/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mueblesblanca.constante.EstadoEnum;
import mueblesblanca.vo.ProductoInsumoVO;

/**
 *
 * @author cochoa
 */
public class ProductoInsumoDAOMS extends ConexionSQL implements ProductoInsumoDAO {

    @Override
    public int insertar(ProductoInsumoVO productoInsumoVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = "INSERT INTO [dbo].[Producto_Insumo]\n"
                    + "           ([Id_Producto]\n"
                    + "           ,[Id_Insumo]\n"
                    + "           ,[Cantidad]\n"
                    + "           ,[Estado])\n"
                    + "     VALUES\n"
                    + "           (?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?)";
            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, productoInsumoVO.getProducto().getIdProducto());
            pstm.setInt(2, productoInsumoVO.getInsumo().getIdInsumo());
            pstm.setInt(3, productoInsumoVO.getCantidad());
            pstm.setInt(4, EstadoEnum.ACTIVO.getIndex());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ProductoInsumoDAOMS: Se presento un error al insertar un ProductoInsumo."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(ProductoInsumoVO productoInsumoVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = "UPDATE [dbo].[Producto_Insumo]\n"
                    + "   SET  [Cantidad] = ? "
                    + " WHERE Id_Producto = ? and Id_Insumo = ?";

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, productoInsumoVO.getCantidad());
            pstm.setInt(2, productoInsumoVO.getProducto().getIdProducto());
            pstm.setInt(3, productoInsumoVO.getInsumo().getIdInsumo());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ProductoInsumoDAOMS: Se presento un error al actualizar un ProductoInsumo."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int eliminar(long idproducto, long idinsumo) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE [dbo].[Producto_Insumo] SET estado = ? "
                    + " WHERE Id_Producto = ? and Id_Insumo = ?";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());
            pstm.setLong(2, idproducto);
            pstm.setLong(3, idinsumo);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ProductoInsumoDAOMS: Se presento un error al eliminar un ProductoInsumo."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public ArrayList<ProductoInsumoVO> listar() throws Exception {
        ArrayList<ProductoInsumoVO> lista = new ArrayList<ProductoInsumoVO>();
        ProductoInsumoVO productoInsumoVO;
        try {
            this.Conectar();
            String consulta = "SELECT * "
                    + " FROM [dbo].[Producto_Insumo] WHERE estado = ? ";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ACTIVO.getIndex());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                productoInsumoVO = new ProductoInsumoVO();
                productoInsumoVO.getProducto().setIdProducto(rs.getInt(t++));
                productoInsumoVO.getInsumo().setIdInsumo(rs.getInt(t++));
                productoInsumoVO.setCantidad(rs.getInt(t++));
                productoInsumoVO.setEstado(rs.getInt(t++));

                lista.add(productoInsumoVO);
            }
        } catch (Exception e) {
            System.out.println(" ProductoInsumoDAOMS: Se presento un error al consultar la tabla ProductoInsumo. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public ProductoInsumoVO consultarPorId(long id) throws Exception {
        ProductoInsumoVO productoInsumoVO = null;
        try {
            this.Conectar();
            String consulta = " SELECT *"
                    + " FROM [dbo].[Producto_Insumo] WHERE Id_Producto = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, id);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                productoInsumoVO = new ProductoInsumoVO();
                productoInsumoVO.getProducto().setIdProducto(rs.getInt(t++));
                productoInsumoVO.getInsumo().setIdInsumo(rs.getInt(t++));
                productoInsumoVO.setCantidad(rs.getInt(t++));
                productoInsumoVO.setEstado(rs.getInt(t++));

            }

        } catch (Exception e) {
            System.out.println("ProductoInsumoDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return productoInsumoVO;
    }
}
