/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.servicio.GuiEli.CAD;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author CPINEDA
 */
public class CAD {

    public Connection AbrirConexion() {
        Connection conexion = null;
        if (conexion != null) {
            return conexion;
        } else {
            try {
//                Context initContext = new InitialContext();
//                Context envContext = (Context) initContext.lookup("java:/comp/env");
//                DataSource fuente = (DataSource) envContext.lookup("jdbc/SQLServer");
                InitialContext ctx = new InitialContext();
                DataSource dataSource = (DataSource) ctx.lookup("jdbc/SQLServer");
                conexion = dataSource.getConnection();

            } catch (NamingException | SQLException ex) {
                //Informes.addMensaje("- Error de comunicación con el servidor.");
                ex.printStackTrace();
                StringWriter errors = new StringWriter();
                ex.printStackTrace(new PrintWriter(errors));
//                GrabarLoggs.getInstance().grabaLogFileAdministrador(errors.toString());
                conexion = null;

            } finally {
                return conexion;
            }
        }
    }

//    public void CerrarConexion() {
//        if (conexion != null) {
//            try {
//                Conexion.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//        Conexion = null;
//    }

}
