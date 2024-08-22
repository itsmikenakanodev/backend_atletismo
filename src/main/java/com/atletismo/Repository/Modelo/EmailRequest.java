package com.atletismo.Repository.Modelo;

import java.io.Serializable;

public class EmailRequest implements Serializable{

    private static final long serialVersionUID = 1L;

    private String destinatario;
    private String asunto;
    private String mensaje;
    private String mensajeHtml;



    //Getters and Setters
    
    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    public String getAsunto() {
        return asunto;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getMensajeHtml() {
        return mensajeHtml;
    }
    public void setMensajeHtml(String mensajeHtml) {
        this.mensajeHtml = mensajeHtml;
    }
    

    


    
}
