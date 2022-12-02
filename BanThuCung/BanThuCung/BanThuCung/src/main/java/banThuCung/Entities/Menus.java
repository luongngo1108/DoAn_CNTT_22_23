package banThuCung.Entities;

public class Menus {
	private String menus_id;
	private String name;
	private String url;
	
	public Menus() {
		super();
	}
	
	public String getMenus_id() {
		return menus_id;
	}

	public void setMenus_id(String menus_id) {
		this.menus_id = menus_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
