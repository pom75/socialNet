/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.com;

import bd.DBStatic;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import org.bson.types.ObjectId;


/**
 *
 * @author Steph
 */
public class LikeBD {

    public static boolean add(String key, String idP, String arg) {
        if (arg.equalsIgnoreCase("true")) {
            return like(key, idP);
        } else {
            return unLike(key, idP);
        }
    }

    public static boolean like(String idP, String idU) {
        supLike(idP,idU);
        supUnLike(idP,idU);
        return addLike(idP,idU);
    }

    public static boolean unLike(String idP, String idU) {
        supLike(idP,idU);
        supUnLike(idP,idU);
        return addUnLike(idP,idU);
    }

    private static BasicDBObject newQuery(String idP) {
        BasicDBObject query = new BasicDBObject();
        ObjectId oId = new ObjectId(idP);
        query.put("_id", oId);
        return query;
    }

    public static boolean addLike(String idUser, String idP) {
        Mongo mongo;
        try {
            mongo = new Mongo(DBStatic.IP_MONGO, DBStatic.PORT_MONGO);
            DB db = mongo.getDB(DBStatic.BD_MONGO);
            DBCollection collection = db.getCollection(DBStatic.COLLECTION_POST);

            BasicDBObject com = new BasicDBObject();
            BasicDBObject query = newQuery(idP);

            DBCursor cursor = collection.find(query);
            BasicDBObject post = (BasicDBObject) cursor.next();

            BasicDBList list = (BasicDBList) post.get("pouceL");

            list.add(com.append("idU", idUser));
            post.put("pouceL", list);

            collection.update(query, post);
            mongo.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean addUnLike(String idUser, String idP) {
        Mongo mongo;
        try {
            mongo = new Mongo(DBStatic.IP_MONGO, DBStatic.PORT_MONGO);
            DB db = mongo.getDB(DBStatic.BD_MONGO);
            DBCollection collection = db.getCollection(DBStatic.COLLECTION_POST);

            BasicDBObject com = new BasicDBObject();
            BasicDBObject query = newQuery(idP);

            DBCursor cursor = collection.find(query);
            BasicDBObject post = (BasicDBObject) cursor.next();

            BasicDBList list = (BasicDBList) post.get("pouceB");

            list.add(com.append("idU", idUser));
            post.put("pouceB", list);

            collection.update(query, post);
            mongo.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean supLike(String idUser, String idP) {
        Mongo mongo;
        try {
            mongo = new Mongo(DBStatic.IP_MONGO, DBStatic.PORT_MONGO);
            DB db = mongo.getDB(DBStatic.BD_MONGO);
            DBCollection collection = db.getCollection(DBStatic.COLLECTION_POST);

            BasicDBObject com = new BasicDBObject();
            BasicDBObject query = newQuery(idP);

            DBCursor cursor = collection.find(query);
            BasicDBObject post = (BasicDBObject) cursor.next();

            BasicDBList list = (BasicDBList) post.get("pouceL");

            list.remove(com.append("idU", idUser));
            post.put("pouceL", list);

            collection.update(query, post);
            mongo.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean supUnLike(String idUser, String idP) {
        Mongo mongo;
        try {
            mongo = new Mongo(DBStatic.IP_MONGO, DBStatic.PORT_MONGO);
            DB db = mongo.getDB(DBStatic.BD_MONGO);
            DBCollection collection = db.getCollection(DBStatic.COLLECTION_POST);

            BasicDBObject com = new BasicDBObject();
            BasicDBObject query = newQuery(idP);

            DBCursor cursor = collection.find(query);
            BasicDBObject post = (BasicDBObject) cursor.next();

            BasicDBList list = (BasicDBList) post.get("pouceB");

            list.remove(com.append("idU", idUser));
            post.put("pouceB", list);

            collection.update(query, post);
            mongo.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
