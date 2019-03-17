/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;
import java.util.ArrayList;
import mueblesblanca.dao.EstadoOrdenDAO;
import mueblesblanca.dao.EstadoOrdenDAOMS;
import mueblesblanca.vo.EstadoOrdenVO;
/**
 *
 * @author Fabian Garcia   
 */
public class EstadoOrdenService {

    private static EstadoOrdenDAO estadoOrdenDAO;

    public EstadoOrdenService() {
        estadoOrdenDAO = new EstadoOrdenDAOMS();
    }

    public int insertar(EstadoOrdenVO estadoOrdenVO) throws Exception {
        int resultado = -1;
        try {
            resultado = estadoOrdenDAO.insertar(estadoOrdenVO);
        } catch (Exception e) {
            System.out.println("EstadoOrdenService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(EstadoOrdenVO estadoOrdenVO) throws Exception {
        int resultado = -1;
        try {
            resultado = estadoOrdenDAO.actualizar(estadoOrdenVO);
        } catch (Exception e) {
            System.out.println("EstadoOrdenService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<EstadoOrdenVO> listar() throws Exception {

        ArrayList<EstadoOrdenVO> lista = new ArrayList<EstadoOrdenVO>();
        try {
            lista = estadoOrdenDAO.listar();
        } catch (Exception e) {
            System.out.println("EstadoOrdenService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public EstadoOrdenVO consultarPorId(long id) throws Exception {
        EstadoOrdenVO estadoOrdenVO = new EstadoOrdenVO();
        try {
            estadoOrdenVO = estadoOrdenDAO.consultarPorId(id);
        } catch (Exception e) {
            System.out.println("EstadoOrdenService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return estadoOrdenVO;
        }
    }
    
    public int eliminarPorId(long id) throws Exception {
        int resultado = -1;
        try {
            resultado = estadoOrdenDAO.eliminar(id);
        } catch (Exception e) {
            System.out.println("EstadoOrdenService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}
