/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.util;

/*Se importan las librerias de javax.Mail para poder enviar correos
 esta libreria la descargue y la agregue 
 */
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

public class Mail {

    public void envioCorreoCliente(String correo, String asunto, String mensaje, String archivo) {

        final String username = "quotevent@gmail.com";
        final String password = "quotevent2014";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

             // Se compone la parte del texto
            BodyPart texto = new MimeBodyPart();
            texto.setText("Texto del mensaje");

            // Se compone el adjunto con la imagen
            BodyPart adjunto = new MimeBodyPart();
            
            adjunto.setDataHandler(new DataHandler(new FileDataSource(archivo)));
            adjunto.setFileName(archivo);

            MimeMultipart multiParte = new MimeMultipart();
            /*Se agregan el texto y el archivo adjunto a multiparte*/
            multiParte.addBodyPart(texto);

            multiParte.addBodyPart(adjunto);

            //Se abre la sesion y se agregan los elementos del correo
            MimeMessage message = new MimeMessage(session);
            //se agrega la multiparte donde esta el texto y el archivo al mensaje
            message.setContent(multiParte);

            //este sera el correo destinatario
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));

            //este es el asunto
            message.setSubject(asunto);

            Transport transport = session.getTransport("smtp");
            //correo que realiza el envio con su contraseÃ±a
            transport.connect(username, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
            e.getStackTrace();
            e.getMessage();
        }
    }

    public void envioCorreo(String correo, String asunto, String mensaje, String archivo[], String ruta) {

        /* Se agregan las propiedades creando un objeto de la clase Properties*/
        Properties propiedades = new Properties();
        propiedades.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedades.setProperty("mail.smtp.starttls.enable", "true");
        propiedades.setProperty("mail.smtp.port", "587");
        propiedades.setProperty("mail.smtp.auth", "true");
        //La linea de codifo de bajo habilita la configuracion para pc de escritorio
        //Es necesaria sin esta solo se realiza el envio de correos a travez de portatiles
        propiedades.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getDefaultInstance(propiedades);

        try {
            /* se obtienen el asunto y el texto del mensaje*/
 /*se crea un BodyPart para el texto*/
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);
            /*se crea un BodyPart para el archivo adjunto*/
            BodyPart adjunto = new MimeBodyPart();
            BodyPart adjunto1 = new MimeBodyPart();
            BodyPart adjunto2 = new MimeBodyPart();
            BodyPart adjunto3 = new MimeBodyPart();
            BodyPart adjunto4 = new MimeBodyPart();
            BodyPart adjunto5 = new MimeBodyPart();
            BodyPart adjunto6 = new MimeBodyPart();
            BodyPart adjunto7 = new MimeBodyPart();
            BodyPart adjunto8 = new MimeBodyPart();
            BodyPart adjunto9 = new MimeBodyPart();
            BodyPart adjunto10 = new MimeBodyPart();

            int tamaño = archivo.length - 1;
            int cont = 0;
            for (int i = 0; i <= tamaño; i++) {
                if (cont <= tamaño) {
                    if (cont == 0) {
                        adjunto.setDataHandler(new DataHandler(new FileDataSource(ruta + "/" + archivo[0])));
                        adjunto.setFileName(archivo[0]);
                    }
                    if (cont == 1) {
                        adjunto1.setDataHandler(new DataHandler(new FileDataSource(ruta + "/" + archivo[1])));
                        adjunto1.setFileName(archivo[1]);
                    }
                    if (cont == 2) {
                        adjunto2.setDataHandler(new DataHandler(new FileDataSource(ruta + "/" + archivo[2])));
                        adjunto2.setFileName(archivo[2]);
                    }
                    if (cont == 3) {
                        adjunto3.setDataHandler(new DataHandler(new FileDataSource(ruta + "/" + archivo[3])));
                        adjunto3.setFileName(archivo[3]);
                    }
                    if (cont == 4) {
                        adjunto4.setDataHandler(new DataHandler(new FileDataSource(ruta + "/" + archivo[4])));
                        adjunto4.setFileName(archivo[4]);
                    }
                    if (cont == 5) {
                        adjunto5.setDataHandler(new DataHandler(new FileDataSource(ruta + "/" + archivo[5])));
                        adjunto5.setFileName(archivo[5]);
                    }
                    if (cont == 6) {
                        adjunto6.setDataHandler(new DataHandler(new FileDataSource(ruta + "/" + archivo[6])));
                        adjunto6.setFileName(archivo[6]);
                    }
                    if (cont == 7) {
                        adjunto7.setDataHandler(new DataHandler(new FileDataSource(ruta + "/" + archivo[7])));
                        adjunto7.setFileName(archivo[7]);
                    }
                    if (cont == 8) {
                        adjunto8.setDataHandler(new DataHandler(new FileDataSource(ruta + "/" + archivo[8])));
                        adjunto8.setFileName(archivo[8]);
                    }
                    if (cont == 9) {
                        adjunto9.setDataHandler(new DataHandler(new FileDataSource(ruta + "/" + archivo[9])));
                        adjunto9.setFileName(archivo[9]);
                    }
                    if (cont == 10) {
                        adjunto10.setDataHandler(new DataHandler(new FileDataSource(ruta + "/" + archivo[10])));
                        adjunto10.setFileName(archivo[10]);
                    }
                    cont++;
                }
            }

            MimeMultipart multiParte = new MimeMultipart();
            /*Se agregan el texto y el archivo adjunto a multiparte*/
            multiParte.addBodyPart(texto);

            int tamaño2 = archivo.length - 1;
            int cont2 = 0;
            for (int i = 0; i <= tamaño2; i++) {
                if (cont2 <= tamaño2) {
                    if (cont2 == 0) {
                        multiParte.addBodyPart(adjunto);
                    }
                    if (cont2 == 1) {
                        multiParte.addBodyPart(adjunto1);
                    }
                    if (cont2 == 2) {
                        multiParte.addBodyPart(adjunto2);
                    }
                    if (cont2 == 3) {
                        multiParte.addBodyPart(adjunto3);
                    }
                    if (cont2 == 4) {
                        multiParte.addBodyPart(adjunto4);
                    }
                    if (cont2 == 5) {
                        multiParte.addBodyPart(adjunto5);
                    }
                    if (cont2 == 6) {
                        multiParte.addBodyPart(adjunto6);
                    }
                    if (cont2 == 7) {
                        multiParte.addBodyPart(adjunto7);
                    }
                    if (cont2 == 8) {
                        multiParte.addBodyPart(adjunto8);
                    }
                    if (cont2 == 9) {
                        multiParte.addBodyPart(adjunto9);
                    }
                    if (cont2 == 10) {
                        multiParte.addBodyPart(adjunto10);
                    }
                    cont2++;
                }
            }

            //Se abre la sesion y se agregan los elementos del correo
            MimeMessage message = new MimeMessage(session);
            //se agrega la multiparte donde esta el texto y el archivo al mensaje
            message.setContent(multiParte);

            //este sera el correo destinatario
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));

            //este es el asunto
            message.setSubject(asunto);

            Transport transport = session.getTransport("smtp");
            //correo que realiza el envio con su contraseÃ±a
            transport.connect("quotevent@gmail.com", "quotevent2014");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static boolean envioCorreo(String correo, String mensaje, String asunto) {
        /* Se agregan las propiedades creando un objeto de la clase Properties*/
        Properties propiedades = new Properties();
        propiedades.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedades.setProperty("mail.smtp.starttls.enable", "true");
        propiedades.setProperty("mail.smtp.port", "587");
        propiedades.setProperty("mail.smtp.auth", "true");
        propiedades.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getDefaultInstance(propiedades);

        try {
            /* se obtienen el asunto y el texto del mensaje*/
 /*se crea un BodyPart para el texto*/
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);
            /*Se agregan el texto y el archivo adjunto a multiparte*/
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);

            //Se abre la sesion y se agregan los elementos del correo
            MimeMessage message = new MimeMessage(session);
            //este sera el correo destinatario
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));
            //este es el asunto
            message.setSubject(asunto);
            //se agrega la multiparte donde esta el text, al mensaje
            message.setContent(multiParte);

            Transport transport = session.getTransport("smtp");

            //correo que realiza el envio con su contraseÃ±a
            transport.connect("quotevent@gmail.com", "quotevent2014");
            transport.sendMessage(message, message.getAllRecipients());
            return true;
        } catch (MessagingException me) {
            System.out.println("Mail: MessagingException:  " + me.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Mail: Exception:  " + e.getMessage());
            return false;
        }
    }

    public static boolean solicitarProducto(String producto, String correo, String cantidad, String gramaje, String observaciones, String fecha) {
        /* Se agregan las propiedades creando un objeto de la clase Properties*/
        Properties propiedades = new Properties();
        propiedades.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedades.setProperty("mail.smtp.starttls.enable", "true");
        propiedades.setProperty("mail.smtp.port", "587");
        propiedades.setProperty("mail.smtp.auth", "true");
        propiedades.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getDefaultInstance(propiedades);

        try {
            /* se obtienen el asunto y el texto del mensaje*/

 /*se crea un BodyPart para el texto*/
            BodyPart texto = new MimeBodyPart();
            texto.setText("Buen Día:"
                    + "Nuestra empresa BLUMMER solicita una cantidad de " + cantidad + " " + gramaje + "s del producto " + producto
                    + " teniendo en cuenta la fecha " + fecha + " para su entrega."
                    + "\n\n"
                    + "Agradecemos la atención y solicitamos una respuesta a este correo. \n \n"
                    + "Observaciones:   " + observaciones
                    + "\n" + "Cordialmente BLUMMER by Quotevent");
//         /*se crea un BodyPart para el archivo adjunto*/
//                BodyPart adjunto = new MimeBodyPart();
//                adjunto.setText(producto);
//                adjunto.setText(cantidad);          

            /*Se agregan el texto y el archivo adjunto a multiparte*/
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
//                multiParte.addBodyPart(adjunto);            

            /* Se abre la sesion y se agregan los elementos del correo*/
            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("ochoacamilo17@gmail.com"));
            /* este sera el correo destinatario*/
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));

            /*   este es el asunto */
            message.setSubject("solicitud de " + producto + " para la empresa BLUMMER");
            /*  se agrega la multiparte donde esta el texto y el archivo al mensaje*/
            message.setContent(multiParte, "text/html");

            Transport transport = session.getTransport("smtp");
            /*  correo que realiza el envio con su contraseÃÆÃÂ±a */
            transport.connect("quotevent@gmail.com", "quotevent2014");
            transport.sendMessage(message, message.getAllRecipients());
            return true;
        } catch (MessagingException me) {
            System.out.println("Mail: MessagingException:  " + me.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Mail: Exception:  " + e.getMessage());
            return false;
        }
    }

    public static boolean envioContasena(String correo, String usuario, String contrasenia) {
        /* Se agregan las propiedades creando un objeto de la clase Properties*/
        Properties propiedades = new Properties();
        propiedades.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedades.setProperty("mail.smtp.starttls.enable", "true");
        propiedades.setProperty("mail.smtp.port", "587");
        propiedades.setProperty("mail.smtp.auth", "true");
        propiedades.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getDefaultInstance(propiedades);

        try {
            /* se obtienen el asunto y el texto del mensaje*/

 /*se crea un BodyPart para el texto*/
            BodyPart texto = new MimeBodyPart();
            texto.setText("su usuario es:  " + usuario + "  y su contraseña es:  " + contrasenia
                    + "\n" + "Cordialmente BLUMMER by Quotevent");
//         /*se crea un BodyPart para el archivo adjunto*/
//                BodyPart adjunto = new MimeBodyPart();
//                adjunto.setText(producto);
//                adjunto.setText(cantidad);          

            /*Se agregan el texto y el archivo adjunto a multiparte*/
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
//                multiParte.addBodyPart(adjunto);            

            /* Se abre la sesion y se agregan los elementos del correo*/
            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("ochoacamilo17@gmail.com"));
            /* este sera el correo destinatario*/
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));

            /*   este es el asunto */
            message.setSubject("nueva contraseña");
            /*  se agrega la multiparte donde esta el texto y el archivo al mensaje*/
            message.setContent(multiParte);

            Transport transport = session.getTransport("smtp");
            /*  correo que realiza el envio con su contraseÃÂ±a */
            transport.connect("quotevent@gmail.com", "quotevent2014");
            transport.sendMessage(message, message.getAllRecipients());
            return true;
        } catch (MessagingException me) {
            System.out.println("Mail: MessagingException:  " + me.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Mail: Exception:  " + e.getMessage());
            return false;
        }

    }

}
