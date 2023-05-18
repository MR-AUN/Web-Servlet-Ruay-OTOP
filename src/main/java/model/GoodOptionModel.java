package model;

public class GoodOptionModel {
	private int optionId;
	private GoodGroupModel group;
	private	String optionName;
	private double optionPrice;
	
	
	@Override
	public String toString() {
		return "GoodOptionModel [optionId=" + optionId + ", group=" + group + ", optionName=" + optionName
				+ ", optionPrice=" + optionPrice +  "]";
	}

	public GoodOptionModel(int optionId, GoodGroupModel group, String optionName, double optionPrice) {
		super();
		this.optionId = optionId;
		this.group = group;
		this.optionName = optionName;
		this.optionPrice = optionPrice;
	}
	
	public GoodOptionModel(int optionId, String optionName, double optionPrice) {
		super();
		this.optionId = optionId;
		this.optionName = optionName;
		this.optionPrice = optionPrice;
	}
	public int getOptionId() {
		return optionId;
	}
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}
	public GoodGroupModel getGroup() {
		return group;
	}
	public void setGroup(GoodGroupModel group) {
		this.group = group;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public double getOptionPrice() {
		return optionPrice;
	}
	public void setOptionPrice(double optionPrice) {
		this.optionPrice = optionPrice;
	}
	
	
}
