<%--@elvariable id="viewModel" type="uk.co.lucditysoftware.campervibe.site.viewmodels.booking.PendingForVehicleViewModel"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Existing Bookings</h3>
    </div>
    <div class="panel-body">
        <table class="table table-striped table-bordered">
            <tr>
                <th>
                    BookingNumber
                </th>
                <th>
                    StartDate
                </th>
                <th>
                    EndDate
                </th>
            </tr>
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
	    		</tr>
			</c:forEach>
        </table>
    </div>
</div>
