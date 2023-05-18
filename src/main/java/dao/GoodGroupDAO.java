package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.Database;
import model.AdminGoodsModel;
import model.CategoriesModel;
import model.GoodGroupModel;

public class GoodGroupDAO {
	public ArrayList<GoodGroupModel> searchGroupByIdGoodnotGood(int id) {
		ArrayList<GoodGroupModel> groupList = new ArrayList<GoodGroupModel>();
		
		try {
			String viewSql = "SELECT * FROM goods_group WHERE good_id = "+id;
			System.out.println("selectSql:" + viewSql);
			

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int groupId = rs.getInt("id");
					String name = rs.getString("groupname");
					GoodGroupModel group = new GoodGroupModel(groupId, name);
					groupList.add(group);
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
		return groupList;
	}	
	public GoodGroupModel searchGroupByIdnotGood(int id) {
		GoodGroupModel groupList = null;
		
		try {
			String viewSql = "SELECT * FROM goods_group WHERE id = "+id;
			System.out.println("selectSql:" + viewSql);
			

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					String name = rs.getString("groupname");
					groupList = new GoodGroupModel(id, name);
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
		return groupList;
	}	
	
	public GoodGroupModel searchGroupById(int id) {
		GoodGroupModel groupList = null;
		
		try {
			String viewSql = "SELECT * FROM goods_group WHERE id = "+id;
			System.out.println("selectSql:" + viewSql);
			

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					String name = rs.getString("groupname");
					int good_id = rs.getInt("good_id");
					AdminGoodsModel good = new GoodsListDAO().searchGoodById(good_id);
					groupList = new GoodGroupModel(id, good, name);
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
		return groupList;
	}	
}
