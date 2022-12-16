package banThuCung.Dto;

public class CartDto {
	private int quantity;
	private double totalPrice;
	private ProductDto product;
	
	public CartDto() {
		super();
	}
	
	public CartDto(int quantity, double totalPrice, ProductDto product) {
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public ProductDto getProduct() {
		return product;
	}
	public void setProduct(ProductDto product) {
		this.product = product;
	}
}
