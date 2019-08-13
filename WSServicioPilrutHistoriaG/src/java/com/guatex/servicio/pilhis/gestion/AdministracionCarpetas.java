/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.servicio.pilhis.gestion;

import java.io.File;

/**
 *
 * @author JLAM
 */
public class AdministracionCarpetas {

    private final static String UNIDAD = "C";
    private final static String RUTA_PRIMARIA = UNIDAD + ":\\MTRPILHIS_WS\\";
    private final static String RUTA_LOGS_WS = RUTA_PRIMARIA + "\\LOGS_WS\\";

    public static void LimpiarDirectorios() {
        File DirectorioArchivo = new File(RUTA_PRIMARIA);
        if (DirectorioArchivo.exists()) {
            GenerarCarpetaLogs();

        } else {
            DirectorioArchivo.mkdir();
            GenerarCarpetaLogs();
        }

    }

    private static void GenerarCarpetaLogs() {
        //System.out.println("-----------------generar carpetalogs");
        File DirectorioArchivos = new File(RUTA_LOGS_WS);
        if (!DirectorioArchivos.exists()) {
            DirectorioArchivos.mkdir();
           // System.out.println("No existe el directorio: " + RUTA_LOGS_WS);
        }
        DirectorioArchivos = null;
    }

    private static void Limpiar(String Directorio) {
        File DirectorioArchivos = new File(Directorio);
        File[] Ficheros = DirectorioArchivos.listFiles();
        File Archivo = null;
        if (DirectorioArchivos.exists()) {
            for (File fichero : Ficheros) {
                Archivo = new File(fichero.toString());
                Archivo.delete();
            }
        } else {
            DirectorioArchivos.mkdir();
            //System.out.println("No existe el directorio: " + Directorio);
        }
        Ficheros = null;
        Archivo = null;
        DirectorioArchivos = null;
    }

    public static String getRUTA_PRIMARIA() {
        return RUTA_PRIMARIA;
    }

    public static String getRUTA_LOGS_WS() {
        return RUTA_LOGS_WS;
    }

}
