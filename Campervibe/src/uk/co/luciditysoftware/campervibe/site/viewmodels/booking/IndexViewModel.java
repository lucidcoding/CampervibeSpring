package uk.co.luciditysoftware.campervibe.site.viewmodels.booking;

import java.util.List;

public class IndexViewModel {
	private List<IndexViewModelRow> bookings;

	public List<IndexViewModelRow> getBookings() {
		return bookings;
	}

	public void setBookings(List<IndexViewModelRow> bookings) {
		this.bookings = bookings;
	}
}
