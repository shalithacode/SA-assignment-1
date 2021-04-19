package e_shoplk;

//Item model class
public class Item {

	private String pNname;
	private double pPrice;
	private int pQty;

	public Item(String pNname, double pPrice, int pQty) {

		this.pNname = pNname;
		this.pPrice = pPrice;
		this.pQty = pQty;
	}

	public String getpNname() {
		return pNname;
	}

	public void setpNname(String pNname) {
		this.pNname = pNname;
	}

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}

	public int getpQty() {
		return pQty;
	}

	public void setpQty(int pQty) {
		this.pQty = pQty;
	}

}
