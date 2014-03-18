package services.search;

import bd.SessionBD;
import bd.search.SearchBD;
import java.util.LinkedList;
import org.json.JSONObject;
import services.ControlString;
import services.ErrorL;
import services.ServicesTools;

public class SearchService {

    private String key;
    private String query;
    private String args;

    public SearchService(String key, String query, String args) {
        this.key = key;
        this.query = query;
        this.args = args;
    }

    public JSONObject service() {
        LinkedList<String> test = new LinkedList<String>();
        test.add(key);

        if (!ControlString.controlString(test)) {
            test.remove(0);
            test.add(query);
            test.add(args);
            if (!ControlString.controlString(test)) {
                test.remove(1);
                test.add(query);
                if (!ControlString.controlString(test)) {
                    return ServicesTools.erreur(ErrorL.getErrorL(1), 1);
                } else if (query.equalsIgnoreCase("postAll")) {
                    return ServicesTools.ok(SearchBD.postAll());
                } else {
                    return ServicesTools.erreur(ErrorL.getErrorL(19), 19);
                }
            }
            if (query.equalsIgnoreCase("user")) {
            } else if (query.equalsIgnoreCase("postU")) {
                return ServicesTools.ok(SearchBD.postUO(args));
            } else {
                return ServicesTools.erreur(ErrorL.getErrorL(19), 19);
            }

        } else {
            test.add(query);
            test.add(args);

            if (!ControlString.controlString(test)) {
                return ServicesTools.erreur(ErrorL.getErrorL(1), 1);
            } else if (!SessionBD.keyExist(key)) {
                return ServicesTools.erreur(ErrorL.getErrorL(1), 2);
            } else if (query.equalsIgnoreCase("user")) {
            } else if (query.equalsIgnoreCase("postU")) {
                if (SessionBD.userExist(args)) {
                    return ServicesTools.ok(SearchBD.postU(args));
                } else {
                    return ServicesTools.erreur(ErrorL.getErrorL(13), 13);
                }
            } else if (query.equalsIgnoreCase("postUP")) {
                if (SessionBD.userExist(args)) {
                    return ServicesTools.ok(SearchBD.postUP(args));
                } else {
                    return ServicesTools.erreur(ErrorL.getErrorL(13), 13);
                }
            } else if (query.equalsIgnoreCase("postUF")) {
                if (SessionBD.userExist(args)) {
                    return ServicesTools.ok(SearchBD.postUF(args));
                } else {
                    return ServicesTools.erreur(ErrorL.getErrorL(13), 13);
                }
            } else if (query.equalsIgnoreCase("postAll")) {
                return ServicesTools.ok(SearchBD.postAllCo());
            } else if (query.equalsIgnoreCase("friendU")) {
                if (SessionBD.userExist(args)) {
                    return ServicesTools.ok(SearchBD.userF(args));
                } else {
                    return ServicesTools.erreur(ErrorL.getErrorL(13), 13);
                }
            } else if (query.equalsIgnoreCase("bondU")) {
                String a[] = args.split("&");
                if (SessionBD.userExist(a[0]) && SessionBD.userExist(a[1])) {
                    return ServicesTools.ok(SearchBD.postBond(a[0], a[1]));
                } else {
                    return ServicesTools.erreur(ErrorL.getErrorL(13), 13);
                }
            } else {
                return ServicesTools.erreur(ErrorL.getErrorL(19), 19);
            }

        }
        return null;

    }

    public String toString() {
        return "SearchService";
    }
}