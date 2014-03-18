/**********Cookie************/
  
function createCookie(name,value,days) {
    if (days) {
        var date = new Date();
        date.setTime(date.getTime()+(days*24*60*60*1000));
        var expires = "; expires="+date.toGMTString();
    }
    else var expires = "";
    document.cookie = name+"="+value+expires+"; path=/";
}

function readCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}

function eraseCookie(name) {
    createCookie(name,"",-1);
}
    
function tchek(){
    if(parseInt(readCookie("id_u")) >= 0){
        window.location = "flux.jsp";
    }

        
}
    
    
  
/**********Erreur Servlet************/
    
    
function erreurServlet(code,mess){
    if(code == 2 && mess == "key inexistante dans la bd"){
        deco();
    }
    else{
        $("#erreur").find('p')[0].firstChild.data=mess;
        pop('erreur');
    }
        
}
    
    
    
    
    
    
/***********Indexe***********/
  
  
  
//On test la valeur de tous les champs
function testID(obj){
    if(obj.value.length<5){
        document.getElementById('e1').style.display="block";
        obj.style.borderColor="red";	
    }else{
        document.getElementById('e1').style.display="none";
        obj.style.borderColor="green";	
    }
        
    	
}

function testMdpL(obj){
    if(obj.value.length<5){
        document.getElementById('e3').style.display="block";
        obj.style.borderColor="red";	
    }else{
        document.getElementById('e3').style.display="none";
        obj.style.borderColor="green";		
    }
    	
}
function testMdpDiff(obj){
    if(obj.value != document.getElementById('mdp1').value){
        document.getElementById('e4').style.display="block";
        obj.style.borderColor="red";	
    }else{
        document.getElementById('e4').style.display="none";	
        obj.style.borderColor="green";	
    }
    	
}
function testMail(mail){
    var reg = new RegExp('^[a-z0-9]+([_|\.|-]{1}[a-z0-9]+)*@[a-z0-9]+([_|\.|-]{1}[a-z0-9]+)*[\.]{1}[a-z]{2,6}$', 'i');
    if(reg.test(mail.value))
    {
        document.getElementById('e5').style.display="none";
        mail.style.borderColor="green";	
    }
    else
    {
        document.getElementById('e5').style.display="block";
        mail.style.borderColor="red";	
    }
}
function testNom(obj){
    if(obj.value.length<2){
        document.getElementById('e6').style.display="block";
        obj.style.borderColor="red";	
    }else{
        document.getElementById('e6').style.display="none";	
        obj.style.borderColor="green";	
    }
    	
}
function testPre(obj){
    if(obj.value.length<2){
        document.getElementById('e7').style.display="block";
        obj.style.borderColor="red";	
    }else{
        document.getElementById('e7').style.display="none";	
        obj.style.borderColor="green";	
    }
    	
}
    
//Lors qu'on clique sur le bouton valider'
function valide(){
    //Regexp email
    var reg = new RegExp('^[a-z0-9]+([_|\.|-]{1}[a-z0-9]+)*@[a-z0-9]+([_|\.|-]{1}[a-z0-9]+)*[\.]{1}[a-z]{2,6}$', 'i');

    if(document.getElementsByName('id')[0].value <=4){
        alert('5 caracteres minimum pour le login');
    }else if(document.getElementsByName('pass1')[0].value <=4){
        alert('5 caracteres minimum pour le mot de passe');
    }else if(document.getElementsByName('pass2')[0].value != document.getElementsByName('pass1')[0].value){
        alert('Les deux mots de passe entrÃ© sont diffÃ©rents');
    }else if(!reg.test(document.getElementsByName('email2')[0].value)){
        alert('Email invalide');
    }else if(document.getElementsByName('nom')[0].value <=2){
        alert('Nom trop court');
    }else if(document.getElementsByName('prenom')[0].value <=2){
        alert('Prenom trop court');
    }else{
        //Si tous est bon on appelle la function ajax
        inscription(document.getElementsByName('id')[0].value,document.getElementsByName('pass1')[0].value,document.getElementsByName('email2')[0].value,document.getElementsByName('nom')[0].value,document.getElementsByName('prenom')[0].value);
    }
    	
}
    
    
//On test les valeur rentrer dans login
function login(){

    if(document.getElementsByName('email')[0].value <=4){
        alert('5 caracteres minimum pour le login');
    }else if(document.getElementsByName('pass')[0].value <=4){
        alert('5 caracteres minimum pour le mot de passe');
    }else{
        //Si tous est bon on appele la fonction ajax
        login_ajax(document.getElementsByName('email')[0].value,document.getElementsByName('pass')[0].value);
    }
	    
}
    
    
      
      
      
