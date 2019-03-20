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
import mueblesblanca.vo.EstadoOrdenVO;

/**
 *
 * @author Fabian García
 */

public class EstadoOrdenDAOMS extends ConexionSQL implements EstadoOrdenDAO {

    @Override
    public int insertar(EstadoOrdenVO estadoOrdenVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();

            String consulta = "INSERT INTO [dbo].[Estado_Orden] ([Descripcion] ,[Fecha_Creacion],[Usuario_Creacion],[Fecha_Modificacion],[Usuario_Modificacion],[Estado])\n"
                    + "VALUES(?,GETDATE(),?,?,?,?) ";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, estadoOrdenVO.getDescripcionEstadoOrden());
            pstm.setString(2, estadoOrdenVO.getUsuarioCreacionEstadoOrden());
            pstm.setTimestamp(3, estadoOrdenVO.getFechaModificacionEstadoOrden());
            pstm.setString(4, estadoOrdenVO.getUsuarioModificacionEstadoOrden());
            pstm.setInt(5, EstadoEnum.ACTIVO.getIndex());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" EstadoOrdenDAOMS: Se presento un error al insertar una Estado Orden."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(EstadoOrdenVO estadoOrdenVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();

            String consulta
                    = "	UPDATE [dbo].[Estado_Orden]\n"
                    + "	   SET [Descripcion] = ?\n"
                    + "		  ,[Fecha_Creacion] = ?\n"
                    + "		  ,[Usuario_Creacion] = ?\n"
                    + "		  ,[Fecha_Modificacion] = GETDATE()\n"
                    + "		  ,[Usuario_Modificacion] = ?\n"
                    + "		  ,[Estado] = ?\n"
                    + "	 WHERE Id_Estado_Orden = ?;";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, estadoOrdenVO.getDescripcionEstadoOrden());
            pstm.setString(2, estadoOrdenVO.getUsuarioCreacionEstadoOrden());
            pstm.setTimestamp(3, estadoOrdenVO.getFechaModificacionEstadoOrden());
            pstm.setString(4, estadoOrdenVO.getUsuarioModificacionEstadoOrden());
            pstm.setInt(5, EstadoEnum.ACTIVO.getIndex());
            pstm.setInt(6, estadoOrdenVO.getIdEstadoOrden());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" EstadoOrdenDAOMS: Se presento un error al insertar una Estado Orden."
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
            String consulta = " UPDATE Estado_Orden SET Estado = ? "
                    + " WHERE Id_Estado_Orden = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());
            pstm.setLong(2, id);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" EstadoOrdenDAOMS: Se presento un error al eliminar una Estado Orden."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;

    }

    @Override
    public ArrayList<EstadoOrdenVO> listar() throws Exception {
        ArrayList<EstadoOrdenVO> lista = new ArrayList<EstadoOrdenVO>();
        EstadoOrdenVO estadoOrdenVO;
        try {
            this.Conectar();
            String consulta = "SELECT * "
                    + " FROM Estado_Orden WHERE Id_Estado_Orden = ? ";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ACTIVO.getIndex());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                estadoOrdenVO = new EstadoOrdenVO();
                estadoOrdenVO.setIdEstadoOrden(rs.getInt(t++));
                estadoOrdenVO.setDescripcionEstadoOrden(rs.getString(t++));
                estadoOrdenVO.setFechaCreacionEstadoOrden(rs.getTimestamp(t++));
                estadoOrdenVO.setUsuarioCreacionEstadoOrden(rs.getString(t++));
                estadoOrdenVO.setFechaModificacionEstadoOrden(rs.getTimestamp(t++));
                estadoOrdenVO.setUsuarioModificacionEstadoOrden(rs.getString(t++));
                estadoOrdenVO.setEstado(rs.getInt(t++));

                lista.add(estadoOrdenVO);
            }
        } catch (Exception e) {
            System.out.println(" EstadoOrdenDAOMS: Se presento un error al consultar la tabla Estado Orden. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public EstadoOrdenVO consultarPorId(long id) throws Exception {
        EstadoOrdenVO estadoOrdenVO = null;
        try {
            this.Conectar();
            String consulta = " SELECT * "
                    + " FROM Estado_Orden WHERE Id_Estado_Orden = ?  ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, id);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                estadoOrdenVO = new EstadoOrdenVO();
                estadoOrdenVO.setIdEstadoOrden(rs.getInt(t++));
                estadoOrdenVO.setDescripcionEstadoOrden(rs.getString(t++));
                estadoOrdenVO.setFechaCreacionEstadoOrden(rs.getTimestamp(t++));
                estadoOrdenVO.setUsuarioCreacionEstadoOrden(rs.getString(t++));
                estadoOrdenVO.setFechaModificacionEstadoOrden(rs.getTimestamp(t++));
                estadoOrdenVO.setUsuarioModificacionEstadoOrden(rs.getString(t++));
                estadoOrdenVO.setEstado(rs.getInt(t++));
            }

        } catch (Exception e) {
            System.out.println("EstadoOrdenDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return estadoOrdenVO;
    }

}
