package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.Database;
import model.ReceiptDetailModel;
import model.ReceiptGoodViewModel;

public class ReceiptDetailDAO {
	public void addReceipt(ReceiptDetailModel rec_de) {
		try {
			String insertSql = "INSERT INTO `recaipt_deatil` (`id`, `recdetail_qua`, `recdeatil_amount`, `rec_id`, `combin_group_id`) VALUES (NULL, '"+rec_de.getRecDeCount()+"', '"+rec_de.getRecDeAmount()+"', '"+rec_de.getRec().getRecId()+"', "+rec_de.getCombin().getCombinId()+")";

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
//	public ArrayList<ReceiptGoodViewModel> viewRecGood() {
//		ArrayList<ReceiptGoodViewModel> goods = null;
//		try {
//			String viewSql = "SELECT SUM(receipt_details.qua) AS total,receipt_details.id as rede_id,receipt_details.*,goods.id as good_id,goods.* FROM receipt_details"
//					+ "	INNER JOIN goods ON  receipt_details.good_id = goods.id "
//					+ "	GROUP BY receipt_details.good_id";
//
//			goods = new ArrayList<ReceiptGoodViewModel>();
//
//			Database connDB = new Database();
//			Connection con = connDB.getConnection();
//
//			Statement stmnt = null;
//			if (con != null) {
//				stmnt = con.createStatement();
//				ResultSet rs = stmnt.executeQuery(viewSql);
//				while (rs.next()) {
//					int goodId = rs.getInt("good_id");
//					int recDe = rs.getInt("rede_id");
//					int recgoodTotal = rs.getInt("total");
//					String goodNmae = rs.getString("name");
//					int goodStock = rs.getInt("Stock");
//					
////					GoodsModel good = new GoodsModel(goodId,goodNmae, goodPrice, goodDescription, goodStock);
//					ReceiptGoodViewModel recDeGood = new ReceiptGoodViewModel(recDe, goodId, recgoodTotal, goodNmae, goodStock);
//					goods.add(recDeGood);
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
//		return goods;
//	}
}
