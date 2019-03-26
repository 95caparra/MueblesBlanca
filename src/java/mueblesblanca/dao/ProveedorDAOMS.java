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
import mueblesblanca.vo.ProveedorVO;

/**
 *
 * @author Fabian García
 */
public class ProveedorDAOMS extends ConexionSQL implements ProveedorDAO {

    @Override
    public int insertar(ProveedorVO proveedorVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = "INSERT INTO [dbo].[Proveedor]\n"
                    + "           ([Razon_Social_Proveedor]\n"
                    + "           ,[Direccion_Proveedor]\n"
                    + "           ,[Telefono_Proveedor]\n"
                    + "           ,[Correo_Proveedor]\n"
                    + "           ,[Fecha_Creacion]\n"
                    + "           ,[Usuario_Creacion]\n"
                    + "           ,[Fecha_Modificacion]\n"
                    + "           ,[Usuario_Modificacion]\n"
                    + "           ,[Estado])\n"
                    + "     VALUES\n"
                    + "           (?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,GETDATE()"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?)";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, proveedorVO.getRazonSocialProveedor());
            pstm.setString(2, proveedorVO.getDireccionProveedor());
            pstm.setInt(3, proveedorVO.getTelefonoProveedor());
            pstm.setString(4, proveedorVO.getCorreoProveedor());
            pstm.setString(5, proveedorVO.getUsuarioCreacionProveedor());
            pstm.setTimestamp(6, proveedorVO.getFechaModificacionProveedor());
            pstm.setString(7, proveedorVO.getUsuarioModificacionProveedor());
            pstm.setInt(8, EstadoEnum.ACTIVO.getIndex());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ProveedorDAOMS: Se presento un error al insertar un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(ProveedorVO proveedorVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = "UPDATE [dbo].[Proveedor]\n"
                    + "   SET [Razon_Social_Proveedor] = ?"
                    + "      ,[Direccion_Proveedor] = ?"
                    + "      ,[Telefono_Proveedor] = ?"
                    + "      ,[Correo_Proveedor] = ?"
                    + "      ,[Fecha_Modificacion] = GETDATE()"
                    + "      ,[Usuario_Modificacion] = ?"
                    + "      ,[Estado] = ?   "
                    + " WHERE [Id_Proveedor] = ?";

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, proveedorVO.getRazonSocialProveedor());
            pstm.setString(2, proveedorVO.getDireccionProveedor());
            pstm.setInt(3, proveedorVO.getTelefonoProveedor());
            pstm.setString(4, proveedorVO.getCorreoProveedor());
            pstm.setString(5, proveedorVO.getUsuarioModificacionProveedor());
            pstm.setInt(6, proveedorVO.getEstado());
            pstm.setInt(7, proveedorVO.getIdProveedor());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ProveedorDAOMS: Se presento un error un proveedor."
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
            String consulta = " UPDATE [dbo].[Proveedor] SET estado = ? "
                    + " WHERE Id_Proveedor = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());
            pstm.setLong(2, id);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" ProveedorDAOMS: Se presento un error un proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public ArrayList<ProveedorVO> listar() throws Exception {
        ArrayList<ProveedorVO> lista = new ArrayList<ProveedorVO>();
        ProveedorVO proveedorVO;
        try {
            this.Conectar();
            String consulta = "SELECT * "
                    + " FROM [dbo].[Proveedor] WHERE estado <> ? ";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                proveedorVO = new ProveedorVO();
                proveedorVO.setIdProveedor(rs.getInt(t++));
                proveedorVO.setRazonSocialProveedor(rs.getString(t++));
                proveedorVO.setDireccionProveedor(rs.getString(t++));
                proveedorVO.setTelefonoProveedor(rs.getInt(t++));
                proveedorVO.setCorreoProveedor(rs.getString(t++));
                proveedorVO.setFechaCreacionProveedor(rs.getTimestamp(t++));
                proveedorVO.setUsuarioCreacionProveedor(rs.getString(t++));
                proveedorVO.setFechaModificacionProveedor(rs.getTimestamp(t++));
                proveedorVO.setUsuarioModificacionProveedor(rs.getString(t++));
                proveedorVO.setEstado(rs.getInt(t++));

                lista.add(proveedorVO);
            }
        } catch (Exception e) {
            System.out.println(" ProveedorDAOMS: Se presento un error al consultar la tabla proveedor. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public ProveedorVO consultarPorId(long id) throws Exception {
        ProveedorVO proveedorVO = null;
        try {
            this.Conectar();
            String consulta = " SELECT *"
                    + " FROM [dbo].[Proveedor] WHERE Id_Proveedor = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, id);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                proveedorVO = new ProveedorVO();
                proveedorVO.setIdProveedor(rs.getInt(t++));
                proveedorVO.setRazonSocialProveedor(rs.getString(t++));
                proveedorVO.setDireccionProveedor(rs.getString(t++));
                proveedorVO.setTelefonoProveedor(rs.getInt(t++));
                proveedorVO.setCorreoProveedor(rs.getString(t++));
                proveedorVO.setFechaCreacionProveedor(rs.getTimestamp(t++));
                proveedorVO.setUsuarioCreacionProveedor(rs.getString(t++));
                proveedorVO.setFechaModificacionProveedor(rs.getTimestamp(t++));
                proveedorVO.setUsuarioModificacionProveedor(rs.getString(t++));
                proveedorVO.setEstado(rs.getInt(t++));
            }

        } catch (Exception e) {
            System.out.println("ProveedorDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return proveedorVO;
    }
}
