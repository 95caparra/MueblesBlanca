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
import mueblesblanca.vo.RolVO;

/**
 *
 * @author cochoa
 */
public class RolDAOMS extends ConexionSQL implements RolDAO {

    @Override
    public int insertar(RolVO rolVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = "INSERT INTO [dbo].[Rol]\n"
                    + "           ([descripción]\n"
                    + "           ,[fechaCreacion_Rol]\n"
                    + "           ,[usuarioCreacion_Rol]\n"
                    + "           ,[fechaModificacion_Rol]\n"
                    + "           ,[usuarioModificacion]\n"
                    + "           ,[estado_Rol])\n"
                    + "            VALUES\n"
                    + "           (?\n"
                    + "           ,GETDATE()\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, rolVO.getDescripcionRol());
            pstm.setString(2, rolVO.getUsuarioCreacionRol());
            pstm.setTimestamp(3, rolVO.getFechaModificacionRol());
            pstm.setString(4, rolVO.getUsuarioModificacionRol());
            pstm.setInt(5, EstadoEnum.ACTIVO.getIndex());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" RolDAOMS: Se presento un error al insertar una Rol."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(RolVO rolVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = "UPDATE [dbo].[Rol]\n"
                    + "   SET [descripción] = ?"
                    + "      ,[fechaModificacion_Rol] = GETDATE()"
                    + "      ,[usuarioModificacion] = ?"
                    + " WHERE [id_Rol] = ?";

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, rolVO.getDescripcionRol());
            pstm.setString(2, rolVO.getUsuarioModificacionRol());
            pstm.setInt(3, rolVO.getIdRol());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" RolDAOMS: Se presento un error al actualizar una Rol."
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
            String consulta = " UPDATE [dbo].[Rol] SET estado_Rol = ? "
                    + " WHERE id_Rol = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());
            pstm.setLong(2, id);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" RolDAOMS: Se presento un error al eliminar una Rol."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public ArrayList<RolVO> listar() throws Exception {
        ArrayList<RolVO> lista = new ArrayList<RolVO>();
        RolVO rolVO;
        try {
            this.Conectar();
            String consulta = "SELECT * "
                    + " FROM [dbo].[Rol] WHERE id_Rol = ? ";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ACTIVO.getIndex());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                rolVO = new RolVO();
                rolVO.setIdRol(rs.getInt(t++));
                rolVO.setDescripcionRol(rs.getString(t++));
                rolVO.setFechaCreacionRol(rs.getTimestamp(t++));
                rolVO.setUsuarioCreacionRol(rs.getString(t++));
                rolVO.setFechaModificacionRol(rs.getTimestamp(t++));
                rolVO.setUsuarioModificacionRol(rs.getString(t++));
                rolVO.setEstado(rs.getInt(t++));

                lista.add(rolVO);
            }
        } catch (Exception e) {
            System.out.println(" RolDAOMS: Se presento un error al consultar la tabla Rol. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public RolVO consultarPorId(long id) throws Exception {
        RolVO rolVO = null;
        try {
            this.Conectar();
            String consulta = " SELECT *"
                    + " FROM [dbo].[Rol] WHERE Id_Ciudad = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, id);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                rolVO = new RolVO();
                rolVO.setIdRol(rs.getInt(t++));
                rolVO.setDescripcionRol(rs.getString(t++));
                rolVO.setFechaCreacionRol(rs.getTimestamp(t++));
                rolVO.setUsuarioCreacionRol(rs.getString(t++));
                rolVO.setFechaModificacionRol(rs.getTimestamp(t++));
                rolVO.setUsuarioModificacionRol(rs.getString(t++));
                rolVO.setEstado(rs.getInt(t++));
            }

        } catch (Exception e) {
            System.out.println("RolDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return rolVO;
    }
}
