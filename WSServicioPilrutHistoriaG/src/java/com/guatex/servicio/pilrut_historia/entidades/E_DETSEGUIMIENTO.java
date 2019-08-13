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
public class E_DETSEGUIMIENTO {

    private String IDSEGUIMIENTO;
    private String USUARIO;
    private String FECHAHORA;
    private String OBSERVACIONES;
    private String TRANSMITIDO;

    public String getIDSEGUIMIENTO() {
        return IDSEGUIMIENTO;
    }

    public void setIDSEGUIMIENTO(String IDSEGUIMIENTO) {
        this.IDSEGUIMIENTO = IDSEGUIMIENTO;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getFECHAHORA() {
        return FECHAHORA;
    }

    public void setFECHAHORA(String FECHAHORA) {
        this.FECHAHORA = FECHAHORA;
    }

    public String getOBSERVACIONES() {
        return OBSERVACIONES;
    }

    public void setOBSERVACIONES(String OBSERVACIONES) {
        this.OBSERVACIONES = OBSERVACIONES;
    }

    public String getTRANSMITIDO() {
        return TRANSMITIDO;
    }

    public void setTRANSMITIDO(String TRANSMITIDO) {
        this.TRANSMITIDO = TRANSMITIDO;
    }

}
