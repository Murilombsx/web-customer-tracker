<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	
	<title>Login Page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<style>
		body{padding-top:60px;}
		.alert-fixed {
		    position:fixed; 
		    top: 0px; 
		    left: 0px; 
		    width: 100%;
		    z-index:9999; 
		    border-radius:0px
		}
	</style>
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

<div class="container">
	
	<c:if test="${param.error != null}">
		<div class="alert alert-danger alert-fixed">
			Invalid username or password.
		</div>
	</c:if>	
	
	<c:if test="${param.logout != null}">
		<div class="alert alert-success alert-fixed">
			You have been logged out.
		</div>
	</c:if>	
	
    <div class="row">
		<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			    	<h3 class="panel-title">Customer Login Page</h3>
			 	</div>
			  	<div class="panel-body">
			    	<form:form accept-charset="UTF-8" role="form" action="${pageContext.request.contextPath}/authenticateUser"
						method="POST">
	                   	<fieldset>
				    	  	<div class="form-group">
				    		    <input class="form-control" placeholder="Username" name="username" type="text">
				    		</div>
				    		<div class="form-group">
				    			<input class="form-control" placeholder="Password" name="password" type="password" value="">
				    		</div>
				    		<input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
			    		</fieldset>
			      	</form:form>
			    </div>
			</div>
		</div>
	</div>
</div>

</body>
</html>