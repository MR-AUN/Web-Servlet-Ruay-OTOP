package model;

public class OptionpayModel {
	private int optionpayId;
	private String optionpayName;
	@Override
	public String toString() {
		return "OptionpayModel [optionpayId=" + optionpayId + ", optionpayName=" + optionpayName + "]";
	}
	public OptionpayModel(int optionpayId, String optionpayName) {
		super();
		this.optionpayId = optionpayId;
		this.optionpayName = optionpayName;
	}
	public int getOptionpayId() {
		return optionpayId;
	}
	public void setOptionpayId(int optionpayId) {
		this.optionpayId = optionpayId;
	}
	public String getOptionpayName() {
		return optionpayName;
	}
	public void setOptionpayName(String optionpayName) {
		this.optionpayName = optionpayName;
	}
	
	
}
