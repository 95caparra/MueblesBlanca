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
import mueblesblanca.vo.TipoDocumentoVO;

/**
 *
 * @author Fabian García
 */

public class TipoDocumentoDAOMS extends ConexionSQL implements TipoDocumentoDAO {

    @Override
    public int insertar(TipoDocumentoVO tipoDocumentoVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = "INSERT INTO [dbo].[Tipo_Documento]\n"
                    + "           ([Descripcion]\n"
                    + "           ,[Fecha_Creacion]\n"
                    + "           ,[Usuario_Creacion]\n"
                    + "           ,[Fecha_Modificacion]\n"
                    + "           ,[Usuario_Modificacion]\n"
                    + "           ,[Estado])\n"
                    + "     VALUES\n"
                    + "           (?"
                    + "           ,GETDATE()"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?)";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, tipoDocumentoVO.getDescripcionTipoDocumento());
            pstm.setString(2, tipoDocumentoVO.getUsuarioCreacionTipoDocumento());
            pstm.setTimestamp(3, tipoDocumentoVO.getFechaModificacionTipoDocumento());
            pstm.setString(4, tipoDocumentoVO.getUsuarioModificacionTipoDocumento());
            pstm.setInt(5, EstadoEnum.ACTIVO.getIndex());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" TipoDocumentoDAOMS: Se presento un error al insertar un tipo documento."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(TipoDocumentoVO tipoDocumentoVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = "UPDATE [dbo].[Tipo_Documento]\n"
                    + "   SET [Descripcion] = ?"
                    + "      ,[Fecha_Modificacion] = GETDATE()"
                    + "      ,[Usuario_Modificacion] = ?"
                    + " WHERE [Id_Tipo_Documento] = ?";

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, tipoDocumentoVO.getDescripcionTipoDocumento());
            pstm.setString(2, tipoDocumentoVO.getUsuarioModificacionTipoDocumento());
            pstm.setInt(3, tipoDocumentoVO.getIdTipoDocumento());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" TipoDocumentoDAOMS: Se presento un error un tipo documento."
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
            String consulta = " UPDATE [dbo].[Tipo_Documento] SET estado = ? "
                    + " WHERE Id_Tipo_Documento = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());
            pstm.setLong(2, id);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" TipoDocumentoDAOMS: Se presento un error un tipo documento."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public ArrayList<TipoDocumentoVO> listar() throws Exception {
        ArrayList<TipoDocumentoVO> lista = new ArrayList<TipoDocumentoVO>();
        TipoDocumentoVO tipoDocumentoVO;
        try {
            this.Conectar();
            String consulta = "SELECT * "
                    + " FROM [dbo].[Tipo_Documento] WHERE Estado = ? ";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ACTIVO.getIndex());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                tipoDocumentoVO = new TipoDocumentoVO();
                tipoDocumentoVO.setIdTipoDocumento(rs.getInt(t++));
                tipoDocumentoVO.setDescripcionTipoDocumento(rs.getString(t++));
                tipoDocumentoVO.setFechaCreacionTipoDocumento(rs.getTimestamp(t++));
                tipoDocumentoVO.setUsuarioCreacionTipoDocumento(rs.getString(t++));
                tipoDocumentoVO.setFechaModificacionTipoDocumento(rs.getTimestamp(t++));
                tipoDocumentoVO.setUsuarioModificacionTipoDocumento(rs.getString(t++));
                tipoDocumentoVO.setEstado(rs.getInt(t++));

                lista.add(tipoDocumentoVO);
            }
        } catch (Exception e) {
            System.out.println(" TipoDocumentoDAOMS: Se presento un error al consultar la tabla tipo documento. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public TipoDocumentoVO consultarPorId(long id) throws Exception {
        TipoDocumentoVO tipoDocumentoVO = null;
        try {
            this.Conectar();
            String consulta = " SELECT * FROM [dbo].[Tipo_Documento] WHERE Id_Tipo_Documento = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, id);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                tipoDocumentoVO = new TipoDocumentoVO();
                tipoDocumentoVO.setIdTipoDocumento(rs.getInt(t++));
                tipoDocumentoVO.setDescripcionTipoDocumento(rs.getString(t++));
                tipoDocumentoVO.setFechaCreacionTipoDocumento(rs.getTimestamp(t++));
                tipoDocumentoVO.setUsuarioCreacionTipoDocumento(rs.getString(t++));
                tipoDocumentoVO.setFechaModificacionTipoDocumento(rs.getTimestamp(t++));
                tipoDocumentoVO.setUsuarioModificacionTipoDocumento(rs.getString(t++));
                tipoDocumentoVO.setEstado(rs.getInt(t++));
            }

        } catch (Exception e) {
            System.out.println("TipoDocumentoDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return tipoDocumentoVO;
    }
}

