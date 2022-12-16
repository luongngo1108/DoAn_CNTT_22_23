package banThuCung.Entities;

public class Order_detail {
	private String order_id;
	private String pro_id;
	private String proper_id;
	private int quantity;
	private double total;
	private boolean paid;
	
	public Order_detail() {
		super();
	}
	
	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getPro_id() {
		return pro_id;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getProper_id() {
		return proper_id;
	}

	public void setProper_id(String proper_id) {
		this.proper_id = proper_id;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
}
