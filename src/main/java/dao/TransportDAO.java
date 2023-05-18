package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.Database;
import model.ProvinceModel;
import model.TransportModel;

public class TransportDAO {
	public ArrayList<TransportModel> viewTransport() {
		ArrayList<TransportModel> transportList = null;
		
		try {
			String viewSql = "SELECT * FROM transport";
			System.out.println("selectSql:" + viewSql);
			
			transportList = new ArrayList<TransportModel>();

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String transportName = rs.getString("transportname");
					double transportprice = rs.getDouble("transportprice");
					TransportModel transport = new TransportModel(id, transportName, transportprice);
					transportList.add(transport);
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
	
	public TransportModel searchById(int byid) {
		TransportModel transportList = null;
		
		try {
			String viewSql = "SELECT * FROM transport WHERE id = "+byid;
			System.out.println("selectSql:" + viewSql);
			

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String transportName = rs.getString("transportname");
					double transportprice = rs.getDouble("transportprice");
					transportList = new TransportModel(id, transportName, transportprice);
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
