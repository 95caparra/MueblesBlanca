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
import mueblesblanca.vo.PersonaNaturalVO;

/**
 *
 * @author Sergio AlfonsoG
 */
public class PersonaNaturalDAOMS extends ConexionSQL implements PersonaNaturalDAO {

    @Override
    public int insertar(PersonaNaturalVO personaNaturalVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " INSERT INTO Pedido (Identificacion_PersonaNatural, Id_Tipo_Documento_PersonaNatural, PrimerNombre_PersonaNatural, "
                    + "SegundoNombre_PersonaNatural, PrimerApellido_PersonaNatural, SegundoApellido_PersonaNatural, Telefono_PersonaNatural, "
                    + "Celular_PersonaNatural, Direccion_PersonaNatural, Id_Ciudad_PersonaNatural, Fecha_Creacion_PersonaNatural, "
                    + "Usuario_Creacion_PersonaNatural, Estado_PersonaNatural, IdRol_PersonaNatural)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,GETDATE(),?,?,?) ";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, personaNaturalVO.getIdentificacionPersonaNatural());
            pstm.setInt(2, personaNaturalVO.getTipoDocumentoPersonaNatural().getIdTipoDocumento());
            pstm.setString(3, personaNaturalVO.getPrimerNombrePersonaNatural());
            pstm.setString(4, personaNaturalVO.getSegundoNombrePersonaNatural());
            pstm.setString(5, personaNaturalVO.getPrimerApellidoPersonaNatural());  
            pstm.setString(6, personaNaturalVO.getSegundoApellidoPersonaNatural());  
            pstm.setString(7, personaNaturalVO.getTelefonoPersonaNatural());  
            pstm.setString(8, personaNaturalVO.getCelularPersonaNatural());  
            pstm.setString(9, personaNaturalVO.getDireccionPersonaNatural());  
            pstm.setInt(10, personaNaturalVO.getCiudadPersonaNatural().getIdCiudad());   
            pstm.setString(11, personaNaturalVO.getUsuarioCreacionPersonaNatural());      
            pstm.setInt(12, EstadoEnum.ACTIVO.getIndex());
            pstm.setInt(13, personaNaturalVO.getRolPersonaNatural().getIdRol());             

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" PersonaNaturalDAOMS: Se presento un error al insertar una Persona Natural."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(PersonaNaturalVO personaNaturalVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE PersonaNatural SET "
                    + " Identificacion_PersonaNatural = ?, "
                    + " Id_Tipo_Documento_PersonaNatural = ?, "
                    + " PrimerNombre_PersonaNatural = ?, "
                    + " SegundoNombre_PersonaNatural = ?, "
                    + " PrimerApellido_PersonaNatural = ?, "
                    + " SegundoApellido_PersonaNatural = ?, "
                    + " Telefono_PersonaNatural = ?, "
                    + " Celular_PersonaNatural = ?, "
                    + " Direccion_PersonaNatural = ?, "
                    + " Id_Ciudad_PersonaNatural = ?, "
                    + " Fecha_Modificacion_PersonaNatural = GETDATE(), "
                    + " Usuario_Modificacion_PersonaNatural = ?, "
                    + " Estado_PersonaNatural = ?, "
                    + " IdRol_PersonaNatural = ?, "
                    + " WHERE Id_PersonaNatural = ? ";

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, personaNaturalVO.getIdentificacionPersonaNatural());
            pstm.setInt(2, personaNaturalVO.getTipoDocumentoPersonaNatural().getIdTipoDocumento());
            pstm.setString(3, personaNaturalVO.getPrimerNombrePersonaNatural());
            pstm.setString(4, personaNaturalVO.getSegundoNombrePersonaNatural());
            pstm.setString(5, personaNaturalVO.getPrimerApellidoPersonaNatural());  
            pstm.setString(6, personaNaturalVO.getSegundoApellidoPersonaNatural());  
            pstm.setString(7, personaNaturalVO.getTelefonoPersonaNatural());  
            pstm.setString(8, personaNaturalVO.getCelularPersonaNatural());  
            pstm.setString(9, personaNaturalVO.getDireccionPersonaNatural());  
            pstm.setInt(10, personaNaturalVO.getCiudadPersonaNatural().getIdCiudad());  
            pstm.setString(12, personaNaturalVO.getUsuarioModificacionPersonaNatural());
            pstm.setInt(14, EstadoEnum.ACTIVO.getIndex());
            pstm.setInt(13, personaNaturalVO.getRolPersonaNatural().getIdRol());  
            
