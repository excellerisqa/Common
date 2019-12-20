package upp1.objects.bean;

public class FutureorHistoryAppointmentsBeans {

	private int siteid, customerid, appointmentid;
	private String date, time, name, confirmation, address1, city, state;
	private boolean isdependent;

	public FutureorHistoryAppointmentsBeans(int SiteID, int CustomerID, String Date, String Time, int AppointmentID, String Name, String Confirmation, boolean IsDependent, String Address1,
			String City, String State) {
		setSiteid(SiteID);
		setCustomerid(CustomerID);
		setDate(Date);
		setTime(Time);
		setAppointmentid(AppointmentID);
		setName(Name);
		setConfirmation(Confirmation);
		setIsdependent(IsDependent);
		setAddress1(Address1);
		setCity(City);
		setState(State);
	}

	public int getSiteid() {
		return siteid;
	}

	public void setSiteid(int siteid) {
		this.siteid = siteid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getAppointmentid() {
		return appointmentid;
	}

	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isIsdependent() {
		return isdependent;
	}

	public void setIsdependent(boolean isdependent) {
		this.isdependent = isdependent;
	}

}
