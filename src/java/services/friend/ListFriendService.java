package services.friend;

import bd.SessionBD;
import bd.friend.ListFriendBD;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import services.ControlString;
import services.ErrorL;
import services.ServicesTools;

public class ListFriendService {

    private String key;
    private String idU;

    public ListFriendService(String key, String idU) {
        this.key = key;
        this.idU = idU;
    }

    public JSONObject service() {
        String idUser;
        List<String> test = new LinkedList<String>();
        test.add(key);
        test.add(idU);

        if (!ControlString.controlString(test)) {

            test.remove(1);
            test.add(key);
            if (!ControlString.controlString(test)) {
                return ServicesTools.erreur(ErrorL.getErrorL(1), 1);
            } else{
                List<String> listID = ListFriendBD.getListIDFriendT(SessionBD.getIdUser(key));
                List<List<String>> listUser = ListFriendBD.getListUserName(listID);
                return ServicesTools.listFriendOk(listUser);
            }

        } else if (!SessionBD.keyExist(key)) {
            return ServicesTools.erreur(ErrorL.getErrorL(2), 2);
        } else if (!SessionBD.userExist(idU)) {
            return ServicesTools.erreur(ErrorL.getErrorL(13), 13);
        } else {
            idUser = SessionBD.getIdUser(key);
            if (idU.equalsIgnoreCase(idUser)) {
                List<String> listID = ListFriendBD.getListIDFriend(idU);
                List<List<String>> listUser = ListFriendBD.getListUserName(listID);
                return ServicesTools.listFriendOk(listUser);
            } else {
                return ServicesTools.erreur(ErrorL.getErrorL(21), 21);
            }
        }

    }
}
