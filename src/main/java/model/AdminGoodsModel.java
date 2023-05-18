package model;

import java.io.InputStream;

public class AdminGoodsModel {
	private int goodId ;
	private String goodName;
	private double goodPrice;
	private ProvinceModel province;
	private CategoriesModel categorie;
	private SupCategorieModel subCategorie;
	private InputStream goodImg;
	private String goodDescriptio;
	
	@Override
	public String toString() {
		return "AdminGoodsModel [goodId=" + goodId + ", goodName=" + goodName + ", goodPrice=" + goodPrice
				+ ", province=" + province + ", categorie=" + categorie + ", subCategorie=" + subCategorie
				+ ", goodImg=" + goodImg + ", goodDescriptio=" + goodDescriptio + "]";
	}
	public AdminGoodsModel(int goodId, String goodName, double goodPrice, ProvinceModel province,
			CategoriesModel categorie, SupCategorieModel subCategorie, InputStream goodImg, String goodDescriptio) {
		super();
		this.goodId = goodId;
		this.goodName = goodName;
		this.goodPrice = goodPrice;
		this.province = province;
		this.categorie = categorie;
		this.subCategorie = subCategorie;
		this.goodImg = goodImg;
		this.goodDescriptio = goodDescriptio;
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
	public ProvinceModel getProvince() {
		return province;
	}
	public void setProvince(ProvinceModel province) {
		this.province = province;
	}
	public CategoriesModel getCategorie() {
		return categorie;
	}
	public void setCategorie(CategoriesModel categorie) {
		this.categorie = categorie;
	}
	public SupCategorieModel getSubCategorie() {
		return subCategorie;
	}
	public void setSubCategorie(SupCategorieModel subCategorie) {
		this.subCategorie = subCategorie;
	}
	public InputStream getGoodImg() {
		return goodImg;
	}
	public void setGoodImg(InputStream goodImg) {
		this.goodImg = goodImg;
	}
	public String getGoodDescriptio() {
		return goodDescriptio;
	}
	public void setGoodDescriptio(String goodDescriptio) {
		this.goodDescriptio = goodDescriptio;
	}
	
	
	
	
	
	
	
	
	
	
	
}
