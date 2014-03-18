package services.friend;

import bd.SessionBD;
import bd.friend.FriendBD;
import java.util.LinkedList;
import org.json.JSONObject;
import services.ControlString;
import services.ErrorL;
import services.ServicesTools;

/**
 *
 * @author Steph
 */
public class AccFriendService {
	private String key;
	private String idF;
        private String accF;

	public AccFriendService(String key,String idF,String accF){
		this.key=key;
		this.idF=idF;
                this.accF=accF;
	}

	public JSONObject service(){
		String idUser;
		LinkedList<String> test = new LinkedList<String>();
		test.add(key);
		test.add(idF);
                test.add(accF);

		if(!ControlString.controlString(test)){
			return ServicesTools.erreur(ErrorL.getErrorL(1), 1);
		} 
		else if(!SessionBD.keyExist(key)){
			return ServicesTools.erreur(ErrorL.getErrorL(2), 2);
		}
		else if (FriendBD.idFExist(idF)){
			idUser=SessionBD.getIdUser(key);
			if(FriendBD.alreadyFriends(idUser, idF)){
				return ServicesTools.erreur(ErrorL.getErrorL(14), 14);
			}else if(idF.contentEquals(idUser)){
                            return ServicesTools.erreur(ErrorL.getErrorL(15), 15);
                        }
			else if(FriendBD.accFriend(idUser, idF , accF)){
				return ServicesTools.ok();
			} 
			else{
				return ServicesTools.erreur(ErrorL.getErrorL(12), 12);
			}
		} 
		else {
			return ServicesTools.erreur(ErrorL.getErrorL(16), 16);
		}
	}


}