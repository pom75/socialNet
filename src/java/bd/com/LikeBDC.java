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
public class LikeBDC {

    public static boolean add(String key, String idP, String idC, String arg) {
        if (arg.equalsIgnoreCase("true")) {
            return like(key, idP, idC);
            
        } else {
            return unLike(key, idP, idC);
        }
    }

    public static boolean like(String idP, String idU, String idC) {
        supLike(idP, idU, idC);
        supUnLike(idP, idU, idC);
        return addLike(idP, idU, idC);
    }

    public static boolean unLike(String idP, String idU, String idC) {
        supLike(idP, idU, idC);
        supUnLike(idP, idU, idC);
        return addUnLike(idP, idU, idC);
    }

    private static BasicDBObject newQuery(String idP) {
        BasicDBObject query = new BasicDBObject();
        ObjectId oId = new ObjectId(idP);
        query.put("_id", oId);
        return query;
    }

    public static boolean addLike(String idUser, String idP, String idC) {
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
                    BasicDBList list2 = (BasicDBList) ((BasicDBObject) list.get(i)).get("pouceL");
                    list2.add(com.append("idU", idUser));
                    ((BasicDBObject) list.get(i)).put("pouceL", list2);
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

    public static boolean addUnLike(String idUser, String idP, String idC) {
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
                    BasicDBList list2 = (BasicDBList) ((BasicDBObject) list.get(i)).get("pouceB");
                    list2.add(com.append("idU", idUser));
                    ((BasicDBObject) list.get(i)).put("pouceB", list2);
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

    public static boolean supLike(String idUser, String idP,String idC) {
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
                    BasicDBList list2 = (BasicDBList) ((BasicDBObject) list.get(i)).get("pouceL");
                    list2.remove(com.append("idU", idUser));
                    ((BasicDBObject) list.get(i)).put("pouceL", list2);
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

    public static boolean supUnLike(String idUser, String idP,String idC) {
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
                    BasicDBList list2 = (BasicDBList) ((BasicDBObject) list.get(i)).get("pouceB");
                    list2.remove(com.append("idU", idUser));
                    ((BasicDBObject) list.get(i)).put("pouceB", list2);
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
