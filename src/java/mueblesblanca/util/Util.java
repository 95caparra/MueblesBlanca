package mueblesblanca.util;

import java.security.MessageDigest;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Jhon Lagos -- jalagos00@misena.edu.co
 */
public class Util {

    public static String cifrar(String clave) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(clave.getBytes());
        StringBuffer h = new StringBuffer(b.length);
        //algoritmo y arreglo md5
        for (int i = 0; i < b.length; i++) {
            int u = b[i] & 255;
            if (u < 16) {
                h.append("0" + Integer.toHexString(u));
            } else {
                h.append(Integer.toHexString(u));
            }
        }
        //clave encriptada
        return h.toString();
    }
    
     /*
     * Convertir date a calendar
     */
	
    public static Calendar toCalendar(Date date){ 
    	  Calendar cal = Calendar.getInstance();
    	  cal.setTime(date);
    	  return cal;
    }
    
    public static XMLGregorianCalendar toXMLGregorianCalendar(Date date) throws DatatypeConfigurationException{ 
    	  GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
          cal.setGregorianChange(new Date(date.getTime()));
          XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
    	  return xgcal;
    }
    
     public static long toDate(XMLGregorianCalendar xmlDate) throws DatatypeConfigurationException{ 
    	 return xmlDate.toGregorianCalendar().getTime().getTime();
    }

    public static Date convertirFecha(String fecha) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilDate = formatter.parse(fecha);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }
    
    public static Date convertirFecha2(String fecha) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = formatter.parse(fecha);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }

    public static Time convertirHora(String hora) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Time sqlTime = new java.sql.Time(formatter.parse(hora).getTime());
        return sqlTime;
    }

    public static String getCadenaAlfanumAleatoria() {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < 8) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }
    
//    Funcion para darle formato a una fecha cualquiera 
//    public static Date formatoFecha(String formato, Date fecha) throws Exception {
//        return new java.sql.Date(new SimpleDateFormat(formato).parse(fecha.toString()).getTime());
//    }

    //Quitar acentos de Strings
    public String remover(String input) {
        // Cadena de caracteres original a sustituir.
        String original = "Ã";
        //String original2[] = {"á", "à", "ä", "é", "è", "ë", "í", "ì", "ï", "ó", "ò", "ö", "ú", "ù", "u", "ñ", "Á", "À", "Ä", "É", "È", "Ë", "Í", "Ì", "Ï", "Ó", "Ò", "Ö", "Ú", "Ù", "Ü", "Ñ", "ç", "Ç", "Ã±"};
        /////////////////////////ñ , á  , é  , í , ó  , ú              
        String especiales[] = {"Ã±", "Ã¡", "Ã©", "Ã"};
        String especialesM[] = {"Ã‘", "Ã", "Ã‰", "Ã", "Ã“", "Ãš"};
        // Cadena de caracteres ASCII que reemplazarán los originales.
        String ascii = "í";
        //String ascii2[] = {"a", "a", "a", "e", "e", "e", "i", "i", "i", "o", "o", "o", "u", "u", "u", "n", "A", "A", "A", "E", "E", "E", "I", "I", "I", "O", "O", "O", "U", "U", "U", "N", "c", "C", "ñ"};
        //String ascii[] = {"ñ", "á", "é", "í"};
        String asciiM[] = {"Ñ", "Á", "É", "Í", "Ó", "Ú"};
        String output = input;
        boolean bandera = false;
        for (int i = 0; i < 1; i++) {
            // Reemplazamos los caracteres especiales.
            if (bandera != true) {
                if (input.contains("Ãº")) {
                    String cadena = "Ãº";
                    output = output.replaceAll(cadena, "ú");
                    bandera = false;
                }
            }
            if (bandera != true) {
                if (input.contains("Ã³")) {
                    String cadena = "Ã³";
                    output = output.replaceAll(cadena, "ó");
                    bandera = false;
                }
            }
            if (bandera != true) {
                if (input.contains("Ã±")) {
                    String cadena = "Ã±";
                    output = output.replaceAll(cadena, "ñ");
                    bandera = false;
                }
            }
            if (bandera != true) {
                if (input.contains("Ã¡")) {
                    String cadena = "Ã¡";
                    output = output.replaceAll(cadena, "á");
                    bandera = false;
                }
            }
            if (bandera != true) {
                if (input.contains("Ã©")) {
                    String cadena = "Ã©";
                    output = output.replaceAll(cadena, "é");
                    bandera = false;
                }
            }

            if (bandera != true) {
                if (input.contains("Ã")) {
                    String cadena = "Ã";
                    //output = output.replaceAll(cadena, "í");
                    output = output.replace(original.charAt(i), ascii.charAt(i));
                    bandera = false;
                }
            }
        }

        return output;
    }//remove1

}
