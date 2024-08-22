package com.atletismo.Service;


import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class SendEmailServiceImpl implements ISendEmailService {

        @Autowired
        private JavaMailSender javaMailSender;

        @Override
        public Integer enviarNotificacionEmail(String destinatario, String asunto, String mensajeHtml) {


            Integer flag =0;
             try{
            
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
 
            helper.setTo(destinatario);

            if (asunto == null || asunto.isEmpty()) {
                asunto = "NOTIFICACION"; //Asunto por defecto si no se recibe el asunto desde el front
            }

            helper.setSubject(asunto);
            //helper.setText(mensaje);// se puede usar si se quiere enviar solo texto
            helper.setText(mensajeHtml,true); //Lo recomendado enviar un HTML que se renderiza en la bandeja de entrada del destinatario,
                                              //Para usar HTML se puede usar un template de VUE, convertirlo a una estructura comun HTML y se lo envia como string en la
                                              //variable mensajeHTML
            javaMailSender.send(message);
            flag =1;
            }catch(Exception ex){

                throw new RuntimeException(ex.getMessage().toString());
            }            

            return flag;
        }


    

}
