package model;

public class GoodGroupModel {
	private int groupId;
	private AdminGoodsModel good;
	private String groupName ;
	
	
	@Override
	public String toString() {
		return "GoodGroupModel [groupId=" + groupId + ", good=" + good + ", groupName=" + groupName + "]";
	}

	public GoodGroupModel(int groupId, AdminGoodsModel good, String groupName) {
		super();
		this.groupId = groupId;
		this.good = good;
		this.groupName = groupName;
	}
	
	public GoodGroupModel(int groupId,  String groupName) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public AdminGoodsModel getGood() {
		return good;
	}
	public void setGood(AdminGoodsModel good) {
		this.good = good;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
}
