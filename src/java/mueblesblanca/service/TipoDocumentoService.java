/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.TipoDocumentoDAOMS;
import mueblesblanca.dao.TipoDocumentoDAO;
import mueblesblanca.vo.TipoDocumentoVO;

/**
 *
 * @author cochoa
 */
public class TipoDocumentoService {

    private static TipoDocumentoDAO tipoDocumentoDAO;

    public TipoDocumentoService() {
        tipoDocumentoDAO = new TipoDocumentoDAOMS();
    }

    public int insertar(TipoDocumentoVO tipoDocumentoVO) throws Exception {
        int resultado = -1;
        try {
            resultado = tipoDocumentoDAO.insertar(tipoDocumentoVO);
        } catch (Exception e) {
            System.out.println("TipoDocumentoService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(TipoDocumentoVO tipoDocumentoVO) throws Exception {
        int resultado = -1;
        try {
            resultado = tipoDocumentoDAO.actualizar(tipoDocumentoVO);
        } catch (Exception e) {
            System.out.println("TipoDocumentoService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<TipoDocumentoVO> listar() throws Exception {

        ArrayList<TipoDocumentoVO> lista = new ArrayList<TipoDocumentoVO>();
        try {
            lista = tipoDocumentoDAO.listar();
        } catch (Exception e) {
            System.out.println("TipoDocumentoService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public TipoDocumentoVO consultarPorId(long idCiudad) throws Exception {
        TipoDocumentoVO tipoDocumentoVO = new TipoDocumentoVO();
        try {
            tipoDocumentoVO = tipoDocumentoDAO.consultarPorId(idCiudad);
        } catch (Exception e) {
            System.out.println("TipoDocumentoService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return tipoDocumentoVO;
        }
    }
    
    public int eliminarPorId(long id) throws Exception {
        int resultado = -1;
        try {
            resultado = tipoDocumentoDAO.eliminar(id);
        } catch (Exception e) {
            System.out.println("TipoDocumentoService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}
