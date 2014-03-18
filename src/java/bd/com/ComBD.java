package bd.com;

import bd.DBStatic;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.bson.types.ObjectId;

public class ComBD {

    public static boolean idPExist(String idP) {
        Mongo mongo;
        boolean b = false;
        try {
            mongo = new Mongo(DBStatic.IP_MONGO, DBStatic.PORT_MONGO);
            DB db = mongo.getDB(DBStatic.BD_MONGO);
            DBCollection collection = db.getCollection(DBStatic.COLLECTION_POST);
            BasicDBObject query = newQuery(idP);
            DBCursor cursor = collection.find(query);
            b = cursor.hasNext();
            mongo.close();
            return b;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean addCom(String idP, String idU, String text) {
        Mongo mongo;
        try {
            mongo = new Mongo(DBStatic.IP_MONGO, DBStatic.PORT_MONGO);
            DB db = mongo.getDB(DBStatic.BD_MONGO);
            DBCollection collection = db.getCollection(DBStatic.COLLECTION_POST);

            BasicDBObject com = newCom(idU, text);
            BasicDBObject query = newQuery(idP);

            DBCursor cursor = collection.find(query);
            BasicDBObject post = (BasicDBObject) cursor.next();

            BasicDBList list = (BasicDBList) post.get("commentaires");
            list.add(com);
            post.put("commentaires", list);

            collection.update(query, post);
            mongo.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static BasicDBObject newCom(String idU, String text) {
        //creation de la cle
        String key = "";
        while (key.length() < 32) {
            int x = (int) (Math.random() * 123);
            if (x >= 65 && x <= 90 || x >= 97 && x <= 122 || x >= 48 && x <= 57) {
                key += (char) x;
            }
        }


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH-mm-ss");
        BasicDBObject com = new BasicDBObject();
        BasicDBList list = new BasicDBList();
        com.put("iduser", idU);
        com.put("id", key);
        com.put("nameuser", bd.SessionBD.getNameUser(idU));
        com.put("date", sdf.format(calendar.getTime()));
        com.put("text", text);
        com.put("pouceL", list);
        com.put("pouceB", list);
        return com;
    }

    private static BasicDBObject newQuery(String idP) {
        BasicDBObject query = new BasicDBObject();
        ObjectId oId = new ObjectId(idP);
        query.put("_id", oId);
        return query;
    }

    public static boolean supCom(String idUser, String idP, String idC) {
        Mongo mongo;
        try {
            mongo = new Mongo(DBStatic.IP_MONGO, DBStatic.PORT_MONGO);
            DB db = mongo.getDB(DBStatic.BD_MONGO);
            DBCollection collection = db.getCollection(DBStatic.COLLECTION_POST);

            BasicDBObject com = new BasicDBObject();
            BasicDBObject query = newQuery(idP);

            DBCursor cursor = collection.find(query);
            BasicDBObject post = (BasicDBObject) cursor.next();

            BasicDBList list = (BasicDBList) post.get("commentaires");

            for (int i = 0; i < list.size(); i++) {
                if (((BasicDBObject) list.get(i)).getString("id").equalsIgnoreCase(idC)) {
                    list.remove(i);
                }
            }

            post.put("commentaires", list);
            collection.update(query, post);

            mongo.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
