/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.servicio.pilrut_historia.datos;

//import com.guatex.servicio.pilhis.gestion.GrabarLoggs;
import com.guatex.servicio.GuiEli.Entidades.E_GUIASELI;
import com.guatex.servicio.GuiEli.Entidades.GUIAS;
import com.guatex.servicio.GuiEli.Entidades.GUIASDETALLE;
import com.guatex.servicio.pilrut_historia.entidades.E_DETSEGUIMIENTO;
import com.guatex.servicio.pilrut_historia.entidades.E_ENCSEGUIMIENTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.guatex.servicio.pilrut_historia.entidades.E_ParseoPilrut;
import com.guatex.servicio.pilrut_historia.entidades.E_ParseoHistoria;
import com.guatex.servicio.pilrut_historia.entidades.E_RespuestaParseo;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author JLAM
 */
public class CapturaDatos {

    private PreparedStatement _Sentencia;
    private ResultSet _Resultado;
    private final CAD _Conexion = new CAD();

    public String InsertDataPilrut(E_RespuestaParseo lista_pilrut) {
        //System.out.println("insertando valores a la tabla OperacionesPrueba, tabla Pilrut ");

        //String res = "999901";
        String res = "1";
        int contador = 0;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            InitialContext ctx = new InitialContext();
            DataSource fuente = (DataSource) ctx.lookup("jdbc/SQLServer");
            con = fuente.getConnection();

            String query = "INSERT INTO PILRUT (T_FECHA, T_HORA, T_RUTA, T_NRUTA, T_ENTREGA1, T_NENTREG1, T_ENTREGA2, T_NENTREG2, T_RECIBE1, T_NRECIBE1, T_RECIBE2, T_NRECIBE2, T_INGEGR, T_NOMANIF, T_EXTRA, T_ENLAZAR, T_FLIQ, T_PTOLIQ, T_SEGUNDOS, T_AYU1, T_AYU2, T_AYU3, T_AYU4, T_ESTACION, T_PLACA, T_BODEGA, T_AUENT2, T_AUREC2, T_AUAYU1, T_AUAYU2, T_AUAYU3, T_AUAYU4, TRANSMITIDO, EMAILRECOENVIADO, EMAILENTREGAENVIADO, XMLRECOLECCION, XMLENTREGA) VALUES (cast(? as datetime), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            st = con.prepareStatement(query);
            for (E_ParseoPilrut pilrut : lista_pilrut.getPilrut()) {

                if (validacionT_NOMANIF_Pilrut(pilrut.getT_NOMANIF()) == true) {
                    st.setString(1, quitaNulo(pilrut.getT_FECHA()));
                    st.setString(2, quitaNulo(pilrut.getT_HORA()));
                    st.setString(3, quitaNulo(pilrut.getT_RUTA()));
                    st.setString(4, quitaNulo(pilrut.getT_NRUTA()));
                    st.setString(5, quitaNulo(pilrut.getT_ENTREGA1()));
                    st.setString(6, quitaNulo(pilrut.getT_NENTREGA1()));
                    st.setString(7, quitaNulo(pilrut.getT_ENTREGA2()));
                    st.setString(8, quitaNulo(pilrut.getT_NENTREGA2()));
                    st.setString(9, quitaNulo(pilrut.getT_RECIBE1()));
                    st.setString(10, quitaNulo(pilrut.getT_NRECIBE1()));
                    st.setString(11, quitaNulo(pilrut.getT_RECIBE2()));
                    st.setString(12, quitaNulo(pilrut.getT_NRECIBE2()));
                    st.setString(13, quitaNulo(pilrut.getT_INGEGR()));
                    st.setString(14, quitaNulo(pilrut.getT_NOMANIF()));
                    st.setString(15, quitaNulo(pilrut.getT_EXTRA()));
                    st.setString(16, quitaNulo(pilrut.getT_ENLAZAR()));
                    st.setString(17, quitaNulo(pilrut.getT_FLIQ()));
                    //st.setString(17, null);
                    st.setString(18, quitaNulo(pilrut.getT_PTOLIQ()));
//            st.setString(19, quitaNulo(pilrut.getCORRELATIVO()));
                    st.setString(19, quitaNulo(pilrut.getT_SEGUNDOS()));
                    st.setString(20, quitaNulo(pilrut.getT_AYU1()));
                    st.setString(21, quitaNulo(pilrut.getT_AYU2()));
                    st.setString(22, quitaNulo(pilrut.getT_AYU3()));
                    st.setString(23, quitaNulo(pilrut.getT_AYU4()));
                    st.setString(24, quitaNulo(pilrut.getT_ESTACION()));
                    st.setString(25, quitaNulo(pilrut.getT_PLACA()));
                    st.setString(26, quitaNulo(pilrut.getT_BODEGA()));
                    st.setString(27, quitaNulo(pilrut.getT_AUENT2()));
                    st.setString(28, quitaNulo(pilrut.getT_AUREC2()));
                    st.setString(29, quitaNulo(pilrut.getT_AUAYU1()));
                    st.setString(30, quitaNulo(pilrut.getT_AUAYU2()));
                    st.setString(31, quitaNulo(pilrut.getT_AUAYU3()));
                    st.setString(32, quitaNulo(pilrut.getT_AUAYU4()));
                    st.setString(33, quitaNulo(pilrut.getTRANSMITIDO()));
                    st.setString(34, quitaNulo(pilrut.getEMAILRECOENVIADO()));
                    st.setString(35, quitaNulo(pilrut.getEMAILENTREGAENVIADO()));
                    st.setString(36, quitaNulo(pilrut.getXMLRECOLECCION()));
                    st.setString(37, quitaNulo(pilrut.getXMLENTREGA()));
                    st.addBatch();

                }

//               contador=0;// para cada insert de los objetos debe de inciar con valor de 0
//               contador ++;
            }

            int[] ins = st.executeBatch();

            // if (ins > 0) {
//            res = "00001";
            res = "0";
            // }

        } catch (NamingException ex) {
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataPilrut/////////////");
            ex.printStackTrace();
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            res = "1";
        } catch (SQLException ex) {
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataPilrut/////////////");
            ex.printStackTrace();
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            res = "2";
        } catch (Exception ex) {
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataPilrut/////////////");
            ex.printStackTrace();
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            res = "3";
        } finally {

            if (rs != null) {
                try {
                    rs.close();

                } catch (SQLException e) {
                }
                rs = null;

            }
            if (st != null) {
                try {
                    st.close();

                } catch (SQLException e) {
                }
                st = null;

            }

            if (con != null) {
                try {
                    con.close();

                } catch (SQLException e) {
                }
                con = null;

            }

        }

