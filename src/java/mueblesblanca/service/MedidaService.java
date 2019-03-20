/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.MedidaDAO;
import mueblesblanca.dao.MedidaDAOMS;
import mueblesblanca.vo.MedidaVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class MedidaService {

    private static MedidaDAO medidaDAO;

    public MedidaService() {
        medidaDAO = new MedidaDAOMS();
    }

    public int insertar(MedidaVO medidaVO) throws Exception {
        int resultado = -1;
        try {
            resultado = medidaDAO.insertar(medidaVO);
        } catch (Exception e) {
            System.out.println("MedidaService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(MedidaVO mediaVO) throws Exception {
        int resultado = -1;
        try {
            resultado = medidaDAO.actualizar(mediaVO);
        } catch (Exception e) {
            System.out.println("MedidaService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<MedidaVO> listar() throws Exception {

        ArrayList<MedidaVO> lista = new ArrayList<MedidaVO>();
        try {
            lista = medidaDAO.listar();
        } catch (Exception e) {
            System.out.println("MedidaService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public MedidaVO consultarPorId(long idMedida) throws Exception {
        MedidaVO medidaVO = new MedidaVO();
        try {
            medidaVO = medidaDAO.consultarPorId(idMedida);
        } catch (Exception e) {
            System.out.println("MedidaService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return medidaVO;
        }
    }
    
    public int eliminarPorId(long idMedida) throws Exception {
        int resultado = -1;
        try {
            resultado = medidaDAO.eliminar(idMedida);
        } catch (Exception e) {
            System.out.println("MedidaService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}


