package upp1.objects.bean;

public class AnnouncementMessageBean {

	String title, message;

	public AnnouncementMessageBean(String title, String message) {
		setTitle(title);
		setMessage(message);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
