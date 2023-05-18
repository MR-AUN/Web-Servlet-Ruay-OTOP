package model;

public class TransportModel {
	private int transportId;
	private String transportName ;
	private double transportPrice;
	@Override
	public String toString() {
		return "TransportModel [transportId=" + transportId + ", transportName=" + transportName + ", transportPrice="
				+ transportPrice + "]";
	}
	public TransportModel(int transportId, String transportName, double transportPrice) {
		super();
		this.transportId = transportId;
		this.transportName = transportName;
		this.transportPrice = transportPrice;
	}
	public int getTransportId() {
		return transportId;
	}
	public void setTransportId(int transportId) {
		this.transportId = transportId;
	}
	public String getTransportName() {
		return transportName;
	}
	public void setTransportName(String transportName) {
		this.transportName = transportName;
	}
	public double getTransportPrice() {
		return transportPrice;
	}
	public void setTransportPrice(double transportPrice) {
		this.transportPrice = transportPrice;
	}
	
	
}
