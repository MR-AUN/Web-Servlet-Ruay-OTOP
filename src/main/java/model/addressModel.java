package model;

public class addressModel {
	private int addressId ;
	private String addressDetail;
	private CustomerModel customer;
	@Override
	public String toString() {
		return "addressModel [addressId=" + addressId + ", addressDetail=" + addressDetail + ", customer=" + customer
				+ "]";
	}
	public addressModel(int addressId, String addressDetail, CustomerModel customer) {
		super();
		this.addressId = addressId;
		this.addressDetail = addressDetail;
		this.customer = customer;
	}
	public addressModel(int addressId, String addressDetail) {
		super();
		this.addressId = addressId;
		this.addressDetail = addressDetail;
	}
	public addressModel( String addressDetail, CustomerModel customer) {
		super();
		this.addressDetail = addressDetail;
		this.customer = customer;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public CustomerModel getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}
	
}