/**********Gere la taille du textarea des posts et commentaire************/
 
   
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
    
    
/***********Affichage Mustache***********/

function affPostNotCoMustache(json){
    var template = '{{#post}}<div id="post" ><div id="avatar"><a href="profil.jsp?id={{iduserP}}"><img src="img/avatar.jpg" alt="" ></a></div><div id="author"><a href="profil.jsp?id={{iduserP}}">{{nameuserP}}</a></div><div id="text">{{text}}</div><div id="date">{{date}}</div></div>{{/post}}';
    var res= Mustache.render(template, json);
    document.getElementsByName("liste")[0].innerHTML=res;
}
    
    
function affPostCoMustache(json){
    var buff;
    var cpt =0;
    var id = "";
    var json2 = {
        post:json.post , 
        fl:listfriend.friendList,
        unlike: function(){
            return this.pouceB.length
        } , 
        like: function(){
            return this.pouceL.length
        }, 
        comms: function(){
            return this.commentaires.length
        },
        supp : function(){
            if( !(this.iduserP == readCookie("id_u") || this.iduserA == readCookie("id_u")) ){
                return "display:none"
            }
        },
        suppC : function(){
            if( !(this.iduser == readCookie("id_u") ) ){
                return "display:none"
            }
        },
        a : function(){
            if(this.iduserP == this.iduserA){
                return "display:none"
            }else{
                "display:inline-block"
            }
        },
        via : function(){
            if(this.iduserP == this.iduserH){
                return "display:none"
            }else{
                "display:inline-block"
            }
        },
        rePost : function(){
            if(this.iduserP == readCookie("id_u")){
                return "display:none"
            }else{
                "display:inline-block"
            }
        },
        addp : function(){
            buff = this.iduserP ;
        },
        addp1 : function(){
            buff = this.iduserH ;
        },
        addp2 : function(){
            buff = this.iduserA ;
        },
        addp3 : function(){
            buff = this.iduser ;
        },
        postf : function(){
            if(varshow){
                if(cpt == 0){
                    cpt++;
                    id = this._id;
                    return "display:none";
                }
                cpt++;
            }
        },
        add : function(){
            if(this.idU == buff){
                return "display:none"
            }
        }
    };
    var template = '{{#post}}<div class="{{_id}}" style="{{postf}}"><div id="post"  ><div id="avatar"><a href="profil.jsp?id={{iduserP}}"><img src="img/avatar.jpg" alt="" ></a></div><a class=\"button4\" style="{{supp}}" onclick=\"hideShowPost(\'{{_id}}\')\" >x</a><div id="author"><a href="profil.jsp?id={{iduserP}}">{{nameuserP}} </a><a class="button6"  style="{{addp}}{{#fl}}{{add}}{{/fl}}" onclick="addFriend(\'{{iduserP}}\')">+</a> <div style="{{a}}"> à <a href="profil.jsp?id={{iduserA}}">{{nameuserA}} </a><a class="button6"  style="{{addp2}}{{#fl}}{{add}}{{/fl}}" onclick="addFriend(\'{{iduserA}}\')">+</a> </div> <div style="{{via}}"> via <a href="profil.jsp?id={{iduserH}}">{{nameuserH}} </a><a class="button6" style="{{addp1}}{{#fl}}{{add}}{{/fl}}"  onclick="addFriend(\'{{iduserH}}\')">+</a> </div> </div><div id="text" name="{{_id}}_text">{{text}}</div><div id="date">{{date}}</div><a class="button2" onclick="hideShowCom(\'.{{_id}}_c\')">Com\'s (<span>{{comms}}</span>)</a> <a class="button3_v" style="{{rePost}}" onclick="rePost({{iduserH}},\'{{_id}}\')" ><img src="img/via.png" width="19" height="19" /></a> <a class="button3" onclick="jaimePas(\'{{_id}}\')">- <span>{{unlike}}</span></a> <a class="button3" onclick="jaime(\'{{_id}}\')">+ <span>{{like}}</span></a></div><div id="comments" style="display:none" class="{{_id}}_c">{{#commentaires}}<div id="comment" class="{{id}}"><div id="avatar"><a href="profil.jsp?id={{iduser}}"><img src="img/avatar.jpg" alt="" ></a></div><a class=\"button4\" style="{{suppC}}" onclick=\"hideShowComP(\'{{_id}}\',\'{{id}}\')\">x</a><div id="author"><a href="profil.jsp?id={{iduser}}">{{nameuser}}</a><a class="button6" style="{{addp3}}{{#fl}}{{add}}{{/fl}}"  onclick="addFriend(\'{{iduser}}\')">+</a></div><div id="text">{{text}}</div><div id="date">{{date}}</div><a class="button5" onclick="jaimeC(\'{{_id}}\',\'{{id}}\')">+ <span>{{like}}</span></a> <a class="button5" onclick="jaimePasC(\'{{_id}}\',\'{{id}}\')">- <span>{{unlike}}</span></a><div id="diviseur"></div></div>{{/commentaires}}<div id="comms"><form id="comms" action=""><textarea type="text" class="coms" name="com{{_id}}" placeholder="Réagis !" onclick="agrandCom(this)"></textarea></form><a class="button5" onclick="envoisCom(\'{{_id}}\');redCom(\'com{{_id}}\')">Envoyer</a></div></div></div>{{/post}}'

        
    var res= Mustache.render(template, json2);
    res = res.replace(/\n/g,'<br>');
    document.getElementsByName("liste")[0].innerHTML=res ;
    if(varshow){
        $("."+id).slideToggle('slow');
    }
    varshow=false;
}
/*********PopUP*************/ 
//Fonction de popup
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
    $('#fade').css({
        'filter' : 'alpha(opacity=80)'
    }).fadeIn();

    return false;
}

