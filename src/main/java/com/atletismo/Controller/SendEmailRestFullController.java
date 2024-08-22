package com.atletismo.Controller;

import com.atletismo.Repository.Modelo.EmailRequest;
import com.atletismo.Service.ISendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/emails")
public class SendEmailRestFullController {

    @Autowired
    private ISendEmailService sendEmailService;


    @PostMapping(path = "/sendNotif",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> enviarNotificacionEmail(@RequestBody EmailRequest emailRequest){
        try{
                return new ResponseEntity<>(this.sendEmailService.enviarNotificacionEmail(emailRequest.getDestinatario(),emailRequest.getAsunto(),emailRequest.getMensajeHtml()),null,HttpStatus.OK);
        }catch(Exception ex){

            var mensajeError=crearMensajeError(ex);

            return new ResponseEntity<>(mensajeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String crearMensajeError(Exception ex) {
        StringBuilder mensajeError = new StringBuilder();
        mensajeError.append("Error al enviar el correo por error del servidor: ").append(ex.toString())
                .append(" detail: ").append(ex.getMessage()).append("\n");

        for (StackTraceElement element : ex.getStackTrace()) {
            mensajeError.append(element.toString()).append("\n");
        }

        return mensajeError.toString();
    }

}
