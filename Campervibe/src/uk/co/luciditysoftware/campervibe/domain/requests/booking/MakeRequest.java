package uk.co.luciditysoftware.campervibe.domain.requests.booking;

import java.util.*;
import uk.co.luciditysoftware.campervibe.domain.entities.*;

public class MakeRequest {
	private Date startDate;
	private Date endDate;
	private Vehicle vehicle;
	//private virtual Customer Customer { get; set; }
	
	public Date getStartDate() 
	{
		return startDate;
	}
	
	public void setStartDate(Date startDate) 
	{
		this.startDate = startDate;
	}
	
	public Date getEndDate() 
	{
		return endDate;
	}
	
	public void setEndDate(Date endDate) 
	{
		this.endDate = endDate;
	}
	
	public Vehicle getVehicle() 
	{
		return vehicle;
	}
	
	public void setVehicle(Vehicle vehicle) 
	{
		this.vehicle = vehicle;
	}
}
