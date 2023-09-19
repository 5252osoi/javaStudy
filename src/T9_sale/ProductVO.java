package T9_sale;

public class ProductVO {
	private int idx;
	private String pName;
	private int price;
	
	
	int getIdx() {
		return idx;
	}
	void setIdx(int idx) {
		this.idx = idx;
	}
	String getpName() {
		return pName;
	}
	void setpName(String pName) {
		this.pName = pName;
	}
	int getPrice() {
		return price;
	}
	void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductVO [idx=" + idx + ", pName=" + pName + ", price=" + price + "]";
	}
	
}
