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
import mueblesblanca.vo.AutorizacionVO;

/**
 *
 * @author Sergio  
 */

public class AutorizacionDAOMS extends ConexionSQL implements AutorizacionDAO  {

    @Override
    public int insertar(AutorizacionVO autorizacionVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " INSERT INTO Autorizaciones ( codigoOpcion_Autorizacion, id_rol_Autorizacion, Modifica_Autorizacion, "
                    + "Crea_Autorizacion, Consulta_Autorizacion, Elimina_Autorizacion, fechaCreacion_Autorizacion, usuarioCreacion_Autorizacion, estado_Autorizacion) "
                    + " VALUES (?,?,?,?,?,?,GETDATE(),?,?)";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, autorizacionVO.getCodigoOpcionAutorizacion());
            pstm.setInt(2, autorizacionVO.getRol().getIdRol());
            pstm.setString(3, autorizacionVO.getModificaAutorizacion());
            pstm.setString(4, autorizacionVO.getCreaAutorizacion());
            pstm.setString(5, autorizacionVO.getConsultaAutorizacion());
            pstm.setString(6, autorizacionVO.getEliminaAutorizacion());
            pstm.setString(7, autorizacionVO.getUsuarioCreacionAutorizacion());       
            pstm.setInt(8, EstadoEnum.ACTIVO.getIndex());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" AutorizacionDAOMS: Se presento un error al insertar una Autorizacion."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(AutorizacionVO autorizacionVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE Autorizaciones SET "
                    + " codigoOpcion_Autorizacion = ?, "
                    + " id_rol_Autorizacion = ?, "
                    + " Modifica_Autorizacion = ?, " 
                    + " Crea_Autorizacion = ?, " 
                    + " Consulta_Autorizacion = ?, " 
                    + " Elimina_Autorizacion = ?, "
                    + " fechaModificacion_Autorizacion = GETDATE(), "
                    + " usuarioModificacion_Autorizacion = ? "
                    + " WHERE id_Autorizacion = ? ";        

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, autorizacionVO.getCodigoOpcionAutorizacion());
            pstm.setInt(2, autorizacionVO.getRol().getIdRol());
            pstm.setString(3, autorizacionVO.getModificaAutorizacion());
            pstm.setString(4, autorizacionVO.getCreaAutorizacion());
            pstm.setString(5, autorizacionVO.getConsultaAutorizacion());
            pstm.setString(6, autorizacionVO.getEliminaAutorizacion());
            pstm.setString(7, autorizacionVO.getUsuarioModificacion()); 

            pstm.setInt(8, autorizacionVO.getIdAutorizacion());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" AutorizacionDAOMS: Se presento un error al actualizar una Autorizacion."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int eliminar(long idAutorizacion) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE Autorizaciones SET estado_Autorizacion = ? "
                    + " WHERE id_Autorizacion = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());
            pstm.setLong(2, idAutorizacion);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" AutorizacionDAOMS: Se presento un error al eliminar una Autorizacion."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public ArrayList<AutorizacionVO> listar() throws Exception {
         ArrayList<AutorizacionVO> lista = new ArrayList<AutorizacionVO>();
        AutorizacionVO autorizacionVO;
        try {
            this.Conectar();
            String consulta = " SELECT id_Autorizacion, codigoOpcion_Autorizacion, id_rol_Autorizacion, Modifica_Autorizacion, "
                    + "Crea_Autorizacion, Consulta_Autorizacion, Elimina_Autorizacion, fechaCreacion_Autorizacion, usuarioCreacion_Autorizacion, "
                    + "fechaModificacion_Autorizacion, usuarioModificacion_Autorizacion, estado_Autorizacion"
                    + " FROM Autorizaciones WHERE estado_Autorizacion = ? ";
            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ACTIVO.getIndex());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                autorizacionVO = new AutorizacionVO();
                autorizacionVO.setIdAutorizacion(rs.getInt(t++));
                autorizacionVO.setCodigoOpcionAutorizacion(rs.getInt(t++));
                autorizacionVO.getRol().setIdRol(t++);
                autorizacionVO.setModificaAutorizacion(rs.getString(t++));
                autorizacionVO.setCreaAutorizacion(rs.getString(t++));
                autorizacionVO.setConsultaAutorizacion(rs.getString(t++));
                autorizacionVO.setEliminaAutorizacion(rs.getString(t++));                
                autorizacionVO.setFechaCreacionAutorizacion(rs.getTimestamp(t++));
                autorizacionVO.setUsuarioCreacionAutorizacion(rs.getString(t++));
                autorizacionVO.setFechaModificacionAutorizacion(rs.getTimestamp(t++));
                autorizacionVO.setUsuarioModificacion(rs.getString(t++));
                autorizacionVO.setEstadoAutorizacion(rs.getInt(t++));               

                lista.add(autorizacionVO);
            }
        } catch (Exception e) {
            System.out.println(" AutorizacionDAOMS: Se presento un error al consultar la tabla Autorizaciones. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public AutorizacionVO consultarPorId(long idAutorizacion) throws Exception {
        AutorizacionVO autorizacionVO = null;
        try {
            this.Conectar();
            String consulta = " SELECT id_Autorizacion, codigoOpcion_Autorizacion, id_rol_Autorizacion, Modifica_Autorizacion, "
                    + "Crea_Autorizacion, Consulta_Autorizacion, Elimina_Autorizacion, fechaCreacion_Autorizacion, usuarioCreacion_Autorizacion, "
                    + "fechaModificacion_Autorizacion, usuarioModificacion_Autorizacion, estado_Autorizacion"
                    + " FROM Autorizaciones WHERE id_Autorizacion = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idAutorizacion);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                autorizacionVO = new AutorizacionVO();
                autorizacionVO.setIdAutorizacion(rs.getInt(t++));
                autorizacionVO.setCodigoOpcionAutorizacion(rs.getInt(t++));
                autorizacionVO.getRol().setIdRol(t++);
                autorizacionVO.setModificaAutorizacion(rs.getString(t++));
                autorizacionVO.setCreaAutorizacion(rs.getString(t++));
                autorizacionVO.setConsultaAutorizacion(rs.getString(t++));
                autorizacionVO.setEliminaAutorizacion(rs.getString(t++));                
                autorizacionVO.setFechaCreacionAutorizacion(rs.getTimestamp(t++));
                autorizacionVO.setUsuarioCreacionAutorizacion(rs.getString(t++));
                autorizacionVO.setFechaModificacionAutorizacion(rs.getTimestamp(t++));
                autorizacionVO.setUsuarioModificacion(rs.getString(t++));
                autorizacionVO.setEstadoAutorizacion(rs.getInt(t++)); 
            }

        } catch (Exception e) {
            System.out.println("AutorizacionDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return autorizacionVO;
    }
    
}
