package services.com;

import bd.SessionBD;
import bd.com.PostBD;
import java.util.LinkedList;
import org.json.JSONObject;
import services.ControlString;
import services.ErrorL;
import services.ServicesTools;

/**
 *
 * @author Steph
 */
public class AddPostService {
	private String key;
	private String text;
        private String idA;
        private String idH;

	public AddPostService(String key,String idA,String text ,String idH){
		this.key=key;
		this.text=text;
                this.idA=idA;
                this.idH=idH;
	}

	public JSONObject service(){
		LinkedList<String> test = new LinkedList<String>();
		test.add(key);
		test.add(text);
                test.add(idA);
                test.add(idH);
                
		if(!ControlString.controlString(test)){
                        System.out.println(key+text+idA);
			return ServicesTools.erreur(ErrorL.getErrorL(1), 1);
		}
		else if (SessionBD.keyExist(key)){
			if(SessionBD.userExist(idA) && SessionBD.userExist(idH)){
                            if(PostBD.addPost(SessionBD.getIdUser(key), idA, text , idH)){
                                return ServicesTools.ok();
                            }else{
                                return ServicesTools.erreur(ErrorL.getErrorL(12), 12);
                            }
				
			} 
			else{
				return ServicesTools.erreur(ErrorL.getErrorL(13), 13);
			}
		} 
		else {
			return ServicesTools.erreur(ErrorL.getErrorL(2), 2);
		}
	}

}