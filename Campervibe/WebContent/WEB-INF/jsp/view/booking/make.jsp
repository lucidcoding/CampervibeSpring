<%--@elvariable id="viewModel" type="uk.co.lucditysoftware.campervibe.site.viewmodels.booking.MakeViewModel"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Make Booking</title>
        <link href="<c:url value="/resource/bower_components/bootstrap/dist/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
	    <link href="<c:url value="/resource/bower_components/bootstrap/dist/css/bootstrap-theme.css" />" rel="stylesheet" type="text/css" />
	    <script src="<c:url value="/resource/bower_components/jquery/dist/jquery.js" />" type="application/javascript"></script>
	    <script src="<c:url value="/resource/bower_components/jquery-validation/jquery.validate.js" />" type="application/javascript"></script>
	    <script src="<c:url value="/resource/bower_components/jquery-validation/additional-methods.js" />" type="application/javascript"></script>
	    <script src="<c:url value="/resource/bower_components/bootstrap/dist/js/bootstrap.js" />" type="application/javascript"></script>
    </head>
    <body>
    	<h1>Make Booking</h1>
		<form:form method="POST" action="make" commandName="viewModel" role="form" class="form-horizontal" >
			<div class="form-group" >
				<label class="control-label col-sm-3" for="vehicleId">Vehicle</label>
		        <div class="col-sm-6">
		        	<select id="vehicleId" name="vehicleId" class="form-control">
		    			<c:forEach items="${viewModel.vehicleOptions}" var="option">
		        			<option value="${option.value}" >${option.text}</option>
						</c:forEach>
		        	</select>
		        	<form:errors path="vehicleId" cssClass="error"/>
		        </div>
		    </div>
    		<div id="pendingBookingsForVehicleDiv">
    		</div>
		    <div class="form-group" >
				<label class="control-label col-sm-3" for="startDate">Start Date</label>
		        <div class="col-sm-6">
		        	<input id="startDate" name="startDate" type="date" class="form-control" value="${viewModel.startDate}" />
		        </div>
		    </div>
		    <div class="form-group" >
				<label class="control-label col-sm-3" for="endDate">End Date</label>
		        <div class="col-sm-6">
		        	<input id="endDate" name="endDate" type="date" class="form-control"  value="${viewModel.startDate}"/>
		        </div>
		    </div>
		    <div class="form-group">        
		        <div class="col-sm-offset-3 col-sm-9">
		            <button type="submit" class="btn btn-success">Submit</button>
		        </div>
		    </div>
	    </form:form>
	    <script src="<c:url value="/resource/scripts/booking/make.js" />" type="application/javascript"></script>
    </body>
</html>