/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logisticalogica;
/**
 *
 * @author ULTRA
 */
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
public class EnviarCorreo {
    private static String username = "totoloco392@gmail.com"; // Coloca tu correo electrónico aquí
    private final String password = "utbqaaakffvqrwlf"; // Coloca tu contraseña aquí
    private String EmailTo;
    private String subject;
    private String content;
    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;
    
    // Constructor
    public EnviarCorreo() {
        // Inicializar las propiedades
        mProperties = new Properties();
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust" , "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", username);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        mSession = Session.getDefaultInstance(mProperties);
    }
    
    public void crearEmail(String emailDestinatario, String asunto, String contenido) {
        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(username));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailDestinatario));
            mCorreo.setSubject(asunto);
            mCorreo.setText(contenido, "ISO-8859-1", "html");
        } catch (AddressException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendEmail() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(username,password);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
