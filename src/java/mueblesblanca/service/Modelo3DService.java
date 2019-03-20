/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.Modelo3DDAO;
import mueblesblanca.dao.Modelo3DDAOMS;
import mueblesblanca.vo.Modelo3DVO;

/**
 *
 * @author Fabian Garcia
 */

public class Modelo3DService {

    private static Modelo3DDAO modelo3DDAO;

    public Modelo3DService() {
        modelo3DDAO = new Modelo3DDAOMS();
    }

    public int insertar(Modelo3DVO modelo3DVO) throws Exception {
        int resultado = -1;
        try {
            resultado = modelo3DDAO.insertar(modelo3DVO);
        } catch (Exception e) {
            System.out.println("Modelo3DService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(Modelo3DVO modelo3DVO) throws Exception {
        int resultado = -1;
        try {
            resultado = modelo3DDAO.actualizar(modelo3DVO);
        } catch (Exception e) {
            System.out.println("Modelo3DService: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<Modelo3DVO> listar() throws Exception {

        ArrayList<Modelo3DVO> lista = new ArrayList<Modelo3DVO>();
        try {
            lista = modelo3DDAO.listar();
        } catch (Exception e) {
            System.out.println("Modelo3DService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public Modelo3DVO consultarPorId(long id) throws Exception {
        Modelo3DVO tipoDocumentoVO = new Modelo3DVO();
        try {
            tipoDocumentoVO = modelo3DDAO.consultarPorId(id);
        } catch (Exception e) {
            System.out.println("Modelo3DService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return tipoDocumentoVO;
        }
    }

    public int eliminarPorId(long id) throws Exception {
        int resultado = -1;
        try {
            resultado = modelo3DDAO.eliminar(id);
        } catch (Exception e) {
            System.out.println("Modelo3DService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }
}
