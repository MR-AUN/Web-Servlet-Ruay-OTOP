package model;

public class ReceiptModel {
	private int  recId ;
	private String recDate;
	private double 	recTotal;
	private addressModel address;
	private OptionpayModel optionpay;
	private TransportModel transport;
	@Override
	public String toString() {
		return "ReceiptModel [recId=" + recId + ", recDate=" + recDate + ", recTotal=" + recTotal + ", address="
				+ address + ", optionpay=" + optionpay + ", transport=" + transport + "]";
	}
	public ReceiptModel(int recId, String recDate, double recTotal, addressModel address, OptionpayModel optionpay,
			TransportModel transport) {
		super();
		this.recId = recId;
		this.recDate = recDate;
		this.recTotal = recTotal;
		this.address = address;
		this.optionpay = optionpay;
		this.transport = transport;
	}
	
	public ReceiptModel(int recId, String recDate, double recTotal) {
		super();
		this.recId = recId;
		this.recDate = recDate;
		this.recTotal = recTotal;
	}
	
	
	public ReceiptModel(  double recTotal, addressModel address, OptionpayModel optionpay,
			TransportModel transport) {
		super();
		this.recTotal = recTotal;
		this.address = address;
		this.optionpay = optionpay;
		this.transport = transport;
	}
	public int getRecId() {
		return recId;
	}
	public void setRecId(int recId) {
		this.recId = recId;
	}
	public String getRecDate() {
		return recDate;
	}
	public void setRecDate(String recDate) {
		this.recDate = recDate;
	}
	public double getRecTotal() {
		return recTotal;
	}
	public void setRecTotal(double recTotal) {
		this.recTotal = recTotal;
	}
	public addressModel getAddress() {
		return address;
	}
	public void setAddress(addressModel address) {
		this.address = address;
	}
	public OptionpayModel getOptionpay() {
		return optionpay;
	}
	public void setOptionpay(OptionpayModel optionpay) {
		this.optionpay = optionpay;
	}
	public TransportModel getTransport() {
		return transport;
	}
	public void setTransport(TransportModel transport) {
		this.transport = transport;
	}
	
	
}
