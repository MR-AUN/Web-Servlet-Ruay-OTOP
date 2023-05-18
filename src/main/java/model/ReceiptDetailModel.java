package model;

public class ReceiptDetailModel {
	private int recDeID ;
	private ReceiptModel rec;
	private int recDeCount;
	private double recDeAmount;
	private CombinGroupModel combin ;
	
	
	
	
	public ReceiptDetailModel(int recDeID, ReceiptModel rec, int recDeCount, double recDeAmount,
			CombinGroupModel combin) {
		super();
		this.recDeID = recDeID;
		this.rec = rec;
		this.recDeCount = recDeCount;
		this.recDeAmount = recDeAmount;
		this.combin = combin;
	}
	public ReceiptDetailModel( ReceiptModel rec, int recDeCount, double recDeAmount,
			CombinGroupModel combin) {
		super();
		this.rec = rec;
		this.recDeCount = recDeCount;
		this.recDeAmount = recDeAmount;
		this.combin = combin;
	}
	public int getRecDeID() {
		return recDeID;
	}
	public void setRecDeID(int recDeID) {
		this.recDeID = recDeID;
	}
	public ReceiptModel getRec() {
		return rec;
	}
	public void setRec(ReceiptModel rec) {
		this.rec = rec;
	}
	public int getRecDeCount() {
		return recDeCount;
	}
	public void setRecDeCount(int recDeCount) {
		this.recDeCount = recDeCount;
	}
	public double getRecDeAmount() {
		return recDeAmount;
	}
	public void setRecDeAmount(double recDeAmount) {
		this.recDeAmount = recDeAmount;
	}
	public CombinGroupModel getCombin() {
		return combin;
	}
	public void setCombin(CombinGroupModel combin) {
		this.combin = combin;
	}
	
	
	
}
