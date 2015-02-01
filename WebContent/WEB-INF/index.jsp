<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="utf-8" />
        <title>Architecture N-tiers</title>

        <!-- BOOTSRAP -->
        <!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">   
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">  
		<!-- MY CSS -->
        
        <link rel="stylesheet" href="<c:url value="/styles/main.css"/>">
        
        <!-- MY SCRIPT -->       
    </head>
    <body>

    	<div class="page-header">
  			<h1>Architecture N-tiers</h1>
		</div>


		<!-- Panel for the login -->
		<div class="container" style="margin-top:30px">
			<div class="col-md-6 col-md-offset-3">
			    <div class="panel panel-default">
			  		<div class="panel-heading"><h3 class="panel-title"><strong>Look for ...?</strong></h3>
			  		</div>
			  	<div class="panel-body">
			    <form action="<c:url value="/"/>" method="post" role="form">
			  		<div class="form-group">
			    		<label for="exampleInputEmail1">Nom</label>
			    		<input type="text" class="form-control" id="exampleInputEmail1" name="nom" placeholder="Enter nom">
			  		</div>
			  		<div class="form-group">
			    		<label for="exampleInputPassword1">Prenom</label>
			    		<input type="text" class="form-control" id="exampleInputPassword1" name="prenom" placeholder="Enter prenom">
			  		</div>
			  		<button type="submit" class="btn btn-success" name="searchBTN">Search</button>
				</form>
			 </div>
		</div>
		</div>


		

		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	  	<!-- BOOTSTRAP -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>  
    </body>
</html>