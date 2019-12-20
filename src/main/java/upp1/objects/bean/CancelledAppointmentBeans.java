package upp1.objects.bean;

public class CancelledAppointmentBeans {
	private String date, cancelleddate, name, role, SiteAddress, confirmation;
	private boolean isdependent;

	public CancelledAppointmentBeans(String Date, String CancelledDate, String CustomerName, String SiteAddress, String Confirmation, boolean IsDependent) {
		setDate(Date);
		setCancelleddate(CancelledDate);
		setName(CustomerName);
		setSiteAddress(SiteAddress);
		setConfirmation(Confirmation);
		setIsdependent(IsDependent);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCancelleddate() {
		return cancelleddate;
	}

	public void setCancelleddate(String cancelleddate) {
		this.cancelleddate = cancelleddate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSiteAddress() {
		return SiteAddress;
	}

	public void setSiteAddress(String siteAddress) {
		SiteAddress = siteAddress;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public boolean isIsdependent() {
		return isdependent;
	}

	public void setIsdependent(boolean isdependent) {
		this.isdependent = isdependent;
	}

}
