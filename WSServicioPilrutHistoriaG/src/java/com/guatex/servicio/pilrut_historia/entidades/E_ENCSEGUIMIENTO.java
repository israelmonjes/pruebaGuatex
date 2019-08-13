/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.servicio.pilrut_historia.entidades;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author JLAM
 */
public class E_ENCSEGUIMIENTO {

    private String IDSEGUIMIENTO;
    private String NOGUIA;
    private String RESPONSABLE;
    private String ESTADO;
    private String TIPOSEGUIMIENTO;
    private String SOLUCION;
    private String FECHA;
    private String AGERPT;
    private String TELREM;
    private String TELDES;
    private String TRANSMITIDO;
    private List<E_DETSEGUIMIENTO> detSeguiList = new LinkedList<>();

    public String getIDSEGUIMIENTO() {
        return IDSEGUIMIENTO;
    }

    public void setIDSEGUIMIENTO(String IDSEGUIMIENTO) {
        this.IDSEGUIMIENTO = IDSEGUIMIENTO;
    }

    public String getNOGUIA() {
        return NOGUIA;
    }

    public void setNOGUIA(String NOGUIA) {
        this.NOGUIA = NOGUIA;
    }

    public String getRESPONSABLE() {
        return RESPONSABLE;
    }

    public void setRESPONSABLE(String RESPONSABLE) {
        this.RESPONSABLE = RESPONSABLE;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    public String getTIPOSEGUIMIENTO() {
        return TIPOSEGUIMIENTO;
    }

    public void setTIPOSEGUIMIENTO(String TIPOSEGUIMIENTO) {
        this.TIPOSEGUIMIENTO = TIPOSEGUIMIENTO;
    }

    public String getSOLUCION() {
        return SOLUCION;
    }

    public void setSOLUCION(String SOLUCION) {
        this.SOLUCION = SOLUCION;
    }

    public String getFECHA() {
        return FECHA;
    }

    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }

    public String getAGERPT() {
        return AGERPT;
    }

    public void setAGERPT(String AGERPT) {
        this.AGERPT = AGERPT;
    }

    public String getTELREM() {
        return TELREM;
    }

    public void setTELREM(String TELREM) {
        this.TELREM = TELREM;
    }

    public String getTELDES() {
        return TELDES;
    }

    public void setTELDES(String TELDES) {
        this.TELDES = TELDES;
    }

    public String getTRANSMITIDO() {
        return TRANSMITIDO;
    }

    public void setTRANSMITIDO(String TRANSMITIDO) {
        this.TRANSMITIDO = TRANSMITIDO;
    }

    public List<E_DETSEGUIMIENTO> getDetSeguiList() {
        return detSeguiList;
    }

    public void setDetSeguiList(List<E_DETSEGUIMIENTO> detSeguiList) {
        this.detSeguiList = detSeguiList;
    }
}
