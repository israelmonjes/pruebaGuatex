/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.servicio.GuiEli.Entidades;

/**
 *
 * @author JLAM
 */
public class E_HISTORIA {

    private String noGuia;
    private String noManif;
    private String transmitido;
    private String operador;
    

    String error = "NO";

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public E_HISTORIA() {
    }

    public String getNoGuia() {
        return noGuia;
    }

    public void setNoGuia(String noGuia) {
        this.noGuia = noGuia;
    }

    public String getNoManif() {
        return noManif;
    }

    public void setNoManif(String noManif) {
        this.noManif = noManif;
    }

    public String getTransmitido() {
        return transmitido;
    }

    public void setTransmitido(String transmitido) {
        this.transmitido = transmitido;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

}
