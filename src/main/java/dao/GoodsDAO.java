package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.Database;
import model.CustomerModel;
import model.GoodsModel;

public class GoodsDAO {
	public ArrayList<GoodsModel> viewGoods() {
		ArrayList<GoodsModel> goods = null;
		try {
			String viewSql = "SELECT * FROM GOODS";

			goods = new ArrayList<GoodsModel>();

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int goodId = rs.getInt("id");
					String goodNmae = rs.getString("name");
					double goodPrice = rs.getDouble("price");
					String goodDescription = rs.getString("description");
					int goodStock = rs.getInt("Stock");
					
					GoodsModel good = new GoodsModel(goodId,goodNmae, goodPrice, goodDescription, goodStock);
					goods.add(good);
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
		return goods;
	}
	
	public GoodsModel searchGoods(int goods_id) {
		System.out.println("Search Goods");
		GoodsModel goods = null;
		try {
			String searchSql = "SELECT * FROM `goods` WHERE `goods`.`id` = "+goods_id;
			System.out.println("selectSql:" + searchSql);

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(searchSql);
				if (rs.next()) {
					String goods_name = rs.getString("name");
					String goods_detail = rs.getString("description");
					double goods_price = rs.getDouble("price");
					int goods_count = rs.getInt("stock");
					goods =new GoodsModel(goods_id,goods_name,goods_price,goods_detail,goods_count);;
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
		return goods;
	}
	
	public int searchStockById(int goods_id) {
		int  stock = -1;
		try {
			String searchSql = "SELECT * FROM `goods` WHERE `goods`.`id` = "+goods_id;

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(searchSql);
				if (rs.next()) {
					
					int goods_count = rs.getInt("stock");
					stock = goods_count ;
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
		return stock;
	}
	public void updateStock(int count,int good_id) {
		try {
			String sql = "UPDATE goods SET stock = stock - "+count+" WHERE id = "+good_id ;
			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(sql);
				stmnt.close();
				con.close();
				System.out.println("Customer added successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
