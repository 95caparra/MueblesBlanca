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
import mueblesblanca.vo.ProductoVO;

/**
 *
 * @author Sergio AlfonsoG
 */
public class ProductoDAOMS extends ConexionSQL implements ProductoDAO {

    @Override
    public int insertar(ProductoVO productoVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " INSERT INTO Producto ( NombreProducto, Id_Tipo_Producto, Cantidad_Existente, Precio_Unidad_Producto, "
                    + "Id_Medida_Producto, Descripcion_Producto, Fecha_Creacion, Usuario_Creacion, Estado, foto)"
                    + " VALUES(?,?,?,?,?,?,GETDATE(),?,?,?) ";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, productoVO.getNombreProducto());
            pstm.setInt(2, productoVO.getTipoProducto().getIdTipoProducto());
            pstm.setInt(3, productoVO.getCantidadExistente());
            pstm.setBigDecimal(4, productoVO.getPrecioUnidadProducto());
            pstm.setInt(5, productoVO.getMedida().getIdMedida());
            pstm.setString(6, productoVO.getDescripcionProducto());
            pstm.setString(7, productoVO.getUsuarioCreacionProducto());
            pstm.setInt(8, productoVO.getEstado());
            pstm.setBytes(9, productoVO.getFoto());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ProductoDAOMS: Se presento un error al insertar un Producto."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(ProductoVO productoVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE Producto SET "
                    + " NombreProducto = ?, "
                    + " Id_Tipo_Producto = ?, "
                    + " Cantidad_Existente = ?, "
                    + " Precio_Unidad_Producto = ?, "
                    + " Id_Medida_Producto = ?, "
                    + " Descripcion_Producto = ?, "
                    + " Fecha_Modificacion = GETDATE(), "
                    + " Usuario_Modificacion = ?, "
                    + " Estado = ? "
                    + " WHERE Id_Producto = ? ";

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, productoVO.getNombreProducto());
            pstm.setInt(2, productoVO.getTipoProducto().getIdTipoProducto());
            pstm.setInt(3, productoVO.getCantidadExistente());
            pstm.setBigDecimal(4, productoVO.getPrecioUnidadProducto());
            pstm.setInt(5, productoVO.getMedida().getIdMedida());
            pstm.setString(6, productoVO.getDescripcionProducto());
            pstm.setString(7, productoVO.getUsuarioModificacionProducto());
            pstm.setInt(8, EstadoEnum.ACTIVO.getIndex());

            pstm.setInt(9, productoVO.getIdProducto());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ProductoDAOMS: Se presento un error al actualizar un Producto."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int eliminar(long idProducto) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE Producto SET Estado = ? "
                    + " WHERE Id_Producto = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());
            pstm.setLong(2, idProducto);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ProductoDAOMS: Se presento un error al eliminar un Producto."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public ArrayList<ProductoVO> listar() throws Exception {
        ArrayList<ProductoVO> lista = new ArrayList<ProductoVO>();
        ProductoVO productoVO;
        try {
            this.Conectar();
            String consulta = "SELECT Id_Producto, NombreProducto, Id_Tipo_Producto, Cantidad_Existente, Precio_Unidad_Producto, Id_Medida_Producto, Descripcion_Producto, Fecha_Creacion, Usuario_Creacion, Fecha_Modificacion, Usuario_Modificacion, Estado, foto FROM Producto WHERE estado <> ? ";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                productoVO = new ProductoVO();
                productoVO.setIdProducto(rs.getInt(t++));
                productoVO.setNombreProducto(rs.getString(t++));
                productoVO.getTipoProducto().setIdTipoProducto(rs.getInt(t++));
                productoVO.setCantidadExistente(rs.getInt(t++));
                productoVO.setPrecioUnidadProducto(rs.getBigDecimal(t++));
                productoVO.getMedida().setIdMedida(rs.getInt(t++));
                productoVO.setDescripcionProducto(rs.getString(t++));
                productoVO.setFechaCreacionProducto(rs.getTimestamp(t++));
                productoVO.setUsuarioCreacionProducto(rs.getString(t++));
                productoVO.setFechaModificacionProducto(rs.getTimestamp(t++));
                productoVO.setUsuarioModificacionProducto(rs.getString(t++));
                productoVO.setEstado(rs.getInt(t++));
                productoVO.setFoto(rs.getBytes(t++));
                lista.add(productoVO);
            }
        } catch (Exception e) {
            System.out.println(" ProductoDAOMS: Se presento un error al consultar la tabla Producto. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public ProductoVO consultarPorId(long id) throws Exception {
        ProductoVO productoVO = null;
        try {
            this.Conectar();
            String consulta = " SELECT Id_Producto, NombreProducto,Id_Tipo_Producto, Cantidad_Existente, Precio_Unidad_Producto,"
                    +" Id_Medida_Producto, Descripcion_Producto, Fecha_Creacion, Usuario_Creacion, " 
                    +" Fecha_Modificacion, Usuario_Modificacion, Estado, foto "
                    +" FROM [dbo].[Producto] WHERE [Id_Producto] = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, id);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                productoVO = new ProductoVO();
                productoVO.setIdProducto(rs.getInt(t++));
                productoVO.setNombreProducto(rs.getString(t++));
                productoVO.getTipoProducto().setIdTipoProducto(rs.getInt(t++));
                productoVO.setCantidadExistente(rs.getInt(t++));
                productoVO.setPrecioUnidadProducto(rs.getBigDecimal(t++));
                productoVO.getMedida().setIdMedida(rs.getInt(t++));
                productoVO.setDescripcionProducto(rs.getString(t++));
                productoVO.setFechaCreacionProducto(rs.getTimestamp(t++));
                productoVO.setUsuarioCreacionProducto(rs.getString(t++));
                productoVO.setFechaModificacionProducto(rs.getTimestamp(t++));
                productoVO.setUsuarioModificacionProducto(rs.getString(t++));
                productoVO.setEstado(rs.getInt(t++));
                productoVO.setFoto(rs.getBytes(t++));
            }

        } catch (Exception e) {
            System.out.println("ProductoDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return productoVO;
    }
}
