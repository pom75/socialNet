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
    <body onload="estCo()">

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
                    <div id="sous_menu">
                        <h3>Filtre <a name="filtre_2" onclick="showFiltre()">+</a> <a name="filtre_3" style="display:none" onclick="hideFiltre()">-</a> </h3>
                        <div name="filtre_1" style="display:none" >
                            <p class="haut">Trier par pertinence</p>
                            <p class="mid">Trier par date</p>
                            <p class="mid">Trier par mot clé</p>
                            <p class="mid">Filtrer par Amis</p>
                        </div>
                    </div>

                    <div id="sous_menu" class="aaa">
                        <h3>Statistiques :</h3>
                                            
                    </div>
                </div>

                <div id="poster" name="cache5">
                    <h3>Nouveau poste : </h3>
                    <form id="pos" action="" >
                        <textarea type="text" class="pos" name="messageA" placeholder="Exprime toi !" onclick="agrandPos(this)"></textarea>
                    </form>
                    <a class="button2" href="#" onclick="redPos(this);post()">Envoyer !</a>

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

 
   
    
    
    //Fonction d'affichage de post'
    function affPost(){
        if(parseInt(readCookie("id_u")) >= 0){
            //Le mec est coonecter
            postCo();
        }else{
            //Le mec n'est pas coonecter
            postNotCo();
        }
    }
    
    
    function affStat(){
        $.ajax ({
            type : "POST" ,
            url: "stats",
            data:"key="+readCookie("key_u"), dataType : "json" ,
            success: function(rep){
                if(!(typeof (rep.code) == 'undefined')){
                    erreurServlet(rep.code,rep.mess);
                }else{
                    $('.aaa').append('<p class="mid">Nombres d\'utilisateur :'+rep.nbUser+'</p>' );
                } 
            },error :function(jqXHR, textStatus , errorThrown ){
                
            }
        })
    }
    
    
    //Query spécifique a cette page
    function postNotCo(){
        
        $.ajax ({
            type : "POST" ,
            url: "search",
            data:"query=postAll", dataType : "json" ,
            success: function(rep){
                if(!(typeof (rep.code) == 'undefined')){
                    erreurServlet(rep.code,rep.mess);
                }else{
                    affPostNotCoMustache(rep);
                } 
            },error :function(jqXHR, textStatus , errorThrown ){
                
            }
        })
    }
     
 
    //Quéry Spécifique a cette page
    function postCo(){
    affStat();
        $.ajax ({
            type : "POST" ,
            url: "search",
            data:"key="+readCookie("key_u")+"&query=postAll&args=PSG", dataType : "json" ,
            success: function(rep){
                if(!(typeof (rep.code) == 'undefined')){
                    erreurServlet(rep.code,rep.mess);
                    
                }else{
                    affPostCoMustache(rep);
                } 
            },error :function(jqXHR, textStatus , errorThrown ){
               
            }
        })
    }
    

   
   

    //Affichage Selon co ou non
    function hideCo(){
        document.getElementsByName('cache1')[0].style.display="none";
        document.getElementsByName('cache2')[0].style.display="none";
        document.getElementsByName('cache3')[0].style.display="inline";
        document.getElementsByName('cache4')[0].style.display="none";
        document.getElementsByName('cache5')[0].style.display="none";
	
    }
    function showCo(){
        document.getElementsByName('cache1')[0].style.display="inline";
        document.getElementsByName('cache2')[0].style.display="inline";
        document.getElementsByName('cache3')[0].style.display="none";
        document.getElementsByName('cache4')[0].style.display="inline";
        document.getElementsByName('cache5')[0].style.display="inline";
	
    }
    
    function estCo(){
        if(parseInt(readCookie("id_u")) >= 0){
            showCo();
            listF();
        }else{
            hideCo();
            affPost();
        }
    }
    

    
    //Affichage fitre ou non
    function hideFiltre(){
        
        document.getElementsByName('filtre_2')[0].style.display="inline";
        document.getElementsByName('filtre_3')[0].style.display="none";
        $("[name=filtre_1]").slideToggle('slow');
        
    }
    
    function showFiltre(){
        
        document.getElementsByName('filtre_2')[0].style.display="none";
        document.getElementsByName('filtre_3')[0].style.display="inline";
        $("[name=filtre_1]").slideToggle('slow');
    }

    


    function hideShowDisc(id){
        $('.disc_'+id+'_d').slideToggle('slow');
        $('.disc_'+id+'_rea').slideToggle('slow');
        $('#button2_'+id+'_b1').slideToggle('slow');
        $('#button3_'+id+'_b1').slideToggle('slow');
        $('#button3_'+id+'_b2').slideToggle('slow');
        $('#button2_'+id+'_b4').slideToggle('slow');
    }

    //Useless
    function incrActiz(){
        document.getElementById('actiz').firstChild.data=(1+parseInt(document.getElementById('actiz').firstChild.data));
    }
    function incrBouton(obj,op){
        if(op == '+'){
            obj.getElementsByTagName('span')[0].firstChild.data=(1+parseInt(obj.getElementsByTagName('span')[0].firstChild.data));
        }else{
            obj.getElementsByTagName('span')[0].firstChild.data=(-1+parseInt(obj.getElementsByTagName('span')[0].firstChild.data));
        }
	

    }
    
    
    //Regarde si le mec est déja co
    function tchek(){
        
        if(!(typeof(readCookie("id_u")) == 'undefined')){
            window.location = "flux.jsp";
        }
    }
    
 
    
    
   
</script>