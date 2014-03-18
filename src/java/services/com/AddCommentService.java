package services.com;

import bd.SessionBD;
import bd.com.ComBD;
import java.util.LinkedList;
import org.json.JSONObject;
import services.ControlString;
import services.ErrorL;
import services.ServicesTools;

public class AddCommentService {
	private String key;
	private String idP;
	private String text;

	public AddCommentService(String key,String idP,String text){
		this.key=key;
		this.idP=idP;
		this.text=text;
	}

	public JSONObject service(){
		String idU;
		LinkedList<String> test = new LinkedList<String>();
		test.add(key);
		test.add(idP);
		test.add(text);

		if(!ControlString.controlString(test)){
			return ServicesTools.erreur(ErrorL.getErrorL(1), 1);
		}
		else if(!SessionBD.keyExist(key)){
			return ServicesTools.erreur(ErrorL.getErrorL(2), 2);
		}
		else if(!ComBD.idPExist(idP)){
			return ServicesTools.erreur(ErrorL.getErrorL(3), 3);
		}
		else{
			idU=SessionBD.getIdUser(key);
			if(ComBD.addCom(idP, idU, text)){
				return ServicesTools.ok();
			}
			else{
				return ServicesTools.erreur(ErrorL.getErrorL(4), 4);
			}
		}
	}

	public String toString(){
		return "AddCommentService";
	}
}