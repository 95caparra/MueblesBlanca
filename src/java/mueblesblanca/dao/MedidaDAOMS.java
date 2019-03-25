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
import mueblesblanca.vo.MedidaVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class MedidaDAOMS extends ConexionSQL implements MedidaDAO {

    @Override
    public int insertar(MedidaVO medidaVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " INSERT INTO Medida (Descripcion_Medida, Fecha_Creacion, Usuario_Creacion, Estado)"
                    + " VALUES(?,GETDATE(),?,?) ";
            
            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, medidaVO.getDescripcionMedida());
            pstm.setString(2, medidaVO.getUsuarioCreacionMedida());
            pstm.setInt(3, EstadoEnum.ACTIVO.getIndex());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" MedidaDAOMS: Se presento un error al insertar una Medida."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(MedidaVO medidaVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE Medida SET "
                    + " Descripcion_Medida = ?, "
                    + " Fecha_Modificacion = GETDATE(), "
                    + " Usuario_Modificacion = ?, "
                    + " Estado = ? "
                    + " WHERE Id_Medida = ? ";

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, medidaVO.getDescripcionMedida());
            pstm.setString(2, medidaVO.getUsuarioModificacionMedida());
            pstm.setInt(3, EstadoEnum.ACTIVO.getIndex());
            
            pstm.setInt(4, medidaVO.getIdMedida());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" MedidaDAOMS: Se presento un error al actualizar un Medida."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int eliminar(long idMedida) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE Medida SET Estado = ? "
                    + " WHERE Id_Medida = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());
            pstm.setLong(2, idMedida);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" MedidaDAOMS: Se presento un error al eliminar un Medida."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public ArrayList<MedidaVO> listar() throws Exception {
        ArrayList<MedidaVO> lista = new ArrayList<MedidaVO>();
        MedidaVO medidaVO;
        try {
            this.Conectar();
            String consulta = "SELECT Id_Medida, Descripcion_Medida, Fecha_Creacion, Usuario_Creacion, Fecha_Modificacion, "
                    + "Usuario_Modificacion, Estado"
                    + " FROM Medida WHERE Estado = ? ";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ACTIVO.getIndex());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                medidaVO = new MedidaVO();
                medidaVO.setIdMedida(rs.getInt(t++));
                medidaVO.setDescripcionMedida(rs.getString(t++));
                medidaVO.setFechaCreacionMedida(rs.getTimestamp(t++));
                medidaVO.setUsuarioCreacionMedida(rs.getString(t++));
                medidaVO.setFechaModificacionMedida(rs.getTimestamp(t++));
                medidaVO.setUsuarioModificacionMedida(rs.getString(t++));
                medidaVO.setEstado(rs.getInt(t++));
                
                lista.add(medidaVO);
            }
        } catch (Exception e) {
            System.out.println(" MedidaDAOMS: Se presento un error al consultar la tabla Medida. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public MedidaVO consultarPorId(long idMedida) throws Exception {
         MedidaVO medidaVO = null;
        try {
            this.Conectar();
            String consulta = "SELECT Id_Medida, Descripcion_Medida, Fecha_Creacion, Usuario_Creacion, Fecha_Modificacion, "
                    + "Usuario_Modificacion, Estado"
                    + " FROM Medida WHERE Id_Medida = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idMedida);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                medidaVO = new MedidaVO();
                medidaVO.setIdMedida(rs.getInt(t++));
                medidaVO.setDescripcionMedida(rs.getString(t++));
                medidaVO.setFechaCreacionMedida(rs.getTimestamp(t++));
                medidaVO.setUsuarioCreacionMedida(rs.getString(t++));
                medidaVO.setFechaModificacionMedida(rs.getTimestamp(t++));
                medidaVO.setUsuarioModificacionMedida(rs.getString(t++));
                medidaVO.setEstado(rs.getInt(t++));
            }

        } catch (Exception e) {
            System.out.println("MedidaDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return medidaVO;
    }
    
}
