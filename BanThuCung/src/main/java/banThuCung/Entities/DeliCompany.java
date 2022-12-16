package banThuCung.Entities;

public class DeliCompany {
	private String deli_com_id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String name_contact;
	private String web_url;
	public DeliCompany() {
		super();
	}
	public String getDeli_com_id() {
		return deli_com_id;
	}
	public void setDeli_com_id(String deli_com_id) {
		this.deli_com_id = deli_com_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName_contact() {
		return name_contact;
	}
	public void setName_contact(String name_contact) {
		this.name_contact = name_contact;
	}
	public String getWeb_url() {
		return web_url;
	}
	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}
}
