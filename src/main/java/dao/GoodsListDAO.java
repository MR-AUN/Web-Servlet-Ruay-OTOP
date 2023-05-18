package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.PreparableStatement;

import db.Database;
import model.AdminGoodsModel;
import model.CategoriesModel;
import model.ProvinceModel;
import model.SupCategorieModel;

public class GoodsListDAO {
//	public int addGoodsId(AdminGoodsModel goods) {
//		System.out.println("Add Goods");
//		try {
//			PreparedStatement st;
//			String insertSql = "INSERT INTO `goods` (`id`, `goodname`, `gooddetail`, `provice_id`, `categorie_id`, `supcategorie_id`, `goodprice`, `goodimage`, `goodstock`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)";
//			System.out.println("insertSql:" + insertSql);
//
//			Database connDB = new Database();
//			Connection con = connDB.getConnection();
//
//			st = con.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
//			st.setString(1, goods.getGoodName());
//			st.setString(2, goods.getGoodDescriptio());
//			st.setObject(3, goods.getProvinceId());
//			st.setObject(4, goods.getCategorieId());
//			st.setObject(5, goods.getSubId());
//			st.setObject(6, goods.getGoodPrice());
//			st.setBlob(7, goods.getGoodImg());
//			st.setObject(8, goods.getGoodStock());
//
//	        int affectedRows = st.executeUpdate();
//
//	        if (affectedRows == 0) {
//	            throw new SQLException("Creating user failed, no rows affected.");
//	        }
//
//	        try (ResultSet generatedKeys = st.getGeneratedKeys()) {
//	            if (generatedKeys.next()) {
//	                int idGood = generatedKeys.getInt(1);
//	                Long idTest=  generatedKeys.getLong(1); 
//	                System.out.println("return key good: "+idGood);
//	                System.out.println(idTest);
//	                con.close();
//	                return idGood;
//	            }
//	            else {
//	            	con.close();
//	                throw new SQLException("Creating user failed, no ID obtained.");
//	            }
//	        }
//			
//		} catch (ClassNotFoundException ex) {
//			ex.printStackTrace();
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//		return 0;
//	}
//	
//	public void editGoods(AdminGoodsModel goods) {
//		System.out.println("Add Goods");
//		try {
//			PreparedStatement st;
//			String updateSql = "UPDATE `goods` SET `goodname` = ?, `gooddetail` = ?, `provice_id` =  ?, `categorie_id` = ?, `supcategorie_id` = ?, `goodprice` = ?, `goodimage` = ? , `goodstock` = ? WHERE `goods`.`id` = ?";
//			System.out.println("insertSql:" + updateSql);
//
//			ConnectionDB connDB = new ConnectionDB();
//			Connection con = connDB.getConnection();
//
//			st = con.prepareStatement(updateSql);
//			st.setString(1, goods.getGoodName());
//			st.setString(2, goods.getGoodDescriptio());
//			st.setObject(3, goods.getProvinceId());
//			st.setObject(4, goods.getCategorieId());
//			st.setObject(5, goods.getSubId());
//			st.setObject(6, goods.getGoodPrice());
//			st.setBlob(7, goods.getGoodImg());
//			st.setObject(8, goods.getGoodStock());
//			st.setInt(9, goods.getGoodId());
//
//	        int affectedRows = st.executeUpdate();
//
//	        if (affectedRows == 0) {
//	            throw new SQLException("Creating user failed, no rows affected.");
//	        }
//
//	        con.close();
//			
//		} catch (ClassNotFoundException ex) {
//			ex.printStackTrace();
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//	}
//
//	
//
//	public void deleteGoods(long goods_id) {
//		System.out.println("Delete Goods");
//		try {
//			String deleteSql = "DELETE FROM `goods` WHERE `goods`.`id` = " + goods_id;
//			System.out.println("deleteSql:" + deleteSql);
//
//			ConnectionDB connDB = new ConnectionDB();
//			Connection con = connDB.getConnection();
//
//			Statement stmnt = null;
//			if (con != null) {
//				stmnt = con.createStatement();
//				stmnt.executeUpdate(deleteSql);
//				stmnt.close();
//				con.close();
//				System.out.println("Deleted successfully.");
//			}
//		} catch (ClassNotFoundException ex) {
//			ex.printStackTrace();
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//	}
//
//	public AdminGoodsModel searchGoods(long goods_id) {
//		System.out.println("Search Goods");
//		AdminGoodsModel goods = null;
//		try {
//			String searchSql = "SELECT * FROM `goods` WHERE `goods`.`id` = " + goods_id;
//			System.out.println("selectSql:" + searchSql);
//
//			ConnectionDB connDB = new ConnectionDB();
//			Connection con = connDB.getConnection();
//
//			Statement stmnt = null;
//			if (con != null) {
//				stmnt = con.createStatement();
//				ResultSet rs = stmnt.executeQuery(searchSql);
//				if (rs.next()) {
//					int goodId = rs.getInt("id");
//					String goodName = rs.getString("goodname");
//					String goodDetail = rs.getString("gooddetail");
//					int province = rs.getInt("provice_id");
//					int categorie = rs.getInt("categorie_id");
//					int supcategorie = rs.getInt("supcategorie_id");
//					double goodprice = rs.getDouble("goodprice");
//					int goodstock = rs.getInt("goodstock");
//					InputStream input = rs.getBinaryStream("goodimage");
//					 goods = new AdminGoodsModel(goodId, goodName, goodprice, goodstock, province, categorie, supcategorie, input, goodDetail);
//				}
//				stmnt.close();
//				con.close();
//				System.out.println("Searched successfully.");
//			}
//		} catch (NumberFormatException ex) {
//			System.err.println("Error! Invalid plate");
//		} catch (ClassNotFoundException ex) {
//			ex.printStackTrace();
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//		return goods;
//	}
	
