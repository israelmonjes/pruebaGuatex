/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.servicio.pilrut_historia.entidades;

//import com.guatex.servicio.pilhis.gestion.GrabarLoggs;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.guatex.servicio.pilrut_historia.datos.CapturaDatos;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author JLAM
 */
public class E_Parseo {

    public E_Parseo() {
    }

    public E_RespuestaParseo parseoXML(String xmlcad) throws Exception {
        //declaramos un objeto de la clase E_RespuestaParseo = resparseo
        E_RespuestaParseo resparseo = new E_RespuestaParseo();

        try {
            //Get the DOM Builder Factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Get the DOM Builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            //Load and Parse the XML document
            //document contains the complete XML as a Tree.
            //documento envio por el cliente con datos a actualizar.
            InputStream is = new ByteArrayInputStream(xmlcad.getBytes("UTF-8"));
            //System.out.println("is -----viene del cliente [" + xmlcad + "]");

            Document document = builder.parse(is);

            //Iterating through the nodes and extracting the data.
            // System.out.println(document.getDocumentElement().getTagName());
            NodeList nodeList = document.getDocumentElement().getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                //We have encountered an <employee> tag.

                Node node = nodeList.item(i);
                if (node.getNodeName().trim().toUpperCase().equals("PILRUT")) {
                    //System.out.println("Datos para la tabla PILRUT cliente-servidor");

                    NodeList nodeListx = node.getChildNodes();
                    for (int ix = 0; ix < nodeListx.getLength(); ix++) {

                        Node nodex = nodeListx.item(ix);
                        if (nodex.getNodeName().trim().toUpperCase().equals("REGISTROS")) {
                            //System.out.println("ya paso RESGISTROS");

                            NodeList nodeListx2 = nodex.getChildNodes();
                            for (int ix2 = 0; ix2 < nodeListx2.getLength(); ix2++) {
                                //We have encountered an <employee> tag.
                                Node nodex3 = nodeListx2.item(ix2);
                                if (nodex3.getNodeName().trim().toUpperCase().equals("REGISTRO")) {
                                    //se instacion la clase RespuestaParseoPilrut
                                    E_ParseoPilrut respuesta = new E_ParseoPilrut();
                                    // System.out.println("paso a la area de REGISTRO ");

                                    NodeList nodeListx3 = nodex3.getChildNodes();
                                    for (int ix3 = 0; ix3 < nodeListx3.getLength(); ix3++) {

                                        Node nodex4 = nodeListx3.item(ix3);
                                        if (nodex4.getNodeName().trim().toUpperCase().equals("T_FECHA")) {

                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_FECHA(nodex4.getTextContent().trim());
                                                //System.out.println("----------"+respuesta.getT_FECHA());
                                            } else {
                                                respuesta.setT_FECHA("");

                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_HORA")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_HORA(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_HORA("");
                                            }
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_RUTA")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_RUTA(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_RUTA("");
                                            }
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_NRUTA")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_NRUTA(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_NRUTA("");
                                            }
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_ENTREGA1")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_ENTREGA1(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_ENTREGA1("");
                                            }
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_NENTREGA1")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_NENTREGA1(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_NENTREGA1("");
                                            }
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_ENTREGA2")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_ENTREGA2(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_ENTREGA2("");
                                            }
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_NENTREGA2")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_NENTREGA2(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_NENTREGA2("");
                                            }
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_RECIBE1")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_RECIBE1(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_RECIBE1("");
                                            }
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_NRECIBE1")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_NRECIBE1(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_NRECIBE1("");
                                            }
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_RECIBE2")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_RECIBE2(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_RECIBE2("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_NRECIBE2")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_NRECIBE2(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_NRECIBE2("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_INGEGR")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_INGEGR(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_INGEGR("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_NOMANIF")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_NOMANIF(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_NOMANIF("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_EXTRA")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_EXTRA(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_EXTRA("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_ENLAZAR")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_ENLAZAR(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_ENLAZAR("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_FLIQ")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_FLIQ(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_FLIQ("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_PTOLIQ")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_PTOLIQ(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_PTOLIQ("");
                                            }

                                        } /*else if (nodex4.getNodeName().trim().toUpperCase().equals("CORRELATIVO")) {
                                        if (nodex4.getTextContent() != null) {
                                            respuesta.setCORRELATIVO(nodex4.getTextContent().trim());
                                        } else {
                                            respuesta.setCORRELATIVO("");
                                        }

                                    }*/ else if (nodex4.getNodeName().trim().toUpperCase().equals("T_SEGUNDOS")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_SEGUNDOS(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_SEGUNDOS("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_AYU1")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_AYU1(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_AYU1("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_AYU2")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_AYU2(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_AYU2("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_AYU3")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_AYU3(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_AYU3("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_AYU4")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_AYU4(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_AYU4("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_ESTACION")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_ESTACION(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_ESTACION("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_PLACA")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_PLACA(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_PLACA("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_BODEGA")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_BODEGA(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_BODEGA("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_AUENT2")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_AUENT2(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_AUENT2("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_AUREC2")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_AUREC2(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_AUREC2("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_AUAYU1")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_AUAYU1(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_AUAYU1("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_AUAYU2")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_AUAYU2(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_AUAYU2("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_AUAYU3")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_AUAYU3(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_AUAYU3("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("T_AUAYU4")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setT_AUAYU4(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setT_AUAYU4("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("TRANSMITIDO")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setTRANSMITIDO(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setTRANSMITIDO("");

                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("EMAILRECOENVIADO")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setEMAILRECOENVIADO(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setEMAILRECOENVIADO("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("EMAILENTREGAENVIADO")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setEMAILENTREGAENVIADO(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setEMAILENTREGAENVIADO("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("XMLRECOLECCION")) {

                                            if (nodex4.getTextContent() != null) {
                                                String variable = "";
//                                                respuesta.setXMLRECOLECCION(nodex4.getTextContent().trim());
//                                                variable = nodex4.getTextContent().trim();
//                                                //System.out.println("xml manifiesto-----"+nodex4.getTextContent().trim());
//                                                variable = variable.substring(nodex4.getTextContent().trim().indexOf("<XMLRECOLECCION>"), nodex4.getTextContent().trim().indexOf("</XMLRECOLECCION>")).replace("<XMLRECOLECCION>", "");
////                                                  
//                                                System.out.println("variable parse " + variable);
//                                                respuesta.setXMLRECOLECCION(variable);
                                                respuesta.setXMLRECOLECCION(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setXMLRECOLECCION("");
                                            }//hacer los cambios en los seter

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("XMLENTREGA")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuesta.setXMLENTREGA(nodex4.getTextContent().trim());
                                            } else {
                                                respuesta.setXMLENTREGA("");
                                            }

                                        }
                                    }
                                    resparseo.getPilrut().add(respuesta);

//                                 System.out.println("codigo de insersion---->"+envio_lista_Pilrut);
                                }
                            }

                        }
                    }//busca entre los nodos ENTRE EL XML A PARTIR DE HISTORIA

                } else if (node.getNodeName().trim().toUpperCase().equals("HISTORIA")) {
                    NodeList nodeListx = node.getChildNodes();
                    for (int ix = 0; ix < nodeListx.getLength(); ix++) {
                        Node nodex = nodeListx.item(ix);
                        if (nodex.getNodeName().trim().toUpperCase().equals("REGISTROS")) {

                            NodeList nodeListx2 = nodex.getChildNodes();
                            for (int ix2 = 0; ix2 < nodeListx2.getLength(); ix2++) {

                                Node nodex3 = nodeListx2.item(ix2);
                                if (nodex3.getNodeName().trim().toUpperCase().equals("REGISTRO")) {
                                    NodeList nodeListx3 = nodex3.getChildNodes();

                                    E_ParseoHistoria respuestaHistoria = new E_ParseoHistoria();

                                    for (int ix3 = 0; ix3 < nodeListx3.getLength(); ix3++) {
                                        Node nodex4 = nodeListx3.item(ix3);
                                        if (nodex4.getNodeName().trim().toUpperCase().equals("NOGUIA")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuestaHistoria.setNOGUIA(nodex4.getTextContent().trim());
                                            } else {
                                                respuestaHistoria.setNOGUIA("");
                                            }

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("NOMANIF")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuestaHistoria.setNOMANIF(nodex4.getTextContent().trim());
                                            } else {
                                                respuestaHistoria.setNOMANIF("");
                                            }
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("FECHAHORA")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuestaHistoria.setFechahora(nodex4.getTextContent().trim());
                                            } else {
                                                respuestaHistoria.setFechahora("");
                                            }
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("PESO")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuestaHistoria.setPESO(nodex4.getTextContent().trim());
                                            } else {
                                                respuestaHistoria.setPESO("");
                                            }
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("TRANSMITIDO")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuestaHistoria.setTRANSMITIDO(nodex4.getTextContent().trim());
                                            } else {
                                                respuestaHistoria.setTRANSMITIDO("");
                                            }
                                        }
                                    }

                                    resparseo.getHistoria().add(respuestaHistoria);

                                }
                            }
                        }
                    }
                } else if (node.getNodeName().trim().toUpperCase().equals("PRMTRO")) {
                    NodeList nodeListx = node.getChildNodes();
                    for (int ix = 0; ix < nodeListx.getLength(); ix++) {
                        Node nodex = nodeListx.item(ix);
                        if (nodex.getNodeName().trim().toUpperCase().equals("REGISTROS")) {

                            NodeList nodeListx2 = nodex.getChildNodes();
                            for (int ix2 = 0; ix2 < nodeListx2.getLength(); ix2++) {

                                Node nodex3 = nodeListx2.item(ix2);
                                if (nodex3.getNodeName().trim().toUpperCase().equals("REGISTRO")) {
                                    NodeList nodeListx3 = nodex3.getChildNodes();

                                    E_PRMTRO respuestaPrmtro = new E_PRMTRO();

                                    for (int ix3 = 0; ix3 < nodeListx3.getLength(); ix3++) {
                                        Node nodex4 = nodeListx3.item(ix3);
                                        if (nodex4.getNodeName().trim().toUpperCase().equals("AGENCIA")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuestaPrmtro.setAgencia(nodex4.getTextContent().trim());
                                            } else {
                                                respuestaPrmtro.setAgencia("");
                                            }
                                            System.out.println("Agencia " + respuestaPrmtro.getAgencia());

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("PUNTO")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuestaPrmtro.setPunto(nodex4.getTextContent().trim());
                                            } else {
                                                respuestaPrmtro.setPunto("");
                                            }
                                            System.out.println("Punto " + respuestaPrmtro.getPunto());
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("DISTRIB")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuestaPrmtro.setDistrib(nodex4.getTextContent().trim());
                                            } else {
                                                respuestaPrmtro.setDistrib("");
                                            }
                                            System.out.println("Distrib " + respuestaPrmtro.getDistrib());
                                        }
                                    }

                                }
                            }
                        }
                    }

                } else if (node.getNodeName().trim().toUpperCase().equals("ENCSEGUIMIENTO")) {
                    NodeList nodeListx = node.getChildNodes();
                    for (int ix = 0; ix < nodeListx.getLength(); ix++) {
                        Node nodex = nodeListx.item(ix);
                        if (nodex.getNodeName().trim().toUpperCase().equals("REGISTROS")) {

                            NodeList nodeListx2 = nodex.getChildNodes();
                            for (int ix2 = 0; ix2 < nodeListx2.getLength(); ix2++) {

                                Node nodex3 = nodeListx2.item(ix2);
                                if (nodex3.getNodeName().trim().toUpperCase().equals("REGISTRO")) {
                                    NodeList nodeListx3 = nodex3.getChildNodes();

                                    E_ENCSEGUIMIENTO respuestaEncSeguimiento = new E_ENCSEGUIMIENTO();

                                    for (int ix3 = 0; ix3 < nodeListx3.getLength(); ix3++) {
                                        Node nodex4 = nodeListx3.item(ix3);

                                        if (nodex4.getNodeName().trim().toUpperCase().equals("IDSEGUIMIENTO")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuestaEncSeguimiento.setIDSEGUIMIENTO(nodex4.getTextContent().trim());
                                            } else {
                                                respuestaEncSeguimiento.setIDSEGUIMIENTO("");
                                            }
//                                            System.out.println("idseguimiento local " + respuestaEncSeguimiento.getNOGUIA());

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("NOGUIA")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuestaEncSeguimiento.setNOGUIA(nodex4.getTextContent().trim());
                                            } else {
                                                respuestaEncSeguimiento.setNOGUIA("");
                                            }
//                                            System.out.println("Noguia " + respuestaEncSeguimiento.getNOGUIA());

                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("RESPONSABLE")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuestaEncSeguimiento.setRESPONSABLE(nodex4.getTextContent().trim());
                                            } else {
                                                respuestaEncSeguimiento.setRESPONSABLE("");
                                            }
//                                            System.out.println("responsable " + respuestaEncSeguimiento.getRESPONSABLE());
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("ESTADO")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuestaEncSeguimiento.setESTADO(nodex4.getTextContent().trim());
                                            } else {
                                                respuestaEncSeguimiento.setESTADO("");
                                            }
//                                            System.out.println("estado " + respuestaEncSeguimiento.getESTADO());
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("TIPOSEGUIMIENTO")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuestaEncSeguimiento.setTIPOSEGUIMIENTO(nodex4.getTextContent().trim());
                                            } else {
                                                respuestaEncSeguimiento.setTIPOSEGUIMIENTO("");
                                            }
//                                            System.out.println("tiposeguimiento " + respuestaEncSeguimiento.getESTADO());
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("SOLUCION")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuestaEncSeguimiento.setSOLUCION(nodex4.getTextContent().trim());
                                            } else {
                                                respuestaEncSeguimiento.setSOLUCION("");
                                            }
//                                            System.out.println("solucion " + respuestaEncSeguimiento.getSOLUCION());
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("FECHA")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuestaEncSeguimiento.setFECHA(nodex4.getTextContent().trim());
                                            } else {
                                                respuestaEncSeguimiento.setFECHA("");
                                            }
//                                            System.out.println("fecha " + respuestaEncSeguimiento.getFECHA());
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("AGERPT")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuestaEncSeguimiento.setAGERPT(nodex4.getTextContent().trim());
                                            } else {
                                                respuestaEncSeguimiento.setAGERPT("");
                                            }
//                                            System.out.println("AGERPT " + respuestaEncSeguimiento.getAGERPT());
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("TELREM")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuestaEncSeguimiento.setTELREM(nodex4.getTextContent().trim());
                                            } else {
                                                respuestaEncSeguimiento.setTELREM("");
                                            }
//                                            System.out.println("TELREM " + respuestaEncSeguimiento.getTELREM());
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("TELDES")) {
                                            if (nodex4.getTextContent() != null) {
                                                respuestaEncSeguimiento.setTELDES(nodex4.getTextContent().trim());
                                            } else {
                                                respuestaEncSeguimiento.setTELDES("");
                                            }
//                                            System.out.println("TELDES " + respuestaEncSeguimiento.getTELDES());
                                        } else if (nodex4.getNodeName().trim().toUpperCase().equals("DETSEGUIMIENTO")) {
                                            NodeList nodeListX = nodex4.getChildNodes();
                                            for (int j = 0; j < nodeListX.getLength(); j++) {
                                                Node nodeX5 = nodeListX.item(j);
                                                if (nodeX5.getNodeName().trim().toUpperCase().equals("REGISTROS")) {
                                                    NodeList nodeListX2 = nodeX5.getChildNodes();
                                                    //
                                                    List<E_DETSEGUIMIENTO> listaDet = new LinkedList<>();
                                                    for (int j2 = 0; j2 < nodeListX2.getLength(); j2++) {
                                                        Node nodeX6 = nodeListX2.item(j2);
                                                        if (nodeX6.getNodeName().trim().toUpperCase().equals("REGISTRO")) {
                                                            NodeList nodeListX3 = nodeX6.getChildNodes();
                                                            E_DETSEGUIMIENTO objDetSegui = new E_DETSEGUIMIENTO();
                                                            for (int j3 = 0; j3 < nodeListX3.getLength(); j3++) {
                                                                Node nodeX7 = nodeListX3.item(j3);
                                                                if (nodeX7.getNodeName().trim().toUpperCase().equals("USUARIO")) {
                                                                    if (nodeX7.getTextContent() != null) {
                                                                        objDetSegui.setUSUARIO(nodeX7.getTextContent().trim());
                                                                    } else {
                                                                        objDetSegui.setUSUARIO("");
                                                                    }
//                                                                    System.out.println("usuario " + objDetSegui.getUSUARIO());

                                                                } else if (nodeX7.getNodeName().trim().toUpperCase().equals("FECHAHORA")) {
                                                                    if (nodeX7.getTextContent() != null) {
                                                                        objDetSegui.setFECHAHORA(nodeX7.getTextContent().trim());
                                                                    } else {
                                                                        objDetSegui.setFECHAHORA("");
                                                                    }
//                                                                    System.out.println("fecha hora " + objDetSegui.getFECHAHORA());

                                                                } else if (nodeX7.getNodeName().trim().toUpperCase().equals("OBSERVACIONES")) {
                                                                    if (nodeX7.getTextContent() != null) {
                                                                        objDetSegui.setOBSERVACIONES(nodeX7.getTextContent().trim());
                                                                    } else {
                                                                        objDetSegui.setOBSERVACIONES("");
                                                                    }
//                                                                    System.out.println("observaciones " + objDetSegui.getOBSERVACIONES());

                                                                }
                                                            }
                                                            listaDet.add(objDetSegui);

                                                        }

                                                    }
                                                    //agregar el objeto

                                                    respuestaEncSeguimiento.setDetSeguiList(listaDet);
                                                }
                                            }
                                        }
                                    }
                                    //
                                    resparseo.EncSeguimiento.add(respuestaEncSeguimiento);
                                }
                            }
                        }
                    }
                }
            }
            try {
                //enviamos a lista de objetos, y se los pasamos a metodo de inser respectivo
//                CapturaDatos envio_lista_Pilrut = new CapturaDatos();
//                envio_lista_Pilrut.InsertDataPilrut(resparseo);
                CapturaDatos datos = new CapturaDatos();
                //estas instancias estan al incio de la clase, de manera global, para no tener doble instancia de la misma
                E_ParseoPilrut respuestaPilrut1 = new E_ParseoPilrut();
                E_ParseoHistoria respuestaHistoria1 = new E_ParseoHistoria();

                /**
                 * Esta seccion de codigo envia los datos para insertar objetos
                 * de historia y pilrut
                 *
                 */
                if (resparseo.pilrut.size() > 0) {

                    System.out.println("ELEMENTOS INSERTADOS EN LA TABLA DE PILRUT: " + resparseo.pilrut.size());
                    datos.InsertDataPilrut(resparseo);
                } 

                if (resparseo.historia.size() > 0) {
                    System.out.println("ELEMENTOS INSERTADOS EN LA TABLA DE HISTORIA: " + resparseo.historia.size());
                    datos.InsertDataHistoria(resparseo);
                }
                /**
                 * Este codigo no es funcional
                 */
//                if (datos.validacionT_NOMANIF_Pilrut(respuestaPilrut1.getT_NOMANIF()) == true) {
//                    //CapturaDatos envio_lista = new CapturaDatos();
//                    System.out.println("ELEMENTOS INSERTADOS EN LA TABLA DE PILRUT: " + resparseo.pilrut.size());
//                    datos.InsertDataPilrut(resparseo);
//                    //CapturaDatos envio_lista_Historia = new CapturaDatos();
//
//                }
//                if (datos.validacionNOMANIF_Historia(respuestaHistoria1.getNOGUIA(), respuestaHistoria1.getNOMANIF()) == true) {
//                    System.out.println("ELEMENTOS INSERTADOS EN LA TABLA DE HISTORIA: " + resparseo.historia.size());
//                    datos.InsertDataHistoria(resparseo);
//                } else {
//                    resparseo.setError("SI");
//
//                }
                try {
                    //System.out.println("tamaño de objetos a verificar " + resparseo.EncSeguimiento.size());
                    //System.out.println("existen los datos..." + datos.validarEncSeguimiento(resparseo.EncSeguimiento));

                    //System.out.println("------------------tañamo de lista encseguimiento[" + resparseo.EncSeguimiento.size() + "]");
                    //int idservicio= datos.insertDataEncSeguimiento(resparseo);
//                        datos.insertDataDetSeguimiento(resparseo, idservicio);
//                    System.out.println("------------------------------");
                    StringBuilder xmlEncSeguimiento = new StringBuilder();
                    xmlEncSeguimiento.append("<ENCSEGUIMIENTO>");
                    xmlEncSeguimiento.append("<REGISTROS>");
                    int cantidadInsert = 0;
                    for (E_ENCSEGUIMIENTO obj : resparseo.EncSeguimiento) {

                        String query = "SELECT * FROM ENCSEGUIMIENTO WHERE NOGUIA= ? and "
                                + "RESPONSABLE= '" + obj.getRESPONSABLE() + "' and "
//                                + "ESTADO='" + obj.getESTADO() + "' and "
                                + "TIPOSEGUIMIENTO= '" + obj.getTIPOSEGUIMIENTO() + "' and "
//                                + "SOLUCION= '" + obj.getSOLUCION() + "' and "
                                + "FECHA= '" + obj.getFECHA() + "'";
//                                + "AGERPT= '" + obj.getAGERPT() + "' and "
//                                + "TELREM= '" + obj.getTELREM() + "' and "
//                                + "TELDES= '" + obj.getTELDES() + "' ";
//                        System.out.println("noguia..............."+obj.getNOGUIA());
//                        System.out.println("query a preguntar...."+query);
                        //System.out.println(" respuesta del metodo si existe ...."+datos.siExisteEncSeguimiento(query, obj.getNOGUIA()));
                        if (!datos.siExisteEncSeguimiento(query, obj.getNOGUIA())) {
//                            System.out.println("NO existe el objeto con noguia  ...." + obj.getNOGUIA() + "---" + datos.siExisteEncSeguimiento(query, obj.getNOGUIA()));
//                            System.out.println("valor que retorna la fucion insert detSeguimiento " + datos.insertDataDetSeguimiento(obj.getDetSeguiList(), datos.insertDataEncSeguimiento(obj)));
                            datos.insertDataDetSeguimiento(obj.getDetSeguiList(), datos.insertDataEncSeguimiento(obj));
                            xmlEncSeguimiento.append("<REGISTRO>");
                            xmlEncSeguimiento.append("<IDSEGUIMIENTO>" + obj.getIDSEGUIMIENTO() + "</IDSEGUIMIENTO>");
                            xmlEncSeguimiento.append("<NOGUIA>" + obj.getNOGUIA() + "</NOGUIA>");
                            xmlEncSeguimiento.append("<RESPONSABLE>" + obj.getRESPONSABLE() + "</RESPONSABLE>");
//                            xmlEncSeguimiento.append("<ESTADO>" + obj.getESTADO() + "</ESTADO>");
                            xmlEncSeguimiento.append("<TIPOSEGUIMIENTO>" + obj.getTIPOSEGUIMIENTO() + "</TIPOSEGUIMIENTO>");
//                            xmlEncSeguimiento.append("<SOLUCION>" + obj.getSOLUCION() + "</SOLUCION>");
                            xmlEncSeguimiento.append("<FECHA>" + obj.getFECHA() + "</FECHA>");
//                            xmlEncSeguimiento.append("<AGERPT>" + obj.getAGERPT() + "</AGERPT>");
//                            xmlEncSeguimiento.append("<TELREM>" + obj.getTELREM() + "</TELREM>");
//                            xmlEncSeguimiento.append("<TELDES>" + obj.getTELDES() + "</TELDES>");
                            xmlEncSeguimiento.append("<TRANSMITIDO>S</TRANSMITIDO>");
                            xmlEncSeguimiento.append("</REGISTRO>");
                            cantidadInsert++;
                        } else {
//                            System.out.println("***********existe el objeto*********************");
                            xmlEncSeguimiento.append("<REGISTRO>");
                            xmlEncSeguimiento.append("<IDSEGUIMIENTO>" + obj.getIDSEGUIMIENTO() + "</IDSEGUIMIENTO>");
                            xmlEncSeguimiento.append("<NOGUIA>" + obj.getNOGUIA() + "</NOGUIA>");
                            xmlEncSeguimiento.append("<RESPONSABLE>" + obj.getRESPONSABLE() + "</RESPONSABLE>");
//                            xmlEncSeguimiento.append("<ESTADO>" + obj.getESTADO() + "</ESTADO>");
                            xmlEncSeguimiento.append("<TIPOSEGUIMIENTO>" + obj.getTIPOSEGUIMIENTO() + "</TIPOSEGUIMIENTO>");
//                            xmlEncSeguimiento.append("<SOLUCION>" + obj.getSOLUCION() + "</SOLUCION>");
                            xmlEncSeguimiento.append("<FECHA>" + obj.getFECHA() + "</FECHA>");
//                            xmlEncSeguimiento.append("<AGERPT>" + obj.getAGERPT() + "</AGERPT>");
//                            xmlEncSeguimiento.append("<TELREM>" + obj.getTELREM() + "</TELREM>");
//                            xmlEncSeguimiento.append("<TELDES>" + obj.getTELDES() + "</TELDES>");
                            xmlEncSeguimiento.append("<TRANSMITIDO>S</TRANSMITIDO>");
                            xmlEncSeguimiento.append("</REGISTRO>");
                        }

//                        for (E_DETSEGUIMIENTO obj2 : obj.getDetSeguiList()) {
//                            System.out.println("" + obj2.getUSUARIO());
//                            System.out.println("" + obj2.getFECHAHORA());
//                        }
//                        System.out.println("------------------------------");
                    }
                    xmlEncSeguimiento.append("</REGISTROS>");
                    xmlEncSeguimiento.append("</ENCSEGUIMIENTO>");
                    if(cantidadInsert>0){
                        System.out.println("ELEMENTOS INSERTADOS EN LA TABLA DE ENCSEGUIMIENTO: " + cantidadInsert);
                    }
                    
//                    System.out.println("......................" + xmlEncSeguimiento);
                    resparseo.setXmlEncSeguimiento(xmlEncSeguimiento);
                    //System.out.println("existe o no? "+datos.validarEncSeguimiento(resparseo.listaEncSeguimiento));
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error en el objeto de encseguimiento");
                }

            } catch (Exception e) {
//                GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////////////////////////////////////");
//                GrabarLoggs.getInstance().grabaLogFileAdministrador("ERROR AL VALIDAR LOS DATOS PARA LA TABLA DE HISTORIA Y PILRUT ");
                resparseo.setError("SI");
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
//                GrabarLoggs.getInstance().grabaLogFileAdministrador(errors.toString());

//                GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////////////////////////////////////");
            }


        } catch (Exception e) {
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////////////////////////////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("ERROR AL RALIZAR EL PARCEO DEL XML RECIBIDO");
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(errors.toString());
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////////////////////////////////////");
        }

        return resparseo;

    }

    public String quitaNulo(String var) {
        String res = "";
        if (var != null && var.trim().length() > 0) {
            res = var.trim();
        } else {
            res = "";
        }
        return res.trim();
    }

}
