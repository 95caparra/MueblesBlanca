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
 * @author Sergio AlfonsoG
 */

public class Modelo3DDAOMS extends ConexionSQL implements Modelo3DDAO {

    @Override
    public int insertar(Modelo3DVO modelo3DVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " INSERT INTO Modelo3D ( NombreModelo, ruta)"
                    + " VALUES(?,?) ";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, modelo3DVO.getNombreModelo());
            pstm.setString(2, modelo3DVO.getRutaModelo());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" Modelo3DDAOMS: Se presento un error al insertar un Modelo."
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
            String consulta = " UPDATE Modelo3D SET "
                    + " NombreModelo = ?, "
                    + " ruta = ? "
                    + "WHERE Id_modelo = ? ";

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setString(1, modelo3DVO.getNombreModelo());
            pstm.setString(2, modelo3DVO.getRutaModelo());
               
            pstm.setInt(3, modelo3DVO.getIdModelo3D());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" Modelo3DDAOMS: Se presento un error al actualizar un Modelo."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int eliminar(long idModelo) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " DELETE FROM Modelo3D WHERE Id_modelo = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(2, idModelo);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" Modelo3DDAOMS: Se presento un error al eliminar un Modelo."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;

    }

    @Override
    public ArrayList<Modelo3DVO> listar() throws Exception {
        ArrayList<Modelo3DVO> lista = new ArrayList<Modelo3DVO>();
        Modelo3DVO modeloVO;
        try {
            this.Conectar();
            String consulta = "SELECT Id_modelo, NombreModelo, ruta FROM Modelo3D";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                modeloVO = new Modelo3DVO();
                modeloVO.setIdModelo3D(rs.getInt(t++));
                modeloVO.setNombreModelo(rs.getString(t++));
                modeloVO.setRutaModelo(rs.getString(t++));

                lista.add(modeloVO);
            }
        } catch (Exception e) {
            System.out.println(" Modelo3DDAOMS: Se presento un error al consultar la tabla Modelo3D. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public Modelo3DVO consultarPorId(long idModelo) throws Exception {
        Modelo3DVO modeloVO = null;
        try {
            this.Conectar();
            String consulta = "SELECT Id_modelo, NombreModelo, ruta FROM Modelo3D WHERE Id_modelo = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idModelo);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                modeloVO = new Modelo3DVO();
                modeloVO.setIdModelo3D(rs.getInt(t++));
                modeloVO.setNombreModelo(rs.getString(t++));
                modeloVO.setRutaModelo(rs.getString(t++));
                
            }

        } catch (Exception e) {
            System.out.println("Modelo3DDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return modeloVO;
    }
}
