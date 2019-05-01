/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mueblesblanca.vo.UsuarioVO;

/**
 *
 * @author Alexis Holguin
 */
public class UsuarioDAOMS extends ConexionSQL implements UsuarioDAO {

    @Override
    public int insertar(UsuarioVO usuario) throws Exception {
        int result = -1;
        try {
            this.Conectar();
            String query = "INSERT INTO `users` (`user_id`, `email`, `password`, `first_name`, `second_name`, `first_surname`, `second_surname`, `address`, `created_at`, `updated_at`,`personal_id`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,?)";
            PreparedStatement pstm = this.conection.prepareStatement(query);
            pstm.setString(1, usuario.getEmail());
            pstm.setString(2, usuario.getPassword());
            pstm.setString(3, usuario.getFirstName());
            pstm.setString(4, usuario.getSecondName());
            pstm.setString(5, usuario.getFirstSurname());
            pstm.setString(6, usuario.getSecondSurname());
            pstm.setString(7, usuario.getAddress());
            pstm.setString(8, usuario.getPersonalId());
            result = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" UsuarioDAOMS: Se presento un error al insertar un tipo producto."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return result;
    }

    @Override
    public int actualizar(UsuarioVO usuario) throws Exception {
        int result = -1;
        try {
            this.Conectar();
            String query = "UPDATE `users` SET `email` = ? , `password` = ? , `first_name` = ?, `second_name` = ?, `first_surname`  = ?, `second_surname` = ?, `address` = ? WHERE  `users`.`user_id` = ?";
            PreparedStatement pstm = this.conection.prepareStatement(query);
            pstm.setString(1, usuario.getEmail());
            pstm.setString(2, usuario.getPassword());
            pstm.setString(3, usuario.getFirstName());
            pstm.setString(4, usuario.getSecondName());
            pstm.setString(5, usuario.getFirstSurname());
            pstm.setString(6, usuario.getSecondSurname());
            pstm.setString(7, usuario.getAddress());
            pstm.setInt(8, usuario.getUserId());
            result = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" UsuarioDAOMS: Se presento un error al insertar un tipo producto."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return result;
    }

    @Override
    public UsuarioVO consultarPorEmail(String email) throws Exception {
        UsuarioVO user = null;
        try {
            this.Conectar();
            String query = "SELECT * FROM `users` WHERE `users`.`email` = ? ";
            PreparedStatement pstm = this.conection.prepareStatement(query);
            pstm.setString(1, email);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                user = new UsuarioVO();
                user.setUserId(rs.getInt(1));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("first_name"));
                user.setSecondName(rs.getString("second_name"));
                user.setFirstSurname(rs.getString("first_surname"));
                user.setSecondSurname(rs.getString("second_surname"));
                user.setAddress(rs.getString("address"));
            }
        } catch (Exception e) {
            System.out.println(" UsuarioDAOMS: Se presento un error al insertar un tipo producto."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return user;
    }
}
