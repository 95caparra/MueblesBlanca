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
import mueblesblanca.vo.InsumoProveedorVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class InsumoProveedorDAOMS extends ConexionSQL implements InsumoProveedorDAO {

    @Override
    public int insertar(InsumoProveedorVO insumoProveedorVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " INSERT INTO Insumo_Proveedor ( Id_Producto, Id_Proveedor )"
                    + " VALUES(?,?) ";

            System.out.println("QUERY insertar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, insumoProveedorVO.getProducto().getIdProducto());
            pstm.setInt(2, insumoProveedorVO.getProveedor().getIdProveedor());

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" InsumoProveedorDAOMS: Se presento un error al insertar un Insumo o Proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int actualizar(InsumoProveedorVO insumoProveedorVO) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " UPDATE Insumo_Proveedor SET "
                    + " Id_Producto = ?, "
                    + " Id_Proveedor = ? "
                    + " WHERE Id_Producto = ?  AND  Id_Proveedor = ?";

            System.out.println("QUERY actualizar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setInt(1, insumoProveedorVO.getProducto().getIdProducto());
            pstm.setInt(2, insumoProveedorVO.getProveedor().getIdProveedor());
               
            pstm.setInt(3, insumoProveedorVO.getProducto().getIdProducto());
            pstm.setInt(4, insumoProveedorVO.getProveedor().getIdProveedor());
            
            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" InsumoProveedorDAOMS: Se presento un error al actualizar un Insumo o Proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public int eliminar(long idInsumo, long idProveedor) throws Exception {
        int resultado = -1;
        try {
            this.Conectar();
            String consulta = " DELETE FORM Insumo_Proveedor WHERE Id_Producto = ? AND Id_Proveedor = ? ";

            System.out.println("QUERY eliminar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            pstm.setLong(1, idInsumo);
            pstm.setLong(2, idProveedor);

            resultado = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(" InsumoProveedorDAOMS: Se presento un error al eliminar un Insumo y Proveedor."
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
        }
        return resultado;
    }

    @Override
    public ArrayList<InsumoProveedorVO> listar() throws Exception {
        ArrayList<InsumoProveedorVO> lista = new ArrayList<InsumoProveedorVO>();
        InsumoProveedorVO insumoProveedorVO;
        try {
            this.Conectar();
            String consulta = "SELECT Id_Producto, Id_Proveedor FROM Categoria";

            System.out.println("QUERY listar " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int t = 1;
                insumoProveedorVO = new InsumoProveedorVO();
                insumoProveedorVO.getProducto().setIdProducto(t++);
                insumoProveedorVO.getProveedor().setIdProveedor(t++);

                lista.add(insumoProveedorVO);
            }
        } catch (Exception e) {
            System.out.println(" InsumoProveedorDAOMS: Se presento un error al consultar la tabla Insumo_Proveedor. "
                    + e.getMessage());
            throw e;
        } finally {
            this.Desconectar();
            return lista;
        }
    }

    @Override
    public InsumoProveedorVO consultarPorId(long idProducto) throws Exception {
        InsumoProveedorVO insumoProveedorVO = null;
        try {
            this.Conectar();
            String consulta = " SELECT Id_Producto, Id_Proveedor"
                    + " FROM Insumo_Proveedor WHERE Id_Producto = ? ";

            System.out.println("QUERY consultarPorId " + consulta);
            PreparedStatement pstm = this.conection.prepareStatement(consulta);
            pstm.setLong(1, idProducto);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int t = 1;
                insumoProveedorVO = new InsumoProveedorVO();
                insumoProveedorVO.getProducto().setIdProducto(t++);
                insumoProveedorVO.getProveedor().setIdProveedor(t++);
                
            }

        } catch (Exception e) {
            System.out.println("InsumoProveedorDAOMS : se presento un error al consultar por id: " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return insumoProveedorVO;
    }
    
}
