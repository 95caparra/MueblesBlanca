/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblabnca.pruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import mueblesblanca.service.CiudadService;
import mueblesblanca.vo.CiudadVO;

/**
 *
 * @author cochoa
 */
public class PruebaCiudad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\t SELECCIONE LA OPCION QUE DESEA REALIZAR");
        System.out.println(" ----------------------------------------------------- ");
        System.out.println(" 1. INSERTAR CIUDAD ");
        System.out.println(" 2. LISTAR CIUDADES ");
        System.out.println(" 3. ACTUALIZAR CIUDAD ");
        System.out.println(" 4. BUSCAR CIUDAD POR ID ");
        System.out.println(" 5. ELIMINAR CIUDAD POR ID ");

        System.out.println(" POR FAVOR ESCRIBA EL NÚMERO DE LA OPCIÓN ");
        int opcion = Integer.parseInt(br.readLine());

        System.out.println(" ----------------------------------------------------- ");

        switch (opcion) {
            case 1:
                System.out.println(" HA SELECCIONADO LA OPCIÓN 1 INSERTAR CIUDAD ");
                insertarCiudad();
                break;

            case 2:
                System.out.println(" HA SELECCIONADO LA OPCIÓN 2 LISTAR CIUDADES ");
                listarCiudad();
                break;

            case 3:
                System.out.println(" HA SELECCIONADO LA OPCIÓN 3 ACTUALIZAR CIUDAD ");
                actualizarCiudad();
                break;

            case 4:
                System.out.println(" HA SELECCIONADO LA OPCIÓN 4 BUSCAR CIUDAD POR ID ");
                consultarCiudadPorId();
                break;

            case 5:
                System.out.println(" HA SELECCIONADO LA OPCIÓN 5 ELIMINAR CIUDAD POR ID ");
                eliminarCiudadPorId();
                break;
        }

    }

    public static void insertarCiudad() throws Exception, IOException {
        CiudadService ciudadService = new CiudadService();
        CiudadVO ciudadVO = new CiudadVO();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\t REGISTRAR CIUDAD ");
        System.out.println(" ----------------------------------------------------- ");
        System.out.println(" Digite la descipción de la ciudad: ");
        ciudadVO.setDescripcionCiudad(br.readLine());
        System.out.println(" Digite el usuario: ");
        ciudadVO.setUsuarioCreacionCiudad(br.readLine());
        System.out.println(" ----------------------------------------------------- ");
        if (ciudadService.insertar(ciudadVO) > 0) {
            System.out.println(" ciudad insertada con exito ");
        } else {
            System.out.println(" Ocurrio un error ");
        }
    }

    public static void actualizarCiudad() throws Exception, IOException {
        CiudadService ciudadService = new CiudadService();
        CiudadVO ciudadVO = new CiudadVO();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\t ACTUALIZAR CIUDAD ");
        System.out.println(" ----------------------------------------------------- ");
        System.out.println(" Digite el id de la ciudad a actualizar: ");
        ciudadVO.setIdCiudad(Integer.parseInt(br.readLine()));

        System.out.println(" Digite la descipción de la ciudad: ");
        ciudadVO.setDescripcionCiudad(br.readLine());
        System.out.println(" Digite el usuario que modifica: ");
        ciudadVO.setUsuarioModificacionCiudad(br.readLine());

        System.out.println(" ----------------------------------------------------- ");
        if (ciudadService.actualizar(ciudadVO) > 0) {
            System.out.println(" ciudad actualizada con exito ");
        } else {
            System.out.println(" Ocurrio un error ");
        }
    }

    public static void listarCiudad() throws Exception, IOException {
        CiudadService ciudadService = new CiudadService();

        System.out.println("\t LISTAR CIUDADES ACTIVAS ");
        System.out.println(" ----------------------------------------------------- ");

        List<CiudadVO> ciudades = ciudadService.listar();

        for (CiudadVO c : ciudades) {
            System.out.println("id ciudad -------------------->" + c.getIdCiudad());
            System.out.println("nombre y/o descipción ciudad ->" + c.getDescripcionCiudad());
            System.out.println("estado ciudad ---------------->" + c.getEstado());
            System.out.println(" ----------------------------------------------------- ");
        }
    }

    public static void consultarCiudadPorId() throws Exception, IOException {
        CiudadService ciudadService = new CiudadService();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\t CONSULTAR CIUDAD POR ID ");
        System.out.println(" ----------------------------------------------------- ");
        System.out.println(" Digite el id de la ciudad a buscar: ");
        long idCiudad = Integer.parseInt(br.readLine());

        CiudadVO c = ciudadService.consultarPorId(idCiudad);

        System.out.println("id ciudad -------------------->" + c.getIdCiudad());
        System.out.println("nombre y/o descipción ciudad ->" + c.getDescripcionCiudad());
        System.out.println("estado ciudad ---------------->" + c.getEstado());
        System.out.println(" ----------------------------------------------------- ");
    }
    
     public static void eliminarCiudadPorId() throws Exception, IOException {
        CiudadService ciudadService = new CiudadService();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\t ELIMINAR CIUDAD POR ID ");
        System.out.println(" ----------------------------------------------------- ");
        System.out.println(" Digite el id de la ciudad a eliminar: ");
        long idCiudad = Integer.parseInt(br.readLine());
        
        System.out.println(" ----------------------------------------------------- ");
        if (ciudadService.eliminarPorId(idCiudad) > 0) {
            System.out.println(" ciudad eliminada con exito ");
        } else {
            System.out.println(" Ocurrio un error ");
        }
    }

}
