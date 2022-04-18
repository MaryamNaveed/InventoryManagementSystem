package buisnessLayer;

import java.util.ArrayList;

public class Store {
	ProductCatalog productCatalog = new ProductCatalog();
	ArrayList<Customer> customers= new ArrayList<Customer>();
	ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	
	public Store() {
		loadData();
	}

	public void loadData() {
		productCatalog.loadData();
		loadCustomerData();
		loadSupplierData();
	}
	
	void loadCustomerData() {
		Customer c1=new Customer("Iman", "03331111111", "iman@gmail.com", "G-9", "1234");
		this.AddCustomer(c1);
	}
	
	void loadSupplierData() {
		Supplier s1=new Supplier("Supplier1", "03334111111", "sup1@gmail.com", "G-9");
		this.AddSupplier(s1);
	
		Supplier s2=new Supplier("Supplier2", "03334161111", "sup2@gmail.com", "G-9");
		this.AddSupplier(s2);
	
	}
	
	public Category searchCategory(String n) {
		return productCatalog.searchCategory(n);
	}
	
	public Product searchProduct(String n) {
		return productCatalog.searchProduct(n);
	}
	
	
	public ProductCatalog getProductCatalog() {
		return productCatalog;
	}

	public void setProductCatalog(ProductCatalog productCatalog) {
		this.productCatalog = productCatalog;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(ArrayList<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public String AddCategory(Category c) {
		return productCatalog.AddCategory(c);
	}
	
	public String AddProduct(Product p) {
		return productCatalog.AddProduct(p);
	}
	
	public String AddCustomer(Customer c) {
		for(int i=0; i<customers.size(); i++) {
			if(customers.get(i).getEmail().equalsIgnoreCase(c.getEmail())) {
				return "This email already exist";
			}
			if(customers.get(i).getPhone().equalsIgnoreCase(c.getPhone())) {
				return "This phone number already exist";
			}
		}
		Customer.tempid++;
		c.id=Customer.tempid;
		customers.add(c);
		return null;
		
	}
	
	public String AddSupplier(Supplier c) {
		for(int i=0; i<suppliers.size(); i++) {
			if(suppliers.get(i).getEmail().equalsIgnoreCase(c.getEmail())) {
				return "This email already exist";
			}
			if(suppliers.get(i).getPhone().equalsIgnoreCase(c.getPhone())) {
				return "This phone number already exist";
			}
		}
		Supplier.tempid++;
		c.id=Supplier.tempid;
		suppliers.add(c);
		return null;
		
	}
	
	public String UpdateCategory(int n,Category c) {
		return productCatalog.UpdateCategory(n, c);
	}
	
	public String DeleteCategory(int n) {
		return productCatalog.DeleteCategory(n);
	}
	
	public String DeleteProduct(int n) {
		return productCatalog.DeleteProduct(n);
	}
	
	public String UpdateProduct(int n,Product p) {
		return productCatalog.UpdateProduct(n, p);
	}

	public ArrayList<Product> getAvailableStock() {
		return productCatalog.getAvailableStock();		
	}

	public int searchCustomerIndex(int n) {
		int ind=-1;
		for(int i=0; i<customers.size(); i++) {
			if(customers.get(i).id==n) {
				return i;
			}
		}
		return ind;
	}
	
	public int searchSupplierIndex(int n) {
		int ind=-1;
		for(int i=0; i<suppliers.size(); i++) {
			if(suppliers.get(i).id==n) {
				return i;
			}
		}
		return ind;
	}
	
	public Customer searchCustomer(int n) {
		for(int i=0; i<customers.size(); i++) {
			if(customers.get(i).id==n) {
				return customers.get(i);
			}
		}
		return null;
	}
	
	public Supplier searchSupplier(int n) {
		for(int i=0; i<suppliers.size(); i++) {
			if(suppliers.get(i).id==n) {
				return suppliers.get(i);
			}
		}
		return null;
	}
	
	public String UpdateCustomer(int n,Customer c) {
		int ind=searchCustomerIndex(n);
		
		for(int i=0; i<customers.size(); i++) {
			if(customers.get(i).getEmail().equalsIgnoreCase(c.getEmail()) && i!=ind) {
				return "This email already exist";
			}
			if(customers.get(i).getPhone().equalsIgnoreCase(c.getPhone()) && i!=ind) {
				return "This phone number already exist";
			}
		}
		
		if(ind!=-1) {
			c.id=n;
			customers.set(ind, c);
			return null;
		}
		else {
			return "The required customer donot exist";
		}
	}
	
	public String UpdateSupplier(int n,Supplier c) {
		int ind=searchSupplierIndex(n);
		
		for(int i=0; i<suppliers.size(); i++) {
			if(suppliers.get(i).getEmail().equalsIgnoreCase(c.getEmail()) && i!=ind) {
				return "This email already exist";
			}
			if(suppliers.get(i).getPhone().equalsIgnoreCase(c.getPhone()) && i!=ind) {
				return "This phone number already exist";
			}
		}
		
		if(ind!=-1) {
			c.id=n;
			suppliers.set(ind, c);
			return null;
		}
		else {
			return "The required supplier donot exist";
		}
	}
	
	public String DeleteCustomer(int n) {
		int ind=searchCustomerIndex(n);
		
		if(ind!=-1) {
			customers.remove(ind);
			return null;
		}
		else {
			return "The required customer donot exist";
		}
	}
	
	public String DeleteSupplier(int n) {
		int ind=searchCustomerIndex(n);
		
		if(ind!=-1) {
			suppliers.remove(ind);
			return null;
		}
		else {
			return "The required supplier donot exist";
		}
	}
}
