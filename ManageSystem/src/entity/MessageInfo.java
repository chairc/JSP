package entity;

public class MessageInfo {
	private int messageid;
	private String messagemaintitle;
	private String messagetitle;
	private String messageinfo;
	
	private int addmessageid;
	private String addmessagename;
	private String addmessageinfo;
	
	
	public int getMessageid() {
		return messageid;
	}

	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}

	public String getMessageinfo() {
		return messageinfo;
	}

	public void setMessageinfo(String messageinfo) {
		this.messageinfo = messageinfo;
	}

	public String getMessagemaintitle() {
		return messagemaintitle;
	}

	public void setMessagemaintitle(String messagemaintitle) {
		this.messagemaintitle = messagemaintitle;
	}

	public String getMessagetitle() {
		return messagetitle;
	}

	public void setMessagetitle(String messagetitle) {
		this.messagetitle = messagetitle;
	}

	public String getAddmessagename() {
		return addmessagename;
	}

	public void setAddmessagename(String addmessagename) {
		this.addmessagename = addmessagename;
	}

	public String getAddmessageinfo() {
		return addmessageinfo;
	}

	public void setAddmessageinfo(String addmessageinfo) {
		this.addmessageinfo = addmessageinfo;
	}

	public int getAddmessageid() {
		return addmessageid;
	}

	public void setAddmessageid(int addmessageid) {
		this.addmessageid = addmessageid;
	}

}
