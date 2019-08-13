/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.servicio.pilrut_historia.datos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author CPINEDA
 */
public class ControlDeUpdates {

    int cantidadIntentos;
    int tiempoEspera;

    /*
  * flag que define el resultado de la operacion
  * codes:
  * 0    - success
  * -504 - timeout
     */
    /**
     * @param cantidadIntentos Cantidad de intentos que se quieren llevar a cabo
     * antes de considerar un error de timeout, debe ser un numero entero mayor
     * a 0 sin importar si se quiere ejecutar para siempre o no
     * @param tiempoEspera Cantidad de tiempo de espera en segundos entre cada
     * intento
     */
    public ControlDeUpdates(int cantidadIntentos, int tiempoEspera) {
        this.cantidadIntentos = cantidadIntentos;
        this.tiempoEspera = tiempoEspera;
    }

    /**
     *
     * @param ps PreparedStatement que se quiere ejecutar
     * @param forever Booleano que determina si se quiere intentar la ejecucion
     * del prepared statement por siempre sin tomar en cuanta la cantidad de
     * intentos definida
     * @return
     * @throws Exception
     */
    public int executeUpdatePS(PreparedStatement ps, boolean forever) throws Exception {
        int localCantidadIntentos = cantidadIntentos;

        ps.setQueryTimeout(3);
        while (localCantidadIntentos > 0) {
            try {
                ps.executeUpdate();
                return 0;
            } catch (SQLException ex) {
                if (!ex.getMessage().equalsIgnoreCase("La consulta ha superado el tiempo de espera.")) {
                    throw ex;
                }
            }

            try {
                Thread.sleep(tiempoEspera * 1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (!forever) {
                localCantidadIntentos--;
            }
        }

        return 504;
    }

    /**
     * @param ps PreparedStatement que se quiere ejecutar
     * @param forever Booleano que determina si se quiere intentar la ejecucion
     * del prepared statement por siempre sin tomar en cuanta la cantidad de
     * intentos definida
     * @return
     * @throws Exception
     */
    public int[] executeBatchPS(PreparedStatement ps, boolean forever) throws Exception {
        System.out.println("ingreso al metodo executeBatchPS");
        
        int localCantidadIntentos = cantidadIntentos;
        ps.setQueryTimeout(3);
        while (localCantidadIntentos > 0) {
            try {
                int[] result = ps.executeBatch();
                return result;
            } catch (SQLException ex) {
                if (!ex.getMessage().equalsIgnoreCase("La consulta ha superado el tiempo de espera.")) {
                    throw ex;
                }
                System.out.println("error en el metodo exucuteBatchPS ");
                System.out.println(ex.toString());
            }

            try {
                TimeUnit.SECONDS.sleep(tiempoEspera);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (!forever) {
                localCantidadIntentos--;
            }
        }

        return null;
    }

}
