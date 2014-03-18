<%-- 
    Document   : index
    Created on : 9 févr. 2013, 15:04:49
    Author     : Steph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projet LI328</title>
    </head>
    <body>
        <h2>New User</h2>
        <form action="newuser" method="POST">
            <table summary="New User">
                <tr>
                    <td><label for="login">Identifiant : </label></td>
                    <td><input name="login" type="text" /></td>
                </tr>

                <tr>
                    <td><label for="pass">Mot de passe : </label></td>
                    <td><input name="pass" type="password" /></td>
                </tr>

                <tr>
                    <td><label for="pass">Prenom : </label></td>
                    <td><input name="fname" type="text" /></td>
                </tr>
                <tr>
                    <td><label for="name">Nom : </label></td>
                    <td><input name="name" type="text" /></td>
                </tr>
                <tr>
                    <td> <label for="mail">email : </label></td>
                    <td> <input name="mail" type="text" /></td>
                </tr>


            </table>
            <input name="Valider" type="submit" />

        </form>
        <h2>Login</h2>
        <form action="login" method="POST">
            <table>
                <tr>
                    <td><label for="login">Identifiant : </label></td>
                    <td><input name="login" type="text" /></td>
                </tr>

                <tr>
                    <td><label for="pass">Mot de passe : </label></td>
                    <td><input name="pass" type="password" /></td>
                </tr>



            </table>
            <input name="Valider" type="submit" />
        </form>

        <h2>Logout</h2>
        <form action="logout" method="POST">
            <table>
                <tr>
                    <td><label for="key">Key : </label></td>
                    <td><input name="key" type="text" /></td>
                </tr>





            </table>
            <input name="Valider" type="submit" />
        </form>
        <h2>Ajout commentaire</h2>
        <form action="addcomment" method="POST">
            <table>
                <tr>
                    <td><label for="login">Key : </label></td>
                    <td><input name="key" type="text" /></td>
                </tr>

                <tr>
                    <td><label for="pass">id Post: </label></td>
                    <td><input name="idP" type="text" /></td>
                </tr>

                <tr>
                    <td><label for="pass">Commentaire: </label></td>
                    <td><input name="text" type="text" /></td>
                </tr>



            </table>
            <input name="Valider" type="submit" />
        </form>

        <h2>Sup Post</h2>
        <form action="suppost" method="POST">
            <table>
                <tr>
                    <td><label for="login">Key : </label></td>
                    <td><input name="key" type="text" /></td>
                </tr>

                <tr>
                    <td><label for="login">idP : </label></td>
                    <td><input name="idP" type="text" /></td>
                </tr>

            </table>
            <input name="Valider" type="submit" />
        </form>




        <h2>Ajout POST </h2>
        <form action="addpost" method="POST" >
            <table>

                <tr>
                    <td><label for="login">Key : </label></td>
                    <td><input name="key" type="text" /></td>
                </tr>

                <tr>
                    <td><label for="login">idA : </label></td>
                    <td><input name="idA" type="text" /></td>
                </tr>

                <tr>
                    <td><label for="pass">text: </label></td>
                    <td><input name="text" type="text" /></td>
                </tr>

            </table>
            <input name="Valider" type="submit" />
        </form>

        <h2>Ajout Image</h2>
        <form action="addimg" method="POST" enctype="multipart/form-data">
            <table>


                <tr>
                    <td><label for="Image">Image : </label></td>
                    <td><input name="img" type="file" /></td>
                </tr>


            </table>
            <input name="Valider" type="submit" />
        </form>


        <h2>Like Post</h2>
        <form action="plike" method="POST">
            <table>
                <tr>
                    <td><label for="login">Key : </label></td>
                    <td><input name="key" type="text" /></td>
                </tr>

                <tr>
                    <td><label for="login">idP : </label></td>
                    <td><input name="idP" type="text" /></td>
                </tr>

                <tr>
                    <td><label for="pass">arg: </label></td>
                    <td><input name="arg" type="text" /></td>
                </tr>



            </table>
            <input name="Valider" type="submit" />
        </form>

        <h2>Ajout amis</h2>
        <form action="addfriend" method="POST">
            <table>
                <tr>
                    <td><label for="login">Key : </label></td>
                    <td><input name="key" type="text" /></td>
                </tr>

                <tr>
                    <td><label for="pass">Id amis : </label></td>
                    <td><input name="idF" type="text" /></td>
                </tr>



            </table>
            <input name="Valider" type="submit" />
        </form>

        <h2>Accepte amis</h2>
        <form action="accfriend" method="POST">
            <table>
                <tr>
                    <td><label for="login">Key : </label></td>
                    <td><input name="key" type="text" /></td>
                </tr>

                <tr>
                    <td><label for="pass">Id amis : </label></td>
                    <td><input name="idF" type="text" /></td>
                </tr>
                <tr>
                    <td><label for="pass">Ajoute ou sup (false / true) : </label></td>
                    <td><input name="accF" type="text" /></td>
                </tr>


            </table>
            <input name="Valider" type="submit" />
        </form>


        <h2>Supp amis</h2>
        <form action="removefriend" method="POST">
            <table>
                <tr>
                    <td><label for="login">Key : </label></td>
                    <td><input name="key" type="text" /></td>
                </tr>

                <tr>
                    <td><label for="pass">Id amis : </label></td>
                    <td><input name="idF" type="text" /></td>
                </tr>



            </table>
            <input name="Valider" type="submit" />
        </form>

        <h2>Search</h2>
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
        <form action="search" method="POST">
            <table>
                <tr>
                    <td><label for="text">Key : </label></td>
                    <td><input name="key" type="text" /></td>
                </tr>

                <tr>
                    <td><label for="text">Query: </label></td>
                    <td><input name="query" type="text" /></td>
                </tr>

                <tr>
                    <td><label for="text">Args: </label></td>
                    <td><input name="args" type="text" /></td>
                </tr>

            </table>
            <input name="Valider" type="submit" />
        </form>



    </body>
</html>
