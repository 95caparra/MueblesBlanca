/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblabnca.pruebas;

import java.util.HashMap;
import java.util.Map;
import mueblesblanca.constante.EstadoEnum;
import mueblesblanca.constante.EstadoEnumLista;

/**
 *
 * @author camil
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    private static Map<Integer, String> estadosEnum;

    public static void main(String[] args) {
        // TODO code application logic here

        estadosEnum = new HashMap<Integer, String>();

        for (EstadoEnumLista enl : EstadoEnumLista.values()) {
            estadosEnum.put(enl.getIndex(), enl.getNombre());
        }
        
        estadosEnum.get(1);
        System.out.println(estadosEnum.keySet());
        
        System.out.println(estadosEnum.entrySet());

    }

}
