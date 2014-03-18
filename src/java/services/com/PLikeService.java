package services.com;

import bd.SessionBD;
import bd.com.ComBD;
import bd.com.LikeBD;
import java.util.LinkedList;
import org.json.JSONObject;
import services.ControlString;
import services.ErrorL;
import services.ServicesTools;

public class PLikeService {

    private String key;
    private String idP;
    private String arg;

    public PLikeService(String key, String idP, String arg) {
        this.key = key;
        this.idP = idP;
        this.arg = arg;
    }

    public JSONObject service() {
        String idU;
        LinkedList<String> test = new LinkedList<String>();
        test.add(key);
        test.add(arg);
        test.add(idP);
        
        
        
        if (!ControlString.controlString(test)) {
            return ServicesTools.erreur(ErrorL.getErrorL(1), 1);
        } else if (!SessionBD.keyExist(key)) {
            return ServicesTools.erreur(ErrorL.getErrorL(2), 2);
        } else if (!ComBD.idPExist(idP)) {
            return ServicesTools.erreur(ErrorL.getErrorL(3), 3);
        } else {
            if (LikeBD.add(SessionBD.getIdUser(key),idP,arg)) {
                return ServicesTools.ok();
            } else {
                return ServicesTools.erreur(ErrorL.getErrorL(4), 4);
            }
        }
    }

}