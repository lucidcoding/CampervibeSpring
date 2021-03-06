$(document).ready(function () {
	$('#vehicleId').change(function (event) {
        event.preventDefault();

        var vehicleId = $('#vehicleId').val();

        if (vehicleId == "" || vehicleId == null)
        {
            $("#pendingBookingsForVehicleDiv").empty();
        }
        else
        {
            $.ajax({
                url: "pendingforvehicle/"  + vehicleId,
                type: "GET",
                success: function (result) {
                    $("#pendingBookingsForVehicleDiv").html(result);
                    //initialize();
                },
                error: function (jqXhr, textStatus, errorThrown) {
                    alert('error: ' + jqXhr + ', ' + textStatus + ', ' + errorThrown);
                }
            });
        }
    });
});