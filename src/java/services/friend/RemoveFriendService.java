package services.friend;

import bd.SessionBD;
import bd.friend.FriendBD;
import java.util.LinkedList;
import org.json.JSONObject;
import services.ControlString;
import services.ErrorL;
import services.ServicesTools;

public class RemoveFriendService {
	private String key;
	private String idF;

	public RemoveFriendService(String key,String idF){
		this.key=key;
		this.idF=idF;
	}

	public JSONObject service(){
		String idU;
		LinkedList<String> test = new LinkedList<String>();
		test.add(key);
		test.add(idF);

		if(!ControlString.controlString(test)){
			return ServicesTools.erreur(ErrorL.getErrorL(1), 1);
		} 
		else if (!SessionBD.keyExist(key)){
			return ServicesTools.erreur(ErrorL.getErrorL(2), 2);
		}
		else if (FriendBD.idFExist(idF)){
			idU=SessionBD.getIdUser(key);
			if(FriendBD.removeFriendBD(idU, idF)){
				return ServicesTools.ok();
			}
			else{
				return ServicesTools.erreur(ErrorL.getErrorL(18), 18);
			}
		} 
		else {
			return ServicesTools.erreur(ErrorL.getErrorL(16), 16);
		}
	}
}