            pstm.setInt(14, personaNaturalVO.getIdPersonaNatural());  
            
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" PersonaNaturalDAOMS: Se presento un error al actualizar una Persona Natural."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int eliminar(long idPersonaNatural) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE PersonaNatural SET Estado_PersonaNatural = ? "
                    + " WHERE Id_PersonaNatural = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());
            pstm.setLong(2, idPersonaNatural);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" PersonaNaturalDAOMS: Se presento un error al eliminar una Persona Natural."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public ArrayList<PersonaNaturalVO> listar() throws Exception {
        ArrayList<PersonaNaturalVO> lista = new ArrayList<PersonaNaturalVO>();
        PersonaNaturalVO personaNaturalVO;
        try {
            this.Conectar();
            String consulta = "SELECT Id_PersonaNatural, Identificacion_PersonaNatural, Id_Tipo_Documento_PersonaNatural, PrimerNombre_PersonaNatural, "
                    + "SegundoNombre_PersonaNatural, PrimerApellido_PersonaNatural, SegundoApellido_PersonaNatural, Telefono_PersonaNatural, "
                    + "Celular_PersonaNatural, Direccion_PersonaNatural, Id_Ciudad_PersonaNatural, Fecha_Creacion_PersonaNatural, "
                    + "Usuario_Creacion_PersonaNatural, Fecha_Modificacion_PersonaNatural, Usuario_Modificacion_PersonaNatural, Estado_PersonaNatural, "
                    + "IdRol_PersonaNatural"
                    + " FROM PersonaNatural WHERE Estado_PersonaNatural = ? ";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ACTIVO.getIndex());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                personaNaturalVO = new PersonaNaturalVO();
                personaNaturalVO.setIdPersonaNatural(rs.getInt(t++));
                personaNaturalVO.setIdentificacionPersonaNatural(rs.getLong(t++));
                personaNaturalVO.getTipoDocumentoPersonaNatural().setIdTipoDocumento(t++);
                personaNaturalVO.setPrimerNombrePersonaNatural(rs.getString(t++));
                personaNaturalVO.setSegundoNombrePersonaNatural(rs.getString(t++));
                personaNaturalVO.setPrimerApellidoPersonaNatural(rs.getString(t++));
                personaNaturalVO.setSegundoApellidoPersonaNatural(rs.getString(t++));
                personaNaturalVO.setTelefonoPersonaNatural(rs.getString(t++));
                personaNaturalVO.setCelularPersonaNatural(rs.getString(t++));
                personaNaturalVO.setDireccionPersonaNatural(rs.getString(t++));
                personaNaturalVO.getCiudadPersonaNatural().setIdCiudad(t++);
                personaNaturalVO.setFechaCreacionPersonaNatural(rs.getTimestamp(t++));
                personaNaturalVO.setUsuarioCreacionPersonaNatural(rs.getString(t++));
                personaNaturalVO.setFechaModificacionPersonaNatural(rs.getTimestamp(t++));
                personaNaturalVO.setUsuarioModificacionPersonaNatural(rs.getString(t++));
                personaNaturalVO.setEstado(rs.getInt(t++));
                personaNaturalVO.getRolPersonaNatural().setIdRol(t++);

                lista.add(personaNaturalVO);
            }
        } catch (Exception e) {
            System.out.println(" PersonaNaturalDAOMS: Se presento un error al consultar la tabla PersonaNatural. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public PersonaNaturalVO consultarPorId(long idPersonaNatural) throws Exception {
        PersonaNaturalVO personaNaturalVO = null;
        try {
            this.Conectar();
            String consulta = "SELECT Id_PersonaNatural, Identificacion_PersonaNatural, Id_Tipo_Documento_PersonaNatural, PrimerNombre_PersonaNatural, "
                    + "SegundoNombre_PersonaNatural, PrimerApellido_PersonaNatural, SegundoApellido_PersonaNatural, Telefono_PersonaNatural, "
                    + "Celular_PersonaNatural, Direccion_PersonaNatural, Id_Ciudad_PersonaNatural, Fecha_Creacion_PersonaNatural, "
                    + "Usuario_Creacion_PersonaNatural, Fecha_Modificacion_PersonaNatural, Usuario_Modificacion_PersonaNatural, Estado_PersonaNatural, "
                    + "IdRol_PersonaNatural"
                    + " FROM PersonaNatural WHERE Id_PersonaNatural = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idPersonaNatural);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                personaNaturalVO = new PersonaNaturalVO();
                personaNaturalVO.setIdPersonaNatural(rs.getInt(t++));
                personaNaturalVO.setIdentificacionPersonaNatural(rs.getLong(t++));
                personaNaturalVO.getTipoDocumentoPersonaNatural().setIdTipoDocumento(t++);
                personaNaturalVO.setPrimerNombrePersonaNatural(rs.getString(t++));
                personaNaturalVO.setSegundoNombrePersonaNatural(rs.getString(t++));
                personaNaturalVO.setPrimerApellidoPersonaNatural(rs.getString(t++));
                personaNaturalVO.setSegundoApellidoPersonaNatural(rs.getString(t++));
                personaNaturalVO.setTelefonoPersonaNatural(rs.getString(t++));
                personaNaturalVO.setCelularPersonaNatural(rs.getString(t++));
                personaNaturalVO.setDireccionPersonaNatural(rs.getString(t++));
                personaNaturalVO.getCiudadPersonaNatural().setIdCiudad(t++);
                personaNaturalVO.setFechaCreacionPersonaNatural(rs.getTimestamp(t++));
                personaNaturalVO.setUsuarioCreacionPersonaNatural(rs.getString(t++));
                personaNaturalVO.setFechaModificacionPersonaNatural(rs.getTimestamp(t++));
                personaNaturalVO.setUsuarioModificacionPersonaNatural(rs.getString(t++));
                personaNaturalVO.setEstado(rs.getInt(t++));
                personaNaturalVO.getRolPersonaNatural().setIdRol(t++);
                
            }

        } catch (Exception e) {
            System.out.println("PersonaNaturalDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return personaNaturalVO;
    }
    
}
