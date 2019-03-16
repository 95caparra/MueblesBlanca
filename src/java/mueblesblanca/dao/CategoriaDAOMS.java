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
import mueblesblanca.vo.CategoriaVO;

/**
 *
 * @author Sergio AlfonsoG
 */
public class CategoriaDAOMS extends ConexionSQL implements CategoriaDAO {

    @Override
    public int insertar(CategoriaVO categoriaVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " INSERT INTO Categoria ( Descripcion_Categoria, Fecha_Creacion, Usuario_Creacion, Estado) "
                    + " VALUES(?,GETDATE(),?,?) ";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, categoriaVO.getDescripcionCategoria());
            pstm.setString(2, categoriaVO.getUsuarioCreacionCategoria());
            pstm.setInt(3, EstadoEnum.ACTIVO.getIndex());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" CategoriaDAOMS: Se presento un error al insertar una Categoria."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(CategoriaVO categoriaVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE Categoria SET "
                    + " Descripcion_Categoria = ?, "
                    + " Fecha_Modificacion = GETDATE(), "
                    + " Usuario_Modificacion = ? "
                    + " WHERE Id_Categoria = ? ";

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, categoriaVO.getDescripcionCategoria());
            pstm.setString(2, categoriaVO.getUsuarioModificacionCategoria());

            pstm.setInt(3, categoriaVO.getIdCategoria());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" CategoriaDAOMS: Se presento un error al actualizar una Categoria."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int eliminar(long idCategoria) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE Categoria SET Estado = ? "
                    + " WHERE Id_Categoria = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ELIMINADO.getIndex());
            pstm.setLong(2, idCategoria);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" CategoriaDAOMS: Se presento un error al eliminar una Categoria."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public ArrayList<CategoriaVO> listar() throws Exception {
         ArrayList<CategoriaVO> lista = new ArrayList<CategoriaVO>();
        CategoriaVO categoriaVO;
        try {
            this.Conectar();
            String consulta = "SELECT Id_Categoria, Descripcion_Categoria, Fecha_Creacion, Usuario_Creacion, Fecha_Modificacion, Usuario_Modificacion, Estado "
                    + " FROM Categoria WHERE Estado = ? ";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, EstadoEnum.ACTIVO.getIndex());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                categoriaVO = new CategoriaVO();
                categoriaVO.setIdCategoria(rs.getInt(t++));
                categoriaVO.setDescripcionCategoria(rs.getString(t++));
                categoriaVO.setFechaCreacionCategoria(rs.getTimestamp(t++));
                categoriaVO.setUsuarioCreacionCategoria(rs.getString(t++));
                categoriaVO.setFechaModificacionCategoria(rs.getTimestamp(t++));
                categoriaVO.setUsuarioModificacionCategoria(rs.getString(t++));
                categoriaVO.setEstado(rs.getInt(t++));

                lista.add(categoriaVO);
            }
        } catch (Exception e) {
            System.out.println(" CategoriaDAOMS: Se presento un error al consultar la tabla Categoria. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public CategoriaVO consultarPorId(long idCategoria) throws Exception {
        CategoriaVO categoriaVO = null;
        try {
            this.Conectar();
            String consulta = " SELECT Id_Categoria, Descripcion_Categoria, Fecha_Creacion, Usuario_Creacion, Fecha_Modificacion, Usuario_Modificacion, Estado "
                    + " FROM Categoria WHERE Id_Categoria = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idCategoria);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                categoriaVO = new CategoriaVO();
                categoriaVO.setIdCategoria(rs.getInt(t++));
                categoriaVO.setDescripcionCategoria(rs.getString(t++));
                categoriaVO.setFechaCreacionCategoria(rs.getTimestamp(t++));
                categoriaVO.setUsuarioCreacionCategoria(rs.getString(t++));
                categoriaVO.setFechaModificacionCategoria(rs.getTimestamp(t++));
                categoriaVO.setUsuarioModificacionCategoria(rs.getString(t++));
                categoriaVO.setEstado(rs.getInt(t++));
            }

        } catch (Exception e) {
            System.out.println("CategoiaDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return categoriaVO;
    }
    
}
