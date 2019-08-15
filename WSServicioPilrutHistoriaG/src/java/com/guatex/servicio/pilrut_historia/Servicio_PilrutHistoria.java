/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.servicio.pilrut_historia;

import com.guatex.servicio.GuiEli.Entidades.E_GUIASELI;
import com.guatex.servicio.GuiEli.Entidades.E_HISTORIA;
import com.guatex.servicio.GuiEli.Entidades.GUIAS;
import com.guatex.servicio.GuiEli.Entidades.GUIASDETALLE;
import com.guatex.servicio.GuiEli.Parseo.Parseo;
import com.guatex.servicio.pilrut_historia.datos.CapturaDatos;
import com.guatex.servicio.pilrut_historia.entidades.E_Parseo;
import com.guatex.servicio.pilrut_historia.entidades.E_ParseoHistoria;
import com.guatex.servicio.pilrut_historia.entidades.E_ParseoPilrut;
import com.guatex.servicio.pilrut_historia.entidades.E_RespuestaParseo;
import com.guatex.servicio.pilrut_historia.entidades.GzipTest;
import com.guatex.servicio.pilrut_historia.entidades.PARSEO_GUIAS;
import java.util.Date;
import java.util.LinkedList;
//import java.util.logging.Level;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author CPINEDA
 */
@WebService(serviceName = "Servicio_PilrutHistoria")
public class Servicio_PilrutHistoria {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        System.out.println("hola " + txt);

