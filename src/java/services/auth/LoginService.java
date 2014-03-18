package services.auth;

import bd.SessionBD;
import bd.auth.AuthBD;
import java.util.LinkedList;
import org.json.JSONObject;
import services.ControlString;
import services.ErrorL;
import services.ServicesTools;

public class LoginService {

    private String login;
    private String pass;
    private String ip;

    public LoginService(String login, String pass,String ip) {
        this.login = login;
        this.pass = pass;
        this.ip=ip;
    }

    public JSONObject service() {
        LinkedList<String> test = new LinkedList<String>();
        test.add(login);
        test.add(pass);

        //Test des log entrer
        if (!ControlString.controlString(test)) {
            return ServicesTools.erreur(ErrorL.getErrorL(1), 1);
        } else {
            //On recupere iduser et login apres avoir tester les log dans la bd
            test = AuthBD.loginSql(login, pass);
            //Si les login ne son pas bon false se trouve a la case 0
            if (test.get(0).equalsIgnoreCase("false")) {
                return ServicesTools.erreur(ErrorL.getErrorL(5), 5);
            } else {
                String key;
                try {
                    //On cree et ajoue la cle dans la bd puis on la recupere
                    key = SessionBD.creatInsertKey(test.get(0));
                    //On ajoute l'ip de l'user dans la bd
                    AuthBD.addIp(test.get(0), ip);
                    return ServicesTools.ok(test.get(0) , test.get(1) , key);
                } catch (Exception e) {
                    return ServicesTools.erreur(ErrorL.getErrorL(6),6);
                }
                
            }
        }
    }
}
