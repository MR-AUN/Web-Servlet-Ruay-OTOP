package model;

public class GoodsModel {
	private int goodId ;
	private String goodName ;
	private double goodPrice;
	private String goodDescription ;
	private int goodStock;
	
	
	
	@Override
	public String toString() {
		return " {goodId:" + goodId + ", goodName:'" + goodName + "', goodPrice:" + goodPrice
				+ ", goodDescription:'" + goodDescription + "', goodStock:" + goodStock + "}";
	}

	public GoodsModel(int goodId, String goodName, double goodPrice, String goodDescription, int goodStock) {
		this.goodId = goodId;
		this.goodName = goodName;
		this.goodPrice = goodPrice;
		this.goodDescription = goodDescription;
		this.goodStock = goodStock;
	}
	
	public GoodsModel(String goodName, double goodPrice, String goodDescription, int goodStock) {
		this.goodName = goodName;
		this.goodPrice = goodPrice;
		this.goodDescription = goodDescription;
		this.goodStock = goodStock;
	}
	
	
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public double getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(double goodPrice) {
		this.goodPrice = goodPrice;
	}
	public String getGoodDescription() {
		return goodDescription;
	}
	public void setGoodDescription(String goodDescription) {
		this.goodDescription = goodDescription;
	}
	public int getGoodStock() {
		return goodStock;
	}
	public void setGoodStock(int goodStock) {
		this.goodStock = goodStock;
	}
	
}
