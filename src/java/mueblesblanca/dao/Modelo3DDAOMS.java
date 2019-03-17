/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mueblesblanca.vo.Modelo3DVO;

/**
 *
 * @author cochoa
 */
public class Modelo3DDAOMS extends ConexionSQL implements Modelo3DDAO {

    @Override
    public int insertar(Modelo3DVO modelo3DVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = "INSERT INTO [dbo].[Modelo3D]\n"
                    + "           ([NombreModelo]\n"
                    + "           ,[ruta])\n"
                    + "     VALUES\n"
                    + "           (?"
                    + "           ,?)";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, modelo3DVO.getNombreModelo());
            pstm.setString(2, modelo3DVO.getRutaModelo());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" Modelo3DVO: Se presento un error al insertar un modelo 3D."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(Modelo3DVO modelo3DVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = "UPDATE [dbo].[Modelo3D]\n"
                    + "   SET [NombreModelo] = ?"
                    + "      ,[ruta] = ?"
                    + " WHERE [Id_modelo] = ?";

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, modelo3DVO.getNombreModelo());
            pstm.setString(2, modelo3DVO.getRutaModelo());
            pstm.setInt(3, modelo3DVO.getIdModelo3D());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" Modelo3DVO: Se presento un error al actualizar un modelo 3D."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int eliminar(long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Modelo3DVO> listar() throws Exception {
        ArrayList<Modelo3DVO> lista = new ArrayList<Modelo3DVO>();
        Modelo3DVO modelo3DVO;
        try {
            this.Conectar();
            String consulta = "SELECT * "
                    + " FROM [dbo].[Modelo3D]";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                modelo3DVO = new Modelo3DVO();
                modelo3DVO.setIdModelo3D(rs.getInt(t++));
                modelo3DVO.setNombreModelo(rs.getString(t++));
                modelo3DVO.setRutaModelo(rs.getString(t++));

                lista.add(modelo3DVO);
            }
        } catch (Exception e) {
            System.out.println(" Modelo3DVO: Se presento un error al consultar la tabla modelo 3D. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public Modelo3DVO consultarPorId(long id) throws Exception {
        Modelo3DVO modelo3DVO = null;
        try {
            this.Conectar();
            String consulta = " SELECT *"
                    + " FROM [dbo].[Modelo3D] WHERE [Id_modelo] = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, id);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                modelo3DVO = new Modelo3DVO();
                modelo3DVO.setIdModelo3D(rs.getInt(t++));
                modelo3DVO.setNombreModelo(rs.getString(t++));
                modelo3DVO.setRutaModelo(rs.getString(t++));
            }

        } catch (Exception e) {
            System.out.println("Modelo3DVO : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return modelo3DVO;
    }
}
