/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.PedidoDAO;
import mueblesblanca.dao.PedidoDAOMS;
import mueblesblanca.vo.PedidoVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class PedidoService {

    private static PedidoDAO pedidoDAO;

    public PedidoService() {
        pedidoDAO = new PedidoDAOMS();
    }

    public int insertar(PedidoVO pedidoVO) throws Exception {
        int resultado = -1;
        try {
            resultado = pedidoDAO.insertar(pedidoVO);
        } catch (Exception e) {
            System.out.println("PedidoService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(PedidoVO pedidoVO) throws Exception {
        int resultado = -1;
        try {
            resultado = pedidoDAO.actualizar(pedidoVO);
        } catch (Exception e) {
            System.out.println("PedidoService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<PedidoVO> listar() throws Exception {

        ArrayList<PedidoVO> lista = new ArrayList<PedidoVO>();
        try {
            lista = pedidoDAO.listar();
        } catch (Exception e) {
            System.out.println("PedidoService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public PedidoVO consultarPorId(long idPedido) throws Exception {
        PedidoVO pedidoVO = new PedidoVO();
        try {
            pedidoVO = pedidoDAO.consultarPorId(idPedido);
        } catch (Exception e) {
            System.out.println("PedidoService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return pedidoVO;
        }
    }
    
    public int eliminarPorId(long idPedido) throws Exception {
        int resultado = -1;
        try {
            resultado = pedidoDAO.eliminar(idPedido);
        } catch (Exception e) {
            System.out.println("PedidoService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}


