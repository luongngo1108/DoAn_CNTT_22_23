package banThuCung.Entities;

import java.sql.Date;

public class Orders {
	private String order_id;
	private String acc_id;
	private String pay_id;
	private String deli_ser_id;
	private String name_receiver;
	private String email;
	private String address_receiver;
	private String phone_receiver;
	private String note;
	private double total;
	private double quantity;
	private Date date;

	public Orders() {
		super();
	}
	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}

	public String getName_receiver() {
		return name_receiver;
	}

	public void setName_receiver(String name_receiver) {
		this.name_receiver = name_receiver;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress_receiver() {
		return address_receiver;
	}

	public void setAddress_receiver(String address_receiver) {
		this.address_receiver = address_receiver;
	}

	public String getPhone_receiver() {
		return phone_receiver;
	}

	public void setPhone_receiver(String phone_receiver) {
		this.phone_receiver = phone_receiver;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public String getPay_id() {
		return pay_id;
	}
	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}
	public String getDeli_ser_id() {
		return deli_ser_id;
	}
	public void setDeli_ser_id(String deli_ser_id) {
		this.deli_ser_id = deli_ser_id;
	}

}
