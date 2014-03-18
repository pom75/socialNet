/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services.search;

/**
 *
 * @author Steph
 */
import bd.SessionBD;
import bd.friend.FriendBD;
import bd.search.SearchBD;
import java.util.LinkedList;
import org.json.JSONObject;
import services.ControlString;
import services.ErrorL;
import services.ServicesTools;

public class StatsService {

    private String key;

    public StatsService(String key) {
        this.key = key;
    }

    public JSONObject service() {
        String idU;
        LinkedList<String> test = new LinkedList<String>();
        test.add(key);

        if (!ControlString.controlString(test)) {
            return ServicesTools.erreur(ErrorL.getErrorL(1), 1);
        } else if (!SessionBD.keyExist(key)) {
            return ServicesTools.erreur(ErrorL.getErrorL(2), 2);
        } else {
            return ServicesTools.statOk(""+SearchBD.nbU());
        }
    }
}