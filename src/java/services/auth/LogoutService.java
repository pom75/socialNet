/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services.auth;

import bd.SessionBD;
import java.util.LinkedList;
import org.json.JSONObject;
import services.ControlString;
import services.ErrorL;
import services.ServicesTools;

/**
 *
 * @author Steph
 */
public class LogoutService {

    private String key;

    public LogoutService(String key) {
        this.key = key;
    }

    public JSONObject service() {
        LinkedList<String> test = new LinkedList<String>();
        test.add(key);

        if (!ControlString.controlString(test)) {
            return ServicesTools.erreur(ErrorL.getErrorL(1), 1);
        } else if (SessionBD.keyExist(key)) {
            if (SessionBD.supKey(key)) {
                return ServicesTools.ok();
            }else{
                return ServicesTools.erreur(ErrorL.getErrorL(7), 7);
            }
            
        } else {
            return ServicesTools.erreur(ErrorL.getErrorL(8), 8);
        }
    }

}
