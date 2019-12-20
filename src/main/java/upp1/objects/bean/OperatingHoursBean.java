package upp1.objects.bean;

public class OperatingHoursBean {
	int siteid, dayoftheweek;
	String opentime, closetime;
	boolean closed;

	public OperatingHoursBean(int siteid, int dayoftheweek, String opentime, String closetime, boolean closed) {
		setSiteid(siteid);
		setDayoftheweek(dayoftheweek);
		setOpentime(opentime);
		setClosetime(closetime);
		setClosed(closed);
	}

	public int getSiteid() {
		return siteid;
	}

	public void setSiteid(int siteid) {
		this.siteid = siteid;
	}

	public int getDayoftheweek() {
		return dayoftheweek;
	}

	public void setDayoftheweek(int dayoftheweek) {
		this.dayoftheweek = dayoftheweek;
	}

	public String getOpentime() {
		return opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	public String getClosetime() {
		return closetime;
	}

	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

}
