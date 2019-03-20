/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.service;

import java.util.ArrayList;
import mueblesblanca.dao.PersonaNaturalDAO;
import mueblesblanca.dao.PersonaNaturalDAOMS;
import mueblesblanca.vo.PersonaNaturalVO;

/**
 *
 * @author Sergio AlfonsoG
 */

public class PersonaNaturalService {

    private static PersonaNaturalDAO personaNaturalDAO;

    public PersonaNaturalService() {
        personaNaturalDAO = new PersonaNaturalDAOMS();
    }

    public int insertar(PersonaNaturalVO personNaturalVO) throws Exception {
        int resultado = -1;
        try {
            resultado = personaNaturalDAO.insertar(personNaturalVO);
        } catch (Exception e) {
            System.out.println("PersonaNaturalService: Se presento un error al "
                    + "insertar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public int actualizar(PersonaNaturalVO personaNaturalVO) throws Exception {
        int resultado = -1;
        try {
            resultado = personaNaturalDAO.actualizar(personaNaturalVO);
        } catch (Exception e) {
            System.out.println("PersonaNaturalervice: Se presento un error al "
                    + "actualizar: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    public ArrayList<PersonaNaturalVO> listar() throws Exception {

        ArrayList<PersonaNaturalVO> lista = new ArrayList<PersonaNaturalVO>();
        try {
            lista = personaNaturalDAO.listar();
        } catch (Exception e) {
            System.out.println("PersonaNaturalService: Se presento un error al "
                    + "listar la tabla: " + e.getMessage());
        } finally {
            return lista;
        }
    }

    public PersonaNaturalVO consultarPorId(long idPersonaNatural) throws Exception {
        PersonaNaturalVO personaNaturalVO = new PersonaNaturalVO();
        try {
            personaNaturalVO = personaNaturalDAO.consultarPorId(idPersonaNatural);
        } catch (Exception e) {
            System.out.println("PesonaNaturalService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return personaNaturalVO;
        }
    }
    
    public int eliminarPorId(long idPersonaNatural) throws Exception {
        int resultado = -1;
        try {
            resultado = personaNaturalDAO.eliminar(idPersonaNatural);
        } catch (Exception e) {
            System.out.println("PersonaNaturalService: Se presento un error al "
                    + "consultar por id en la tabla: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

}


