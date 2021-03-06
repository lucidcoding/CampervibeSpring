package uk.co.luciditysoftware.campervibe.site.viewmodels.booking;

import java.util.Date;
import java.util.UUID;

import uk.co.luciditysoftware.campervibe.domain.entities.Booking;

public class IndexViewModelRow {
	private UUID id;
	private String bookingNumber;
	private Date startDate;
	private Date endDate;
	private String vehicleName;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	public IndexViewModelRow(Booking booking) {
		//this.id = booking.getId();
		this.bookingNumber = booking.getBookingNumber();
		this.startDate = booking.getStartDate();
		this.endDate = booking.getEndDate();
		this.vehicleName = booking.getVehicle().getName();
	}
}
