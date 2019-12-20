package upp1.objects.bean;

public class AppointmentsSearchDataBean {

	public String Site_name, Street_Num, Street_Name, Street_Type, Street_Direction, Unit_Type, Unit_Num, Location, Address1, City, State, Zip, Phone, Hours, Map_Address, OperatingHours, WaitTime,
			AdditionalSiteInformation, Open_Hours_Today, Open_Hours_Tomorrow, Open_Hours_DayAfterTomorrow, fax, Open_Hours_WeekDays, Open_Hours_Saturday, Open_Hours_Sunday;

	public int SiteID;
	public double Distance, Latitude, Longitude;
	public boolean Open_Early, Open_Weekends, Open_Sundays, Wheelchair_Accessible, Availability_Today, Availability_Tomorrow, Availability_DayAfterTomorrow, Open_Saturdays, Show_Wait_Time,
			GetCheckedOnline, AutismServices, Does24HourHolterMonitoring, DoesAmbulatoryBloodPressureMonitoring, DoesEcg, OntarioHealthStudy, Closed, PermanentlyClosed, IsClosedToday,
			IsClosedTomorrow, IsClosedDayAfterTomorrow;

	WaitTimeBean waittime; // Child Object
	AnnouncementMessageBean announmentmessages;// Child Object
	OperatingHoursBean[] operatinghours; // Child Object

	public AppointmentsSearchDataBean() {}

	// With out wait time object
	public AppointmentsSearchDataBean(int SiteID, String Site_name, String Street_Num, String Street_Name, String Street_Type, String Street_Direction, String Unit_Type, String Unit_Num,
			String Location, String Address1, String City, String State, String Zip, String Phone, String Hours, String Map_Address, double Distance, double Latitude, double Longitude,
			boolean Open_Early, boolean Open_Weekends, boolean Wheelchair_Accessible, String Open_Hours_Today, String Open_Hours_Tomorrow, String Open_Hours_DayAfterTomorrow,
			boolean Availability_Today, boolean Availability_Tomorrow, boolean Availability_DayAfterTomorrow) {
		setSiteID(SiteID);
		setSite_name(Site_name);
		setStreet_Num(Street_Num);
		setStreet_Name(Street_Name);
		setStreet_Type(Street_Type);
		setStreet_Direction(Street_Direction);
		setUnit_Type(Unit_Type);
		setUnit_Num(Unit_Num);
		setLocation(Location);
		setAddress1(Address1);
		setCity(City);
		setState(State);
		setZip(Zip);
		setPhone(Phone);
		setHours(Hours);
		setMap_Address(Map_Address);
		setDistance(Distance);
		setLatitude(Latitude);
		setLongitude(Longitude);
		setOpen_Early(Open_Early);
		setOpen_Weekends(Open_Weekends);
		setOpen_Sundays(Open_Sundays);
		setWheelchair_Accessible(Wheelchair_Accessible);
		setOpen_Hours_Today(Open_Hours_Today);
		setOpen_Hours_Tomorrow(Open_Hours_Tomorrow);
		setOpen_Hours_DayAfterTomorrow(Open_Hours_DayAfterTomorrow);
		setAvailability_Today(Availability_Today);
		setAvailability_Tomorrow(Availability_Tomorrow);
		setAvailability_DayAfterTomorrow(Availability_DayAfterTomorrow);
		setwaittime(waittime);
	}

