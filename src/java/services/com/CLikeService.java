package services.com;

import bd.SessionBD;
import bd.com.ComBD;
import bd.com.LikeBDC;
import java.util.LinkedList;
import org.json.JSONObject;
import services.ControlString;
import services.ErrorL;
import services.ServicesTools;

public class CLikeService {

    private String key;
    private String idP;
    private String idC;
    private String arg;

    public CLikeService(String key, String idP,String idC , String arg) {
        this.key = key;
        this.idP = idP;
        this.idC = idC;
        this.arg = arg;
    }

    public JSONObject service() {
        String idU;
        LinkedList<String> test = new LinkedList<String>();
        test.add(key);
        test.add(arg);
        test.add(idP);
        test.add(idC);
        
        
        if (!ControlString.controlString(test)) {
            return ServicesTools.erreur(ErrorL.getErrorL(1), 1);
        } else if (!SessionBD.keyExist(key)) {
            return ServicesTools.erreur(ErrorL.getErrorL(2), 2);
        } else if (!ComBD.idPExist(idP)) {
            return ServicesTools.erreur(ErrorL.getErrorL(3), 3);
        } else {
            if (LikeBDC.add(SessionBD.getIdUser(key),idP,idC,arg)) {
                return ServicesTools.ok();
            } else {
                return ServicesTools.erreur(ErrorL.getErrorL(4), 4);
            }
        }
    }

}