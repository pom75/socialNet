<!doctype html>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

    <head>
        <title> Bienvenue sur Actiz - Accueil </title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
            <meta name="keywords" content="  " />
            <meta name="description" content=" " />
            <meta name="author" content="" />
            <meta name="generator" content="" />
            <meta name="revisit-after" content="0"/>
            <meta name="Language" content="fr"/>
            <meta name="Copyright" content="Null"/>
            <meta name="ROBOTS" content="INDEX"/>
            <link rel="icon" type="image/png" href="img/favicon.png"  />
            <script type="text/javascript" src="ajax.js"></script>
            <script type="text/javascript" src="client.js"></script>
            <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
            <link rel="stylesheet" href="actiz_index.css" type="text/css" media="screen" charset="utf-8"/>
    </head>
    <body onload="tchek()">
        <div id="nav_5">
            <ul>
                <li><a href="index.jsp">Actiz</a></li>
                <li><a href="flux.jsp">Flux public</a></li>
                <li ><a href="rest.jsp">API REST</a></li>
                <div id="co">
                    <label for="email">Identifiant </label> <input type="text" name="email" id="email" value="" tabindex="1" /> 
                    <label for="pass">Mot de passe </label><input type="password" name="pass" id="pass" tabindex="1" />

                    <a class="button" href="#" onclick="login()">Connexion</a>

                </div>


            </ul>
        </div>
        <div id="container">
            <div id="barre">
            </div>

            <div id="corp_index">

                <div id="gauche">
                    <div id="textg">
                        <p>Tous ensemble , connectés .</p>
                    </div>
                    <img src="img/world.png" alt="Actiz"/>
                </div>
                <div id="droite">
                    <div id="textd">
                        <p>Pas encore inscris ?</p>
                        <div id="diviseur">
                        </div>
                        <div id="error" >
                            <div id="e1"  style="display:none">
                                5 caractères minimum !
                            </div>
                        </div> 
                        <div id="error" >
                            <div id="e2"style="display:none">
                                Identifiant incorrect !
                            </div>
                        </div>  
                        <div id="diviseur1">
                        </div>
                        <label for="id">Identifiant :</label> <input type="text" name="id" id="identiant" value="" tabindex="1" onBlur="testID(this)" />
                        <div id="diviseur1">
                        </div>
                        <div id="error">
                            <div id="e3" style="display:none">
                                Mot de passe trop court
                            </div>
                        </div> 
                        <div id="diviseur1">
                        </div>
                        <label for="pass">Mot de passe :</label><input id="mdp1" type="password" name="pass1" id="pass" tabindex="1" onBlur="testMdpL(this)"/>
                        <div id="diviseur1">
                        </div>
                        <div id="error">
                            <div id="e4" style="display:none">
                                Mots de passe différents
                            </div>
                        </div> 
                        <div id="diviseur1">
                        </div>
                        <label for="pass">Mot de passe :</label><input type="password" name="pass2" id="pass" tabindex="1" onBlur="testMdpDiff(this)"/>
                        <div id="diviseur1">
                        </div>
                        <div id="error">
                            <div id="e5" style="display:none">
                                Adresse électronique incorrecte
                            </div>
                        </div> 
                        <div id="diviseur1">
                        </div>
                        <label for="email">Adresse électronique :</label> <input type="text" name="email2" value="" tabindex="1" onBlur="testMail(this)"/> 
                        <div id="diviseur1">
                        </div>
                        <div id="error">
                            <div id="e6" style="display:none">
                                Nom vide
                            </div>
                        </div> 
                        <div id="diviseur1">
                        </div>  
                        <label for="pass">Nom :</label><input type="text" name="nom" id="pass" tabindex="1" onBlur="testNom(this)"/>
                        <div id="diviseur1">
                        </div>
                        <div id="error">
                            <div id="e7" style="display:none">
                                Prénom vide
                            </div>
                        </div> 
                        <div id="diviseur1">
                        </div>
                        <label for="pass">Prénom : </label><input type="text" name="prenom" id="pass" tabindex="1" onBlur="testPre(this)"/>
                        <div id="diviseur1">
                        </div>
                        <a class="button2" href="#" onclick="valide()">S'inscrire !</a>
                    </div>
                </div>
            </div>  
            <div id="foot" >
                <p>Actiz © Tous droits réservé | Contact</p>
            </div>  
        </div>


        <div id="inscrip" class="popup_block">
            <h2>Bienvenue !</h2>
            <p>Vous pouvez des maintenant vous loguer sur Actiz !</p>
        </div>

        <div id="erreur" class="popup_block">
            <h2>Erreur</h2>
            <p>aa</p>
        </div>

    </body>

</html>
<script type="text/javascript">
    
    //Fuction pop propre a cette page
    function pop(popID){

        var popWidth = 300; 

        //Faire apparaitre la pop-up et ajouter le bouton de fermeture
        $('#' + popID).fadeIn().css({
            'width': Number(popWidth)
        })
        .prepend('<a href="#" class="close"><img src="close_pop.png" class="btn_close" title="Fermer" alt="Fermer" /></a>');

        //Récupération du margin, qui permettra de centrer la fenêtre - on ajuste de 80px en conformité avec le CSS
        var popMargTop = ($('#' + popID).height() + 80) / 2;
        var popMargLeft = ($('#' + popID).width() + 80) / 2;

        //On affecte le margin
        $('#' + popID).css({
            'margin-top' : -popMargTop,
            'margin-left' : -popMargLeft
        });

        //Effet fade-in du fond opaque
        $('body').append('<div id="fade"></div>'); //Ajout du fond opaque noir
        //Apparition du fond - .css({'filter' : 'alpha(opacity=80)'}) pour corriger les bogues de IE
        $('#fade').css({'filter' : 'alpha(opacity=80)'}).fadeIn();

        return false;
    }

    //Fermeture de la pop-up et du fond
    $('a.close, #fade').live('click', function() { //Au clic sur le bouton ou sur le calque...
        $('#fade , .popup_block').fadeOut(function() {
            $('#fade, a.close').remove();  //...ils disparaissent ensemble
        });
        return false;
    });
    


</script>