	// with wait time object
	public AppointmentsSearchDataBean(int SiteID, String Site_name, String Street_Num, String Street_Name, String Street_Type, String Street_Direction, String Unit_Type, String Unit_Num,
			String Location, String Address1, String City, String State, String Zip, String Phone, String Hours, String Map_Address, OperatingHoursBean[] ohb, WaitTimeBean waittime, double Distance,
			double Latitude, double Longitude, boolean Open_Early, boolean Open_Sundays, boolean Open_Saturdays, boolean Wheelchair_Accessible, String Open_Hours_Today, String Open_Hours_Tomorrow,
			String Open_Hours_DayAfterTomorrow, boolean Availability_Today, boolean Availability_Tomorrow, boolean Availability_DayAfterTomorrow, String Open_Hours_WeekDays,
			String Open_Hours_Saturday, String Open_Hours_Sunday, String Fax, String AdditionalSiteInformation, AnnouncementMessageBean AnnouncementMessage, boolean Show_Wait_Time,
			boolean GetCheckedOnline, boolean AutismServices, boolean Does24HourHolterMonitoring, boolean DoesAmbulatoryBloodPressureMonitoring, boolean DoesEcg, boolean OntarioHealthStudy,
			boolean Closed, boolean PermanentlyClosed, boolean IsClosedToday, boolean IsClosedTomorrow, boolean IsClosedDayAfterTomorrow) {
		setSiteID(SiteID);
		setSite_name(Site_name);
		setStreet_Num(Street_Num);
		setStreet_Name(Street_Name);
		setStreet_Type(Street_Type);
		setStreet_Direction(Street_Direction);
		setUnit_Type(Unit_Type);
		setUnit_Num(Unit_Num);
		setLocation(Location);
		setAddress1(Address1);
		setCity(City);
		setState(State);
		setZip(Zip);
		setPhone(Phone);
		setHours(Hours);
		setMap_Address(Map_Address);
		setOperatinghours(ohb);
		setwaittime(waittime);
		setDistance(Distance);
		setLatitude(Latitude);
		setLongitude(Longitude);
		setOpen_Early(Open_Early);
		setOpen_Sundays(Open_Sundays);
		setOpen_Saturdays(Open_Saturdays);
		setWheelchair_Accessible(Wheelchair_Accessible);
		setOpen_Hours_Today(Open_Hours_Today);
		setOpen_Hours_Tomorrow(Open_Hours_Tomorrow);
		setOpen_Hours_DayAfterTomorrow(Open_Hours_DayAfterTomorrow);
		setAvailability_Today(Availability_Today);
		setAvailability_Tomorrow(Availability_Tomorrow);
		setAvailability_DayAfterTomorrow(Availability_DayAfterTomorrow);
		setOpen_Hours_WeekDays(Open_Hours_WeekDays);
		setOpen_Hours_Saturday(Open_Hours_Saturday);
		setOpen_Hours_Sunday(Open_Hours_Sunday);
		setFax(Fax);
		setAdditionalSiteInformation(AdditionalSiteInformation);
		setAnnouncementMessage(AnnouncementMessage);
		setShow_Wait_Time(Show_Wait_Time);
		setGetCheckedOnline(GetCheckedOnline);
		setAutismServices(AutismServices);
		setDoes24HourHolterMonitoring(Does24HourHolterMonitoring);
		setDoesAmbulatoryBloodPressureMonitoring(DoesAmbulatoryBloodPressureMonitoring);
		setDoesEcg(DoesEcg);
		setOntarioHealthStudy(OntarioHealthStudy);
		setClosed(Closed);
		setPermanentlyClosed(PermanentlyClosed);
		setIsClosedToday(IsClosedToday);
		setIsClosedTomorrow(IsClosedTomorrow);
		setIsClosedDayAfterTomorrow(IsClosedDayAfterTomorrow);

	}

	public WaitTimeBean getwaitime() {
		return waittime;
	}

	public void setwaittime(WaitTimeBean wait) {
		waittime = wait;
	}

	public AnnouncementMessageBean getAnnouncementMessage() {
		return announmentmessages;
	}

	public void setAnnouncementMessage(AnnouncementMessageBean ann) {
		announmentmessages = ann;
	}

	public OperatingHoursBean[] getOperatinghours() {
		return operatinghours;
	}

	public void setOperatinghours(OperatingHoursBean[] ohb) {
		operatinghours = ohb;
	}

	public String getSite_name() {
		try {
			return Site_name;
		} catch (NullPointerException ne) {
			return "";
		}
	}

	public void setSite_name(String site_name) {
		Site_name = site_name;
	}

	public String getStreet_Num() {
		return Street_Num;
	}

