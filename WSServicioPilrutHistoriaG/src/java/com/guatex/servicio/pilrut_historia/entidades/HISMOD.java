/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.servicio.pilrut_historia.entidades;

/**
 *
 * @author CPINEDA
 */
public class HISMOD {

    public HISMOD() {
    }
    private String TIPO;
    private String NOGUIA;
    private String NOGUIANT;
    private String OPERADOR;
    private String FECHA;
    private String HORA;
    private String RAZON;
    private String ANTERIOR;

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public String getNOGUIA() {
        return NOGUIA;
    }

    public void setNOGUIA(String NOGUIA) {
        this.NOGUIA = NOGUIA;
    }

    public String getNOGUIANT() {
        return NOGUIANT;
    }

    public void setNOGUIANT(String NOGUIANT) {
        this.NOGUIANT = NOGUIANT;
    }

    public String getOPERADOR() {
        return OPERADOR;
    }

    public void setOPERADOR(String OPERADOR) {
        this.OPERADOR = OPERADOR;
    }

    public String getFECHA() {
        return FECHA;
    }

    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }

    public String getHORA() {
        return HORA;
    }

    public void setHORA(String HORA) {
        this.HORA = HORA;
    }

    public String getRAZON() {
        return RAZON;
    }

    public void setRAZON(String RAZON) {
        this.RAZON = RAZON;
    }

    public String getANTERIOR() {
        return ANTERIOR;
    }

    public void setANTERIOR(String ANTERIOR) {
        this.ANTERIOR = ANTERIOR;
    }
    
}
