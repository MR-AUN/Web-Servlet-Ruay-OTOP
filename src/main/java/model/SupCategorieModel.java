package model;

public class SupCategorieModel {
	private int supCateId ;
	private CategoriesModel categorie;
	private String supCateName;
	public SupCategorieModel(int supCateId, CategoriesModel categorie, String supCateName) {
		super();
		this.supCateId = supCateId;
		this.categorie = categorie;
		this.supCateName = supCateName;
	}
	public int getSupCateId() {
		return supCateId;
	}
	public void setSupCateId(int supCateId) {
		this.supCateId = supCateId;
	}
	public CategoriesModel getCategorie() {
		return categorie;
	}
	public void setCategorie(CategoriesModel categorie) {
		this.categorie = categorie;
	}
	public String getSupCateName() {
		return supCateName;
	}
	public void setSupCateName(String supCateName) {
		this.supCateName = supCateName;
	}
	
	
}
