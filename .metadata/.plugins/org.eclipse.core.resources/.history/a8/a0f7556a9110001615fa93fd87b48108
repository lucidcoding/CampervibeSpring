<%-- elvariable id="viewModel" type="uk.co.lucditysoftware.campervibe.site.viewmodels.booking.IndexViewModel"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Bookings</title>
    </head>
    <body>
    	<h1>Bookings</h1>
    	<img src="<c:url value="/resource/images/CoolCats.gif" />" alt="Cool Cats" />
    	<p>
    		<a href="<c:url value="/booking/make"></c:url>">Create Ticket</a>
    	<p/>
        <p>Records: ${bookingDatabase.size() }
        <table>
        	<thead>
        		<tr>
	        		<th>Booking Number</th>
	        		<th>Start Date</th>
	        		<th>End Date</th>
	        		<th>Bus</th>
	        		<th></th>
        		</tr>
        	</thead>
		    <c:forEach items="${viewModel.bookings}" var="booking">
		    	<tr>
			    	<td>
			    		<c:out value="${booking.bookingNumber}"/>
		    		</td>
		    		<td>
		    			<fmt:formatDate value="${booking.startDate}" type="date" dateStyle="long" />
		    		</td>
		    		<td>
		    			<fmt:formatDate value="${booking.endDate}" type="date" dateStyle="long" />
		    		</td>
		    		<td>
		    			${booking.vehicleName} 
		    		</td>
		    		<td>
		    			<a href="<c:url value="/booking/view">
							<c:param name="bookingId" value="${booking.id}" />
						</c:url>">View</a>
		    		</td>
	    		</tr>
			</c:forEach>
		</table>
		
    </body>
</html>
