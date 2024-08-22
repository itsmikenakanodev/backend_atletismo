package com.atletismo.Service;


public interface ISendEmailService {


    Integer enviarNotificacionEmail(String destinatario, String asunto, String mensajeHtml );
}
