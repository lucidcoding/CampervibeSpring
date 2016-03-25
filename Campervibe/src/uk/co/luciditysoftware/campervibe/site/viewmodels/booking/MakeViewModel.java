package uk.co.luciditysoftware.campervibe.site.viewmodels.booking;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import uk.co.luciditysoftware.campervibe.site.viewmodels.common.SelectListOption;
import javax.validation.constraints.NotNull;

public class MakeViewModel {
	private List<SelectListOption> vehicleOptions;
	
	@NotNull(message = "This field is required")
	private UUID vehicleId;
	
	private Date startDate;
	private Date endDate;

	public List<SelectListOption> getVehicleOptions() {
		return vehicleOptions;
	}

	public void setVehicleOptions(List<SelectListOption> vehicleOptions) {
		this.vehicleOptions = vehicleOptions;
	}

	public UUID getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(UUID vehicleId) {
		this.vehicleId = vehicleId;
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
