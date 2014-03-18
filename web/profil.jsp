<!doctype html>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

    <head>
        <title> Bienvenue sur Actiz - Profil </title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
            <meta name="keywords" content="  " />
            <meta name="description" content=" " />
            <meta name="author" content="" />
            <meta name="generator" content="" />
            <meta name="revisit-after" content="0"/>
            <meta name="Language" content="fr"/>
            <meta name="Copyright" content="Null"/>
            <meta NAME="ROBOTS" CONTENT="INDEX"/>
            <link rel="icon" type="image/png" href="img/logo.png" />
            <script type="text/javascript" src="jquery-1.js"></script>
            <script type="text/javascript" src="ajax.js"></script>
            <script type="text/javascript" src="client.js"></script>
            <script src="mustache.js"></script>
            <link rel="stylesheet" href="actiz_profil.css" type="text/css" media="screen" charset="utf-8"/>
    </head>
    <body onload="estCo()" >
        <div id="nav_5">
            <ul>
                <li><a href="flux.jsp">Actiz </a></li>
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
                <div id="co" name="cache3" style="display:none" >       
                    <a class="button" href="index.jsp">Connexion</a>
                </div>
            </ul>
        </div>
        <div id="container">
            <div id="barre">
            </div>

            <div id="corp_index">
                <div id="droite">

                    <div id="sous_menu" name="cache7" style="display:none" onclick="addFriendT()">
                        <p class="midz">Ajouter en amis</p>
                    </div>

                    <div id="sous_menu" name="cache10" style="display:none" onclick="suppFriend($_GET['id'])">
                        <p class="midz">Suprimer des amis</p>
                    </div>

                    <div id="sous_menui">
                        <h3>Informations :</h3>

                    </div>

                    <div id="sous_menu" name="cache6">
                        <h3>Mon profil :</h3>
                        <p class="haut">Modifier mon profil</p>
                        <p class="mid">Messages</p>
                        <p class="bas" onclick="pop('friendAtt')">Demandes d'amis : <span id="cpt">0 </span></p>
                    </div>
                </div>

                <div id="poster" >
                    <div id="photo">
                        <img src="img/avatar.jpg" alt="" >
                    </div>
                    <div id="pos" name="cache5">

                        <form action="" >
                            <h3>Nouveau poste : </h3>
                            <textarea type="text" class="pos" name="messageA" placeholder="Exprime toi !" onclick="agrandPos(this)"></textarea>
                            <a class="button2" href="#" onclick="redPos(this);post()">Envoyer !</a>
                        </form>



                    </div>

                </div>


                <div id="list"  name="liste">





                </div>

            </div> 
            <div id="foot" >
                <p>Actiz © Tous droits réservé | Contact</p>
            </div>  
        </div>

        <div id="erreur" class="popup_block">
            <h2>Erreur</h2>
            <p>aa</p>
        </div>
        
        <div id="friend" class="popup_block">
            <h2>Information</h2>
            <p>Une demande d'amis a été envoyé !</p>
        </div>



        <div id="friendAtt" class="popup_block">
            <h3>Demande d'ajout d'amis</h3>
            <p>Aucune demmande actuelement </p>
        </div>


    </body>

