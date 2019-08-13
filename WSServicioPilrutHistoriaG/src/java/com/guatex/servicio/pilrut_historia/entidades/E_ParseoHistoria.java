/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.servicio.pilrut_historia.entidades;

/**
 *
 * @author JLAM
 */
public class E_ParseoHistoria {

    public E_ParseoHistoria() {
    }

    private String NOGUIA;
    private String NOMANIF;
    private String fechahora;
    private String PESO;
    private String TRANSMITIDO;

    public String getNOGUIA() {
        return NOGUIA;
    }

    public void setNOGUIA(String NOGUIA) {
        this.NOGUIA = NOGUIA;
    }

    public String getNOMANIF() {
        return NOMANIF;
    }

    public void setNOMANIF(String NOMANIF) {
        this.NOMANIF = NOMANIF;
    }

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    public String getPESO() {
        return PESO;
    }

    public void setPESO(String PESO) {
        this.PESO = PESO;
    }

    public String getTRANSMITIDO() {
        return TRANSMITIDO;
    }

    public void setTRANSMITIDO(String TRANSMITIDO) {
        this.TRANSMITIDO = TRANSMITIDO;
    }
    
    
}
