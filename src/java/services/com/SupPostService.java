package services.com;

import bd.SessionBD;
import bd.com.ComBD;
import bd.com.PostBD;
import java.util.LinkedList;
import org.json.JSONObject;
import services.ControlString;
import services.ErrorL;
import services.ServicesTools;

/**
 *
 * @author Steph
 */
public class SupPostService {

    private String key;
    private String idP;

    public SupPostService(String key, String idP) {
        this.key = key;
        this.idP = idP;
    }

    public JSONObject service() {
        LinkedList<String> test = new LinkedList<String>();
        test.add(key);
        test.add(idP);

        if (!ControlString.controlString(test)) {
            return ServicesTools.erreur(ErrorL.getErrorL(1), 1);
        } else if (SessionBD.keyExist(key)) {
            if (ComBD.idPExist(idP)) {
                if (PostBD.supPost(SessionBD.getIdUser(key), idP)) {
                    return ServicesTools.ok();
                } else {
                    return ServicesTools.erreur(ErrorL.getErrorL(12), 12);
                }

            } else {
                return ServicesTools.erreur(ErrorL.getErrorL(3), 3);
            }
        } else {
            return ServicesTools.erreur(ErrorL.getErrorL(2), 2);
        }
    }
}