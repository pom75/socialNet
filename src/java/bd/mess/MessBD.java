/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.mess;

import bd.DBStatic;
import bd.DBTools;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import bd.SessionBD;

/**
 *
 * @author Steph
 */
public class MessBD {

    public static LinkedList<String> getMess(String idu) {
        Connection con;
        Statement stm;
        ResultSet rep;
        LinkedList<String> res = new LinkedList<String>();

        try {
            //Connexion a la base
            con = DBTools.getMySQLConnection();
            stm = (Statement) con.createStatement();

            //On recupere tous les amis de iduser
            rep = stm.executeQuery("SELECT * FROM " + DBStatic.TABLE_MESS + "WHERE idr = '"+idu+"'" );
            while (rep.next() != false) {
                res.add(rep.getString("idp"));
                SessionBD.getNameUser(rep.getString("idp"));
                res.add(rep.getString("mess"));
            }

            //On ferme les connexion
            stm.close();
            con.close();


        } catch (Exception e) {
            res.add("erreur");
        }

        return res;
    }
    
    
    public static boolean addMess(String idr, String idp , String text) {
        Connection co;
        Statement stm;
        String query;
        ResultSet res;
        boolean b = false;

        try {
            co = DBTools.getMySQLConnection();
            stm = co.createStatement();

            query = "INSERT INTO " + DBStatic.TABLE_MESS + " (idp,mess,idr) VALUES ('"+idp +"','" + text + "','" + idr + "')";

            stm.executeUpdate(query);


            stm.close();
            co.close();

        } catch (Exception e) {
            System.err.print("Execption: ");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    
}
