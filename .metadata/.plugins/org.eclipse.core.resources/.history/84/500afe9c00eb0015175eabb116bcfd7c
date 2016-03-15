package uk.co.luciditysoftware.campervibe.domain.entities;

import java.util.*;
import java.math.*;
import uk.co.luciditysoftware.campervibe.domain.requests.booking.*;
import uk.co.luciditysoftware.campervibe.domain.common.*;

public class Booking {
	//private UUID id;
	private long id;
	private String bookingNumber;
	private Date startDate;
	private Date endDate;
	private BigDecimal startMileage;
	private BigDecimal endMileage;
	private Vehicle vehicle;
	// private Customer Customer { get; set; }
	private Date collectedOn;
	private Date returnedOn;
	private BigDecimal total;

	/*public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public BigDecimal getStartMileage() {
		return startMileage;
	}

	public void setStartMileage(BigDecimal startMileage) {
		this.startMileage = startMileage;
	}

	public BigDecimal getEndMileage() {
		return endMileage;
	}

	public void setEndMileage(BigDecimal endMileage) {
		this.endMileage = endMileage;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Date getCollectedOn() {
		return collectedOn;
	}

	public void setCollectedOn(Date collectedOn) {
		this.collectedOn = collectedOn;
	}

	public Date getReturnedOn() {
		return returnedOn;
	}

	public void setReturnedOn(Date returnedOn) {
		this.returnedOn = returnedOn;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public static List<ValidationMessage> validateMake(MakeRequest request) {
		List<ValidationMessage> validationMessages = new ArrayList<ValidationMessage>();
		Date now = new Date();

		if (request.getStartDate() == null) {
			validationMessages.add(new ValidationMessage() {
				{
					setType(ValidationMessageType.ERROR);
					setField("StartDate");
					setText("Start date is required.");
				}
			});
		} else if (request.getStartDate().before(now)) {
			validationMessages.add(new ValidationMessage() {
				{
					setType(ValidationMessageType.ERROR);
					setField("StartDate");
					setText("Start date must not be in the past.");
				}
			});
		}

		if (request.getEndDate() == null) {
			validationMessages.add(new ValidationMessage() {
				{
					setType(ValidationMessageType.ERROR);
					setField("EndDate");
					setText("End date must not be in the past.");
				}
			});
		} else if (request.getEndDate().before(now)) {
			validationMessages.add(new ValidationMessage() {
				{
					setType(ValidationMessageType.ERROR);
					setField("EndDate");
					setText("End date must not be in the past.");
				}
			});
		}

		if (request.getStartDate() != null && request.getEndDate() != null
				&& request.getEndDate().before(request.getStartDate())) {
			validationMessages.add(new ValidationMessage() {
				{
					setType(ValidationMessageType.ERROR);
					setField("EndDate");
					setText("End date must not be before start date.");
				}
			});
		}

		if (request.getVehicle() == null) {
			validationMessages.add(new ValidationMessage() {
				{
					setType(ValidationMessageType.ERROR);
					setField("Vehicle");
					setText("Vehicle is required.");
				}
			});
		}

		// if (request.Customer == null) validationMessages.AddError("Customer",
		// "Customer is required.");

		/*if (request.getVehicle() != null && request.getStartDate() != null && request.getEndDate() != null && request
				.getVehicle().getConflictingBookings(request.getStartDate(), request.getEndDate()).size() > 0) {
			validationMessages.add(new ValidationMessage() {
				{
					setType(ValidationMessageType.ERROR);
					setField("");
					setText("Booking conflicts with existing bookings.");
				}
			});
		}*/

		return validationMessages;
	}

	public static Booking make(MakeRequest request) {
		Booking booking = new Booking();
		//booking.id = UUID.randomUUID();
		// booking.Id = Guid.NewGuid();
		//booking.bookingNumber = "BOOK-" + booking.id.toString();
		// DateTime.Now.ToString("yyMMddHHmmss");
		booking.startDate = request.getStartDate();
		booking.endDate = request.getEndDate();
		// booking.Customer = request.Customer;
		// booking.createdBy = request.Customer.User;
		booking.vehicle = request.getVehicle();
		long totalMilliseconds = request.getEndDate().getTime() - request.getStartDate().getTime();
		int totalDays = (int) (totalMilliseconds / (24 * 60 * 60 * 1000));
		booking.total = request.getVehicle().getPricePerDay().multiply(new BigDecimal(totalDays));
		return booking;
	}
}
