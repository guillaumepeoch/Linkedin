<%@ page pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8" />
<title>Architecture N-tiers</title>

		<link rel="stylesheet" href="<c:url value="/styles/main.css"/>">
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
        <div class="col-xs-12 col-sm-10 col-md-8 col-lg-8 col-sm-offset-1 col-md-offset-2 col-lg-offset-2 toppad" > 
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">Voici le profil !</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-12 col-lg-12 " align="center" >
                	<img class="img-circle"  alt="User Pic" src="<c:out value="${profil.photoLinkedin}"/>">                	
                </div>   
                <br>             
                <div class="col-xs-12 col-sm-12 hidden-md hidden-lg"> <br></div>
                <div class=" col-md-12 col-lg-12 "> 
                  <table class="table table-user-information">
                    <tbody>
                    	<tr>                      
                        	<td>Nom:</td>
                        	<td><c:out value="${profil.nom}" /></td>   
                        </tr>                   
                      	<tr>
                        	<td>Prenom:</td>
                        	<td><c:out value="${profil.prenom}"/></td>
                      	</tr>
                      	<tr>
                        	<td>URL Linkedin:</td>
                        	<td>
                        		<a href="<c:out value="${profil.urlLinkedin}"/>"><c:out value="${profil.urlLinkedin}" /></a>
                        	</td>                        	
                      	</tr>
                      	<tr>
                        	<td>Nombre de contact(s):</td>
                        	<td><c:out value="${profil.nombreContact}" /></td>
                      	</tr>
                      	<tr>
                        	<td>Entreprise Actuelle:</td>
                        	<td><c:out value="${profil.entreprise}" /></td>
                     	</tr>
                      	<tr>
                        	<td>Secteur d'activités:</td>
                        	<td><c:out value="${profil.secteurActivites}" /></td>
                      	</tr>
                      	<tr>
                        	<td>Region Linkedin</td>
                        	<td><c:out value="${profil.region}" /></td>
                      	</tr>
                    </tbody>
                  </table>                                
                </div>                
              </div>				
            </div>             
          </div>
           <div align="center">
              	<a href="<c:url value="/"/>"><button class="btn btn-success" name="searchBTN">Nouvelle Recherche</button>	</a>
              </div>
        </div>
      </div>
    </div>


		

		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	  	<!-- BOOTSTRAP -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>  
		<script src="<c:url value="/scripts/script.js"/>"></script>
    </body>
</html>