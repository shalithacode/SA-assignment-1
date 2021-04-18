package e_shoplk;

public interface Ishop {

	public void addProduct(String name, double price, int qty);
	public boolean viewProduct();
	public boolean deleteProduct(String prod);
	
}
