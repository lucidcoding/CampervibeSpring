package uk.co.luciditysoftware.campervibe.site.viewmodels.booking;

import java.util.Date;

public class PendingForVehicleViewModelRow {
	private String bookingNumber;
	private String customerName;
	private Date startDate;
	private Date endDate;
	
	public String getBookingNumber() {
		return bookingNumber;
	}
	
	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
}