        return "Hello " + txt + " !";
    }

    /**
     * SincronizacionGuiEli Este metodo es para eliminar las guías que sean
     * necesarias.
     *
     * @param xmlGuiEli este recibe un array de byte.
     * @return Retorna un array de byte.
     *
     */
    @WebMethod(operationName = "sincronizacionGuiEli")
    public byte[] sincronizacionGuiEli(@WebParam(name = "xmlGuiEli") byte[] xmlGuiEli) {
        try {
            System.out.println("INGRESANDO A LA SINCRONIZACIÓN DEL WEB-SERVICES ELIMINACION DE GUIAS " + new Date());
            StringBuilder stringRespuesta = new StringBuilder();
            //String xmlCredenciales = xmlCredencialesori;
            GzipTest texe = new GzipTest();
            String xmlCredenciales = texe.ungzip(xmlGuiEli);
            Parseo archivo = new Parseo();
            LinkedList<E_HISTORIA> listaEliminar = new LinkedList<>();
            E_HISTORIA historiaEli = new E_HISTORIA();
            E_RespuestaParseo respuestaGuiEli = archivo.parseoXmlGuiEli(xmlCredenciales);
            System.out.println("....GUIAS A ELIMINAR....");
            CapturaDatos consulta = new CapturaDatos();
            stringRespuesta.append("<TAG>");
            stringRespuesta.append("<GUIELI>");
            stringRespuesta.append("<REGISTROS>");
//            LinkedList<E_GUIASELI> listaGuiasEli = new LinkedList<>();
            for (E_GUIASELI objGuiEli : respuestaGuiEli.getGuiasEli()) {
                System.out.println("guia...." + objGuiEli.getNOGUIA());
                System.out.println("nomanif." + objGuiEli.getNOMANIF());
                //AQUI DEBERIA VALIDAR SI LA GUIA EXISTE Y NO TIENE DATOS EN: P_RECIBIO, P_FECHA, P_HORA_, P_OPERADOR, P_ESTATUS, P_CEDULA
//                System.out.println("existe en db producion " + consulta.siExisteGuiaHistoria(obj.getNOGUIA(), obj.getNOMANIF()) + "---");
                GUIAS objGuias = consulta.siExisteGuia(objGuiEli.getNOGUIA());
                if (objGuias != null) {
                    System.out.println("si existe la guia");
                    if (objGuias.getP_RECIBIO().isEmpty() && (objGuias.getP_FECHA().isEmpty() || objGuias.getP_FECHA().equals("19000101")) && objGuias.getP_HORA().isEmpty()
                            && objGuias.getP_OPERADOR().isEmpty() && objGuias.getP_ESTATUS().isEmpty() && objGuias.getP_CEDULA().isEmpty()) {
                        if (consulta.siExisteGUIABOD(objGuiEli.getNOGUIA())) {
                            LinkedList<E_HISTORIA> listaHistoria = new LinkedList<>();
                            listaHistoria = consulta.selectHistoria(objGuiEli.getNOGUIA());
                            if (listaHistoria.size() > 0 && listaHistoria.size() < 2) {
                                for (E_HISTORIA objHisto : listaHistoria) {
                                    if(objHisto.getNoGuia().equals(objGuiEli.getNOGUIA()) && objHisto.getNoManif().equals(objGuiEli.getNOMANIF())){
                                        
                                    }
                                }
                            } else if (listaHistoria.size() > 1) {
                                for (E_HISTORIA objHisto : listaHistoria) {

                                }
                            }
                        }
                        System.out.println("la guia puede ser eliminada");
                        /* se debe borrar en guias, en historia, guardar el registro en Hisdmod y enviar una respuesa */
                        int res = consulta.insertDataHismod(objGuiEli);
                        if (res == 1) {
                            if (consulta.delteGuia(objGuiEli.getNOGUIA()) && consulta.deleteGuiasDetalle(objGuiEli.getNOGUIA()) && consulta.deleteGuiaHistoria(objGuiEli.getNOGUIA(), objGuiEli.getNOMANIF())) {
//                                consulta.deleteGuiasDetalle(obj.getNOGUIA());
//                                consulta.deleteGuiaHistoria(obj.getNOGUIA(), obj.getNOMANIF());
                                stringRespuesta.append("<REGISTRO>");
                                stringRespuesta.append("<NOGUIA>" + objGuiEli.getNOGUIA() + "</NOGUIA>");
                                stringRespuesta.append("<NOMANIF>" + objGuiEli.getNOMANIF() + "</NOMANIF>");
                                stringRespuesta.append("<TRANSMITIDO>S</TRANSMITIDO>");
                                stringRespuesta.append("</REGISTRO>");

                            } else {
                                stringRespuesta.append("<REGISTRO>");
                                stringRespuesta.append("<NOGUIA>" + objGuiEli.getNOGUIA() + "</NOGUIA>");
                                stringRespuesta.append("<NOMANIF>" + objGuiEli.getNOMANIF() + "</NOMANIF>");
                                stringRespuesta.append("<TRANSMITIDO>N</TRANSMITIDO>");
                                stringRespuesta.append("</REGISTRO>");
                            }

                        }

                    } else {
                        System.out.println("no es posible eliminar la guia dado que tiene datos P_..");
                        /**
                         * Cuando la guia tenga por lo menos uno de los
                         * siguientes campos que son : P_RECIBIO, P_FECHA,
                         * P_HORA_, P_OPERADOR, P_ESTATUS, P_CEDULA este lleno
                         * no sera posible borrar la guia, a lo que retornara el
                         * codigo 9999.
                         */
                        stringRespuesta.append("<REGISTRO>");
                        stringRespuesta.append("<NOGUIA>" + objGuiEli.getNOGUIA() + "</NOGUIA>");
                        stringRespuesta.append("<NOMANIF>" + objGuiEli.getNOMANIF() + "</NOMANIF>");
                        stringRespuesta.append("<TRANSMITIDO>9999</TRANSMITIDO>");
                        stringRespuesta.append("</REGISTRO>");
                    }
                } else {
                    /**
                     * Si la guia a buscar no existe retornara el siguiente
                     * elemento 9997 en el campo TRANSMITIDO.
                     */
                    System.out.println("No existe la guia buscada.");
                    stringRespuesta.append("<REGISTRO>");
                    stringRespuesta.append("<NOGUIA>" + objGuiEli.getNOGUIA() + "</NOGUIA>");
                    stringRespuesta.append("<NOMANIF>" + objGuiEli.getNOMANIF() + "</NOMANIF>");
                    stringRespuesta.append("<TRANSMITIDO>9997</TRANSMITIDO>");
                    stringRespuesta.append("</REGISTRO>");
                }

//                if(consulta.siExisteGuia(obj.getNOGUIA())){
//                    System.out.println("si exite la guia y se puede borrar");
//                    
//                    
//                }else{
//                    System.out.println("*******************************************************************");
//                    System.out.println("No es posible borrar la guia ya que tiene alguno de los siguientes"
//                            + "capos llenos: P_RECIBIO, P_FECHA, P_HORA_, P_OPERADOR, P_ESTATUS, P_CEDULA");
//                    System.out.println("*******************************************************************");
//                }
            }

            stringRespuesta.append("</REGISTROS>");
            stringRespuesta.append("</GUIELI>");
            stringRespuesta.append("</TAG>");
//            System.out.println("recepcion de xml "+xmlCredenciales);
//            System.out.println("////////////////////////tenemos algun error/////////" + r.getError());
            if (historiaEli.getError() != null && historiaEli.getError().equals("SI")) {
                //String respuesta = "<RESPUESTA><ERROR>9999</ERROR><DESCRIPCION>ERROR DE SISTEMA, LLAME AL PEROSNAL TECNICO DE GUATEX</DESCRIPCION></RESPUESTA>";
                String respuesta = "99993, error";
//            respuesta = respuesta + "</RESPUESTA>";

                respuesta = respuesta.replace("&", "&amp;");
                respuesta = respuesta.replace("\"", "&quot;");
                respuesta = respuesta.replace("\'", "&apos;");

                byte[] mires = null;

                try {

                    mires = texe.gzip(respuesta);
                } catch (Exception ee) {

                    ee.printStackTrace();

                }

                System.out.println("SALIENDO DE LA SINCRONIZACIÓN DEL WEB-SERVICES ELIMINACION DE GUIAS " + new Date());
                return mires;
            } else {
                try {
                    CapturaDatos datos = new CapturaDatos();
                    StringBuilder sbrespuesta = new StringBuilder();
//                    String xmlTransmitido = "S";
                    String xmlTransmitido = xmlCredenciales;
                    String xml = stringRespuesta.toString();
                    System.out.println("...........................\n" + xml);
//                    String xml = xmlTransmitido;
                    GzipTest tex = new GzipTest();
                    System.out.println("ENVIO DE XML RESPUESTA ");
                    System.out.println("SALIENDO DE LA SINCRONIZACIÓN DEL WEB-SERVICES ELIMINACION DE GUIAS " + new Date());
                    //aqui retorna
                    return tex.gzip(xml);
                } catch (Exception e) {
                    String respuesta = "999";

                    byte[] mires = null;

                    try {
                        GzipTest texe1 = new GzipTest();

                        mires = texe1.gzip(respuesta);
                    } catch (Exception ee) {

                        ee.printStackTrace();

                    }

                    System.out.println("SALIENDO DE LA SINCRONIZACIÓN DEL WEB-SERVICES ELIMINACION DE GUIAS " + new Date());

                    return mires;
                }
// LLAMARA LOS METODOS PARA VALIDAR E INSERTAR EN LA TABLA

                //return xml;
            }

        } catch (Exception e) {
            e.printStackTrace();

            //String respuesta = "<RESPUESTA><ERROR>9999</ERROR><DESCRIPCION>ERROR DE SISTEMA, LLAME AL PEROSNAL TECNICO DE GUATEX</DESCRIPCION></RESPUESTA>";
            String respuesta = "Error 99990, al utilizar el motodo sincronizacionGuiEli";
//            respuesta = respuesta + "</RESPUESTA>";

            respuesta = respuesta.replace("&", "&amp;");
            respuesta = respuesta.replace("\"", "&quot;");
            respuesta = respuesta.replace("\'", "&apos;");

            byte[] mires = null;

            try {
                GzipTest texe = new GzipTest();

                mires = texe.gzip(respuesta);
            } catch (Exception ee) {
                ee.printStackTrace();
//                Logger.getLogger(Servicio_PilrutHistoria.class.getName()).log(Level.SEVERE, null, ee);
            }
//            grabarlogs.grabaLogFileAdministrador("ERROR AL PROCESAR EL XML RECIBIDO POR PARTE DEL CLIENTE");
            System.out.println("SALIENDO DE LA SINCRONIZACIÓN DEL WEB-SERVICES ELIMINACION DE GUIAS " + new Date());
//            Logger.getLogger(Servicio_PilrutHistoria.class.getName()).log(Level.SEVERE, respuesta, e);
            return mires;

            //   return xml;
        }

    }

    @WebMethod(operationName = "sincronizacion")
    public byte[] sincronizacion(@WebParam(name = "xmlCredencialesori") byte[] xmlCredencialesori) {

        try {

            System.out.println("INGRESANDO AL Ws DE SINCRONIZACIÓN" + new Date());

            //String xmlCredenciales = xmlCredencialesori;
            GzipTest texe = new GzipTest();
            String xmlCredenciales = texe.ungzip(xmlCredencialesori);
            E_Parseo archivo = new E_Parseo();
            E_RespuestaParseo r = archivo.parseoXML(xmlCredenciales);
//            System.out.println("recepcion de xml \n["+xmlCredenciales+"]");
//            System.out.println("////////////////////////tenemos algun error/////////" + r.getError());
            if (r.getError() != null && r.getError().equals("SI")) {
                //String respuesta = "<RESPUESTA><ERROR>9999</ERROR><DESCRIPCION>ERROR DE SISTEMA, LLAME AL PEROSNAL TECNICO DE GUATEX</DESCRIPCION></RESPUESTA>";
                String respuesta = "999";
//            respuesta = respuesta + "</RESPUESTA>";

                respuesta = respuesta.replace("&", "&amp;");
                respuesta = respuesta.replace("\"", "&quot;");
                respuesta = respuesta.replace("\'", "&apos;");

                byte[] mires = null;

                try {

                    mires = texe.gzip(respuesta);
                } catch (Exception ee) {

                    ee.printStackTrace();

                }

                System.out.println("SALIENDO DE LA SINCRONIZACIÓN DEL WEB-SERVICES " + new Date());
                return mires;
            } else {
                try {
                    CapturaDatos datos = new CapturaDatos();
                    StringBuilder sbrespuesta = new StringBuilder();
                    String xmlTransmitido = "S";

                    sbrespuesta.append("<TAG>");
                    sbrespuesta.append("<PILRUT>");
                    sbrespuesta.append("<REGISTROS>");
                    for (E_ParseoPilrut dato : r.getPilrut()) {

                        if (datos.validacionT_NOMANIF_Pilrut(dato.getT_NOMANIF()) != true) {
                            // System.out.println("entro a la agrupacion de la respuesta");
//                     datos.InsertDataPilrut( (dato));
                            sbrespuesta.append("<REGISTRO>");
                            sbrespuesta.append("<T_NOMANIF>" + dato.getT_NOMANIF() + "</T_NOMANIF>");
                            //System.out.println("que valor trae " + dato.getTRANSMITIDO());
                            if (dato.getTRANSMITIDO().trim().toUpperCase().equals("S")) {
                                //System.out.println(datos.InsertDataPilrut(dato));
                            } else {
                                dato.setTRANSMITIDO(xmlTransmitido);
                            }

                            sbrespuesta.append("<TRANSMITIDO>" + dato.getTRANSMITIDO() + "</TRANSMITIDO>");
                            sbrespuesta.append("</REGISTRO>");

                        } else {
                            // System.out.println("no ingresoooooo!!!!!!!!!!");

                        }

                    }

                    sbrespuesta.append("</REGISTROS>");
                    sbrespuesta.append("</PILRUT>");
                    sbrespuesta.append("<HISTORIA>");
                    sbrespuesta.append("<REGISTROS>");
                    for (E_ParseoHistoria dato1 : r.getHistoria()) {
                        //String NOMANIF = dato1.getNOMANIF();

                        if (datos.validacionNOMANIF_Historia(dato1.getNOGUIA(), dato1.getNOMANIF()) != true) {

                            sbrespuesta.append("<REGISTRO>");
                            sbrespuesta.append("<NOGUIA>" + dato1.getNOGUIA() + "</NOGUIA>");
                            sbrespuesta.append("<NOMANIF>" + dato1.getNOMANIF() + "</NOMANIF>");
                            //System.out.println("que valor trae " + dato1.getTRANSMITIDO());
                            if (dato1.getTRANSMITIDO().trim().toUpperCase().equals("S")) {
                                //System.out.println("Ya ha sido transmitido el registro");
                            } else {
                                dato1.setTRANSMITIDO(xmlTransmitido);
                            }

                            sbrespuesta.append("<TRANSMITIDO>" + dato1.getTRANSMITIDO() + "</TRANSMITIDO>");
                            sbrespuesta.append("</REGISTRO>");
                        } else {
                            // System.out.println("no ingreso!!!!!!!!!");
//                    sbrespuesta.append("<REGISTRO>");
////                    sbrespuesta.append("<NOGUIA>" + dato1.getNOGUIA() + "</NOGUIA>");
////                    sbrespuesta.append("<NOMANIF>" + dato1.getNOMANIF() + "</NOMANIF>");
////                    sbrespuesta.append("<TRANSMITIDO>NULL</TRANSMITIDO>");
//                    sbrespuesta.append("</REGISTRO>");
                        }

                    }
                    sbrespuesta.append("</REGISTROS>");
                    sbrespuesta.append("</HISTORIA>");
//                    System.out.println("xml que debemos adjuntar ....."+r.getXmlEncSeguimiento());
                    sbrespuesta.append(r.getXmlEncSeguimiento());
                    sbrespuesta.append("</TAG>");

                    String xml = sbrespuesta.toString();

                    GzipTest tex = new GzipTest();
                    System.out.println("ENVIO DE XML RESPUESTA ");
                    System.out.println("SALIENDO DE LA SINCRONIZACIÓN DEL WEB-SERVICES  " + new Date());
                    //aqui retorna
                    return tex.gzip(xml);
                } catch (Exception e) {
                    String respuesta = "999";

                    byte[] mires = null;

                    try {
                        GzipTest texe1 = new GzipTest();

                        mires = texe1.gzip(respuesta);
                    } catch (Exception ee) {

                        ee.printStackTrace();

                    }

                    System.out.println("SALIENDO DE LA SINCRONIZACIÓN DEL WEB-SERVICES  " + new Date());

                    return mires;
                }
// LLAMARA LOS METODOS PARA VALIDAR E INSERTAR EN LA TABLA

                //return xml;
            }

        } catch (Exception e) {
            e.printStackTrace();

            //String respuesta = "<RESPUESTA><ERROR>9999</ERROR><DESCRIPCION>ERROR DE SISTEMA, LLAME AL PEROSNAL TECNICO DE GUATEX</DESCRIPCION></RESPUESTA>";
            String respuesta = "999";
//            respuesta = respuesta + "</RESPUESTA>";

            respuesta = respuesta.replace("&", "&amp;");
            respuesta = respuesta.replace("\"", "&quot;");
            respuesta = respuesta.replace("\'", "&apos;");

            byte[] mires = null;

            try {
                GzipTest texe = new GzipTest();

                mires = texe.gzip(respuesta);
            } catch (Exception ee) {
                ee.printStackTrace();
//                Logger.getLogger(Servicio_PilrutHistoria.class.getName()).log(Level.SEVERE, null, ee);
            }
//            grabarlogs.grabaLogFileAdministrador("ERROR AL PROCESAR EL XML RECIBIDO POR PARTE DEL CLIENTE");
            System.out.println("SALIENDO DE LA SINCRONIZACIÓN DEL WEB-SERVICES  " + new Date());
//            Logger.getLogger(Servicio_PilrutHistoria.class.getName()).log(Level.SEVERE, respuesta, e);
            return mires;

            //   return xml;
        }

    }

    @WebMethod(operationName = "sincronizacionGUIAS")
    public byte[] sincronizacionGUIAS(@WebParam(name = "xmlGUIAS") byte[] xmlGUIAS) {
        System.out.println("******INGRESANDO AL SERVICIO SINCRONIZACIONGUIAS ******" + new Date());
        GzipTest texe = new GzipTest();
        StringBuilder respuestaXML = new StringBuilder();
        try {
            String xmlguiasCliente = texe.ungzip(xmlGUIAS);
//            System.out.println("recepcion de xml: "+xmlguiasCliente);

            PARSEO_GUIAS parseoGuias = new PARSEO_GUIAS();
            LinkedList<GUIAS> listaGuiasP = parseoGuias.paseoListaGuias(xmlguiasCliente);
            System.out.println("Dimencion de lista " + listaGuiasP.size());
            respuestaXML.append("<TAG>");
            respuestaXML.append("<GUIAS>");

            for (GUIAS obj : listaGuiasP) {
//                System.out.println("....guia "+obj.getNoguia());
                CapturaDatos capturaDatos = new CapturaDatos();
//                System.out.println("existe la guia?: "+capturaDatos.exiteGuia(obj.getNoguia()));
                if (!capturaDatos.existeGuia(obj.getNoguia())) {
                    System.out.println("insertar la guia...");
                    boolean res = capturaDatos.insertGuias(obj);
                    if (res) {
                        respuestaXML.append("<GUIA>");
                        respuestaXML.append("<NOGUIA>" + obj.getNoguia() + "</NOGUIA>");
                        respuestaXML.append("<TRANSMITIDO>S</TRANSMITIDO>");
                        respuestaXML.append("</GUIA>");
                        System.out.println("guia a insertar " + obj.getNoguia());
                    } else {
                        respuestaXML.append("<GUIA>");
                        respuestaXML.append("<NOGUIA>" + obj.getNoguia() + "</NOGUIA>");
                        respuestaXML.append("<TRANSMITIDO>N</TRANSMITIDO>");
                        respuestaXML.append("</GUIA>");
                    }

                } else {
                    System.out.println("update de la guia");

                    boolean res = capturaDatos.updateGuias(obj);
                    if (res) {
                        System.out.println("update a la guia no. " + obj.getNoguia());
                        respuestaXML.append("<GUIA>");
                        respuestaXML.append("<NOGUIA>" + obj.getNoguia() + "</NOGUIA>");
                        respuestaXML.append("<TRANSMITIDO>S</TRANSMITIDO>");
                        respuestaXML.append("</GUIA>");
                    } else {
                        respuestaXML.append("<GUIA>");
                        respuestaXML.append("<NOGUIA>" + obj.getNoguia() + "</NOGUIA>");
                        respuestaXML.append("<TRANSMITIDO>N</TRANSMITIDO>");
                        respuestaXML.append("</GUIA>");
                    }

                }

            }
            respuestaXML.append("</GUIAS>");
            respuestaXML.append("</TAG>");

            String respuestaCliente = respuestaXML.toString();
            byte[] mires = null;
            try {
                mires = texe.gzip(respuestaCliente);
            } catch (Exception e) {
                System.out.println("Error al crear el array de bytes de respuesta efectiva.");
                e.printStackTrace();
            }
            System.out.println("******SALIENDO DEL  SERVICIO SINCRONIZACIONGUIAS******");
            return mires;
        } catch (Exception e) {
            System.out.println("Error al usar el metodo ungzip en la operacion sincronizacionGuias.");
            e.printStackTrace();
            byte[] mires = null;
            String respuestaError = "9999";
            try {
                mires = texe.gzip(respuestaError);
            } catch (Exception ex) {
                System.out.println("Error al crear el array de bytes de respuesta error, metodo SINCRONIZACIONGUIAS.");
                ex.printStackTrace();
            }
            System.out.println("******SALIENDO DEL  SERVICIO SINCRONIZACIONGUIAS******" + new Date());
            return mires;

        }

    }
}
