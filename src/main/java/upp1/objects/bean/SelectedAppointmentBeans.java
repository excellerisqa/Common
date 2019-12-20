package upp1.objects.bean;

public class SelectedAppointmentBeans {

	private int siteid, customerid, appointmentid;
	private double distance, Latitude, Longitude;
	private String datetimeday, name, siteloaction, phone, fax, weekdayopenhours, saturdayopenhours, sundayopenhours, additionalsiteinfo, StartTime, EndTime;

	OperatingHoursBean[] operatinghours; // Child Object

	public SelectedAppointmentBeans(int SiteId, int CustomerID, int AppointmentID, String DateTimeDay, String Name, String SiteLocation, double Distance, String Phone, String Fax,
			String WeekDayOpenHours, String SaturdayOpenhours, String SundayOpenHours, String AdditionalSiteInfo) {
		setSiteid(SiteId);
		setCustomerid(CustomerID);
		setAppointmentid(AppointmentID);
		setDatetimeday(DateTimeDay);
		setName(Name);
		setSiteloaction(SiteLocation);
		setDistance(Distance);
		setPhone(Phone);
		setFax(Fax);
		setWeekdayopenhours(WeekDayOpenHours);
		setSaturdayopenhours(SaturdayOpenhours);
		setSundayopenhours(SundayOpenHours);
		setAdditionalsiteinfo(AdditionalSiteInfo);

	}

	public SelectedAppointmentBeans(int SiteId, int CustomerID, int AppointmentID, String DateTimeDay, String starttime, String endtime, String Name, String SiteLocation, double latitude,
			double longitude, double Distance, String Phone, String Fax, OperatingHoursBean[] ohb, String AdditionalSiteInfo) {
		setSiteid(SiteId);
		setCustomerid(CustomerID);
		setAppointmentid(AppointmentID);
		setDatetimeday(DateTimeDay);
		setStartTime(starttime);
		setEndTime(endtime);
		setName(Name);
		setSiteloaction(SiteLocation);
		setLatitude(latitude);
		setLongitude(longitude);
		setDistance(Distance);
		setPhone(Phone);
		setFax(Fax);
		setOperatinghours(ohb);
		setAdditionalsiteinfo(AdditionalSiteInfo);
	}

	public OperatingHoursBean[] getOperatinghours() {
		return operatinghours;
	}

	public void setOperatinghours(OperatingHoursBean[] ohb) {
		operatinghours = ohb;
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

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getDatetimeday() {
		return datetimeday;
	}

	public void setDatetimeday(String datetimeday) {
		this.datetimeday = datetimeday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSiteloaction() {
		return siteloaction;
	}

	public void setSiteloaction(String siteloaction) {
		this.siteloaction = siteloaction;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWeekdayopenhours() {
		return weekdayopenhours;
	}

	public void setWeekdayopenhours(String weekdayopenhours) {
		this.weekdayopenhours = weekdayopenhours;
	}

	public String getSaturdayopenhours() {
		return saturdayopenhours;
	}

	public void setSaturdayopenhours(String saturdayopenhours) {
		this.saturdayopenhours = saturdayopenhours;
	}

	public String getSundayopenhours() {
		return sundayopenhours;
	}

	public void setSundayopenhours(String sundayopenhours) {
		this.sundayopenhours = sundayopenhours;
	}

	public String getAdditionalsiteinfo() {
		return additionalsiteinfo;
	}

	public void setAdditionalsiteinfo(String additionalsiteinfo) {
		this.additionalsiteinfo = additionalsiteinfo;
	}

	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public void setEndTime(String endTime) {
		EndTime = endTime;
	}

}