</html>
<script>

    
   
    //Spécifique a cette page
    function rePost(idH,id){
        if(boolPost){
            boolPost= false;
            $.ajax ({
                type : "POST" ,
                url: "addpost",
                data:"key="+readCookie('key_u')+"&idA="+readCookie('id_u')+"&idH="+idH+"&text="+document.getElementsByName(id+"_text")[0].firstChild.data, dataType : "json" ,
                success: function(rep){
                    if(!(typeof (rep.code) == 'undefined')){
                        boolPost=true;
                        erreurServlet(rep.code,rep.mess);
                    }else{
                        boolPost=true;
                        if(readCookie('id_u') == $_GET['id']){
                            varshow = true;
                            affPost();
                        }else{
                            window.location = "flux.jsp";
                        }
                        
                    } 
                },error :function(jqXHR, textStatus , errorThrown ){
                    alert("textStatus");
                }
            })
        }
    }
    
    
    
    
    function post(){
        var text = document.getElementsByName("messageA")[0].value;
        text = text.replace(/[\s]*$/g,'');  
        if(boolPost){
            boolPost= false;
            $.ajax ({
                type : "POST" ,
                url: "addpost",
                data:"key="+readCookie('key_u')+"&idA="+$_GET['id']+"&idH="+readCookie('id_u')+"&text="+text, dataType : "json" ,
                success: function(rep){
                    if(!(typeof (rep.code) == 'undefined')){
                        erreurServlet(rep.code,rep.mess);
                        boolPost=true;
                    }else{
                        boolPost=true;
                        varshow = true;
                        document.getElementsByName("messageA")[0].value="";
                        affPost();
                    } 
                },error :function(jqXHR, textStatus , errorThrown ){
                    alert("textStatus");
                }
            })
        }
    }
   
    
    function listF(){
        $.ajax ({
            type : "POST" ,
            url: "listfriend",
            data:"key="+readCookie("key_u")+"&idU="+readCookie("id_u"), dataType : "json" ,
            success: function(rep){
                if(!(typeof (rep.code) == 'undefined')){
                    erreurServlet(rep.code,rep.mess);
                }else{
                    listfriend = rep;
                    friendAtt();
                    affPost();
                    if(readCookie("id_u") == $_GET["id"]){
                        return;
                    }
                    var testf = false;
                    for(var i=0;i<listfriend.friendList.length;i++){
                        if(listfriend.friendList[i].idU == $_GET['id']){
                            testf = true;
                        }
                    }
                    if(testf){
                        document.getElementsByName('cache7')[0].style.display="none";
                        document.getElementsByName('cache10')[0].style.display="block";
                    }else{
                        document.getElementsByName('cache7')[0].style.display="block";
                        document.getElementsByName('cache10')[0].style.display="none";
                    }
                    

                } 
            },error :function(jqXHR, textStatus , errorThrown ){
                
            }
        })
    }
   
    
    
   
    
    
    function affPost(){
        if(parseInt(readCookie("id_u")) >= 0){
            //Le mec est coonecter
            postCo();
        }else{
            //Le mec n'est pas coonecter
            postNotCo();
        }
    }
    
    function postNotCo(){
        $.ajax ({
            type : "POST" ,
            url: "search",
            data:"query=postU&args="+$_GET['id'], dataType : "json" ,
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
     
    
    function agrandCom(doc){
        doc.style.padding="10px";
        doc.style.resize="vertical";
        doc.style.background="10px 6px #fcfcfc";
        doc.style.color= "black";
        doc.style.width= "90%";
        doc.style.height= "60px";
    }
    
    function redCom(name){
        document.getElementsByName(name)[0].style.height="";
        document.getElementsByName(name)[0].style.padding="";
        document.getElementsByName(name)[0].style.resize="";
        document.getElementsByName(name)[0].style.background="";
        document.getElementsByName(name)[0].style.color="";
        document.getElementsByName(name)[0].style.width="";
    }
    
    function agrandPos(doc){
        doc.style.padding="10px";
        doc.style.resize="vertical";
        doc.style.background="10px 6px #fcfcfc";
        doc.style.color= "black";
        doc.style.width= "90%";
        doc.style.height= "90px";
    }
    
    function redPos(doc){
        document.getElementsByName("messageA")[0].style.height="";
        document.getElementsByName("messageA")[0].style.padding="";
        document.getElementsByName("messageA")[0].style.resize="";
        document.getElementsByName("messageA")[0].style.background="";
        document.getElementsByName("messageA")[0].style.color="";
        document.getElementsByName("messageA")[0].style.width="";
    }
    

    
    function postCo(){
        $.ajax ({
            type : "POST" ,
            url: "search",
            data:"key="+readCookie("key_u")+"&query=postUP&args="+$_GET['id'], dataType : "json" ,
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
   
    
    function pop(popID){

        var popWidth = 600; 

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
    

    document.location.search.replace(/\??(?:([^=]+)=([^&]*)&?)/g, function () {
        function decode(s) {
            return decodeURIComponent(s.split("+").join(" "));
        }

        $_GET[decode(arguments[1])] = decode(arguments[2]);
    });
    function hideCo(){
        document.getElementsByName('cache1')[0].style.display="none";
        document.getElementsByName('cache2')[0].style.display="none";
        document.getElementsByName('cache3')[0].style.display="inline";
        document.getElementsByName('cache4')[0].style.display="none";
        document.getElementsByName('cache5')[0].style.display="none";
        document.getElementsByName('cache6')[0].style.display="none";
        document.getElementsByName('cache7')[0].style.display="none";
	
    }
    function showCo(){
        document.getElementsByName('cache1')[0].style.display="inline";
        document.getElementsByName('cache2')[0].style.display="inline";
        document.getElementsByName('cache3')[0].style.display="none";
        document.getElementsByName('cache4')[0].style.display="inline";
        document.getElementsByName('cache5')[0].style.display="inline";
        document.getElementsByName('cache6')[0].style.display="inline";
	
    }
    
    function estCo(){
        if(parseInt(readCookie("id_u")) >= 0){
            showCo();
            listF();
            
            if($_GET["id"] == undefined){
                $_GET["id"] = readCookie("id_u");
            }
            if(!(readCookie("id_u") == $_GET["id"])){
                document.getElementsByName('cache6')[0].style.display="none";
                //document.getElementsByName('cache8')[0].style.display="none";
            }else{
                document.getElementsByName('cache7')[0].style.display="none";
                document.getElementsByName('cache10')[0].style.display="none";
            }
            
        }else{
            hideCo();
            affPost();
        }
    }
  
    
    

    function hideShowDisc(id){
        $('.disc_'+id+'_d').slideToggle('slow');
        $('.disc_'+id+'_rea').slideToggle('slow');
        $('#button2_'+id+'_b1').slideToggle('slow');
        $('#button3_'+id+'_b1').slideToggle('slow');
        $('#button3_'+id+'_b2').slideToggle('slow');
        $('#button2_'+id+'_b4').slideToggle('slow');
    }

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
    
    
    
    
    /*
     * 
     * 
     * 
     <form action="" name="cache8">
                            <h3>Nouvelle discussion: </h3>
                            <textarea type="text" class="pos" placeholder="Sujet de discussion !"></textarea>
                            <a class="button2" href="#">Envoyer !</a>
                        </form>
    
    
     <div id="disc" class="disc_1">
                        <div id="reac">
                            <div id="avatar">
                                <a href="#"><img src="img/avatar.jpg" alt="" ></a>
                            </div>
                            <a class="button4" >x</a>
                            <div id="author">
                                <a href="#">StÃ©phane Ferreira</a> <a class="button6" >+</a>
                            </div>
                            <div id="text">
                                Ceci est une discussion de l'utilisateur stÃ©phane ferreira et je veux voir jusqu'a quelle longueur le post peux allez donc j'Ã©cris du text.
                            </div>
                            <div id="date">
                                26 MARS 2013 Ã  18h12
                            </div>

                            <div id="diviseur" class="disc_1_d" style="display:none">
                            </div>
                        </div>

                        <div class="disc_1_rea" style="display:none">
                            <div id="reac">
                                <div id="avatar">
                                    <a href="#"><img src="img/avatar.jpg" alt="" ></a>
                                </div>
                                <a class="button4" >x</a>
                                <div id="author">
                                    <a href="#">StÃ©phane Ferreira</a> <a class="button6" >+</a>
                                </div>
                                <div id="text">
                                    Ceci est une discussion de l'utilisateur stÃ©phane ferreira et je veux voir jusqu'a quelle longueur le post peux allez donc j'Ã©cris du text.
                                </div>
                                <div id="date">
                                    26 MARS 2013 Ã  18h12
                                </div>
                                <div id="diviseur">
                                </div>
                            </div>

                            <div id="reac">
                                <div id="avatar">
                                    <a href="#"><img src="img/avatar.jpg" alt="" ></a>
                                </div>
                                <a class="button4" >x</a>
                                <div id="author">
                                    <a href="#">StÃ©phane Ferreira</a> <a class="button6" >+</a>
                                </div>
                                <div id="text">
                                    Ceci est une discussion de l'utilisateur stÃ©phane ferreira et je veux voir jusqu'a quelle longueur le post peux allez donc j'Ã©cris du text.
                                </div>
                                <div id="date">
                                    26 MARS 2013 Ã  18h12
                                </div>

                            </div>

                            <div id="coms">
                                <form id="comms" action="">
                                    <textarea type="text" class="coms" placeholder="Exprime toi !"></textarea>
                                </form>
                                <a class="button5" href="#">Envoyer</a>
                            </div>



                        </div>
                        <a class="button2"  id="button2_1_b1" onclick="hideShowDisc(1)">Lire (3)</a> <a class="button2"  id="button2_1_b4" style="display:none" onclick="hideShowDisc(1)">Cacher</a> <a class="button3" id="button3_1_b1" class="disc_1_b2">Suivre</a> <a class="button3" id="button3_1_b2" style="display:none" >Abandonner</a>       
                    </div>
    
     <p class="bas">Epurer par post</p>
     */

</script>
