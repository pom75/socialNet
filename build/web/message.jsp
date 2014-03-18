<!doctype html>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

    <head>
        <title> Bienvenue sur Actiz - Flux </title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-15">
            <meta name="keywords" content="  " />
            <meta name="description" content=" " />
            <meta name="author" content="" />
            <meta name="generator" content="" />
            <meta name="revisit-after" content="0"/>
            <meta name="Language" content="fr"/>
            <meta name="Copyright" content="Null"/>
            <meta NAME="ROBOTS" CONTENT="INDEX"/>
            <link rel="icon" type="image/png" href="img/favicon.png"  />
            <script type="text/javascript" src="jquery-1.js"></script>
            <script type="text/javascript" src="ajax.js"></script>
            <script type="text/javascript" src="client.js"></script>
            <script src="mustache.js"></script>
            <link rel="stylesheet" href="actiz_flux.css" type="text/css" media="screen" charset="utf-8"/>
    </head>
    <body onload="affMess()">

        <div id="nav_5">
            <ul>
                <li><a href="flux.jsp">Actiz  </a></li>
                <li><a href="flux.jsp">Flux public</a></li>
                <li name="cache1"><a href="message.jsp">Messages</a></li>
                <li name="cache2"><a href="profil.jsp">Profil</a></li>
                <li ><a href="rest.jsp">API REST</a></li>
                <div id="co" name="cache4">       
                    <a class="buttond" onclick="deco()" style="float:right"><img src="img/deco.png" height="17" width="17"/></a>
                </div>
                <form id="search" action="">
                    <input type="text" class="search_1" placeholder="Search">
                </form>
                <div id="co" name="cache3" style="display:none">       
                    <a class="button" href="index.jsp">Connexion</a>
                </div>


            </ul>
        </div>
        <div id="container">
            <div id="barre">
            </div>

            <div id="corp_index">

                <div id="droite">
                    
                </div>

                <div id="poster" name="cache5">
                    <h3>Nouveau Message : </h3>
                    <form id="pos" action="" >
                        <textarea type="text" class="message" name="messageA" placeholder="Message" onclick="agrandPos(this)"></textarea>
                    </form>
                    
                    <form id="pos" action="" >
                        <textarea type="text" class="id" name="messageA" placeholder="ID de la personne" onclick="agrandPos(this)"></textarea>
                    </form>
                    
                    <a class="button2" href="#" onclick="redPos(this);send()">Envoyer !</a>

                </div>

                <div id="list" name="liste">
                </div>

            </div> 
            <div id="foot" >
                <p>Actiz © Tous droits réservé | Contact</p>
            </div>  
        </div>

        <div id="friend" class="popup_block">
            <h2>Information</h2>
            <p>Une demande d'amis a été envoyé !</p>
        </div>

        <div id="erreur" class="popup_block">
            <h2>Erreur</h2>
            <p>aa</p>
        </div>

    </body>

</html>
<script>
    
    function affMess(){

        $.ajax ({
            type : "POST" ,
            url: "mess",
            data:"key="+readCookie("id_u"), 
            dataType : "json" ,
            success: function(rep){
                if(!(typeof (rep.code) == 'undefined')){
                    alert("Erreur "+rep.code+" : "+rep.mess);
                }else{
                    //PAs le temps de parssé le JSOn avec moustache 
                    $("#liste").append(rep);
                } 
            },
            error :function(jqXHR, textStatus , errorThrown ){
                boolInscr = true;
                alert("textStatus");
            }
        })
    }
    
    
       function send(){

        $.ajax ({
            type : "POST" ,
            url: "send",
            data:"key="+readCookie("id_u")+"&idp="+$('#poster').$('.id')+"&mess="+$('#poster').$('.message'), 
            dataType : "json" ,
            success: function(rep){
                if(!(typeof (rep.code) == 'undefined')){
                    alert("Erreur "+rep.code+" : "+rep.mess);
                }else{
                    //PAs le temps de parssé le JSOn avec moustache 
                    $("#liste").append(rep);
                } 
            },
            error :function(jqXHR, textStatus , errorThrown ){
                boolInscr = true;
                alert("textStatus");
            }
        })
    }


    
    
</script>