package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.Database;
import model.CategoriesModel;
import model.SupCategorieModel;

public class SupCategorieDAO {
	public SupCategorieModel searchSupCategorieById(int id) {
		System.out.println("View Categorie");
		SupCategorieModel cateList = null;
		
		try {
			String viewSql = "SELECT * FROM supcategories WHERE id = "+id;
			System.out.println("selectSql:" + viewSql);
			

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int supcate_id = rs.getInt("id");
					int cate_id = rs.getInt("categories_id");
					String name = rs.getString("sup_name");
					CategoriesModel caregorie = new CategoriesDAO().searchCategorieById(cate_id);
					cateList = new SupCategorieModel(supcate_id, caregorie, name);
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
	public ArrayList<SupCategorieModel> ViewSupCategorie() {
		System.out.println("View Categorie");
		ArrayList<SupCategorieModel> cateList = new ArrayList<SupCategorieModel>();
		
		try {
			String viewSql = "SELECT * FROM supcategories ";
			System.out.println("selectSql:" + viewSql);
			

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int supcate_id = rs.getInt("id");
					int cate_id = rs.getInt("categories_id");
					String name = rs.getString("sup_name");
					CategoriesModel caregorie = new CategoriesDAO().searchCategorieById(cate_id);
					SupCategorieModel cate = new SupCategorieModel(supcate_id, caregorie, name);
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
