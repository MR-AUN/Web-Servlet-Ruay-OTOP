package model;

public class RecCusViewModel {
	private int cusId ;
	private  String cusName ;
	private String cusListName;
	private String recDate ;
	private double recAmount;
	
	
	
	
	
	@Override
	public String toString() {
		return "{cusId:" + cusId + ", cusName:'" + cusName + "', cusListName:'" + cusListName
				+ "', recDate:'" + recDate + "', recAmount:" + recAmount + "}";
	}
	public RecCusViewModel(int cusId, String cusName, String cusListName, String recDate, double recAmount) {
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusListName = cusListName;
		this.recDate = recDate;
		this.recAmount = recAmount;
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusListName() {
		return cusListName;
	}
	public void setCusListName(String cusListName) {
		this.cusListName = cusListName;
	}
	public String getRecDate() {
		return recDate;
	}
	public void setRecDate(String recDate) {
		this.recDate = recDate;
	}
	public double getRecAmount() {
		return recAmount;
	}
	public void setRecAmount(double recAmount) {
		this.recAmount = recAmount;
	}
	
	
}
