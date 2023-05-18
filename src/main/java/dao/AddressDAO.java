package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.Database;
import model.AdminGoodsModel;
import model.CategoriesModel;
import model.CustomerModel;
import model.ProvinceModel;
import model.SupCategorieModel;
import model.addressModel;

public class AddressDAO {
	public void addAddress(addressModel address) {
		System.out.println("Add Address");
		try {
			String insertSql = "INSERT INTO `address` (`id`, `detail`, `customer_id`) VALUES (NULL, '"+address.getAddressDetail()+"', '"+address.getCustomer().getCusId()+"')";
			System.out.println("insertSql:" + insertSql);

			Database connDB = new Database();
			Connection con = connDB.getConnection();

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
	
	public ArrayList<addressModel> viewAddressByCustomer(int cus_id) {
		System.out.println("View address");
		ArrayList<addressModel> addressList = null;
		
		try {
			String viewSql = "SELECT * FROM `address` WHERE customer_id= "+cus_id+" ;";
			System.out.println("selectSql:" + viewSql);
			
			addressList = new ArrayList<addressModel>();

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String detail = rs.getString("detail");
					
					addressModel address = new addressModel(id,detail);
					addressList.add(address);
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
		return addressList;
	}	
	
	public addressModel searchAddressByid(int byid) {
		System.out.println("View address");
		addressModel addressList = null;
		
		try {
			String viewSql = "SELECT * FROM `address` WHERE id= "+byid+" ;";
			System.out.println("selectSql:" + viewSql);
			

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String detail = rs.getString("detail");
					int customer_id = rs.getInt("customer_id");
					CustomerModel cus = new CustomerDAO().searchCustomer(customer_id);
					addressList = new addressModel(id, detail,cus);
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
		return addressList;
	}	
}
