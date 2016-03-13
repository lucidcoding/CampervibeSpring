//package uk.co.luciditysoftware.campervibe.tests.domain.entities.vehicle;
//
//import static org.junit.Assert.*;
//
//import java.util.*;
//import org.junit.*;
//import java.text.*;
//import uk.co.luciditysoftware.campervibe.domain.entities.*;
//
//public class GetConflictingBookingsTests 
//{
//	private Vehicle vehicle;
//	private SimpleDateFormat dateFormat;
//	
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception 
//	{
//	}
//
//	@Before
//	public void setUp() throws Exception 
//	{
//		vehicle = new Vehicle();
//		List<Booking> bookings = new ArrayList<Booking>();
//		dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
//
//		bookings.add(new Booking() 
//		{{
//			setStartDate(dateFormat.parse("16-11-2015 00:00:00"));
//			setEndDate(dateFormat.parse("20-11-2015 00:00:00"));
//			setVehicle(vehicle);
//		}});
//		
//		bookings.add(new Booking() 
//		{{
//			setStartDate(dateFormat.parse("02-11-2015 00:00:00"));
//			setEndDate(dateFormat.parse("06-11-2015 00:00:00"));
//			setVehicle(vehicle);
//		}});
//		
//		vehicle.setBookings(bookings);
//	}
//
//	/**
//	 * Test the case when start date and end date are before the earlier booking. No conflicting bookings
//	 * should be returned.
//	 * @throws ParseException
//	 */
//	@Test
//	public void nothingReturnedIfBeforeEarliestBooking() throws ParseException 
//	{
//		//Act.
//		List<Booking> result = vehicle.getConflictingBookings(
//				dateFormat.parse("26-10-2015 00:00:00"), 
//				dateFormat.parse("30-10-2015 00:00:00"));
//		
//		//Assert.
//		assertEquals(0, result.size());
//	}
//
//	/**
//	 * Test the case when start date is before start of a conflicting booking, and end date is equal to 
//	 * the start date. The conflicting booking should be returned.
//	 * @throws ParseException
//	 */
//	@Test
//	public void returnsBookingIfStartDateBeforeAndEndDateEqualsStart() throws ParseException 
//	{
//		//Act.
//		List<Booking> result = vehicle.getConflictingBookings(
//			dateFormat.parse("31-10-2015 00:00:00"), 
//			dateFormat.parse("02-11-2015 00:00:00"));
//				
//		//Assert.
//		assertEquals(1, result.size());
//	}
//
//	/**
//	 * Test the case when start date is before start of a conflicting booking, and end date is after 
//	 * the start date. The conflicting booking should be returned.
//	 * @throws ParseException
//	 */
//	@Test
//	public void returnsBookingIfStartDateIsBeforeAndEndIsAfterStart() throws ParseException 
//	{
//		//Act.
//		List<Booking> result = vehicle.getConflictingBookings(
//			dateFormat.parse("31-10-2015 00:00:00"), 
//			dateFormat.parse("03-11-2015 00:00:00"));
//				
//		//Assert.
//		assertEquals(1, result.size());
//	}
//	
//	/**
//	 * Test the case when start date is on the start date of a conflicting booking, and end date is after 
//	 * the start date. The conflicting booking should be returned.
//	 * @throws ParseException
//	 */
//	@Test
//	public void returnsBookingIfStartDateIsEqualAndEndIsAfterStart() throws ParseException 
//	{
//		//Act.
//		List<Booking> result = vehicle.getConflictingBookings(
//			dateFormat.parse("02-11-2015 00:00:00"), 
//			dateFormat.parse("03-11-2015 00:00:00"));
//				
//		//Assert.
//		assertEquals(1, result.size());
//	}
//	
//	/**
//	 * Test the case when start date is on the start date of a conflicting booking, and end date is on 
//	 * the end date. The conflicting booking should be returned.
//	 * @throws ParseException
//	 */
//	@Test
//	public void returnsBookingIfStartEqualsStartAndEndEqualsEnd() throws ParseException 
//	{
//		//Act.
//		List<Booking> result = vehicle.getConflictingBookings(
//			dateFormat.parse("02-11-2015 00:00:00"), 
//			dateFormat.parse("06-11-2015 00:00:00"));
//				
//		//Assert.
//		assertEquals(1, result.size());
//	}
//
//	/**
//	 * Test the case when start date is after the start date of a conflicting booking, and end date is on 
//	 * the end date. The conflicting booking should be returned.
//	 * @throws ParseException
//	 */
//	@Test
//	public void returnsBookingIfStartAfterStartAndEndEqualsEnd() throws ParseException 
//	{
//		//Act.
//		List<Booking> result = vehicle.getConflictingBookings(
//			dateFormat.parse("03-11-2015 00:00:00"), 
//			dateFormat.parse("06-11-2015 00:00:00"));
//				
//		//Assert.
//		assertEquals(1, result.size());
//	}
//
//	/**
//	 * Test the case when start date is after the start date of a conflicting booking, and end date is 
//	 * after the end date. The conflicting booking should be returned.
//	 * @throws ParseException
//	 */
//	@Test
//	public void returnsBookingIfStartAfterStartAndEndAfterEnd() throws ParseException 
//	{
//		//Act.
//		List<Booking> result = vehicle.getConflictingBookings(
//			dateFormat.parse("03-11-2015 00:00:00"), 
//			dateFormat.parse("07-11-2015 00:00:00"));
//				
//		//Assert.
//		assertEquals(1, result.size());
//	}
//
//	/**
//	 * Test the case when start date is on the end date of a conflicting booking, and end date is 
//	 * after the end date. The conflicting booking should be returned.
//	 * @throws ParseException
//	 */
//	@Test
//	public void returnsBookingIfStartEqualsEndAndEndAfterEnd() throws ParseException 
//	{
//		//Act.
//		List<Booking> result = vehicle.getConflictingBookings(
//			dateFormat.parse("06-11-2015 00:00:00"), 
//			dateFormat.parse("08-11-2015 00:00:00"));
//				
//		//Assert.
//		assertEquals(1, result.size());
//	}
//
//	/**
//	 * Test the case when start date is after the end date of a conflicting booking, and end date is 
//	 * after the end date. No conflicting bookings should be returned.
//	 * @throws ParseException
//	 */
//	@Test
//	public void returnsNothingIfStartAfterEndAndEndAfterEnd() throws ParseException 
//	{
//		//Act.
//		List<Booking> result = vehicle.getConflictingBookings(
//			dateFormat.parse("08-11-2015 00:00:00"), 
//			dateFormat.parse("09-11-2015 00:00:00"));
//				
//		//Assert.
//		assertEquals(0, result.size());
//	}
//
//	/**
//	 * Test the case when start date is after the start date of a conflicting booking, and end date is 
//	 * before the end date. The conflicting booking should be returned.
//	 * @throws ParseException
//	 */
//	@Test
//	public void returnsBookingIfStartAfterStartAndEndBeforeEnd() throws ParseException 
//	{
//		//Act.
//		List<Booking> result = vehicle.getConflictingBookings(
//			dateFormat.parse("03-11-2015 00:00:00"), 
//			dateFormat.parse("05-11-2015 00:00:00"));
//				
//		//Assert.
//		assertEquals(1, result.size());
//	}
//}
