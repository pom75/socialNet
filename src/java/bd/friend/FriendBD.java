package bd.friend;

import bd.DBStatic;
import bd.DBTools;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FriendBD {

    public static boolean idFExist(String idF) {
        Connection co;
        ResultSet res = null;
        Statement stm;
        String query;
        boolean b = false;
        try {
            //Connexion a la bd
            co = DBTools.getMySQLConnection();
            stm = co.createStatement();

            query = "SELECT * FROM " + DBStatic.TABLE_USER + " WHERE iduser='" + idF + "';";
            res = stm.executeQuery(query);

            b = res.next();
            //deconnxeion de la bd
            stm.close();
            co.close();
        } catch (Exception e) {
            return false;
        }


        return b;
    }

    public static boolean alreadyFriends(String idU, String idF) {
        Connection co;
        Statement stm;
        String query;
        ResultSet res = null;
        boolean b = false;

        try {
            co = DBTools.getMySQLConnection();
            stm = co.createStatement();

            query = "SELECT DISTINCT * FROM " + DBStatic.TABLE_FRIEND + " WHERE iduser1='" + idU + "' AND iduser2='" + idF + "';";
            res = stm.executeQuery(query);

            b = res.next();

            stm.close();
            co.close();
        } catch (Exception e) {
            System.err.print("Execption: ");
            e.printStackTrace();
            return false;
        }
        return b;
    }

    public static boolean alreadyFriendsT(String idU, String idF) {
        Connection co;
        Statement stm;
        String query;
        ResultSet res = null;
        boolean b = false;

        try {
            co = DBTools.getMySQLConnection();
            stm = co.createStatement();

            query = "SELECT DISTINCT * FROM " + DBStatic.TABLE_FRIENDT + " WHERE iduser1='" + idU + "' AND iduser2='" + idF + "' OR iduser2='" + idU + "' AND iduser1='" + idF + "' ;";
            res = stm.executeQuery(query);

            b = res.next();

            stm.close();
            co.close();
        } catch (Exception e) {
            System.err.print("Execption: ");
            e.printStackTrace();
            return false;
        }
        return b;
    }

    public static boolean addFriend(String idU, String idF) {
        Connection co;
        Statement stm;
        String query;
        ResultSet res;
        boolean b = false;

        try {
            co = DBTools.getMySQLConnection();
            stm = co.createStatement();

            query = "INSERT INTO " + DBStatic.TABLE_FRIENDT + " (idft,iduser1,iduser2) VALUES (NULL,'" + idU + "','" + idF + "')";

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

    public static boolean accFriend(String idU, String idF, String accF) {
        Connection co;
        Statement stm;
        String query;
        ResultSet res;
        boolean b = false;

        try {
            co = DBTools.getMySQLConnection();
            stm = co.createStatement();
            query = "SELECT DISTINCT * FROM " + DBStatic.TABLE_FRIENDT + " WHERE iduser1='" + idF + "' AND iduser2='" + idU + "';";
            res = stm.executeQuery(query);

            b = res.next();

            if (b) {
                if (accF.equalsIgnoreCase("true")) {
                    query = "INSERT INTO " + DBStatic.TABLE_FRIEND + " (idf,iduser1,iduser2) VALUES (NULL,'" + idU + "','" + idF + "')";

                    stm.executeUpdate(query);
                }
                query = "DELETE FROM " + DBStatic.TABLE_FRIENDT + " WHERE iduser1='" + idF + "' AND iduser2='" + idU + "';";;
                stm.executeUpdate(query);
            }

            stm.close();
            co.close();

        } catch (Exception e) {
            System.err.print("Execption: ");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean removeFriendBD(String idU, String idF) {
        Connection co;
        Statement stm;
        String query;
        boolean res = false;
        try {
            co = DBTools.getMySQLConnection();
            stm = co.createStatement();

            query = "DELETE FROM " + DBStatic.TABLE_FRIEND + " WHERE iduser1='" + idU + "' AND iduser2='" + idF + "' OR iduser2='" + idU + "' AND iduser1='" + idF + "';";;
            res = (stm.executeUpdate(query) == 1);
            stm.close();
            co.close();

        } catch (Exception e) {
            System.err.print("Execption: ");
            e.printStackTrace();
        }

        return res;
    }
}