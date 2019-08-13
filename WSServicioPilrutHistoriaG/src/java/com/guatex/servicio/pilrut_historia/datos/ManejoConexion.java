/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.servicio.pilrut_historia.datos;

import java.io.IOException;
import java.nio.CharBuffer;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author CPINEDA
 */
public class ManejoConexion {

    public ManejoConexion() {
    }

    /**
     * Este motodo es para el envio de queri usando AddBack y retorne la
     * respuesta que este haya obtenido, Con ello manejarla del lado que fue
     * usada.
     */
    public int executeUpdate(PreparedStatement ps) {
        int respuesta = 0;
        PreparedStatement psr = ps;
        try {
            respuesta = psr.executeUpdate();
            return respuesta;
        } catch (SQLException e) {
            System.out.println("Error en el metodo excuteUpdate.");
            e.printStackTrace();
            if (e.getErrorCode() == 1205) {
                executeUpdate(psr);
            }
            return respuesta;
        }

    }

    /**
     *
     */
    public int[] executeBatchPS(PreparedStatement ps) {
        PreparedStatement psr = ps;

        try {
            int[] res = ps.executeBatch();
            if (res.length > 0) {
                return res;
            } else {
                return res;
            }
        } catch (SQLException e) {
            System.out.println("Error executeBatchPS.");
            e.printStackTrace();
            if (e.getErrorCode() == 1205) {
                executeBatchPS(psr);
                return null;
            } else {
                return null;
            }

        }

    }
}