	public void setStreet_Num(String street_Num) {
		Street_Num = street_Num;
	}

	public String getStreet_Name() {
		return Street_Name;
	}

	public void setStreet_Name(String street_Name) {
		Street_Name = street_Name;
	}

	public String getStreet_Type() {
		return Street_Type;
	}

	public void setStreet_Type(String street_Type) {
		Street_Type = street_Type;
	}

	public String getStreet_Direction() {
		return Street_Direction;
	}

	public void setStreet_Direction(String street_Direction) {
		Street_Direction = street_Direction;
	}

	public String getUnit_Type() {
		return Unit_Type;
	}

	public void setUnit_Type(String unit_Type) {
		Unit_Type = unit_Type;
	}

	public String getUnit_Num() {
		return Unit_Num;
	}

	public void setUnit_Num(String unit_Num) {
		Unit_Num = unit_Num;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getAddress1() {
		return Address1;
	}

	public void setAddress1(String address1) {
		Address1 = address1;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZip() {
		return Zip;
	}

	public void setZip(String zip) {
		Zip = zip;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getHours() {
		return Hours;
	}

	public void setHours(String hours) {
		Hours = hours;
	}

	public String getMap_Address() {
		return Map_Address;
	}

	public void setMap_Address(String map_Address) {
		Map_Address = map_Address;
	}

	public String getOperatingHours() {
		return OperatingHours;
	}

	public void setOperatingHours(String operatingHours) {
		OperatingHours = operatingHours;
	}

	public String getWaitTime() {
		return WaitTime;
	}

	public void setWaitTime(String waitTime) {
		WaitTime = waitTime;
	}

	public String getOpen_Hours_Today() {
		return Open_Hours_Today;
	}

	public void setOpen_Hours_Today(String open_Hours_Today) {
		Open_Hours_Today = open_Hours_Today;
	}

	public String getOpen_Hours_Tomorrow() {
		return Open_Hours_Tomorrow;
	}

	public void setOpen_Hours_Tomorrow(String open_Hours_Tomorrow) {
		Open_Hours_Tomorrow = open_Hours_Tomorrow;
	}

	public String getOpen_Hours_DayAfterTomorrow() {
		return Open_Hours_DayAfterTomorrow;
	}

	public void setOpen_Hours_DayAfterTomorrow(String open_Hours_DayAfterTomorrow) {
		Open_Hours_DayAfterTomorrow = open_Hours_DayAfterTomorrow;
	}

	public int getSiteID() {
		return SiteID;
	}

	public void setSiteID(int siteID) {
		SiteID = siteID;
	}

	public double getDistance() {
		return Distance;
	}

	public void setDistance(double distance) {
		Distance = distance;
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

	public boolean isOpen_Early() {
		return Open_Early;
	}

	public void setOpen_Early(boolean open_Early) {
		Open_Early = open_Early;
	}

	public boolean isOpen_Weekends() {
		return Open_Weekends;
	}

	public void setOpen_Weekends(boolean open_Weekends) {
		Open_Weekends = open_Weekends;
	}

	public boolean isOpen_Sundays() {
		return Open_Sundays;
	}

	public void setOpen_Sundays(boolean open_Sundays) {
		Open_Sundays = open_Sundays;
	}

	public boolean isWheelchair_Accessible() {
		return Wheelchair_Accessible;
	}

	public void setWheelchair_Accessible(boolean wheelchair_Accessible) {
		Wheelchair_Accessible = wheelchair_Accessible;
	}

	public boolean isAvailability_Today() {
		return Availability_Today;
	}

	public void setAvailability_Today(boolean availability_Today) {
		Availability_Today = availability_Today;
	}

	public boolean isAvailability_Tomorrow() {
		return Availability_Tomorrow;
	}

	public void setAvailability_Tomorrow(boolean availability_Tomorrow) {
		Availability_Tomorrow = availability_Tomorrow;
	}

	public boolean isAvailability_DayAfterTomorrow() {
		return Availability_DayAfterTomorrow;
	}

	public void setAvailability_DayAfterTomorrow(boolean availability_DayAfterTomorrow) {
		Availability_DayAfterTomorrow = availability_DayAfterTomorrow;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAdditionalSiteInformation() {
		return AdditionalSiteInformation;
	}

	public void setAdditionalSiteInformation(String additionalSiteInformation) {
		AdditionalSiteInformation = additionalSiteInformation;
	}

	public boolean isOpen_Saturdays() {
		return Open_Saturdays;
	}

	public void setOpen_Saturdays(boolean open_Saturdays) {
		Open_Saturdays = open_Saturdays;
	}

	public boolean isShow_Wait_Time() {
		return Show_Wait_Time;
	}

	public void setShow_Wait_Time(boolean show_Wait_Time) {
		Show_Wait_Time = show_Wait_Time;
	}

	public boolean isGetCheckedOnline() {
		return GetCheckedOnline;
	}

	public void setGetCheckedOnline(boolean getCheckedOnline) {
		GetCheckedOnline = getCheckedOnline;
	}

	public boolean isAutismServices() {
		return AutismServices;
	}

	public void setAutismServices(boolean autismServices) {
		AutismServices = autismServices;
	}

	public boolean isDoes24HourHolterMonitoring() {
		return Does24HourHolterMonitoring;
	}

	public void setDoes24HourHolterMonitoring(boolean does24HourHolterMonitoring) {
		Does24HourHolterMonitoring = does24HourHolterMonitoring;
	}

	public boolean isDoesAmbulatoryBloodPressureMonitoring() {
		return DoesAmbulatoryBloodPressureMonitoring;
	}

	public void setDoesAmbulatoryBloodPressureMonitoring(boolean doesAmbulatoryBloodPressureMonitoring) {
		DoesAmbulatoryBloodPressureMonitoring = doesAmbulatoryBloodPressureMonitoring;
	}

	public boolean isDoesEcg() {
		return DoesEcg;
	}

	public void setDoesEcg(boolean doesEcg) {
		DoesEcg = doesEcg;
	}

	public boolean isOntarioHealthStudy() {
		return OntarioHealthStudy;
	}

	public void setOntarioHealthStudy(boolean ontarioHealthStudy) {
		OntarioHealthStudy = ontarioHealthStudy;
	}

	public boolean isClosed() {
		return Closed;
	}

	public void setClosed(boolean closed) {
		Closed = closed;
	}

	public boolean isPermanentlyClosed() {
		return PermanentlyClosed;
	}

	public void setPermanentlyClosed(boolean permanentlyClosed) {
		PermanentlyClosed = permanentlyClosed;
	}

	public boolean isIsClosedToday() {
		return IsClosedToday;
	}

	public void setIsClosedToday(boolean isClosedToday) {
		IsClosedToday = isClosedToday;
	}

	public boolean isIsClosedTomorrow() {
		return IsClosedTomorrow;
	}

	public void setIsClosedTomorrow(boolean isClosedTomorrow) {
		IsClosedTomorrow = isClosedTomorrow;
	}

	public boolean isIsClosedDayAfterTomorrow() {
		return IsClosedDayAfterTomorrow;
	}

	public void setIsClosedDayAfterTomorrow(boolean isClosedDayAfterTomorrow) {
		IsClosedDayAfterTomorrow = isClosedDayAfterTomorrow;
	}

	public String getOpen_Hours_WeekDays() {
		return Open_Hours_WeekDays;
	}

	public void setOpen_Hours_WeekDays(String open_Hours_WeekDays) {
		Open_Hours_WeekDays = open_Hours_WeekDays;
	}

	public String getOpen_Hours_Saturday() {
		return Open_Hours_Saturday;
	}

	public void setOpen_Hours_Saturday(String open_Hours_Saturday) {
		Open_Hours_Saturday = open_Hours_Saturday;
	}

	public String getOpen_Hours_Sunday() {
		return Open_Hours_Sunday;
	}

	public void setOpen_Hours_Sunday(String open_Hours_Sunday) {
		Open_Hours_Sunday = open_Hours_Sunday;
	}
}
