package services;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServicesTools {

	public static JSONObject ok() {
		return new JSONObject();
	}


	//method ok pour le service Login
	public static JSONObject ok(String id,String login , String key) {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id", id);
			obj.put("login", login);
			obj.put("key", key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	public static JSONObject ok(List post) {
		JSONObject obj = new JSONObject();

		try {
			for(int i = 0 ; i< post.size() ; i++){
				obj.accumulate("post", post.get(i));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	public static JSONObject ok(LinkedList l) {
		JSONObject obj = new JSONObject();
		try {	
			for(int i =0 ; i<l.size();i++){
				obj.accumulate("amis", l.get(i));   
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
     
          public static JSONObject okMess(LinkedList l) {
		JSONObject obj = new JSONObject();
                     JSONObject obj2 = new JSONObject();
		try {	
			for(int i =0 ; i<l.size();i++){
				obj2.put("id", l.get(i));
                                        obj2.put("name", l.get(i));
                                        obj2.put("mess", l.get(i));
                                        obj.accumulate("Message",obj2);
                                        obj2 = new JSONObject();
                                        
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	public static JSONObject statOk(String statAmis){
		JSONObject obj=new JSONObject();
		try{
			obj.put("nbUser",statAmis);
		}
		catch(JSONException e){
			e.printStackTrace();
		}
		return obj;
	}
	
	public static JSONObject listFriendOk(List<List<String>> list){
		JSONObject obj=new JSONObject();
		JSONArray array=new JSONArray();
		JSONObject objUser;
		
		try {
			for(List<String> user : list){
				objUser=new JSONObject();
				objUser.put("idU", user.get(0));
				objUser.put("prenom", user.get(1));
				objUser.put("nom", user.get(2));
				array.put(objUser);
			}
			obj.put("friendList", array);
			return obj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static JSONObject erreur(String mess, int code) {
		JSONObject obj = new JSONObject();
		try {
			obj.put("mess", mess);
			obj.put("code", code);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
