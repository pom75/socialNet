package bd.com;

import bd.DBStatic;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.bson.types.ObjectId;


public class PostBD {

    public static boolean addPost(String idP, String idA, String text,String idH) {
        Mongo mongo;
        try {
            //Connexion a la base mongo
            mongo = new Mongo(DBStatic.IP_MONGO, DBStatic.PORT_MONGO);
            DB db = mongo.getDB(DBStatic.BD_MONGO);
            //Recuperation de la collection
            DBCollection collection = db.getCollection(DBStatic.COLLECTION_POST);
            //creation du post
            BasicDBObject post = newPost(idP, idA, text,idH);
            //insertion dans la base
            collection.save(post);
            mongo.close();

        } catch (Exception e) {
            return false;
        }

        return true;

    }

    private static BasicDBObject newPost(String idP, String idA, String text,String idH) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH-mm-ss");

        BasicDBObject post = new BasicDBObject();
        post.put("iduserH", idH);
        post.put("nameuserH", bd.SessionBD.getNameUser(idH));
        post.put("iduserP", idP);
        post.put("nameuserP", bd.SessionBD.getNameUser(idP));
        post.put("iduserA", idA);
        post.put("nameuserA", bd.SessionBD.getNameUser(idA));
        post.put("text", text);
        post.put("date", sdf.format(calendar.getTime()));
        BasicDBList list = new BasicDBList();
        post.put("commentaires", list);
        post.put("pouceL", list);
        post.put("pouceB", list);
        return post;
    }

    public static boolean supPost(String idU, String idP) {
        Mongo mongo;
        try {
            //Connexion a la base mongo
            mongo = new Mongo(DBStatic.IP_MONGO, DBStatic.PORT_MONGO);
            DB db = mongo.getDB(DBStatic.BD_MONGO);
            //Recuperation de la collection
            DBCollection collection = db.getCollection(DBStatic.COLLECTION_POST);
            
            BasicDBObject query = newQuery(idP);
            collection.remove(query.append("iduserP", idU));
            
            query = newQuery(idP);
            collection.remove(query.append("iduserA", idU));
            
            mongo.close();

        } catch (Exception e) {
            return false;
        }

        return true;

    }

    private static BasicDBObject newQuery(String idP) {
        BasicDBObject query = new BasicDBObject();
        ObjectId oId = new ObjectId(idP);
        query.put("_id", oId);
        return query;
    }
}
