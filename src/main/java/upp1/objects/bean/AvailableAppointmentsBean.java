package upp1.objects.bean;

public class AvailableAppointmentsBean {

	private String slotid, selectedday, slots;

	public AvailableAppointmentsBean(String slotids, String selecteddays, String slots) {
		setSlotid(slotids);
		setSelectedday(selecteddays);
		setSlots(slots);
	}

	public String getSlotid() {
		return slotid;
	}

	public void setSlotid(String slotid) {
		this.slotid = slotid;
	}

	public String getSelectedday() {
		return selectedday;
	}

	public void setSelectedday(String selectedday) {
		this.selectedday = selectedday;
	}

	public String getSlots() {
		return slots;
	}

	public void setSlots(String slots) {
		this.slots = slots;
	}

}
