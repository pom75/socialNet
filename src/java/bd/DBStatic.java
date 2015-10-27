/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

public class DBStatic {

    //Otpion connexion
    static String mysql_host = "132.227.201.129:33306";
    static String mysql_username = "fe_fe";
    static String mysql_password = "ferreira";
    static boolean mysql_pooling = true ;
    static String mysql_db = "fe_fe";
    static String token = "CnX26RQOVLgIYINzeF9mFj+i/5+aeDxTD5qbm9mogEaTferKcvUa0MCawwbJVWiQkh9QFS1HEzL3V9kMd06nFw==";
    //tables
    //SQL
    public static final String TABLE_SESSION = "SESSION";
    public static final String TABLE_IP = "IP";
    public static final String TABLE_MESS = "Mess";
    public static final String TABLE_FRIENDT = "FRIENDT";
    public static final String TABLE_FRIEND = "FRIEND";
    public static final String TABLE_USER = "USER";
    //MongoDB
    public static final String COLLECTION_POST = "post";
    public static final String IP_MONGO = "li328.lip6.fr";
    public static final int PORT_MONGO = 27130;
    public static final String BD_MONGO = "fe_fe";
}
