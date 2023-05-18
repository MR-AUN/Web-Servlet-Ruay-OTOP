package model;

public class ReceiptGoodViewModel {
	private int RecDeId ;
	private int good_id;
	private int goodTotalCount ;
	private String goodName ;
	private int goodStock;
	
	
	
	@Override
	public String toString() {
		return "{RecDeId:" + RecDeId + ", good_id:" + good_id + ", goodTotalCount:"
				+ goodTotalCount + ", goodName:'" + goodName + "', goodStock:" + goodStock + " }";
	}
	public ReceiptGoodViewModel(int recDeId, int good_id, int goodTotalCount, String goodName, int goodStock) {
		RecDeId = recDeId;
		this.good_id = good_id;
		this.goodTotalCount = goodTotalCount;
		this.goodName = goodName;
		this.goodStock = goodStock;
	}
	public int getRecDeId() {
		return RecDeId;
	}
	public void setRecDeId(int recDeId) {
		RecDeId = recDeId;
	}
	public int getGood_id() {
		return good_id;
	}
	public void setGood_id(int good_id) {
		this.good_id = good_id;
	}
	public int getGoodTotalCount() {
		return goodTotalCount;
	}
	public void setGoodTotalCount(int goodTotalCount) {
		this.goodTotalCount = goodTotalCount;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public int getGoodStock() {
		return goodStock;
	}
	public void setGoodStock(int goodStock) {
		this.goodStock = goodStock;
	}
	
}
