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
import mueblesblanca.vo.InsumoVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class InsumoDAOMS extends ConexionSQL implements InsumoDAO {

    @Override
    public int insertar(InsumoVO insumoVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " INSERT INTO Insumo ( Nombre_Insumo, Cantidad_Existente, Id_Medida, Precio_Unidad_Insumo, "
                    + "Detalle_Insumo, Fecha_Creacion, Usuario_Creacion, Estado)"
                    + " VALUES(?,?,?,?,?,GETDATE(),?,?) ";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, insumoVO.getNombreInsumo());
            pstm.setInt(2, insumoVO.getcantidadExistente());
            pstm.setInt(3, insumoVO.getMedida().getIdMedida());
            pstm.setBigDecimal(4, insumoVO.getPrecioUnidadInsumo());
            pstm.setString(5, insumoVO.getDetalleInsumo());
            pstm.setString(6, insumoVO.getUsuarioCreacionInsumo());    
            pstm.setInt(7, EstadoEnum.ACTIVO.getIndex());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" InsumoDAOMS: Se presento un error al insertar un Insumo."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(InsumoVO insumoVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE Insumo SET "
                    + " Nombre_Insumo = ?, "
                    + " Cantidad_Existente = ?, "
                    + " Id_Medida = ?, "
                    + " Precio_Unidad_Insumo = ?, "
                    + " Detalle_Insumo = ?, "
                    + " Fecha_Modificacion = GETDATE(), "
                    + " Usuario_Modificacion = ?, "
                    + " Estado = ?, "
                    + " WHERE Id_insumo = ? ";

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, insumoVO.getNombreInsumo());
            pstm.setInt(2, insumoVO.getcantidadExistente());
            pstm.setInt(3, insumoVO.getMedida().getIdMedida());
            pstm.setBigDecimal(4, insumoVO.getPrecioUnidadInsumo());
            pstm.setString(5, insumoVO.getDetalleInsumo());
            pstm.setTimestamp(6, insumoVO.getFechaModificacionInsumo());
            pstm.setString(7, insumoVO.getUsuarioModificacionInsumo());
            pstm.setInt(8, insumoVO.getEstado());
               
            pstm.setInt(9, insumoVO.getIdInsumo());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" InsumoDAOMS: Se presento un error al actualizar un Insumo."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int eliminar(long idInsumo) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE Insumo SET Estado = ? "
                    + " WHERE Id_insumo = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());
            pstm.setLong(2, idInsumo);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" InsumoDAOMS: Se presento un error al eliminar un Insumo."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public ArrayList<InsumoVO> listar() throws Exception {
        ArrayList<InsumoVO> lista = new ArrayList<InsumoVO>();
        InsumoVO insumoVO;
        try {
            this.Conectar();
            String consulta = "SELECT Id_insumo, Nombre_Insumo, Cantidad_Existente, Id_Medida, Precio_Unidad_Insumo, Detalle_Insumo, "
                    + "Fecha_Creacion, Usuario_Creacion, Fecha_Modificacion, Usuario_Modificacion, Estado "
                    + " FROM Insumo WHERE Estado <> ? ";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                insumoVO = new InsumoVO();
                insumoVO.setIdInsumo(rs.getInt(t++));
                insumoVO.setNombreInsumo(rs.getString(t++));
                insumoVO.setcantidadExistente(rs.getInt(t++));
                insumoVO.getMedida().setIdMedida(t++);
                insumoVO.setPrecioUnidadInsumo(rs.getBigDecimal(t++));
                insumoVO.setDetalleInsumo(rs.getString(t++));
                insumoVO.setFechaCreacionInsumo(rs.getTimestamp(t++));
                insumoVO.setUsuarioCreacionInsumo(rs.getString(t++));
                insumoVO.setFechaModificacionInsumo(rs.getTimestamp(t++));
                insumoVO.setUsuarioModificacionInsumo(rs.getString(t++));
                insumoVO.setEstado(rs.getInt(t++));

                lista.add(insumoVO);
            }
        } catch (Exception e) {
            System.out.println(" InsumoDAOMS: Se presento un error al consultar la tabla Insumo. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public InsumoVO consultarPorId(long idInsumo) throws Exception {
        InsumoVO insumoVO = null;
        try {
            this.Conectar();
            String consulta = " SELECT Id_insumo, Nombre_Insumo, Cantidad_Existente, Id_Medida, Precio_Unidad_Insumo, Detalle_Insumo, "
                    + "Fecha_Creacion, Usuario_Creacion, Fecha_Modificacion, Usuario_Modificacion, Estado "
                    + " FROM Insumo WHERE Id_insumo = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idInsumo);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                insumoVO = new InsumoVO();
                insumoVO.setIdInsumo(rs.getInt(t++));
                insumoVO.setNombreInsumo(rs.getString(t++));
                insumoVO.setcantidadExistente(rs.getInt(t++));
                insumoVO.getMedida().setIdMedida(t++);
                insumoVO.setPrecioUnidadInsumo(rs.getBigDecimal(t++));
                insumoVO.setDetalleInsumo(rs.getString(t++));
                insumoVO.setFechaCreacionInsumo(rs.getTimestamp(t++));
                insumoVO.setUsuarioCreacionInsumo(rs.getString(t++));
                insumoVO.setFechaModificacionInsumo(rs.getTimestamp(t++));
                insumoVO.setUsuarioModificacionInsumo(rs.getString(t++));
                insumoVO.setEstado(rs.getInt(t++));
            }

        } catch (Exception e) {
            System.out.println("InsumoDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return insumoVO;
    }
    
}
