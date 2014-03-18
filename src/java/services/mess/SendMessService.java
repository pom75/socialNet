/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services.mess;

/**
 *
 * @author Steph
 */
import bd.SessionBD;
import bd.com.PostBD;
import bd.mess.MessBD;
import java.util.LinkedList;
import org.json.JSONObject;
import services.ControlString;
import services.ErrorL;
import services.ServicesTools;

/**
 *
 * @author Steph
 */
public class SendMessService {

    private String key;
    private String text;
    private String idp;

    public SendMessService(String key, String idp, String text) {
        this.key = key;
        this.text = text;
        this.idp = idp;
    }

    public JSONObject service() {
        LinkedList<String> test = new LinkedList<String>();
        test.add(key);
        test.add(text);
        test.add(idp);


        //Un argument vide
        if (!ControlString.controlString(test)) {
            return ServicesTools.erreur(ErrorL.getErrorL(1), 1);
        } //Si la cle est valide et quelel existe
        else if (SessionBD.keyExist(key)) {

            //Si l'id du destinataire existe
            if (SessionBD.userExist(idp)) {
                if (MessBD.addMess(SessionBD.getIdUser(key), idp, text)) {
                    return ServicesTools.ok();
                } else {
                    return ServicesTools.erreur(ErrorL.getErrorL(12), 12);
                }

            } else {
                return ServicesTools.erreur(ErrorL.getErrorL(13), 13);
            }
        } else {
            return ServicesTools.erreur(ErrorL.getErrorL(2), 2);
        }
    }
}