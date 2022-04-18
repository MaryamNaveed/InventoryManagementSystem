package buisnessLayer;

public class StockIn extends Stock {

	Supplier supplier;

	public StockIn(Product product, int quantity, int purchasePrice, Supplier supplier) {
		super(product, quantity, purchasePrice);
		this.supplier = supplier;
	}

	public StockIn(Product product, int quantity, int purchasePrice) {
		super(product, quantity, purchasePrice);
	}
	
	public StockIn() {
		super();
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
}
