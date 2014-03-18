/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.HashMap;

/**
 *
 * @author Steph
 */
public class ErrorL {
    private static ErrorL singleton;
    private static HashMap map;
    
    /**
     * Liste erreur 
     * 1 : "Un des arguments est vide"
     */
    private ErrorL(){
        map = new HashMap();
        map.put(1,"Un des arguments est vide");
        map.put(2,"key inexistante dans la bd");
        map.put(3,"Post inexistant dans la bd");
        map.put(4,"Commentaire non ajoute dans la bd");
        map.put(5,"Login et/ou Mot de passe incorrecte");
        map.put(6,"Probleme login BD");
        map.put(7,"Probleme Logout BD");
        map.put(8,"Mauvaise cle de logout");
        map.put(9,"Mauvais format mail.");
        map.put(10,"Le login est deja utilise.");
        map.put(11,"Probleme class NewUser");
        map.put(12,"Probleme inserstion dans la BD.");
        map.put(13,"L'iduser entrer n'existe pas");
        map.put(14,"Demande d'amis déja fait");
        map.put(15,"Vous ne pouvez pas vous ajouter en amis");
        map.put(16,"idF inexsitant dans la bd");
        map.put(17,"Cette personne est déja votre amis ou une demande d'amis a déja été envoyé");
        map.put(18,"Probleme suppression dans la bd");
        map.put(19,"Query Inconnue");
        map.put(20,"Image trop grande ( 300ko max)");
        map.put(21, "key et idUser non compatible");
    }
    
    /**
     *
     */
    public static String getErrorL(int i){
        if(singleton==null){
            singleton=new ErrorL();
        }
        return (String) map.get(i);
    }                
}
