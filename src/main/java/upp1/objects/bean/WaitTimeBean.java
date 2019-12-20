package upp1.objects.bean;

public class WaitTimeBean {

	int siteId, wait;

	public WaitTimeBean() {

	}

	public WaitTimeBean(int siteid, int wait) {
		setSiteId(siteid);
		setWait(wait);
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public int getWait() {
		return wait;
	}

	public void setWait(int wait) {
		this.wait = wait;
	}

}
