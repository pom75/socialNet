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
public class AddFriendService {
	private String key;
	private String idF;

	public AddFriendService(String key,String idF){
		this.key=key;
		this.idF=idF;
	}

	public JSONObject service(){
		String idUser;
		LinkedList<String> test = new LinkedList<String>();
		test.add(key);
		test.add(idF);

		if(!ControlString.controlString(test)){
			return ServicesTools.erreur(ErrorL.getErrorL(1), 1);
		} 
		else if(!SessionBD.keyExist(key)){
			return ServicesTools.erreur(ErrorL.getErrorL(2), 2);
		}
		else if (FriendBD.idFExist(idF)){
			idUser=SessionBD.getIdUser(key);
			if(FriendBD.alreadyFriendsT(idUser, idF)){
				return ServicesTools.erreur(ErrorL.getErrorL(17), 17);
			}else if(idF.contentEquals(idUser)){
                            return ServicesTools.erreur(ErrorL.getErrorL(15), 15);
                        }
			else if(FriendBD.addFriend(idUser, idF)){
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


	public String toString(){
		return "AddFriendService";
	}
}