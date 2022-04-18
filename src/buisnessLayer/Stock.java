package buisnessLayer;

public class Stock {

	Product product;
	int quantity;
	int purchasePrice;
	
	
	
	public Stock(Product product, int quantity, int purchasePrice) {
		this.product = product;
		this.quantity = quantity;
		this.purchasePrice = purchasePrice;
	}



	public Stock() {
		
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public int getPurchasePrice() {
		return purchasePrice;
	}



	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
	
	
	
	
	
}
