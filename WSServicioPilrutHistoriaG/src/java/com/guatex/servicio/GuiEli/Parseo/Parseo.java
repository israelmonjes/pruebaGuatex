/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.servicio.GuiEli.Parseo;

import com.guatex.servicio.GuiEli.Entidades.E_GUIASELI;
import com.guatex.servicio.GuiEli.Entidades.E_HISTORIA;
import com.guatex.servicio.pilrut_historia.entidades.E_PRMTRO;
import com.guatex.servicio.pilrut_historia.entidades.E_RespuestaParseo;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author JLAM
 */
public class Parseo {

    LinkedList<E_HISTORIA> listaRetorno = new LinkedList<>();

    public Parseo() {
    }

    public E_RespuestaParseo parseoXmlGuiEli(String xmlrecepcion) throws ParserConfigurationException, UnsupportedEncodingException, SAXException, IOException {
        LinkedList<E_HISTORIA> listaEli = new LinkedList<>();
        E_RespuestaParseo resparseo = new E_RespuestaParseo();
        System.out.println("ingresando al modulo parseo xmlGuiEli");

        System.out.println("xmlobtenido:\n[" + xmlrecepcion + "]");
        DocumentBuilderFactory factory
                = DocumentBuilderFactory.newInstance();

        //Get the DOM Builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Load and Parse the XML document
        //document contains the complete XML as a Tree.
        //  System.out.println("xml entrada " + xmlentrada);
        InputStream is = new ByteArrayInputStream(xmlrecepcion.getBytes("UTF-8"));
        Document document = builder.parse(is);

        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeName().trim().toUpperCase().equals("PRMTRO")) {
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

            } else if (node.getNodeName().trim().toUpperCase().equals("GUIELI")) {
                NodeList nodeListx = node.getChildNodes();
                for (int ix = 0; ix < nodeListx.getLength(); ix++) {
                    Node nodex = nodeListx.item(ix);
                    if (nodex.getNodeName().trim().toUpperCase().equals("REGISTROS")) {

                        NodeList nodeListx2 = nodex.getChildNodes();
                        for (int ix2 = 0; ix2 < nodeListx2.getLength(); ix2++) {

                            Node nodex3 = nodeListx2.item(ix2);
                            if (nodex3.getNodeName().trim().toUpperCase().equals("REGISTRO")) {
                                NodeList nodeListx3 = nodex3.getChildNodes();

                                E_GUIASELI respuestaGuiEli = new E_GUIASELI();

                                for (int ix3 = 0; ix3 < nodeListx3.getLength(); ix3++) {
                                    Node nodex4 = nodeListx3.item(ix3);
                                    if (nodex4.getNodeName().trim().toUpperCase().equals("NOGUIA")) {
                                        if (nodex4.getTextContent() != null) {
                                            respuestaGuiEli.setNOGUIA(nodex4.getTextContent().trim());
                                        } else {
                                            respuestaGuiEli.setNOGUIA("");
                                        }

                                    } else if (nodex4.getNodeName().trim().toUpperCase().equals("NOMANIF")) {
                                        if (nodex4.getTextContent() != null) {
                                            respuestaGuiEli.setNOMANIF(nodex4.getTextContent().trim());
                                        } else {
                                            respuestaGuiEli.setNOMANIF("");
                                        }
                                    }else if (nodex4.getNodeName().trim().toUpperCase().equals("OPERADOR")) {
                                        if (nodex4.getTextContent() != null) {
                                            respuestaGuiEli.setOPERADOR(nodex4.getTextContent().trim());
                                        } else {
                                            respuestaGuiEli.setOPERADOR("");
                                        }
                                    }else if (nodex4.getNodeName().trim().toUpperCase().equals("FECHA")) {
                                        if (nodex4.getTextContent() != null) {
                                            respuestaGuiEli.setFECHA(nodex4.getTextContent().trim());
                                        } else {
                                            respuestaGuiEli.setFECHA("");
                                        }
                                    }else if (nodex4.getNodeName().trim().toUpperCase().equals("HORA")) {
                                        if (nodex4.getTextContent() != null) {
                                            respuestaGuiEli.setHORA(nodex4.getTextContent().trim());
                                        } else {
                                            respuestaGuiEli.setHORA("");
                                        }
                                    }
                                }

                                resparseo.getGuiasEli().add(respuestaGuiEli);

                            }
                        }
                    }
                }

            }
        }

        return resparseo;
    }
    
    

    public LinkedList<E_HISTORIA> getListaRetorno() {
        return listaRetorno;
    }

    public void setListaRetorno(LinkedList<E_HISTORIA> listaRetorno) {
        this.listaRetorno = listaRetorno;
    }

    private static String quitaNulo(String var) {
        String res = "";
        if (var != null && var.trim().length() > 0) {
            res = var.trim();
        } else {
            res = "";
        }
        return res;
    }

}
