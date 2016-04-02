<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Login</title>
        <link href="<c:url value="/resource/bower_components/bootstrap/dist/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
	    <link href="<c:url value="/resource/bower_components/bootstrap/dist/css/bootstrap-theme.css" />" rel="stylesheet" type="text/css" />
	    <script src="<c:url value="/resource/bower_components/jquery/dist/jquery.js" />" type="application/javascript"></script>
	    <script src="<c:url value="/resource/bower_components/jquery-validation/jquery.validate.js" />" type="application/javascript"></script>
	    <script src="<c:url value="/resource/bower_components/jquery-validation/additional-methods.js" />" type="application/javascript"></script>
	    <script src="<c:url value="/resource/bower_components/bootstrap/dist/js/bootstrap.js" />" type="application/javascript"></script>
    </head>
	<body>
		<h1>Login</h1>
		<form:form method="POST" action="login" role="form" class="form-horizontal">
			<div class="form-group">
				<label class="control-label col-sm-3" for="username">Username</label>
				<div class="col-sm-6">
	            	<input type="text" name="username" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="password">Password</label>
				<div class="col-sm-6">
	            	<input type="password" name="password" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-9">
					<button type="submit" class="btn btn-success">Login</button>
				</div>
			</div>
		</form:form>
	</body>
</html>