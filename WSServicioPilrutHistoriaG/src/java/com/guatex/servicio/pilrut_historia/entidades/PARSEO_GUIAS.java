/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.servicio.pilrut_historia.entidades;

import com.guatex.servicio.GuiEli.Entidades.GUIAS;
import com.guatex.servicio.GuiEli.Entidades.GUIASDETALLE;
import java.io.ByteArrayInputStream;
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
 * @author CPINEDA
 */
public class PARSEO_GUIAS {
    
    public PARSEO_GUIAS() {
    }
    
    public LinkedList<GUIAS> paseoListaGuias(String xmlentrada) throws ParserConfigurationException, UnsupportedEncodingException, SAXException, IOException {
        LinkedList<GUIAS> listaguias = new LinkedList<>();
        DocumentBuilderFactory factory
                = DocumentBuilderFactory.newInstance();

        //Get the DOM Builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Load and Parse the XML document
        //document contains the complete XML as a Tree.
        //  System.out.println("xml entrada " + xmlentrada);
        InputStream is = new ByteArrayInputStream(xmlentrada.getBytes("UTF-8"));
        Document document = builder.parse(is);
        
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                if (node.getNodeName().equals("GUIAS")) {
                    NodeList childNodesX = node.getChildNodes();
                    for (int j = 0; j < childNodesX.getLength(); j++) {
                        Node nodeX = childNodesX.item(j);
                        if (nodeX instanceof Element) {
                            if (nodeX.getNodeName().equals("GUIA")) {
                                GUIAS objGuias = new GUIAS();
                                NodeList nodelist = nodeX.getChildNodes();
                                for (int jx = 0; jx < nodelist.getLength(); jx++) {
                                    Node nodeX2 = nodelist.item(jx);
                                    if (nodeX2.getNodeName().equals("NOGUIA")) {
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setNoguia(nodeX2.getLastChild().getTextContent().trim());
                                            
                                        }                                        
                                    } else if (nodeX2.getNodeName().equals("FECHA")) {
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setFECHA(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setFECHA("");
                                            
                                        }
                                    } else if (nodeX2.getNodeName().equals("CODREM")) {
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            
                                            objGuias.setCODREM(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setCODREM("");
                                            
                                        }
                                    } else if (nodeX2.getNodeName().equals("NOMREM")) {
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            
                                            objGuias.setNOMREM(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            
                                            objGuias.setNOMREM("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("TELREM")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setTELREM(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setTELREM("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("DIRREM1")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setDIRREM1(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setDIRREM1("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("ZONAREM")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setZONAREM(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setZONAREM("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("DIRREM2")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setDIRREM2(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setDIRREM2("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("CODDES")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setCODDES(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setCODDES("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("NOMDES")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setNomdes(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setNomdes("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("TELDES")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setTELDES(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setTELDES("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("DIRDES1")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setDIRDES1(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setDIRDES1(xmlentrada);
                                        }
                                    } else if (nodeX2.getNodeName().equals("ZONADES")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setZONADES(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setZONADES("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("DIRDES2")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setDIRDES2(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setDIRDES2("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("PTOORI")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setPTOORI(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setPTOORI("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("PTODES")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setPtodes(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setPtodes("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("CODCOB")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setCODCOB(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setCODCOB("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("SERIEFACTURA")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setSERIEFACTURA(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setSERIEFACTURA("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("FACTURA")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setFACTURA(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setFACTURA("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("OBSERVACIONES")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setOBSERVACIONES(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setOBSERVACIONES("");
                                        }
                                    } 
                                    
//                                    else if (nodeX2.getNodeName().equals("P_RECIBIO")) {
//                                        
//                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
//                                            objGuias.setP_RECIBIO(nodeX2.getLastChild().getTextContent().trim());
//                                        } else {
//                                            objGuias.setP_RECIBIO("");
//                                        }
//                                    } else if (nodeX2.getNodeName().equals("P_FECHA")) {
//                                        
//                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
//                                            objGuias.setP_FECHA(nodeX2.getLastChild().getTextContent().trim());
//                                        } else {
//                                            objGuias.setP_FECHA("");
//                                        }
//                                    } else if (nodeX2.getNodeName().equals("P_HORA")) {
//                                        
//                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
//                                            objGuias.setP_HORA(nodeX2.getLastChild().getTextContent().trim());
//                                        } else {
//                                            objGuias.setP_HORA("");
//                                        }
//                                    } else if (nodeX2.getNodeName().equals("P_OPERADOR")) {
//                                        
//                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
//                                            objGuias.setP_OPERADOR(nodeX2.getLastChild().getTextContent().trim());
//                                        } else {
//                                            objGuias.setP_OPERADOR("");
//                                        }
//                                    } else if (nodeX2.getNodeName().equals("P_ESTATUS")) {
//                                        
//                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
//                                            objGuias.setP_ESTATUS(nodeX2.getLastChild().getTextContent().trim());
//                                        } else {
//                                            objGuias.setP_ESTATUS("");
//                                        }
//                                    } else if (nodeX2.getNodeName().equals("P_CEDULA")) {
//                                        
//                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
//                                            objGuias.setP_CEDULA(nodeX2.getLastChild().getTextContent().trim());
//                                        } else {
//                                            objGuias.setP_CEDULA("");
//                                        }
//                                    } 
                                    
                                    else if (nodeX2.getNodeName().equals("OPERADOR")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setOPERADOR(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setOPERADOR("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("TIPTAR")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setTIPTAR(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setTIPTAR("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("DECLARADO")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setDECLARADO(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setDECLARADO("0");
                                        }
                                    } else if (nodeX2.getNodeName().equals("SEGURO")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setSEGURO(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setSEGURO("0");
                                        }
                                    } else if (nodeX2.getNodeName().equals("SERIESEGURO")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setSERIESEGURO(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                         objGuias.setSERIESEGURO("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("FACTURASEGURO")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setFACTURASEGURO(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setFACTURASEGURO("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("PAGOCONTADOSEGURO")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setPAGOCONTADOSEGURO(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setPAGOCONTADOSEGURO("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("FECOPE")) {
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setFECOPE(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setFECOPE("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("HORAOPE")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setHORAOPE(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setHORAOPE("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("FECPOD")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setFECPOD(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setFECPOD("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("HORAPOD")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setHORAOPE(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setHORAOPE("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("COBEX")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setCOBEX(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setCOBEX("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("RECOGEOFICINA")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setRECOGEOFICINA(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setRECOGEOFICINA("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("OPEGAGE")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setOPEGAGE(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setOPEGAGE("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("OPEPAGE")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setOPEPAGE(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setOPEPAGE("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("HORAGAGE")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setHORAGAGE(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setHORAGAGE("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("HORAPAGE")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setHORAPAGE(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setHORAPAGE("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("MNFGUI")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setMNFGUI(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setMNFGUI("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("MNFPOD")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setMNFPOD(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setMNFPOD("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("MNCPORI")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setMNCPORI(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                         objGuias.setMNCPORI("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("MNCPDES")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setMNCPDES(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setMNCPDES("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("ULTIMAMODIFICACION")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setULTIMAMODIFICACION(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setULTIMAMODIFICACION("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("TOTSERV")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setTOTSERV(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setTOTSERV("0");
                                        }
                                    } else if (nodeX2.getNodeName().equals("PAGOCONTADOSER")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setPAGOCONTADOSER(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setPAGOCONTADOSER("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("SERIESER")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setSERIESER(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setSERIESER("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("FACTURASER")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setFACTURASER(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setFACTURASER("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("RUTZONA")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setRUTZONA(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setRUTZONA("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("RUTAENT")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setRUTAENT(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setRUTAENT("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("FECENT")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setFECENT(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setFECENT("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("ENTLATITUD")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setENTLATITUD(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setENTLATITUD("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("ENTLONGITUD")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setENTLONGITUD(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setENTLONGITUD("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("LLAVECLIENTE")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setLLAVECLIENTE(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setLLAVECLIENTE("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("FECPODAGE")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setFECPODAGE(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setFECPODAGE("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("SERIEFACTURACOM")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setSERIEFACTURACOM(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setSERIEFACTURACOM("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("FACTURACOM")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setFACTURACOM(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setFACTURACOM("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("VALORCOM")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setVALORCOM(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setVALORCOM("0");
                                        }
                                    } else if (nodeX2.getNodeName().equals("OPEPWH")) {
                                        
                                        if (nodeX2.getTextContent() != null && !nodeX2.getTextContent().isEmpty()) {
                                            objGuias.setOPEPWH(nodeX2.getLastChild().getTextContent().trim());
                                        } else {
                                            objGuias.setOPEPWH("");
                                        }
                                    } else if (nodeX2.getNodeName().equals("DETALLES")) {
                                        NodeList nodeListG = nodeX2.getChildNodes();
                                        LinkedList<GUIASDETALLE> listaGuiasDetalle = new LinkedList<>();
                                        for (int m = 0; m < nodeListG.getLength(); m++) {
                                            Node nodeX3 = nodeListG.item(m);
                                            if (nodeX3 instanceof Element) {
                                                if (nodeX3.getNodeName().equals("DETALLE")) {
                                                    GUIASDETALLE objGuiasDetalle = new GUIASDETALLE();
                                                    NodeList nodeListG2 = nodeX3.getChildNodes();
                                                    for (int jx3 = 0; jx3 < nodeListG2.getLength(); jx3++) {
                                                        Node nodeX4 = nodeListG2.item(jx3);
                                                        if (nodeX4.getNodeName().equals("NOGUIADET")) {
                                                            if(nodeX4.getTextContent() !=null && !nodeX4.getTextContent().isEmpty()){
                                                                objGuiasDetalle.setNOGUIADET(nodeX4.getLastChild().getTextContent().trim());
                                                            }
                                                        } else if (nodeX4.getNodeName().equals("LINEA")) {
                                                            if(nodeX4.getTextContent() !=null && !nodeX4.getTextContent().isEmpty()){
                                                                objGuiasDetalle.setLINEA(nodeX4.getLastChild().getTextContent().trim());
                                                            }
                                                        } else if (nodeX4.getNodeName().equals("PIEZAS")) {
                                                            if(nodeX4.getTextContent() !=null && !nodeX4.getTextContent().isEmpty()){
                                                                objGuiasDetalle.setPIEZAS(nodeX4.getLastChild().getTextContent().trim());
                                                            }else{
                                                                objGuiasDetalle.setPIEZAS("0");
                                                            }
                                                        } else if (nodeX4.getNodeName().equals("TIPENV")) {
                                                            if(nodeX4.getTextContent() !=null && !nodeX4.getTextContent().isEmpty()){
                                                                objGuiasDetalle.setTIPENV(nodeX4.getLastChild().getTextContent().trim());
                                                            }else{
                                                                objGuiasDetalle.setTIPENV("");
                                                            }
                                                        } else if (nodeX4.getNodeName().equals("PESO")) {
                                                            if(nodeX4.getTextContent() !=null && !nodeX4.getTextContent().isEmpty()){
                                                                objGuiasDetalle.setPESO(nodeX4.getLastChild().getTextContent().trim());
                                                            }else{
                                                                objGuiasDetalle.setPESO("0");
                                                            }
                                                        } else if (nodeX4.getNodeName().equals("TARIFA")) {
                                                            if(nodeX4.getTextContent() !=null && !nodeX4.getTextContent().isEmpty()){
                                                                objGuiasDetalle.setTARIFA(nodeX4.getLastChild().getTextContent().trim());
                                                            }else{
                                                                objGuiasDetalle.setTARIFA("0");
                                                            }
                                                        } else if (nodeX4.getNodeName().equals("MANUAL")) {
                                                            if(nodeX4.getTextContent() !=null && !nodeX4.getTextContent().isEmpty()){
                                                                objGuiasDetalle.setMANUAL(nodeX4.getLastChild().getTextContent().trim());
                                                            }else{
                                                                objGuiasDetalle.setMANUAL("");
                                                            }
                                                        } else if (nodeX4.getNodeName().equals("PBULTOS")) {
                                                            if(nodeX4.getTextContent() !=null && !nodeX4.getTextContent().isEmpty()){
                                                                objGuiasDetalle.setPBULTOS(nodeX4.getLastChild().getTextContent().trim());
                                                            }else{
                                                                objGuiasDetalle.setPBULTOS("0");
                                                            }
                                                        }
                                                    }
                                                    listaGuiasDetalle.add(objGuiasDetalle);
                                                    objGuias.setListaGuiasDetalle(listaGuiasDetalle);
                                                }
                                            }
                                        }
                                    }
                                }
                                listaguias.add(objGuias);
                                
                            }
                        }
                    }
                    
                }
            }
        }
        
        return listaguias;
    }
}
