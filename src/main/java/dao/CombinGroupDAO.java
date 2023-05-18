package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import db.Database;
import model.AdminGoodsModel;
import model.CombinGroupModel;
import model.CustomerModel;

public class CombinGroupDAO {
	
	public void addCombinGroup(CombinGroupModel combin) {
		System.out.println("Add Categorie Sup");
		try {
			String insertSql = "INSERT INTO `combin_group` (`id`, `combinName`, `combinPrice`, `combinquantity`, `good_id`) VALUES (NULL, '"+combin.getCombinName()+"', "+combin.getCombinPrice()+", "+combin.getCombinQua()+", "+combin.getGood().getGoodId()+")";
			System.out.println("insertSql:" + insertSql);

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insertSql);
				stmnt.close();
				con.close();
				System.out.println("Categorie Sup Add successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public CombinGroupModel searchCustomerName(String combinName) {
		CombinGroupModel combin = null;
		try {
			String searchSql = "SELECT * FROM `combin_group` where combinName = '" + combinName+"' ;";
			System.out.println("selectSql:" + searchSql);

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(searchSql);
				if (rs.next()) {
					int id = rs.getInt("id");
					String combinNames = rs.getString("combinName");
					double combinPrice = rs.getDouble("combinPrice");
					int combinquantity = rs.getInt("combinquantity");
					int good_id = rs.getInt("good_id");
					AdminGoodsModel good = new GoodsListDAO().searchGoodById(good_id);
					combin = new CombinGroupModel(id, combinNames, combinPrice, combinquantity, good);
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (NumberFormatException ex) {
			System.err.println("Error! Invalid plate");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return combin;
	}
	
	public CombinGroupModel searchCustomerByIdGood(int goodId) {
		CombinGroupModel combin = null;
		try {
			String searchSql = "SELECT * FROM `combin_group` where good_id = '" + goodId+"' ;";
			System.out.println("selectSql:" + searchSql);

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(searchSql);
				if (rs.next()) {
					int id = rs.getInt("id");
					String combinNames = rs.getString("combinName");
					double combinPrice = rs.getDouble("combinPrice");
					int combinquantity = rs.getInt("combinquantity");
					int good_id = rs.getInt("good_id");
					AdminGoodsModel good = new GoodsListDAO().searchGoodById(good_id);
					combin = new CombinGroupModel(id, combinNames, combinPrice, combinquantity, good);
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (NumberFormatException ex) {
			System.err.println("Error! Invalid plate");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return combin;
	}
	
	public CombinGroupModel searchCustomerById(int Id) {
		CombinGroupModel combin = null;
		try {
			String searchSql = "SELECT * FROM `combin_group` where id = "+Id;
			System.out.println("selectSql:" + searchSql);

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(searchSql);
				if (rs.next()) {
					int id = rs.getInt("id");
					String combinNames = rs.getString("combinName");
					double combinPrice = rs.getDouble("combinPrice");
					int combinquantity = rs.getInt("combinquantity");
					int good_id = rs.getInt("good_id");
					AdminGoodsModel good = new GoodsListDAO().searchGoodById(good_id);
					combin = new CombinGroupModel(id, combinNames, combinPrice, combinquantity, good);
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (NumberFormatException ex) {
			System.err.println("Error! Invalid plate");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return combin;
	}
	
	public void updateStockCombin(int number , int combinId) {
		try {
			String sql ="";
				sql = "UPDATE `combin_group` SET `combinquantity` = `combinquantity` - "+number+" WHERE `combin_group`.`id` = "+combinId;

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(sql);
				stmnt.close();
				con.close();
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
//	public CombinGroupModel searchCustomer(int combinId) {
//		CombinGroupModel combin = null;
//		try {
//			String searchSql = "SELECT * FROM `combin_group` where id = " + combinId;
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
//					String combinName = rs.getString("combinName");
//					double combinPrice = rs.getDouble("combinPrice");
//					int combinquantity = rs.getInt("combinquantity");
//					int good_id = rs.getInt("good_id");
//					AdminGoodsModel good = new AdminGoodsDAO().searchGoods(good_id);
//					combin = new CombinGroupModel(combinId, combinName, combinPrice, combinquantity, good);
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
//		return combin;
//	}
	
//	public Vector<CombinGroupModel> viewCombinGroup() {
//		Vector<CombinGroupModel> combinList = null;
//		
//		try {
//			String viewSql = "SELECT * FROM `combin_group`";
//			System.out.println("selectSql:" + viewSql);
//			
//			combinList = new Vector<CombinGroupModel>();
//
//			ConnectionDB connDB = new ConnectionDB();
//			Connection con = connDB.getConnection();
//
//			Statement stmnt = null;
//			if (con != null) {
//				stmnt = con.createStatement();
//				ResultSet rs = stmnt.executeQuery(viewSql);
//				while (rs.next()) {
//					int id = rs.getInt("id");
//					String combinName = rs.getString("combinName");
//					double combinPrice = rs.getDouble("combinPrice");
//					int combinquantity = rs.getInt("combinquantity");
//					int good_id = rs.getInt("good_id");
//					AdminGoodsModel good = new AdminGoodsDAO().searchGoods(good_id);
//					CombinGroupModel combin = new CombinGroupModel(id, combinName, combinPrice, combinquantity, good);
//					combinList.add(combin);
//				}
//				stmnt.close();
//				con.close();
//				System.out.println("Searched successfully.");
//			}
//		} catch (ClassNotFoundException ex) {
//			ex.printStackTrace();
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//		return combinList;
//	}	
}
