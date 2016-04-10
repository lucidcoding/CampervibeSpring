<%--@elvariable id="viewModel" type="uk.co.lucditysoftware.campervibe.site.viewmodels.account.RegisterViewModel"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <link href="<c:url value="/resource/bower_components/bootstrap/dist/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
	    <link href="<c:url value="/resource/bower_components/bootstrap/dist/css/bootstrap-theme.css" />" rel="stylesheet" type="text/css" />
	    <script src="<c:url value="/resource/bower_components/jquery/dist/jquery.js" />" type="application/javascript"></script>
	    <script src="<c:url value="/resource/bower_components/jquery-validation/jquery.validate.js" />" type="application/javascript"></script>
	    <script src="<c:url value="/resource/bower_components/jquery-validation/additional-methods.js" />" type="application/javascript"></script>
	    <script src="<c:url value="/resource/bower_components/bootstrap/dist/js/bootstrap.js" />" type="application/javascript"></script>
    </head>
    <body>
    	<h1>Register</h1>
		<form:form method="POST" action="register" commandName="viewModel" role="form" class="form-horizontal" novalidate="true" >
		    <div class="form-group" >
				<label class="control-label col-sm-3" for="startDate">Username (Email Address)</label>
		        <div class="col-sm-6">
		        	<input id="username" name="username" type="email" class="form-control" value="${viewModel.username}" />
		        	<form:errors path="username" cssClass="error"/>
		        </div>
		    </div>
		    <div class="form-group" >
				<label class="control-label col-sm-3" for="endDate">Password</label>
		        <div class="col-sm-6">
		        	<input id="password" name="password" type="password" class="form-control"  value=""/>
		        	<form:errors path="password" cssClass="error"/>
		        </div>
		    </div>
		    <div class="form-group" >
				<label class="control-label col-sm-3" for="endDate">Confirm Password</label>
		        <div class="col-sm-6">
		        	<input id="confirmPassword" name="confirmPassword" type="password" class="form-control"  value=""/>
		        	<form:errors path="confirmPassword" cssClass="error"/>
		        </div>
		    </div>
		    <div class="form-group" >
				<label class="control-label col-sm-3" for="endDate">First Name</label>
		        <div class="col-sm-6">
		        	<input id="firstName" name="firstName" type="text" class="form-control"  value="${viewModel.firstName}"/>
		        	<form:errors path="firstName" cssClass="error"/>
		        </div>
		    </div>
		    <div class="form-group" >
				<label class="control-label col-sm-3" for="endDate">Last Name</label>
		        <div class="col-sm-6">
		        	<input id="lastName" name="lastName" type="text" class="form-control"  value="${viewModel.lastName}"/>
		        	<form:errors path="lastName" cssClass="error"/>
		        </div>
		    </div>
		    <div class="form-group">        
		        <div class="col-sm-offset-3 col-sm-9">
		            <button type="submit" class="btn btn-success">Submit</button>
		        </div>
		    </div>
	    </form:form>
    </body>
</html>