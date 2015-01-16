<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="profil.Profil"%>
<%@page import="java.awt.Image"%>



<%
Profil profil = (Profil)request.getAttribute("profil");
String nom = profil.getNom();
String prenom = profil.getPrenom();
String urlLinkedin = profil.getUrlLinkedin();
int nombreContact = profil.getNombreContact();
String entreprise = profil.getEntreprise();
String secteurActivites = profil.getSecteurActivites();
Image photoLinkedin = profil.getPhotoLinkedin();
String region = profil.getRegion();
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Architecture N-tiers</title>

        <!-- MY CSS -->
        <link rel="stylesheet" href="styles/main.css">

        <script type='text/javascript' src='scripts/script.js'></script>

        <!-- BOOTSRAP -->
        <!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">   
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">  

    </head>


    <body>

    	<div class="page-header">
  			<h1>Architecture N-tiers</h1>
		</div>


		<div class="container">
      <div class="row">
      	<!--
      <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
           <A href="edit.html" >Edit Profile</A>

        <A href="edit.html" >Logout</A>
       <br>
<p class=" text-info">May 05,2014,03:00 pm </p>
      </div> -->
      <br>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
  
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">Nom Prenom</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src=<%=photoLinkedin %> class="img-circle"> </div>
                
                <div class="col-xs-10 col-sm-10 hidden-md hidden-lg"> <br>
                
                </div>
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                   
                      
                        <td>Nom:</td>
                        <td><%=nom %></td>
                      
                      <tr>
                        <td>Prenom:</td>
                        <td><%=prenom %></td>
                      </tr>
                      <tr>
                        <td>URL du profil linkedin:</td>
                        <!--<a href=<%= urlLinkedin %>>Lien Linkedin</a>-->
                        <td><%=urlLinkedin %></td>
                      </tr>
                      <tr>
                        <td>Nombre de contact:</td>
                        <td><%=nombreContact %></td>
                      </tr>
                      <tr>
                        <td>entreprise actuelle:</td>
                        <td><%=entreprise %></td>
                      </tr>
                      <tr>
                        <td>Secteur d'activités:</td>
                        <td><%=secteurActivites %></td>
                      </tr>
                      <tr>
                        <td>region linkedin</td>
                        <td><%=region %></td>
                      </tr>

                    </tbody>
                  </table>                                
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>


		

		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	  	<!-- BOOTSTRAP -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>  
    </body>
</html>