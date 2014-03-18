package services.com;

import bd.SessionBD;
import bd.com.ComBD;
import java.util.LinkedList;
import org.json.JSONObject;
import services.ControlString;
import services.ErrorL;
import services.ServicesTools;

/**
 *
 * @author Steph
 */
public class SupComService {

    private String key;
    private String idP;
    private String idC;

    public SupComService(String key, String idP , String idC) {
        this.key = key;
        this.idP = idP;
        this.idC = idC;
    }

    public JSONObject service() {
        LinkedList<String> test = new LinkedList<String>();
        test.add(key);
        test.add(idP);
        test.add(idC);

        if (!ControlString.controlString(test)) {
            return ServicesTools.erreur(ErrorL.getErrorL(1), 1);
        } else if (SessionBD.keyExist(key)) {
            if (ComBD.idPExist(idP)) {
                if (ComBD.supCom(SessionBD.getIdUser(key), idP , idC)) {
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