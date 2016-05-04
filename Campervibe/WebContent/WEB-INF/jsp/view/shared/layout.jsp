<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<tiles:insertAttribute name="header" />
</head>
<body class="campervibe">
<header role="banner">
        <nav class="navbar navbar-inverse" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="../" class="navbar-brand">
                        Campervibe
                    </a>
                </div>
                <div id="navbar" class="navbar-collapse collapse" >
                    <ul class="nav navbar-nav">
                        <li>
                        	<a href="<c:url value="/booking/index"></c:url>">
								Home
							</a>
						</li>
                        <li>
                        	<a href="<c:url value="/booking/make"></c:url>">
								Book a Vehicle
							</a>
						</li>
                    </ul>
                    <!-- @if (Request.IsAuthenticated)
                    {
                        using (Html.BeginForm("LogOff", "Account", FormMethod.Post, new { id = "logoutForm", @class = "navbar-right" }))
                        {
                            @Html.AntiForgeryToken()
                            <ul class="nav navbar-nav navbar-right">
                                <li class="dropdown-open">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Signed In<span class="caret"></span></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="javascript:document.getElementById('logoutForm').submit()">Sign Out</a></li>
                                        <li>@Html.ActionLink("My Bookings", "Index", "Booking", routeValues: null, htmlAttributes: null)</li>
                                    </ul>
                                </li>
                            </ul>
                        }
                    }
                    else
                    {
                        <ul class="nav navbar-nav navbar-right">
                            <li>@Html.ActionLink("Sign In", "Login", "Account", routeValues: null, htmlAttributes: null)</li>
                            <li>@Html.ActionLink("Register", "Register", "Account", routeValues: null, htmlAttributes: null)</li>
                        </ul>
                    } -->
                </div>
            </div>
        </nav>
    </header>
    <main role="main" class="container-fluid">
		<tiles:insertAttribute name="body" />
    </main>
	<script
		src="<c:url value="/resource/bower_components/jquery/dist/jquery.js" />"
		type="application/javascript"></script>
	<script
		src="<c:url value="/resource/bower_components/jquery-validation/jquery.validate.js" />"
		type="application/javascript"></script>
	<script
		src="<c:url value="/resource/bower_components/jquery-validation/additional-methods.js" />"
		type="application/javascript"></script>
	<script
		src="<c:url value="/resource/bower_components/bootstrap/dist/js/bootstrap.js" />"
		type="application/javascript"></script>
	<tiles:insertAttribute name="scripts" />
</body>
</html>