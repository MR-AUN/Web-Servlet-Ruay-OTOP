package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.Database;
import model.GoodGroupModel;
import model.GoodOptionModel;

public class GoodOptionDAO {
	public ArrayList<GoodOptionModel> searchOptionByIdNotGoodList(int id) {
		ArrayList<GoodOptionModel> optionList = new ArrayList<GoodOptionModel>();
		
		try {
			String viewSql = "SELECT * FROM goods_option WHERE good_group = "+id;
			System.out.println("selectSql:" + viewSql);
			

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int optionId = rs.getInt("id");
					int groupId = rs.getInt("good_group");
					String name = rs.getString("optionname");
					double price = rs.getDouble("optionprice");
					GoodOptionModel option = new GoodOptionModel(optionId, name, price);
					optionList.add(option);
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
		return optionList;
	}	
	
	public GoodOptionModel searchOptionByIdNotGood(int id) {
		GoodOptionModel optionList = null;
		
		try {
			String viewSql = "SELECT * FROM goods_option WHERE id = "+id;
			System.out.println("selectSql:" + viewSql);
			

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int groupId = rs.getInt("good_group");
					String name = rs.getString("optionname");
					double price = rs.getDouble("optionprice");
					GoodGroupModel group = new GoodGroupDAO().searchGroupByIdnotGood(groupId);
					optionList = new GoodOptionModel(id, group, name, price);
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
		return optionList;
	}	
	
	public GoodOptionModel searchOptionById(int id) {
		GoodOptionModel optionList = null;
		
		try {
			String viewSql = "SELECT * FROM goods_option WHERE id = "+id;
			System.out.println("selectSql:" + viewSql);
			

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int groupId = rs.getInt("good_group");
					String name = rs.getString("optionname");
					double price = rs.getDouble("optionprice");
					GoodGroupModel group = new GoodGroupDAO().searchGroupById(groupId);
					optionList = new GoodOptionModel(id, group, name, price);
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
		return optionList;
	}	
}
