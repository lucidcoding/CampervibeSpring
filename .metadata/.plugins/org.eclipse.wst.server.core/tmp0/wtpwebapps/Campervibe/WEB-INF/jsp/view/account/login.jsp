<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h1>Login</h1>
<form:form method="POST" action="login" role="form"
	class="form-horizontal">
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
			<a href="<c:url value="/account/register"></c:url>"
				class="btn btn-success">Register</a>
		</div>
	</div>
</form:form>