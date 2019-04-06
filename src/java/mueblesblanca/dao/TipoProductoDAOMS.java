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
import mueblesblanca.vo.TipoProductoVO;

/**
 *
 * @author Fabian García
 */

public class TipoProductoDAOMS extends ConexionSQL implements TipoProductoDAO {

    @Override
    public int insertar(TipoProductoVO tipoProductoVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = "INSERT INTO [dbo].[TipoProducto]\n"
                    + "           ([Descripcion_Tipo_Producto]\n"
                    + "           ,[Fecha_Creacion]\n"
                    + "           ,[Usuario_Creacion]\n"
                    + "           ,[Fecha_Modificacion]\n"
                    + "           ,[Usuario_Modificacion]\n"
                    + "           ,[estado])\n"
                    + "     VALUES\n"
                    + "           (?"
                    + "           ,GETDATE()"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?)";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, tipoProductoVO.getDescripcionTipoProducto());
            pstm.setString(2, tipoProductoVO.getUsuarioCreacionTipoProducto());
            pstm.setTimestamp(3, tipoProductoVO.getFechaModificacionTipoProducto());
            pstm.setString(4, tipoProductoVO.getUsuarioModificacionTipoProducto());
            pstm.setInt(5, EstadoEnum.ACTIVO.getIndex());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" TipoProductoDAOMS: Se presento un error al insertar un tipo producto."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(TipoProductoVO tipoProductoVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = "UPDATE [dbo].[TipoProducto]\n"
                    + "   SET [Descripcion_Tipo_Producto] = ?\n"
                    + "      ,[Fecha_Modificacion] = GETDATE()"
                    + "      ,[Usuario_Modificacion] = ?"
                    + "      ,[estado] = ?"
                    + " WHERE [Id_Tipo_Producto] = ?";

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, tipoProductoVO.getDescripcionTipoProducto());
            pstm.setString(2, tipoProductoVO.getUsuarioModificacionTipoProducto());
            pstm.setInt(3, tipoProductoVO.getEstado());
            
            pstm.setInt(4, tipoProductoVO.getIdTipoProducto());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" TipoProductoDAOMS: Se presento un error un tipo producto."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int eliminar(long id) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE [dbo].[TipoProducto] SET estado = ? "
                    + " WHERE Id_Tipo_Producto = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());
            pstm.setLong(2, id);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" TipoProductoDAOMS: Se presento un error un tipo producto."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public ArrayList<TipoProductoVO> listar() throws Exception {
        ArrayList<TipoProductoVO> lista = new ArrayList<TipoProductoVO>();
        TipoProductoVO tipoProductoVO;
        try {
            this.Conectar();
            String consulta = "SELECT * "
                    + " FROM [dbo].[TipoProducto] WHERE estado <> ? ";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                tipoProductoVO = new TipoProductoVO();
                tipoProductoVO.setIdTipoProducto(rs.getInt(t++));
                tipoProductoVO.setDescripcionTipoProducto(rs.getString(t++));
                tipoProductoVO.setFechaCreacionTipoProducto(rs.getTimestamp(t++));
                tipoProductoVO.setUsuarioCreacionTipoProducto(rs.getString(t++));
                tipoProductoVO.setFechaModificacionTipoProducto(rs.getTimestamp(t++));
                tipoProductoVO.setUsuarioModificacionTipoProducto(rs.getString(t++));
                tipoProductoVO.setEstado(rs.getInt(t++));

                lista.add(tipoProductoVO);
            }
        } catch (Exception e) {
            System.out.println(" TipoProductoDAOMS: Se presento un error al consultar la tabla tipo producto. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public TipoProductoVO consultarPorId(long id) throws Exception {
        TipoProductoVO tipoProductoVO = null;
        try {
            this.Conectar();
            String consulta = " SELECT *"
                    + " FROM [dbo].[TipoProducto] WHERE Id_Tipo_Producto = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, id);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                tipoProductoVO = new TipoProductoVO();
                tipoProductoVO.setIdTipoProducto(rs.getInt(t++));
                tipoProductoVO.setDescripcionTipoProducto(rs.getString(t++));
                tipoProductoVO.setFechaCreacionTipoProducto(rs.getTimestamp(t++));
                tipoProductoVO.setUsuarioCreacionTipoProducto(rs.getString(t++));
                tipoProductoVO.setFechaModificacionTipoProducto(rs.getTimestamp(t++));
                tipoProductoVO.setUsuarioModificacionTipoProducto(rs.getString(t++));
                tipoProductoVO.setEstado(rs.getInt(t++));
            }

        } catch (Exception e) {
            System.out.println("TipoProductoDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return tipoProductoVO;
    }

}
