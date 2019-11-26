package ticket_me;

import java.sql.Date;

public class Tickets {
	private int Id;
	private String name_ticket;
	private String description;
	private String Priority;
	private String Category;
	private Date dateBegin;
	private Date dateEnd;
	private String Screenshot;
	private boolean Status;
	private String Completioncode;
	private Faq faq;
	
	public Tickets() {
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name_ticket;
	}

	public void setName(String title) {
		name_ticket = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		description = description;
	}

	public String getPriority() {
		return Priority;
	}

	public void setPriority(String priority) {
		Priority = priority;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public Date getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getScreenshot() {
		return Screenshot;
	}

	public void setScreenshot(String screenshot) {
		Screenshot = screenshot;
	}

	public boolean isStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}

	public String getCompletioncode() {
		return Completioncode;
	}

	public void setCompletioncode(String completioncode) {
		Completioncode = completioncode;
	}

	public Faq getFaq() {
		return faq;
	}

	public void setFaq(Faq faq) {
		this.faq = faq;
	}
}
