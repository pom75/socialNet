/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.search;

import bd.DBStatic;
import bd.DBTools;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Steph
 */
public class SearchBD {

    public static List<DBObject> postU(String idu) {
        Mongo mongo;
        BasicDBObject query = new BasicDBObject();
        List<DBObject> find = null;
        try {
            //Connexion a la base mongo
            mongo = new Mongo("li328.lip6.fr", 27130);
            DB db = mongo.getDB("fe_fe");

            //Recuperation de la collection
            DBCollection collection = db.getCollection(DBStatic.COLLECTION_POST);

            //Recuperation des objets de plus new au plus old
            query.put("iduserP", idu);
            find = collection.find(query).sort(new BasicDBObject("date", -1)).toArray();

            mongo.close();

        } catch (Exception e) {
        }

        return find;

    }

    public static List<DBObject> postUO(String idu) {
        Mongo mongo;
        BasicDBObject query = new BasicDBObject();
        List<DBObject> find = null;
        try {
            //Connexion a la base mongo
            mongo = new Mongo("li328.lip6.fr", 27130);
            DB db = mongo.getDB("fe_fe");

            //Recuperation de la collection
            DBCollection collection = db.getCollection(DBStatic.COLLECTION_POST);

            //Recuperation des objets de plus new au plus old
            query.put("iduserP", idu);
            find = collection.find(query.append("iduserA", idu), new BasicDBObject("commentaires", 0).append("pouceL", 0).append("pouceB", 0)).sort(new BasicDBObject("date", -1)).toArray();

            mongo.close();

        } catch (Exception e) {
        }

        return find;

    }

    public static List<DBObject> postUP(String idu) {
        Mongo mongo;
        List<DBObject> find = null;
        try {
            //Connexion a la base mongo
            mongo = new Mongo("li328.lip6.fr", 27130);
            DB db = mongo.getDB("fe_fe");

            //Recuperation de la collection
            DBCollection collection = db.getCollection(DBStatic.COLLECTION_POST);

            //Recuperation des objets de plus new au plus old
            DBObject clause1 = new BasicDBObject("iduserP", idu);
            DBObject clause2 = new BasicDBObject("iduserA", idu);
            BasicDBList or = new BasicDBList();
            or.add(clause1);
            or.add(clause2);
            DBObject query = new BasicDBObject("$or", or);

            find = collection.find(query).sort(new BasicDBObject("date", -1)).toArray();

            mongo.close();

        } catch (Exception e) {
        }

        return find;

    }

    public static List<DBObject> postUF(String idu) {
        Mongo mongo;
        LinkedList<String> friendU = userF(idu);
        List<DBObject> find = null;


        try {
            //Connexion a la base mongo
            mongo = new Mongo("li328.lip6.fr", 27130);
            DB db = mongo.getDB("fe_fe");

            //Recuperation de la collection
            DBCollection collection = db.getCollection(DBStatic.COLLECTION_POST);


            for (int i = 0; i < friendU.size(); i++) {
                if (i == 0) {
                    find = collection.find(new BasicDBObject("iduserP", friendU.get(i))).sort(new BasicDBObject("date", -1)).toArray();
                }
                find.addAll(collection.find(new BasicDBObject("iduserP", friendU.get(i))).sort(new BasicDBObject("date", -1)).toArray());
            }

            mongo.close();

        } catch (Exception e) {
        }

        return find;

    }

    public static List<DBObject> postBond(String idu1, String idu2) {
        Mongo mongo;
        List<DBObject> find = null;


        try {
            //Connexion a la base mongo
            mongo = new Mongo("li328.lip6.fr", 27130);
            DB db = mongo.getDB("fe_fe");

            //Recuperation de la collection
            DBCollection collection = db.getCollection(DBStatic.COLLECTION_POST);



            find = collection.find(new BasicDBObject("iduserP", idu1).append("iduserA", idu2)).sort(new BasicDBObject("date", -1)).toArray();
            if (find.isEmpty()) {
                find = collection.find(new BasicDBObject("iduserP", idu2).append("iduserA", idu1)).sort(new BasicDBObject("date", -1)).toArray();
            } else {
                find.addAll(collection.find(new BasicDBObject("iduserP", idu2).append("iduserA", idu1)).sort(new BasicDBObject("date", -1)).toArray());
            }



            mongo.close();

        } catch (Exception e) {
        }

        return find;

    }

    public static LinkedList<String> userF(String iduser) {
        Connection con;
        Statement stm;
        ResultSet rep;
        LinkedList<String> res = new LinkedList<String>();

        try {
            //Connexion a la base
            con = DBTools.getMySQLConnection();
            stm = (Statement) con.createStatement();

            //On recupere tous les amis de iduser
            rep = stm.executeQuery("SELECT * FROM " + DBStatic.TABLE_FRIEND + " WHERE iduser1='" + iduser + "'");
            while (rep.next() != false) {
                res.add(rep.getString("iduser2"));
            }
            rep = stm.executeQuery("SELECT * FROM " + DBStatic.TABLE_FRIEND + " WHERE iduser2='" + iduser + "'");
            while (rep.next() != false) {
                res.add(rep.getString("iduser1"));
            }

            //On ferme les connexion
            stm.close();
            con.close();


        } catch (Exception e) {
            res.add("erreur");
        }

        return res;
    }
    
    
       public static int nbU() {
        Connection con;
        Statement stm;
        ResultSet rep;
        LinkedList<String> res = new LinkedList<String>();

        try {
            //Connexion a la base
            con = DBTools.getMySQLConnection();
            stm = (Statement) con.createStatement();

            //On recupere tous les amis de iduser
            rep = stm.executeQuery("SELECT * FROM " + DBStatic.TABLE_USER );
            while (rep.next() != false) {
                res.add(rep.getString("iduser"));
            }

            //On ferme les connexion
            stm.close();
            con.close();


        } catch (Exception e) {
            res.add("erreur");
        }

        return res.size();
    }

    public static List<DBObject> postAll() {
        Mongo mongo;
        BasicDBObject query = new BasicDBObject();
        List<DBObject> find = null;
        try {
            //Connexion a la base mongo
            mongo = new Mongo("li328.lip6.fr", 27130);
            DB db = mongo.getDB("fe_fe");

            //Recuperation de la collection
            DBCollection collection = db.getCollection(DBStatic.COLLECTION_POST);

            query.put("$where", "this.iduserA == this.iduserP");
            find = collection.find(query, new BasicDBObject("commentaires", 0).append("pouceL", 0).append("pouceB", 0)).sort(new BasicDBObject("date", -1)).toArray();

            //Recuperation des objets de plus new au plus old

            mongo.close();

        } catch (Exception e) {
        }

        return find;

    }

    public static List<DBObject> postAllCo() {
        Mongo mongo;
        BasicDBObject query = new BasicDBObject();
        List<DBObject> find = null;
        try {
            //Connexion a la base mongo
            mongo = new Mongo("li328.lip6.fr", 27130);
            DB db = mongo.getDB("fe_fe");

            //Recuperation de la collection
            DBCollection collection = db.getCollection(DBStatic.COLLECTION_POST);

            find = collection.find().sort(new BasicDBObject("date", -1)).toArray();

            //Recuperation des objets de plus new au plus old

            mongo.close();

        } catch (Exception e) {
        }

        return find;

    }
}
