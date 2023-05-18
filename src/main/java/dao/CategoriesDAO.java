package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import db.Database;
import model.CategoriesModel;

public class CategoriesDAO {
	public CategoriesModel searchCategorieById(int id) {
		System.out.println("View Categorie");
		CategoriesModel cateList = null;
		
		try {
			String viewSql = "SELECT * FROM categories WHERE id = "+id;
			System.out.println("selectSql:" + viewSql);
			

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int cate_id = rs.getInt("id");
					String name = rs.getString("categoriename");
					cateList = new CategoriesModel(cate_id, name);
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
		return cateList;
	}	
	
	public ArrayList<CategoriesModel> viewCategories() {
		System.out.println("View Categorie");
		ArrayList<CategoriesModel> cateList = new ArrayList<CategoriesModel>();
		
		try {
			String viewSql = "SELECT * FROM categories ";
			System.out.println("selectSql:" + viewSql);
			

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int cate_id = rs.getInt("id");
					String name = rs.getString("categoriename");
					CategoriesModel cate = new CategoriesModel(cate_id, name);
					cateList.add(cate);
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
		return cateList;
	}	
}