        return res;
    }

    //se ha cambiado el E_ParseoHistoria por una lista de historia para verificar si hace el insert por objetos
    public String InsertDataHistoria(E_RespuestaParseo lista_historia) {
        //System.out.println("insertando valores a la tabla OperacionesPrueba, tabla Historia ");

//        String res = "999902";
        String res = "error";
        //int contador=0;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            InitialContext ctx = new InitialContext();
            DataSource fuente = (DataSource) ctx.lookup("jdbc/SQLServer");
            con = fuente.getConnection();

//            String query2 = "INSERT INTO HISTORIA (NOGUIA, NOMANIF, fechahora, PESO, TRANSMITIDO) VALUES ('"+quitaNulo(E_ParseoHistoria.getNOGUIA())+"','"+quitaNulo(E_ParseoHistoria.getNOMANIF())+"','"+quitaNulo(E_ParseoHistoria.getPESO())+"','"+quitaNulo(E_ParseoHistoria.getTRANSMITIDO())+"')";
            //22134848
            String query = "INSERT INTO HISTORIA (NOGUIA, NOMANIF, fechahora, PESO, TRANSMITIDO) VALUES (?,?,CAST(? AS DATETIME),?,?)";
//           INSERT INTO HISTORIA (NOMANIF, fechahora) values ('TON2', cast(? as datetime))
            st = con.prepareStatement(query);
            for (E_ParseoHistoria historia : lista_historia.getHistoria()) {
                // contador=contador+1;
                if (validacionNOMANIF_Historia(historia.getNOGUIA(), historia.getNOMANIF()) == true) {

                    st.setString(1, quitaNulo(historia.getNOGUIA()));
                    st.setString(2, quitaNulo(historia.getNOMANIF()));
                    st.setString(3, quitaNulo(historia.getFechahora()));
                    String elpe = quitaNulo(historia.getPESO());
                    if (elpe.length() == 0 || elpe.toUpperCase().contains("NULL")) {
                        elpe = null;
                    }
                    st.setString(4, elpe);
                    st.setString(5, quitaNulo(historia.getTRANSMITIDO()));
                    st.addBatch();
//               System.out.println("que elemento trae-------->"+historia.getTRANSMITIDO());
                }
            }

            int[] ins = st.executeBatch();
            //if (ins > 0) {
            res = "0";
            //}

        } catch (NamingException ex) {
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
            ex.printStackTrace();
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            res = "error";
        } catch (SQLException ex) {
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
            ex.printStackTrace();
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            res = "error";
        } catch (Exception ex) {
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
            ex.printStackTrace();
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            res = "error";
        } finally {

            if (rs != null) {
                try {
                    rs.close();

                } catch (SQLException e) {
                }
                rs = null;

            }
            if (st != null) {
                try {
                    st.close();

                } catch (SQLException e) {
                }
                st = null;

            }

            if (con != null) {
                try {
                    con.close();

                } catch (SQLException e) {
                }
                con = null;

            }

        }

        return res;

    }

    public boolean validacionT_NOMANIF_Pilrut(String tnomanif) {

        boolean res = false;

        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        // System.out.println("llamo a la validacion pilrut");
        try {

            InitialContext ctx = new InitialContext();
            DataSource fuente = (DataSource) ctx.lookup("jdbc/SQLServer");
            con = fuente.getConnection();

            String query = "SELECT TOP 1 T_NOMANIF FROM PILRUT WHERE T_NOMANIF = ? ";

            st = con.prepareStatement(query);
            //System.err.println("el T_NOMANIF es " + tnomanif);
            st.setString(1, tnomanif);

            rs = st.executeQuery();
            if (rs.next()) {
                res = false;
            } else {

                res = true;

            }

        } catch (NamingException ex) {
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("/////ERROR EN EL METODO: validacionT_NOMANIF_Pilrut/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("ERROR AL VERIFICAR NOMANIF EN PILRUT");
            ex.printStackTrace();
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("NaningException: " + ex.toString());
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////////////////////////////////////");

        } catch (SQLException ex) {
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("/////ERROR EN EL METODO: validacionT_NOMANIF_Pilrut/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("ERROR AL CONECTAR A LA BASE DE DATOS");
            ex.printStackTrace();
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("SQLException: " + ex.toString());
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////////////////////////////////////");

        } catch (Exception ex) {
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("/////ERROR EN EL METODO: validacionT_NOMANIF_Pilrut/////////////");
            ex.printStackTrace();

//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////////////////////////////////////");
        } finally {

            if (rs != null) {
                try {
                    rs.close();

                } catch (SQLException e) {
                }
                rs = null;

            }
            if (st != null) {
                try {
                    st.close();

                } catch (SQLException e) {
                }
                st = null;

            }

            if (con != null) {
                try {
                    con.close();

                } catch (SQLException e) {
                }
                con = null;

            }

        }
        //System.out.println("respuesta de la validacion de PILRUT---"+res);
        return res;

    }

    public boolean validacionNOMANIF_Historia(String tnomanif, String tnoguia) {

        boolean res = false;

        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        // System.out.println("llamo a la validacion historia");
        try {

            InitialContext ctx = new InitialContext();
            DataSource fuente = (DataSource) ctx.lookup("jdbc/SQLServer");
            con = fuente.getConnection();

            String query = "SELECT TOP 1 NOMANIF FROM HISTORIA WHERE NOGUIA =? AND NOMANIF = ? ";

            st = con.prepareStatement(query);
            //System.err.println("el NOMANIF es " + tnomanif);
            st.setString(1, tnomanif);
            st.setString(2, tnoguia);
            rs = st.executeQuery();
            if (rs.next()) {
                res = false;
            } else {
                res = true;
            }

        } catch (NamingException ex) {
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("/////ERROR EN EL METODO: validacionNOMANIF_Historia/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("ERROR AL VERIFICAR NOMANIF Y NOGUIA EN HISTORIA");
            ex.printStackTrace();
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

//            GrabarLoggs.getInstance().grabaLogFileAdministrador("/////ERROR EN EL METODO: validacionNOMANIF_Historia/////////////");
            ex.printStackTrace();
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception ex) {
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("/////ERROR EN EL METODO: validacionNOMANIF_Historia/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
            ex.printStackTrace();
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            if (rs != null) {
                try {
                    rs.close();

                } catch (SQLException e) {
                }
                rs = null;

            }
            if (st != null) {
                try {
                    st.close();

                } catch (SQLException e) {
                }
                st = null;

            }

            if (con != null) {
                try {
                    con.close();

                } catch (SQLException e) {
                }
                con = null;

            }

        }
        // System.out.println("respuesta de la validacion de HISTORIA---"+res);
        return res;

    }

    /**
     * *
     * Metodo para borrar objetos de historia.
     *
     * @param noguia Este parametro es el número de guía a eliminar de Historia.
     * @param nomanif Este parametro es el número de manifiesto asignado a la
     * Historia.
     * @return Retorna una true si el objeto de Historia ha sido eliminado.
     */
    public boolean deleteGuiaHistoria(String noguia, String nomanif) {
        _Sentencia = null;
        _Resultado = null;
        boolean respuesta = false;
        System.out.println("......." + noguia);
        System.out.println("......." + nomanif);
        String query = "DELETE FROM HISTORIA WHERE NOGUIA = ? AND NOMANIF = ?";
        try {

            _Sentencia = _Conexion.AbrirConexion().prepareStatement(query);
            _Sentencia.setString(1, noguia);
            _Sentencia.setString(2, nomanif);
            _Sentencia.addBatch();
            int[] results = _Sentencia.executeBatch();
            //int resultados= _Sentencia.executeUpdate();
            return respuesta = true;
        } catch (Exception e) {
            System.out.println("Error en deleteGuiaHistoria");
            e.printStackTrace();
            return respuesta;
        } finally {
            if (_Sentencia != null) {
                try {
                    _Sentencia.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                _Sentencia = null;
            }
            if (_Resultado != null) {
                try {
                    _Resultado.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                _Resultado = null;
            }
            CerrarConexiones();
        }

    }

    /**
     * *
     * Metodo para borrar objetos de GUIAS.
     *
     * @param noguia Este parametro es el número de guía a eliminar de GUIAS.
     * @return Retorna una true si el objeto de GUIAS ha sido eliminado.
     */
    public boolean delteGuia(String noguia) {
        _Sentencia = null;
        _Resultado = null;
        boolean respuesta = false;
        System.out.println("......." + noguia);

        String query = "DELETE FROM GUIAS WHERE NOGUIA = ? ";
        try {

            _Sentencia = _Conexion.AbrirConexion().prepareStatement(query);
            _Sentencia.setString(1, noguia);

            _Sentencia.addBatch();
            int[] results = _Sentencia.executeBatch();
            //int resultados= _Sentencia.executeUpdate();
            return respuesta = true;
        } catch (Exception e) {
            System.out.println("Error en deleteGuiaHistoria");
            e.printStackTrace();
            return respuesta;
        } finally {
            if (_Sentencia != null) {
                try {
                    _Sentencia.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                _Sentencia = null;
            }
            if (_Resultado != null) {
                try {
                    _Resultado.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                _Resultado = null;
            }
            CerrarConexiones();
        }

    }

    public boolean siExisteGuiaHistoria(String noguia, String nomanif) {

        _Sentencia = null;
        _Resultado = null;

        String query = "SELECT NOGUIA, NOMANIF FROM HISTORIA WHERE NOGUIA = ?  AND NOMANIF = ?";
        try {
            _Sentencia = _Conexion.AbrirConexion().prepareStatement(query);
            _Sentencia.setString(1, noguia);
            _Sentencia.setString(2, nomanif);
            _Resultado = _Sentencia.executeQuery();

            if (_Resultado.next()) {
//                res_dpi.setDPI(dpi.trim());
//                res_dpi.setNOMBRE(_Resultado.getString("NOMBRE"));
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
//            StringWriter errors = new StringWriter();
//            ex.printStackTrace(new PrintWriter(errors));
            //GrabarLoggs.getInstance().grabaLogFileAdministrador(errors.toString());
            return true;
        } finally {
            if (_Sentencia != null) {
                try {
                    _Sentencia.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (_Resultado != null) {
                try {
                    _Resultado.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            CerrarConexiones();
        }

    }

    /**
     * *
     * Este metodo sirve para buscar la guia donde P_RECIBIO, P_FECHA, P_HORA,
     * P_OPERADOR, P_ESTATUS y P_CEDUAL siendo estos 6 campos = null o vacios.
     *
     * @param noguia Este resibe como parametro el número de guiía.
     * @return false si la guia no existe.
     */
    public GUIAS siExisteGuia(String noguia) {

        _Sentencia = null;
        _Resultado = null;
        GUIAS objGuias = new GUIAS();
//        objGuias = null;
//        String query = "SELECT NOGUIA, P_RECIBIO, P_FECHA, P_HORA, P_OPERADOR, P_ESTATUS, P_CEDULA FROM GUIAS WHERE NOGUIA = ? ";
        String query = "SELECT top 10  NOGUIA, P_RECIBIO, convert(varchar,"
                + "ISNULL(P_FECHA,CAST('19000101' AS DATETIME)),112) P_FECHA, P_HORA, P_OPERADOR, P_ESTATUS, P_CEDULA FROM GUIAS "
                + "WHERE NOGUIA=?";
//        String query = "SELECT NOGUIA FROM GUIAS WHERE NOGUIA = ? ";
        try {
            _Sentencia = _Conexion.AbrirConexion().prepareStatement(query);
            _Sentencia.setString(1, noguia);

            _Resultado = _Sentencia.executeQuery();

            if (_Resultado.next()) {

                System.out.println("******" + _Resultado.getString(1));
                System.out.println("" + quitaNulo(_Resultado.getString(2)));
                System.out.println("" + quitaNulo(_Resultado.getString(3)));
                System.out.println("");
                System.out.println("");
                System.out.println("");
                objGuias.setNoguia(quitaNulo(_Resultado.getString(1)));
                objGuias.setP_RECIBIO(quitaNulo(_Resultado.getString(2)));
                objGuias.setP_FECHA(quitaNulo(_Resultado.getString(3)));
                objGuias.setP_HORA(quitaNulo(_Resultado.getString(4)));
                objGuias.setP_OPERADOR(quitaNulo(_Resultado.getString(5)));
                objGuias.setP_ESTATUS(quitaNulo(_Resultado.getString(6)));
                objGuias.setP_CEDULA(quitaNulo(_Resultado.getString(7)));
                return objGuias;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
//            StringWriter errors = new StringWriter();
//            ex.printStackTrace(new PrintWriter(errors));
            //GrabarLoggs.getInstance().grabaLogFileAdministrador(errors.toString());
            return null;
        } finally {
            if (_Sentencia != null) {
                try {
                    _Sentencia.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (_Resultado != null) {
                try {
                    _Resultado.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            CerrarConexiones();
        }
//        return objGuias;
    }

    public boolean siExisteEncSeguimiento(String query, String noguia) {

        _Sentencia = null;
        _Resultado = null;

//        String query = "SELECT NOMBRE FROM DPI WHERE DPI = ?  ";
        try {
            _Sentencia = _Conexion.AbrirConexion().prepareStatement(query);
            _Sentencia.setString(1, noguia);
            _Resultado = _Sentencia.executeQuery();

            if (_Resultado.next()) {
//                res_dpi.setDPI(dpi.trim());
//                res_dpi.setNOMBRE(_Resultado.getString("NOMBRE"));
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
//            StringWriter errors = new StringWriter();
//            ex.printStackTrace(new PrintWriter(errors));
            //GrabarLoggs.getInstance().grabaLogFileAdministrador(errors.toString());
            return true;
        } finally {
            if (_Sentencia != null) {
                try {
                    _Sentencia.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (_Resultado != null) {
                try {
                    _Resultado.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            CerrarConexiones();
        }

    }

    /**
     * Metodo para insertar cada guia que a sido borrada a la tabla HISMOD. Para
     * tener como historial de cada una de las guias que han sido borradas.
     *
     * @param listaGuias Recibe una lista de las guias que se deben insertar en
     * la tabla HISMOD
     * @return Si retorna un número con valor de 1 es porque fue exitoso el
     * insert, de lo contrario puede ser otro número.
     */
    public int insertDataHismod(E_GUIASELI objGuias) {
        int respuesta = 0;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            InitialContext ctx = new InitialContext();
            DataSource fuente = (DataSource) ctx.lookup("jdbc/SQLServer");
            con = fuente.getConnection();

            String query = "INSERT INTO HISMOD (TIPO, NOGUIA, OPERADOR, FECHA, HORA) VALUES (?, ?, ?, CAST(? AS DATETIME), ?)";
            st = con.prepareStatement(query);

            st.setString(1, "ELI");
            st.setString(2, objGuias.getNOGUIA());
            st.setString(3, objGuias.getOPERADOR());
            st.setString(4, objGuias.getFECHA());
            st.setString(5, objGuias.getHORA());
            st.addBatch();

            int[] ins = st.executeBatch();
            if (ins.length > 0) {
                respuesta = 1;
            }
            return respuesta;
        } catch (NamingException e) {
            System.out.println("NamingException, en el metodo insertDataHismod");
            e.printStackTrace();
            return respuesta;
        } catch (SQLException ex) {
            System.out.println("SQLException, en el metodo insertDataHismod");
            ex.printStackTrace();
            return respuesta;
        } catch (Exception ex) {
            System.out.println("Exception, en el metodo insertDataHismod");
            ex.printStackTrace();
            return respuesta;
        } finally {
            if (rs != null) {
                try {
                    rs.close();

                } catch (SQLException e) {
                }
                rs = null;

            }
            if (st != null) {
                try {
                    st.close();

                } catch (SQLException e) {
                }
                st = null;

            }

            if (con != null) {
                try {
                    con.close();

                } catch (SQLException e) {
                }
                con = null;

            }
        }

    }

    public int insertDataEncSeguimiento(E_ENCSEGUIMIENTO objEncSeguimiento) {

//        System.out.println("insertando valores a la tabla EncSeguimiento");
//        String res = "999902";
        String res = "error";
        int idServicio = 0;
        //int contador=0;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            InitialContext ctx = new InitialContext();
            DataSource fuente = (DataSource) ctx.lookup("jdbc/SQLServer");
            con = fuente.getConnection();

//            String query2 = "INSERT INTO HISTORIA (NOGUIA, NOMANIF, fechahora, PESO, TRANSMITIDO) VALUES ('"+quitaNulo(E_ParseoHistoria.getNOGUIA())+"','"+quitaNulo(E_ParseoHistoria.getNOMANIF())+"','"+quitaNulo(E_ParseoHistoria.getPESO())+"','"+quitaNulo(E_ParseoHistoria.getTRANSMITIDO())+"')";
            //22134848
            String query = "INSERT INTO  ENCSEGUIMIENTO (NOGUIA, RESPONSABLE, ESTADO, TIPOSEGUIMIENTO, SOLUCION, FECHA, AGERPT, TELREM, TELDES) \n"
                    + "VALUES (?,?,?,?,?,?,?,?,?) SELECT SCOPE_IDENTITY() as taskID";
//           INSERT INTO HISTORIA (NOMANIF, fechahora) values ('TON2', cast(? as datetime))
            st = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            List<E_DETSEGUIMIENTO> listadet = new LinkedList<>();

            // contador=contador+1;
            st.setString(1, quitaNulo(objEncSeguimiento.getNOGUIA()));
            st.setString(2, quitaNulo(objEncSeguimiento.getRESPONSABLE()));
            st.setString(3, quitaNulo(objEncSeguimiento.getESTADO()));
            st.setString(4, quitaNulo(objEncSeguimiento.getTIPOSEGUIMIENTO()));
            st.setString(5, quitaNulo(objEncSeguimiento.getSOLUCION()));
            st.setString(6, quitaNulo(objEncSeguimiento.getFECHA()));
            st.setString(7, quitaNulo(objEncSeguimiento.getAGERPT()));
            st.setString(8, quitaNulo(objEncSeguimiento.getTELREM()));
            st.setString(9, quitaNulo(objEncSeguimiento.getTELDES()));
            listadet = objEncSeguimiento.getDetSeguiList();
            st.executeUpdate();
            ResultSet rest = st.getGeneratedKeys();
            if (rest != null && rest.next()) {
                idServicio = rest.getInt(1);
                //insertDataDetSeguimiento(listadet, idServicio);
            }
//               System.out.println("que elemento trae-------->"+historia.getTRANSMITIDO());

//            ResultSet retorno = st.executeQuery();
//            if (retorno.next()) {
//                idServicio = retorno.getInt(1);
//                
//            }
            int[] ins = st.executeBatch();
//            if (ins > 0) {
            //res = "0";
//            }

        } catch (NamingException ex) {
            System.out.println("Error en el metodo insertDataEncSeguimiento 1");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
            ex.printStackTrace();
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            res = "error";
        } catch (SQLException ex) {
            System.out.println("Error en el metodo insertDataEncSeguimiento 2");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
            ex.printStackTrace();
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            res = "error";
        } catch (Exception ex) {
            System.out.println("Error en el metodo insertDataEncSeguimiento 3");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
            ex.printStackTrace();
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            res = "error";
        } finally {

            if (rs != null) {
                try {
                    rs.close();

                } catch (SQLException e) {
                }
                rs = null;

            }
            if (st != null) {
                try {
                    st.close();

                } catch (SQLException e) {
                }
                st = null;

            }

            if (con != null) {
                try {
                    con.close();

                } catch (SQLException e) {
                }
                con = null;

            }

        }

        return idServicio;

    }

    public String insertDataDetSeguimiento(List<E_DETSEGUIMIENTO> lista_DetSeguimiento, int idServicio) {
        //System.out.println("insertando valores a la tabla OperacionesPrueba, tabla Historia ");
//        System.out.println("insertando valores a la tabla DetSeguimiento");
//        String res = "999902";
        String res = "error";
        //int contador=0;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            InitialContext ctx = new InitialContext();
            DataSource fuente = (DataSource) ctx.lookup("jdbc/SQLServer");
            con = fuente.getConnection();

//            String query2 = "INSERT INTO HISTORIA (NOGUIA, NOMANIF, fechahora, PESO, TRANSMITIDO) VALUES ('"+quitaNulo(E_ParseoHistoria.getNOGUIA())+"','"+quitaNulo(E_ParseoHistoria.getNOMANIF())+"','"+quitaNulo(E_ParseoHistoria.getPESO())+"','"+quitaNulo(E_ParseoHistoria.getTRANSMITIDO())+"')";
            //22134848
            String query = "INSERT INTO DETSEGUIMIENTO (IDSEGUIMIENTO, USUARIO, FECHAHORA, OBSERVACIONES) \n"
                    + "VALUES (?,?,?,?)";
//           INSERT INTO HISTORIA (NOMANIF, fechahora) values ('TON2', cast(? as datetime))
            st = con.prepareStatement(query);
//            System.out.println("codigo de id servicio generado [" + idServicio + "]");
            for (E_DETSEGUIMIENTO obj : lista_DetSeguimiento) {
                // contador=contador+1;
                st.setInt(1, idServicio);
                st.setString(2, quitaNulo(obj.getUSUARIO()));
                st.setString(3, quitaNulo(obj.getFECHAHORA()));
                st.setString(4, quitaNulo(obj.getOBSERVACIONES()));
                st.addBatch();
//               System.out.println("que elemento trae-------->"+historia.getTRANSMITIDO());

            }

            int[] ins = st.executeBatch();
            //if (ins > 0) {
            res = "0";
            //}

        } catch (NamingException ex) {
            System.out.println("Error en el metodo insertDataDetSeguimiento 1");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
            ex.printStackTrace();
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            res = "error";
        } catch (SQLException ex) {
            System.out.println("Error en el metodo insertDataDetSeguimiento 2");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
            ex.printStackTrace();
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            res = "error";
        } catch (Exception ex) {
            System.out.println("Error en el metodo insertDataDetSeguimiento 3");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
            ex.printStackTrace();
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            res = "error";
        } finally {

            if (rs != null) {
                try {
                    rs.close();

                } catch (SQLException e) {
                }
                rs = null;

            }
            if (st != null) {
                try {
                    st.close();

                } catch (SQLException e) {
                }
                st = null;

            }

            if (con != null) {
                try {
                    con.close();

                } catch (SQLException e) {
                }
                con = null;

            }

        }

        return res;
    }

    public boolean insertGuias(GUIAS obj) {
        boolean respuesta = false;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            InitialContext ctx = new InitialContext();
            DataSource fuente = (DataSource) ctx.lookup("jdbc/SQLServer");
            con = fuente.getConnection();

            String query = "INSERT INTO GUIAS (NOGUIA, FECHA, CODREM, NOMREM, TELREM, DIRREM1, ZONAREM, DIRREM2, CODDES, NOMDES, "
                    + "TELDES, DIRDES1, ZONADES, DIRDES2, PTOORI, PTODES, CODCOB, SERIEFACTURA, FACTURA, OBSERVACIONES, "
                    //                    + "P_RECIBIO, P_FECHA, P_HORA, P_OPERADOR, P_ESTATUS, P_CEDULA, "
                    + "OPERADOR, TIPTAR, DECLARADO, SEGURO, "
                    + "SERIESEGURO, FACTURASEGURO, PAGOCONTADOSEGURO, FECOPE, HORAOPE, FECPOD, HORAPOD, COBEX, RECOGEOFICINA, "
                    + "OPEGAGE, OPEPAGE, HORAGAGE, HORAPAGE, MNFGUI, MNFPOD, MNCPORI, MNCPDES, ULTIMAMODIFICACION, TOTSERV, PAGOCONTADOSER, "
                    + "SERIESER, FACTURASER, RUTZONA, RUTAENT, FECENT, ENTLATITUD, ENTLONGITUD, LLAVECLIENTE, FECPODAGE, SERIEFACTURACOM, "
                    + "FACTURACOM, VALORCOM, OPEPWH)"
                    + "VALUES (?,CAST(? AS DATETIME),?,?,?,?,?,?,?,?, "
                    + "?,?,?,?,?,?,?,?,?,?, "
                    //                    + "?,CAST(? AS DATETIME),?,?,?,?,"
                    + "?,?,?,?, "
                    + "?,?,?,CAST(? AS DATETIME),?,CAST(? AS DATETIME),?,?,?,?, "
                    + "?,?,?,?,?,?,?,CAST(? AS DATETIME),?,?, "
                    + "?,?,?,?,CAST(? AS DATETIME),?,?,?,CAST(? AS DATETIME),?, "
                    + "?,?,?);";

            st = con.prepareStatement(query);

            st.setString(1, quitaNulo(obj.getNoguia()));
            st.setString(2, quitaNulo(obj.getFECHA()));
            st.setString(3, obj.getCODREM());
            st.setString(4, obj.getNOMREM());
            st.setString(5, obj.getTELREM());
            st.setString(6, obj.getDIRREM1());
            st.setString(7, obj.getZONAREM());
            st.setString(8, obj.getDIRREM2());
            st.setString(9, obj.getCODDES());
            st.setString(10, obj.getNomdes());

            st.setString(11, obj.getTELDES());
            st.setString(12, obj.getDIRDES1());
            st.setString(13, obj.getZONADES());
            st.setString(14, obj.getDIRDES2());
            st.setString(15, obj.getPTOORI());
            st.setString(16, obj.getPtodes());
            st.setString(17, obj.getCODCOB());
            st.setString(18, obj.getSERIEFACTURA());
            st.setString(19, obj.getFACTURA());
            st.setString(20, obj.getOBSERVACIONES());

//            st.setString(21, obj.getP_RECIBIO());
//            st.setString(22, obj.getP_FECHA());
//            st.setString(23, obj.getP_HORA());
//            st.setString(24, obj.getP_OPERADOR());
//            st.setString(25, obj.getP_ESTATUS());
//            st.setString(26, obj.getP_CEDULA());
            st.setString(21, obj.getOPERADOR());
            st.setString(22, obj.getTIPTAR());
            st.setString(23, obj.getDECLARADO());
            st.setString(24, obj.getSEGURO());
            st.setString(25, obj.getSERIESEGURO());
            st.setString(26, obj.getFACTURASEGURO());
            st.setString(27, obj.getPAGOCONTADOSEGURO());
            st.setString(28, obj.getFECOPE());
            st.setString(29, obj.getHORAOPE());
            st.setString(30, obj.getFECPOD());

            st.setString(31, obj.getHORAPOD());
            st.setString(32, obj.getCOBEX());
            st.setString(33, obj.getRECOGEOFICINA());
            st.setString(34, obj.getOPEGAGE());
            st.setString(35, obj.getOPEPAGE());
            st.setString(36, obj.getHORAGAGE());
            st.setString(37, obj.getHORAPAGE());
            st.setString(38, obj.getMNFGUI());
            st.setString(39, obj.getMNFPOD());
            st.setString(40, obj.getMNCPORI());

            st.setString(41, obj.getMNCPDES());
            st.setString(42, obj.getULTIMAMODIFICACION());
            st.setString(43, obj.getTOTSERV());
            st.setString(44, obj.getPAGOCONTADOSER());
            st.setString(45, obj.getSERIESER());
            st.setString(46, obj.getFACTURASER());
            st.setString(47, obj.getRUTZONA());
            st.setString(48, obj.getRUTAENT());
            st.setString(49, obj.getFECENT());
            st.setString(50, obj.getENTLATITUD());

            st.setString(51, obj.getENTLONGITUD());
            st.setString(52, obj.getLLAVECLIENTE());
            st.setString(53, obj.getFECPODAGE());
            st.setString(54, obj.getSERIEFACTURACOM());
            st.setString(55, obj.getFACTURACOM());
            st.setString(56, obj.getVALORCOM());
            st.setString(57, obj.getOPEPWH());
            insertGuiasDetalle(obj.getListaGuiasDetalle());
            st.addBatch();

            int[] ins = st.executeBatch();
            if (ins.length > 0) {
                respuesta = true;
            } else {
                respuesta = false;
            }

        } catch (NamingException ex) {
            System.out.println("Error en el metodo insertGuias 1");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
            ex.printStackTrace();
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            respuesta = false;
        } catch (SQLException ex) {
            System.out.println("Error en el metodo insertGuias 2");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
            ex.printStackTrace();
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            respuesta = false;
        } catch (Exception ex) {
            System.out.println("Error en el metodo insertGuias 3");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
            ex.printStackTrace();
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            respuesta = false;
        } finally {

            if (rs != null) {
                try {
                    rs.close();

                } catch (SQLException e) {
                }
                rs = null;

            }
            if (st != null) {
                try {
                    st.close();

                } catch (SQLException e) {
                }
                st = null;

            }

            if (con != null) {
                try {
                    con.close();

                } catch (SQLException e) {
                }
                con = null;

            }

        }

        return respuesta;
    }

    public boolean insertGuiasDetalle(LinkedList<GUIASDETALLE> lista) {
        boolean respuesta = false;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            InitialContext ctx = new InitialContext();
            DataSource fuente = (DataSource) ctx.lookup("jdbc/SQLServer");
            con = fuente.getConnection();

            String query = "INSERT INTO  GUIASDETALLE (NOGUIA, LINEA, PIEZAS, TIPENV, PESO, TARIFA, MANUAL, PBULTOS)"
                    + "VALUES (?,?,?,?,?,?,?,?);";

            st = con.prepareStatement(query);
            for (GUIASDETALLE obj : lista) {
                st.setString(1, obj.getNOGUIADET());
                st.setString(2, obj.getLINEA());
                st.setString(3, obj.getPIEZAS());
                st.setString(4, obj.getTIPENV());
                st.setString(5, obj.getPESO());
                st.setString(6, obj.getTARIFA());
                st.setString(7, obj.getMANUAL());
                st.setString(8, obj.getPBULTOS());
                st.addBatch();
            }
            int[] ins = st.executeBatch();
            if (ins.length > 0) {
                respuesta = true;
            }

        } catch (NamingException ex) {
            System.out.println("Error en el metodo insertGuiasDetalle 1");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
            ex.printStackTrace();
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            respuesta = false;
        } catch (SQLException ex) {
            System.out.println("Error en el metodo insertGuiasDetalle 2");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
            ex.printStackTrace();
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            respuesta = false;
        } catch (Exception ex) {
            System.out.println("Error en el metodo insertGuiasDetalle 3");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
            ex.printStackTrace();
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            respuesta = false;
        } finally {

            if (rs != null) {
                try {
                    rs.close();

                } catch (SQLException e) {
                }
                rs = null;

            }
            if (st != null) {
                try {
                    st.close();

                } catch (SQLException e) {
                }
                st = null;

            }

            if (con != null) {
                try {
                    con.close();

                } catch (SQLException e) {
                }
                con = null;

            }

        }

        return respuesta;
    }

    public boolean existeGuia(String noguia) {
        boolean respuesta = false;

        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String query = "SELECT NOGUIA FROM GUIAS WHERE NOGUIA = ?";
        try {

            InitialContext ctx = new InitialContext();
            DataSource fuente = (DataSource) ctx.lookup("jdbc/SQLServer");
            con = fuente.getConnection();

            st = con.prepareStatement(query);
            st.setString(1, noguia);
            rs = st.executeQuery();
            if (rs.next()) {
                respuesta = true;
                //System.out.println("...respuesta..."+rs.getString(1));
            } else {
                respuesta = false;

            }
        } catch (SQLException ex) {
            System.out.println("error sql existeguia");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("/////ERROR EN EL METODO: validacionT_NOMANIF_Pilrut/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("ERROR AL CONECTAR A LA BASE DE DATOS");
            ex.printStackTrace();
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("SQLException: " + ex.toString());
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////////////////////////////////////");

        } catch (Exception ex) {
            System.out.println("Error metodo existeguia");
            System.out.println(ex.toString());
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("/////ERROR EN EL METODO: validacionT_NOMANIF_Pilrut/////////////");
            ex.printStackTrace();

//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////////////////////////////////////");
        } finally {

            if (rs != null) {
                try {
                    rs.close();

                } catch (SQLException e) {
                }
                rs = null;

            }
            if (st != null) {
                try {
                    st.close();

                } catch (SQLException e) {
                }
                st = null;

            }

            if (con != null) {
                try {
                    con.close();

                } catch (SQLException e) {
                }
                con = null;

            }

        }
        return respuesta;
    }

    public boolean updateGuias(GUIAS obj) {
        boolean respuesta = false;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            InitialContext ctx = new InitialContext();
            DataSource fuente = (DataSource) ctx.lookup("jdbc/SQLServer");
            con = fuente.getConnection();

            String query = "UPDATE GUIAS SET NOGUIA = ?, FECHA= ?, CODREM = ?, NOMREM = ?, TELREM = ?, DIRREM1 = ?, ZONAREM = ?, DIRREM2 = ?,"
                    + "CODDES = ?, NOMDES = ?, TELDES = ?, DIRDES1 = ?, ZONADES = ?, DIRDES2 = ?, PTOORI = ?, PTODES = ?, CODCOB = ?,"
                    + "SERIEFACTURA = ?, FACTURA = ?, OBSERVACIONES = ?, "
                    //                    + "P_RECIBIO = ?, P_FECHA = ?, P_HORA = ?, P_OPERADOR = ?, P_ESTATUS = ?, P_CEDULA = ?, "
                    + "OPERADOR = ?, TIPTAR = ?, DECLARADO = ?, SEGURO = ?, SERIESEGURO = ?, FACTURASEGURO = ?, PAGOCONTADOSEGURO = ?,"
                    + "FECOPE = ?, HORAOPE = ?, FECPOD = ?, HORAPOD = ?, COBEX = ?, RECOGEOFICINA = ?, OPEGAGE = ?, OPEPAGE = ?, HORAGAGE = ?,"
                    + "HORAPAGE = ?, MNFGUI = ?, MNFPOD = ?, MNCPORI = ?, MNCPDES = ?, ULTIMAMODIFICACION = ?, TOTSERV = ?, PAGOCONTADOSER = ?,"
                    + "SERIESER = ?, FACTURASER = ?, RUTZONA = ?, RUTAENT = ?, FECENT = ?, ENTLATITUD = ?, ENTLONGITUD = ?, LLAVECLIENTE = ?, FECPODAGE = ?,"
                    + "SERIEFACTURACOM = ?, FACTURACOM = ?, VALORCOM = ?, OPEPWH= ? "
                    + "WHERE NOGUIA =  ?;";

            st = con.prepareStatement(query);

            st.setString(1, quitaNulo(obj.getNoguia()));
            st.setString(2, quitaNulo(obj.getFECHA()));
            st.setString(3, obj.getCODREM());
            st.setString(4, obj.getNOMREM());
            st.setString(5, obj.getTELREM());
            st.setString(6, obj.getDIRREM1());
            st.setString(7, obj.getZONAREM());
            st.setString(8, obj.getDIRREM2());
            st.setString(9, obj.getCODDES());
            st.setString(10, obj.getNomdes());

            st.setString(11, obj.getTELDES());
            st.setString(12, obj.getDIRDES1());
            st.setString(13, obj.getZONADES());
            st.setString(14, obj.getDIRDES2());
            st.setString(15, obj.getPTOORI());
            st.setString(16, obj.getPtodes());
            st.setString(17, obj.getCODCOB());
            st.setString(18, obj.getSERIEFACTURA());
            st.setString(19, obj.getFACTURA());
            st.setString(20, obj.getOBSERVACIONES());

//            st.setString(21, obj.getP_RECIBIO());
//            st.setString(22, obj.getP_FECHA());
//            st.setString(23, obj.getP_HORA());
//            st.setString(24, obj.getP_OPERADOR());
//            st.setString(25, obj.getP_ESTATUS());
//            st.setString(26, obj.getP_CEDULA());
            st.setString(21, obj.getOPERADOR());
            st.setString(22, obj.getTIPTAR());
            st.setString(23, obj.getDECLARADO());
            st.setString(24, obj.getSEGURO());
            st.setString(25, obj.getSERIESEGURO());
            st.setString(26, obj.getFACTURASEGURO());
            st.setString(27, obj.getPAGOCONTADOSEGURO());
            st.setString(28, obj.getFECOPE());
            st.setString(29, obj.getHORAOPE());
            st.setString(30, obj.getFECPOD());

            st.setString(31, obj.getHORAPOD());
            st.setString(32, obj.getCOBEX());
            st.setString(33, obj.getRECOGEOFICINA());
            st.setString(34, obj.getOPEGAGE());
            st.setString(35, obj.getOPEPAGE());
            st.setString(36, obj.getHORAGAGE());
            st.setString(37, obj.getHORAPAGE());
            st.setString(38, obj.getMNFGUI());
            st.setString(39, obj.getMNFPOD());
            st.setString(40, obj.getMNCPORI());

            st.setString(41, obj.getMNCPDES());
            st.setString(42, obj.getULTIMAMODIFICACION());
            st.setString(43, obj.getTOTSERV());
            st.setString(44, obj.getPAGOCONTADOSER());
            st.setString(45, obj.getSERIESER());
            st.setString(46, obj.getFACTURASER());
            st.setString(47, obj.getRUTZONA());
            st.setString(48, obj.getRUTAENT());
            st.setString(49, obj.getFECENT());
            st.setString(50, obj.getENTLATITUD());

            st.setString(51, obj.getENTLONGITUD());
            st.setString(52, obj.getLLAVECLIENTE());
            st.setString(53, obj.getFECPODAGE());
            st.setString(54, obj.getSERIEFACTURACOM());
            st.setString(55, obj.getFACTURACOM());
            st.setString(56, obj.getVALORCOM());
            st.setString(57, obj.getOPEPWH());
            st.setString(58, obj.getNoguia());

            st.addBatch();

//            int[] ins = st.executeBatch();
//            ControlDeUpdates cu = new ControlDeUpdates(5, 1000);
            ManejoConexion mc = new ManejoConexion();
            int[] ins = mc.executeBatchPS(st);
            if (ins.length > 0) {
                respuesta = true;
                deleteGuiasDetalle(obj.getNoguia());
                insertGuiasDetalle(obj.getListaGuiasDetalle());
            } else {
                respuesta = false;
            }

        } catch (NamingException ex) {
            System.out.println("Error en el metodo updateGuias 1");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
            ex.printStackTrace();
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            respuesta = false;
        } catch (SQLException ex) {
            System.out.println("Error en el metodo updateGuias 2");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
            ex.printStackTrace();
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            respuesta = false;
        } catch (Exception ex) {
            System.out.println("Error en el metodo updateGuias 3");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
            ex.printStackTrace();
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            respuesta = false;
        } finally {

            if (rs != null) {
                try {
                    rs.close();

                } catch (SQLException e) {
                }
                rs = null;

            }
            if (st != null) {
                try {
                    st.close();

                } catch (SQLException e) {
                }
                st = null;

            }

            if (con != null) {
                try {
                    con.close();

                } catch (SQLException e) {
                }
                con = null;

            }

        }

        return respuesta;
    }

    public boolean deleteGuiasDetalle(String noguia) {
        boolean respuesta = false;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            InitialContext ctx = new InitialContext();
            DataSource fuente = (DataSource) ctx.lookup("jdbc/SQLServer");
            con = fuente.getConnection();

            String query = "DELETE FROM GUIASDETALLE WHERE NOGUIA = ?;";

            st = con.prepareStatement(query);
            st.setString(1, noguia);

            st.addBatch();

            int[] ins = st.executeBatch();
            if (ins.length > 0) {
                respuesta = true;
            }

        } catch (NamingException ex) {
            System.out.println("Error en el metodo deleteGuiasDetalle 1");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
            ex.printStackTrace();
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            respuesta = false;
        } catch (SQLException ex) {
            System.out.println("Error en el metodo deleteGuiasDetalle 2");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
            ex.printStackTrace();
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            respuesta = false;
        } catch (Exception ex) {
            System.out.println("Error en el metodo deleteGuiasDetalle 3");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador("////////////ERROR EN EL METODO: InsertDataHistoria/////////////");
//            GrabarLoggs.getInstance().grabaLogFileAdministrador(ex.toString());
            ex.printStackTrace();
//            Logger.getLogger(CapturaDatos.class.getName()).log(Level.SEVERE, null, ex);
            respuesta = false;
        } finally {

            if (rs != null) {
                try {
                    rs.close();

                } catch (SQLException e) {
                }
                rs = null;

            }
            if (st != null) {
                try {
                    st.close();

                } catch (SQLException e) {
                }
                st = null;

            }

            if (con != null) {
                try {
                    con.close();

                } catch (SQLException e) {
                }
                con = null;

            }

        }

        return respuesta;
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

    private void CerrarConexiones() {
        if (_Resultado != null) {
            try {
                _Resultado.close();
            } catch (SQLException ex) {
//                StringWriter errors = new StringWriter();
//                ex.printStackTrace(new PrintWriter(errors));
//                GrabarLoggs.getInstance().grabaLogFileAdministrador(errors.toString());
            }
        }
        _Resultado = null;
        if (_Sentencia != null) {
            try {
                _Sentencia.close();
            } catch (SQLException ex) {
//                StringWriter errors = new StringWriter();
//                ex.printStackTrace(new PrintWriter(errors));
//                GrabarLoggs.getInstance().grabaLogFileAdministrador(errors.toString());

            }
        }
        _Sentencia = null;
        _Conexion.CerrarConexion();
    }

}
