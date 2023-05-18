package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.Database;
import model.OptionpayModel;
import model.TransportModel;

public class OptionpayDAO {
	public ArrayList<OptionpayModel> viewOptionpay() {
		ArrayList<OptionpayModel> transportList = null;
		
		try {
			String viewSql = "SELECT * FROM optionpay";
			System.out.println("selectSql:" + viewSql);
			
			transportList = new ArrayList<OptionpayModel>();

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String optionpaynaem = rs.getString("optionpaynaem");
					OptionpayModel optionpay = new OptionpayModel(id, optionpaynaem);
					transportList.add(optionpay);
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
		return transportList;
	}	
	
	public OptionpayModel searchById(int byid) {
		OptionpayModel transportList = null;
		
		try {
			String viewSql = "SELECT * FROM optionpay WHERE id = "+byid;
			System.out.println("selectSql:" + viewSql);
			

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String optionpaynaem = rs.getString("optionpaynaem");
					transportList = new OptionpayModel(id, optionpaynaem);
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
		return transportList;
	}	
}
