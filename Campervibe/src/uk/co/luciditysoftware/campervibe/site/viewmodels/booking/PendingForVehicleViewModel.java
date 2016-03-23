package uk.co.luciditysoftware.campervibe.site.viewmodels.booking;

import java.util.List;

public class PendingForVehicleViewModel {
	private List<PendingForVehicleViewModelRow> bookings;

	public List<PendingForVehicleViewModelRow> getBookings() {
		return bookings;
	}

	public void setBookings(List<PendingForVehicleViewModelRow> bookings) {
		this.bookings = bookings;
	}
}