	public AdminGoodsModel searchGoodById(int id_good) {
		System.out.println("View Goods");
		AdminGoodsModel goodList = null;
		
		try {
			String viewSql = "SELECT * FROM Goods WHERE id ="+id_good;
			System.out.println("selectSql:" + viewSql);
			

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String goodName = rs.getString("goodname");
					String goodDetail = rs.getString("gooddetail");
					int province = rs.getInt("provice_id");
					int categorie = rs.getInt("categorie_id");
					int supcategorie = rs.getInt("supcategorie_id");
					double goodprice = rs.getDouble("goodprice");
					InputStream input = rs.getBinaryStream("goodimage");
					ProvinceModel provices = new ProvinceDAO().searchProvinceById(province);
					CategoriesModel categories = new CategoriesDAO().searchCategorieById(categorie);
					SupCategorieModel supCate = new SupCategorieDAO().searchSupCategorieById(supcategorie);
					goodList = new AdminGoodsModel(id, goodName, goodprice, provices, categories, supCate, input, goodDetail);
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return goodList;
	}	

	
	
	public ArrayList<AdminGoodsModel> viewGoodsLimit() {
		System.out.println("View Goods");
		ArrayList<AdminGoodsModel> goodList = null;
		
		try {
			String viewSql = "SELECT * FROM Goods LIMIT 6;";
			System.out.println("selectSql:" + viewSql);
			
			goodList = new ArrayList<AdminGoodsModel>();

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String goodName = rs.getString("goodname");
					String goodDetail = rs.getString("gooddetail");
					int province = rs.getInt("provice_id");
					int categorie = rs.getInt("categorie_id");
					int supcategorie = rs.getInt("supcategorie_id");
					double goodprice = rs.getDouble("goodprice");
					InputStream input = rs.getBinaryStream("goodimage");
					ProvinceModel provices = new ProvinceDAO().searchProvinceById(province);
					CategoriesModel categories = new CategoriesDAO().searchCategorieById(categorie);
					SupCategorieModel supCate = new SupCategorieDAO().searchSupCategorieById(supcategorie);
					AdminGoodsModel good = new AdminGoodsModel(id, goodName, goodprice, provices, categories, supCate, input, goodDetail);
					goodList.add(good);
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return goodList;
	}	
	
	public ArrayList<AdminGoodsModel> viewGoods() {
		System.out.println("View Goods");
		ArrayList<AdminGoodsModel> goodList = null;
		
		try {
			String viewSql = "SELECT * FROM Goods ";
			System.out.println("selectSql:" + viewSql);
			
			goodList = new ArrayList<AdminGoodsModel>();

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String goodName = rs.getString("goodname");
					String goodDetail = rs.getString("gooddetail");
					int province = rs.getInt("provice_id");
					int categorie = rs.getInt("categorie_id");
					int supcategorie = rs.getInt("supcategorie_id");
					double goodprice = rs.getDouble("goodprice");
					InputStream input = rs.getBinaryStream("goodimage");
					ProvinceModel provices = new ProvinceDAO().searchProvinceById(province);
					CategoriesModel categories = new CategoriesDAO().searchCategorieById(categorie);
					SupCategorieModel supCate = new SupCategorieDAO().searchSupCategorieById(supcategorie);
					AdminGoodsModel good = new AdminGoodsModel(id, goodName, goodprice, provices, categories, supCate, input, goodDetail);
					goodList.add(good);
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return goodList;
	}	
	
	public ArrayList<AdminGoodsModel> viewGoodsSearch(String search) {
		System.out.println("View Goods");
		ArrayList<AdminGoodsModel> goodList = null;
		
		try {
			String viewSql = "SELECT * FROM Goods JOIN provinces ON provinces.PROVINCE_ID = goods.provice_id JOIN categories ON categories.id = goods.categorie_id LEFT JOIN supcategories ON supcategories.id = goods.supcategorie_id WHERE goods.goodname LIKE '"+search+"' OR goods.gooddetail LIKE '%"+search+"%' OR provinces.PROVINCE_NAME LIKE '%"+search+"%' OR categories.categoriename LIKE '%"+search+"%' OR supcategories.sup_name LIKE '%"+search+"%'";
			System.out.println("selectSql:" + viewSql);
			
			goodList = new ArrayList<AdminGoodsModel>();

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String goodName = rs.getString("goodname");
					String goodDetail = rs.getString("gooddetail");
					int province = rs.getInt("provice_id");
					int categorie = rs.getInt("categorie_id");
					int supcategorie = rs.getInt("supcategorie_id");
					double goodprice = rs.getDouble("goodprice");
					InputStream input = rs.getBinaryStream("goodimage");
					ProvinceModel provices = new ProvinceDAO().searchProvinceById(province);
					CategoriesModel categories = new CategoriesDAO().searchCategorieById(categorie);
					SupCategorieModel supCate = new SupCategorieDAO().searchSupCategorieById(supcategorie);
					AdminGoodsModel good = new AdminGoodsModel(id, goodName, goodprice, provices, categories, supCate, input, goodDetail);
					goodList.add(good);
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return goodList;
	}	
	
	public ArrayList<AdminGoodsModel> searchGoodsByCategorie(int cate) {
		System.out.println("View Goods");
		ArrayList<AdminGoodsModel> goodList = null;
		
		try {
			String viewSql = "SELECT * FROM `goods` WHERE categorie_id = "+cate;
			System.out.println("selectSql:" + viewSql);
			
			goodList = new ArrayList<AdminGoodsModel>();

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String goodName = rs.getString("goodname");
					String goodDetail = rs.getString("gooddetail");
					int province = rs.getInt("provice_id");
					int categorie = rs.getInt("categorie_id");
					int supcategorie = rs.getInt("supcategorie_id");
					double goodprice = rs.getDouble("goodprice");
					InputStream input = rs.getBinaryStream("goodimage");
					ProvinceModel provices = new ProvinceDAO().searchProvinceById(province);
					CategoriesModel categories = new CategoriesDAO().searchCategorieById(categorie);
					SupCategorieModel supCate = new SupCategorieDAO().searchSupCategorieById(supcategorie);
					AdminGoodsModel good = new AdminGoodsModel(id, goodName, goodprice, provices, categories, supCate, input, goodDetail);
					goodList.add(good);
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return goodList;
	}	
	
	public ArrayList<AdminGoodsModel> searchGoodsBySupCategorie(int supcate) {
		System.out.println("View Goods");
		ArrayList<AdminGoodsModel> goodList = null;
		
		try {
			String viewSql = "SELECT * FROM `goods` WHERE supcategorie_id = "+supcate;
			System.out.println("selectSql:" + viewSql);
			
			goodList = new ArrayList<AdminGoodsModel>();

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String goodName = rs.getString("goodname");
					String goodDetail = rs.getString("gooddetail");
					int province = rs.getInt("provice_id");
					int categorie = rs.getInt("categorie_id");
					int supcategorie = rs.getInt("supcategorie_id");
					double goodprice = rs.getDouble("goodprice");
					InputStream input = rs.getBinaryStream("goodimage");
					ProvinceModel provices = new ProvinceDAO().searchProvinceById(province);
					CategoriesModel categories = new CategoriesDAO().searchCategorieById(categorie);
					SupCategorieModel supCate = new SupCategorieDAO().searchSupCategorieById(supcategorie);
					AdminGoodsModel good = new AdminGoodsModel(id, goodName, goodprice, provices, categories, supCate, input, goodDetail);
					goodList.add(good);
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return goodList;
	}	
	
	public ArrayList<AdminGoodsModel> searchGoodsByProvince(int proId) {
		System.out.println("View Goods");
		ArrayList<AdminGoodsModel> goodList = null;
		
		try {
			String viewSql = "SELECT * FROM `goods` WHERE provice_id = "+proId;
			System.out.println("selectSql:" + viewSql);
			
			goodList = new ArrayList<AdminGoodsModel>();

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String goodName = rs.getString("goodname");
					String goodDetail = rs.getString("gooddetail");
					int province = rs.getInt("provice_id");
					int categorie = rs.getInt("categorie_id");
					int supcategorie = rs.getInt("supcategorie_id");
					double goodprice = rs.getDouble("goodprice");
					InputStream input = rs.getBinaryStream("goodimage");
					ProvinceModel provices = new ProvinceDAO().searchProvinceById(province);
					CategoriesModel categories = new CategoriesDAO().searchCategorieById(categorie);
					SupCategorieModel supCate = new SupCategorieDAO().searchSupCategorieById(supcategorie);
					AdminGoodsModel good = new AdminGoodsModel(id, goodName, goodprice, provices, categories, supCate, input, goodDetail);
					goodList.add(good);
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return goodList;
	}	

}
