package ch.bfh.bti7081.blue.PMS;

public class Order {
	private int id;
	private String date;
	private String status;
	private String drucken;

	public Order(int id, String date, String status, String drucken) {
		super();
		this.id=id;
		this.date=date;
		this.status=status;
		this.setDrucken(drucken);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDrucken() {
		return drucken;
	}

	public void setDrucken(String drucken) {
		this.drucken = drucken;
	}

}
