package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import db.Database;
import model.ProvinceModel;

public class ProvinceDAO {
	public ProvinceModel searchProvinceById(int id) {
		System.out.println("View Province");
		ProvinceModel provinceList = null;
		
		try {
			String viewSql = "SELECT * FROM provinces WHERE PROVINCE_ID = "+id;
			System.out.println("selectSql:" + viewSql);
			

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int pro_id = rs.getInt("province_id");
					String name = rs.getString("province_name");
					String code = rs.getString("province_code");
					int geo_id = rs.getInt("geo_id");
					provinceList = new ProvinceModel(pro_id, code, name, geo_id);
					
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
		return provinceList;
	}	
	
	public ArrayList<ProvinceModel> viewProvince() {
		System.out.println("View Province");
		ArrayList<ProvinceModel> provinceList = null;
		
		try {
			String viewSql = "SELECT * FROM provinces";
			System.out.println("selectSql:" + viewSql);
			
			provinceList = new ArrayList<ProvinceModel>();

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int pro_id = rs.getInt("province_id");
					String name = rs.getString("province_name");
					String code = rs.getString("province_code");
					int geo_id = rs.getInt("geo_id");
					
					ProvinceModel province = new ProvinceModel(pro_id, code,name,geo_id);
					provinceList.add(province);
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
		return provinceList;
	}	
}
