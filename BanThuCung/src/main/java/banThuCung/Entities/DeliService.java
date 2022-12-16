package banThuCung.Entities;

public class DeliService {
	private String deli_ser_id;
	private String deli_com_id;
	private String type;
	private int price;
	private String time;
	public DeliService() {
		super();
	}
	public String getDeli_ser_id() {
		return deli_ser_id;
	}
	public void setDeli_ser_id(String deli_ser_id) {
		this.deli_ser_id = deli_ser_id;
	}
	public String getDeli_com_id() {
		return deli_com_id;
	}
	public void setDeli_com_id(String deli_com_id) {
		this.deli_com_id = deli_com_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
