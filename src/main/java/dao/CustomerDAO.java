package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.Database;
import model.CustomerModel;




public class CustomerDAO {
	public CustomerModel searchCustomer(long cus_id) {
		System.out.println("Search Customer");
		CustomerModel cus = null;
		try {
			String searchSql = "SELECT * FROM `customer` WHERE `customer`.`id` = "+cus_id;
			System.out.println("selectSql:" + searchSql);

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(searchSql);
				if (rs.next()) {
					int idCus = rs.getInt("id");
					String firstname = rs.getString("firstname");
					String lastname = rs.getString("lastname");
					String username = rs.getString("username");
					String pass = rs.getString("password");
					String e_mail = rs.getString("e_mail");
					int role = rs.getInt("role_id");
					cus = new CustomerModel(idCus,firstname, lastname, username, e_mail, pass, role);
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
		return cus;
	}
	
	public int addCustomerGetId(CustomerModel cus) {
		System.out.println("Add Customer");
		try {
			String insertSql = "INSERT INTO `customer` (`id`, `firstname`, `e_mail`, `username`, `password`, `lastname`, `role_id`) VALUES (NULL, '"+cus.getCusName()+"', '"+cus.getCusEmail()+"', '"+cus.getCusUsername()+"', '"+cus.getCusPass()+"', '"+cus.getCusLast()+"', '"+cus.getRoleId()+"')";
			System.out.println("insertSql:" + insertSql);

			Database connDB = new Database();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insertSql, Statement.RETURN_GENERATED_KEYS);
				try (ResultSet generatedKeys = stmnt.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		                int idGroup= generatedKeys.getInt(1);
		            	stmnt.close();
		                con.close();
		                return idGroup;
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

	
	
	
	public CustomerModel loginCustomer(CustomerModel cus) {
		CustomerModel customer = null ;
		try {
			String sql = "SELECT * FROM customer WHERE username = '"+cus.getCusUsername()+"' AND password = '"+cus.getCusPass()+"'";
			Database connDB = new Database();
			Connection con = connDB.getConnection();
			ResultSet rs  = null ;
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				rs = stmnt.executeQuery(sql);
				if (rs.next()) {
					int cus_id = rs.getInt("id");
					String firstname = rs.getString("firstname");
					String lastname = rs.getString("lastname");
					String username = rs.getString("username");
					String pass = rs.getString("password");
					String e_mail = rs.getString("e_mail");
					int role = rs.getInt("role_id");
					customer = new CustomerModel(cus_id, firstname, lastname, username, e_mail, pass, role);
					
		        } 
				stmnt.close();
				con.close();
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return customer;
	}
}
