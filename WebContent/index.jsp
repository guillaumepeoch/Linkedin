<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
        <title>Architecture N-tiers</title>

        <!-- MY CSS -->
        <link rel="stylesheet" href="styles/main.css">

        <!-- MY SCRIPT -->


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


		<!-- Panel for the login -->
		<div class="container" style="margin-top:30px">
			<div class="col-md-6 col-md-offset-3">
			    <div class="panel panel-default">
			  		<div class="panel-heading"><h3 class="panel-title"><strong>Look for ...?</strong></h3>
			  		</div>
			  	<div class="panel-body">
			    <form action="${pageContext.request.contextPath}/researchServlet" method="post" role="form">
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