//Fermeture de la pop-up et du fond
$('a.close, #fade').live('click', function() { //Au clic sur le bouton ou sur le calque...
    $('#fade , .popup_block').fadeOut(function() {
        $('#fade, a.close').remove();  //...ils disparaissent ensemble
    });
    return false;
});
    
    
/**********Affichage attenta Friend************/ 
            
             
function afficheInfo(){
    var buff = '';
        
    //faire un service pour get nom by id
        
    $('#sous_menui').append('<p class="mid"></p>');
}
    
function afficheAttF(){
        
    $('#cpt')[0].firstChild.data = listfriendAtt.friendList.length;
    if(listfriendAtt.friendList.length>0){
        $('#friendAtt').find('p').remove();
        for(var i =0;i<listfriendAtt.friendList.length;i++){
            $('#friendAtt').append('<p>'+listfriendAtt.friendList[i].nom +' '+listfriendAtt.friendList[i].prenom +' <span ><a class="button" href="#" onclick="accFriend(\''+listfriendAtt.friendList[i].idU+'\',\'true\')" >Accepter</a></span> <span> <a class="button" href="#" onclick="accFriend(\''+listfriendAtt.friendList[i].idU+'\',\'false\')" >Refuser </a> </span></p>');
        }
    }
       
}
    
    
/**********Deconexion************/  
            
//Deco le mec
function deco(){
    suppCook(readCookie('key_u')); 
}
    
    
    
//Stuff affichage commentaire
function hideShowCom(id_p){
    $(id_p).slideToggle('slow');
}
    
    
    
            /**********************/ 
            /**********************/ 
            /**********************/
              /**********************/
              /**********************/
              
              
              
                /**********************/  
                /**********************/
                /**********************/  
                /**********************/
                
                
              
              
              
              
            
            
            
            
            