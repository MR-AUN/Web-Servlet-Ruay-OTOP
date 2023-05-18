package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.Database;
import model.AdminGoodsModel;
import model.CombinGroupModel;
import model.RecCusViewModel;
import model.ReceiptModel;


public class ReceiptDAO {
	
	public void addReceipt(ReceiptModel rec) {
		try {
			String insertSql ="INSERT INTO `recaipt` (`id`, `rec_reg`, `rec_total`, `address_id`, `optionpay_id`, `transport_id`) VALUES (NULL, CURRENT_TIMESTAMP, '"+rec.getRecTotal()+"', "+rec.getAddress().getAddressId()+", "+rec.getOptionpay().getOptionpayId()+", "+rec.getTransport().getTransportId()+")";

			Database connDB = new Database();
			Connection con = connDB.getConnection();
			System.out.println(insertSql);

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insertSql);
				stmnt.close();
				con.close();
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public int addReceiptGetId(ReceiptModel rec) {
		try {
			String insertSql ="INSERT INTO `recaipt` (`id`, `rec_reg`, `rec_total`, `address_id`, `optionpay_id`, `transport_id`) VALUES (NULL, CURRENT_TIMESTAMP, '"+rec.getRecTotal()+"', "+rec.getAddress().getAddressId()+", "+rec.getOptionpay().getOptionpayId()+", "+rec.getTransport().getTransportId()+")";

			Database connDB = new Database();
			Connection con = connDB.getConnection();
			System.out.println(insertSql);

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insertSql, Statement.RETURN_GENERATED_KEYS);
				try (ResultSet generatedKeys = stmnt.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		                int id= generatedKeys.getInt(1);
		            	stmnt.close();
		                con.close();
		                return id;
		            }
		            else {
		            	stmnt.close();
		            	con.close();
		                throw new SQLException("Creating user failed, no ID obtained.");
		            }
		        }
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	
	public ReceiptModel searchRecGetId(int rec_deId) {
		ReceiptModel rec = null;
		try {
			String searchSql = "SELECT * FROM `recaipt` WHERE id = "+rec_deId;

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(searchSql);
				if (rs.next()) {
					int rec_id = rs.getInt("id");
					String date = rs.getString("rec_reg");
					double rec_total = rs.getDouble("rec_total");
					rec = new ReceiptModel(rec_id, date, rec_total);
							
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
		return rec;
	}
//	
//	public ArrayList<RecCusViewModel> viewRecCus() {
//		ArrayList<RecCusViewModel> RecCus = null;
//		try {
//			String viewSql = "SELECT SUM(receipt.total) AS amount , customer.* ,receipt.reg ,receipt.id as rec_id "
//					+ "FROM receipt INNER JOIN customer ON receipt.cus_id = customer.id GROUP BY receipt.cus_id";
//
//			RecCus = new ArrayList<RecCusViewModel>();
//
//			Database connDB = new Database();
//			Connection con = connDB.getConnection();
//
//			Statement stmnt = null;
//			if (con != null) {
//				stmnt = con.createStatement();
//				ResultSet rs = stmnt.executeQuery(viewSql);
//				while (rs.next()) {
//					int cusId = rs.getInt("id");
//					String cusName = rs.getString("name");
//					double recgoodTotal = rs.getDouble("amount");
//					String cusListName = rs.getString("username");
//					String recDate = rs.getString("reg");
//					RecCusViewModel recCus = new RecCusViewModel(cusId, cusName, cusListName, recDate, recgoodTotal);
//					RecCus.add(recCus);
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
//		return RecCus;
//	}
}
