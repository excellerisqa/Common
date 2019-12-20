package upp1.objects.bean;

public class SurroundingLabsBean {

	public int siteid;
	public String locname, slots, Stimeslots;
	public double distance;

	DateSlotsBean[] dateslots;
	TimeSlotesBean[] timeslots;

	public SurroundingLabsBean(int siteid, String locanme, double distance, DateSlotsBean[] dateslots, TimeSlotesBean[] timeslots) {
		setSiteid(siteid);
		setLocname(locanme);
		setDistance(distance);
		setDateslots(dateslots);
		setTimeslots(timeslots);
	}

	public SurroundingLabsBean(int siteid, String locanme, double distance, String slots, String Stimeslots) {
		setSiteid(siteid);
		setLocname(locanme);
		setDistance(distance);
		setSlots(slots);
		setStimeslots(Stimeslots);
	}

	public DateSlotsBean[] getDateslots() {
		return dateslots;
	}

	public void setDateslots(DateSlotsBean[] dateslots) {
		this.dateslots = dateslots;
	}

	public TimeSlotesBean[] getTimeslots() {
		return timeslots;
	}

	public void setTimeslots(TimeSlotesBean[] timeslots) {
		this.timeslots = timeslots;
	}

	public int getSiteid() {
		return siteid;
	}

	public void setSiteid(int siteid) {
		this.siteid = siteid;
	}

	public String getLocname() {
		return locname;
	}

	public void setLocname(String locname) {
		this.locname = locname;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getSlots() {
		return slots;
	}

	public void setSlots(String slots) {
		this.slots = slots;
	}

	public String getStimeslots() {
		return Stimeslots;
	}

	public void setStimeslots(String stimeslots) {
		Stimeslots = stimeslots;
	}

}
