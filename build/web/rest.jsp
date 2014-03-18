<!doctype html>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

    <head>
        <title> Bienvenue sur Actiz - Accueil </title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-15">
            <meta name="keywords" content="  " />
            <meta name="description" content=" " />
            <meta name="author" content="" />
            <meta name="generator" content="" />
            <meta name="revisit-after" content="0"/>
            <meta name="Language" content="fr"/>
            <meta name="Copyright" content="Null"/>
            <meta name="ROBOTS" content="INDEX"/>
            <link rel="icon" type="image/png" href="img/favicon.png"  />
            <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
            <link rel="stylesheet" href="actiz_index.css" type="text/css" media="screen" charset="utf-8"/>
    </head>
    <body>
        <div id="nav_5">
            <ul>
                <li><a href="index.jsp">Actiz</a></li>
                <li><a href="flux.jsp">Flux public</a></li>

            </ul>
        </div>
        <div id="container">
            <div id="barre">
            </div>



            <div id="corp_index">

                <div id="droit">
                    <div id="sous_menu">
                        <h3>Statistiques :</h3>
                        <a class="haut" href="#a">Login/Auth Methods</a>
                        <br/>
                        <a class="mid" href="#f">Firends Methods</a>
                        <br/>
                        <a class="mid" href="#p">Post/Com Methods</a>
                        <br/>
                        <a class="bas" href="#s">Search Methods</a>
                    </div>
                </div>


                <div id="apirest">
                    <h1>Documentation  API REST </h1>
                    <br/><br/><br/>
                    <h2 id="a">Login/Auth Methods</h2>
                    <br/><br/>
                    <li>Nom du service : </li>
                    <p>/newuser</p>
                    <br/>
                    <li>Description du service : </li>
                    <p>Création d'un nouvel utilisateur.</p>
                    <br/>
                    <li>Parametres en entrer :</li>
                    <p>login, pass, fname , name , mail</p>
                    <br/>
                    <li>Format de sortie :</li>
                    <p>JSON</p>
                    <br/>
                    <li>Exemple de sortie :</li>
                    <p>{} OU {mess:..., code:...}</p>
                    <br/>
                    <li>Erreurs Possibles :</li>
                    <p>login existant, paramètres non renseigné, adress e-mail non conforme ,Probleme class NewUser</p>
                    <br/>
                    <li>Avancement du Service :</li>
                    <p>Fini</p>
                    <br/>
                    <li>Class Java en raport avec le Web Service :</li>
                    <p>NewUserService ,ControlString , ServiceTools , ErrorL , AuthBD</p>

                    <div id="diviseur"></div>
                    <li>Nom du service : </li>
                    <p>/login</p>
                    <br/>
                    <li>Description du service : </li>
                    <p>Connexion au site</p>
                    <br/>
                    <li>Parametres en entrer :</li>
                    <p>login , pass</p>
                    <br/>
                    <li>Format de sortie :</li>
                    <p>JSON</p>
                    <br/>
                    <li>Exemple de sortie :</li>
                    <p>{id,login,key} OU {mess:..., code:...}</p>
                    <br/>
                    <li>Erreurs Possibles :</li>
                    <p>login ou mdp  incorrecte , paramètres non renseigné</p>
                    <br/>
                    <li>Avancement du Service :</li>
                    <p>Fini</p>
                    <br/>
                    <li>Class Java en raport avec le Web Service :</li>
                    <p>LoginService ,SessionBD, ServiceTools ,ControlString , ErrorL , AuthBD</p>

                    <div id="diviseur"></div>
                    <li>Nom du service : </li>
                    <p>/logout</p>
                    <br/>
                    <li>Description du service : </li>
                    <p>Deconnexion au site</p>
                    <br/>
                    <li>Parametres en entrer :</li>
                    <p>key</p>
                    <br/>
                    <li>Format de sortie :</li>
                    <p>JSON</p>
                    <br/>
                    <li>Exemple de sortie :</li>
                    <p>{} OU {mess:..., code:...}</p>
                    <br/>
                    <li>Erreurs Possibles :</li>
                    <p> key inexistant, paramètres non renseigné </p>
                    <br/>
                    <li>Avancement du Service :</li>
                    <p>Fini</p>
                    <br/>
                    <li>Class Java en raport avec le Web Service :</li>
                    <p> LogoutService ,SessionBD, ServiceTools ,ControlString , ErrorL</p>


                    <br/><br/><br/>
                    <h2 id="f">Firends Methods</h2>
                    <br/><br/>
                    <li>Nom du service : </li>
                    <p>/removefriend</p>
                    <br/>
                    <li>Description du service : </li>
                    <p>Suprime un amis.</p>
                    <br/>
                    <li>Parametres en entrer :</li>
                    <p>key , idF</p>
                    <br/>
                    <li>Format de sortie :</li>
                    <p>JSON</p>
                    <br/>
                    <li>Exemple de sortie :</li>
                    <p>{} OU {mess:..., code:...}</p>
                    <br/>
                    <li>Erreurs Possibles :</li>
                    <p>paramètres non renseigné, key ou idF innexistant , idF non amis avec key</p>
                    <br/>
                    <li>Avancement du Service :</li>
                    <p>Fini</p>
                    <br/>
                    <li>Class Java en raport avec le Web Service :</li>
                    <p>SessionBD , FriendBD ,ControlString ,ErrorL , ServicesTools</p>

                    <div id="diviseur"></div>
                    <li>Nom du service : </li>
                    <p>/listfriend</p>
                    <br/>
                    <li>Description du service : </li>
                    <p>A COMPLETER</p>
                    <br/>
                    <li>Parametres en entrer :</li>
                    <p>key , idU</p>
                    <br/>
                    <li>Format de sortie :</li>
                    <p>JSON</p>
                    <br/>
                    <li>Exemple de sortie :</li>
                    <p>A COMPLETER</p>
                    <br/>
                    <li>Erreurs Possibles :</li>
                    <p>A COMPLETER</p>
                    <br/>
                    <li>Avancement du Service :</li>
                    <p>Fini</p>
                    <br/>
                    <li>Class Java en raport avec le Web Service :</li>
                    <p>A COMPLETER</p>

                    <div id="diviseur"></div>
                    <li>Nom du service : </li>
                    <p>/addfriend</p>
                    <br/>
                    <li>Description du service : </li>
                    <p>Fait une demande d'amis a un autre User</p>
                    <br/>
                    <li>Parametres en entrer :</li>
                    <p>key , idF</p>
                    <br/>
                    <li>Format de sortie :</li>
                    <p>JSON</p>
                    <br/>
                    <li>Exemple de sortie :</li>
                    <p>{} OU {mess:..., code:...}</p>
                    <br/>
                    <li>Erreurs Possibles :</li>
                    <p> key inexistant, paramètres non renseigné ,idF inexistante , déja amis </p>
                    <br/>
                    <li>Avancement du Service :</li>
                    <p>Fini</p>
                    <br/>
                    <li>Class Java en raport avec le Web Service :</li>
                    <p> AddFriendService , ServiceTools ,ControlString, ErrorL , FriendBD , SessionBD</p>


                    <div id="diviseur"></div>
                    <li>Nom du service : </li>
                    <p>/accfriend</p>
                    <br/>
                    <li>Description du service : </li>
                    <p>Accepte ou refuse un demande d'amis.</p>
                    <br/>
                    <li>Parametres en entrer :</li>
                    <p>key , idF , accF(boolean)</p>
                    <br/>
                    <li>Format de sortie :</li>
                    <p>JSON</p>
                    <br/>
                    <li>Exemple de sortie :</li>
                    <p>{} OU {mess:..., code:...}</p>
                    <br/>
                    <li>Erreurs Possibles :</li>
                    <p> key inexistant, paramètres non renseigné ,idF inexistante , déja amis  </p>
                    <br/>
                    <li>Avancement du Service :</li>
                    <p>Fini</p>
                    <br/>
                    <li>Class Java en raport avec le Web Service :</li>
                    <p> AccFriendService , ServiceTools ,ControlString, ErrorL , FriendBD , SessionBD</p>


                    <br/><br/><br/>
                    <h2 id="p">Post/Com Methods</h2>
                    <br/><br/>
                    <li>Nom du service : </li>
                    <p>/suppost</p>
                    <br/>
                    <li>Description du service : </li>
                    <p>Suprime un post que l'on a poster ou que quelqu'un a posté sur notre flux.</p>
                    <br/>
                    <li>Parametres en entrer :</li>
                    <p>key , idP</p>
                    <br/>
                    <li>Format de sortie :</li>
                    <p>JSON</p>
                    <br/>
                    <li>Exemple de sortie :</li>
                    <p>{} OU {mess:..., code:...}</p>
                    <br/>
                    <li>Erreurs Possibles :</li>
                    <p>Paramètres non renseigné, key ou idP innexistant , key non propriétaire du post ou pas sur son flux</p>
                    <br/>
                    <li>Avancement du Service :</li>
                    <p>Fini</p>
                    <br/>
                    <li>Class Java en raport avec le Web Service :</li>
                    <p>ControlString ,ErrorL , ServicesTools ,  PostBD ,ComBD , SessionBD</p>

                    <div id="diviseur"></div>
                    <li>Nom du service : </li>
                    <p>/supcom</p>
                    <br/>
                    <li>Description du service : </li>
                    <p>Suprime un com que l'on a poster .</p>
                    <br/>
                    <li>Parametres en entrer :</li>
                    <p>key , idP , idC</p>
                    <br/>
                    <li>Format de sortie :</li>
                    <p>JSON</p>
                    <br/>
                    <li>Exemple de sortie :</li>
                    <p>{} OU {mess:..., code:...}</p>
                    <br/>
                    <li>Erreurs Possibles :</li>
                    <p>Paramètres non renseigné, key ou idP innexistant , key différent de idC</p>
                    <br/>
                    <li>Avancement du Service :</li>
                    <p>Fini</p>
                    <br/>
                    <li>Class Java en raport avec le Web Service :</li>
                    <p>ControlString ,ErrorL , ServicesTools  ,ComBD , SessionBD</p>

                    <div id="diviseur"></div>
                    <li>Nom du service : </li>
                    <p>/plike</p>
                    <br/>
                    <li>Description du service : </li>
                    <p> Aime ou n'aime pas un post.</p>
                    <br/>
                    <li>Parametres en entrer :</li>
                    <p>key , idP , arg(boolean)</p>
                    <br/>
                    <li>Format de sortie :</li>
                    <p>JSON</p>
                    <br/>
                    <li>Exemple de sortie :</li>
                    <p>{} OU {mess:..., code:...}</p>
                    <br/>
                    <li>Erreurs Possibles :</li>
                    <p>Paramètres non renseigné, key ou idP innexistant </p>
                    <br/>
                    <li>Avancement du Service :</li>
                    <p>Fini</p>
                    <br/>
                    <li>Class Java en raport avec le Web Service :</li>
                    <p>ControlString ,ErrorL , ServicesTools ,LikeBD,ComBD , SessionBD</p>

                    <div id="diviseur"></div>
                    <li>Nom du service : </li>
                    <p>/clike</p>
                    <br/>
                    <li>Description du service : </li>
                    <p> Aime ou n'aime pas un commentaire.</p>
                    <br/>
                    <li>Parametres en entrer :</li>
                    <p>key , idP ,idC , arg(boolean)</p>
                    <br/>
                    <li>Format de sortie :</li>
                    <p>JSON</p>
                    <br/>
                    <li>Exemple de sortie :</li>
                    <p>{} OU {mess:..., code:...}</p>
                    <br/>
                    <li>Erreurs Possibles :</li>
                    <p>Paramètres non renseigné, key , idC ou idP innexistant </p>
                    <br/>
                    <li>Avancement du Service :</li>
                    <p>Fini</p>
                    <br/>
                    <li>Class Java en raport avec le Web Service :</li>
                    <p>ControlString ,ErrorL , ServicesTools ,LikeBD,ComBD , SessionBD</p>

                    <div id="diviseur"></div>
                    <li>Nom du service : </li>
                    <p>/addpost</p>
                    <br/>
                    <li>Description du service : </li>
                    <p> Ajoute un post dans son flux, dans le flux de quelqu'un d'autre , ou copie le post de queluq'un dans son flux.</p>
                    <br/>
                    <li>Parametres en entrer :</li>
                    <p>key , idA ,idH , text</p>
                    <br/>
                    <li>Format de sortie :</li>
                    <p>JSON</p>
                    <br/>
                    <li>Exemple de sortie :</li>
                    <p>{} OU {mess:..., code:...}</p>
                    <br/>
                    <li>Erreurs Possibles :</li>
                    <p>Paramètres non renseigné, key , idA ou idH innexistant </p>
                    <br/>
                    <li>Avancement du Service :</li>
                    <p>Fini</p>
                    <br/>
                    <li>Class Java en raport avec le Web Service :</li>
                    <p>ControlString ,ErrorL , ServicesTools ,PostBD , SessionBD</p>

                    <div id="diviseur"></div>
                    <li>Nom du service : </li>
                    <p>/addcomment</p>
                    <br/>
                    <li>Description du service : </li>
                    <p> Ajoute un commentaire dans un post.</p>
                    <br/>
                    <li>Parametres en entrer :</li>
                    <p>key , idP , text</p>
                    <br/>
                    <li>Format de sortie :</li>
                    <p>JSON</p>
                    <br/>
                    <li>Exemple de sortie :</li>
                    <p>{} OU {mess:..., code:...}</p>
                    <br/>
                    <li>Erreurs Possibles :</li>
                    <p>Paramètres non renseigné, key  ou idP innexistant </p>
                    <br/>
                    <li>Avancement du Service :</li>
                    <p>Fini</p>
                    <br/>
                    <li>Class Java en raport avec le Web Service :</li>
                    <p>ControlString ,ErrorL , ServicesTools ,ComBD , SessionBD</p>


                    <br/><br/><br/>
                    <h2 id="s">Search Methods</h2>
                    <br/><br/>
                    <li>Nom du service : </li>
                    <p>/search</p>
                    <br/>
                    <li>Description du service : </li>
                    <p>Search .</p>
                    <br/>
                    <li>Parametres en entrer :</li>
                    <p>key , query , args</p>
                    <br/>
                    <li>Format de sortie :</li>
                    <p>JSON</p>
                    <br/>
                    <li>Exemple de sortie :</li>
                    <p>{"post":[{"text":"","nameuserP":"","commentaires":[{"id":"","iduser":"","text":"","pouceL":[{"idU":""}],"nameuser":"","pouceB":[],"date":""}],"iduserH":"","pouceB":[],"date":"","nameuserH":"","iduserP":"","_id":"","nameuserA":"","pouceL":[{"idU":""}],"iduserA":""}]} OU {mess:..., code:...}</p>
                    <br/>
                    <li>Erreurs Possibles :</li>
                    <p>Paramètres non renseigné, key innexistant, query inconue , args inconue </p>
                    <br/>
                    <li>Avancement du Service :</li>
                    <p>Fini</p>
                    <br/>
                    <li>Class Java en raport avec le Web Service :</li>
                    <p>ControlString ,ErrorL , ServicesTools , SearchBD, SessionBD</p>
                    <br/>
                    <li>Informatiosn suplémentaire :</li>
                    <p>Protocol(Pour les connecté {Using key}) : </p>
                    <p>query : user / args : login || nom || prenom || nom prenom / Recherche les users selon certain criteres * </p> 
                    <p>query : postU / args : iduser / Renvois tous les posts de l'user</p>
                    <p>query : postUP / args : iduser / Renvois tous les posts de l'user et des post qui sont sur son mur </p>
                    <p>query : postUF / args : iduser / Renvois tous les posts des amis de l'user </p>
                    <p>query : friendU / args : iduser / Renvois tous les amis de l'user </p>
                    <p>query : bondU / args : iduser1&iduser2 / Renvois tous les posts entre iduser1 & iduser2  </p>
                    <p>query : postAll / Renvois tous les posts des users </p>
                    <p>Protocol(Pour les non connecté {Non key}) : </p>
                    <p>query : user / args : login || nom || prenom || nom prenom / Recherche les users selon certain criteres *</p>
                    <p>query : postAll / Renvois tous les posts des users qui sont uniquement sur son propre mure (idP =idA) 
                        (Sans afficher les commentaires et les likes) </p>
                    <p>query : postU / args : iduser / Renvois tous les posts de l'user qui sont uniquement sur son propre mure (idP =idA) 
                        (Sans afficher les commentaires et les likes) </p>
                    <p> * : a faire</p>
                    
                    
                    
                    <br/><br/><br/>
                    <h2 id="s">Stats Methods</h2>
                    <br/><br/>
                    <li>Nom du service : </li>
                    <p>/stats</p>
                    <br/>
                    <li>Description du service : </li>
                    <p>Renvosi divrs stats.</p>
                    <br/>
                    <li>Parametres en entrer :</li>
                    <p>key </p>
                    <br/>
                    <li>Format de sortie :</li>
                    <p>JSON</p>
                    <br/>
                    <li>Exemple de sortie :</li>
                    <p>{"nbUser":"7"} OU {mess:..., code:...}</p>
                    <br/>
                    <li>Erreurs Possibles :</li>
                    <p>Paramètres non renseigné, key innexistant </p>
                    <br/>
                    <li>Avancement du Service :</li>
                    <p>Fini</p>
                    <br/>
                    <li>Class Java en raport avec le Web Service :</li>
                    <p>ControlString ,ErrorL , ServicesTools , SearchBD, SessionBD</p>

                </div>

            </div>  
            <div id="foot" >
                <p>Actiz © Tous droits réservé | Contact</p>
            </div>  
        </div>




    </body>

</html>