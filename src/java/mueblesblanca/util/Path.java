/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author cochoa
 */
public class Path {

    public static String getPath() {
        try {
            ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance()
                    .getExternalContext().getContext();
            return ctx.getRealPath("/");

        } catch (Exception e) {
            System.out.print("getPath() " + e.getLocalizedMessage());
        }
        return null;
    }

    public static HashMap<String, String> getMapPathArchivos() {
        try {
            HashMap<String, String> map = new HashMap<String, String>();

            String path = getPath() + "archivos";
            map.put("path", path);
            map.put("url", "archivos");
            return map;
        } catch (Exception e) {
            System.out.print(" getMapPathFotosClinica() " + e.getLocalizedMessage());
        }
        return null;
    }

    public static String getPathArchivos() {
        try {

            String path = getPath() + "resources";
            return path;
        } catch (Exception e) {
            System.out.print("getPathFotosClinica() " + e.getLocalizedMessage());
        }
        return null;
    }

    public static Boolean copyFile(String fileName, InputStream in) {
        try {
            String ruta = getPathArchivos() + "/" + fileName;
            File f = new File(ruta);
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            out.close();
            in.close();
            out.flush();

            return true;
        } catch (IOException e) {
            System.out.print("copyFile() " + e.getLocalizedMessage());
        }
        return false;
    }
    
     public static Boolean copyFileImagenes(String fileName, InputStream in) {
        try {
            String ruta = getPathArchivos() + "/imagenesProductos/" + fileName;
            File f = new File(ruta);
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            out.close();
            in.close();
            out.flush();

            return true;
        } catch (IOException e) {
            System.out.print("copyFile() " + e.getLocalizedMessage());
        }
        return false;
    }

    public static void subirFichero(UploadedFile uploadFile, String nombreFichero) throws IOException {
        String ruta = getPathArchivos() + "/" + nombreFichero;
        File file = new File(ruta);
        FileOutputStream fos = new FileOutputStream(file);
        IOUtils.copy(uploadFile.getInputstream(), fos);

    }

}
