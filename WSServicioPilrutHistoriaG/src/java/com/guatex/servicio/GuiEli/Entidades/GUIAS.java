/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.servicio.GuiEli.Entidades;

import java.util.LinkedList;

/**
 *
 * @author CPINEDA
 */
public class GUIAS {

    public GUIAS() {
    }

    private String noguia;//si
    private String FECHA;
    private String CODREM;
    private String NOMREM;
    private String TELREM;
    private String DIRREM1;
    private String ZONAREM;
    private String DIRREM2;
    private String CODDES;
    private String nomdes;//si

    private String TELDES;
    private String DIRDES1;
    private String ZONADES;
    private String DIRDES2;
    private String PTOORI;
    private String ptodes;//si
    private String CODCOB;
    private String SERIEFACTURA;
    private String FACTURA;
    private String OBSERVACIONES;

    private String P_RECIBIO;
    private String P_FECHA;
    private String P_HORA;
    private String P_OPERADOR;
    private String P_ESTATUS;
    private String P_CEDULA;
    private String OPERADOR;
    private String TIPTAR;
    private String DECLARADO;
    private String SEGURO;

    private String SERIESEGURO;
    private String FACTURASEGURO;
    private String PAGOCONTADOSEGURO;
    private String FECOPE;
    private String HORAOPE;
    private String FECPOD;
    private String HORAPOD;
    private String COBEX;
    private String RECOGEOFICINA;
    private String OPEGAGE;

    private String OPEPAGE;
    private String HORAGAGE;
    private String HORAPAGE;
    private String MNFGUI;
    private String MNFPOD;
    private String MNCPORI;
    private String MNCPDES;
    private String ULTIMAMODIFICACION;
    private String TOTSERV;
    private String PAGOCONTADOSER;

    private String SERIESER;
    private String FACTURASER;
    private String RUTZONA;
    private String RUTAENT;
    private String FECENT;
    private String ENTLATITUD;
    private String ENTLONGITUD;
    private String LLAVECLIENTE;
    private String FECPODAGE;
    private String SERIEFACTURACOM;

    private String FACTURACOM;
    private String VALORCOM;
    private String OPEPWH;
    private String TRANSMITIDO;

    
    private LinkedList<GUIASDETALLE> listaGuiasDetalle = new LinkedList<>();
    
    
    public String getNoguia() {
        return noguia;
    }

    public void setNoguia(String noguia) {
        this.noguia = noguia;
    }

