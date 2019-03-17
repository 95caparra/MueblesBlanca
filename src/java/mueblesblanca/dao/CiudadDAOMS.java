package mueblesblanca.dao;

import mueblesblanca.vo.CiudadVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mueblesblanca.constante.EstadoEnum;

public class CiudadDAOMS extends ConexionSQL implements CiudadDAO {

    @Override
    public int insertar(CiudadVO ciudadVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " INSERT INTO ciudad ( Descripcion, Fecha_Creacion, Usuario_Creacion, Estado) "
                    + " VALUES(?,GETDATE(),?,?) ";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, ciudadVO.getDescripcionCiudad());
            pstm.setString(2, ciudadVO.getUsuarioCreacionCiudad());
            pstm.setInt(3, EstadoEnum.ACTIVO.getIndex());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" CiudadDAOMS: Se presento un error al insertar una Ciudad."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(CiudadVO ciudadVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE Ciudad SET "
                    + " Descripcion = ?, "
                    + " Fecha_Modificacion = GETDATE(), "
                    + " Usuario_Modificacion = ?,"
                    + " Estado = ?, "
                    + " WHERE Id_Ciudad = ? ";

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, ciudadVO.getDescripcionCiudad());
            pstm.setString(2, ciudadVO.getUsuarioModificacionCiudad());
            pstm.setInt(3, EstadoEnum.ACTIVO.getIndex());
            
            pstm.setInt(4, ciudadVO.getIdCiudad());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" CiudadDAOMS: Se presento un error al actualizar una Ciudad."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int eliminar(long idCiudad) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE Ciudad SET Estado = ? "
                    + " WHERE Id_Ciudad = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());
            pstm.setLong(2, idCiudad);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" CiudadDAOMS: Se presento un error al eliminar una Ciudad."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public ArrayList<CiudadVO> listar() throws Exception {
        ArrayList<CiudadVO> lista = new ArrayList<CiudadVO>();
        CiudadVO ciudadVO;
        try {
            this.Conectar();
            String consulta = "SELECT Id_Ciudad, Descripcion, Fecha_Creacion, Usuario_Creacion, Fecha_Modificacion, Usuario_Modificacion, Estado "
                    + " FROM Ciudad WHERE Estado = ? ";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ACTIVO.getIndex());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                ciudadVO = new CiudadVO();
                ciudadVO.setIdCiudad(rs.getInt(t++));
                ciudadVO.setDescripcionCiudad(rs.getString(t++));
                ciudadVO.setFechaCreacionCiudad(rs.getTimestamp(t++));
                ciudadVO.setUsuarioCreacionCiudad(rs.getString(t++));
                ciudadVO.setFechaModificacionCiudad(rs.getTimestamp(t++));
                ciudadVO.setUsuarioModificacionCiudad(rs.getString(t++));
                ciudadVO.setEstado(rs.getInt(t++));

                lista.add(ciudadVO);
            }
        } catch (Exception e) {
            System.out.println(" CiudadDAOMS: Se presento un error al consultar la tabla Ciudad. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public CiudadVO consultarPorId(long idCiudad) throws Exception {
        CiudadVO ciudadVO = null;
        try {
            this.Conectar();
            String consulta = " SELECT Id_Ciudad, Descripcion, Fecha_Creacion, Usuario_Creacion, Fecha_Modificacion, Usuario_Modificacion, Estado "
                    + " FROM Ciudad WHERE Id_Ciudad = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idCiudad);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                ciudadVO = new CiudadVO();
                ciudadVO.setIdCiudad(rs.getInt(t++));
                ciudadVO.setDescripcionCiudad(rs.getString(t++));
                ciudadVO.setFechaCreacionCiudad(rs.getTimestamp(t++));
                ciudadVO.setUsuarioCreacionCiudad(rs.getString(t++));
                ciudadVO.setFechaModificacionCiudad(rs.getTimestamp(t++));
                ciudadVO.setUsuarioModificacionCiudad(rs.getString(t++));
                ciudadVO.setEstado(rs.getInt(t++));
            }

        } catch (Exception e) {
            System.out.println("CiudadDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return ciudadVO;
    }

}
