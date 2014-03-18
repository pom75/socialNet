package bd.friend;

import bd.DBStatic;
import bd.DBTools;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ListFriendBD {

    public static List<String> getListIDFriend(String idU) {
        Connection co;
        Statement stm;
        ResultSet nuplet;
        String query;
        List<String> listId = new LinkedList<String>();
        String iduser1;
        String iduser2;

        try {
            co = DBTools.getMySQLConnection();
            stm = co.createStatement();
            query = "SELECT * FROM " + DBStatic.TABLE_FRIEND + " WHERE iduser1='" + idU + "' OR iduser2='" + idU + "';";
            nuplet = stm.executeQuery(query);
            while (nuplet.next()) {
                iduser1 = nuplet.getString("iduser1");
                iduser2 = nuplet.getString("iduser2");
                if (iduser1.equalsIgnoreCase(idU)) {
                    listId.add(iduser2);
                } else {
                    listId.add(iduser1);
                }
            }
            listId.add(idU);
            stm.close();
            co.close();
            return listId;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<String> getListIDFriendT(String idU) {
        Connection co;
        Statement stm;
        ResultSet nuplet;
        String query;
        List<String> listId = new LinkedList<String>();
        String iduser1;
        String iduser2;

        try {
            co = DBTools.getMySQLConnection();
            stm = co.createStatement();
            query = "SELECT * FROM " + DBStatic.TABLE_FRIENDT + " WHERE  iduser2='" + idU + "';";
            nuplet = stm.executeQuery(query);
            while (nuplet.next()) {
                iduser1 = nuplet.getString("iduser1");
                iduser2 = nuplet.getString("iduser2");
                if (iduser1.equalsIgnoreCase(idU)) {
                    listId.add(iduser2);
                } else {
                    listId.add(iduser1);
                }
            }
            stm.close();
            co.close();
            return listId;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static List<List<String>> getListUserName(List<String> listId) {
        Connection co;
        Statement stm;
        ResultSet nuplet;
        String query;
        List<List<String>> userList = new LinkedList<List<String>>();
        List<String> user;
        try {
            co = DBTools.getMySQLConnection();
            stm = co.createStatement();

            for (String id : listId) {
                user = new LinkedList<String>();
                query = "SELECT * FROM " + DBStatic.TABLE_USER + " WHERE iduser='" + id + "';";
                nuplet = stm.executeQuery(query);
                if (nuplet.next()) {
                    user.add(id);
                    user.add(nuplet.getString("prenom"));
                    user.add(nuplet.getString("nom"));
                    userList.add(user);
                }
            }
            stm.close();
            co.close();
            return userList;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}