    public String getFECHA() {
        return FECHA;
    }

    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }

    public String getCODREM() {
        return CODREM;
    }

    public void setCODREM(String CODREM) {
        this.CODREM = CODREM;
    }

    public String getNOMREM() {
        return NOMREM;
    }

    public void setNOMREM(String NOMREM) {
        this.NOMREM = NOMREM;
    }

    public String getTELREM() {
        return TELREM;
    }

    public void setTELREM(String TELREM) {
        this.TELREM = TELREM;
    }

    public String getDIRREM1() {
        return DIRREM1;
    }

    public void setDIRREM1(String DIRREM1) {
        this.DIRREM1 = DIRREM1;
    }

    public String getZONAREM() {
        return ZONAREM;
    }

    public void setZONAREM(String ZONAREM) {
        this.ZONAREM = ZONAREM;
    }

    public String getDIRREM2() {
        return DIRREM2;
    }

    public void setDIRREM2(String DIRREM2) {
        this.DIRREM2 = DIRREM2;
    }

    public String getCODDES() {
        return CODDES;
    }

    public void setCODDES(String CODDES) {
        this.CODDES = CODDES;
    }

    public String getNomdes() {
        return nomdes;
    }

    public void setNomdes(String nomdes) {
        this.nomdes = nomdes;
    }

    public String getTELDES() {
        return TELDES;
    }

    public void setTELDES(String TELDES) {
        this.TELDES = TELDES;
    }

    public String getDIRDES1() {
        return DIRDES1;
    }

    public void setDIRDES1(String DIRDES1) {
        this.DIRDES1 = DIRDES1;
    }

    public String getZONADES() {
        return ZONADES;
    }

    public void setZONADES(String ZONADES) {
        this.ZONADES = ZONADES;
    }

    public String getDIRDES2() {
        return DIRDES2;
    }

    public void setDIRDES2(String DIRDES2) {
        this.DIRDES2 = DIRDES2;
    }

    public String getPTOORI() {
        return PTOORI;
    }

    public void setPTOORI(String PTOORI) {
        this.PTOORI = PTOORI;
    }

    public String getPtodes() {
        return ptodes;
    }

    public void setPtodes(String ptodes) {
        this.ptodes = ptodes;
    }

    public String getCODCOB() {
        return CODCOB;
    }

    public void setCODCOB(String CODCOB) {
        this.CODCOB = CODCOB;
    }

    public String getSERIEFACTURA() {
        return SERIEFACTURA;
    }

    public void setSERIEFACTURA(String SERIEFACTURA) {
        this.SERIEFACTURA = SERIEFACTURA;
    }

    public String getFACTURA() {
        return FACTURA;
    }

    public void setFACTURA(String FACTURA) {
        this.FACTURA = FACTURA;
    }

    public String getOBSERVACIONES() {
        return OBSERVACIONES;
    }

    public void setOBSERVACIONES(String OBSERVACIONES) {
        this.OBSERVACIONES = OBSERVACIONES;
    }

    public String getP_RECIBIO() {
        return P_RECIBIO;
    }

    public void setP_RECIBIO(String P_RECIBIO) {
        this.P_RECIBIO = P_RECIBIO;
    }

    public String getP_FECHA() {
        return P_FECHA;
    }

    public void setP_FECHA(String P_FECHA) {
        this.P_FECHA = P_FECHA;
    }

    public String getP_HORA() {
        return P_HORA;
    }

    public void setP_HORA(String P_HORA) {
        this.P_HORA = P_HORA;
    }

    public String getP_OPERADOR() {
        return P_OPERADOR;
    }

    public void setP_OPERADOR(String P_OPERADOR) {
        this.P_OPERADOR = P_OPERADOR;
    }

    public String getP_ESTATUS() {
        return P_ESTATUS;
    }

    public void setP_ESTATUS(String P_ESTATUS) {
        this.P_ESTATUS = P_ESTATUS;
    }

    public String getP_CEDULA() {
        return P_CEDULA;
    }

    public void setP_CEDULA(String P_CEDULA) {
        this.P_CEDULA = P_CEDULA;
    }

    public String getOPERADOR() {
        return OPERADOR;
    }

    public void setOPERADOR(String OPERADOR) {
        this.OPERADOR = OPERADOR;
    }

    public String getTIPTAR() {
        return TIPTAR;
    }

    public void setTIPTAR(String TIPTAR) {
        this.TIPTAR = TIPTAR;
    }

    public String getDECLARADO() {
        return DECLARADO;
    }

    public void setDECLARADO(String DECLARADO) {
        this.DECLARADO = DECLARADO;
    }

    public String getSEGURO() {
        return SEGURO;
    }

    public void setSEGURO(String SEGURO) {
        this.SEGURO = SEGURO;
    }

    public String getSERIESEGURO() {
        return SERIESEGURO;
    }

    public void setSERIESEGURO(String SERIESEGURO) {
        this.SERIESEGURO = SERIESEGURO;
    }

    public String getFACTURASEGURO() {
        return FACTURASEGURO;
    }

    public void setFACTURASEGURO(String FACTURASEGURO) {
        this.FACTURASEGURO = FACTURASEGURO;
    }

    public String getPAGOCONTADOSEGURO() {
        return PAGOCONTADOSEGURO;
    }

    public void setPAGOCONTADOSEGURO(String PAGOCONTADOSEGURO) {
        this.PAGOCONTADOSEGURO = PAGOCONTADOSEGURO;
    }

    public String getFECOPE() {
        return FECOPE;
    }

    public void setFECOPE(String FECOPE) {
        this.FECOPE = FECOPE;
    }

    public String getHORAOPE() {
        return HORAOPE;
    }

    public void setHORAOPE(String HORAOPE) {
        this.HORAOPE = HORAOPE;
    }

    public String getFECPOD() {
        return FECPOD;
    }

    public void setFECPOD(String FECPOD) {
        this.FECPOD = FECPOD;
    }

    public String getHORAPOD() {
        return HORAPOD;
    }

    public void setHORAPOD(String HORAPOD) {
        this.HORAPOD = HORAPOD;
    }

    public String getCOBEX() {
        return COBEX;
    }

    public void setCOBEX(String COBEX) {
        this.COBEX = COBEX;
    }

    public String getRECOGEOFICINA() {
        return RECOGEOFICINA;
    }

    public void setRECOGEOFICINA(String RECOGEOFICINA) {
        this.RECOGEOFICINA = RECOGEOFICINA;
    }

    public String getOPEGAGE() {
        return OPEGAGE;
    }

    public void setOPEGAGE(String OPEGAGE) {
        this.OPEGAGE = OPEGAGE;
    }

    public String getOPEPAGE() {
        return OPEPAGE;
    }

    public void setOPEPAGE(String OPEPAGE) {
        this.OPEPAGE = OPEPAGE;
    }

    public String getHORAGAGE() {
        return HORAGAGE;
    }

    public void setHORAGAGE(String HORAGAGE) {
        this.HORAGAGE = HORAGAGE;
    }

    public String getHORAPAGE() {
        return HORAPAGE;
    }

    public void setHORAPAGE(String HORAPAGE) {
        this.HORAPAGE = HORAPAGE;
    }

    public String getMNFGUI() {
        return MNFGUI;
    }

    public void setMNFGUI(String MNFGUI) {
        this.MNFGUI = MNFGUI;
    }

    public String getMNFPOD() {
        return MNFPOD;
    }

    public void setMNFPOD(String MNFPOD) {
        this.MNFPOD = MNFPOD;
    }

    public String getMNCPORI() {
        return MNCPORI;
    }

    public void setMNCPORI(String MNCPORI) {
        this.MNCPORI = MNCPORI;
    }

    public String getMNCPDES() {
        return MNCPDES;
    }

    public void setMNCPDES(String MNCPDES) {
        this.MNCPDES = MNCPDES;
    }

    public String getULTIMAMODIFICACION() {
        return ULTIMAMODIFICACION;
    }

    public void setULTIMAMODIFICACION(String ULTIMAMODIFICACION) {
        this.ULTIMAMODIFICACION = ULTIMAMODIFICACION;
    }

    public String getTOTSERV() {
        return TOTSERV;
    }

    public void setTOTSERV(String TOTSERV) {
        this.TOTSERV = TOTSERV;
    }

    public String getPAGOCONTADOSER() {
        return PAGOCONTADOSER;
    }

    public void setPAGOCONTADOSER(String PAGOCONTADOSER) {
        this.PAGOCONTADOSER = PAGOCONTADOSER;
    }

    public String getSERIESER() {
        return SERIESER;
    }

    public void setSERIESER(String SERIESER) {
        this.SERIESER = SERIESER;
    }

    public String getFACTURASER() {
        return FACTURASER;
    }

    public void setFACTURASER(String FACTURASER) {
        this.FACTURASER = FACTURASER;
    }

    public String getRUTZONA() {
        return RUTZONA;
    }

    public void setRUTZONA(String RUTZONA) {
        this.RUTZONA = RUTZONA;
    }

    public String getRUTAENT() {
        return RUTAENT;
    }

    public void setRUTAENT(String RUTAENT) {
        this.RUTAENT = RUTAENT;
    }

    public String getFECENT() {
        return FECENT;
    }

    public void setFECENT(String FECENT) {
        this.FECENT = FECENT;
    }

    public String getENTLATITUD() {
        return ENTLATITUD;
    }

    public void setENTLATITUD(String ENTLATITUD) {
        this.ENTLATITUD = ENTLATITUD;
    }

    public String getENTLONGITUD() {
        return ENTLONGITUD;
    }

    public void setENTLONGITUD(String ENTLONGITUD) {
        this.ENTLONGITUD = ENTLONGITUD;
    }

    public String getLLAVECLIENTE() {
        return LLAVECLIENTE;
    }

    public void setLLAVECLIENTE(String LLAVECLIENTE) {
        this.LLAVECLIENTE = LLAVECLIENTE;
    }

    public String getFECPODAGE() {
        return FECPODAGE;
    }

    public void setFECPODAGE(String FECPODAGE) {
        this.FECPODAGE = FECPODAGE;
    }

    public String getSERIEFACTURACOM() {
        return SERIEFACTURACOM;
    }

    public void setSERIEFACTURACOM(String SERIEFACTURACOM) {
        this.SERIEFACTURACOM = SERIEFACTURACOM;
    }

    public String getFACTURACOM() {
        return FACTURACOM;
    }

    public void setFACTURACOM(String FACTURACOM) {
        this.FACTURACOM = FACTURACOM;
    }

    public String getVALORCOM() {
        return VALORCOM;
    }

    public void setVALORCOM(String VALORCOM) {
        this.VALORCOM = VALORCOM;
    }

    public String getOPEPWH() {
        return OPEPWH;
    }

    public void setOPEPWH(String OPEPWH) {
        this.OPEPWH = OPEPWH;
    }

    public String getTRANSMITIDO() {
        return TRANSMITIDO;
    }

    public void setTRANSMITIDO(String TRANSMITIDO) {
        this.TRANSMITIDO = TRANSMITIDO;
    }

    public LinkedList<GUIASDETALLE> getListaGuiasDetalle() {
        return listaGuiasDetalle;
    }

    public void setListaGuiasDetalle(LinkedList<GUIASDETALLE> listaGuiasDetalle) {
        this.listaGuiasDetalle = listaGuiasDetalle;
    }
    
    
}
