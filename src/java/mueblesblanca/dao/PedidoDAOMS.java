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
import mueblesblanca.vo.PedidoVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class PedidoDAOMS extends ConexionSQL implements PedidoDAO {

    @Override
    public int insertar(PedidoVO pedidoVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " INSERT INTO Pedido (Id_Insumo, Id_Proveedor, Fecha_Sugerida, Observacion, Fecha_Creacion, "
                    + "Usuario_Creacion, Estado)"
                    + " VALUES(?,?,?,?,GETDATE(),?,?) ";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, pedidoVO.getInsumo().getIdInsumo());
            pstm.setInt(2, pedidoVO.getProveedor().getIdProveedor());
            pstm.setTimestamp(3, pedidoVO.getFechaSugeridaPedido());
            pstm.setString(4, pedidoVO.getObservacionPedido());
            pstm.setString(5, pedidoVO.getUsuarioCreacionPedido());   
            pstm.setInt(6, EstadoEnum.ACTIVO.getIndex());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" PedidoDAOMS: Se presento un error al insertar un Pedido."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(PedidoVO pedidoVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE Pedido SET "
                    + " Id_Insumo = ?, "
                    + " Id_Proveedor = ?, "
                    + " Fecha_Sugerida = ?, "
                    + " Observacion = ?, "
                    + " Fecha_Modificacion = GETDATE(), "
                    + " Usuario_Modificacion = ?, "
                    + " Estado = ?, "
                    + " WHERE Id_Pedido = ? ";

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, pedidoVO.getInsumo().getIdInsumo());
            pstm.setInt(2, pedidoVO.getProveedor().getIdProveedor());
            pstm.setTimestamp(3, pedidoVO.getFechaSugeridaPedido());
            pstm.setString(4, pedidoVO.getObservacionPedido());
            pstm.setString(5, pedidoVO.getUsuarioModificacionPedido());
            pstm.setInt(6, EstadoEnum.ACTIVO.getIndex());
            
            pstm.setInt(7, pedidoVO.getIdPedido());               

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" PedidoDAOMS: Se presento un error al actualizar un Pedido."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int eliminar(long idPedido) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE Pedido SET Estado = ? "
                    + " WHERE Id_Pedido = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());
            pstm.setLong(2, idPedido);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" PedidoDAOMS: Se presento un error al eliminar un Pedido."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public ArrayList<PedidoVO> listar() throws Exception {
        ArrayList<PedidoVO> lista = new ArrayList<PedidoVO>();
        PedidoVO pedidoVO;
        try {
            this.Conectar();
            String consulta = "SELECT Id_Pedido, Id_Insumo, Id_Proveedor, Fecha_Sugerida, Observacion, Fecha_Creacion, Usuario_Creacion, "
                    + "Fecha_Modificacion, Usuario_Modificacion, Estado"
                    + " FROM Insumo WHERE Estado = ? ";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ACTIVO.getIndex());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                pedidoVO = new PedidoVO();
                pedidoVO.setIdPedido(rs.getInt(t++));
                pedidoVO.getInsumo().setIdInsumo(t++);
                pedidoVO.getProveedor().setIdProveedor(t);
                pedidoVO.setFechaSugeridaPedido(rs.getTimestamp(t++));
                pedidoVO.setObservacionPedido(rs.getString(t++));
                pedidoVO.setFechaCreacionPedido(rs.getTimestamp(t++));
                pedidoVO.setUsuarioCreacionPedido(rs.getString(t++));
                pedidoVO.setFechaModificacionPedido(rs.getTimestamp(t++));
                pedidoVO.setUsuarioModificacionPedido(rs.getString(t++));
                pedidoVO.setEstado(rs.getInt(t++));

                lista.add(pedidoVO);
            }
        } catch (Exception e) {
            System.out.println(" PedidoDAOMS: Se presento un error al consultar la tabla Pedido. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public PedidoVO consultarPorId(long idPedido) throws Exception {
        PedidoVO pedidoVO = null;
        try {
            this.Conectar();
            String consulta = "SELECT Id_Pedido, Id_Insumo, Id_Proveedor, Fecha_Sugerida, Observacion, Fecha_Creacion, Usuario_Creacion, "
                    + "Fecha_Modificacion, Usuario_Modificacion, Estado"
                    + " FROM Insumo WHERE Id_Pedido = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idPedido);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                pedidoVO = new PedidoVO();
                pedidoVO.setIdPedido(rs.getInt(t++));
                pedidoVO.getInsumo().setIdInsumo(t++);
                pedidoVO.getProveedor().setIdProveedor(t);
                pedidoVO.setFechaSugeridaPedido(rs.getTimestamp(t++));
                pedidoVO.setObservacionPedido(rs.getString(t++));
                pedidoVO.setFechaCreacionPedido(rs.getTimestamp(t++));
                pedidoVO.setUsuarioCreacionPedido(rs.getString(t++));
                pedidoVO.setFechaModificacionPedido(rs.getTimestamp(t++));
                pedidoVO.setUsuarioModificacionPedido(rs.getString(t++));
                pedidoVO.setEstado(rs.getInt(t++));
            }

        } catch (Exception e) {
            System.out.println("PedidoDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return pedidoVO;
    }
    
}