/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.servicio.pilrut_historia.entidades;

import com.guatex.servicio.GuiEli.Entidades.E_GUIASELI;
import com.guatex.servicio.GuiEli.Entidades.E_HISTORIA;
import com.guatex.servicio.GuiEli.Entidades.GUIAS;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author JLAM
 */
public class E_RespuestaParseo {

    public E_RespuestaParseo() {
    }

    String error = "NO";

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    //Se genera para poder tener cada objeto en una lista o mejor dicho una lista de objetos
    List<E_ParseoPilrut> pilrut = new LinkedList<>();
    List<E_ParseoHistoria> historia = new LinkedList<>();
    List<E_ENCSEGUIMIENTO> EncSeguimiento = new LinkedList<>();
    List<E_GUIASELI> guiasEli = new LinkedList<>();
    private LinkedList<GUIAS> guias = new LinkedList<>();

    public StringBuilder xmlEncSeguimiento;

    public StringBuilder getXmlEncSeguimiento() {
        return xmlEncSeguimiento;
    }

    public void setXmlEncSeguimiento(StringBuilder xmlEncSeguimiento) {
        this.xmlEncSeguimiento = xmlEncSeguimiento;
    }

    public List<E_ENCSEGUIMIENTO> getEncSeguimiento() {
        return EncSeguimiento;
    }

    public void setEncSeguimiento(List<E_ENCSEGUIMIENTO> EncSeguimiento) {
        this.EncSeguimiento = EncSeguimiento;
    }

    public List<E_ParseoPilrut> getPilrut() {
        return pilrut;
    }

    public void setPilrut(List<E_ParseoPilrut> pilrut) {
        this.pilrut = pilrut;
    }

    public List<E_ParseoHistoria> getHistoria() {
        return historia;
    }

    public void setHistoria(List<E_ParseoHistoria> historia) {
        this.historia = historia;
    }

    public List<E_GUIASELI> getGuiasEli() {
        return guiasEli;
    }

    public void setGuiasEli(List<E_GUIASELI> guiasEli) {
        this.guiasEli = guiasEli;
    }

    public LinkedList<GUIAS> getGuias() {
        return guias;
    }

    public void setGuias(LinkedList<GUIAS> guias) {
        this.guias = guias;
    }

}
